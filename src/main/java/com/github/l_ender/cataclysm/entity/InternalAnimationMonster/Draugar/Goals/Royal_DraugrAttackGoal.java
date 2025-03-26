package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class Royal_DraugrAttackGoal extends Goal {
   protected final Royal_Draugr_Entity mob;
   private final double speedModifier;
   private final boolean followingTargetEvenIfNotSeen;
   private Path path;
   private double pathedTargetX;
   private double pathedTargetY;
   private double pathedTargetZ;
   private int ticksUntilNextPathRecalculation;
   private int ticksUntilNextAttack;
   private final int attackInterval = 20;
   private long lastCanUseCheck;
   private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
   private int failedPathFindingPenalty = 0;
   private boolean canPenalize = false;

   public Royal_DraugrAttackGoal(Royal_Draugr_Entity p_25552_, double p_25553_, boolean p_25554_) {
      this.mob = p_25552_;
      this.speedModifier = p_25553_;
      this.followingTargetEvenIfNotSeen = p_25554_;
      this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
   }

   public boolean canStart() {
      long i = this.mob.getWorld().getTime();
      if (i - this.lastCanUseCheck < 20L) {
         return false;
      } else {
         this.lastCanUseCheck = i;
         LivingEntity livingentity = this.mob.getTarget();
         if (livingentity == null) {
            return false;
         } else if (!livingentity.isAlive()) {
            return false;
         } else {
           if (canPenalize) {
               if (--this.ticksUntilNextPathRecalculation <= 0) {
                  this.path = this.mob.getNavigation().findPathTo(livingentity, 0);
                  this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                  return this.path != null;
               } else {
                  return true;
               }
            }
            this.path = this.mob.getNavigation().findPathTo(livingentity, 0);
            if (this.path != null) {
               return true;
            } else {
               return this.getAttackReachSqr(livingentity) >= this.mob.squaredDistanceTo(livingentity.getX(), livingentity.getY(), livingentity.getZ());
            }
         }
      }
   }

   public boolean shouldContinue() {
      LivingEntity livingentity = this.mob.getTarget();
      if (livingentity == null) {
         return false;
      } else if (!livingentity.isAlive()) {
         return false;
      } else if (!this.followingTargetEvenIfNotSeen) {
         return !this.mob.getNavigation().isIdle();
      } else if (!this.mob.isInWalkTargetRange(livingentity.getBlockPos())) {
         return false;
      } else {
         return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity)livingentity).isCreative();
      }
   }

   public void start() {
      this.mob.getNavigation().startMovingAlong(this.path, this.speedModifier);
      this.mob.setAttacking(true);
      this.ticksUntilNextPathRecalculation = 0;
      this.ticksUntilNextAttack = 0;
   }

   public void stop() {
      LivingEntity livingentity = this.mob.getTarget();
      if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingentity)) {
         this.mob.setTarget(null);
      }

      this.mob.setAttacking(false);
      this.mob.getNavigation().stop();
      if(this.mob.isDraugrBlocking()){
         this.mob.clearActiveItem();
         this.mob.setShieldCooldownTime(60);
      }
   }

   public boolean shouldRunEveryTick() {
      return true;
   }

   public void tick() {
      LivingEntity livingentity = this.mob.getTarget();
      if (livingentity != null) {
         this.mob.getLookControl().lookAt(livingentity, 30.0F, 30.0F);
         double d0 = this.mob.squaredDistanceTo(livingentity);
         this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);

         if(!isShieldDisabled(mob) && mob.getOffHandStack().isIn(ConventionalItemTags.SHIELD_TOOLS) && this.mob.getRandom().nextInt(6) == 0){
            this.mob.setCurrentHand(Hand.OFF_HAND);
         }

         if ((this.followingTargetEvenIfNotSeen || this.mob.getVisibilityCache().canSee(livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.squaredDistanceTo(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
            this.pathedTargetX = livingentity.getX();
            this.pathedTargetY = livingentity.getY();
            this.pathedTargetZ = livingentity.getZ();
            this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
         if (this.canPenalize) {
            this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
            if (this.mob.getNavigation().getCurrentPath() != null) {
               net.minecraft.entity.ai.pathing.PathNode finalPathPoint = this.mob.getNavigation().getCurrentPath().getEnd();
               if (finalPathPoint != null && livingentity.squaredDistanceTo(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                  failedPathFindingPenalty = 0;
               else
                  failedPathFindingPenalty += 10;
            } else {
               failedPathFindingPenalty += 10;
            }
         }
            if (d0 > 1024.0D) {
               this.ticksUntilNextPathRecalculation += 10;
            } else if (d0 > 256.0D) {
               this.ticksUntilNextPathRecalculation += 5;
            }

            if (!this.mob.getNavigation().startMovingTo(livingentity, this.speedModifier)) {
               this.ticksUntilNextPathRecalculation += 15;
            }

            this.ticksUntilNextPathRecalculation = this.getTickCount(this.ticksUntilNextPathRecalculation);
         }

         this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
         this.checkAndPerformAttack(livingentity, d0);
      }
   }

   public boolean isShieldDisabled(Royal_Draugr_Entity shieldUser) {
      return shieldUser.isShieldDisabled();
   }

   protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
      double d0 = this.getAttackReachSqr(p_25557_);
      if (p_25558_ <= d0 && this.ticksUntilNextAttack <= 0) {
         this.resetAttackCooldown();
         if(this.mob.isDraugrBlocking()){
            this.mob.clearActiveItem();
            this.mob.setShieldCooldownTime(30);
         }
         this.mob.swingHand(Hand.MAIN_HAND);
         this.mob.tryAttack(p_25557_);
      }

   }

   protected void resetAttackCooldown() {
      this.ticksUntilNextAttack = this.getTickCount(20);
   }

   protected boolean isTimeToAttack() {
      return this.ticksUntilNextAttack <= 0;
   }

   protected int getTicksUntilNextAttack() {
      return this.ticksUntilNextAttack;
   }

   protected int getAttackInterval() {
      return this.getTickCount(20);
   }

   protected double getAttackReachSqr(LivingEntity p_25556_) {
      float f = this.mob.getWidth();
      return f * 2.25F * f * 2.25F + p_25556_.getWidth();
   }
}