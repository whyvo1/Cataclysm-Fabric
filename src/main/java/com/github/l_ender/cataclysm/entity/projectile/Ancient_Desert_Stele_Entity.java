package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.UUID;

public class Ancient_Desert_Stele_Entity extends ProjectileEntity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 70;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final TrackedData<Boolean> ACTIVATE = DataTracker.registerData(Ancient_Desert_Stele_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Ancient_Desert_Stele_Entity.class, TrackedDataHandlerRegistry.FLOAT);


    public Ancient_Desert_Stele_Entity(EntityType<? extends Ancient_Desert_Stele_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Ancient_Desert_Stele_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,float damage, LivingEntity casterIn) {
        this(ModEntities.ANCIENT_DESERT_STELE, worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(ACTIVATE, Boolean.FALSE);
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
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.containsUuid("Owner")) {
            this.casterUuid = compound.getUuid("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUuid("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();

        HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitresult.getType() != HitResult.Type.MISS) {
            this.onCollision(hitresult);
        }

        this.checkBlockCollision();

        if (this.getWorld().isClient) {
            --this.lifeTicks;

        } else if (--this.warmupDelayTicks < 0) {
            if(!this.isActivate()) {
                this.setActivate(true);
            }
            if (--this.lifeTicks < 0) {
                this.discard();
            }
        }

        Vec3d vec3 = this.getVelocity();
        double d2 = this.getX() + vec3.x;
        double d0 = this.getY() + vec3.y;
        double d1 = this.getZ() + vec3.z;
        if (this.isActivate()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.98D));
            Vec3d vec31 = this.getVelocity();
            this.setVelocity(vec31.x, vec31.y - 0.03, vec31.z);
        }
        this.setPosition(d2, d0, d1);

    }

    protected void onCollision(HitResult ray) {
        super.onCollision(ray);
        BlockState state = Blocks.SANDSTONE.getDefaultState();
        BlockSoundGroup soundtype = state.getSoundGroup();
        this.playSound(soundtype.getBreakSound(), (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
        if (!this.getWorld().isClient) {
            ((ServerWorld) this.getWorld()).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state), this.getX(), this.getY() + this.getHeight() / 2.0, this.getZ(), 64, this.getWidth() / 2.0, this.getHeight() / 2.0, this.getWidth() / 2.0, 1);
            this.discard();
        }

    }

    protected void onEntityHit(EntityHitResult p_213868_1_) {
        LivingEntity shooter = this.getCaster();
        Entity entity = p_213868_1_.getEntity();
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            boolean flag = false;
            if (shooter != null) {
                LivingEntity owner = shooter;
                if (owner != entity) {
                    if (!owner.isTeammate(entity)) {
                        DamageSource damagesource = this.getDamageSources().mobProjectile(this, owner);
                        flag = entity.damage(damagesource,  this.getDamage());

                        if (flag) {
                            EnchantmentHelper.onTargetDamaged(serverlevel, entity, damagesource);
                        }
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), this.getDamage());
            }
            if (flag && entity instanceof LivingEntity) {
                StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                ((LivingEntity) entity).addStatusEffect(effectinstance);
            }
        }

    }

    protected void onBlockHit(BlockHitResult p_230299_1_) {
    }

    public boolean isActivate() {
        return this.dataTracker.get(ACTIVATE);
    }

    public void setActivate(boolean Activate) {
        this.dataTracker.set(ACTIVATE, Activate);
    }

}
