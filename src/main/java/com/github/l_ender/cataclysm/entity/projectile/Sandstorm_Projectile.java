package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.particle.StormParticle;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
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
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Sandstorm_Projectile extends ProjectileEntity {
    public double xPower;
    public double yPower;
    public double zPower;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Sandstorm_Projectile.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> STATE = DataTracker.registerData(Sandstorm_Projectile.class, TrackedDataHandlerRegistry.INTEGER);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    private int lifetick;
    private int discardtick;

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, World level) {
        super(type, level);
    }

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, World level) {
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

    public Sandstorm_Projectile(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, World p_36831_, float damage) {
        this(ModEntities.SANDSTORM_PROJECTILE, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setRotation(p_36827_.getYaw(), p_36827_.getPitch());
    }

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, World level) {
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
        this.dataTracker.startTracking(STATE,0);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "spawn" -> this.SpawnAnimationState;
            case "despawn" -> this.DespawnAnimationState;
            default -> new AnimationState();
        };
//        if (input == "spawn") {
//            return this.SpawnAnimationState;
//        } else if (input == "despawn") {
//            return this.DespawnAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            if (this.getWorld().isClient)
                switch (this.getState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    stopAllAnimationStates();
                    this.SpawnAnimationState.startIfNotRunning(this.age);
                }
                case 2 -> {
                    stopAllAnimationStates();
                    this.DespawnAnimationState.startIfNotRunning(this.age);
                }
            }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return dataTracker.get(STATE);
    }

    public void setState(int state) {
        dataTracker.set(STATE, state);
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

    public void tick() {
        Entity entity = this.getOwner();

        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();
            lifetick++;
            HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit);
            if (hitresult.getType() != HitResult.Type.MISS) {
                this.onCollision(hitresult);
            }
            if(this.getState() == 1) {
                if (this.lifetick > 5) {
                    this.setState(0);
                }
            }
            if(lifetick > 290){
                if(this.getState() == 0) {
                    this.setState(2);
                }
            }

            if(this.getState() == 2){
                discardtick++;
                if(discardtick > 10){
                    this.discard();
                }
            }

            this.checkBlockCollision();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);
            float f = this.getInertia();

            float ran = 0.04f;
            float r = 0.89F + random.nextFloat() * ran;
            float g = 0.85f + random.nextFloat() * ran;
            float b = 0.69f + random.nextFloat() * ran * 1.5F;
            this.getWorld().addParticle((new StormParticle.OrbData(r, g, b,0.25f + random.nextFloat() * 0.45f,0.35F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            //this.level().addParticle((new StormParticle.OrbData(r, g, b,2.0f + random.nextFloat() * 0.45f,2.0f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            // this.level().addParticle((new StormParticle.OrbData(r, g, b,1.75f + random.nextFloat() * 0.45f,1.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);

            if (!this.isSilent()) {
                Cataclysm.PROXY.playWorldSound(this, (byte) 2);
            }
            this.setVelocity(vec3.add(this.xPower, this.yPower, this.zPower).multiply((double)f));
            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
    }


    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (!this.getWorld().isClient) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag = false;
            if (entity1 instanceof LivingEntity) {
                if (!(entity.getType().isIn(ModTag.TEAM_ANCIENT_REMNANT) && entity1.getType().isIn(ModTag.TEAM_ANCIENT_REMNANT))) {
                    LivingEntity livingentity = (LivingEntity) entity1;
                    flag = entity.damage(this.getDamageSources().mobProjectile(this, livingentity), this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            this.applyDamageEffects(livingentity, entity);
                        }
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), this.getDamage());
            }

            if (flag && entity instanceof LivingEntity) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 100, 1), this.getEffectCause());
            }
            this.setState(2);

        }
    }

    protected void onCollision(HitResult ray) {

        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)ray);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, ray.getPos(), GameEvent.Emitter.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onBlockHit(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockpos)));
        }

    }

    protected boolean canHit(Entity p_36842_) {
        return super.canHit(p_36842_) && !p_36842_.noClip;
    }

    protected float getInertia() {
        return 0.9F;
    }

    public void writeCustomDataToNbt(NbtCompound p_36848_) {
        super.writeCustomDataToNbt(p_36848_);
        p_36848_.put("power", this.toNbtList(new double[]{this.xPower, this.yPower, this.zPower}));
        p_36848_.putInt("state", this.getState());
        p_36848_.putFloat("damage", this.getDamage());
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
        this.setState(p_36844_.getInt("state"));
        this.setDamage(p_36844_.getFloat("damage"));
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
}


