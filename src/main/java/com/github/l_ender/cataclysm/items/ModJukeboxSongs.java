package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

public interface ModJukeboxSongs {
    RegistryKey<JukeboxSong> IGNIS_THEME = registerKey("ignis_theme");
    RegistryKey<JukeboxSong> ENDERGUARDIAN_THEME = registerKey("enderguardian_theme");
    RegistryKey<JukeboxSong> HARBINGER_THEME = registerKey("harbinger_theme");
    RegistryKey<JukeboxSong> MONSTROSITY_THEME = registerKey("monstrosity_theme");
    RegistryKey<JukeboxSong> REMNANT_THEME = registerKey("remnant_theme");
    RegistryKey<JukeboxSong> LEVIATHAN_THEME = registerKey("leviathan_theme");
    RegistryKey<JukeboxSong> MALEDICTUS_THEME = registerKey("maledictus_theme");


    private static RegistryKey<JukeboxSong> registerKey(String p_350505_) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Cataclysm.modIdentifier(p_350505_));
    }


//    public static void bootstrap(Registerable<JukeboxSong> p_350269_) {
//        register(p_350269_, IGNIS_THEME,  ModSounds.IGNIS_MUSIC, 153, 15);
//        register(p_350269_, ENDERGUARDIAN_THEME,  ModSounds.ENDERGUARDIAN_MUSIC, 196, 15);
//        register(p_350269_, HARBINGER_THEME,  ModSounds.HARBINGER_MUSIC, 189, 15);
//        register(p_350269_, MONSTROSITY_THEME,  ModSounds.MONSTROSITY_MUSIC, 289, 15);
//        register(p_350269_, REMNANT_THEME,  ModSounds.REMNANT_MUSIC, 212, 15);
//        register(p_350269_, LEVIATHAN_THEME,  ModSounds.LEVIATHAN_MUSIC, 291, 15);
//        register(p_350269_, MALEDICTUS_THEME,  ModSounds.MALEDICTUS_MUSIC_DISC, 201, 15);
//    }

    private static void register(Registerable<JukeboxSong> context, RegistryKey<JukeboxSong> key, RegistryEntry<SoundEvent> sound, float length, int output) {
        context.register(key, new JukeboxSong(sound, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), length, output));
    }

}
