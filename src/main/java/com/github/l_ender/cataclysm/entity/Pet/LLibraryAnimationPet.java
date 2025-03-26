package com.github.l_ender.cataclysm.entity.Pet;


import com.github.l_ender.cataclysm.entity.etc.IFollower;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.world.World;

public class LLibraryAnimationPet extends AnimationPet implements IAnimatedEntity, IFollower {
    private int animationTick;
    private Animation currentAnimation;

    public LLibraryAnimationPet(EntityType entity, World world) {
        super(entity, world);

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


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }


}
