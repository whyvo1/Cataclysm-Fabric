package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.l_ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.github.l_ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.l_ender.cataclysm.entity.etc.ISemiAquatic;
import com.github.l_ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class AbstractDeepling extends LLibrary_Monster implements ISemiAquatic,Monster {
    private int moistureAttackTime = 0;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;
    private boolean isLandNavigator;
    private static final TrackedData<Integer> MOISTNESS = DataTracker.registerData(AbstractDeepling.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> DEEPLINGSWIM = DataTracker.registerData(AbstractDeepling.class, TrackedDataHandlerRegistry.BOOLEAN);

    public AbstractDeepling(EntityType entity, World world) {
        super(entity, world);
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.add(4, new MobAILeaveWater(this));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(5, new RidingCoralssus(this));
        this.goalSelector.add(3, new StopRiding(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(MOISTNESS, 40000);
        p_326229_.add(DEEPLINGSWIM, false);
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

    @Override
    public void tick() {
        super.tick();

        if (isTouchingWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isTouchingWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (this.isAiDisabled()) {
            this.setAir(this.getMaxAir());
        } else {
            if (this.isWet()) {
                this.setMoistness(6000);
            } else {
                int dry = this.getWorld().isDay() ? 2 : 1;
                this.setMoistness(this.getMoistness() - dry);
                if (this.getMoistness() <= 0 && moistureAttackTime-- <= 0) {
                    this.damage(getDamageSources().dryOut(), random.nextInt(2) == 0 ? 1.0F : 0F);
                    moistureAttackTime = 20;
                }
            }
        }


        boolean flag1 = this.canInFluidType(this.getWorld().getFluidState(new BlockPos(this.getBlockPos())));
        if (this.getWorld().isClient) {
            if (flag1) {
                if (this.getWorld().isSpaceEmpty(this, this.getSwimmingBox())) {
                    if (!this.getDeeplingSwim()) {
                        setDeeplingSwim(true);
                    }
                    calculateDimensions();
                }
            } else {
                if (this.getWorld().isSpaceEmpty(this, this.getNormalBox())) {
                    if (this.getDeeplingSwim()) {
                        setDeeplingSwim(false);
                    }
                    calculateDimensions();
                }
            }
        }


        if (this.getWorld().isClient){
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }
    }

    private boolean canInFluidType(FluidState fluid) {
        return fluid.isOf(Fluids.WATER);
    }

    public boolean isInSwimmingPose() {
        return this.getDeeplingSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide(this, getWorld());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, getWorld());
            this.isLandNavigator = false;
        }
    }

    public Box getSwimmingBox() {
        return new Box(this.getX()- 1.15f, this.getY(), this.getZ() -1.15f,  this.getX() + 1.15f, this.getY()+ 0.6F, this.getZ() + 1.15f);
    }

    public Box getNormalBox() {
        return new Box(this.getX()- 0.6f, this.getY(), this.getZ() -0.6f,  this.getX() + 0.6f, this.getY()+ 2.3f, this.getZ() + 0.6f);
    }

    public EntityDimensions getSwimmingSize() {
        return this.getType().getDimensions().scaled(this.getScale());
    }



    @Override
    public EntityDimensions getBaseDimensions(EntityPose poseIn) {
        return this.getDeeplingSwim() ? getSwimmingSize() : this.getType().getDimensions().scaled(this.getScale());
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("Moisture", this.getMoistness());

    }
    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setMoistness(compound.getInt("Moisture"));

    }

    public int getMoistness() {
        return this.dataTracker.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.dataTracker.set(MOISTNESS, p_211137_1_);
    }

    public boolean getDeeplingSwim() {
        return this.dataTracker.get(DEEPLINGSWIM);
    }

    public void setDeeplingSwim(boolean swim) {
        this.dataTracker.set(DEEPLINGSWIM, swim);
    }


    public boolean isPushedByFluids() {
        return !this.isSwimming();
    }


    @Override
    public boolean shouldEnterWater() {
        return getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isTouchingWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;

    }

    protected Box getAttackBox() {
        Box aabb = super.getAttackBox();
        return aabb.contract(0.05, 0.0F, 0.05);
    }

    static class RidingCoralssus extends Goal {
        private final AbstractDeepling drowned;

        public RidingCoralssus(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;

        }

        public boolean canStart() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            return !this.drowned.hasVehicle() && sus !=null && this.drowned.getMoistness() > 300 && sus.isAlive() && !sus.hasPassengers();
        }

        public void start() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            if(sus !=null) {
                this.drowned.getNavigation().startMovingTo(sus, 1.0D);
            }
        }

        public void tick() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            if(sus !=null) {
                this.drowned.getNavigation().startMovingTo(sus, 1.0D);
                if(this.drowned.distanceTo(sus) < 4.0f){
                    this.drowned.startRiding(sus, true);
                }

            }
        }

        public void stop() {
            this.drowned.getNavigation().stop();
        }

        private Coralssus_Entity getClosestCoralssus_Entity(){
            List<Coralssus_Entity> list = this.drowned.getWorld().getNonSpectatingEntities(Coralssus_Entity.class, this.drowned.getBoundingBox().expand(15, 15, 15));
            Coralssus_Entity closest = null;
            if(!list.isEmpty()){
                for(Coralssus_Entity entity : list){
                    if((closest == null || closest.distanceTo(entity) > entity.distanceTo(entity))){
                        closest = entity;
                    }
                }
            }
            return closest;
        }
    }


    static class StopRiding extends Goal {
        private final AbstractDeepling drowned;

        public StopRiding(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;

        }

        public boolean canStart() {
            return this.drowned.getMoistness() < 300 && drowned.hasVehicle();
        }

        public void start() {
            drowned.stopRiding();
        }

    }

}
