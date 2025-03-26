package com.github.l_ender.cataclysm.init;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class ModKeybind {

    public static final KeyBinding KEY_ABILITY = new KeyBinding("key.cataclysm.ability", InputUtil.GLFW_KEY_X, "key.categories.cataclysm");

    public static final KeyBinding HELMET_KEY_ABILITY = new KeyBinding("key.cataclysm.helmet_ability", InputUtil.GLFW_KEY_C, "key.categories.cataclysm");

    public static final KeyBinding CHESTPLATE_KEY_ABILITY = new KeyBinding("key.cataclysm.chestplate_ability", InputUtil.GLFW_KEY_Y, "key.categories.cataclysm");

    public static final KeyBinding BOOTS_KEY_ABILITY = new KeyBinding("key.cataclysm.boots_ability", InputUtil.GLFW_KEY_V, "key.categories.cataclysm");
}
