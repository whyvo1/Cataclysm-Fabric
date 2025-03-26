package com.github.l_ender.cataclysm.entity.effect;

import com.github.l_ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Ancient_Remnant_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Sandstorm_Entity extends Entity {

    protected static final TrackedData<Integer> LIFESPAN = DataTracker.registerData(Sandstorm_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Float> OFFSET = DataTracker.registerData(Sandstorm_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> CASTER = DataTracker.registerData(Sandstorm_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final TrackedData<Integer> STATE = DataTracker.registerData(Sandstorm_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    @Nullable
    private LivingEntity owner;

    public Sandstorm_Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Sandstorm_Entity(World worldIn, double x, double y, double z, int lifespan, float offset, LivingEntity casterIn) {
        this(ModEntities.SANDSTORM, worldIn);
        this.setOwner(casterIn);
        this.setLifespan(lifespan);
        this.setPosition(x, y, z);
        this.setState(1);
        this.setOffset(offset);
        if (!worldIn.isClient) {
            this.setCasterID(casterIn.getId());
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entity) {
        return new EntitySpawnS2CPacket(this,entity);
    }

    public void tick() {
        super.tick();
        updateMotion();
        Entity owner = getOwner();
        if (owner != null && !owner.isAlive()) discard();
        if(getWorld().isClient) {
            float ran = 0.04f;
            float r = 0.89F + random.nextFloat() * ran;
            float g = 0.85f + random.nextFloat() * ran;
            float b = 0.69f + random.nextFloat() * ran * 1.5F;
            this.getWorld().addParticle((new StormParticleOptions(r, g, b,2.75f + random.nextFloat() * 0.6f,3.75F + random.nextFloat() * 0.6f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.getWorld().addParticle((new StormParticleOptions(r, g, b,2.5f + random.nextFloat() * 0.45f,3.0F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.getWorld().addParticle((new StormParticleOptions(r, g, b,2.25f + random.nextFloat() * 0.45f,2.25F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            //this.level().addParticle((new StormParticleOptions(r, g, b,2.0f + random.nextFloat() * 0.45f,2.0f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
           // this.level().addParticle((new StormParticleOptions(r, g, b,1.75f + random.nextFloat() * 0.45f,1.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.getWorld().addParticle((new StormParticleOptions(r, g, b,1.25f + random.nextFloat() * 0.45f,1.25f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);


            if(this.getState() == 1) {
                if (this.getLifespan() < 295) {
                    this.setState(0);
                }
            }
            if(this.getState() == 0) {
                if(this.getLifespan() < 10) {
                    this.setState(2);
                }
            }
        }

        if (!this.isSilent() && getWorld().isClient) {
         //   Cataclysm.PROXY.playWorldSound(this, (byte) 2);
        }

        for(LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.2D, 0.0D, 0.2D))) {
            if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().invulnerable) continue;
            if(entity != owner) {
                if (entity.isAlive() && !entity.isInvulnerable() ) {
                    if (this.age % 3 == 0) {
                        if (owner == null) {
                           boolean flag =  entity.damage(this.getDamageSources().magic(), (float) CMConfig.Sandstormdamage);
                           if(flag) {
                               StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                               entity.addStatusEffect(effectinstance);
                           }
                        } else {
                            if (owner.isTeammate(entity)) {
                                return;
                            }
                            boolean flag = entity.damage(this.getDamageSources().indirectMagic(this, owner), (float) CMConfig.Sandstormdamage);
                            if(flag) {
                                StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                                entity.addStatusEffect(effectinstance);
                            }
                        }
                    }
                }
            }

        }

        this.setLifespan(this.getLifespan() - 1);

        if (this.getLifespan() <= 0) {
            //Cataclysm.PROXY.clearSoundCacheFor(this);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return this.dataTracker.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.dataTracker.set(LIFESPAN, i);
    }

    public float getOffset() {
        return this.dataTracker.get(OFFSET);
    }

    public void setOffset(float i) {
        this.dataTracker.set(OFFSET, i);
    }

    public int getCasterID() {
        return dataTracker.get(CASTER);
    }

    public void setCasterID(int id) {
        dataTracker.set(CASTER, id);
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        setCasterID(p_19719_ == null ? 0 : p_19719_.getId());
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && getCasterID() != 0 && this.getWorld() instanceof ServerWorld) {
            Entity entity = this.getWorld().getEntityById(getCasterID());
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }


        return this.owner;
    }


    protected void updateMotion() {
        Entity owner = getOwner();
        if(owner !=null) {
            if (owner instanceof Ancient_Ancient_Remnant_Entity || owner instanceof Ancient_Remnant_Entity) {
                Vec3d center = owner.getPos().add(0.0, 0, 0.0);
                float radius = 8;
                float speed = this.age * 0.04f;
                float offset = this.getOffset();
                Vec3d orbit = new Vec3d(center.x + Math.cos(speed + offset) * (double) radius, center.y, center.z + Math.sin(speed + offset) * (double) radius);
                this.refreshPositionAfterTeleport(orbit);
            }
            if (owner instanceof PlayerEntity) {
                Vec3d center = owner.getPos().add(0.0, 0, 0.0);
                float radius = 6;
                float speed = this.age * 0.04f;
                float offset = this.getOffset();
                Vec3d orbit = new Vec3d(center.x + Math.cos(speed + offset) * (double) radius, center.y, center.z + Math.sin(speed + offset) * (double) radius);
                this.refreshPositionAfterTeleport(orbit);
            }

        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(CASTER, -1);
        p_326229_.add(LIFESPAN, 300);
        p_326229_.add(OFFSET,0f);
        p_326229_.add(STATE,0);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "spawn" -> this.SpawnAnimationState;
            case "despawn" -> this.DespawnAnimationState;
            default -> new AnimationState();
        };
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


    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        this.setCasterID(compound.getInt("CasterId"));
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Lifespan", getLifespan());
        compound.putInt("CasterId", getCasterID());
    }
}
