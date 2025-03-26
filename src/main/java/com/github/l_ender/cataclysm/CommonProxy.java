package com.github.l_ender.cataclysm;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;



//@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {


    public void init() {
    }
    public PlayerEntity getClientSidePlayer() {
        return null;
    }

    public void clientInit() {
    }

    public void blockRenderingEntity(UUID id) {
    }

    public void releaseRenderingEntity(UUID id) {
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return false;
    }

    public Object getISTERProperties() {
        return null;
    }

    public Object getArmorRenderProperties() {
        return null;
    }

    public void onEntityStatus(Entity entity, byte updateKind) {
    }


    public void clearSoundCacheFor(Entity entity) {

    }

    public float getPartialTicks() {
        return 1.0F;
    }


    public boolean isKeyDown(int keyType) {
        return false;
    }

    public void clearSoundCacheFor(BlockEntity entity) {

    }

    public void playWorldSound(@Nullable Object soundEmitter, byte type) {

    }



    public void removeBossBarRender(UUID bossBar) {
    }

    public void setBossBarRender(UUID bossBar, int renderType) {
    }

}
