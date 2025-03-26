package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.AI.AnimalAIRandomSwimming;
import com.github.l_ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.l_ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AnimationGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.*;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Partable;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.message.MessageMusic;
import com.github.l_ender.cataclysm.util.Utilities;
import com.github.l_ender.cataclysm.world.data.CMWorldData;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.*;

public class The_Leviathan_Entity extends LLibrary_Boss_Monster implements ISemiAquatic, IHoldEntity, Partable {

    public static final Animation LEVIATHAN_GRAB = Animation.create(160);
    public static final Animation LEVIATHAN_GRAB_BITE = Animation.create(13);
    public static final Animation LEVIATHAN_BITE = Animation.create(24);
    public static final Animation LEVIATHAN_ABYSS_BLAST = Animation.create(184);
    public static final Animation LEVIATHAN_ABYSS_BLAST_FIRE = Animation.create(216);

    public static final Animation LEVIATHAN_RUSH = Animation.create(157);
    public static final Animation LEVIATHAN_STUN = Animation.create(90);

    public static final Animation LEVIATHAN_ABYSS_BLAST_PORTAL = Animation.create(142);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_R = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_R = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_L = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_L = Animation.create(44);

    public static final Animation LEVIATHAN_TENTACLE_HOLD = Animation.create(63);
    public static final Animation LEVIATHAN_TENTACLE_HOLD_BLAST = Animation.create(189);

    public static final Animation LEVIATHAN_TAIL_WHIPS = Animation.create(42);
    public static final Animation LEVIATHAN_BREAK_DIMENSION = Animation.create(156);
    public static final Animation LEVIATHAN_PHASE2 = Animation.create(200);
    public static final Animation LEVIATHAN_DEATH = Animation.create(210);

    public static final Animation LEVIATHAN_MINE = Animation.create(68);

    public final The_Leviathan_Part headPart;
    public final The_Leviathan_Part tailPart1;
    public final The_Leviathan_Part tailPart2;

    public final The_Leviathan_Part[] leviathanParts;
    public boolean blocksBylefttentacle = true;
    public boolean blocksByrighttentacle = true;

    public boolean CanGrab = true;
    public boolean CanAbyss_Blast = true;
    public boolean CanRush = true;
    public boolean CanTailWhips = true;
    public boolean CanBite = true;
    public boolean CanAbyss_Blast_Portal = true;
    public boolean CanCrackDimension = true;
    public boolean CanMine= true;

