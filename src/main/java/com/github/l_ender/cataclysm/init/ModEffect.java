package com.github.l_ender.cataclysm.init;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEffect {

//    public static final DeferredRegister<StatusEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
//            Cataclysm.MODID);

    public static final StatusEffect EFFECTMONSTROUS = registerStatusEffect("monstrous", new EffectMonstrous());

    public static final StatusEffect EFFECTBLAZING_BRAND = registerStatusEffect("blazing_brand", new EffectBlazing_Brand());

    public static final StatusEffect EFFECTSTUN = registerStatusEffect("stun", new EffectStun());

    public static final StatusEffect EFFECTABYSSAL_BURN = registerStatusEffect("abyssal_burn", new EffectAbyssal_Burn());

    public static final StatusEffect EFFECTBONE_FRACTURE = registerStatusEffect("bone_fracture", new EffectBone_Fracture());

    public static final StatusEffect EFFECTABYSSAL_FEAR = registerStatusEffect("abyssal_fear", new EffectAbyssal_Fear());

    public static final StatusEffect EFFECTABYSSAL_CURSE = registerStatusEffect("abyssal_curse", new EffectAbyssal_Curse());

    public static final StatusEffect EFFECTBLESSING_OF_AMETHYST = registerStatusEffect("blessing_of_amethyst", new EffectBlessing_Of_Amethyst());

    public static final StatusEffect EFFECTCURSE_OF_DESERT = registerStatusEffect("curse_of_desert", new EffectCurse_Of_Desert());

    public static final StatusEffect EFFECTGHOST_FORM = registerStatusEffect("ghost_form", new EffectGhostForm());

    public static final StatusEffect EFFECTGHOST_SICKNESS = registerStatusEffect("ghost_sickness", new EffectGhost_Sickness());

    private static StatusEffect registerStatusEffect(String id, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, Cataclysm.modIdentifier(id), statusEffect);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering status effects for " + Cataclysm.MOD_ID);
    }

}
