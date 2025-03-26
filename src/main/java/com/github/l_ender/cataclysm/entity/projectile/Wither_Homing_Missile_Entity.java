package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Wither_Homing_Missile_Entity extends ProjectileEntity {
    public double xPower;
    public double yPower;
    public double zPower;
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;


    public Wither_Homing_Missile_Entity(EntityType<? extends Wither_Homing_Missile_Entity> p_36833_, World p_36834_) {
        super(p_36833_, p_36834_);
    }

    public Wither_Homing_Missile_Entity(World worldIn, LivingEntity entity) {
        this(ModEntities.WITHER_HOMING_MISSILE, worldIn);
        this.setOwner(entity);
    }

    public Wither_Homing_Missile_Entity(EntityType<? extends Wither_Homing_Missile_Entity> p_36817_, double p_36818_, double p_36819_, double p_36820_, double p_36821_, double p_36822_, double p_36823_, World p_36824_) {
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

    public Wither_Homing_Missile_Entity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, World p_36831_, @Nullable LivingEntity finalTarget) {
        this(ModEntities.WITHER_HOMING_MISSILE, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.finalTarget = finalTarget;
        this.setRotation(p_36827_.getYaw(), p_36827_.getPitch());
    }
    public Wither_Homing_Missile_Entity(World worldIn, LivingEntity entity, @Nullable LivingEntity finalTarget) {
        this(ModEntities.WITHER_HOMING_MISSILE, worldIn);
        this.setOwner(entity);
        this.finalTarget = finalTarget;
    }

    protected void initDataTracker() {
    }

    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }



    public void writeCustomDataToNbt(NbtCompound p_37357_) {
        super.writeCustomDataToNbt(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.putUuid("Target", this.finalTarget.getUuid());
        }
        p_37357_.put("power", this.toNbtList(this.xPower, this.yPower, this.zPower));
    }

    public void readCustomDataFromNbt(NbtCompound p_37353_) {
        super.readCustomDataFromNbt(p_37353_);
        if (p_37353_.containsUuid("Target")) {
            this.targetId = p_37353_.getUuid("Target");
        }
        if (p_37353_.contains("power", 9)) {
            NbtList listtag = p_37353_.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }

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
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);
            float f = this.getInertia();
            if (this.isTouchingWater()) {
                for(int i = 0; i < 4; ++i) {
                    float f1 = 0.25F;
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
                f = 0.8F;
            }
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y + 0.15D, this.getZ() - vec3.z, 0.0D, 0.0D, 0.0D);
          //  this.level.addParticle(ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y + 0.15D, this.getZ() - vec3.z, 0.0D, 0.0D, 0.0D);
            this.setVelocity(vec3.add(this.xPower, this.yPower, this.zPower).multiply(f));
            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
        if (!this.getWorld().isClient) {
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerWorld) this.getWorld()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }

            if (this.finalTarget == null || !this.finalTarget.isAlive() || (this.finalTarget instanceof PlayerEntity && this.finalTarget.isSpectator())) {
                this.yPower = -0.175;
            } else {
                double d = this.squaredDistanceTo(finalTarget);
                double dx = finalTarget.getX() - this.getX();
                double dy = finalTarget.getY() + finalTarget.getHeight() * 1.2F - this.getY();
                double dz = finalTarget.getZ() - this.getZ();
                double d13 = 3;
                dx /= d;
                dy /= d;
                dz /= d;
                this.xPower += dx * d13;
                this.yPower += dy * d13;
                this.zPower += dz * d13;
                this.xPower = MathHelper.clamp((float) this.xPower, -0.175, 0.175);
                this.yPower = MathHelper.clamp((float) this.yPower, -0.175, 0.175);
                this.zPower = MathHelper.clamp((float) this.zPower, -0.175, 0.175);
            }
        }

    }


    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (!this.getWorld().isClient && !(p_37626_.getEntity() instanceof The_Harbinger_Entity)) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity livingentity) {
                flag = entity.damage(this.getDamageSources().mobProjectile(this, livingentity), (float) CMConfig.WitherHomingMissiledamage);
                if (flag) {
                    if (entity.isAlive()) {
                        this.applyDamageEffects(livingentity, entity);
                    } else {
                        if(entity1 instanceof The_Harbinger_Entity) {
                            livingentity.heal(5.0F * (float) CMConfig.HarbingerHealingMultiplier);
                        }else{
                            livingentity.heal(5.0F);
                        }
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), 3.0F);
            }

            if (flag && entity instanceof LivingEntity) {
                int i = 5;
                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 5 * i, 0), this.getEffectCause());
            }
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.NONE);
            this.discard();

        }
    }

    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.NONE);
            this.discard();
        }
    }

    @Override
    protected void onCollision(HitResult ray) {
        HitResult.Type raytraceresult$type = ray.getType();
        if (raytraceresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult) ray);
        } else if (raytraceresult$type == HitResult.Type.BLOCK) {
            this.onBlockHit((BlockHitResult) ray);
        }
    }

    protected boolean canHit(Entity p_36842_) {
        return super.canHit(p_36842_) && !p_36842_.noClip;
    }

    protected float getInertia() {
        return 0.6F;
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
    protected boolean shouldBurn() {
        return false;
    }
}


