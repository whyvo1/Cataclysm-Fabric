package com.github.l_ender.cataclysm.client.gui;

import com.whyvo.sbb.style.BossBarStyleEntry;
import com.whyvo.sbb.style.SimpleBossBarStyle;
import com.whyvo.sbb.bossbar.StyledBossBar;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class CustomBossBar extends StyledBossBar<SimpleBossBarStyle> {

    public CustomBossBar(Text displayName, @NotNull BossBarStyleEntry<SimpleBossBarStyle> style, boolean darkenSky) {
        super(displayName, style);
        this.darkenSky = darkenSky;
    }
}
