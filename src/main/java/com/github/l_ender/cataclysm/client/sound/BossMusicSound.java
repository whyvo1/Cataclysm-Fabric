package com.github.l_ender.cataclysm.client.sound;

import com.github.l_ender.cataclysm.client.tool.ControlledAnimation;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.etc.Animation_Monsters;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class BossMusicSound extends MovingSoundInstance {
    private Animation_Monsters boss;
    private int ticksExisted = 0;
    private int timeUntilFade;

    private final SoundEvent soundEvent;
    ControlledAnimation volumeControl;

    public BossMusicSound(SoundEvent sound, Animation_Monsters boss) {
        super(sound, SoundCategory.RECORDS,boss.getRandom());
        this.boss = boss;
        this.soundEvent = sound;
        this.attenuationType = AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
        this.x = boss.getX();
        this.y = boss.getY();
        this.z = boss.getZ();

        volumeControl = new ControlledAnimation(40);
        volumeControl.setTimer(20);
        volume = volumeControl.getAnimationFraction();
        timeUntilFade = 80;
    }

    public boolean canPlay() {
        return BossMusicPlayer.bossMusic == this;
    }

    public void tick() {
        // If the music should stop playing
        if (boss == null || !boss.isAlive() || boss.isSilent()) {
            // If the boss is dead, skip the fade timer and fade out right away
            if (boss != null && !boss.isAlive()) timeUntilFade = 0;
            boss = null;
            if (timeUntilFade > 0) timeUntilFade--;
            else volumeControl.decreaseTimer();
        }
        // If the music should keep playing
        else {
            volumeControl.increaseTimer();
            timeUntilFade = 60;
        }

        if (volumeControl.getAnimationFraction() < 0.025) {
            setDone();
            BossMusicPlayer.bossMusic = null;
        }

        volume = volumeControl.getAnimationFraction() / CMConfig.BossMusicVolume;

        if (ticksExisted % 100 == 0) {
            MinecraftClient.getInstance().getMusicTracker().stop();
        }
        ticksExisted++;
    }

    public void setBoss(Animation_Monsters boss) {
        this.boss = boss;
    }

    public Animation_Monsters getBoss() {
        return boss;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }
}