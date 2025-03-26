package com.github.l_ender.cataclysm.entity.AnimationMonster;

import com.github.l_ender.cataclysm.entity.etc.path.DirectPathNavigator;
import com.github.l_ender.cataclysm.entity.etc.FlightMoveController;
import com.github.l_ender.cataclysm.entity.projectile.Void_Shard_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SpiderNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class Endermaptera_Entity extends HostileEntity implements IAnimatedEntity {
    public static final Identifier HAS_JAWS_LOOT = new Identifier("cataclysm", "entities/endermaptera_has_jaws");
    private int animationTick;
    private Animation currentAnimation;
    public static final Animation JAW_ATTACK = Animation.create(13);
    public static final Animation HEADBUTT_ATTACK = Animation.create(13);
    public float attachChangeProgress = 0F;
    public float prevAttachChangeProgress = 0F;
    private static final TrackedData<Direction> ATTACHED_FACE = DataTracker.registerData(Endermaptera_Entity.class, TrackedDataHandlerRegistry.FACING);
    private static final TrackedData<Byte> CLIMBING = DataTracker.registerData(Endermaptera_Entity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Boolean> HAS_JAWS = DataTracker.registerData(Endermaptera_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private Direction prevAttachDir = Direction.DOWN;
    private boolean isUpsideDownNavigator;

    public Endermaptera_Entity(EntityType entity, World world) {
        super(entity, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.experiencePoints = 6;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0f, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    private void switchNavigator(boolean rightsideUp) {
        if (rightsideUp) {
            this.moveControl = new MoveControl(this);
            this.navigation = new SpiderNavigation(this, getWorld());
            this.isUpsideDownNavigator = false;
        } else {
            this.moveControl = new FlightMoveController(this, 0.6F, false);
            this.navigation = new DirectPathNavigator(this, getWorld());
            this.isUpsideDownNavigator = true;
        }
    }

    public static DefaultAttributeContainer.Builder endermaptera() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
                .add(EntityAttributes.GENERIC_ARMOR, 6)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.25);
    }


    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(CLIMBING, (byte) 0);
        this.dataTracker.startTracking(ATTACHED_FACE, Direction.DOWN);
        this.dataTracker.startTracking(HAS_JAWS, true);
    }

    public Direction getAttachmentFacing() {
        return this.dataTracker.get(ATTACHED_FACE);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new SpiderNavigation(this, worldIn);
    }

    @Nullable
    protected Identifier getLootTableId() {
        return this.getHasJaws() ? HAS_JAWS_LOOT : super.getLootTableId();
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("Has_Jaws", getHasJaws());

    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.dataTracker.set(ATTACHED_FACE, Direction.byId(compound.getByte("AttachFace")));
        setHasJaw(compound.getBoolean("Has_Jaws"));
    }

    public void setHasJaw(boolean HasJaws) {
        this.dataTracker.set(HAS_JAWS, HasJaws);

    }

    public boolean getHasJaws() {
        return this.dataTracker.get(HAS_JAWS);

    }

    public boolean handleFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
        return false;
    }

    protected void fall(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.ENDERMAPTERA_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.ENDERMAPTERA_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERMAPTERA_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.ENDERMAPTERA_STEP, 0.15F, 0.6F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, JAW_ATTACK, HEADBUTT_ATTACK};
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }


    public boolean tryAttack(Entity entityIn) {
        if (this.getHasJaws()) {
            this.setAnimation(JAW_ATTACK);
        } else {
            this.setAnimation(HEADBUTT_ATTACK);
        }
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        this.prevAttachChangeProgress = this.attachChangeProgress;
        AnimationHandler.INSTANCE.updateAnimations(this);
        if (attachChangeProgress > 0F) {
            attachChangeProgress -= 0.25F;
        }
        Vec3d vec3d = this.getVelocity();
        if (!this.getWorld().isClient) {
            this.setBesideClimbableBlock(this.horizontalCollision || this.verticalCollision && !this.isOnGround());
            if (this.isOnGround() || this.isInsideWaterOrBubbleColumn() || this.isInLava()) {
                this.dataTracker.set(ATTACHED_FACE, Direction.DOWN);
            } else if (this.verticalCollision) {
                this.dataTracker.set(ATTACHED_FACE, Direction.UP);
            } else {
                Direction closestDirection = Direction.DOWN;
                double closestDistance = 100;
                for (Direction dir : HORIZONTALS) {
                    BlockPos antPos = new BlockPos(MathHelper.floor(this.getX()), MathHelper.floor(this.getY()), MathHelper.floor(this.getZ()));
                    BlockPos offsetPos = antPos.offset(dir);
                    Vec3d offset = Vec3d.ofCenter(offsetPos);
                    if (closestDistance > this.getPos().distanceTo(offset) && getWorld().isDirectionSolid(offsetPos, this, dir.getOpposite())) {
                        closestDistance = this.getPos().distanceTo(offset);
                        closestDirection = dir;
                    }
                }
                this.dataTracker.set(ATTACHED_FACE, closestDirection);
            }
        }
        boolean flag = false;
        if (this.getAttachmentFacing() != Direction.DOWN) {
            if (this.getAttachmentFacing() == Direction.UP) {
                this.setVelocity(this.getVelocity().add(0, 1, 0));
            } else {
                if (!this.horizontalCollision && this.getAttachmentFacing() != Direction.UP) {
                    Vec3d vec = Vec3d.of(this.getAttachmentFacing().getVector());
                    this.setVelocity(this.getVelocity().add(vec.normalize().multiply(0.1F, 0.1F, 0.1F)));
                }
                if (!this.isOnGround() && vec3d.y < 0.0D) {
                    this.setVelocity(this.getVelocity().multiply(1.0D, 0.5D, 1.0D));
                    flag = true;
                }
            }
        }
        if (this.getAttachmentFacing() == Direction.UP) {
            this.setNoGravity(true);
            this.setVelocity(vec3d.multiply(0.7D, 1D, 0.7D));
        } else {
            this.setNoGravity(false);
        }
        if (!flag) {
            if (this.isClimbing()) {
                this.setVelocity(vec3d.multiply(1.0D, 0.4D, 1.0D));
            }
        }
        if (prevAttachDir != this.getAttachmentFacing()) {
            attachChangeProgress = 1F;
        }
        this.prevAttachDir = this.getAttachmentFacing();
        if (!this.getWorld().isClient) {
            if (this.getAttachmentFacing() == Direction.UP && !this.isUpsideDownNavigator) {
                switchNavigator(false);
            }
            if (this.getAttachmentFacing() != Direction.UP && this.isUpsideDownNavigator) {
                switchNavigator(true);
            }
            LivingEntity target = this.getTarget();
            if (target != null && distanceTo(target) < target.getWidth() + this.getWidth() && this.canSee(target)) {
                float damage = (float) ((int) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                if (this.getAnimation() == JAW_ATTACK && this.getAnimationTick() == 11) {
                    target.damage(this.getDamageSources().mobAttack(this), damage);
                    if (this.random.nextInt(6) == 0) {
                        BrokenJaws();
                    }
                }
                if (this.getAnimation() == HEADBUTT_ATTACK && this.getAnimationTick() == 6) {
                    target.damage(this.getDamageSources().mobAttack(this), damage * 0.75f);
                }
            }
        } else {
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.PORTAL, this.getParticleX(0.5D), this.getRandomBodyY(), this.getParticleZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            }
        }

    }

    private void BrokenJaws() {
        this.playSound(SoundEvents.ENTITY_ITEM_BREAK, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        this.setHasJaw(false);
        int shardCount = 8 + random.nextInt(4);
        if (!this.getWorld().isClient) {
            for (int i = 0; i < shardCount; i++) {
                float f = ((i + 1) / (float) shardCount) * 360F;
                Void_Shard_Entity shard = new Void_Shard_Entity(ModEntities.VOID_SHARD, this.getWorld(), this);
                shard.setVelocity(this, this.getPitch() - random.nextInt(40), f, 0.0F, 0.15F + random.nextFloat() * 0.2F, 1.0F);
                getWorld().spawnEntity(shard);
            }
        }
    }

    protected void onBlockCollision(BlockState state) {

    }

    public boolean isClimbing() {
        return this.isBesideClimbableBlock();
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataTracker.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataTracker.get(CLIMBING);
        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.dataTracker.set(CLIMBING, b0);
    }

    public static boolean canSpawn(EntityType<Endermaptera_Entity> entity, WorldAccess worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return !worldIn.getBlockState(pos.down()).isIn(ModTag.ENDERMAPTERA_CAN_NOT_SPAWN);
    }


    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

}
