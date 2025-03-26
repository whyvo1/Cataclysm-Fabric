package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.gui.GUIWeponfusion;
import com.github.l_ender.cataclysm.inventory.WeaponfusionMenu;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModMenu {

//    public static final DeferredRegister<ScreenHandlerType<?>> DEF_REG = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Cataclysm.MODID);

    public static final ScreenHandlerType<WeaponfusionMenu> WEAPON_FUSION = registerscreenHandlerType("weapon_fusion", new ScreenHandlerType<>(WeaponfusionMenu::new, FeatureFlags.DEFAULT_ENABLED_FEATURES));
//    public static final ScreenHandlerType<MinistrostiyMenu> MINISTROSTIY_MENU = registerscreenHandlerType("ministrosity_menu", new ScreenHandlerType<>(MinistrostiyMenu::new, FeatureFlags.DEFAULT_ENABLED_FEATURES));


    private static <T extends ScreenHandler> ScreenHandlerType<T> registerscreenHandlerType(String id, ScreenHandlerType<T> screenHandlerType) {
        return Registry.register(Registries.SCREEN_HANDLER, Cataclysm.modIdentifier(id), screenHandlerType);
    }

    public static void registerClient() {
        HandledScreens.register(WEAPON_FUSION, GUIWeponfusion::new);
//        HandledScreens.register(MINISTROSTIY_MENU, MinistrosityInventoryScreen::new);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering screen handlers for " + Cataclysm.MOD_ID);
    }

}
