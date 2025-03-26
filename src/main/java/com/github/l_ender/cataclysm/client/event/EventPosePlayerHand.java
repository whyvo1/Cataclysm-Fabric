package com.github.l_ender.cataclysm.client.event;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.stat.Stats;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;



@Environment(EnvType.CLIENT)
public class EventPosePlayerHand {
    private LivingEntity entityIn;
    private BipedEntityModel model;
    private boolean left;
    private Result result = Result.DEFAULT;

    public EventPosePlayerHand(LivingEntity entityIn, BipedEntityModel model, boolean left) {
        this.entityIn = entityIn;
        this.model = model;
        this.left = left;
    }

    public Entity getEntityIn() {
        return entityIn;
    }

    public BipedEntityModel getModel() {
        return model;
    }

    public boolean isLeftHand() {
        return left;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }
    public static enum Result {
        /**
         * A spawn attempt will always be made, bypassing all rules described in {@link #DEFAULT}.
         */
        ALLOW,

        /**
         * A spawn attempt will only be made if the dimension does not have skylight
         * <b>or</b> the player's Y-level is above sea level and they can see the sky.
         * <p>
         * Additionally, the local difficulty must be higher than a random threshold in [0, 3)
         * and a random number check based on the player's {@link Stats#TIME_SINCE_REST} must succeed.
         */
        DEFAULT,

        /**
         * A spawn attempt will never be made.
         */
        DENY;
    }
}
