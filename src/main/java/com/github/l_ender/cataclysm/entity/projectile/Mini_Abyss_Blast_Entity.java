package com.github.l_ender.cataclysm.entity.projectile;


import com.github.l_ender.cataclysm.client.particle.LightningParticle;
import com.github.l_ender.cataclysm.client.tool.ControlledAnimation;
import com.github.l_ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mini_Abyss_Blast_Entity extends Entity {
    public static final double RADIUS = 15;
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);

    public boolean on = true;

    public Direction blockSide = null;

    private static final TrackedData<Float> YAW = DataTracker.registerData(Mini_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> PITCH = DataTracker.registerData(Mini_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(Mini_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CASTER = DataTracker.registerData(Mini_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> BEAMDIRECTION = DataTracker.registerData(Mini_Abyss_Blast_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    public float prevYaw;
    public float prevPitch;

    @Environment(EnvType.CLIENT)
    private Vec3d[] attractorPos;

    public Mini_Abyss_Blast_Entity(EntityType<? extends Mini_Abyss_Blast_Entity> type, World world) {
        super(type, world);
        ignoreCameraFrustum = true;
        if (world.isClient) {
            attractorPos = new Vec3d[] {new Vec3d(0, 0, 0)};
        }
    }

    public Mini_Abyss_Blast_Entity(EntityType<? extends Mini_Abyss_Blast_Entity> type, World world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float direction) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPosition(x, y, z);
        this.calculateEndPos();
        if (!world.isClient) {
            this.setCasterID(caster.getId());
        }
    }

    @Override
    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    @Override
    public void tick() {
        super.tick();
        prevCollidePosX = collidePosX;
        prevCollidePosY = collidePosY;
        prevCollidePosZ = collidePosZ;
        prevYaw = renderYaw;
        prevPitch = renderPitch;
        prevX = getX();
        prevY = getY();
        prevZ = getZ();
        if (age == 1 && getWorld().isClient) {
            caster = (LivingEntity) getWorld().getEntityById(getCasterID());
        }

        if (!getWorld().isClient) {
            if (caster instanceof The_Baby_Leviathan_Entity) {
                this.updateWithHarbinger();
            }
        }

        if (caster != null) {
            renderYaw = (float) ((caster.headYaw + this.getBeamDirection()) * Math.PI / 180.0d);
            renderPitch = (float) (-caster.getPitch() * Math.PI / 180.0d);
        }

        if (!on && appear.getTimer() == 0) {
            this.discard();
        }
        if (on && age > 20) {
            appear.increaseTimer();
        } else {
            appear.decreaseTimer();
        }

        if (caster != null && !caster.isAlive()) discard();

        if (age > 20) {
            this.calculateEndPos();
            List<LivingEntity> hit = raytraceEntities(getWorld(), new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ)).entities;
            if (blockSide != null) {
                spawnExplosionParticles(3);
            }
            if (!getWorld().isClient) {
                for (LivingEntity target : hit) {
                    if (caster != null) {
                        if (!this.caster.isTeammate(target) && target != caster) {
                            target.damage(CMDamageTypes.causeDeathLaserDamage(this, caster), 5);

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


    public int getCasterID() {
        return dataTracker.get(CASTER);
    }

    public void setCasterID(int id) {
        dataTracker.set(CASTER, id);
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
        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, new Box(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).expand(2, 2, 2));
        for (LivingEntity entity : entities) {
            if (entity == caster) {
                continue;
            }
            float pad = entity.getTargetingMargin() + 0.15f;
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

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
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


    private void updateWithHarbinger() {
        this.setYaw((float) ((caster.headYaw + this.getBeamDirection()) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getPitch() * Math.PI / 180.0d));

        float f = -MathHelper.sin(caster.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(caster.getPitch() * ((float)Math.PI / 180F));
        float f2 = MathHelper.cos(caster.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(caster.getPitch() * ((float)Math.PI / 180F));
        this.setPosition(caster.getX(),caster.getY() + 0.125f, caster.getZ());
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
