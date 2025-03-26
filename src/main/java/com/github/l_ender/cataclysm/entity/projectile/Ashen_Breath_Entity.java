package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import java.util.List;
import java.util.UUID;

public class Ashen_Breath_Entity extends Entity {
    private static final int RANGE = 7;
    private static final int ARC = 45;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Ashen_Breath_Entity.class, TrackedDataHandlerRegistry.FLOAT);


    public Ashen_Breath_Entity(EntityType<? extends Ashen_Breath_Entity> type, World world) {
        super(type, world);

    }


    public Ashen_Breath_Entity(EntityType<? extends Ashen_Breath_Entity> type, World world,float damage,LivingEntity caster) {
        super(type, world);
        this.setCaster(caster);
        this.setDamage(damage);

    }

    @Override
    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    @Override
    public void tick() {
        super.tick();

        if (caster != null && !caster.isAlive()) this.discard();

        if (caster !=null){
            this.setYaw(caster.headYaw);
           // this.setXRot(caster.getXRot());
        }
        float yaw = (float) Math.toRadians(-getYaw());
        float pitch = (float) Math.toRadians(-getPitch());
        float spread = 0.25f;
        float speed = 0.56f;
        float xComp = (float) (Math.sin(yaw) * Math.cos(pitch));
        float yComp = (float) (Math.sin(pitch));
        float zComp = (float) (Math.cos(yaw) * Math.cos(pitch));
        double theta = (getYaw()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double vec = 0.9;
        if (getWorld().isClient) {
            for (int i = 0; i < 80; i++) {
                double xSpeed = speed * xComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - xComp * xComp)));
                double ySpeed = speed * yComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - yComp * yComp)));
                double zSpeed = speed * zComp + (spread * 1 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - zComp * zComp)));
                getWorld().addParticle(ParticleTypes.SMOKE, getX() + vec * vecX, getY(), getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
            }
            for (int i = 0; i < 2; i++) {
                double xSpeed = speed * xComp + (spread * 0.7 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - xComp * xComp)));
                double ySpeed = speed * yComp + (spread * 0.7 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - yComp * yComp)));
                double zSpeed = speed * zComp + (spread * 0.7 * (random.nextFloat() * 2 - 1) * (Math.sqrt(1 - zComp * zComp)));
                getWorld().addParticle(ParticleTypes.FLAME, getX() + vec * vecX, getY(), getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
            }
        }
        if (age > 2 && caster != null) {
            hitEntities();
        }
        if (age > 25) discard() ;
    }

    public void hitEntities() {
        List<LivingEntity> entitiesHit = getEntityLivingBaseNearby(RANGE, RANGE, RANGE, RANGE);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitYaw = (float) ((Math.atan2(entityHit.getZ() - getZ(), entityHit.getX() - getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingYaw = getYaw() % 360;
            if (entityHitYaw < 0) {
                entityHitYaw += 360;
            }
            if (entityAttackingYaw < 0) {
                entityAttackingYaw += 360;
            }
            float entityRelativeYaw = entityHitYaw - entityAttackingYaw;

            float xzDistance = (float) Math.sqrt((entityHit.getZ() - getZ()) * (entityHit.getZ() - getZ()) + (entityHit.getX() - getX()) * (entityHit.getX() - getX()));
            double hitY = entityHit.getY() + entityHit.getHeight() / 2.0;
            float entityHitPitch = (float) ((Math.atan2((hitY - getY()), xzDistance) * (180 / Math.PI)) % 360);
            float entityAttackingPitch = -getPitch() % 360;
            if (entityHitPitch < 0) {
                entityHitPitch += 360;
            }
            if (entityAttackingPitch < 0) {
                entityAttackingPitch += 360;
            }
            float entityRelativePitch = entityHitPitch - entityAttackingPitch;

            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - getZ()) * (entityHit.getZ() - getZ()) + (entityHit.getX() - getX()) * (entityHit.getX() - getX()) + (hitY - getY()) * (hitY - getY()));
            int distance = this.age / 2 ;
            boolean inRange = entityHitDistance <= distance + 1.0F;
            boolean yawCheck = (entityRelativeYaw <= ARC / 2f && entityRelativeYaw >= -ARC / 2f) || (entityRelativeYaw >= 360 - ARC / 2f || entityRelativeYaw <= -360 + ARC / 2f);
            boolean pitchCheck = (entityRelativePitch <= ARC / 2f && entityRelativePitch >= -ARC / 2f) || (entityRelativePitch >= 360 - ARC / 2f || entityRelativePitch <= -360 + ARC / 2f);
            boolean CloseCheck = caster instanceof Ignited_Revenant_Entity && entityHitDistance <= 2;
            if (inRange && yawCheck && pitchCheck || CloseCheck) {
                if (this.age % 3 == 0) {
                    if (!isTeammate(entityHit) && entityHit != caster) {
                        boolean flag = entityHit.damage(this.getDamageSources().indirectMagic(this, caster), this.getDamage());
                        if (flag) {
                            //entityHit.setDeltaMovement(entityHit.getVelocity().multiply(0.25, 1, 0.25));
                            StatusEffectInstance effectinstance = new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 0, false, false, true);
                            entityHit.addStatusEffect(effectinstance);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DAMAGE, 0F);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUuid();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readCustomDataFromNbt(NbtCompound compound) {
        if (compound.containsUuid("Owner")) {
            this.casterUuid = compound.getUuid("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        if (this.casterUuid != null) {
            compound.putUuid("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }


    @Override
    public boolean canHit() {
        return false;
    }

    @Override
    public void pushAwayFrom(Entity entityIn) {
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    public  List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return getWorld().getEntitiesByClass(entityClass, getBoundingBox().expand(dX, dY, dZ), e -> e != this && distanceTo(e) <= r + e.getWidth() / 2f && e.getY() <= getY() + dY);
    }

    @Override
    public boolean isPushable() {
        return false;
    }


}