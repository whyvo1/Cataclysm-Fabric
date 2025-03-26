package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModParticle;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Axe_Blade_Entity extends Entity {
    public double xPower;
    public double yPower;
    public double zPower;
    private LivingEntity caster;
    private UUID casterUuid;
    private boolean leftOwner;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Axe_Blade_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> TRANSPARENCY  = DataTracker.registerData(Axe_Blade_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    public int lifetick = 0;
    public AnimationState idleAnimationState = new AnimationState();
    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, World level) {
        super(type, level);
    }

    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, World level,float Yrot) {
        this(type, level);
        this.setPos(getX, gety, getz);
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public Axe_Blade_Entity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, World p_36831_, float damage,float Yrot) {
        this(ModEntities.AXE_BLADE, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_,Yrot);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setYaw(Yrot);
    }

    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, World level) {
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
        this.dataTracker.startTracking(TRANSPARENCY, 0);
    }

    public void setOwner(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUuid();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.caster == null && this.casterUuid != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public int getTransparency() {
        return this.dataTracker.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.dataTracker.set(TRANSPARENCY, trans);
    }


    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    public void tick() {
        super.tick();
        if (!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }
        if (!this.getWorld().isClient) {
            lifetick++;
            setTransparency(this.lifetick);
            if (this.lifetick >= 80) {
                this.discard();
            }
        }else{
            this.idleAnimationState.setRunning(true, this.age);
        }

        HitResult raytraceresult = ProjectileUtil.getCollision(this, this::canHitEntity);
        if (raytraceresult.getType() != HitResult.Type.MISS) {
            this.onHit(raytraceresult);
        }


        this.checkBlockCollision();
        Vec3d vec3 = this.getVelocity();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        float f = this.getInertia();
        this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0D, 0.0D, 0.0D);
        this.setVelocity(vec3.add(this.xPower, this.yPower, this.zPower).multiply((double)f));
        this.setPosition(d0, d1, d2);

    }


    protected void onHitEntity(EntityHitResult p_37626_) {

        if (!this.getWorld().isClient) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            if (entity1 instanceof LivingEntity livingentity) {
                entity.damage(this.getDamageSources().mobProjectile(this, livingentity), this.getDamage());

                if (entity1 instanceof LivingEntity) {
                    this.applyDamageEffects((LivingEntity) entity1, entity);
                }
            }

        }
    }

    protected void onHitBlock(BlockHitResult result) {

    }

    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)p_37260_);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, p_37260_.getPos(), GameEvent.Emitter.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return canHit(p_36842_) && !p_36842_.noClip;
    }


    protected boolean canHit(Entity p_37250_) {
        if (!p_37250_.canBeHitByProjectile()) {
            return false;
        } else {
            Entity entity = this.getOwner();
            return entity == null || this.leftOwner || !entity.isConnectedThroughVehicle(p_37250_);
        }
    }



    protected float getInertia() {
        return 0.85F;
    }

    protected void readCustomDataFromNbt(NbtCompound compound) {
        if (compound.containsUuid("Owner")) {
            this.casterUuid = compound.getUuid("Owner");
        }
        if (compound.contains("power", 9)) {
            NbtList listtag = compound.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        if (this.casterUuid != null) {
            compound.putUuid("Owner", this.casterUuid);
        }
        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
        compound.put("power", this.toNbtList(new double[]{this.xPower, this.yPower, this.zPower}));

    }
    private boolean checkLeftOwner() {
        Entity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.getWorld().getOtherEntities(this, this.getBoundingBox().stretch(this.getVelocity()).expand(1.0D), (p_234613_0_) -> {
                return !p_234613_0_.isSpectator() && p_234613_0_.canHit();
            })) {
                if (entity1.getRootVehicle() == entity.getRootVehicle()) {
                    return false;
                }
            }
        }

        return true;
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

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new EntitySpawnS2CPacket(this.getId(), this.getUuid(), this.getX(), this.getY(), this.getZ(), this.getPitch(), this.getYaw(), this.getType(), i, new Vec3d(this.xPower, this.yPower, this.zPower), 0.0D);
    }

    public void onSpawnPacket(EntitySpawnS2CPacket p_150128_) {
        super.onSpawnPacket(p_150128_);
    }
}


