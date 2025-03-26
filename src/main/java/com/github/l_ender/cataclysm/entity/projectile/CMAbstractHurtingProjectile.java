package com.github.l_ender.cataclysm.entity.projectile;

import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public abstract class CMAbstractHurtingProjectile extends ProjectileEntity {
    public double xPower;
    public double yPower;
    public double zPower;


    protected CMAbstractHurtingProjectile(EntityType<? extends CMAbstractHurtingProjectile> p_36833_, World p_36834_) {
        super(p_36833_, p_36834_);
    }

    public CMAbstractHurtingProjectile(EntityType<? extends CMAbstractHurtingProjectile> p_36817_, double p_36818_, double p_36819_, double p_36820_, double p_36821_, double p_36822_, double p_36823_, World p_36824_) {
        this(p_36817_, p_36824_);
        this.refreshPositionAndAngles(p_36818_, p_36819_, p_36820_, this.getYaw(), this.getPitch());
        this.refreshPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public CMAbstractHurtingProjectile(EntityType<? extends CMAbstractHurtingProjectile> p_36826_, LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, World p_36831_) {
        this(p_36826_, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.setRotation(p_36827_.getYaw(), p_36827_.getPitch());
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326181_) {
    }

    @Override
    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return p_36837_ < d0 * d0;
    }

    protected RaycastContext.ShapeType getClipType() {
        return RaycastContext.ShapeType.COLLIDER;
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();
            if (this.shouldBurn()) {
                this.setOnFireFor(1.0F);
            }

            HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS) {
                this.hitOrDeflect(hitresult);
            }

            this.checkBlockCollision();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);
            float f;
            if (this.isTouchingWater()) {
                for (int i = 0; i < 4; i++) {
                    float f1 = 0.25F;
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25, d1 - vec3.y * 0.25, d2 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }

                f = this.getLiquidInertia();
            } else {
                f = this.getInertia();
            }

            this.setVelocity(vec3.add(this.xPower, this.yPower, this.zPower).multiply(f));
            ParticleEffect particleoptions = this.getTrailParticle();
            if (particleoptions != null) {
                this.getWorld().addParticle(particleoptions, d0, d1 + 0.5, d2, 0.0, 0.0, 0.0);
            }

            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    public boolean damage(DamageSource p_341896_, float p_341906_) {
        return !this.isInvulnerableTo(p_341896_);
    }

    @Override
    protected boolean canHit(Entity p_36842_) {
        return super.canHit(p_36842_) && !p_36842_.noClip;
    }

    protected boolean shouldBurn() {
        return true;
    }

    @Nullable
    protected ParticleEffect getTrailParticle() {
        return ParticleTypes.SMOKE;
    }

    protected float getInertia() {
        return 0.95F;
    }

    protected float getLiquidInertia() {
        return 0.8F;
    }

    public void writeCustomDataToNbt(NbtCompound p_36848_) {
        super.writeCustomDataToNbt(p_36848_);
        p_36848_.put("power", this.toNbtList(this.xPower, this.yPower, this.zPower));
    }

    public void readCustomDataFromNbt(NbtCompound p_36844_) {
        super.readCustomDataFromNbt(p_36844_);
        if (p_36844_.contains("power", 9)) {
            NbtList listtag = p_36844_.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }

    }

    @Override
    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry p_352396_) {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        Vec3d vec3 = p_352396_.getPos();
        return new EntitySpawnS2CPacket(this.getId(), this.getUuid(),  vec3.getX(),  vec3.getY(),  vec3.getZ(), p_352396_.getPitch(),  p_352396_.getYaw(), this.getType(), i, new Vec3d(this.xPower, this.yPower, this.zPower), 0.0D);
    }

    public void onSpawnPacket(EntitySpawnS2CPacket p_150128_) {
        super.onSpawnPacket(p_150128_);
        double d0 = p_150128_.getVelocityX();
        double d1 = p_150128_.getVelocityY();
        double d2 = p_150128_.getVelocityZ();
        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        if (d3 != 0.0D) {
            this.xPower = d0 / d3 * 0.1D;
            this.yPower = d1 / d3 * 0.1D;
            this.zPower = d2 / d3 * 0.1D;
        }

    }


    @Override
    protected void onDeflected(@Nullable Entity p_341940_, boolean p_341895_) {
        super.onDeflected(p_341940_, p_341895_);
        if (p_341895_) {
            if (p_341940_ != null) {
                if (!this.getWorld().isClient) {
                    Vec3d vec3 = p_341940_.getRotationVector();
                    this.setVelocity(vec3);
                    this.xPower = vec3.x * 0.1D;
                    this.yPower = vec3.y * 0.1D;
                    this.zPower = vec3.z * 0.1D;
                }
            } else {
                this.xPower *= 0.5D;
                this.yPower *= 0.5D;
                this.zPower *= 0.5D;
            }
        }
    }
}