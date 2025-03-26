package com.github.l_ender.cataclysm.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;

public class EffectUtil {
    private static final RegistryEntry<StatusEffect> type = null;

    public EffectUtil(RegistryEntry<StatusEffect> type) {
       type = type;
    }

    public static boolean is(TagKey<StatusEffect> p_270890_) {
        return type.isIn(p_270890_);
    }

    public static boolean is(RegistryKey<StatusEffect> p_276108_) {
        return type.matchesKey(p_276108_);
    }

    public static StatusEffect type() {
        return type.value();
    }

    public static RegistryEntry<StatusEffect> typeHolder() {
        return type;
    }

//    public static void

}
