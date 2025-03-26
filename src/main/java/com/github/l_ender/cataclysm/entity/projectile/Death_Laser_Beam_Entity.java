package com.github.l_ender.cataclysm.entity.projectile;


import com.github.l_ender.cataclysm.blocks.EMP_Block;
import com.github.l_ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.l_ender.cataclysm.client.tool.ControlledAnimation;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Death_Laser_Beam_Entity extends Entity {
    public static final double RADIUS = 30;
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);

    public boolean on = true;

    public Direction blockSide = null;

    private static final TrackedData<Float> YAW = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> PITCH = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CASTER = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> HEAD = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> FIRE = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Death_Laser_Beam_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public float prevYaw;
    public float prevPitch;

    @Environment(EnvType.CLIENT)
    private Vec3d[] attractorPos;

    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, World world) {
        super(type, world);
        ignoreCameraFrustum = true;
        if (world.isClient) {
            attractorPos = new Vec3d[] {new Vec3d(0, 0, 0)};
        }
    }


    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, World world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration,float damage,float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setPosition(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
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
            if (caster instanceof The_Harbinger_Entity) {
                this.updateWithHarbinger();
            }
            if (caster instanceof The_Prowler_Entity) {
                this.updateWithProwler();
            }
        }

        if (caster != null) {
            renderYaw = (float) ((caster.headYaw + 90.0d) * Math.PI / 180.0d);
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
            List<LivingEntity> hit = raytraceEntities(getWorld(), new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ), false, true, true).entities;
            if (blockSide != null) {
                spawnExplosionParticles(5);
                if (!this.getWorld().isClient) {
                    for (BlockPos pos : BlockPos.iterate(MathHelper.floor(collidePosX - 0.5F), MathHelper.floor(collidePosY - 0.5F), MathHelper.floor(collidePosZ - 0.5F), MathHelper.floor(collidePosX + 0.5F), MathHelper.floor(collidePosY + 0.5F), MathHelper.floor(collidePosZ + 0.5F))) {
                        BlockState block = getWorld().getBlockState(pos);
                        if (!block.isAir() && block.isIn(ModTag.CM_GLASS) && this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                            getWorld().breakBlock(pos, true);
                        }
                    }
                    for (BlockPos pos : BlockPos.iterate(MathHelper.floor(collidePosX - 2.5F), MathHelper.floor(collidePosY - 2.5F), MathHelper.floor(collidePosZ - 2.5F), MathHelper.floor(collidePosX + 2.5F), MathHelper.floor(collidePosY + 2.5F), MathHelper.floor(collidePosZ + 2.5F))) {
                        BlockState block = getWorld().getBlockState(pos);
                        if (block.isOf(ModBlocks.EMP)) {
                            if(!block.get(EMP_Block.POWERED) && block.get(EMP_Block.OVERLOAD)) {
                                this.getWorld().setBlockState(pos, block.with(EMP_Block.OVERLOAD, false));
                            }
                        }
                    }
                    if(this.getFire()) {
                        BlockPos blockpos1 = BlockPos.ofFloored(collidePosX,collidePosY, collidePosZ);
                        if(CMConfig.HarbingerLightFire) {
                            if (this.getWorld().isAir(blockpos1)) {
                                this.getWorld().setBlockState(blockpos1, AbstractFireBlock.getState(this.getWorld(), blockpos1));
                            }
                        }else{
                            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                                if (this.getWorld().isAir(blockpos1)) {
                                    this.getWorld().setBlockState(blockpos1, AbstractFireBlock.getState(this.getWorld(), blockpos1));
                                }
                            }
                        }

                    }
                }
            }
            if (!getWorld().isClient) {
                for (LivingEntity target : hit) {
                    if (caster != null) {
                    if (!this.caster.isTeammate(target) && target != caster) {
                        boolean flag = target.damage(CMDamageTypes.causeDeathLaserDamage(this, caster), (float) (this.getDamage() + Math.min(this.getDamage(), target.getMaxHealth() * this.getHpDamage() * 0.01)));
                        if (this.getFire()) {
                            if (flag) {

                                target.setOnFireFor(5);
                            }
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
            final float velocity = 1.5F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);
            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * MathHelper.cos(yaw);
            float motionZ = velocity * MathHelper.sin(yaw);
            getWorld().addParticle((new LightningParticleOptions(255, 26,  0)), collidePosX, collidePosY + 0.1, collidePosZ, motionX, motionY, motionZ);
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(YAW, 0F);
        p_326229_.add(PITCH, 0F);
        p_326229_.add(DURATION, 0);
        p_326229_.add(CASTER, -1);
        p_326229_.add(HEAD, 0);
        p_326229_.add(FIRE, false);
        p_326229_.add(DAMAGE, 0F);
        p_326229_.add(HPDAMAGE, 0F);
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

    public int getHead() {
        return dataTracker.get(HEAD);
    }

    public void setHead(int head) {
        dataTracker.set(HEAD, head);
    }


    public int getCasterID() {
        return dataTracker.get(CASTER);
    }

    public void setCasterID(int id) {
        dataTracker.set(CASTER, id);
    }

    public boolean getFire() {
        return this.dataTracker.get(FIRE);
    }

    public void setFire(boolean fire) {
        this.dataTracker.set(FIRE, fire);
    }


    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}


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

    public LaserbeamHitResult raytraceEntities(World world, Vec3d from, Vec3d to, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) {
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
            float pad = entity.getTargetingMargin() + 0.5f;
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
    public boolean shouldRender(double distance) {
        return distance < 1024;
    }

    private void updateWithHarbinger() {
        this.setYaw((float) ((caster.headYaw + 90) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getPitch() * Math.PI / 180.0d));
        this.setPosition(caster.getX() ,caster.getY() + 2.7 , caster.getZ());
    }

    private void updateWithProwler() {
        this.setYaw((float) ((caster.headYaw + 90) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getPitch() * Math.PI / 180.0d));
        this.setPosition(caster.getX() ,caster.getY() + 1.8, caster.getZ());
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
