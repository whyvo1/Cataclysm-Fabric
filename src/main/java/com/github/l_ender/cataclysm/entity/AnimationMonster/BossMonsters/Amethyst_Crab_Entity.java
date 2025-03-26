package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.CMEntityMoveHelper;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.l_ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;


public class Amethyst_Crab_Entity extends LLibrary_Boss_Monster implements Angerable {
    public static final Animation CRAB_SMASH = Animation.create(53);
    public static final Animation CRAB_SMASH_THREE = Animation.create(77);
    public static final Animation CRAB_DEATH = Animation.create(114);
    public static final Animation CRAB_BURROW = Animation.create(65);
    public static final Animation CRAB_BITE = Animation.create(48);
    private static final UniformIntProvider PERSISTENT_ANGER_TIME = TimeHelper.betweenSeconds(20, 39);
    private int remainingPersistentAngerTime;
    private int despawnTime = 4000;

    public static final int BURROW_ATTACK_COOLDOWN = 240;
    private int burrow_cooldown = 0;

    @Nullable
    private UUID persistentAngerTarget;

    public Amethyst_Crab_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 50;
        this.setStepHeight(1.5F);
        moveControl = new CMEntityMoveHelper(this, 45);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AmethystCrabHealthMultiplier, CMConfig.AmethystCrabDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, CRAB_SMASH,CRAB_SMASH_THREE,CRAB_DEATH,CRAB_BURROW,CRAB_BITE};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new CrabMoveGoal(this, false, 1.0D));
        this.goalSelector.add(0, new CrabSmashGoal(this, CRAB_SMASH));
        this.goalSelector.add(0, new CrabAttack(this, CRAB_SMASH_THREE,10));
        this.goalSelector.add(0, new CrabBurrow(this, CRAB_BURROW));
        this.goalSelector.add(0, new CrabAttack(this, CRAB_BITE,17));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));

    }

    public static DefaultAttributeContainer.Builder amethyst_crab() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 13)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }


    public boolean isKrusty() {
        String s = Formatting.strip(this.getName().getString());
        return s != null && (s.toLowerCase().contains("eugene harold krabs") || s.toLowerCase().contains("mr.krabs"));
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        this.writeAngerToNbt(compound);
    }


    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.readAngerFromNbt(this.getWorld(), compound);
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getAnimation() == CRAB_BURROW) {
            if(this.getAnimationTick() > 9 && this.getAnimationTick() < 52) {
                if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.4F, 2.0F);
                    return false;
                }
            }
        }


        return super.damage(source, damage);
    }

    public boolean canSpawn(WorldView reader) {
        return reader.doesNotIntersectEntities(this);
    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        return ModEntities.rollSpawn(CMConfig.AmethystCrabSpawnRolls, this.getRandom(), spawnReasonIn);
    }


    public static boolean canCrabSpawnSpawnRules(EntityType<? extends Amethyst_Crab_Entity> p_219020_, WorldAccess p_219021_, SpawnReason p_219022_, BlockPos p_219023_, Random p_219024_) {
        return canSpawnIgnoreLightLevel(p_219020_, p_219021_, p_219022_, p_219023_, p_219024_);
    }

    public void tick() {
        super.tick();
        repelEntities(1.7F, 3.7f, 1.7F, 1.7F);
        if (burrow_cooldown > 0) burrow_cooldown--;

        if(this.getdespawnTimee()>0){
            this.setdespawnTime(getdespawnTimee()- 1);
        }

    }

    public void tickMovement() {
        super.tickMovement();
        if (this.getAnimation() == CRAB_SMASH) {
            if(this.getAnimationTick() == 22){
                AreaAttack(4.0f,4.0f,70,1.25f,120);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.4f,-0.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
            }
        }
        if (this.getAnimation() == CRAB_SMASH_THREE) {
            if(this.getAnimationTick() == 16){
                Attackparticle(2.2f,-0.2f);
                EarthQuakeSummon(2.2f,-0.2f);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
            }
            if(this.getAnimationTick() == 36){
                Attackparticle(1.8f,-1.5f);
                EarthQuakeSummon(1.8f,-1.5f);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
            }
            if(this.getAnimationTick() == 56){
                Attackparticle(1.7f,1.3f);
                EarthQuakeSummon(1.7f,1.3f);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
            }
        }
        if (this.getAnimation() == CRAB_BURROW) {
            for (int l = 1; l <= 10; l = l + 3) {
                if (this.getAnimationTick() == l) {
                    BurrowSound();
                    BurrowParticle(0.6f,0.0f,2.0f);
                }
            }
            for (int l = 39; l <= 48; l = l + 3) {
                if (this.getAnimationTick() == l) {
                    BurrowParticle(0.6f, 0.0f, 2.0f);
                    BurrowSound();
                }
            }
        }
        if (this.getAnimation() == CRAB_BITE) {
            if (this.getAnimationTick() == 14) {
                this.playSound(ModSounds.CRAB_BITE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 17) {
                AreaAttack(4.5f,4.5f,110,1.25f,120);
            }
        }

    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.bodyYaw % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!(entityHit instanceof Amethyst_Crab_Entity)) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    entityHit.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                }
            }
        }
    }

    private void Attackparticle(float vec, float math) {
        if (this.getWorld().isClient) {
            float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
            float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
            double theta = (bodyYaw) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = 1.0 * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 1.0 * MathHelper.cos(angle);
                int hitX = MathHelper.floor(getX() + vec * vecX + extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.getWorld().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 25, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.3f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void BurrowParticle(float vec, float math, float size) {
        if (this.getWorld().isClient) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.1D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
                float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
                double extraX = size * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = size * MathHelper.cos(angle);
                double theta = (bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int hitX = MathHelper.floor(getX() + vec * vecX + extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }

    private void BurrowSound(){
        float angle = (0.01745329251F * this.bodyYaw);
        double extraX = 1.0 * MathHelper.sin((float) (Math.PI + angle));
        double extraZ = 1.0 * MathHelper.cos(angle);
        int hitX = MathHelper.floor(getX() + extraX);
        int hitY = MathHelper.floor(getY());
        int hitZ = MathHelper.floor(getZ() + extraZ);
        BlockPos hit = new BlockPos(hitX, hitY, hitZ);
        BlockState block = getWorld().getBlockState(hit.down());
        BlockSoundGroup soundtype = block.getSoundGroup();
        this.getWorld().playSoundFromEntity(null, this, soundtype.getBreakSound(), SoundCategory.HOSTILE, 3.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
    }

    private void EarthQuakeSummon(float vec, float math) {
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        final int quakeCount = 16;
        float angle = 360.0F / quakeCount;
        for (int i = 0; i < quakeCount; i++) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.getWorld(), this);
            peq.setDamage((float) CMConfig.AmethystCrabEarthQuakeDamage);
            peq.setVelocity(this, 0, angle * i, 0.0F, 0.25F, 0.0F);
            peq.setPosition(this.getX() + vec * vecX + f * math, this.getY(), getZ() + vec * vecZ + f1 * math);
            this.getWorld().spawnEntity(peq);

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
        return CRAB_DEATH;
    }


    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CRAB_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CRAB_DEATH;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public void setAngerTime(int p_32515_) {
        this.remainingPersistentAngerTime = p_32515_;
    }

    public int getAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    public void setdespawnTime(int p_32515_) {
        this.despawnTime = p_32515_;
    }

    public int getdespawnTimee() {
        return this.despawnTime;
    }

    public boolean canImmediatelyDespawn(double p_21542_) {
        return this.despawnTime >= 0;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.persistentAngerTarget;
    }

    public void setAngryAt(@Nullable UUID p_32509_) {
        this.persistentAngerTarget = p_32509_;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(PERSISTENT_ANGER_TIME.get(this.random));
    }


    static class CrabMoveGoal extends Goal {
        private final Amethyst_Crab_Entity crab;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;


        public CrabMoveGoal(Amethyst_Crab_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.crab = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setControls(EnumSet.of(Control.LOOK, Control.MOVE));
        }


        public boolean canStart() {
            LivingEntity target = this.crab.getTarget();
            return target != null && target.isAlive() && this.crab.getAnimation() == IAnimatedEntity.NO_ANIMATION;
        }


        public void stop() {
            crab.getNavigation().stop();
            LivingEntity livingentity = this.crab.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.crab.setTarget(null);
            }
            this.crab.setAttacking(false);
            this.crab.getNavigation().stop();
        }

        public boolean shouldContinue() {
            LivingEntity target = this.crab.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.crab.getNavigation().isIdle();
            } else if (!this.crab.isInWalkTargetRange(target.getBlockPos())) {
                return false;
            } else {
                return !(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity)target).isCreative();
            }
        }

        public void start() {
            this.crab.getNavigation().startMovingAlong(this.path, this.moveSpeed);
            this.crab.setAttacking(true);
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.crab.getTarget();
            if(target != null){
                crab.getLookControl().lookAt(target, 30.0F, 30.0F);
                double distSq = this.crab.squaredDistanceTo(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.crab.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.crab.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.crab.isNavigating()) {
                            if (!this.crab.getNavigation().startMovingTo(target, 1.0D)) {
                                this.delayCounter += 5;
                            }
                        }
                    } else {
                        this.crab.getNavigation().startMovingTo(target, this.moveSpeed);
                    }
                }
                if(target.isAlive()) {
                    if (this.crab.getAnimation() == NO_ANIMATION) {
                        if (this.crab.burrow_cooldown <= 0 && this.crab.getRandom().nextFloat() * 100.0F < 6f && this.crab.distanceTo(target) <= 8.0D) {
                            this.crab.setAnimation(CRAB_BURROW);
                        } else if (this.crab.getRandom().nextFloat() * 100.0F < 24f && this.crab.distanceTo(target) <= 3.75D) {
                            if(this.crab.random.nextInt(2) == 0) {
                                this.crab.setAnimation(CRAB_BITE);
                            }else{
                                this.crab.setAnimation(CRAB_SMASH);
                            }
                        } else if (this.crab.getRandom().nextFloat() * 100.0F < 16f && this.crab.distanceTo(target) <= 3.75D && target.isOnGround()) {
                            this.crab.setAnimation(CRAB_SMASH_THREE);
                        }
                    }
                }
            }
        }
    }

    static class CrabSmashGoal extends SimpleAnimationGoal<Amethyst_Crab_Entity> {


        public CrabSmashGoal(Amethyst_Crab_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE,Goal.Control.JUMP, Goal.Control.LOOK));
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 19 && target != null) {
                entity.lookAtEntity(target, 30, 30);
                entity.getNavigation().startMovingTo(target, 1.0f);
                entity.getLookControl().lookAt(target, 30, 30);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if (entity.getAnimationTick() == 19){
                entity.getNavigation().stop();
            }

        }
    }

    static class CrabAttack extends SimpleAnimationGoal<Amethyst_Crab_Entity> {
        private final int look;

        public CrabAttack(Amethyst_Crab_Entity entity, Animation animation , int look) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE,Goal.Control.JUMP, Goal.Control.LOOK));
            this.look = look;
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < look && target != null) {
                entity.lookAtEntity(target, 30, 30);
                entity.getLookControl().lookAt(target, 30, 30);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    static class CrabBurrow extends SimpleAnimationGoal<Amethyst_Crab_Entity> {


        public CrabBurrow(Amethyst_Crab_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE,Goal.Control.JUMP, Goal.Control.LOOK));
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            entity.burrow_cooldown = BURROW_ATTACK_COOLDOWN;
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 48 && target != null) {
                entity.lookAtEntity(target, 30, 30);
                entity.getLookControl().lookAt(target, 30, 30);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if (entity.getAnimationTick() == 50){
                for (int i = 0; i < 32; i++) {
                    float throwAngle = i * MathHelper.PI / 16F;

                    double sx = entity.getX() + (MathHelper.cos(throwAngle) * 1);
                    double sy = entity.getY() + (entity.getHeight() * 0.2D);
                    double sz = entity.getZ() + (MathHelper.sin(throwAngle) * 1);

                    double vx = MathHelper.cos(throwAngle);
                    double vy = 0 + entity.random.nextFloat() * 0.3F;
                    double vz = MathHelper.sin(throwAngle);
                    double v3 = MathHelper.sqrt((float) (vx * vx + vz * vz));
                    Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE, entity.getWorld(), entity,(float)CMConfig.AmethystClusterdamage);

                    projectile.refreshPositionAndAngles(sx, sy, sz, i * 11.25F, entity.getPitch());
                    float speed = 0.8F;
                    projectile.setVelocity(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    entity.getWorld().spawnEntity(projectile);
                }
            }
        }
    }
}





