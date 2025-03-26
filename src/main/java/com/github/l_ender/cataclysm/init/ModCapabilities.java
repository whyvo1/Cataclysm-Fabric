package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.capabilities.*;
import net.minecraft.entity.LivingEntity;

import org.jetbrains.annotations.NotNull;

public final class ModCapabilities {

    public static final CapabilityType<ChargeCapability, LivingEntity> CHARGE_CAPABILITY = CapabilityType.register(ChargeCapability::new);
    public static final CapabilityType<HookCapability, LivingEntity> HOOK_CAPABILITY = CapabilityType.register(HookCapability::new);
    public static final CapabilityType<ParryCapability, LivingEntity> PARRY_CAPABILITY = CapabilityType.register(ParryCapability::new);
    public static final CapabilityType<RenderRushCapability, LivingEntity> RENDER_RUSH_CAPABILITY = CapabilityType.register(RenderRushCapability::new);
    public static final CapabilityType<TidalTentacleCapability, LivingEntity> TIDAL_TENTACLE_CAPABILITY = CapabilityType.register(TidalTentacleCapability::new);
//    public static final Capability<HookCapability.IHookCapability> HOOK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    public static final Capability<TidalTentacleCapability.ITentacleCapability> TENTACLE_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    //public static final Capability<ChargeCapability.IChargeCapability> CHARGE_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    public static final Capability<RenderRushCapability.IRenderRushCapability> RENDER_RUSH_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//
//    public static final Capability<ParryCapability.IParryCapability> PARRY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});


//    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.register(HookCapability.HookCapabilityImp.class);
//        event.register(RenderRushCapability.IRenderRushCapability.class);
//        event.register(ChargeCapability.ChargeCapabilityImp.class);
//        event.register(TidalTentacleCapability.TentacleCapabilityImp.class);
//        event.register(ParryCapability.ParryCapabilityImp.class);
//
//    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering capabilities for " + Cataclysm.MOD_ID);
    }

    public static void attachEntityCapability(LivingEntity living) {
        living.cataclysm$addCapability(CHARGE_CAPABILITY.create(living));
        living.cataclysm$addCapability(HOOK_CAPABILITY.create(living));
        living.cataclysm$addCapability(PARRY_CAPABILITY.create(living));
        living.cataclysm$addCapability(RENDER_RUSH_CAPABILITY.create(living));
        living.cataclysm$addCapability(TIDAL_TENTACLE_CAPABILITY.create(living));
//        e.addCapability(ChargeCapability.ID, new ChargeCapability.ChargeCapabilityImp.ChargeProvider());
//        e.addCapability(RenderRushCapability.ID, new RenderRushCapability.RenderRushCapabilityImp.RenderRushProvider());
//        e.addCapability(TidalTentacleCapability.ID, new TidalTentacleCapability.TentacleCapabilityImp.TentacleProvider());
//        e.addCapability(ParryCapability.ID, new ParryCapability.ParryCapabilityImp.ParryProvider());

    }

    public static <T extends Capability<LivingEntity>> T getOrCreate(@NotNull LivingEntity entity, CapabilityType<T, LivingEntity> type) {
        T capability = entity.cataclysm$getCapability(type);
        if (capability == null) {
            capability = type.create(entity);
            entity.cataclysm$addCapability(capability);
        }
        return capability;
    }

}
