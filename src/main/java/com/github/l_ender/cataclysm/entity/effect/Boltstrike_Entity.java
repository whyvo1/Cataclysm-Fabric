package com.github.l_ender.cataclysm.entity.effect;


import com.github.l_ender.cataclysm.client.particle.LightningParticle;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.UUID;

public class Boltstrike_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;


    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Boltstrike_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Boltstrike_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    private static final TrackedData<Integer> R = DataTracker.registerData(Boltstrike_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> G = DataTracker.registerData(Boltstrike_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> B = DataTracker.registerData(Boltstrike_Entity.class, TrackedDataHandlerRegistry.INTEGER);


    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;



    public Boltstrike_Entity(EntityType<? extends Boltstrike_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
        this.ignoreCameraFrustum = true;
    }


    public Boltstrike_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,float damage, LivingEntity casterIn) {
        this(ModEntities.BOLT_STRIKE, worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }


    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(DAMAGE, 0f);
        this.dataTracker.startTracking(HPDAMAGE, 0f);
        this.dataTracker.startTracking(R, 0);
        this.dataTracker.startTracking(G, 0);
        this.dataTracker.startTracking(B, 0);
    }


    public int getR()
    {
        return this.dataTracker.get(R);
    }

    public void setR(int r)
    {
        this.dataTracker.set(R, r);
    }

    public int getG()
    {
        return this.dataTracker.get(G);
    }

    public void setG(int g)
    {
        this.dataTracker.set(G, g);
    }


    public int getB()
    {
        return this.dataTracker.get(B);
    }

    public void setB(int b)
    {
        this.dataTracker.set(B, b);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.owner = p_190549_1_;
        this.ownerUUID = p_190549_1_ == null ? null : p_190549_1_.getUuid();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.owner == null && this.ownerUUID != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    @Override
    public boolean shouldRender(double p_20869_) {
        double d0 = 64.0D * getRenderDistanceMultiplier();
        return p_20869_ < d0 * d0;
    }



    public Vec3d getAnglePosition(float p_20347_,double height,double Maxradius,double Minradius) {



        double angle = random.nextFloat() * 2 * Math.PI;

        double radius = Minradius + random.nextDouble() * (Maxradius - Minradius);

        double randomX = radius * Math.cos(angle);
        double randomZ = radius * Math.sin(angle);

        return this.getLerpedPos(p_20347_).add(randomX, height, randomZ);
    }

    public float getAnimationProgress(float partialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int i = this.lifeTicks;

            if (i >= 12 && i < 18) {
                return 0.3F;
            }
            if (i >= 18) {
                return Math.max(0.3F - ((i - 18 + partialTicks) / 20.0F), 0.0F);
            }

            return 0.0F;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
                if (this.lifeTicks < 24 && this.lifeTicks > 12) {
                    smolder(6);
                }
                if (this.lifeTicks == 12){
                    if (!this.isSilent()) {
                        this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.EMP_ACTIVATED, this.getSoundCategory(), 1.0F, this.random.nextFloat() * 0.2F + 0.85F, false);
                    }
                }

            }
        } else {
            if (--this.warmupDelayTicks < 0) {
                if (this.warmupDelayTicks == -12) {
                    this.damageEntityLivingBaseNearby(1.0D);
                    ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 30);
                }

                if (!this.sentSpikeEvent) {
                    this.getWorld().sendEntityStatus(this, (byte)4);
                    this.sentSpikeEvent = true;
                }

                if (++this.lifeTicks > 22) {
                    this.discard();
                }
            }
        }
    }


    public void damageEntityLivingBaseNearby(double radius) {
        Box region = new Box(getX() - radius, getY() - 0.5, getZ() - radius, getX() + radius, this.getWorld().getTopY() + 20, getZ() + radius);
        List<LivingEntity> entities = getWorld().getNonSpectatingEntities(LivingEntity.class, region);

        for (LivingEntity entity : entities) {
            damage(entity);
        }
    }


    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (livingentity == null) {
                Hitentity.damage(this.getDamageSources().magic(), this.getDamage());
            } else {
                if (livingentity.isTeammate(Hitentity)) {
                    return;
                }
                Hitentity.damage(this.getDamageSources().indirectMagic(this, livingentity), this.getDamage());
            }
        }
    }


    public void handleStatus(byte p_36935_) {
        super.handleStatus(p_36935_);
        if (p_36935_ == 4) {
            this.clientSideAttackStarted = true;
        }

    }


    private void smolder(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 1.5F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);

            float r = random.nextFloat() * 0.7F;
            float x = r * MathHelper.cos(yaw);
            float z = r * MathHelper.sin(yaw);

            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * MathHelper.cos(yaw);
            float motionZ = velocity * MathHelper.sin(yaw);
            getWorld().addParticle((new LightningParticle.OrbData(this.getR(), this.getG(), this.getB())), this.getX() + x, this.getY() + 0.1, this.getZ() + z, motionX, motionY, motionZ);
        }

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        if (this.ownerUUID != null) {
            compound.putUuid("Owner", this.ownerUUID);
        }
        compound.putFloat("damage", this.getDamage());
        compound.putInt("r", this.getR());
        compound.putInt("g", this.getG());
        compound.putInt("b", this.getB());
       // compound.putFloat("Hpdamage", this.getHpDamage());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        if (compound.containsUuid("Owner")) {
            this.ownerUUID = compound.getUuid("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
     //   this.setHpDamage(compound.getFloat("Hpdamage"));
        this.setR(compound.getInt("r"));
        this.setG(compound.getInt("g"));
        this.setB(compound.getInt("b"));
    }


//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

}
