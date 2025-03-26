package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Laser_Beam_Entity extends ProjectileEntity {
    public double accelerationPower;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);


    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, World level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, double getX, double gety, double getz, Vec3d vec3, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.refreshPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }

    public Laser_Beam_Entity(LivingEntity p_36827_, Vec3d vec3, World p_36831_, float damage) {
        this(ModEntities.LASER_BEAM, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3d vec3, float damage, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.refreshPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DAMAGE,0f);
    }


    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }


    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    protected RaycastContext.ShapeType getClipType() {
        return RaycastContext.ShapeType.COLLIDER;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS) {
                this.hitOrDeflect(hitresult);
            }

            this.checkBlockCollision();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 1.0F);
            float f = this.getInertia();
            this.setVelocity(vec3.add(vec3.normalize().multiply(this.accelerationPower)).multiply(f));
            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult p_37386_) {
        super.onEntityHit(p_37386_);
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            Entity entity1 = p_37386_.getEntity();
            Entity $$4 = this.getOwner();
            int $$5 = entity1.getFireTicks();
            entity1.setOnFireFor(5.0F);
            DamageSource $$6 = CMDamageTypes.causeLaserDamage(this, $$4);
            if (!entity1.damage($$6, getDamage())) {
                entity1.setFireTicks($$5);
            } else {
                EnchantmentHelper.onTargetDamaged(serverlevel, entity1, $$6);
            }
        }
    }


    protected void onBlockHit(BlockHitResult p_37384_) {
        super.onBlockHit(p_37384_);
        if (!this.getWorld().isClient) {
            Entity entity = this.getOwner();
            if(CMConfig.HarbingerLightFire) {
                BlockPos blockpos = p_37384_.getBlockPos().offset(p_37384_.getSide());
                if (this.getWorld().isAir(blockpos)) {
                    this.getWorld().setBlockState(blockpos, AbstractFireBlock.getState(this.getWorld(), blockpos));
                }
            } else{
                if (!(entity instanceof MobEntity) || this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    BlockPos blockpos = p_37384_.getBlockPos().offset(p_37384_.getSide());
                    if (this.getWorld().isAir(blockpos)) {
                        this.getWorld().setBlockState(blockpos, AbstractFireBlock.getState(this.getWorld(), blockpos));
                    }
                }
            }

        }
    }


    @Override
    protected void onCollision(HitResult ray) {
        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)ray);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, ray.getPos(), GameEvent.Emitter.of(this, null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onBlockHit(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockpos)));
            if (!this.getWorld().isClient) {
                this.discard();
            }
        }
    }


    protected boolean canHit(Entity p_36842_) {
        return super.canHit(p_36842_) && !p_36842_.noClip;
    }


    protected float getInertia() {
        return 1.0F;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }

    }


    public boolean canHit() {
        return false;
    }

    public float getTargetingMargin() {
        return 1.0F;
    }

    public boolean damage(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry p_entity) {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        Vec3d vec3 = p_entity.getPos();
        return new EntitySpawnS2CPacket(this.getId(), this.getUuid(), vec3.getX(), vec3.getY(), vec3.getZ(), p_entity.getPitch(), p_entity.getYaw(), this.getType(), i, p_entity.getVelocity(), 0.0F);
    }


    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        this.prevPitch = this.getPitch();
        this.prevYaw = this.getYaw();

    }

    private void assignDirectionalMovement(Vec3d movement, double accelerationPower) {
        this.setVelocity(movement.normalize().multiply(accelerationPower));
        this.velocityDirty = true;
    }

    protected void onDeflected(@Nullable Entity entity, boolean deflectedByPlayer) {
        super.onDeflected(entity, deflectedByPlayer);
        if (deflectedByPlayer) {
            this.accelerationPower = 0.1;
        } else {
            this.accelerationPower *= 0.5F;
        }

    }
}


