package com.github.l_ender.cataclysm.entity.etc;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.message.MessageUpdateBossBar;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class CMBossInfoServer extends ServerBossBar {

    private int renderType;

    public CMBossInfoServer(Text component, BossBar.Color bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, Style.PROGRESS);
        this.setDarkenSky(dark);
        this.renderType = renderType;
    }


    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
//            Cataclysm.sendMSGToAll(new MessageUpdateBossBar(this.getUuid(), renderType));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }


    public void addPlayer(ServerPlayerEntity serverPlayer) {
//        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getUuid(), renderType), serverPlayer);
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayerEntity serverPlayer) {
//        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getUuid(), -1), serverPlayer);
        super.removePlayer(serverPlayer);
    }

}
