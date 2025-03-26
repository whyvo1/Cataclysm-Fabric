package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus;

import com.github.l_ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.IHoldEntity;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Maledictus_Entity extends IABoss_monster implements IHoldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState shotAnimationState = new AnimationState();
    public AnimationState flyingshotAnimationState = new AnimationState();
    public AnimationState fallloopAnimationState = new AnimationState();
    public AnimationState falllendAnimationState = new AnimationState();
    public AnimationState masseffectAnimationState = new AnimationState();
    public AnimationState flyingsmash1AnimationState = new AnimationState();
    public AnimationState flyingsmash2AnimationState = new AnimationState();
    public AnimationState BackstepAnimationState = new AnimationState();
    public AnimationState BackstepRushAnimationState = new AnimationState();
    public AnimationState BackstepRushNobackstepAnimationState = new AnimationState();
    public AnimationState dash1AnimationState = new AnimationState();
    public AnimationState dash1NobackstepAnmationState = new AnimationState();
    public AnimationState dash2AnmationState = new AnimationState();
    public AnimationState dash2NobackstepAnmationState = new AnimationState();
    public AnimationState dash3AnimationState = new AnimationState();
    public AnimationState spinslashesAnimationState = new AnimationState();
    public AnimationState combofirstAnimationState = new AnimationState();
    public AnimationState combofirstendAnimationState = new AnimationState();
    public AnimationState combosecondAnimationState = new AnimationState();
    public AnimationState uppercutleftAnimationState = new AnimationState();
    public AnimationState uppercutrightAnimationState = new AnimationState();
    public AnimationState flyinghalberdsmash1AnimationState = new AnimationState();
    public AnimationState flyinghalberdsmash2AnimationState = new AnimationState();
    public AnimationState radagonAnimationState = new AnimationState();
    public AnimationState halberdswingAnimationState = new AnimationState();
    public AnimationState grab_startAnimationState = new AnimationState();
    public AnimationState grab_loopAnimationState = new AnimationState();
    public AnimationState grab_failAnimationState = new AnimationState();
    public AnimationState grab_successAnimationState = new AnimationState();
    public AnimationState grab_success_loopAnimationState = new AnimationState();
    public AnimationState grab_success_endAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();


    private boolean combo;
    private boolean grab;
    private int rageTicks;
    private int masseffect_cooldown = 0;
    private int flyattack_cooldown = 0;
    private int charge_cooldown = 0;
    private int uppercut_cooldown = 0;
    private int spin_cooldown = 0;
    private int radagon_cooldown = 0;
    private int spear_swing_cooldown = 0;
    private int grab_cooldown = 0;
    public static final int MASSEFFECT_COOLDOWN = 150;
    public static final int FLYATTACK_COOLDOWN = 100;
    public static final int CHARGE_COOLDOWN = 80;
    public static final int UPPERCUT_COOLDOWN = 80;
    public static final int SPIN_COOLDOWN = 100;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    public static final int RADAGON_COOLDOWN = 250;
    public static final int SPEAR_SWING_COOLDOWN = 100;
    public static final int GRAB_COOLDOWN = 300;
    private int timeWithoutTarget;
    private int destroyBlocksTick;
    private static final TrackedData<Boolean> FLYING = DataTracker.registerData(Maledictus_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public static final TrackedData<Integer> RAGE = DataTracker.registerData(Maledictus_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    public static final TrackedData<Integer> WEAPON = DataTracker.registerData(Maledictus_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final TrackedData<BlockPos> TOMBSTONE_POS = DataTracker.registerData(Maledictus_Entity.class, TrackedDataHandlerRegistry.BLOCK_POS);
    private static final TrackedData<Direction> TOMBSTONE_DIRECTION = DataTracker.registerData(Maledictus_Entity.class, TrackedDataHandlerRegistry.FACING);

    private final CustomBossBar bossEvent1 = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.MALEDICTUS, true);
    private final CustomBossBar bossEvent2 = new CustomBossBar(Text.empty(), CustomBossBarStyles.MALEDICTUS_RAGE, false);

    public Maledictus_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 500;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.MaledictusHealthMultiplier, CMConfig.MaledictusDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new AdvancedHurtByTargetGoal(this));
        this.targetSelector.add(2, new EntityAINearestTarget3D<>(this, PlayerEntity.class, true));
        this.goalSelector.add(3, new InternalMoveGoal(this, false, 1.0D));

        //spin slashes
        this.goalSelector.add(1, new MaledictusSpinSlashes(this, 0, 18, 0, 68, 15, 23, 29,15,29,6.5F,0,0,24));

        //halberd_swing
        this.goalSelector.add(1, new InternalAttackGoal(this,0,27,0,50,22,3.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 32f && Maledictus_Entity.this.spear_swing_cooldown <= 0;

            }
            @Override
            public void start() {
                super.start();
                Maledictus_Entity.this.setWeapon(2);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.spear_swing_cooldown = SPEAR_SWING_COOLDOWN;
                Maledictus_Entity.this.setWeapon(0);
            }
        });
        //grab start
        this.goalSelector.add(1, new MaledictusGrabGoal(this, 0, 28, 29, 26, 24, 9F, 3,3,25F));

        //grab_loop
        this.goalSelector.add(1, new MaledictusGrabState(this,29,29,30,15,0,3,3));

        //grab_fail
        this.goalSelector.add(0, new InternalStateGoal(this,30,30,0,30,0){
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.setWeapon(0);
            }
        });

        //grab_success_start
        this.goalSelector.add(0, new MaledictusSuccessState(this, 31, 31, 32, 60, 0, 30,3,3,2));

        //grab_success_loop
        this.goalSelector.add(1, new MaledictusfallingState(this, 32, 32,33,100, 0,3,3));

        //grab_success_end
        this.goalSelector.add(0, new MaledictusfallingState(this, 33, 33, 0, 35,0,3,0));



        //combo first
        this.goalSelector.add(1, new InternalAttackGoal(this,0,19,20,27,10,6F){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 24 && target !=null && this.entity.distanceTo(target) >= 1.75D ;
            }

            @Override
            public boolean shouldContinue() {
                return super.shouldContinue() && !combo;
            }

            @Override
            public void tick() {
                super.tick();
                if (entity.attackTicks == 8) {
                    float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                    float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                    entity.addVelocity(f1 * 1.35, 0, f2 * 1.35);
                }
            }
            @Override
            public void stop() {
                if (combo) {
                    entity.setAttackState(21);
                    combo = false;
                } else {
                    super.stop();
                }
            }
        });


        //uppercut
        this.goalSelector.add(1, new Uppercut(this, 0, 22, 0, 60, 16, 3.0F,32f));

        this.goalSelector.add(1, new Uppercut(this, 0, 23, 0, 60, 16, 3.0F,32F));


        //combo first end
        this.goalSelector.add(0, new InternalStateGoal(this,20,20,0,13,0));

        //combo second end
        this.goalSelector.add(0, new InternalStateGoal(this,21,21,0,45,8){
            @Override
            public void tick() {
                super.tick();
                if (entity.attackTicks == 8) {
                    float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                    float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                    entity.addVelocity(f1 * 1.5, 0, f2 * 1.5);
                }
            }
        });

        //swing
        this.goalSelector.add(1, new Maledictus_Swing(this, 0, 1, 0, 44, 25, 6.5F, 35f, 20F));


        //bow
        this.goalSelector.add(1, new Maledictus_Bow(this, 0, 2, 0, 45, 29, 8F, 35f, 29, 16F));

        //flying bow
        this.goalSelector.add(1, new Maledictus_Flying_Bow(this, 0, 3, 4, 68, 50, 40f, 50,35F));

        //fall_loop
        this.goalSelector.add(1, new MaledictusfallingState(this, 4, 4,5,100, 100,1,0));

        //fall_end
        this.goalSelector.add(0, new MaledictusfallingState(this, 5, 5, 0, 27,0,0,0));

        //mass_effect
        this.goalSelector.add(1, new InternalAttackGoal(this,0,7,0,66,28,4.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 7f * Maledictus_Entity.this.getRageMeter() && Maledictus_Entity.this.masseffect_cooldown <= 0;
            }
            @Override
            public void tick() {
                super.tick();
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.masseffect_cooldown = MASSEFFECT_COOLDOWN;
            }
        });


        //flying strike
        this.goalSelector.add(1, new Maledictus_Flying_Smash(this, 0, 8, 9, 100, 100, 30f, 56,0,0,17F,0.125));

        this.goalSelector.add(0, new MaledictusfallingState(this, 9, 9, 0, 27,0,0,0));


        //halberd flying strike
        this.goalSelector.add(1, new Maledictus_Flying_Smash(this, 0, 24, 25, 100, 100, 30f, 51,2,2,17F,0.145));

        this.goalSelector.add(0, new MaledictusfallingState(this, 25, 25, 0, 75,0,2,0));



        //radagon
        this.goalSelector.add(1, new InternalAttackGoal(this,0,26,0,73,43,13F){
            @Override
            public boolean canStart() {
                if(Maledictus_Entity.this.isQuarterHealth()){
                    return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 35f && Maledictus_Entity.this.radagon_cooldown <= 0;
                }else if(Maledictus_Entity.this.isHalfHealth()){
                    return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 25f && Maledictus_Entity.this.radagon_cooldown <= 0;
                }
                return false;
            }
            @Override
            public void start() {
                super.start();
                Maledictus_Entity.this.setWeapon(2);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.radagon_cooldown = RADAGON_COOLDOWN;
                Maledictus_Entity.this.setWeapon(0);
            }
        });


        //backstep
        this.goalSelector.add(1, new InternalAttackGoal(this,0,10,0,15,15,4.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 18f && Maledictus_Entity.this.charge_cooldown <= 0;
            }
            @Override
            public void start() {
                super.start();
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(Maledictus_Entity.this.getYaw() + 90);
                Vec3d m = Maledictus_Entity.this.getVelocity().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                Maledictus_Entity.this.playSound(ModSounds.MALEDICTUS_JUMP, 1F, 1.0f);
                Maledictus_Entity.this.setVelocity(m.x, 0.4, m.z);
            }

            @Override
            public void stop() {
                if(Maledictus_Entity.this.isHalfHealth()) {
                    this.entity.setAttackState(12);
                }else{
                    this.entity.setAttackState(11);
                }
            }
        });


        //backstep-charge-backstep
        this.goalSelector.add(0, new MaledictusChargeState(this, 11, 11, 0, 65, 18, 31, 24,33,2,0,0));

        //backstep-charge-nobackstep
        this.goalSelector.add(0, new MaledictusChargeState(this, 12, 12, 0, 55, 18, 31, 24,0,2,0,1));

        //only charge
        this.goalSelector.add(1, new MaledictusChargeGoal(this, 0, 19, 30, 24, 4.5F, 13F, 2,0,18f));

        //dash 2-backstep
        this.goalSelector.add(0, new MaledictusChargeState(this, 15, 15, 0, 55, 10, 25, 16,27,2,0,2));

        //dash 2-nobackstep
        this.goalSelector.add(0, new MaledictusChargeState(this, 16, 16, 0, 40, 10, 25, 16,0,2,0,2));

        //dash 3
        this.goalSelector.add(0, new MaledictusChargeState(this, 17, 17, 0, 58, 10, 28, 16,30,2,0,3));

    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public static DefaultAttributeContainer.Builder maledictus() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 13)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 420)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.25F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }



    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        double range = calculateRange(source);
        if (range > CMConfig.MaledictusLongRangelimit * CMConfig.MaledictusLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if ((this.getAttackState() == 31 || this.getAttackState() == 32 || this.getAttackState() == 33) && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }

        return super.damage(source, damage);
    }

    public float DamageCap() {
        return (float) CMConfig.MaledictusDamageCap;
    }

    public int DamageTime() {
        return CMConfig.MaledictusDamageTime;
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public boolean handleFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "swing" -> this.swingAnimationState;
            case "shoot" -> this.shotAnimationState;
            case "death" -> this.deathAnimationState;
            case "flying_shoot" -> this.flyingshotAnimationState;
            case "idle" -> this.idleAnimationState;
            case "fall_loop" -> this.fallloopAnimationState;
            case "fall_end" -> this.falllendAnimationState;
            case "mass_effect" -> this.masseffectAnimationState;
            case "flying_smash_1" -> this.flyingsmash1AnimationState;
            case "flying_smash_2" -> this.flyingsmash2AnimationState;
            case "back_step" -> this.BackstepAnimationState;
            case "back_step_dash" -> this.BackstepRushAnimationState;
            case "back_step_dash_no_back_step" -> this.BackstepRushNobackstepAnimationState;
            case "dash" -> this.dash1AnimationState;
            case "dash_no_back_step" -> this.dash1NobackstepAnmationState;
            case "dash2" -> this.dash2AnmationState;
            case "dash2_no_back_step" -> this.dash2NobackstepAnmationState;
            case "dash3" -> this.dash3AnimationState;
            case "spin_slashes" -> this.spinslashesAnimationState;
            case "combo_first" -> this.combofirstAnimationState;
            case "combo_first_end" -> this.combofirstendAnimationState;
            case "combo_second" -> this.combosecondAnimationState;
            case "uppercut_right" -> this.uppercutrightAnimationState;
            case "uppercut_left" -> this.uppercutleftAnimationState;
            case "flying_halberd_smash_1" -> this.flyinghalberdsmash1AnimationState;
            case "flying_halberd_smash_2" -> this.flyinghalberdsmash2AnimationState;
            case "radagon" -> this.radagonAnimationState;
            case "halberd_swing" -> this.halberdswingAnimationState;
            case "grab_start" -> this.grab_startAnimationState;
            case "grab_loop" -> this.grab_loopAnimationState;
            case "grab_fail" -> this.grab_failAnimationState;
            case "grab_success" -> this.grab_successAnimationState;
            case "grab_success_loop" -> this.grab_success_loopAnimationState;
            case "grab_success_end" -> this.grab_success_endAnimationState;
            default -> new AnimationState();
        };
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(TOMBSTONE_POS, BlockPos.ORIGIN);
        p_326229_.add(TOMBSTONE_DIRECTION, Direction.NORTH);
        p_326229_.add(WEAPON, 0);
        p_326229_.add(FLYING, false);
        p_326229_.add(RAGE, 0);
    }

    public int getWeapon() {
        return this.dataTracker.get(WEAPON);
    }

    public void setWeapon(int weapon) {
        this.dataTracker.set(WEAPON, weapon);
    }


    public boolean isFlying() {
        return this.dataTracker.get(FLYING);
    }

    public void setFlying(boolean flying) {
        this.dataTracker.set(FLYING, flying);
    }


    BlockPos getTombstonePos() {
        return this.dataTracker.get(TOMBSTONE_POS);
    }

    public void setTombstonePos(BlockPos p_30220_) {
        this.dataTracker.set(TOMBSTONE_POS, p_30220_);
    }

    public Direction getTombstoneDirection() {
        return this.dataTracker.get(TOMBSTONE_DIRECTION);
    }


    public void setTombstoneDirection(Direction p_30220_) {
        this.dataTracker.set(TOMBSTONE_DIRECTION, p_30220_);
    }


    public int getRageMeter() {
        return this.dataTracker.get(RAGE);
    }

    public void setRageMeter(int Rage) {
        this.dataTracker.set(RAGE, Rage);
    }

    public void travel(Vec3d travelVector) {
        super.travel(travelVector);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

//    @Override
//    public boolean canRiderInteract() {
//        return true;
//    }

    public void updatePassengerPosition(Entity passenger, PositionUpdater moveFunc) {
        float f1 = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f2 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        Vec3d vec3 = this.getPassengerRidingPos(passenger);
        Vec3d vec31 = passenger.getVehicleAttachmentPos(this);

        double px = vec3.x - vec31.x + 0.5F * vecX + f1 * -0.6;
        double pz = vec3.z - vec31.z + 0.5F * vecZ + f2 * -0.6;

        double y = this.getY()  + 2.0D;
        if (hasPassenger(passenger)) {
            if(this.getAttackState() == 33){
                y = this.getY() - 0.2F * MathHelper.clamp(0, 0, 23);
                if(this.attackTicks == 23) {
                    passenger.stopRiding();
                }
            }

        }
        moveFunc.accept(passenger, px, y, pz);
    }


    public boolean shouldRiderSit() {
        return false;
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.swingAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.shotAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.flyingshotAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.fallloopAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.falllendAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.masseffectAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash1AnimationState.startIfNotRunning(this.age);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash2AnimationState.startIfNotRunning(this.age);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.BackstepAnimationState.startIfNotRunning(this.age);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.BackstepRushAnimationState.startIfNotRunning(this.age);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.BackstepRushNobackstepAnimationState.startIfNotRunning(this.age);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.dash1AnimationState.startIfNotRunning(this.age);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.dash1NobackstepAnmationState.startIfNotRunning(this.age);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.dash2AnmationState.startIfNotRunning(this.age);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.dash2NobackstepAnmationState.startIfNotRunning(this.age);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.dash3AnimationState.startIfNotRunning(this.age);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.spinslashesAnimationState.startIfNotRunning(this.age);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.combofirstAnimationState.startIfNotRunning(this.age);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.combofirstendAnimationState.startIfNotRunning(this.age);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.combosecondAnimationState.startIfNotRunning(this.age);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.uppercutrightAnimationState.startIfNotRunning(this.age);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.uppercutleftAnimationState.startIfNotRunning(this.age);
                    }
                    case 24 -> {
                        this.stopAllAnimationStates();
                        this.flyinghalberdsmash1AnimationState.startIfNotRunning(this.age);
                    }
                    case 25 -> {
                        this.stopAllAnimationStates();
                        this.flyinghalberdsmash2AnimationState.startIfNotRunning(this.age);
                    }
                    case 26 -> {
                        this.stopAllAnimationStates();
                        this.radagonAnimationState.startIfNotRunning(this.age);
                    }
                    case 27 -> {
                        this.stopAllAnimationStates();
                        this.halberdswingAnimationState.startIfNotRunning(this.age);
                    }
                    case 28 -> {
                        this.stopAllAnimationStates();
                        this.grab_startAnimationState.startIfNotRunning(this.age);
                    }
                    case 29 -> {
                        this.stopAllAnimationStates();
                        this.grab_loopAnimationState.startIfNotRunning(this.age);
                    }
                    case 30 -> {
                        this.stopAllAnimationStates();
                        this.grab_failAnimationState.startIfNotRunning(this.age);
                    }
                    case 31 -> {
                        this.stopAllAnimationStates();
                        this.grab_successAnimationState.startIfNotRunning(this.age);
                    }
                    case 32 -> {
                        this.stopAllAnimationStates();
                        this.grab_success_loopAnimationState.startIfNotRunning(this.age);
                    }

                    case 33 -> {
                        this.stopAllAnimationStates();
                        this.grab_success_endAnimationState.startIfNotRunning(this.age);
                    }

                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingAnimationState.stop();
        this.shotAnimationState.stop();
        this.deathAnimationState.stop();
        this.flyingshotAnimationState.stop();
        this.fallloopAnimationState.stop();
        this.falllendAnimationState.stop();
        this.masseffectAnimationState.stop();
        this.flyingsmash1AnimationState.stop();
        this.flyingsmash2AnimationState.stop();
        this.BackstepAnimationState.stop();
        this.BackstepRushAnimationState.stop();
        this.BackstepRushNobackstepAnimationState.stop();
        this.dash1AnimationState.stop();
        this.dash1NobackstepAnmationState.stop();
        this.dash2AnmationState.stop();
        this.dash2NobackstepAnmationState.stop();
        this.dash3AnimationState.stop();
        this.spinslashesAnimationState.stop();
        this.combofirstAnimationState.stop();
        this.combofirstendAnimationState.stop();
        this.combosecondAnimationState.stop();
        this.uppercutrightAnimationState.stop();
        this.uppercutleftAnimationState.stop();
        this.flyinghalberdsmash1AnimationState.stop();
        this.flyinghalberdsmash2AnimationState.stop();
        this.radagonAnimationState.stop();
        this.halberdswingAnimationState.stop();

        this.grab_startAnimationState.stop();

        this.grab_loopAnimationState.stop();

        this.grab_failAnimationState.stop();

        this.grab_successAnimationState.stop();


        this.grab_success_loopAnimationState.stop();

        this.grab_success_endAnimationState.stop();


    }

    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(6);
        this.setFlying(false);
    }

    public int deathtimer() {
        return 60;
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (!this.getWorld().isClient) {
            if(this.getTombstonePos() != BlockPos.ORIGIN) {
                BlockState block = ModBlocks.CURSED_TOMBSTONE.getDefaultState();
                if (this.getTombstoneDirection() == Direction.UP || this.getTombstoneDirection() == Direction.DOWN) {
                    this.getWorld().setBlockState(this.getTombstonePos(), block.with(Cursed_Tombstone_Block.FACING, Direction.NORTH));
                } else {
                    this.getWorld().setBlockState(this.getTombstonePos(), block.with(Cursed_Tombstone_Block.FACING, this.getTombstoneDirection()));
                }
            }
        }
    }


    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("TombstonePosX", this.getTombstonePos().getX());
        compound.putInt("TombstonePosY", this.getTombstonePos().getY());
        compound.putInt("TombstonePosZ", this.getTombstonePos().getZ());
        compound.putByte("Tombstone_Direction", (byte)this.getTombstoneDirection().getId());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        int i = compound.getInt("TombstonePosX");
        int j = compound.getInt("TombstonePosY");
        int k = compound.getInt("TombstonePosZ");
        this.setTombstoneDirection(Direction.byId(compound.getByte("Tombstone_Direction")));
        this.setTombstonePos(new BlockPos(i, j, k));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_30153_, LocalDifficulty p_30154_, SpawnReason p_30155_, @Nullable EntityData p_30156_) {
        this.setTombstonePos(this.getBlockPos());
        this.setTombstoneDirection(Direction.SOUTH);
        return super.initialize(p_30153_, p_30154_, p_30155_, p_30156_);
    }


    public void tick() {
        super.tick();

        if (!this.getPassengerList().isEmpty() && this.getPassengerList().getFirst().isSneaking() && (this.getAttackState() == 31 || this.getAttackState() == 32 || this.getAttackState() == 33 ) ) {
            this.getPassengerList().getFirst().setSneaking(false);
        }

        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.getAttackState() == 0, this.age);
        } else {
            if (rageTicks > 0) {
                rageTicks--;
            } else {
                if (this.getRageMeter() > 0) {
                    setRageMeter(this.getRageMeter() - 1);
                    rageTicks = 200;
                }
            }
        }
        this.bossEvent1.setPercent(this.getHealth() / this.getMaxHealth());
        this.bossEvent2.setPercent((float) this.getRageMeter() / 5);
        if (masseffect_cooldown > 0) masseffect_cooldown--;
        if (flyattack_cooldown > 0) flyattack_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;
        if (uppercut_cooldown > 0) uppercut_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;
        if (radagon_cooldown > 0) radagon_cooldown--;
        if (spear_swing_cooldown > 0) spear_swing_cooldown--;

        if (grab_cooldown > 0) grab_cooldown--;



        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (this.isFlying()) {
                this.setNoGravity(!this.isOnGround());
            } else {
                this.setNoGravity(false);
            }

            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAttackState() == 0 && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.MaledictusNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.MaledictusNatureHealing);
                    }
                }
            }
        }
        blockbreak();
    }

    public boolean isHalfHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.5F;
    }

    public boolean isQuarterHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.25F;
    }

    private float DMG() {
        return (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * this.getRageMeter() * 0.2f);
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.getAttackState() == 1) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 25) {
                AreaAttack(5.5f, 5.5f, 270, 1, (float) CMConfig.MaledictusSmashHpDamage, 200, false,false);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 20);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
            }
        }

        if (this.getAttackState() == 2) {
            if (this.attackTicks == 8) {
                this.playSound(ModSounds.MALEDICTUS_BOW_PULL, 1F, 1.0f);
            }
        }

        if (this.getAttackState() == 3) {
            flyingdestroy();
            if (this.attackTicks == 6) {
                this.playSound(ModSounds.MALEDICTUS_LEAP, 1F, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.MALEDICTUS_BOW_PULL, 1F, 1.0f);
            }
        }

        if (this.getAttackState() == 4) {
            if (this.isOnGround() || !this.getBlockStateAtPos().getFluidState().isEmpty()) {
                this.setAttackState(5);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 30) {
                if (this.getWorld().isClient) {
                    for (int i = 0; i < 20 + random.nextInt(2); ++i) {
                        float f2 = this.random.nextFloat() * ((float) Math.PI * 2F);
                        float f3 = MathHelper.sqrt(this.random.nextFloat()) * this.getWidth() * 0.5F;
                        double d0 = this.getX() + (double) (MathHelper.cos(f2) * f3);
                        double d4 = this.getZ() + (double) (MathHelper.sin(f2) * f3);
                        this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, d0, this.getY() + (double) this.getHeight() * 0.6 + i * 0.05D, d4, 0.0D, 0.1D, 0.0D);
                    }
                }
            }
        }
        if (this.getAttackState() == 7) {
            if (this.attackTicks == 10) {
                masseffectParticle(5.0f);
            }
            if (this.attackTicks == 15) {
                masseffectParticle(7.0f);
            }

            if (this.attackTicks == 20) {
                masseffectParticle(9.0f);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.MALEDICTUS_BATTLE_CRY, 1F, 1.0f);
            }
            if (this.attackTicks == 32) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 34) {
                this.playSound(ModSounds.EXPLOSION, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.2f, 0, 40);
                this.setRageMeter(0);
                if (this.getWorld().isClient) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
                    float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
                    double theta = (bodyYaw) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 30, 86, 236, 204, 1.0f, 85, false, 0), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(7.0D))) {
                    if (!isTeammate(entity) && entity != this) {
                        entity.damage(CMDamageTypes.causeMaledictioSoulDamage(this), (float) (DMG() * 1.5F + Math.min(DMG() * 1.5F, entity.getMaxHealth() * CMConfig.MaledictusAOEHpDamage)));
                    }
                }
            }
            if (this.attackTicks > 34 && this.attackTicks < 44) {
                Sphereparticle(0.3f, 1.0f, 4F);
            }
        }
        if (this.getAttackState() == 8) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_LEAP, 1F, 1.0f);
            }
            if (this.attackTicks >= 65) {
                if (this.isOnGround() || !this.getBlockStateAtPos().getFluidState().isEmpty()) {
                    this.setAttackState(9);
                }
            }
        }

        if (this.getAttackState() == 9) {
            flyingdestroy();
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.EXPLOSION, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.3f, 0, 40);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 50f);
                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(3.5D))) {
                    if (!isTeammate(entity) && entity != this) {
                        boolean flag = entity.damage(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }

                    }
                }
            }
            for (int i = 8, j = 2; i <= 16; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    ShieldSmashDamage(2, j, 4f, 2.5f, 1, (float) CMConfig.MaledictusShockWaveHpDamage, 0.05F);
                }
            }
        }

        if (this.getAttackState() == 11 || this.getAttackState() == 12 || this.getAttackState() == 13 || this.getAttackState() == 14) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 24) {
                this.playSound(ModSounds.PHANTOM_SPEAR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 24 && this.attackTicks <= 33) {
                Rushattack(-0.05D, 0.5D,3.25, 1.1F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.getWorld().isClient) {
                    double x = this.getX();
                    double y = this.getY() + this.getHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYaw());
                    float yaw2 = (float) Math.toRadians(-this.getYaw() + 180);
                    float pitch = (float) Math.toRadians(-this.getPitch());
                    this.getWorld().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.getWorld().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }
        }


        if (this.getAttackState() == 15 || this.getAttackState() == 16) {
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.PHANTOM_SPEAR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 16 && this.attackTicks <= 25) {
                Rushattack(-0.035D, 0.5D,3.25, 1.2F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.getWorld().isClient) {
                    double x = this.getX();
                    double y = this.getY() + this.getHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYaw());
                    float yaw2 = (float) Math.toRadians(-this.getYaw() + 180);
                    float pitch = (float) Math.toRadians(-this.getPitch());
                    this.getWorld().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.getWorld().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }
        }
        if (this.getAttackState() == 17) {
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.PHANTOM_SPEAR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 16 && this.attackTicks <= 24) {
                Rushattack(0, 0.5D,3.25, 1.3F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.getWorld().isClient) {
                    double x = this.getX();
                    double y = this.getY() + this.getHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYaw());
                    float yaw2 = (float) Math.toRadians(-this.getYaw() + 180);
                    float pitch = (float) Math.toRadians(-this.getPitch());
                    this.getWorld().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.getWorld().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }

        }
        if (this.getAttackState() == 18) {
            if (this.attackTicks == 18) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 20) {
                AreaAttack(3.25f, 3.25f, 220, 1, (float) CMConfig.MaledictusHpDamage, 0, false,false);
            }
            if (this.attackTicks == 32) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 34) {
                AreaAttack(3.25f, 3.25f, 220, 1, (float) CMConfig.MaledictusHpDamage, 160, false,false);
            }
        }
        if (this.getAttackState() == 19) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 12) {
                AreaAttack(4.0f, 4.0f, 180, 1, (float) CMConfig.MaledictusHpDamage, 0, false,false);
            }

            if (this.attackTicks == 22) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 24) {
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
                ComboAreaAttack(5f, 5f, 70, 1.2F, (float) CMConfig.MaledictusHpDamage, 200, false);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 20);
            }
        }
        if (this.getAttackState() == 21) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 12) {
                AreaAttack(4.25f, 4.25f, 180, 1, (float) CMConfig.MaledictusHpDamage, 0, true,false);
            }

            if (this.attackTicks == 22) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 24) {
                AreaAttack(5f, 5f, 70, 1.2F, (float) CMConfig.MaledictusHpDamage, 0, true,false);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 22) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 23) {
                uppercut(0.2D, 3.25, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, true);

            }
            if (this.attackTicks == 31) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 0.5F, 1.0f);
            }
            if (this.attackTicks == 33) {
                uppercut(0.25D, 3.8, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false);
                MakeRingparticle(3.5f, -0.3f, 40, 86, 236, 204, 1.0f, 20f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 23) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 1F, 1.0f);
            }
            if (this.attackTicks == 23) {
                uppercut(0.2D, 3.25, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, true);

            }
            if (this.attackTicks == 31) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING, 0.5F, 1.0f);
            }
            if (this.attackTicks == 33) {
                uppercut(0.25D, 3.8, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false);
                MakeRingparticle(3.5f, 0.7f, 40, 86, 236, 204, 1.0f, 20f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 24) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_LEAP, 1F, 1.0f);
            }
            if (this.attackTicks >= 60) {
                if (this.isOnGround() || !this.getBlockStateAtPos().getFluidState().isEmpty()) {
                    this.setAttackState(25);
                }
            }
        }

        if (this.getAttackState() == 25) {
            flyingdestroy();
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.PHANTOM_SPEAR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.3f, 0, 40);
                MakeRingparticle(2.25f, 0.3f, 40, 86, 236, 204, 1.0f, 30f);
                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(2.0D))) {
                    if (!isTeammate(entity) && entity != this) {
                        boolean flag = entity.damage(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }
                    }
                }
                StrikeWindmillHalberd(6, 10, 1.0, 0.75, 0.2, 1);

                StrikeWindmillHalberd(4, 10, 1.0, 1.2, 0.15, 1);
            }
            if (this.attackTicks == 37) {
                MakeRingparticle(2.25f, 0.3f, 40, 86, 236, 204, 1.0f, 30f);
                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(2.0D))) {
                    if (!isTeammate(entity) && entity != this) {
                        boolean flag = entity.damage(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }
                    }
                }
               // StrikeHalberd(12,12F,5 + random.nextInt(1),2.5D,1);
            }
            if (this.attackTicks == 39) {
                StrikeHalberd(14,14F,7 + random.nextInt(3),4D,1);
            }
            if (this.attackTicks == 40) {
                StrikeHalberd(16,16F,10 + random.nextInt(5),5.5D,1);
            }
            if (this.attackTicks == 42 && isHalfHealth()) {
                StrikeHalberd(18,18F,13 + random.nextInt(8),6.5D,1);
            }
            if(this.attackTicks == 43 && this.isQuarterHealth()){
                StrikeHalberd(20,20F,16 + random.nextInt(10),7.5D,1);
            }

        }

        if(this.getAttackState() == 26){
            if(this.attackTicks == 13) {
                this.playSound(ModSounds.PHANTOM_SPEAR, 1.0F, 1.0f);
            }
            if(this.attackTicks == 15) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 1.0F, 1.0f);
                AreaAttack(4.5f, 4.5f, 80, 1.2F, (float) CMConfig.MaledictusSmashHpDamage, 0, true,false);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
            }
            if(this.attackTicks == 44) {
                AreaAttack(5.5f, 5.5f, 110, 1.0F, (float) CMConfig.MaledictusSmashHpDamage, 0, true,false);
              //  ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
            }

            for (int l = 44; l <= 58; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 42;
                    radagonskill(0.7f, d, 1,2);
                }
            }
        }
        if(this.getAttackState() == 27){
            if(this.attackTicks == 20) {
                AreaAttack(5.25f, 5.25f, 110, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false,true);
                this.playSound(ModSounds.AXE_SWING, 1.0F, 1.3f);
            }
        }

        if(this.getAttackState() == 29){
            if(this.attackTicks == 1) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 1.0F, 1.0f);
            }
            Grab(-0.025D, 0.5D,1.5, 0.2F, 0, 0, true);
            if (this.getWorld().isClient) {
                for (int i = 0; i < 2; ++i) {
                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, this.getParticleX(1.5D), this.getRandomBodyY(), this.getParticleZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if(this.getAttackState() == 31){
            if (this.getWorld().isClient) {
                for (int i = 0; i < 2; ++i) {
                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, this.getParticleX(1.5D), this.getRandomBodyY(), this.getParticleZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.MALEDICTUS_LEAP, 1F, 1.0f);
            }

        }


        if(this.getAttackState() == 32){
            if (this.isOnGround() || !this.getBlockStateAtPos().getFluidState().isEmpty()) {
                this.setAttackState(33);
            }
            if (this.getWorld().isClient) {
                for (int i = 0; i < 2; ++i) {
                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, this.getParticleX(1.5D), this.getRandomBodyY(), this.getParticleZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if(this.getAttackState() == 33) {
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.EXPLOSION, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.2f, 0, 40);
                if (this.getWorld().isClient) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
                    float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
                    double theta = (bodyYaw) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 30, 86, 236, 204, 1.0f, 85, false, 0), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(7.0D))) {
                    if (!isTeammate(entity) && entity != this) {
                        entity.damage(CMDamageTypes.causeMaledictioSoulDamage(this), (float) (DMG() * 1.75F + Math.min(DMG() * 1.75F, entity.getMaxHealth() * CMConfig.MaledictusAOEHpDamage)));
                    }
                }
            }
            if (this.attackTicks > 1 && this.attackTicks < 11) {
                Sphereparticle(0.3f, 1.0f, 4F);
            }
        }

    }


    private void blockbreak() {
        if (!this.isAiDisabled()) {
            if (!this.getWorld().isClient) {
                if (CMConfig.MaledictusBlockBreaking) {
                    blockdestroy();
                } else {
                    if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        blockdestroy();
                    }
                }
            }
        }
    }

    private void flyingdestroy(){
        if (!this.getWorld().isClient) {
            if (CMConfig.MaledictusBlockBreaking) {
                blockdestroy2(0.35D,2.0D);
            } else {
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    blockdestroy2(0.35D,2.0D);
                }
            }
        }
    }

    private void blockdestroy() {
        if (this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0) {
                Box aabb = this.getBoundingBox().expand(0.5D);
                for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
                    BlockState blockstate = this.getWorld().getBlockState(blockpos);
                    if (!blockstate.isAir() && !blockstate.isIn(ModTag.MALEDICTUS_IMMUNE)) {
                        this.getWorld().breakBlock(blockpos, true, this);
                    }
                }

            }
        }
        Box aabb = this.getBoundingBox().expand(0.2D, 0.5D, 0.2D);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.isIn(ModTag.FROSTED_PRISON_CHANDELIER)) {
                this.getWorld().breakBlock(blockpos, true, this);
            }
        }

    }

    private void blockdestroy2(double xz,double y) {
        Box aabb = this.getBoundingBox().expand(xz, y, xz);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.MALEDICTUS_IMMUNE)) {
                this.getWorld().breakBlock(blockpos, true, this);
            }
        }

    }


    private void StrikeHalberd(int rune, float close,float radius,double range,int delay) {
        float angle2 = (0.01745329251F * this.bodyYaw);
        for (int k = 0; k < rune; ++k) {
            float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / close + ((float) Math.PI * 2F / radius);
            this.spawnHalberd(this.getX() + (double) MathHelper.cos(f2) * range, this.getZ() + (double) MathHelper.sin(f2) * range, this.getY() -5, this.getY() + 3, f2, delay);
        }


        if (this.getWorld().isClient) {
            for (int k = 0; k < rune; ++k) {
                float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / close + ((float) Math.PI * 2F / radius);
                for (int i1 = 0; i1 < 6 + random.nextInt(2); i1++) {
                    double DeltaMovementX = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementY = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementZ = getRandom().nextGaussian() * 0.007D;
                    float angle = (0.01745329251F * this.bodyYaw) + i1;
                    double extraX = 0.5F * MathHelper.sin((float) (Math.PI + angle));
                    double extraY = 0.3F;
                    double extraZ = 0.5F * MathHelper.cos(angle);

                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, getX() + (double) MathHelper.cos(f2) * range + extraX, this.getY() + extraY, getZ() + (double) MathHelper.sin(f2) * range + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }


    private void StrikeWindmillHalberd(int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
        float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
        for (int branch = 0; branch < numberOfBranches; ++branch) {
            float baseAngle = angleIncrement * branch;

            for (int i = 0; i < particlesPerBranch; ++i) {
                double currentRadius = initialRadius + i * radiusIncrement;
                float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

                double xOffset = currentRadius * Math.cos(currentAngle);
                double zOffset = currentRadius * Math.sin(currentAngle);

                double spawnX = this.getX() + xOffset;
                double spawnY = this.getY() + 0.3D;
                double spawnZ = this.getZ() + zOffset;
                int d3 = delay * (i + 1);
                this.spawnHalberd(spawnX, spawnZ, this.getY() -5, this.getY() + 3, currentAngle, d3);

                double deltaX = getRandom().nextGaussian() * 0.007D;
                double deltaY = getRandom().nextGaussian() * 0.007D;
                double deltaZ = getRandom().nextGaussian() * 0.007D;
                if (this.getWorld().isClient) {
                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, spawnX, spawnY, spawnZ, deltaX, deltaY, deltaZ);
                }
            }
        }
    }

    private void radagonskill(float spreadarc, int distance, float vec, int delay) {
        double perpFacing = this.bodyYaw * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = MathHelper.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((bodyYaw + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((bodyYaw + 90) * Math.PI / 180);
            int hitX = MathHelper.floor(px);
            int hitZ = MathHelper.floor(pz);

            this.spawnHalberd(hitX + 0.5D, hitZ + 0.5D, this.getY() -5, this.getY() + 3, (float) theta, delay);
            this.radagonparticle(hitX + 0.5D, hitZ + 0.5D, this.getY() -5, this.getY() + 3);
        }
    }

    private void radagonparticle(double x, double z, double minY, double maxY) {
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
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            if (this.getWorld().isClient) {
                for (int i1 = 0; i1 < 4 ; i1++) {
                    double DeltaMovementX = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementY = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementZ = getRandom().nextGaussian() * 0.007D;
                    float angle = (0.01745329251F * this.bodyYaw) + i1;
                    double extraX = 0.35F * MathHelper.sin((float) (Math.PI + angle));
                    double extraY = 0.3F;
                    double extraZ = 0.35F * MathHelper.cos(angle);

                    this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, x + extraX, (double)blockpos.getY() + d0 + extraY, z + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }

    private void spawnHalberd(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            this.getWorld().spawnEntity(new Phantom_Halberd_Entity(this.getWorld(), x, (double)blockpos.getY() + d0, z, rotation, delay, this,(float)CMConfig.MaledictusPhantomHalberddamage + (float) CMConfig.MaledictusPhantomHalberddamage * this.getRageMeter() * 0.1F));
        }
    }


    private void ComboAreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, DMG() * damage + Math.min(DMG() * damage, entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        combo = true;
                        rageTicks = 200;
                        if (this.getRageMeter() < 5) {
                            setRageMeter(this.getRageMeter() + 1);
                        }
                    }
                }
            }
        }
    }

    private void Grab(double inflateXZ,double inflateY,  double range, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
        double yaw = (bodyYaw) * (Math.PI / 180);
        yaw += Math.PI / 2;

        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        Box attackRange = this.getBoundingBox().expand(inflateXZ,inflateY,inflateXZ).stretch(xExpand, 0, zExpand);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
            if (!isTeammate(entity) && entity != this) {
                DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    grab = true;
                    if (!entity.getType().isIn(ModTag.IGNIS_CANT_POKE) && entity.isAlive()) {
                        if (entity.isSneaking()) {
                            entity.setSneaking(false);
                        }
                        if(this.getPassengerList().isEmpty()) {
                            if (!this.getWorld().isClient) {
                                entity.startRiding(this, true);
                            }
                        }
                    }

                }

            }
        }
    }


    private void ShieldSmashDamage(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
        double perpFacing = this.bodyYaw * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = MathHelper.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = MathHelper.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((bodyYaw + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((bodyYaw + 90) * Math.PI / 180);
            int hitX = MathHelper.floor(px);
            int hitZ = MathHelper.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = getWorld().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderType() == BlockRenderType.MODEL) {
                    break;
                }
                pos = pos.down();
                block = getWorld().getBlockState(pos);
            }
            if (block.getRenderType() != BlockRenderType.MODEL) {
                block = Blocks.AIR.getDefaultState();
            }
            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.addVelocity(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            getWorld().spawnEntity(fallingBlockEntity);
            Box selection = new Box(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = getWorld().getNonSpectatingEntities(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isTeammate(entity) && entity != this) {
                    boolean flag = entity.damage(CMDamageTypes.causeMaledictioDamage(this), DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {
                        entity.setVelocity(entity.getVelocity().add(0.0D, airborne * distance + getWorld().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    private void MakeRingparticle(float vec, float math, int duration, int r, int g, int b, float a, float scale) {
        if (this.getWorld().isClient) {
            float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
            float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
            double theta = (bodyYaw) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, duration, r, g, b, a, scale, false, 2), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
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
                            this.getWorld().addParticle(ModParticle.CURSED_FLAME, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void masseffectParticle(float radius) {
        if (this.getWorld().isClient) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = this.getX() + distance * MathHelper.cos(angle);
                double extraY = this.getY() + 0.3F;
                double extraZ = this.getZ() + distance * MathHelper.sin(angle);

                this.getWorld().addParticle(ModParticle.PHANTOM_WING_FLAME, extraX, extraY, extraZ, 0.0D, this.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }

    private void Rushattack(double inflateXZ,double inflateY,  double range, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
        double yaw = (bodyYaw) * (Math.PI / 180);
        yaw += Math.PI / 2;
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        Box attackRange = this.getBoundingBox().expand(inflateXZ,inflateY,inflateXZ).stretch(xExpand, 0, zExpand);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
            if (!isTeammate(entity) && entity != this) {
                DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    rageTicks = 200;
                    if (this.getRageMeter() < 5) {
                        setRageMeter(this.getRageMeter() + 1);
                    }
                }

            }
        }
    }

    private void uppercut(double inflate, double range, float damage, float hpdamage, int shieldbreakticks, boolean airborne) {
        double yaw = (bodyYaw) * (Math.PI / 180);
        yaw += Math.PI / 2;
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        Box attackRange = this.getBoundingBox().expand(inflate).stretch(xExpand, 0, zExpand);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
            if (!isTeammate(entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    rageTicks = 200;
                    if (this.getRageMeter() < 5) {
                        setRageMeter(this.getRageMeter() + 1);
                    }
                    if (airborne) {
                        double d0 = entity.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE);
                        double d1 = Math.max(0.0D, 1.0D - d0);
                        entity.setVelocity(entity.getVelocity().add(0.0D, (double) 0.4F * d1, 0.0D));
                    }
                }

            }
        }
    }


    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, boolean maledictio,boolean knockback) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, DMG() * damage + Math.min(DMG() * damage, entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        rageTicks = 200;
                        if (this.getRageMeter() < 5) {
                            setRageMeter(this.getRageMeter() + 1);
                        }
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        if (knockback) {
                            entityHit.addVelocity(d0 / d2 * 2.5D, 0.18D, d1 / d2 * 2.2D);
                        }
                    }
                }
            }
        }
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_MALEDICTUS)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MALEDICTUS_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MALEDICTUS_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.MALEDICTUS_IDLE;
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.MALEDICTUS_MUSIC;
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossEvent1.addPlayer(player);
        this.bossEvent2.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossEvent1.removePlayer(player);
        this.bossEvent2.removePlayer(player);
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    static class Maledictus_Swing extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;


        public Maledictus_Swing(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == 5) {
                if (target != null) {
                    double d0 = target.getX() - this.entity.getX();
                    double d1 = target.getY() - this.entity.getY();
                    double d2 = target.getZ() - this.entity.getZ();
                    Vec3d vec3 = (new Vec3d(d0, 0.7 + MathHelper.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
                    this.entity.setVelocity(vec3);
                } else {

                    Vec3d vec3 = (new Vec3d(0, 0.7, 0));
                    this.entity.setVelocity(vec3);
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }


    static class Maledictus_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;


        public Maledictus_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getVisibilityCache().canSee(target);
        }

        @Override
        public void start() {
            super.start();
            this.entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setWeapon(0);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(6);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getBodyY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.getWorld(), this.entity, target);
                        throwntrident.setDamage(CMConfig.MaledictusPhantomArrowbasedamage + CMConfig.MaledictusPhantomArrowbasedamage * this.entity.getRageMeter() * 0.05f);
                        throwntrident.setVelocity(x, d2 + distance * (double) 0.15F, z, 1.8F, 1);
                        this.entity.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.getWorld().spawnEntity(throwntrident);

                    }

                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class Maledictus_Flying_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int attackshot;
        private final float random;

        public Maledictus_Flying_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(0);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackshot && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 90.0F);
                entity.lookAtEntity(target, 30.0F, 90.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }

            if (this.entity.attackTicks == 8) {
                if (target != null) {
                    double x = 0;
                    double z = 0;
                    double r = 0;
                    double maxR = 3.0;
                    if (entity.squaredDistanceTo(target) < 36D) {
                        float dodgeYaw = (float) Math.toRadians(entity.getYaw() + 90);
                        double dis = entity.squaredDistanceTo(target);
                        r = MathHelper.clamp(8 / (dis + 0.1), 0, maxR);
                        x = Math.cos(dodgeYaw);
                        z = Math.sin(dodgeYaw);
                    }

                    double d1 = target.getY() - this.entity.getY();
                    this.entity.setVelocity(x * -r, 0.9 + MathHelper.clamp(d1 * 0.075, 0.0, 7.0), z * -r);
                } else {
                    this.entity.setVelocity(0, 0.9, 0);
                }
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == 20) {
                this.entity.setVelocity(0, 0, 0);
            }
            if (this.entity.attackTicks == 60) {
                this.entity.setFlying(false);
            }
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(9);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getBodyY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();


                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.getWorld(), this.entity, target);
                        throwntrident.setDamage(CMConfig.MaledictusPhantomArrowbasedamage + CMConfig.MaledictusPhantomArrowbasedamage * this.entity.getRageMeter() * 0.05f);
                        throwntrident.setVelocity(x, d2 + distance * (double) 0.15F, z, 1.5F, 1);
                        this.entity.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.getWorld().spawnEntity(throwntrident);

                    }
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class MaledictusfallingState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startbow;
        private final int stopbow;
        private final int attackseetick;

        public MaledictusfallingState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int startbow, int stopbow) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.startbow = startbow;
            this.stopbow = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startbow);
            if (entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            entity.setVelocity(0, entity.getVelocity().y, 0);
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 0F);
                entity.lookAtEntity(target, 30.0F, 0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
            entity.setWeapon(stopbow);
        }
    }

    static class Maledictus_Flying_Smash extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int attackstrike;
        private final float random;
        private final double dropspeed;
        private final int startweapon;
        private final int stopweapon;

        public Maledictus_Flying_Smash(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, int startweapon, int stopweapon, float random,double dropspeed) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackstrike = attackshot;
            this.random = random;
            this.dropspeed = dropspeed;
            this.startweapon = startweapon;
            this.stopweapon = stopweapon;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <= 0 ;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setFlying(false);
            entity.setWeapon(stopweapon);
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackstrike && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 0F);
                entity.lookAtEntity(target, 30.0F, 0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if (this.entity.attackTicks == 25) {
                this.entity.setVelocity(0, 0.9, 0);

                if(target !=null) {
                    double d1 = target.getY() - this.entity.getY();
                    this.entity.setVelocity(0, 0.9 + MathHelper.clamp(d1 * 0.075, 0.0, 7.0), 0);
                }else{
                    this.entity.setVelocity(0, 0.9, 0);
                }
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == attackstrike) {
                this.entity.setFlying(false);
                if (target != null) {
                    double Y = dropspeed * Math.abs(this.entity.getY() - target.getY());

                    double Z = 0.1f * (target.getZ() - this.entity.getZ());
                    double X = 0.1F * (target.getX() - this.entity.getX());
                    entity.setVelocity(entity.getVelocity().add(X, -1.0d * Y, Z));

                }
            }

        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }


    static class MaledictusSpinSlashes extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackseetick3;
        private final int attackchargetick1;
        private final int attackchargetick2;
        private final float random;

        public MaledictusSpinSlashes(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackseetick3, int attackchargetick1, int attackchargetick2, float attackrange, int startbow, int stopbow, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackseetick3 = attackseetick3;
            this.attackchargetick1 = attackchargetick1;
            this.attackchargetick2 = attackchargetick2;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));

        }

        @Override
        public boolean canStart() {
            return super.canStart() && this.entity.getRandom().nextFloat() * 100.0F < random && entity.spin_cooldown  <= 0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null ||
                    entity.attackTicks > attackseetick2 && target != null && entity.attackTicks < attackseetick3) {
                entity.getLookControl().lookAt(target, 60.0F, 30F);
                entity.lookAtEntity(target, 60.0F, 30F);
            } else {
                entity.setYaw(entity.prevYaw);
            }

            if (entity.attackTicks == attackchargetick1 || entity.attackTicks == attackchargetick2) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = MathHelper.clamp(r, 2.5F, 6.5F);
                    entity.addVelocity(f1 * 0.35f * r, 0, f2 * 0.35f * r);
                } else {
                    entity.addVelocity(f1 * 2.25, 0, f2 * 2.25);
                }

            }


        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(stopweapon);
            entity.spin_cooldown = SPIN_COOLDOWN;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class MaledictusChargeGoal extends Goal {
        private final Maledictus_Entity entity;
        private final int getattackstate;
        private final float attackrange;
        private final float attackminrange;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final float random;


        public MaledictusChargeGoal(Maledictus_Entity entity, int getattackstate, int attackseetick, int attackseetick2, int attackchargetick, float attackminrange, float attackrange, int startbow, int stopbow, float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackrange = attackrange;
            this.attackminrange = attackminrange;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.charge_cooldown <= 0 && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getVisibilityCache().canSee(target);
        }

        @Override
        public void start() {
            if (this.entity.isHalfHealth()) {
                this.entity.setAttackState(14);
            } else {
                this.entity.setAttackState(13);
            }
            entity.setWeapon(startweapon);
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.getAttackState() == 13 ? this.entity.attackTicks <= 65 : this.entity.attackTicks <= 55;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target != null) {
                entity.getLookControl().lookAt(target, 60.0F, 30F);
                entity.lookAtEntity(target, 60.0F, 30F);
            } else {
                entity.setYaw(entity.prevYaw);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = MathHelper.clamp(r, 0, 7);
                    entity.addVelocity(f1 * 0.9 * r, 0, f2 * 0.9 * r);
                } else {
                    entity.addVelocity(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (this.entity.getAttackState() == 13) {
                if (entity.attackTicks == 34 && (entity.isOnGround() || entity.isInLava() || entity.isTouchingWater())) {
                    float speed = -1.7f;
                    float dodgeYaw = (float) Math.toRadians(entity.getYaw() + 90);
                    Vec3d m = entity.getVelocity().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                    entity.setVelocity(m.x, 0.4, m.z);
                }
            }


        }

        @Override
        public void stop() {
            if (this.entity.getAttackState() == 14) {
                if (this.entity.isQuarterHealth()) {
                    this.entity.setAttackState(16);
                } else {
                    this.entity.setAttackState(15);
                }
            } else {
                this.entity.setAttackState(0);
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }


    static class MaledictusChargeState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final int backsteptick;
        private final int count;


        public MaledictusChargeState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackchargetick, int backsteptick, int startbow, int stopbow, int count) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.backsteptick = backsteptick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.count = count;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target != null) {
                entity.getLookControl().lookAt(target, 60.0F, 30F);
                entity.lookAtEntity(target, 60.0F, 30F);
            } else {
                entity.setYaw(entity.prevYaw);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = MathHelper.clamp(r, 0, 7);
                    entity.addVelocity(f1 * 0.9f * r, 0, f2 * 0.9f * r);
                } else {
                    entity.addVelocity(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (backsteptick > 0 && entity.attackTicks == backsteptick && (entity.isOnGround() || entity.isInLava() || entity.isTouchingWater())) {
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(entity.getYaw() + 90);
                Vec3d m = entity.getVelocity().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                entity.playSound(ModSounds.MALEDICTUS_JUMP, 1F, 1.0f);
                entity.setVelocity(m.x, 0.4, m.z);
            }
        }

        @Override
        public void stop() {
            if (this.count == 1) {
                if (this.entity.isQuarterHealth()) {
                    this.entity.setAttackState(16);
                } else {
                    this.entity.setAttackState(15);
                }
            } else if (this.count == 2 && this.entity.getAttackState() == 16) {
                this.entity.setAttackState(17);
            } else {
                super.stop();
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }
    }


    static class Uppercut extends Goal {
        protected final Maledictus_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private final float random;

        public Uppercut(Maledictus_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange,float random) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;
        }


        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getVisibilityCache().canSee(target) && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.uppercut_cooldown <= 0;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            entity.uppercut_cooldown = UPPERCUT_COOLDOWN;
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 60.0F, 30.0F);
                entity.lookAtEntity(target, 60.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return false;
        }
    }


    static class MaledictusGrabGoal extends Goal {

        protected final Maledictus_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private final float random;
        private final int startweapon;
        private final int stopweapon;

        public MaledictusGrabGoal(Maledictus_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick, int attackseetick, float attackrange, int startbow, int stopbow, float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackrange = attackrange;
            this.attackseetick = attackseetick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random  && this.entity.grab_cooldown <= 0 ;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            entity.setWeapon(startweapon);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            entity.grab_cooldown = GRAB_COOLDOWN;
            entity.setWeapon(stopweapon);
        }

        @Override
        public boolean shouldContinue() {
            return  this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class MaledictusGrabState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;

        public MaledictusGrabState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int startbow, int stopbow) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }


        @Override
        public boolean shouldContinue() {
            return super.shouldContinue() && !entity.grab;
        }

        @Override
        public void tick() {
            if(this.entity.isOnGround()){
                Vec3d vector3d = entity.getVelocity();
                float f = entity.getYaw() * ((float)Math.PI / 180F);
                Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(0.8D).add(vector3d.multiply(0.8D));
                entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
            }
        }


        @Override
        public void stop() {
            if (entity.grab) {
                entity.setAttackState(31);
                entity.grab = false;
            } else {
                super.stop();
            }
            entity.setWeapon(stopweapon);
        }


    }


    static class MaledictusSuccessState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackstrike;
        private final double dropspeed;

        public MaledictusSuccessState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackstrike, int startbow, int stopbow,double dropspeed) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackstrike = attackstrike;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.dropspeed = dropspeed;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            if (this.entity.attackTicks == 19) {
                this.entity.setVelocity(0, 1.2, 0);
                entity.setFlying(true);
            }
            entity.setVelocity(0, entity.getVelocity().y, 0);
            if (this.entity.attackTicks == attackstrike) {
                this.entity.setFlying(false);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(stopweapon);

        }
    }

}





