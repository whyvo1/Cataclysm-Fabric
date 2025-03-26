package com.github.l_ender.cataclysm.entity.AnimationMonster;


import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;

public class Animation_Monster extends HostileEntity implements IAnimatedEntity, Monster{
    public int animationTick;
    public Animation currentAnimation;

    public Animation_Monster(EntityType entity, World world) {
        super(entity, world);
    }


    public  List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return getWorld().getEntitiesByClass(entityClass, getBoundingBox().expand(dX, dY, dZ), e -> e != this && distanceTo(e) <= r + e.getWidth() / 2f && e.getY() <= getY() + dY);
    }

    protected void onAnimationFinish(Animation animation) {}

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION};
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
        return this.currentAnimation;
    }


    @Override
    public void setAnimation(Animation animation) {
        if (animation == NO_ANIMATION) {
            onAnimationFinish(this.currentAnimation);
        }
        this.currentAnimation = animation;
        setAnimationTick(0);
    }

}
