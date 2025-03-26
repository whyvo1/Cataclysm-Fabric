package com.github.l_ender.cataclysm.client.sound;

import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;

public class SandstormSound extends MovingSoundInstance {
    private final Sandstorm_Entity sandstom;

    public SandstormSound(Sandstorm_Entity sandstom) {
        super(ModSounds.SANDSTORM, SoundCategory.HOSTILE, SoundInstance.createRandom());
        this.sandstom = sandstom;
        this.attenuationType = AttenuationType.LINEAR;
        this.repeat = true;
        this.x = (float)this.sandstom.getX();
        this.y = (float)this.sandstom.getY();
        this.z = (float)this.sandstom.getZ();
        this.repeatDelay = 0;
    }

    public boolean canPlay() {
        return this.sandstom.isAlive() && !this.sandstom.isSilent();
    }

    public void tick() {
        this.x = (float)this.sandstom.getX();
        this.y = (float)this.sandstom.getY();
        this.z = (float)this.sandstom.getZ();
        this.volume = 0.05F;
        this.pitch = 1F;

    }

    public boolean shouldAlwaysPlay() {
        return true;
    }

    public boolean isSameEntity(Sandstorm_Entity entity) {
        return this.sandstom.isAlive() && this.sandstom.getId() == entity.getId();
    }
}
