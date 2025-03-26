package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.CmAttackGoal;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import java.util.EnumSet;



public class Ender_Golem_Entity extends LLibrary_Boss_Monster {

    public static final Animation ANIMATION_ATTACK1 = Animation.create(25);
    public static final Animation ANIMATION_ATTACK2 = Animation.create(25);
    public static final Animation ANIMATION_EARTHQUAKE = Animation.create(35);
    public static final Animation VOID_RUNE_ATTACK = Animation.create(83);
    public static final Animation ENDER_GOLEM_DEATH = Animation.create(95);
    public static final int VOID_RUNE_ATTACK_COOLDOWN = 250;
    private static final TrackedData<Boolean> IS_AWAKEN = DataTracker.registerData(Ender_Golem_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int void_rune_attack_cooldown = 0;
    private int timeWithoutTarget;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    public boolean Breaking = CMConfig.EndergolemBlockBreaking;

    public Ender_Golem_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 15;
        this.setStepHeight(1.5F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.EnderGolemHealthMultiplier, CMConfig.EnderGolemDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, ANIMATION_ATTACK1, ANIMATION_ATTACK2, ANIMATION_EARTHQUAKE,VOID_RUNE_ATTACK,ENDER_GOLEM_DEATH};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new CmAttackGoal(this, 1.0D));
        this.goalSelector.add(1, new AttackGoal());
        this.goalSelector.add(0, new AwakenGoal());
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder ender_golem() {
        return createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150)
                .add(EntityAttributes.GENERIC_ARMOR, 12)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }


    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    private static Animation getRandomAttack(Random rand) {
        return switch (rand.nextInt(3)) {
            case 0 -> ANIMATION_ATTACK1;
            case 1 -> ANIMATION_ATTACK2;
            case 2 -> ANIMATION_EARTHQUAKE;
            default -> ANIMATION_EARTHQUAKE;
        };
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getAnimation() == VOID_RUNE_ATTACK
                || !this.getIsAwaken()) {
            if(source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)|| !source.isOf(DamageTypes.MAGIC)) {
                damage *= 0.5F;
            }
        }
        double range = calculateRange(source);

        if (range > CMConfig.EndergolemLongRangelimit * CMConfig.EndergolemLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        Entity entity = source.getSource();
        if (entity instanceof GolemEntity) {
            damage *= 0.5F;
        }

        return super.damage(source, damage);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_AWAKEN, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        setIsAwaken(compound.getBoolean("is_Awaken"));
    }

    public void setIsAwaken(boolean isAwaken) {
        this.dataTracker.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.dataTracker.get(IS_AWAKEN);
    }

    public void tick() {
        super.tick();
        repelEntities(1.7F, 3.7f, 1.7F, 1.7F);
        LivingEntity target = this.getTarget();
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAwaken() && deactivateProgress < 30F) {
            deactivateProgress++;
        }
        if (this.getIsAwaken() && deactivateProgress > 0F) {
            deactivateProgress--;

        }

        if(!this.getIsAwaken()) {
            if (this.age % 20 == 0) {
                this.heal(2.0F);
            }
        }

        if (deactivateProgress == 0 && this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (void_rune_attack_cooldown <= 0 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && target.isOnGround() && (this.random.nextInt(45) == 0 && this.distanceTo(target) < 4 || this.random.nextInt(24) == 0 && this.distanceTo(target) < 10)) {
                    void_rune_attack_cooldown = VOID_RUNE_ATTACK_COOLDOWN;
                    this.setAnimation(VOID_RUNE_ATTACK);

                } else if (this.distanceTo(target) < 4 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION) {
                    Animation animation = getRandomAttack(random);
                    this.setAnimation(animation);
                }
            }

            if (this.getAnimation() == ANIMATION_EARTHQUAKE) {
                if (this.getAnimationTick() == 19) {
                    EarthQuake(5,6);
                    EarthQuakeParticle();
                    if (!this.getWorld().isClient) {
                        if (Breaking) {
                            BlockBreaking(4, 4, 4);
                        } else {
                            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                                BlockBreaking(4, 4, 4);
                            }
                        }
                    }
                }
            }
            if ((this.getAnimation() == ANIMATION_ATTACK1 || this.getAnimation() == ANIMATION_ATTACK2) && this.getAnimationTick() == 13) {
                this.playSound(ModSounds.GOLEMATTACK, 1, 1);
                if (target != null && target.isAlive()) {
                    if (this.distanceTo(target) < 4.75F) {
                        target.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.random.nextInt(4));
                        target.takeKnockback(1.25F, this.getX() - target.getX(), this.getZ() - target.getZ());
                    }
                }
            }
            if (this.getAnimation() == VOID_RUNE_ATTACK) {
                if (this.getAnimationTick() == 22) {
                    EarthQuake(4.25f,4);
                    EarthQuakeParticle();
                    if (!this.getWorld().isClient) {
                        if (Breaking) {
                            BlockBreaking(4, 4, 4);
                        } else {
                            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                                BlockBreaking(4, 4, 4);
                            }
                        }
                    }
                }
                if (this.getAnimationTick() == 28) {
                    VoidRuneAttack();
                }
            }
        }
        if (void_rune_attack_cooldown > 0) void_rune_attack_cooldown--;
        if (!getWorld().isClient) {
            timeWithoutTarget++;
            if (target != null) {
                timeWithoutTarget = 0;
                if(!this.getIsAwaken()) {
                    this.setIsAwaken(true);
                }
            }

            if (timeWithoutTarget > 400 && this.getIsAwaken() && target == null) {
                timeWithoutTarget = 0;
                this.setIsAwaken(false);
            }
        }

    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());
        boolean flag = false;
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.getWorld().getBlockState(blockpos);
                    if (block != Blocks.AIR.getDefaultState() && block.isIn(ModTag.ENDER_GOLEM_CAN_DESTROY)) {
                        flag = this.getWorld().breakBlock(blockpos, true, this) || flag;
                    }
                }
            }
        }
    }

    private void EarthQuakeParticle() {
        if (this.getWorld().isClient) {
            BlockState block = getWorld().getBlockState(getBlockPos().down());
            for (int i1 = 0; i1 < 20 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = 4F * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 4F * MathHelper.cos(angle);
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }

    private void EarthQuake(float grow, int damage) {
        this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(grow))) {
            if (!isTeammate(entity) && !(entity instanceof Ender_Golem_Entity) && entity != this) {
                entity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.random.nextInt(damage));
                launch(entity, true);

            }
        }
    }


    private void VoidRuneAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
            float f = (float) MathHelper.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = MathHelper.cos(this.getYaw() * ((float) Math.PI / 180F)) * (2.0F);
            float f3 = MathHelper.sin(this.getYaw() * ((float) Math.PI / 180F)) * (2.0F);
            for(int l = 0; l < 10; ++l) {
                double d2 = 1.5D * (double)(l + 1);
                int j = (int) (1.25f * l);
                this.spawnFangs(this.getX() + f2 + (double)MathHelper.cos(f) * d2, this.getZ() + f3 + (double)MathHelper.sin(f) * d2, d0, d1, f, j);
                this.spawnFangs(this.getX() - f2 + (double)MathHelper.cos(f) * d2, this.getZ() - f3 + (double)MathHelper.sin(f) * d2, d0, d1, f, j);
            }
            for (int k = 0; k < 6; ++k) {
                float f4 = f + (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 7.5F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f4) * 2.5D, this.getZ() + (double) MathHelper.sin(f4) * 2.5D, d0, d1, f2, 5);
            }
            for (int k = 0; k < 8; ++k) {
                this.spawnFangs(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 15);
            }

        }
    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while (blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            this.getWorld().spawnEntity(new Void_Rune_Entity(this.getWorld(), x, (double) blockpos.getY() + d0, z, rotation, delay,(float) CMConfig.Voidrunedamage, this));
        }
    }

    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.addVelocity(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
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

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setVelocity(0, this.getVelocity().y, 0);
        if (this.deathTime == 40) {
            this.playSound(ModSounds.MONSTROSITYLAND, 1, 1);
        }

    }


    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return ENDER_GOLEM_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.GOLEMHURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.GOLEMDEATH;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    class AttackGoal extends Goal {


        public AttackGoal() {
            this.setControls(EnumSet.of(Control.JUMP, Control.LOOK, Control.MOVE));
        }

        public boolean canStart() {
            return Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE || Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void stop() {
            super.stop();
        }

        public void tick() {
            Ender_Golem_Entity.this.setVelocity(0, Ender_Golem_Entity.this.getVelocity().y, 0);
            LivingEntity target = Ender_Golem_Entity.this.getTarget();

            if(Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 19 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    Ender_Golem_Entity.this.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Golem_Entity.this.setYaw(Ender_Golem_Entity.this.prevYaw);
                    //Ender_Golem_Entity.this.yBodyRot = Ender_Golem_Entity.this.yBodyRotO;
                }
            }
            if(Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 22 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    Ender_Golem_Entity.this.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Golem_Entity.this.setYaw(Ender_Golem_Entity.this.prevYaw);
                    //Ender_Golem_Entity.this.yBodyRot = Ender_Golem_Entity.this.yBodyRotO;
                }
            }
        }
    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setControls(EnumSet.of(Control.JUMP, Control.LOOK, Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return deactivateProgress > 0F;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            Ender_Golem_Entity.this.setVelocity(0, Ender_Golem_Entity.this.getVelocity().y, 0);
        }
    }

}





