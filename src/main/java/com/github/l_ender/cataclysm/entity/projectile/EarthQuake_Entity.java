package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;



public class EarthQuake_Entity extends ThrownEntity {
    private int lifeTime = 60;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(EarthQuake_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public EarthQuake_Entity(EntityType<? extends EarthQuake_Entity> type, World worldIn) {
        super(type, worldIn);
    }

    public EarthQuake_Entity(World worldIn, double x, double y, double z) {
        this(ModEntities.EARTHQUAKE, worldIn);
        this.setPosition(x, y + 1.5, z);
    }

    public EarthQuake_Entity(World worldIn, LivingEntity throwerIn) {
        this(ModEntities.EARTHQUAKE, worldIn);
        this.setOwner(throwerIn);
        this.setVelocity(0.1D, 0D, 0.1D);
    }


    @Override
    public void setVelocity(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        Vec3d vector3d = (new Vec3d(pX, pY, pZ)).normalize().add(this.random.nextGaussian() * (double) 0.0075F * (double) pInaccuracy, this.random.nextGaussian() * (double) 0.0075F * (double) pInaccuracy, this.random.nextGaussian()
                * (double) 0.0075F * (double) pInaccuracy).multiply(pVelocity);
        this.setVelocity(vector3d);
        double d0 = vector3d.horizontalLength();
        this.setYaw((float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI)));
        this.setPitch((float)(MathHelper.atan2(vector3d.y, d0) * (double)(180F / (float)Math.PI)));
        this.prevYaw = this.getYaw();
        this.prevPitch = this.getPitch();
    }

    @Override
    public void setVelocity(Entity pShooter, float pX, float pY, float pZ, float pVelocity, float pInaccuracy) {
        float f = -MathHelper.sin(pY * ((float) Math.PI / 180F)) * MathHelper.cos(pX * ((float) Math.PI / 180F));
        float f1 = -1.0F;// -MathHelper.sin((pX + pZ) * ((float)Math.PI / 180F));
        float f2 = MathHelper.cos(pY * ((float) Math.PI / 180F)) * MathHelper.cos(pX * ((float) Math.PI / 180F));
        this.setVelocity(f, f1, f2, pVelocity, pInaccuracy);
        Vec3d vector3d = pShooter.getVelocity();
        this.setVelocity(this.getVelocity().add(vector3d.x, pShooter.isOnGround() ? 0.0D : vector3d.y, vector3d.z));
    }

    @Override
    public boolean collidesWith(Entity pEntity) {
        return this.canHit(pEntity);
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void tick() {
        if (this.getOwner() != null && !this.getOwner().isAlive()) {
            this.discard();
        } else {

            // this.updateMovement();
            this.move(MovementType.SELF, this.getVelocity());
            this.onUpdateInAir();
        }
        super.tick();
    }

    @Override
    protected boolean canHit(Entity pTarget) {
        return super.canHit(pTarget) && pTarget != this.getOwner();
    }

    public boolean isOnFire() {
        return false;
    }

    private void onUpdateInAir() {
        this.lifeTime -= 1;

        if (this.lifeTime <= 0) {
            this.discard();
        }
        BlockPos pos =  BlockPos.ofFloored(this.getX(), this.getY() - 1, this.getZ());
        BlockState iblockstate = this.getWorld().getBlockState(pos);
        Entity entity1 = this.getOwner();
        LivingEntity livingonwer = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
        for (LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.5,0.5,0.5))) {
            if (this.getOwner() != null) {
                if (this.age % 5 == 0) {
                    if (livingentity != this.getOwner() && livingentity.isOnGround() && !this.getOwner().isTeammate(livingentity) && livingentity.isAlive()) {
                        if(livingentity.damage(getDamageSources().mobProjectile(this, livingonwer), this.getDamage())) {
                            this.strongKnockback(livingentity, 0.5);
                        }


                    }
                }
            }
        }

        if (this.getWorld().isClient) {
            for (int i = 0; i < 3; i++) {
                this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, iblockstate), this.getX() + this.random.nextFloat() - 0.5D, this.getY() + this.random.nextFloat() - 0.5D, this.getZ() + this.random.nextFloat()
                        - 0.5D, 4.0D * ((double) this.random.nextFloat() - 0.5D), (double) this.random.nextFloat() * 5 + 0.5D,
                        ((double) this.random.nextFloat() - 0.5D) * 4.0D);
            }
        }
    }

    private void strongKnockback(Entity p_33340_, double modifier) {
        double d0 = (p_33340_.getX() - this.getX());
        double d1 = (p_33340_.getZ() - this.getZ());
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D) * 2;
        p_33340_.addVelocity(d0 * modifier / d2, 0.5D * modifier, d1 * modifier / d2);
    }


    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DAMAGE,0f);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

}