    public float NoSwimProgress = 0;
    public float prevNoSwimProgress = 0;
    public float LeftTentacleProgress = 0;
    public float prevLeftTentacleProgress = 0;
    public float RightTentacleProgress = 0;
    public float prevRightTentacleProgress = 0;
    private boolean isLandNavigator;
    public Vec3d teleportPos = null;
    public Abyss_Portal_Entity portalTarget = null;
    public boolean fullyThrough = true;
    public static final int GRAB_HUNTING_COOLDOWN = 70;
    public static final int RUSH_HUNTING_COOLDOWN = 100;
    public static final int BLAST_HUNTING_COOLDOWN = 140;
    public static final int CRACK_HUNTING_COOLDOWN = 250;
    public static final int BLAST_PORTAL_HUNTING_COOLDOWN = 120;
    public static final int TAIL_WHIPS_HUNTING_COOLDOWN = 100;
    public static final int BITE_COOLDOWN = 100;
    public static final int MELEE_COOLDOWN = 40;
    public static final int MINE_COOLDOWN = 100;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;
    private AttackMode mode = AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int makePortalCooldown = 0;
    private int bite_cooldown = 0;
    private int melee_cooldown = 0;
    private int waterstillTicks = 0;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    public float LayerBrightness;
    private Vec3d prevTailPos = new Vec3d(0, 0, 0);
    private final CustomBossBar bossInfo = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.LEVIATHAN, false);
    private static final TrackedData<Integer> BLAST_CHANCE = DataTracker.registerData(The_Leviathan_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> MODE_CHANCE = DataTracker.registerData(The_Leviathan_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> MELT_DOWN = DataTracker.registerData(The_Leviathan_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Optional<UUID>> TONGUE_UUID = DataTracker.registerData(The_Leviathan_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final TrackedData<Integer> TONGUE_ID = DataTracker.registerData(The_Leviathan_Entity.class, TrackedDataHandlerRegistry.INTEGER);


    public The_Leviathan_Entity(EntityType type, World worldIn) {
        super(type, worldIn);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.experiencePoints = 500;
        if (worldIn.isClient)
            socketPosArray = new Vec3d[]{new Vec3d(0, 0, 0)
        };
        this.headPart = new The_Leviathan_Part(this, 2.8F, 2.8F);
        this.tailPart1 = new The_Leviathan_Part(this, 1.5F, 2.4F);
        this.tailPart2 = new The_Leviathan_Part(this, 1.3F, 2.4F);
        this.leviathanParts = new The_Leviathan_Part[]{this.headPart,this.tailPart1,this.tailPart2};
        switchNavigator(false);
        setConfigattribute(this, CMConfig.LeviathanHealthMultiplier, CMConfig.LeviathanDamageMultiplier);
    }

    public static DefaultAttributeContainer.Builder leviathan() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 400.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 10.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new SwimNavigation(this, worldIn);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(BLAST_CHANCE, 0);
        this.dataTracker.startTracking(MODE_CHANCE, 0);
        this.dataTracker.startTracking(MELT_DOWN, false);
        this.dataTracker.startTracking(TONGUE_UUID, Optional.empty());
        this.dataTracker.startTracking(TONGUE_ID, -1);
    }

    protected void initGoals() {
        this.goalSelector.add(2, new MobAIFindWater(this,2.0D));
        this.goalSelector.add(3, new LeviathanAttackGoal(this));
        this.goalSelector.add(4, new AnimalAIRandomSwimming(this, 1F, 3, 15));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(0, new LeviathanGrabAttackGoal(this,LEVIATHAN_GRAB));
        this.goalSelector.add(0, new LeviathanAbyssDimensionAttackGoal(this,LEVIATHAN_BREAK_DIMENSION));
        this.goalSelector.add(0, new LeviathanStunGoal(this,LEVIATHAN_STUN));
        this.goalSelector.add(0, new LeviathanGrabBiteAttackGoal(this,LEVIATHAN_GRAB_BITE));
        this.goalSelector.add(0, new LeviathanBiteAttackGoal(this,LEVIATHAN_BITE));
        this.goalSelector.add(0, new LeviathanPhase2Goal(this,LEVIATHAN_PHASE2));
        this.goalSelector.add(0, new LeviathanTailWhipsAttackGoal(this,LEVIATHAN_TAIL_WHIPS));
        this.goalSelector.add(0, new LeviathanTentacleAttackGoal(this));
        this.goalSelector.add(0, new LeviathanBlastAttackGoal(this,LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.add(0, new LeviathanBlastFireAttackGoal(this,LEVIATHAN_ABYSS_BLAST_FIRE));
        this.goalSelector.add(0, new LeviathanAbyssBlastPortalAttackGoal(this,LEVIATHAN_ABYSS_BLAST_PORTAL));
        this.goalSelector.add(0, new LeviathanRushAttackGoal(this,LEVIATHAN_RUSH));
        this.goalSelector.add(0, new LeviathanTentacleHoldAttackGoal(this,LEVIATHAN_TENTACLE_HOLD));
        this.goalSelector.add(0, new LeviathanTentacleHoldBlastAttackGoal(this,LEVIATHAN_TENTACLE_HOLD_BLAST));
        this.goalSelector.add(0, new LeviathanMineAttackGoal(this,LEVIATHAN_MINE));
        this.targetSelector.add(1, (new AdvancedHurtByTargetGoal(this)));
        this.targetSelector.add(2, new EntityAINearestTarget3D<>(this, PlayerEntity.class, false,true));
        this.targetSelector.add(3, new EntityAINearestTarget3D<>(this, LivingEntity.class, 160, false, true, ModEntities.buildPredicateFromTag(ModTag.LEVIATHAN_TARGET)));

    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new CMPathNavigateGround(this, getWorld());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new LeviathanMoveController(this, 10, 1, 6);
            this.navigation = new SwimNavigation(this, getWorld());
            this.isLandNavigator = false;
        }
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{LEVIATHAN_PHASE2,LEVIATHAN_BITE,LEVIATHAN_BREAK_DIMENSION,LEVIATHAN_GRAB,LEVIATHAN_TAIL_WHIPS, LEVIATHAN_ABYSS_BLAST_PORTAL,LEVIATHAN_GRAB_BITE,LEVIATHAN_ABYSS_BLAST,LEVIATHAN_RUSH,LEVIATHAN_TENTACLE_STRIKE_UPPER_R,LEVIATHAN_TENTACLE_STRIKE_UPPER_L,LEVIATHAN_TENTACLE_STRIKE_LOWER_L,LEVIATHAN_TENTACLE_STRIKE_LOWER_R,LEVIATHAN_STUN,LEVIATHAN_DEATH,
                LEVIATHAN_TENTACLE_HOLD,LEVIATHAN_TENTACLE_HOLD_BLAST,LEVIATHAN_ABYSS_BLAST_FIRE,LEVIATHAN_MINE};
    }

    public void travel(Vec3d travelVector) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), travelVector);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
            if (this.getTarget() == null && this.getAnimation() == NO_ANIMATION) {
                this.setVelocity(this.getVelocity().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }

    }


    private static Animation getRandomTantalcleStrike(Random rand) {
        return switch (rand.nextInt(4)) {
            case 0 -> LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
            case 1 -> LEVIATHAN_TENTACLE_STRIKE_LOWER_R;
            case 2 -> LEVIATHAN_TENTACLE_STRIKE_UPPER_L;
            case 3 -> LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
            default -> LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
        };
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    public boolean damage(DamageSource source, float damage) {
        Entity entity = source.getSource();
        if (entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        double range = calculateRange(source);

        if (range > CMConfig.LeviathanLongRangelimit * CMConfig.LeviathanLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        boolean flag1 = this.canInFluidType(this.getWorld().getFluidState(this.getBlockPos()));
        if (!flag1) {
            if(!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && CMConfig.LeviathanImmuneOutofWater) {
                if (entity instanceof PlayerEntity player) {
                    player.sendMessage(Text.translatable("entity.cataclysm.the_leviathan_immune"), true);
                }
                return false;
            }
        }

        if ((this.getAnimation() == LEVIATHAN_PHASE2) && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }


        boolean attack = super.damage(source, damage);

        if(this.getAnimation() == LEVIATHAN_RUSH) {
            if (this.getAnimationTick() >= 38 && this.getAnimationTick() <= 54) {
                if(attack){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEVIATHAN_STUN);
                }
            }
        }


        return attack;
    }

    
    public float DamageCap() {
        return (float) CMConfig.LeviathanDamageCap;
    }

    public int DamageTime() {
        return CMConfig.LeviathanDamageTime;
    }

    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }

    private boolean canInFluidType(FluidState type) {
        return type.isOf(Fluids.WATER);
    }

    public void onBubbleColumnCollision(boolean p_20322_) {

    }

    public void onBubbleColumnSurfaceCollision(boolean p_20313_) {

    }


    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.isOf(DamageTypes.IN_WALL) || source.isOf(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public boolean attackEntityFromPart(The_Leviathan_Part leviathan_part, DamageSource source, float amount) {
        return this.damage(source, amount);
    }


    public void tick() {
        super.tick();
        this.setYaw(this.headYaw);
        if (isTouchingWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isTouchingWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }
        Entity weapon = getTongue();
        if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
            this.dataTracker.set(TONGUE_ID, magneticWeapon.getId());
            magneticWeapon.setControllerUUID(this.getUuid());
        }

        if (!this.getPassengerList().isEmpty() && this.getPassengerList().get(0).isSneaking() && this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            this.getPassengerList().get(0).setSneaking(false);
        }


        LivingEntity target = this.getTarget();
        if (!getWorld().isClient) {
            float halfHealth = this.getMaxHealth() / 2;
            if(!this.getMeltDown()) {
                this.bossInfo.setPercent((this.getHealth() - halfHealth) / (this.getMaxHealth() - halfHealth));
            }
            else {
                this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
//                this.bossInfo.setBossBarStyle(CustomBossBarStyles.LEVIATHAN_MELTDOWN);
            }


            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.LeviathanNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.LeviathanNatureHealing);
                    }
                }
            }
        }

        final boolean groundAnimate = !this.isTouchingWater();
        this.prevNoSwimProgress = NoSwimProgress;
        if (groundAnimate) {
            if (this.NoSwimProgress < 10F)
                this.NoSwimProgress++;
        } else {
            if (this.NoSwimProgress > 0F)
                this.NoSwimProgress--;
        }
        this.prevLeftTentacleProgress = LeftTentacleProgress;
        this.prevRightTentacleProgress = RightTentacleProgress;
        if (blocksByrighttentacle) {
            if (this.RightTentacleProgress < 10F)
                this.RightTentacleProgress++;
        } else {
            if (this.RightTentacleProgress > 0F)
                this.RightTentacleProgress--;
        }
        if (blocksBylefttentacle) {
            if (this.LeftTentacleProgress < 10F)
                this.LeftTentacleProgress++;
        } else {
            if (this.LeftTentacleProgress > 0F)
                this.LeftTentacleProgress--;
        }

        if (age % 10 == 0) {
            blocksByrighttentacle = checkBlocksByTentacle(1,-3)
                    || checkBlocksByTentacle(2,-3)
                    || checkBlocksByTentacle(3,-3)
                    || checkBlocksByTentacle(4,-3)
                    || checkBlocksByTentacle(5,-3);
            blocksBylefttentacle = checkBlocksByTentacle(1,3)
                    || checkBlocksByTentacle(2,3)
                    || checkBlocksByTentacle(3,3)
                    || checkBlocksByTentacle(4,3)
                    || checkBlocksByTentacle(5,3);

        }

        if (this.portalTarget != null && this.portalTarget.getLifespan() < 5) {
            this.portalTarget = null;
        }
        if (teleportPos != null) {
            this.setPosition(teleportPos.x, teleportPos.y, teleportPos.z);
            teleportPos = null;
        }
        if (makePortalCooldown > 0) {
            makePortalCooldown--;
        }

        if (hunting_cooldown > 0) {
            hunting_cooldown--;
        }

        if (bite_cooldown > 0) {
            bite_cooldown--;
        }

        if (melee_cooldown > 0) {
            melee_cooldown--;
        }


        if (!this.isAiDisabled()) {
            if (this.getAnimation() == NO_ANIMATION && !this.getMeltDown() && this.isMeltDown() && this.isAlive()) {
                this.setAnimation(LEVIATHAN_PHASE2);
            }
            if(this.getAnimation() == NO_ANIMATION &&  this.getTarget() !=null) {
                if (Math.abs(prevX - this.getX()) < 0.01F && Math.abs(prevY - this.getY()) < 0.01F && Math.abs(prevZ - this.getZ()) < 0.01F) {
                    waterstillTicks++;
                } else {
                    waterstillTicks = 0;
                }
                if (waterstillTicks > 40 && makePortalCooldown == 0) {
                    createStuckPortal();
                }
            }
            if (!this.getWorld().isClient) {
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0){
                        if(CMConfig.LeviathanBlockBreaking){
                            blockbreak(0.5D,0.5D,0.5D);
                        }else{
                            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                                blockbreak(0.5D,0.5D,0.5D);
                            }
                        }
                    }
                }
                if(mode ==AttackMode.MELEE) {
                    if (CMConfig.LeviathanBlockBreaking) {
                        blockbreak2();
                    } else {
                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                            blockbreak2();
                        }
                    }
                }
            }
            final float f17 = this.getYaw() * (float) Math.PI / 180.0F;
            final float pitch = this.getPitch() * (float) Math.PI / 180.0F;
            final float f3 = MathHelper.sin(f17) * (1 - Math.abs(this.getPitch() / 90F));
            final float f18 = MathHelper.cos(f17) * (1 - Math.abs(this.getPitch() / 90F));
            this.setPartPosition(this.headPart, f3 * -3.8F, -pitch * 3F, -f18 * -3.8F);
            this.setPartPosition(this.tailPart1, f3 * 3.3F, -pitch * -5F, -f18 * 3.3F);
            this.setPartPosition(this.tailPart2, f3 * 4.7F, -pitch * -8F, -f18 * 4.7F);
            Vec3d[] avector3d = new Vec3d[this.leviathanParts.length];
            for (int j = 0; j < this.leviathanParts.length; ++j) {
                avector3d[j] = new Vec3d(this.leviathanParts[j].getX(), this.leviathanParts[j].getY(), this.leviathanParts[j].getZ());
            }
            for (int l = 0; l < this.leviathanParts.length; ++l) {
                this.leviathanParts[l].prevX = avector3d[l].x;
                this.leviathanParts[l].prevY = avector3d[l].y;
                this.leviathanParts[l].prevZ = avector3d[l].z;
                this.leviathanParts[l].lastRenderX = avector3d[l].x;
                this.leviathanParts[l].lastRenderY = avector3d[l].y;
                this.leviathanParts[l].lastRenderZ = avector3d[l].z;
            }

        }
    }

    public void tickMovement() {
        super.tickMovement();
        Vec3d motion;
        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST){
            if(this.getAnimationTick() < 30){
                if (this.getWorld().isClient) {
                    for (int i = 0; i < 20; ++i) {
                        float f = -MathHelper.sin(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
                        float f2 = -MathHelper.sin(this.getPitch() * ((float)Math.PI / 180F));
                        float f3 = MathHelper.cos(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
                        this.getWorld().addParticle(ParticleTypes.PORTAL, this.getX() + f * 4.0,this.getY() + f2 * 3.5, this.getZ() + f3 * 4.0, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }

            if (this.getAnimationTick() >= 82) {
                this.setPitch(this.prevPitch);
            }

            if(this.getAnimationTick() == 84){
                if(this.getMeltDown()){
                    for(int i = 0; i < 3; ++i) {
                        motion = new Vec3d(0.5, -1.25, 0.5).rotateY(-(float)(120 * i) * 0.01745329251F);

                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }

                    for(int i = 0; i < 6; ++i) {
                        motion = new Vec3d(1.0, 0.0, 1.0).rotateY(-(float)(60 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }

                    for(int i = 0; i < 3; ++i) {
                        motion = new Vec3d(0.5, 1.25, 0.5).rotateY(-(float)(120 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                }
            }

            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 144, j = 1; i <= 184; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            if(this.getAnimationTick() == 84 ) {
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 90, 10);
            }
        }
        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST_FIRE){
            if(this.getAnimationTick() < 30){
                if (this.getWorld().isClient) {
                    for (int i = 0; i < 20; ++i) {
                        float f = -MathHelper.sin(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
                        float f2 = -MathHelper.sin(this.getPitch() * ((float)Math.PI / 180F));
                        float f3 = MathHelper.cos(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
                        this.getWorld().addParticle(ParticleTypes.PORTAL, this.getX() + f * 4.0,this.getY() + f2 * 3.5, this.getZ() + f3 * 4.0, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }

            if (this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.ABYSS_BLAST_ONLY_SHOOT, SoundCategory.HOSTILE, 4.0f, 1.0f);
            }


            if (this.getAnimationTick() >= 80 && this.getAnimationTick() <= 118
                    || this.getAnimationTick() >= 125 && this.getAnimationTick() <= 163
                    || this.getAnimationTick() >= 170 && this.getAnimationTick() <= 198) {
                this.setPitch(this.prevPitch);
            }

            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 176, j = 1; i <= 216; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            if(this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174 ) {
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 20, 10);
            }
        }

        if(this.getAnimation() == LEVIATHAN_RUSH){
            if (this.getAnimationTick() > 54 && this.getAnimationTick() < 137) {
                chargeDamage();
                if (!this.getWorld().isClient) {
                    if(CMConfig.LeviathanBlockBreaking) {
                        chargeblockbreaking();
                    }else{
                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                            chargeblockbreaking();
                        }
                    }
                }

            }

            if (this.getAnimationTick() == 54) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_ROAR, SoundCategory.HOSTILE, 4.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 60, 10);
                roarDarkness(48,48,48,48,20);
            }
        }
        if(this.getAnimation() == LEVIATHAN_GRAB_BITE){
            if (this.getAnimationTick() == 2) {
                // charge();
                biteattack(6.5f,1.5,1.5,1.5,100);
            }
        }

        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_R){
            Tentacleattack(24,9,2,2,2);
        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_R){
            Tentacleattack(28,9,2, 2,2);

        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_L){
            Tentacleattack(26,9,2, 2,2);

        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_L){
            Tentacleattack(21,9,2, 2,2);
        }

        if(this.getAnimation() == LEVIATHAN_STUN){
            if (this.getAnimationTick() == 52) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_STUN_ROAR, SoundCategory.HOSTILE, 4.0f, 0.8f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 40, 10);
                if(this.getMeltDown()) {
                    for (int i = 0; i < 3; ++i) {
                        motion = new Vec3d(0.5, -1.25, 0.5).rotateY(-(float) (120 * i) * 0.01745329251F);

                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (int i = 0; i < 6; ++i) {
                        motion = new Vec3d(1.0, 0.0, 1.0).rotateY(-(float) (60 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (int i = 0; i < 3; ++i) {
                        motion = new Vec3d(0.5, 1.25, 0.5).rotateY(-(float) (120 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                }
            }
        }

        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST_PORTAL){
            if (this.getAnimationTick() == 56) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_ROAR, SoundCategory.HOSTILE, 4.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 60, 10);
                roarDarkness(48,48,48,48,80);
            }
            for (int i = 16, j = 0; i <= 56; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 102, j = 1; i <= 142; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
        }
        SwingParticles();

        if(this.getAnimation() == LEVIATHAN_TAIL_WHIPS){
            if (this.getAnimationTick() == 18) {
                TailWhips();
            }
        }

        if(this.getAnimation() == LEVIATHAN_BREAK_DIMENSION) {
            if (this.getAnimationTick() == 24) {
                this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.05f, 10, 10);
            }
            if (this.getAnimationTick() == 62) {
                this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 2.0f, 1.1f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 10, 10);
                for (Entity entity : this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }

            if (this.getAnimationTick() == 94) {
                this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 3.0f, 1.2f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.15f, 10, 10);
                for (Entity entity : this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }

            if (this.getAnimationTick() == 126) {
                this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 3.0f, 1.3f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.2f, 10, 10);
                for (Entity entity : this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }
        }
        if(this.getAnimation() == LEVIATHAN_BITE){
            if (this.getAnimationTick() == 11) {
                // charge();
                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_BITE, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if (this.getAnimationTick() == 13) {
                // charge();
                biteattack(6.0f,1.5,1.5,1.5,100);
            }
        }

        if(this.getAnimation() == LEVIATHAN_PHASE2){
            if (this.getAnimationTick() == 1) {
                if (!getWorld().isClient && getBossMusic() != null) {
                    new MessageMusic(this.getId(), false).sendToClient(this);
                }
            }


            if (this.getAnimationTick() == 90) {
                if(!this.getMeltDown()) {
                    setMeltDown(true);
                }
                if (!getWorld().isClient && getBossMusic() != null) {
                    new MessageMusic(this.getId(), true).sendToClient(this);
                }
                for(int i = 0; i < 3; ++i) {
                    motion = new Vec3d(0.5, -1.25, 0.5).rotateY(-(float)(120 * i) * 0.01745329251F);

                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3d(1.0, -0.75, 1.0).rotateY(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3d(1.0, 0.0, 1.0).rotateY(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3d(1.0, 0.75, 1.0).rotateY(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 3; ++i) {
                    motion = new Vec3d(0.5, 1.25, 0.5).rotateY(-(float)(120 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_STUN_ROAR, SoundCategory.HOSTILE, 3.0f, 0.8f);
                ScreenShake_Entity.ScreenShake(this.getWorld(), this.getPos(), 30, 0.1f, 40, 10);
            }
            if (this.getAnimationTick() >= 70 && this.getAnimationTick() <= 80) {
                Sphereparticle(this.getStandingEyeHeight(),0,8);
            }
        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_HOLD){
            if (this.getAnimationTick() == 32) {
                TentacleHoldattack(7,2.5, 2.5,2.5,80);
            }
        }

        if(this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 149, j = 1; i <= 189; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
        }

        if(this.getAnimation() == LEVIATHAN_MINE){
            if (this.getAnimationTick() == 31) {
                // charge();
                this.getWorld().playSoundFromEntity(null, this, ModSounds.LEVIATHAN_STUN_ROAR, SoundCategory.HOSTILE, 3.0f, 0.8f);
            }
        }
    }


    private void roarDarkness(double x, double y,double z, double radius,int time) {
        List<LivingEntity> entities = getEntityLivingBaseNearby(x, y, z, radius);
        for (LivingEntity inRange : entities) {
            if (inRange instanceof PlayerEntity && ((PlayerEntity) inRange).getAbilities().invulnerable) continue;
            if (isTeammate(inRange)) continue;
            inRange.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, time));
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (living != null) {
            CMWorldData worldData = CMWorldData.get(getWorld(),World.OVERWORLD);
            if (worldData != null) {
                boolean prev = worldData.isLeviathanDefeatedOnce();
                if (!prev) {
                    worldData.setLeviathanDefeatedOnce(true);
                    if (getWorld() instanceof ServerWorld serverLevel) {
                        serverLevel.getPlayers(EntityPredicates.EXCEPT_SPECTATOR).forEach(serverPlayer -> serverPlayer.sendMessage(Text.translatable("entity.cataclysm.the_leviathan.defeat_message").formatted(Formatting.DARK_PURPLE), true));
                    }
                }
            }
        }
    }

    private void TailWhips() {
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(7.0D,7.0D,7.0D))) {
            if (!isTeammate(entity) && !(entity instanceof The_Leviathan_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.LeviathanTailSwingHpdamage)));

                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player) {
                    disableShield(player, 120);
                }


                if (flag) {
                    launch(entity, true);
                    entity.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBONE_FRACTURE, 200));

                }
            }
        }
    }

    private void Sphereparticle(float height, float vec, float size) {
        if (this.getWorld().isClient) {
            if (this.age % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) MathHelper.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;

                            this.getWorld().addParticle(ParticleTypes.REVERSE_PORTAL, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isMeltDown() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    public void shootAbyssOrb(double xMotion, double yMotion, double zMotion) {
        if(getTarget() != null) {
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity(this, xMotion, yMotion, zMotion, this.getWorld(), (float) CMConfig.AbyssOrbdamage,this.getTarget());
            fireball.setPosition(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.getWorld().isClient) {
                this.getWorld().spawnEntity(fireball);
            }
        }else{
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity(this, xMotion, yMotion, zMotion, this.getWorld(), (float) CMConfig.AbyssOrbdamage,null);
            fireball.setPosition(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.getWorld().isClient) {
                this.getWorld().spawnEntity(fireball);
            }
        }
    }

    private void launch(Entity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 10F : 5F;
        e.addVelocity(d0 / d2 * f, huge ? 1.0D : 0.2F, d1 / d2 * f);
    }


    private void Tailswing() {
        Vec3d bladePos = socketPosArray[0];
        double length = prevTailPos.subtract(bladePos).length();
        int numClouds = (int) Math.floor(2 * length);
        for (int i = 0; i < numClouds; i++) {
            double x = prevTailPos.x + i * (bladePos.x - prevTailPos.x) / numClouds;
            double y = prevTailPos.y + i * (bladePos.y - prevTailPos.y) / numClouds;
            double z = prevTailPos.z + i * (bladePos.z - prevTailPos.z) / numClouds;

            ParticleEffect type =  ParticleTypes.EXPLOSION;
            getWorld().addParticle(type, x, y, z, 0, 0, 0);
        }
    }

    private void SwingParticles() {
        if (getWorld().isClient) {
            Vec3d bladePos = socketPosArray[0];
            if (this.getAnimation() == LEVIATHAN_TAIL_WHIPS) {
                if (this.getAnimationTick() >= 10 && this.getAnimationTick() <= 34) {
                    Tailswing();
                }
            }
            prevTailPos = bladePos;
        }
    }



    private void blockbreak(double x, double y, double z) {
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(x, y, z);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.LEVIATHAN_IMMUNE)) {
                flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
            }
        }
    }


    private void blockbreak2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(0.2D);
        for (BlockPos pos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = getWorld().getBlockState(pos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.LEVIATHAN_IMMUNE)) {
                if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, blockstate, 20);
                    flag = this.getWorld().breakBlock(pos, false, this) || flag;
                    fallingBlockEntity.setVelocity(fallingBlockEntity.getVelocity().add(this.getPos().subtract(fallingBlockEntity.getPos()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                    getWorld().spawnEntity(fallingBlockEntity);
                } else {
                    flag = this.getWorld().breakBlock(pos, false, this) || flag;
                    this.setVelocity(this.getVelocity().multiply(0.6F, 1, 0.6F));
                }

            }
        }
        if (flag) {
            blockBreakCounter = 10;
        }
    }

    private void chargeblockbreaking() {
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(4.5D, 0.5D, 4.5D);
        double yblockbreak = this.isTouchingWater() ? aabb.minY : this.getY();
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(yblockbreak), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.LEVIATHAN_IMMUNE)) {
                flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
            }
        }
    }

    private void chargeDamage(){
        if (this.age % 4 == 0) {
            for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(3D))) {
                if (!isTeammate(Lentity) && !(Lentity instanceof The_Leviathan_Entity) && Lentity != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = Lentity.damage(damagesource,  (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), Lentity.getMaxHealth() * CMConfig.LeviathanRushHpdamage)));
                    if (Lentity instanceof PlayerEntity player && Lentity.blockedByShield(damagesource)) {
                        disableShield(player, 120);
                    }


                    if (flag) {
                        if (Lentity.isOnGround()) {
                            double d0 = Lentity.getX() - this.getX();
                            double d1 = Lentity.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            float f = 1.5F;
                            Lentity.addVelocity(d0 / d2 * f, 0.5F, d1 / d2 * f);
                        }
                    }
                }
            }
        }
    }


    private void biteattack(float radius , double inflateX, double inflateY, double inflateZ,int stuntick) {
        double renderYaw = (this.headYaw +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getPitch() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if (!getWorld().isClient) {
            List<LivingEntity> hit = raytraceEntities(getWorld(), inflateX, inflateY,inflateZ, new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ) ).entities;
            for (LivingEntity target : hit) {
                if (!isTeammate(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = target.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 1.5 + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 1.5, target.getMaxHealth() * CMConfig.LeviathanbiteHpdamage)));
                    if (target instanceof PlayerEntity player && target.blockedByShield(damagesource)) {
                        disableShield(player, 200);
                    }


                    if(flag){
                        if (stuntick > 0) {
                            target.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTSTUN, stuntick));
                        }
                    }

                }
            }
        }
    }


    private void Tentacleattack(int anime, float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (this.headYaw +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getPitch() * Math.PI / 180.0d);
        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if(this.getAnimationTick() == anime){
            this.playSound(ModSounds.LEVIATHAN_TENTACLE_STRIKE, 1.0F, 1.0F);

            List<LivingEntity> hit = raytraceEntities(getWorld(), inflateX, inflateY,inflateZ, new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (!isTeammate(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = target.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), target.getMaxHealth() * CMConfig.LeviathanTentacleHpdamage)));
                    if (target instanceof PlayerEntity player && target.blockedByShield(damagesource)) {
                        disableShield(player, 90);
                    }

                    if(flag){
                        double d0 = target.getX() - this.getX();
                        double d1 = target.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        target.addVelocity(d0 / d2 * 7.0D, 0.2D, d1 / d2 * 7.0D);
                    }
                }
            }

        }
    }


    private void TentacleHoldattack(float radius, double inflateX, double inflateY, double inflateZ, int shieldbreakticks) {
        double renderYaw = (this.headYaw +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getPitch() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);

        List<LivingEntity> hit = raytraceEntities(getWorld(), inflateX, inflateY, inflateZ, new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ)).entities;
        for (LivingEntity target : hit) {
            if (!isTeammate(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = target.damage(damagesource, (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + target.getMaxHealth() * 0.1f);
                if (target instanceof PlayerEntity player && target.blockedByShield(damagesource) && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag && !target.getType().isIn(ModTag.IGNIS_CANT_POKE) && target.isAlive()) {
                    if (target.isSneaking()) {
                        target.setSneaking(false);
                    }
                    if (!this.getWorld().isClient) {
                        target.startRiding(this, true);
                        Utilities.trySendOverlayMessage(target, Text.translatable("entity.cataclysm.you_cant_escape"));
                    }

                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEVIATHAN_TENTACLE_HOLD_BLAST);
                }
            }
        }


    }


    public void updatePassengerPosition(Entity passenger, Entity.PositionUpdater moveFunc) {
        if (hasPassenger(passenger)) {
            if (this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
                if (this.getAnimationTick() == 169) {
                    passenger.stopRiding();
                    //passenger.push(f1 * 2.5, 0.8, f2 * 2.5);
                }
            }
            this.setPitch(this.prevPitch);
            this.bodyYaw = this.getYaw();
            this.headYaw = this.getYaw();
            final float f17 = this.getYaw() * (float) Math.PI / 180.0F;
            final float pitch = this.getPitch() * (float) Math.PI / 180.0F;
            final float f3 = MathHelper.sin(f17) * (1 - Math.abs(this.getPitch() / 90F));
            final float f18 = MathHelper.cos(f17) * (1 - Math.abs(this.getPitch() / 90F));
            moveFunc.accept(passenger,this.getX() + f3 * -8.25F, this.getY() + -pitch * 6F, this.getZ() + -f18 * -8.25F);

        }
    }

    public boolean shouldRiderSit() {
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }

    public boolean canHaveStatusEffect(StatusEffectInstance p_31495_) {
        return p_31495_.getEffectType() != ModEffect.EFFECTABYSSAL_BURN
                && super.canHaveStatusEffect(p_31495_);
    }

    private BiteHitResult raytraceEntities(World world, double inflateX, double inflateY, double inflateZ,Vec3d from, Vec3d to) {
        BiteHitResult result = new BiteHitResult();
        collidePosX = endPosX;
        collidePosY = endPosY;
        collidePosZ = endPosZ;

        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, new Box(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).expand(inflateX, inflateY, inflateZ));
        for (LivingEntity entity : entities) {
            float pad = 2.5f;
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


    public static class BiteHitResult {
        private final List<LivingEntity> entities = new ArrayList<>();

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }

    protected int getNextAirOnLand(int currentAir) {
        return this.getMaxAir();
    }

    protected float getActiveEyeHeight(EntityPose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.45F;
    }

    public boolean canBreatheInWater() {
        return true;
    }



    public boolean isPushedByFluids() {
        return false;
    }

    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }


    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("BlastChance", this.getBlastChance());
        compound.putBoolean("MeltDown", this.getMeltDown());
        compound.putInt("ModeChance", this.getModeChance());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setBlastChance(compound.getInt("BlastChance"));
        this.setModeChance(compound.getInt("ModeChance"));
        this.setMeltDown(compound.getBoolean("MeltDown"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossInfo.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossInfo.removePlayer(player);
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    public boolean getMeltDown() {
        return this.dataTracker.get(MELT_DOWN);
    }

    public void setMeltDown(boolean chance) {
        this.dataTracker.set(MELT_DOWN, chance);
        this.bossInfo.setBossBarStyle(chance ? CustomBossBarStyles.LEVIATHAN_MELTDOWN : CustomBossBarStyles.LEVIATHAN);
    }

    public int getBlastChance() {
        return this.dataTracker.get(BLAST_CHANCE);
    }

    public void setBlastChance(int chance) {
        this.dataTracker.set(BLAST_CHANCE, chance);
    }

    public int getModeChance() {
        return this.dataTracker.get(MODE_CHANCE);
    }

    public void setModeChance(int chance) {
        this.dataTracker.set(MODE_CHANCE, chance);
    }


    @Nullable
    public UUID getTongueUUID() {
        return this.dataTracker.get(TONGUE_UUID).orElse(null);
    }

    public void setTongueUUID(@Nullable UUID uniqueId) {
        this.dataTracker.set(TONGUE_UUID, Optional.ofNullable(uniqueId));
    }

    public Entity getTongue() {
        if (!getWorld().isClient) {
            UUID id = getTongueUUID();
            return id == null ? null : ((ServerWorld) getWorld()).getEntity(id);
        } else {
            int id = this.dataTracker.get(TONGUE_ID);
            return id == -1 ? null : getWorld().getEntityById(id);
        }
    }

    public void createStuckPortal() {
        if (this.getTarget() != null) {
            Vec3d to = new Vec3d(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
            this.createPortal2(this.getX() , this.getY() + 0.1,this.getZ(), to);
        }
    }


    public void createPortal2(double x, double y, double z, Vec3d to) {
        if (!getWorld().isClient && portalTarget == null) {
            Abyss_Portal_Entity portal = ModEntities.ABYSS_PORTAL.create(getWorld());
            portal.setPosition(x, y, z);
            portal.setLifespan(10000);
            portal.setEntrance(true);
            if (!getWorld().isClient) {
                getWorld().spawnEntity(portal);
            }
            portalTarget = portal;
            portal.setDestination(BlockPos.ofFloored(to.x, to.y, to.z));
            makePortalCooldown = 300;
        }
    }

    public void resetPortalLogic() {
        portalTarget = null;
    }

    public void teleportTo(Vec3d vec) {
        teleportPos = vec;
        fullyThrough = false;

    }

    private boolean checkBlocksByTentacle(float vec, float math) {
        BlockPos pos1;

        double theta = (bodyYaw) * (Math.PI / 180);
        float f = MathHelper.cos(this.getYaw() * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.getYaw() * ((float)Math.PI / 180F)) ;
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        pos1 = new BlockPos(MathHelper.floor(getX() + vec * vecX + f * math), Math.round((float) (getY() - 2)), MathHelper.floor(getZ() + vec * vecZ + f1 * math));
        return getWorld().getBlockState(pos1).blocksMovement();
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }


    @Override
    public boolean shouldEnterWater() {
        return true;
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.LEVIATHAN_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.LEVIATHAN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.LEVIATHAN_DEFEAT;
    }

    @Override
    public SoundEvent getBossMusic() {
        return this.getMeltDown() ? ModSounds.LEVIATHAN_MUSIC_2 : ModSounds.LEVIATHAN_MUSIC_1;
    }

    @Override
    protected boolean canPlayMusic() {
        if (this.getAnimation() == LEVIATHAN_PHASE2 ){
            return getAnimationTick() > 90 &&  super.canPlayMusic();
        }else{
            return super.canPlayMusic();
        }
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return LEVIATHAN_DEATH;
    }

    protected float getSoundVolume() {
        return isSilent() ? 0 : 2;
    }

    private void setPartPosition(The_Leviathan_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

//    @Override
//    public boolean isMultipartEntity() {
//        return true;
//    }

    @Override
    public Cm_Part_Entity<?>[] getParts() {
        return this.leviathanParts;
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        Cm_Part_Entity.assignPartIDs(this);
    }

    public Vec3d getTonguePosition() {
        float f1 = -MathHelper.sin(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
        float f2 = -MathHelper.sin(this.getPitch() * ((float)Math.PI / 180F));
        float f3 = MathHelper.cos(this.getYaw() * ((float)Math.PI / 180F)) * MathHelper.cos(this.getPitch() * ((float)Math.PI / 180F));
        return new Vec3d(this.getX() + f1 * 3.0, this.getY() + f2 * 3.5, this.getZ() + f3 * 3.0);

    }

    private enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE
    }

    static class LeviathanGrabAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanGrabAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = false;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            Entity weapon = entity.getTongue();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            if (entity.getAnimationTick() == 25) {
                if (target != null) {
                    if (entity.getTongue() == null) {
                        if (!entity.getWorld().isClient) {
                            The_Leviathan_Tongue_Entity segment = ModEntities.THE_LEVIATHAN_TONGUE.create(this.entity.getWorld());
                            segment.copyPositionAndRotation(this.entity);
                            segment.setPosition(entity.getTonguePosition());
                            segment.setControllerUUID(entity.getUuid());
                            segment.setMaxDuration(120);
                            entity.setTongueUUID(segment.getUuid());
                            this.entity.getWorld().spawnEntity(segment);
                        }
                    }
                }
            }
            if (this.entity.getAnimationTick() > 25 && this.entity.getAnimationTick() <= 145) {
                if (target != null && target.isAlive()) {
                    if (this.entity.distanceTo(target) < 8.5F) {
                        if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
                            if(magneticWeapon.getComingBack()) {
                                magneticWeapon.remove(RemovalReason.DISCARDED);
                            }
                        }
                        AnimationHandler.INSTANCE.sendAnimationMessage(this.entity, LEVIATHAN_GRAB_BITE);
                    }

                }
            }

            if (this.entity.getAnimationTick() > 155) {
                if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
                    magneticWeapon.remove(RemovalReason.DISCARDED);
                }
            }

        }
    }

    static class LeviathanGrabBiteAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanGrabBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.LEVIATHAN_BITE, SoundCategory.HOSTILE, 1.0f, 1.0f);
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            entity.setYaw(entity.prevYaw);
        }
        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
        }
    }

    static class LeviathanBiteAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = false;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 13 && target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }
        public void stop() {
            super.stop();
            entity.hunting_cooldown = BITE_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            entity.setModeChance(entity.getModeChance() - 1);

        }
    }

    static class LeviathanPhase2Goal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanPhase2Goal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() >= 90 && target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }
        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
        }
    }

    static class LeviathanBlastAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.ABYSS_BLAST, SoundCategory.HOSTILE, 4.0f, 1.0f);
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() < 82) {
                    entity.getLookControl().lookAt(target, 30, 90);
                }
            }
            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64) {
                if(!entity.getWorld().isClient) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST, entity.getWorld(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.headYaw + dir) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 80, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.getWorld().spawnEntity(DeathBeam);
                }
            }
        }
    }

    static class LeviathanBlastFireAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBlastFireAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.ABYSS_BLAST_ONLY_CHARGE, SoundCategory.HOSTILE, 4.0f, 1.0f);
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() < 80
                        || this.entity.getAnimationTick() > 118 && this.entity.getAnimationTick() < 125
                        || this.entity.getAnimationTick() > 163 &&  this.entity.getAnimationTick() < 170) {
                    entity.getLookControl().lookAt(target, 30, 90);
                }
            }
            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64 || this.entity.getAnimationTick() == 109 || this.entity.getAnimationTick() == 154) {
                if(!entity.getWorld().isClient) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST, entity.getWorld(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.headYaw + dir) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 28, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.getWorld().spawnEntity(DeathBeam);
                }
            }
        }
    }

    static class LeviathanTailWhipsAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTailWhipsAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = false;
            entity.CanBite = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = TAIL_WHIPS_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            entity.setModeChance(entity.getModeChance() -1);
        }
    }


    static class LeviathanRushAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanRushAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }


        public void start() {
            entity.getNavigation().stop();
            super.start();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = false;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanCrackDimension = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = RUSH_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
                if (this.entity.getAnimationTick() > 53 && this.entity.getAnimationTick() < 134) {
                    final double d0 = target.getX() - entity.getX();
                    final double d1 = target.getEyeY() - entity.getEyeY();
                    final double d2 = target.getZ() - entity.getZ();
                    final double d3 = MathHelper.sqrt((float) (d0 * d0 + d2 * d2));
                    final float targetYaw = (float) (MathHelper.atan2(d2, d0) * 180.0F / (float) Math.PI - 90.0F);
                    final float targetPitch = (float) (-(MathHelper.atan2(d1, d3) * 180.0F / (float) Math.PI));
                    entity.setPitch((entity.getPitch() + MathHelper.clamp(targetPitch - entity.getPitch(), -2, 2)));
                    if (d0 * d0 + d2 * d2 >= 9) {
                        entity.setYaw((entity.getYaw() + MathHelper.clamp(targetYaw - entity.getYaw(), -2, 2)));
                        entity.bodyYaw = entity.getYaw();
                    }
                    if (Math.abs(MathHelper.wrapDegrees(targetYaw) - MathHelper.wrapDegrees(entity.getYaw())) < 4) {
                        final double distSq = d0 * d0 + d2 * d2;
                        if (distSq < 9) {
                            entity.setYaw(entity.prevYaw);
                            entity.bodyYaw = entity.prevYaw;
                            entity.setVelocity(entity.getVelocity().multiply(0.8, 1, 0.8));
                        } else {
                            if (entity.isTouchingWater() && target.isTouchingWater()) {
                                final Vec3d vector3d = entity.getVelocity();
                                Vec3d vector3d1 = new Vec3d(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ());
                                if (vector3d1.lengthSquared() > 1.0E-7D) {
                                    vector3d1 = vector3d1.normalize().multiply(0.5D).add(vector3d.multiply(0.5D));
                                }
                                entity.setVelocity(vector3d1.x, vector3d1.y, vector3d1.z);
                            }
                            entity.getMoveControl().moveTo(target.getX(), target.getY(), target.getZ(), 1.0D);
                            entity.getNavigation().startMovingTo(target, 1.0F);
                        }
                    }
                }
            }
        }
    }

    static class LeviathanTentacleAttackGoal extends AnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleAttackGoal(The_Leviathan_Entity entity) {
            super(entity);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_R
                    || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_R
                    || animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_L
                    || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.melee_cooldown = MELEE_COOLDOWN;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);

            }
        }
    }

    static class LeviathanAbyssBlastPortalAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanAbyssBlastPortalAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = false;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = BLAST_PORTAL_HUNTING_COOLDOWN;

            entity.setModeChance(entity.getModeChance() +1);

        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
                double d0 = Math.min(target.getY(), entity.getY()) - 50;
                double d1 = Math.max(target.getY(), entity.getY()) + 3D;
                float f = (float) MathHelper.atan2(target.getZ() - entity.getZ(), target.getX() - entity.getX());
                if (this.entity.getAnimationTick() == 56) {
                    for (int l = 0; l < 9; ++l) {
                        int j = (int) (5f * l);
                        double randomNearbyX = target.getX() + (entity.random.nextGaussian() * 12.0D);
                        double randomNearbyZ = target.getZ() + (entity.random.nextGaussian() * 12.0D);

                        this.spawnUnderPortal(randomNearbyX, randomNearbyZ, d0, d1, f, j);
                        //this.spawnUpperPortal(randomNearbyX, randomNearbyZ, d1, f, j);

                    }
                }
                if(this.entity.getAnimationTick() == 56 || this.entity.getAnimationTick() == 76 || this.entity.getAnimationTick() == 96) {
                    this.spawnUnderPortal(target.getX(), target.getZ(), d0, d1, f, 0);
                }
            }
        }
        private void spawnUnderPortal(double x, double z, double minY, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.down();
                BlockState blockstate = entity.getWorld().getBlockState(blockpos1);
                if (blockstate.isSideSolidFullSquare(entity.getWorld(), blockpos1, Direction.UP)) {
                    if (!entity.getWorld().isAir(blockpos)) {
                        BlockState blockstate1 = entity.getWorld().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.getWorld(), blockpos);
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
                entity.getWorld().spawnEntity(new Abyss_Blast_Portal_Entity(entity.getWorld(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage,entity));
            }
        }

        private void spawnUpperPortal(double x, double z, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.up();
                BlockState blockstate = entity.getWorld().getBlockState(blockpos1);
                if (blockstate.isSideSolidFullSquare(entity.getWorld(), blockpos1, Direction.DOWN)) {
                    if (!entity.getWorld().isAir(blockpos)) {
                        BlockState blockstate1 = entity.getWorld().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.getWorld(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.getMax(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.up();
            } while (blockpos.getY() < Math.min(entity.getWorld().getTopY(), entity.getBlockY() + 100) && !entity.getWorld().getBlockState(blockpos).isSolid());

            if (flag) {
                entity.getWorld().spawnEntity(new Abyss_Blast_Portal_Entity(entity.getWorld(), x, (double) blockpos.getY() + d0 + 0.5F, z, rotation, delay,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage, entity));
            }
        }
    }



    static class LeviathanAbyssDimensionAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanAbyssDimensionAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanCrackDimension = false;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 0);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = CRACK_HUNTING_COOLDOWN;
            entity.setModeChance(entity.getModeChance() - 1);
        }

        public void tick() {
            if (entity.getAnimationTick() == 24) {
                if (!entity.getWorld().isClient ) {
                    double theta = (entity.bodyYaw) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    Dimensional_Rift_Entity portal = new Dimensional_Rift_Entity(entity.getWorld(),
                            entity.getX() + vecX * 12F,
                            entity.getEyeY(),
                            entity.getZ() + vecZ * 12F, entity);
                    portal.setStage(1);
                    portal.setLifespan(600);
                    if (!entity.getWorld().isClient) {
                        entity.getWorld().spawnEntity(portal);
                    }
                }

            }
            Dimensional_Rift_Entity rift = getClosestDimensionalRift();
            if(rift !=null){
                entity.getLookControl().lookAt(rift, 30, 90);
            }
        }

        private Dimensional_Rift_Entity getClosestDimensionalRift(){
            List<Dimensional_Rift_Entity> list = entity.getWorld().getNonSpectatingEntities(Dimensional_Rift_Entity.class, entity.getBoundingBox().expand(15, 15, 15));
            Dimensional_Rift_Entity closest = null;
            if(!list.isEmpty()){
                for(Dimensional_Rift_Entity entity : list){
                    if((closest == null || closest.distanceTo(entity) > entity.distanceTo(entity))){
                        closest = entity;
                    }
                }
            }
            return closest;
        }
    }

    static class LeviathanTentacleHoldAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleHoldAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = false;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            entity.setModeChance(entity.getModeChance() -1);
        }
    }

    static class LeviathanTentacleHoldBlastAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleHoldBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = true;
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.ABYSS_BLAST, SoundCategory.HOSTILE, 4.0f, 1.0f);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }
        @Override
        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }

            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64) {
                if(!entity.getWorld().isClient) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST, entity.getWorld(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.headYaw + dir) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 80, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.getWorld().spawnEntity(DeathBeam);
                }
            }
        }
    }


    static class LeviathanMineAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanMineAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = MINE_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);

                float f = (float) MathHelper.atan2(target.getZ() - entity.getZ(), target.getX() - entity.getX());
                if (this.entity.getAnimationTick() == 31) {
                    for (int l = 0; l < 35; ++l) {
                        int j = (int) (2f * l);
                        double randomNearbyX = target.getX() + (entity.random.nextGaussian() * 12.0D);
                        double randomNearbyY = target.getY() + (entity.random.nextGaussian() * 8.0D);
                        double randomNearbyZ = target.getZ() + (entity.random.nextGaussian() * 12.0D);

                        this.spawnMines(randomNearbyX,randomNearbyY, randomNearbyZ, f, j);
                    }
                }
            }
            entity.setModeChance(entity.getModeChance() -1);
        }

        private void spawnMines(double x, double y, double z, float rotation, int delay) {
            Abyss_Mine_Entity mine = new Abyss_Mine_Entity(entity.getWorld(), x, y, z, rotation, delay, entity);
            if (mine.getWorld().isSpaceEmpty(mine)) {
                entity.getWorld().spawnEntity(mine);
            }

        }
    }

    static class LeviathanStunGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanStunGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() > 28) {
                    entity.getLookControl().lookAt(target, 30, 90);
                }
            }
        }
    }

    class LeviathanAttackGoal extends Goal {
        private final The_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final int huntingTime = 0;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 160;
        private float circleDistance = 18;
        private boolean clockwise = false;

        public LeviathanAttackGoal(The_Leviathan_Entity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAnimation() == NO_ANIMATION;
        }

        public boolean shouldContinue() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start(){
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 36 + this.mob.random.nextInt(20);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAttacking(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 36 + this.mob.random.nextInt(20);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAttacking(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);

                    if (huntingTime >= this.mob.hunting_cooldown) {
                        int i = Math.max(this.mob.getModeChance(), 2);
                        if(this.mob.random.nextInt(i) == 0){
                            this.mob.mode = AttackMode.RANGE;
                        }else{
                            this.mob.mode = AttackMode.MELEE;
                        }
                    }
                    if (this.mob.getRandom().nextFloat() * 100.0F < 12f && this.mob.squaredDistanceTo(target) <= 49.0D && this.mob.melee_cooldown <= 0) {
                        Animation animation = getRandomTantalcleStrike(this.mob.random);
                        this.mob.setAnimation(animation);
                    }

                }else if (this.mob.mode == AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.CanAbyss_Blast_Portal) {
                        this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_PORTAL);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < (2f * this.mob.getBlastChance()) && this.mob.CanAbyss_Blast) {
                        if(this.mob.random.nextInt(2) == 0) {
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST);
                        }else{
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_FIRE);
                        }
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 8f && this.mob.squaredDistanceTo(target) >= 700.0D && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_GRAB);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 4f && this.mob.squaredDistanceTo(target) < 900. && this.mob.squaredDistanceTo(target) >= 49.0D && this.mob.CanRush) {
                        this.mob.setAnimation(LEVIATHAN_RUSH);
                    }
                }else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().startMovingTo(target, 1.0D);
                    MeleeModeTime++;
                    this.mob.getLookControl().lookAt(target, 30, 90);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        this.mob.mode = AttackMode.RANGE;
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 15f && this.mob.squaredDistanceTo(target) < 49.0D && this.mob.CanTailWhips) {
                        this.mob.setAnimation(LEVIATHAN_TAIL_WHIPS);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 8f && this.mob.squaredDistanceTo(target) < 36.0D && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_TENTACLE_HOLD);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 20f && this.mob.squaredDistanceTo(target) <= 30.0D && this.mob.CanBite ) {
                        this.mob.setAnimation(LEVIATHAN_BITE);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.CanCrackDimension && this.mob.squaredDistanceTo(target) < 256 && this.mob.squaredDistanceTo(target) > 49.0D) {
                        this.mob.setAnimation(LEVIATHAN_BREAK_DIMENSION);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 5f && this.mob.CanMine && this.mob.squaredDistanceTo(target) < 256 && this.mob.squaredDistanceTo(target) > 100.0D) {
                        this.mob.setAnimation(LEVIATHAN_MINE);
                    }
                }

            }
        }
    }

    static class LeviathanMoveController extends MoveControl {
        private final The_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private  int stillTicks = 0;
        public LeviathanMoveController(The_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
            super(entity);
            this.entity = entity;
            this.speedMulti = speedMulti;
            this.ySpeedMod = ySpeedMod;
            this.yawLimit = yawLimit;
        }

        public void tick() {
            if (this.entity.isTouchingWater() && this.entity.getAnimation() == NO_ANIMATION) {
                if (Math.abs(this.entity.prevX - this.entity.getX()) < 0.01F && Math.abs(this.entity.prevY - this.entity.getY()) < 0.01F && Math.abs(this.entity.prevZ - this.entity.getZ()) < 0.01F) {
                    stillTicks++;
                } else {
                    stillTicks = 0;
                }
                if (stillTicks > 40){
                    this.entity.setVelocity(this.entity.getVelocity().add(0.0D, -0.005D, 0.0D));
                }
            }
            if (entity.shouldStopMoving()) {
                this.entity.setMovementSpeed(0.0F);
                return;
            }
            if (this.state == State.MOVE_TO && !this.entity.getNavigation().isIdle()) {
                double lvt_1_1_ = this.targetX - this.entity.getX();
                double lvt_3_1_ = this.targetY - this.entity.getY();
                double lvt_5_1_ = this.targetZ - this.entity.getZ();
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7D) {
                    this.entity.setForwardSpeed(0.0F);
                } else {
                    float lvt_9_1_ = (float) (MathHelper.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                    this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), lvt_9_1_, yawLimit));
                    this.entity.bodyYaw = this.entity.getYaw();
                    this.entity.headYaw = this.entity.getYaw();
                    float lvt_10_1_ = (float) (this.speed * speedMulti * 3 * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                    if (this.entity.isTouchingWater()) {
                        if(lvt_3_1_ > 0 && entity.horizontalCollision){
                            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, 0.08F, 0.0D));
                        }else{
                            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, (double) this.entity.getMovementSpeed() * lvt_3_1_ * 0.6D * ySpeedMod, 0.0D));
                        }
                        this.entity.setMovementSpeed(lvt_10_1_ * 0.02F);
                        float lvt_11_1_ = -((float) (MathHelper.atan2(lvt_3_1_, MathHelper.sqrt((float) (lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_))) * 57.2957763671875D));
                        lvt_11_1_ = MathHelper.clamp(MathHelper.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                        this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), lvt_11_1_, 5.0F));
                        float lvt_12_1_ = MathHelper.cos(this.entity.getPitch() * 0.017453292F);
                        float lvt_13_1_ = MathHelper.sin(this.entity.getPitch() * 0.017453292F);
                        this.entity.forwardSpeed = lvt_12_1_ * lvt_10_1_;
                        this.entity.upwardSpeed = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.entity.setMovementSpeed(lvt_10_1_ * 0.1F);
                    }

                }
            } else {
                this.entity.setMovementSpeed(0.0F);
                this.entity.setSidewaysSpeed(0.0F);
                this.entity.setUpwardSpeed(0.0F);
                this.entity.setForwardSpeed(0.0F);
            }
        }
    }

}