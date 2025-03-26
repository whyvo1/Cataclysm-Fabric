package com.github.l_ender.lionfishapi.server.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.ActionResult;

@FunctionalInterface
public interface StandOnFluidCallback {

    Event<StandOnFluidCallback> EVENT = EventFactory.createArrayBacked(StandOnFluidCallback.class, listeners -> (entity, fluidState) -> {
        for (StandOnFluidCallback listener : listeners) {
            ActionResult result = listener.interact(entity, fluidState);
            if(result != ActionResult.PASS) {
                return result;
            }
        }
        return ActionResult.PASS;
    });

    ActionResult interact(LivingEntity entity, FluidState fluidState);
}
