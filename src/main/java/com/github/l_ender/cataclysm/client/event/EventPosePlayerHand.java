package com.github.l_ender.cataclysm.client.event;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
//@Event.HasResult
public class EventPosePlayerHand {
    private LivingEntity entityIn;
    private BipedEntityModel model;
    private boolean left;

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


}
