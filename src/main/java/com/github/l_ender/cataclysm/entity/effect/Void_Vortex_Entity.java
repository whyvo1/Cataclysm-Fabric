package com.github.l_ender.cataclysm.entity.effect;

import com.github.l_ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.l_ender.cataclysm.init.ModEntities;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Void_Vortex_Entity extends Entity {

    protected static final TrackedData<Integer> LIFESPAN = DataTracker.registerData(Void_Vortex_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CASTER = DataTracker.registerData(Void_Vortex_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    @Nullable
    private LivingEntity owner;



    public Void_Vortex_Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Void_Vortex_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, LivingEntity casterIn, int span) {
        this(ModEntities.VOID_VORTEX, worldIn);
        this.setLifespan(span);
        this.setOwner(casterIn);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
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
        if (this.age == 1) {
            if(this.getLifespan() == 0){
                this.setLifespan(60);
            }
            if (getWorld().isClient) {
                owner = (LivingEntity) getWorld().getEntityById(getCasterID());
            }
        }
        if(!madeOpenNoise){
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.playSound(SoundEvents.BLOCK_END_PORTAL_SPAWN, 1.0F, 1 + random.nextFloat() * 0.2F);
            madeOpenNoise = true;
        }

        if(Math.min(age, this.getLifespan()) >= 16){
            if(getWorld().isClient) {
                float r = 0.4F;
                float g = 0.1f;
                float b = 0.8f;
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,2.5F + random.nextFloat() * 0.9f,5 + random.nextFloat() * 0.9f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,2.25f + random.nextFloat() * 0.6f,4.25F + random.nextFloat() * 0.6f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,2f + random.nextFloat() * 0.45f,3.5F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,1.5f + random.nextFloat() * 0.25f,2.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,1.25f + random.nextFloat() * 0.25f,2.0F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,1.0f + random.nextFloat() * 0.25f,1.25F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.getWorld().addParticle((new StormParticleOptions(r, g, b,0.75f + random.nextFloat() * 0.25f,0.5F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            }
            Box screamBox = new Box(this.getX() - 3f, this.getY(), this.getZ() - 3, this.getX() + 3, this.getY() + 15F, this.getZ() + 3F);

            for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, screamBox)) {
                if (!isTeammate(entity) && (owner == null || !owner.equals(entity) && !owner.isTeammate(entity))) {
                    if (!(entity instanceof PlayerEntity player && player.getAbilities().invulnerable)) {
                        Vec3d diff = entity.getPos().subtract(getPos().add(0, 0, 0));
                        diff = diff.normalize().multiply(0.075);
                        entity.setVelocity(entity.getVelocity().add(0, -2, 0).subtract(diff));
                    }
                }
            }
        }

        this.setLifespan(this.getLifespan() - 1);
        if(this.getLifespan() <= 16){
            if(!madeCloseNoise){
                this.emitGameEvent(GameEvent.ENTITY_PLACE);
                madeCloseNoise = true;
            }


        }
        if (this.getLifespan() <= 0) {
            this.getWorld().createExplosion(this.owner, this.getX(), this.getY(), this.getZ(), 2.0F, false, World.ExplosionSourceType.NONE);
            this.remove(RemovalReason.DISCARDED);
        }
    }


    public int getLifespan() {
        return this.dataTracker.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.dataTracker.set(LIFESPAN, i);
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


    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(LIFESPAN, 300);
        p_326229_.add(CASTER, -1);

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
