package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.AbstractFireBlock;
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
import net.minecraft.nbt.NbtList;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Laser_Beam_Entity extends ProjectileEntity {
    public double xPower;
    public double yPower;
    public double zPower;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, World worldIn) {
        super(type, worldIn);
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.refreshPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }
    }

    public Laser_Beam_Entity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, World p_36831_,float damage) {
        this(ModEntities.LASER_BEAM, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type,LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_,float damage, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.refreshPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }



    protected void initDataTracker() {
        this.dataTracker.startTracking(DAMAGE,0f);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public boolean isOnFire() {
        return false;
    }

    @Override
    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit);
            if (hitresult.getType() != HitResult.Type.MISS) {
                this.onCollision(hitresult);
            }

            this.checkBlockCollision();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 1.0F);
            float f = this.getInertia();
            this.setVelocity(vec3.add(this.xPower, this.yPower, this.zPower).multiply(f));
            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (!this.getWorld().isClient) {
            Entity entity = p_37626_.getEntity();
            LivingEntity entity1 = (LivingEntity) this.getOwner();
            int i = entity.getFireTicks();
            entity.setOnFireFor(5);
            if (!entity.damage(CMDamageTypes.causeLaserDamage(this, entity1), getDamage())) {
                entity.setFireTicks(i);
            } else if (entity1 != null) {
                this.applyDamageEffects(entity1, entity);
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
            if (!this.getWorld().isClient()) {
                this.discard();
            }
        }
    }

    protected RaycastContext.ShapeType getClipType() {
        return RaycastContext.ShapeType.COLLIDER;
    }

    public boolean canHit() {
        return false;
    }

    @Override
    protected boolean canHit(Entity entity) {
        return super.canHit(entity) && !entity.noClip;
    }

    protected float getInertia() {
        return 1.0F;
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("power", this.toNbtList(this.xPower, this.yPower, this.zPower));
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if(nbt.contains("power", 9)) {
            NbtList nbtList = nbt.getList("power", 6);
            if(nbtList.size() == 3) {
                this.xPower = nbtList.getDouble(0);
                this.yPower = nbtList.getDouble(1);
                this.zPower = nbtList.getDouble(2);
            }
        }
    }

    @Override
    public float getTargetingMargin() {
        return 1.0F;
    }

    @Override
    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new EntitySpawnS2CPacket(this.getId(), this.getUuid(), this.getX(), this.getY(), this.getZ(), this.getPitch(), this.getYaw(), this.getType(), i, new Vec3d(this.xPower, this.yPower, this.zPower), 0.0D);
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        this.prevPitch = this.getPitch();
        this.prevYaw = this.getYaw();
        double d0 = packet.getVelocityX();
        double d1 = packet.getVelocityY();
        double d2 = packet.getVelocityZ();
        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        if (d3 != 0.0D) {
            this.xPower = d0 / d3 * 0.1D;
            this.yPower = d1 / d3 * 0.1D;
            this.zPower = d2 / d3 * 0.1D;
        }
    }

    public boolean damage(DamageSource p_37616_, float p_37617_) {
        return false;
    }

}



