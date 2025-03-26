package com.github.l_ender.cataclysm.util;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CMDamageTypes {
    public static final RegistryKey<DamageType> LASER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("laser"));
    public static final RegistryKey<DamageType> DEATHLASER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("deathlaser"));
    public static final RegistryKey<DamageType> EMP = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("emp"));
    public static final RegistryKey<DamageType> ABYSSAL_BURN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("abyssal_burn"));
    public static final RegistryKey<DamageType> SHREDDER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("shredder"));
    public static final RegistryKey<DamageType> SWORD_DANCE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("sword_dance"));
    public static final RegistryKey<DamageType> MALEDICTIO = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("maledictio"));
    public static final RegistryKey<DamageType> MALEDICTIO_SAGITTA = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("maledictio_sagitta"));
    public static final RegistryKey<DamageType> MALEDICTIO_MAGICAE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("maledictio_magicae"));
    public static final RegistryKey<DamageType> PENETRATE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("penetrate"));
    public static final RegistryKey<DamageType> MALEDICTIO_ANIMA = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Cataclysm.modIdentifier("maledictio_anima"));

    public static DamageSource causeLaserDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(LASER), attacker, caster);
    }

    public static DamageSource getDamageSource(World level, RegistryKey<DamageType> type, EntityType<?>... toIgnore) {
        return getEntityDamageSource(level, type, null, toIgnore);
    }

    public static DamageSource getEntityDamageSource(World level, RegistryKey<DamageType> type, @Nullable Entity attacker, EntityType<?>... toIgnore) {
        return getIndirectEntityDamageSource(level, type, attacker, attacker, toIgnore);
    }

    public static DamageSource getIndirectEntityDamageSource(World level, RegistryKey<DamageType> type, @Nullable Entity attacker, @Nullable Entity indirectAttacker, EntityType<?>... toIgnore) {
        return toIgnore.length > 0 ? new EntityExcludedDamageSource(level.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(type), toIgnore) : new DamageSource(level.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(type), attacker, indirectAttacker);
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

    public static DamageSource causePenetrateDamage(LivingEntity attacker) {
        return new DamageSource(attacker.getWorld().getRegistryManager().getOptional(RegistryKeys.DAMAGE_TYPE).get().entryOf(PENETRATE), attacker);
    }

}
