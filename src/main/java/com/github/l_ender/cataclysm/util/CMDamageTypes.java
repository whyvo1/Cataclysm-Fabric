package com.github.l_ender.cataclysm.util;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CMDamageTypes {
    public static final RegistryKey<DamageType> LASER = of("laser");
    public static final RegistryKey<DamageType> DEATHLASER = of("deathlaser");
    public static final RegistryKey<DamageType> EMP = of("emp");
    public static final RegistryKey<DamageType> ABYSSAL_BURN = of("abyssal_burn");
    public static final RegistryKey<DamageType> SHREDDER = of("shredder");
    public static final RegistryKey<DamageType> SWORD_DANCE = of("sword_dance");
    public static final RegistryKey<DamageType> MALEDICTIO = of("maledictio");
    public static final RegistryKey<DamageType> MALEDICTIO_SAGITTA = of("maledictio_sagitta");
    public static final RegistryKey<DamageType> MALEDICTIO_MAGICAE = of("maledictio_magicae");
    public static final RegistryKey<DamageType> MALEDICTIO_ANIMA = of("maledictio_anima");

    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier(name));
    }
    
    
    public static DamageSource createSource(World level, RegistryKey<DamageType> damageType, @Nullable Entity source, @Nullable Entity attacker) {
        return new DamageSource(level.getDamageSources().registry.entryOf(damageType), source, attacker);
    }

    public static DamageSource getDamageSource(World level, RegistryKey<DamageType> type, EntityType<?>... toIgnore) {
        return getEntityDamageSource(level, type, null, toIgnore);
    }

    public static DamageSource getEntityDamageSource(World level, RegistryKey<DamageType> type, @Nullable Entity attacker, EntityType<?>... toIgnore) {
        return getIndirectEntityDamageSource(level, type, attacker, attacker, toIgnore);
    }
    
    public static DamageSource getIndirectEntityDamageSource(World level, RegistryKey<DamageType> type, @Nullable Entity attacker, @Nullable Entity indirectAttacker, EntityType<?>... toIgnore) {
        return toIgnore.length > 0 ? new EntityExcludedDamageSource(level.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(type), toIgnore) : createSource(level, type, attacker, indirectAttacker);
    }
    
    

    public static DamageSource causeLaserDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(LASER), attacker, caster);
    }

    public static DamageSource causeDeathLaserDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(DEATHLASER), attacker, caster);
    }

    public static DamageSource causeShredderDamage(LivingEntity attacker) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(SHREDDER), attacker);
    }

    public static DamageSource causeSwordDanceDamage(LivingEntity attacker) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(SWORD_DANCE), attacker);
    }

    public static DamageSource causeMaledictioDamage(LivingEntity attacker) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(MALEDICTIO), attacker);
    }

    public static DamageSource causeMaledictioSoulDamage(LivingEntity attacker) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(MALEDICTIO_ANIMA), attacker);
    }

    public static DamageSource causeMaledictioSagittaDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(MALEDICTIO_SAGITTA), attacker,caster);
    }

    public static DamageSource causeMaledictioMagicaeDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(MALEDICTIO_MAGICAE), attacker,caster);
    }


}
