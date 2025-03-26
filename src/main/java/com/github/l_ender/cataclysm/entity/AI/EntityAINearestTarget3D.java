package com.github.l_ender.cataclysm.entity.AI;

import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Box;
import java.util.function.Predicate;

public class EntityAINearestTarget3D<T extends LivingEntity> extends ActiveTargetGoal<T> {
    public EntityAINearestTarget3D(MobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
        super(goalOwnerIn, targetClassIn, checkSight);
    }

    public EntityAINearestTarget3D(MobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
        super(goalOwnerIn, targetClassIn, checkSight, nearbyOnlyIn);
    }

    public EntityAINearestTarget3D(MobEntity goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
    }

    protected Box getSearchBox(double targetDistance) {
        return this.mob.getBoundingBox().expand(targetDistance, targetDistance, targetDistance);
    }

}
