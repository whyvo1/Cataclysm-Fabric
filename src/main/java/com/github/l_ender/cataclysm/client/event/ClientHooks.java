package com.github.l_ender.cataclysm.client.event;


import java.util.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class ClientHooks {
    /**
     * Set of UUIDs of boss bars that belong to Aether bosses.
     */
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();

    public static List<UUID> blockedEntityRenders = new ArrayList<>();

    public static boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(MinecraftClient.getInstance().cameraEntity) && MinecraftClient.getInstance().options.getPerspective().isFirstPerson();
    }

    public static void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    public static void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

}
