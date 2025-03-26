package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Ignis_Abyss_Fireball_Entity extends CMAbstractHurtingProjectile {
    private static final TrackedData<Integer> BOUNCES = DataTracker.registerData(Ignis_Abyss_Fireball_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> FIRED = DataTracker.registerData(Ignis_Abyss_Fireball_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int timer;

    public Ignis_Abyss_Fireball_Entity(EntityType<? extends Ignis_Abyss_Fireball_Entity> type, World level) {
        super(type, level);
    }

    public Ignis_Abyss_Fireball_Entity(World level, LivingEntity entity, double x, double y, double z) {
        super(ModEntities.IGNIS_ABYSS_FIREBALL, entity, x, y, z, level);
    }

    public Ignis_Abyss_Fireball_Entity(World worldIn, LivingEntity entity) {
        this(ModEntities.IGNIS_ABYSS_FIREBALL, worldIn);
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
            if(this.getTotalBounces() == 0) {
                Entity entity = this.getOwner();
                if (entity instanceof MobEntity && ((MobEntity) entity).getTarget() != null) {
                    LivingEntity target = ((MobEntity) entity).getTarget();
                    if(target == null){
                        this.discard();
                    }

                    float speed =  0.2F;

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
                if (entity instanceof LivingEntity) {
                    flag = entity.damage(getDamageSources().mobProjectile(this, owner), 10.0F + ((LivingEntity) entity).getMaxHealth() * 0.2f);
                }else{
                    flag = entity.damage(getDamageSources().mobProjectile(this, owner), 10.0F);
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
        BlockHitResult traceResult = result;
        BlockState blockstate = this.getWorld().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape(this.getWorld(), traceResult.getBlockPos()).isEmpty() && getFired()) {
            Direction face = traceResult.getSide();
            blockstate.onProjectileHit(this.getWorld(), blockstate, traceResult, this);

            Vec3d motion = this.getVelocity();

            double motionX = motion.getX();
            double motionY = motion.getY();
            double motionZ = motion.getZ();

            if (face == Direction.EAST)
                motionX = -motionX;
            else if (face == Direction.SOUTH)
                motionZ = -motionZ;
            else if (face == Direction.WEST)
                motionX = -motionX;
            else if (face == Direction.NORTH)
                motionZ = -motionZ;
            else if (face == Direction.UP)
                motionY = -motionY;
            else if (face == Direction.DOWN)
                motionY = -motionY;

            this.setVelocity(motionX, motionY, motionZ);
            this.xPower = motionX * 0.05D;
            this.yPower = motionY * 0.05D;
            this.zPower = motionZ * 0.05D;

            if (this.age > 500 || this.getTotalBounces() > 5) {
                if (!this.getWorld().isClient) {
                    this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, true, World.ExplosionSourceType.NONE);
                    this.discard();
                }
            } else {
                this.setTotalBounces(this.getTotalBounces() + 1);
            }
        }

    }

    @Override
    protected void onCollision(HitResult ray) {
        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)ray);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, ray.getPos(), GameEvent.Emitter.of(this, null));
            if (!this.getWorld().isClient) {
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.MOB);
                this.discard();
            }
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onBlockHit(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockpos)));
        }
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(BOUNCES, 0);
        p_326229_.add(FIRED, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("totalBounces", this.getTotalBounces());
        compound.putInt("timer", timer);
        compound.putBoolean("fired", getFired());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setTotalBounces(compound.getInt("totalBounces"));
        timer = compound.getInt("timer");
        this.setFired(compound.getBoolean("fired"));
    }

    public int getTotalBounces()
    {
        return this.dataTracker.get(BOUNCES);
    }

    public void setTotalBounces(int bounces)
    {
        this.dataTracker.set(BOUNCES, bounces);
    }

    public void setFired(boolean fired) {
        this.dataTracker.set(FIRED, fired);
    }

    public boolean getFired() {
        return this.dataTracker.get(FIRED);
    }

    public boolean canHit() {
        return true;
    }

    public float getTargetingMargin() {
        return 1.0F;
    }

    @Override
    public boolean damage(DamageSource p_36839_, float p_36840_) {
        if (this.isInvulnerableTo(p_36839_)) {
            return false;
        } else {
            this.scheduleVelocityUpdate();
            Entity entity = p_36839_.getAttacker();
            if (entity != null && this.getFired()) {
                if (!this.getWorld().isClient) {
                    Vec3d vec3 = entity.getRotationVector();
                    this.setVelocity(vec3);
                    this.xPower = vec3.x * 0.1D;
                    this.yPower = vec3.y * 0.1D;
                    this.zPower = vec3.z * 0.1D;
                    this.setOwner(entity);
                }

                return true;
            } else {
                return false;
            }
        }
    }
}


