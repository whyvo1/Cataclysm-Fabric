package com.github.l_ender.lionfishapi.client.event;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value= EnvType.CLIENT)
public class ClientSetUp {

    private static boolean firstTitleScreenShown = false;
    public static boolean optifinePresent = false;

//    @SubscribeEvent
//    public void showOptifineWarning(ScreenEvent.Init.Post event) {
//        if (firstTitleScreenShown || !(event.getScreen() instanceof TitleScreen)) return;
//
//        if (optifinePresent) {
//            MinecraftClient.getInstance().setScreen(new OptifineWarningScreen(MinecraftClient.getInstance().currentScreen));
//        }
//
//        firstTitleScreenShown = true;
//    }
}
