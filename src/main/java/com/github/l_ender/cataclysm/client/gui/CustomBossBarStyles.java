package com.github.l_ender.cataclysm.client.gui;

import com.github.l_ender.cataclysm.Cataclysm;
import com.whyvo.sbb.style.BossBarStyleApi;
import com.whyvo.sbb.style.BossBarStyleEntry;
import com.whyvo.sbb.style.SimpleBossBarStyle;

public class CustomBossBarStyles {
    public static final BossBarStyleEntry<SimpleBossBarStyle> NETHERITE_MONSTROSITY = registerStyle("netherite_monstrosity", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.netherite_monstrosity").formatted(Formatting.RED),
            Cataclysm.modIdentifier("textures/gui/boss_bar/monstrosity_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/monstrosity_bar_overlay.png"),
            5, 16, 1, 1, -2, -2, 256, 16, 25, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> ENDER_GUARDIAN = registerStyle("ender_guardian", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.ender_guardian").formatted(Formatting.LIGHT_PURPLE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ender_guardian_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ender_guardian_bar_overlay.png"),
            5, 16, 1,1, -2, -2, 256, 16, 25, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> IGNIS = registerStyle("ignis", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.ignis").formatted(Formatting.YELLOW),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ignis_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ignis_bar_overlay.png"),
            5, 16, 1,1, -2, -2, 256, 16, 25,182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> IGNIS_SOUL = registerStyle("ignis_soul", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.ignis").formatted(Formatting.DARK_AQUA),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ignis_soul_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/ignis_soul_bar_overlay.png"),
            5, 16, 1,1, -2, -2, 256, 16, 25, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> HARBINGER = registerStyle("harbinger", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.the_harbinger").formatted(Formatting.DARK_RED),
            Cataclysm.modIdentifier("textures/gui/boss_bar/harbinger_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/harbinger_bar_overlay.png"),
            5, 16, 1,7, -2, -8, 256, 32, 25,182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> LEVIATHAN = registerStyle("leviathan", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.the_leviathan").formatted(Formatting.DARK_PURPLE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/leviathan_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/leviathan_bar_overlay.png"),
            5, 16, 1,2, -4, -4, 256, 16, 25, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> LEVIATHAN_MELTDOWN = registerStyle("leviathan_meltdown", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.the_leviathan").formatted(Formatting.DARK_PURPLE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/leviathan_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/leviathan_meltdown_bar_overlay.png"),
            5, 16, 1,4, -4, -6, 256, 16, 25, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> ANCIENT_REMNANT = registerStyle("ancient_remnant", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.ancient_ancient_remnant").formatted(Formatting.WHITE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/remnant_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/remnant_bar_overlay.png"),
            5, 16, 1,7, -4, -10, 256, 32, 30, 182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> ANCIENT_REMNANT_RAGE = registerStyle("ancient_remnant_rage", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.rage_meter").formatted(Formatting.DARK_PURPLE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/remnant_rage_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/remnant_rage_bar_overlay.png"),
            5, 16, 69,-8, -6,  -8, 256, 16, 15, 48));

    public static final BossBarStyleEntry<SimpleBossBarStyle> MALEDICTUS = registerStyle("maledictus", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.maledictus").formatted(Formatting.DARK_GREEN),
            Cataclysm.modIdentifier("textures/gui/boss_bar/maledictus_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/maledictus_bar_overlay.png"),
            5, 16, 1,7, -6, -9, 256, 32, 25,182));

    public static final BossBarStyleEntry<SimpleBossBarStyle> MALEDICTUS_RAGE = registerStyle("maledictus_rage", new SimpleBossBarStyle(
//            Text.translatable("entity.cataclysm.rage_meter").formatted(Formatting.DARK_PURPLE),
            Cataclysm.modIdentifier("textures/gui/boss_bar/maledictus_rage_bar_base.png"),
            Cataclysm.modIdentifier("textures/gui/boss_bar/maledictus_rage_bar_overlay.png"),
            5, 16, 69,-3, -6,  -8, 256, 16, 15, 48));

    private static BossBarStyleEntry<SimpleBossBarStyle> registerStyle(String name, SimpleBossBarStyle style) {
        return BossBarStyleApi.register(Cataclysm.modIdentifier(name), style);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering boss bar styles for " + Cataclysm.MOD_ID);
    }
}
