package com.github.l_ender.cataclysm.entity.etc;

import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class CMBossInfoServer extends ServerBossBar {

    private int renderType;

    public CMBossInfoServer(Text component, Color bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, Style.PROGRESS);
        this.setDarkenSky(dark);
        this.renderType = renderType;
    }


    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
//            PacketDistributor.sendToAllPlayers(new MessageBossBar.Display(this.getUuid(), renderType));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }


    public void addPlayer(ServerPlayerEntity serverPlayer) {
//        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Display(this.getUuid(), renderType));
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayerEntity serverPlayer) {
//        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Remove(this.getUuid(), renderType));
        super.removePlayer(serverPlayer);
    }

}
