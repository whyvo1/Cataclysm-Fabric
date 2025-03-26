package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Ignis_Fireball_Entity extends CMAbstractHurtingProjectile {
    private static final TrackedData<Boolean> SOUL = DataTracker.registerData(Ignis_Fireball_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> FIRED = DataTracker.registerData(Ignis_Fireball_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int timer;


    public Ignis_Fireball_Entity(EntityType<? extends Ignis_Fireball_Entity> type, World level) {
        super(type, level);
    }

    public Ignis_Fireball_Entity(World level, LivingEntity entity, double x, double y, double z) {
        super(ModEntities.IGNIS_FIREBALL, entity, x, y, z, level);
    }

    public Ignis_Fireball_Entity(World worldIn, LivingEntity entity) {
        this(ModEntities.IGNIS_FIREBALL, worldIn);
        this.setOwner(entity);
    }

    public boolean isOnFire() {
        return false;
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            timer--;
            if (timer <= 0) {
                if (!getFired()){
                    setFired(true);
                }
            }
        }
        if(timer < -160){
            this.discard();
        }
        if (timer == 0 || timer == -40) {
            Entity entity = this.getOwner();
            if (entity instanceof MobEntity && ((MobEntity) entity).getTarget() != null) {
                LivingEntity target = ((MobEntity) entity).getTarget();
                if(target == null){
                    this.discard();
                }

                float speed = this.isSoul() ? 0.25F : 0.2F;

                double dx = target.getX() - this.getX();
                double dy = target.getY() + target.getHeight() * 0.5F - this.getY();
                double dz = target.getZ() - this.getZ();

                double d = Math.sqrt(dx * dx + dy * dy + dz * dz);

                dx /= d;
                dy /= d;
                dz /= d;
                this.xPower = dx * speed;
                this.yPower = dy * speed;
                this.zPower = dz * speed;
            }
        }
    }

    public void setUp(int delay) {
        setFired(false);
        timer = delay;

    }

    @Override
    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        Entity entity = p_37626_.getEntity();
        Entity shooter = this.getOwner();

        if (this.getWorld() instanceof ServerWorld serverlevel && getFired() && !(entity instanceof Ignis_Fireball_Entity || entity instanceof Ignis_Abyss_Fireball_Entity || entity instanceof Cm_Falling_Block_Entity || entity instanceof Ignis_Entity && shooter instanceof Ignis_Entity)) {
            boolean flag;
            if (shooter instanceof LivingEntity owner) {
                DamageSource damagesource = this.getDamageSources().mobProjectile(this, owner);
                float damage = this.isSoul() ? 8.0F : 6.0F;
                if (entity instanceof LivingEntity) {
                    flag = entity.damage(getDamageSources().mobProjectile(this, owner), damage + ((LivingEntity) entity).getMaxHealth() * 0.07f);
                }else{
                    flag = entity.damage(getDamageSources().mobProjectile(this, owner), damage);
                }

                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.onTargetDamaged(serverlevel, entity, damagesource);
                    }
                    if(owner instanceof Ignis_Entity) {
                        owner.heal(5.0F * (float) CMConfig.IgnisHealingMultiplier);
                    }else{
                        owner.heal(5.0F);
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), 5.0F);
            }
            if (flag && entity instanceof LivingEntity) {
                StatusEffectInstance effectinstance1 = ((LivingEntity)entity).getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                int i = 2;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    ((LivingEntity)entity).removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                } else {
                    --i;
                }

                i = MathHelper.clamp(i, 0, 4);
                StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                ((LivingEntity)entity).addStatusEffect(effectinstance);

            }
        }
    }


    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (!this.getWorld().isClient && getFired()) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, true, World.ExplosionSourceType.NONE);
            this.discard();
        }
    }

    @Override
    protected void onCollision(HitResult result) {
        HitResult.Type hitresult$type = result.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            EntityHitResult entityhitresult = (EntityHitResult)result;
            Entity entity = entityhitresult.getEntity();
            if (entity.getType().isIn(EntityTypeTags.REDIRECTABLE_PROJECTILE) && entity instanceof ProjectileEntity) {
                ProjectileEntity projectile = (ProjectileEntity)entity;
                projectile.deflect(ProjectileDeflection.REDIRECTED, this.getOwner(), this.getOwner(), true);
            }

            this.onEntityHit(entityhitresult);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, result.getPos(), GameEvent.Emitter.of(this, null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)result;
            this.onBlockHit(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockpos)));
        }

    }


    public boolean canHit() {
        return false;
    }

    public boolean damage(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(SOUL, false);
        p_326229_.add(FIRED, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("is_soul", isSoul());
        compound.putInt("timer", timer);
        compound.putBoolean("fired", getFired());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        setSoul(compound.getBoolean("is_soul"));
        timer = compound.getInt("timer");
        this.setFired(compound.getBoolean("fired"));
    }

    public boolean isSoul() {
        return this.dataTracker.get(SOUL);
    }

    public void setSoul(boolean IsSoul) {
        this.dataTracker.set(SOUL, IsSoul);
    }

    public void setFired(boolean fired) {
        this.dataTracker.set(FIRED, fired);
    }

    public boolean getFired() {
        return this.dataTracker.get(FIRED);
    }

}


