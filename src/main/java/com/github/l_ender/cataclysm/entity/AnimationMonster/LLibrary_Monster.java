package com.github.l_ender.cataclysm.entity.AnimationMonster;


import com.github.l_ender.cataclysm.entity.etc.Animation_Monsters;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;

public class LLibrary_Monster extends Animation_Monsters implements IAnimatedEntity, Monster {
    public int animationTick;
    public Animation currentAnimation;


    public LLibrary_Monster(EntityType<? extends LLibrary_Monster> entity, World world) {
        super(entity, world);
    }


    @Override
    public void tick() {
        super.tick();
        AnimationHandler.INSTANCE.updateAnimations(this);
    }

    protected void onDeathAIUpdate() {}

    @Override
    protected void updatePostDeath() {
        if (this.getAnimation() != getDeathAnimation()) {
            AnimationHandler.INSTANCE.sendAnimationMessage(this, getDeathAnimation());
        }
        Animation death;
        if ((death = getDeathAnimation()) != null) {
            onDeathUpdate(death.getDuration() - 20);
        } else {
            onDeathUpdate(20);
        }
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

    @Nullable
    public Animation getDeathAnimation()
    {
        return null;
    }
}
