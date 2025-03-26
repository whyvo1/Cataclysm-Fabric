package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;


import com.github.l_ender.cataclysm.client.particle.LightningParticle;
import com.github.l_ender.cataclysm.client.tool.ControlledAnimation;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Portal_Abyss_Blast_Entity extends Entity {
    public static final double RADIUS = 50;
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);

    public boolean on = true;

    public Direction blockSide = null;

    private static final TrackedData<Float> YAW = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> PITCH = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CASTER = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> BEAMDIRECTION = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Portal_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public float prevYaw;
    public float prevPitch;


    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, World world) {
        super(type, world);
        ignoreCameraFrustum = true;

    }

    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, World world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float direction,float damage,float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPosition(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
        if (!world.isClient) {
            this.setCasterID(caster.getId());
        }
    }

    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, World world, double x, double y, double z, float yaw, float pitch, int duration, float direction,float damage,float Hpdamage) {
        this(type, world);
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPosition(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
    }


    @Override
    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    @Override
    public void tick() {
        super.tick();
        super.tick();
        prevCollidePosX = collidePosX;
        prevCollidePosY = collidePosY;
        prevCollidePosZ = collidePosZ;
        prevYaw = renderYaw;
        prevPitch = renderPitch;
        renderYaw = getYaw();
        renderPitch = getPitch();
        prevX = getX();
        prevY = getY();
        prevZ = getZ();
        if (age == 1 && getWorld().isClient) {
            caster = (LivingEntity) getWorld().getEntityById(getCasterID());
        }

        if (!on && appear.getTimer() == 0) {
            this.discard();
        }
        if (on && age > 20) {
            appear.increaseTimer();
        } else {
            appear.decreaseTimer();
        }

        if(age ==20){
            this.getWorld().playSoundFromEntity(null, this, ModSounds.PORTAL_ABYSS_BLAST, SoundCategory.HOSTILE, 0.5f, 1.0f);
        }

        if (caster != null && !caster.isAlive()) discard();

        if (age > 20) {
            this.calculateEndPos();
            List<LivingEntity> hit = raytraceEntities(getWorld(), new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ)).entities;
            if (blockSide != null) {
                spawnExplosionParticles(3);
                if (!this.getWorld().isClient) {
                    for (BlockPos pos : BlockPos.iterate(MathHelper.floor(collidePosX - 0.5F), MathHelper.floor(collidePosY - 0.5F), MathHelper.floor(collidePosZ - 0.5F), MathHelper.floor(collidePosX + 0.5F), MathHelper.floor(collidePosY + 0.5F), MathHelper.floor(collidePosZ + 0.5F))) {
                        BlockState block = getWorld().getBlockState(pos);
                        if (!block.isAir() && !block.isIn(ModTag.LEVIATHAN_IMMUNE) && this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                            getWorld().breakBlock(pos, false);
                        }
                    }
                }
            }
            if (!getWorld().isClient) {
                for (LivingEntity target : hit) {
                    if (caster != null) {
                        if (!this.caster.isTeammate(target) && target != caster) {
                            boolean flag = target.damage(CMDamageTypes.causeDeathLaserDamage(this, caster), (float) (this.getDamage() + Math.min(this.getDamage(), target.getMaxHealth() * this.getHpDamage() * 0.01)));
                            if (flag) {
                                StatusEffectInstance effectinstance1 = target.getStatusEffect(ModEffect.EFFECTABYSSAL_BURN);
                                int i = 1;
                                if (effectinstance1 != null) {
                                    i += effectinstance1.getAmplifier();
                                    target.removeStatusEffectInternal(ModEffect.EFFECTABYSSAL_BURN);
                                } else {
                                    --i;
                                }

                                i = MathHelper.clamp(i, 0, 3);
                                StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTABYSSAL_BURN, 160, i, false, true, true);
                                target.addStatusEffect(effectinstance);
                            }
                        }
                    }

                }
            }
        }
        if (age - 20 > getDuration()) {
            on = false;
        }
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 1.0F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);
            float motionY = random.nextFloat() * 0.08F;
            float motionX = velocity * MathHelper.cos(yaw);
            float motionZ = velocity * MathHelper.sin(yaw);
            getWorld().addParticle((new LightningParticle.OrbData(102, 26, 204)), collidePosX, collidePosY + 0.1, collidePosZ, motionX, motionY, motionZ);
        }

    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(YAW, 0F);
        this.dataTracker.startTracking(PITCH, 0F);
        this.dataTracker.startTracking(DURATION, 0);
        this.dataTracker.startTracking(CASTER, -1);
        this.dataTracker.startTracking(BEAMDIRECTION, 90f);
        this.dataTracker.startTracking(DAMAGE, 0F);
        this.dataTracker.startTracking(HPDAMAGE, 0F);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public float getHpDamage() {
        return dataTracker.get(HPDAMAGE);
    }

    public void setHpDamage(float damage) {
        dataTracker.set(HPDAMAGE, damage);
    }

    public float getYaw() {
        return dataTracker.get(YAW);
    }

    public void setYaw(float yaw) {
        dataTracker.set(YAW, yaw);
    }

    public float getPitch() {
        return dataTracker.get(PITCH);
    }

    public void setPitch(float pitch) {
        dataTracker.set(PITCH, pitch);
    }

    public int getDuration() {
        return dataTracker.get(DURATION);
    }

    public void setDuration(int duration) {
        dataTracker.set(DURATION, duration);
    }

    public float getBeamDirection() {
        return dataTracker.get(BEAMDIRECTION);
    }

    public void setBeamDirection(float beamDirection) {
        dataTracker.set(BEAMDIRECTION, beamDirection);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.setYaw(compound.getFloat("Yaw"));
        this.setPitch(compound.getFloat("Pitch"));
        this.setDuration(compound.getInt("Duration"));
        this.setBeamDirection(compound.getFloat("BeamDirection"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putFloat("Yaw", this.getYaw());
        compound.putFloat("Pitch", this.getPitch());
        compound.putInt("Duration", this.getDuration());
        compound.putFloat("BeamDirection", this.getBeamDirection());

    }

    public int getCasterID() {
        return dataTracker.get(CASTER);
    }

    public void setCasterID(int id) {
        dataTracker.set(CASTER, id);
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    private void calculateEndPos() {
        if (getWorld().isClient()) {
            endPosX = getX() + RADIUS * Math.cos(renderYaw) * Math.cos(renderPitch);
            endPosZ = getZ() + RADIUS * Math.sin(renderYaw) * Math.cos(renderPitch);
            endPosY = getY() + RADIUS * Math.sin(renderPitch);
        } else {
            endPosX = getX() + RADIUS * Math.cos(getYaw()) * Math.cos(getPitch());
            endPosZ = getZ() + RADIUS * Math.sin(getYaw()) * Math.cos(getPitch());
            endPosY = getY() + RADIUS * Math.sin(getPitch());
        }
    }

    public LaserbeamHitResult raytraceEntities(World world, Vec3d from, Vec3d to) {
        LaserbeamHitResult result = new LaserbeamHitResult();
        result.setBlockHit(world.raycast(new RaycastContext(from, to, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this)));
        if (result.blockHit != null) {
            Vec3d hitVec = result.blockHit.getPos();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.blockHit.getSide();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, new Box(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).expand(1, 1, 1));
        for (LivingEntity entity : entities) {
            if (entity == caster) {
                continue;
            }
            float pad = entity.getTargetingMargin() + 1.3f;
            Box aabb = entity.getBoundingBox().expand(pad, pad, pad);
            Optional<Vec3d> hit = aabb.raycast(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    @Override
    public void pushAwayFrom(Entity entityIn) {
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    public static class LaserbeamHitResult {
        private BlockHitResult blockHit;

        private final List<LivingEntity> entities = new ArrayList<>();

        public BlockHitResult getBlockHit() {
            return blockHit;
        }

        public void setBlockHit(HitResult rayTraceResult) {
            if (rayTraceResult.getType() == HitResult.Type.BLOCK)
                this.blockHit = (BlockHitResult) rayTraceResult;
        }

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }
}
