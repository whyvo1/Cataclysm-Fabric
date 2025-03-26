package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ModSounds {
    public static final SoundEvent GOLEMDEATH = registerSoundEvent("golemdeath",
            SoundEvent.of(Cataclysm.modIdentifier("golemdeath")));

    public static final SoundEvent GOLEMHURT = registerSoundEvent("golemhurt",
            SoundEvent.of(Cataclysm.modIdentifier("golemhurt")));

    public static final SoundEvent ENDERGUARDIANDEATH = registerSoundEvent("enderguardiandeath",
            SoundEvent.of(Cataclysm.modIdentifier("enderguardiandeath")));

    public static final SoundEvent ENDERGUARDIANHURT = registerSoundEvent("enderguardianhurt",
            SoundEvent.of(Cataclysm.modIdentifier("enderguardianhurt")));

    public static final SoundEvent GOLEMATTACK = registerSoundEvent("golemattack",
            SoundEvent.of(Cataclysm.modIdentifier("golemattack")));

    public static final SoundEvent FLAMETHROWER = registerSoundEvent("flamethrower",
            SoundEvent.of(Cataclysm.modIdentifier("flamethrower")));

    public static final SoundEvent HAMMERTIME = registerSoundEvent("hammertime",
            SoundEvent.of(Cataclysm.modIdentifier("hammertime")));

    public static final SoundEvent STRONGSWING = registerSoundEvent("strongswing",
            SoundEvent.of(Cataclysm.modIdentifier("strongswingattack")));

    public static final SoundEvent SWING = registerSoundEvent("swing",
            SoundEvent.of(Cataclysm.modIdentifier("swingattack")));

    public static final SoundEvent MONSTROSITYSTEP = registerSoundEvent("monstrositystep",
            SoundEvent.of(Cataclysm.modIdentifier("monstrositystep")));

    public static final SoundEvent MONSTROSITYGROWL = registerSoundEvent("monstrositygrowl",
            SoundEvent.of(Cataclysm.modIdentifier("monstrositygrowl")));

    public static final SoundEvent MONSTROSITYDEATH = registerSoundEvent("monstrositydeath",
            SoundEvent.of(Cataclysm.modIdentifier("monstrositydeath")));

    public static final SoundEvent MONSTROSITYAWAKEN = registerSoundEvent("monstrosityawaken",
            SoundEvent.of(Cataclysm.modIdentifier("monstrosityawaken")));

    public static final SoundEvent MONSTROSITYHURT = registerSoundEvent("monstrosityhurt",
            SoundEvent.of(Cataclysm.modIdentifier("monstrosityhurt")));

    public static final SoundEvent MONSTROSITYSHOOT = registerSoundEvent("monstrosityshoot",
            SoundEvent.of(Cataclysm.modIdentifier("monstrosityshoot")));

    public static final SoundEvent MONSTROSITYLAND = registerSoundEvent("monstrosityland",
            SoundEvent.of(Cataclysm.modIdentifier("monstrosityland")));

    public static final SoundEvent MINISTROSITY_HURT = registerSoundEvent("ministrosity_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("ministrosity_hurt")));

    public static final SoundEvent MINISTROSITY_FILL_BUCKET = registerSoundEvent("ministrosity_fill_bucket",
            SoundEvent.of(Cataclysm.modIdentifier("ministrosity_fill_bucket")));

    public static final SoundEvent MONSTROSITY_MUSIC = registerSoundEvent("monstrosity_music",
            SoundEvent.of(Cataclysm.modIdentifier("monstrosity_music")));

    public static final SoundEvent ENDERGUARDIAN_MUSIC = registerSoundEvent("enderguardian_music",
            SoundEvent.of(Cataclysm.modIdentifier("enderguardian_music")));


    public static final SoundEvent IGNIS_MUSIC = registerSoundEvent("ignis_music",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_music")));


    public static final SoundEvent ENDERMAPTERA_HURT = registerSoundEvent("endermaptera_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("endermaptera_hurt")));

    public static final SoundEvent ENDERMAPTERA_AMBIENT = registerSoundEvent("endermaptera_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("endermaptera_ambient")));

    public static final SoundEvent ENDERMAPTERA_STEP = registerSoundEvent("endermaptera_step",
            SoundEvent.of(Cataclysm.modIdentifier("endermaptera_step")));

    public static final SoundEvent ENDERMAPTERA_DEATH = registerSoundEvent("endermaptera_death",
            SoundEvent.of(Cataclysm.modIdentifier("endermaptera_death")));

    public static final SoundEvent ENDER_GUARDIAN_FIST = registerSoundEvent("enderguardianattack",
            SoundEvent.of(Cataclysm.modIdentifier("enderguardianattack")));

    public static final SoundEvent VOID_RUNE_RISING = registerSoundEvent("voidrunerising",
            SoundEvent.of(Cataclysm.modIdentifier("voidrunerising")));

    public static final SoundEvent FLAME_BURST = registerSoundEvent("flame_burst",
            SoundEvent.of(Cataclysm.modIdentifier("flame_burst")));

    public static final SoundEvent IGNIS_AMBIENT = registerSoundEvent("ignis_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_ambient")));

    public static final SoundEvent IGNIS_SHIELD_BREAK = registerSoundEvent("ignisshieldbreak",
            SoundEvent.of(Cataclysm.modIdentifier("ignisshieldbreak")));

    public static final SoundEvent SWORD_STOMP = registerSoundEvent("sword_stomp",
            SoundEvent.of(Cataclysm.modIdentifier("sword_stomp")));

    public static final SoundEvent IGNIS_HURT = registerSoundEvent("ignis_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_hurt")));

    public static final SoundEvent IGNIS_IMPACT = registerSoundEvent("ignis_impact",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_impact")));

    public static final SoundEvent IGNIS_ARMOR_BREAK = registerSoundEvent("ignis_armor_break",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_armor_break")));

    public static final SoundEvent IGNIS_POKE = registerSoundEvent("ignis_poke",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_poke")));

    public static final SoundEvent IGNIS_DEATH = registerSoundEvent("ignis_death",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_death")));

    public static final SoundEvent IGNIS_EARTHQUAKE = registerSoundEvent("ignis_earthquake",
            SoundEvent.of(Cataclysm.modIdentifier("ignis_earthquake")));

    public static final SoundEvent REVENANT_BREATH = registerSoundEvent("revenant_breath",
            SoundEvent.of(Cataclysm.modIdentifier("revenant_breath")));

    public static final SoundEvent REVENANT_HURT = registerSoundEvent("revenant_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("revenant_hurt")));

    public static final SoundEvent REVENANT_DEATH = registerSoundEvent("revenant_death",
            SoundEvent.of(Cataclysm.modIdentifier("revenant_death")));

    public static final SoundEvent REVENANT_IDLE = registerSoundEvent("revenant_idle",
            SoundEvent.of(Cataclysm.modIdentifier("revenant_idle")));

    public static final SoundEvent HARBINGER_LASER = registerSoundEvent("harbinger_laser",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_laser")));

    public static final SoundEvent HARBINGER_MODE_CHANGE = registerSoundEvent("harbinger_mode_change",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_mode_change")));

    public static final SoundEvent HARBINGER_PREPARE = registerSoundEvent("harbinger_prepare",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_prepare")));

    public static final SoundEvent HARBINGER_STUN = registerSoundEvent("harbinger_stun",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_stun")));

    public static final SoundEvent EMP_ACTIVATED = registerSoundEvent("emp_activated",
            SoundEvent.of(Cataclysm.modIdentifier("emp_activated")));

    public static final SoundEvent DEATH_LASER = registerSoundEvent("death_laser",
            SoundEvent.of(Cataclysm.modIdentifier("death_laser")));

    public static final SoundEvent HARBINGER_CHARGE_PREPARE = registerSoundEvent("harbinger_charge_prepare",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_charge_prepare")));

    public static final SoundEvent HARBINGER_CHARGE = registerSoundEvent("harbinger_charge",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_charge")));

    public static final SoundEvent HARBINGER_DEATHLASER_PREPARE = registerSoundEvent("harbinger_deathlaser_prepare",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_deathlaser_prepare")));

    public static final SoundEvent HARBINGER_MUSIC = registerSoundEvent("harbinger_music",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_music")));


    public static final SoundEvent HARBINGER_HURT = registerSoundEvent("harbinger_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_hurt")));

    public static final SoundEvent HARBINGER_IDLE = registerSoundEvent("harbinger_idle",
            SoundEvent.of(Cataclysm.modIdentifier("harbinger_idle")));

    public static final SoundEvent ABYSS_BLAST = registerSoundEvent("abyss_blast",
            SoundEvent.of(Cataclysm.modIdentifier("abyss_blast")));

    public static final SoundEvent ABYSS_BLAST_ONLY_CHARGE = registerSoundEvent("abyss_blast_only_charge",
            SoundEvent.of(Cataclysm.modIdentifier("abyss_blast_only_charge")));

    public static final SoundEvent ABYSS_BLAST_ONLY_SHOOT = registerSoundEvent("abyss_blast_only_shoot",
            SoundEvent.of(Cataclysm.modIdentifier("abyss_blast_only_shoot")));

    public static final SoundEvent LEVIATHAN_DEFEAT = registerSoundEvent("leviathan_defeat",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_defeat")));

    public static final SoundEvent LEVIATHAN_HURT = registerSoundEvent("leviathan_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_hurt")));

    public static final SoundEvent LEVIATHAN_IDLE = registerSoundEvent("leviathan_idle",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_idle")));

    public static final SoundEvent LEVIATHAN_ROAR = registerSoundEvent("leviathan_roar",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_roar")));

    public static final SoundEvent LEVIATHAN_STUN_ROAR = registerSoundEvent("leviathan_stun_roar",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_stun_roar")));

    public static final SoundEvent LEVIATHAN_BITE = registerSoundEvent("leviathan_bite",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_bite")));

    public static final SoundEvent LEVIATHAN_TENTACLE_STRIKE = registerSoundEvent("leviathan_tentacle_strike",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_tentacle_strike")));

    public static final SoundEvent PORTAL_ABYSS_BLAST = registerSoundEvent("portal_abyss_blast",
            SoundEvent.of(Cataclysm.modIdentifier("portal_abyss_blast")));

    public static final SoundEvent DEEPLING_IDLE = registerSoundEvent("deepling_idle",
            SoundEvent.of(Cataclysm.modIdentifier("deepling_idle")));

    public static final SoundEvent DEEPLING_HURT = registerSoundEvent("deepling_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("deepling_hurt")));

    public static final SoundEvent DEEPLING_DEATH = registerSoundEvent("deepling_death",
            SoundEvent.of(Cataclysm.modIdentifier("deepling_death")));

    public static final SoundEvent DEEPLING_SWING = registerSoundEvent("deepling_swing",
            SoundEvent.of(Cataclysm.modIdentifier("deepling_swing")));

    public static final SoundEvent DEEPLING_LIGHT = registerSoundEvent("deepling_light",
            SoundEvent.of(Cataclysm.modIdentifier("deepling_light")));

    public static final SoundEvent BLACK_HOLE_OPENING = registerSoundEvent("black_hole_opening",
            SoundEvent.of(Cataclysm.modIdentifier("black_hole_opening")));

    public static final SoundEvent BLACK_HOLE_CLOSING = registerSoundEvent("black_hole_closing",
            SoundEvent.of(Cataclysm.modIdentifier("black_hole_closing")));

    public static final SoundEvent BLACK_HOLE_LOOP = registerSoundEvent("black_hole_loop",
            SoundEvent.of(Cataclysm.modIdentifier("black_hole_loop")));

    public static final SoundEvent LEVIATHAN_MUSIC = registerSoundEvent("leviathan_music",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_music")));

    public static final SoundEvent LEVIATHAN_MUSIC_1 = registerSoundEvent("leviathan_music_1",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_music_1")));

    public static final SoundEvent LEVIATHAN_MUSIC_2 = registerSoundEvent("leviathan_music_2",
            SoundEvent.of(Cataclysm.modIdentifier("leviathan_music_2")));

    public static final SoundEvent TIDAL_TENTACLE = registerSoundEvent("tidal_tentacle",
            SoundEvent.of(Cataclysm.modIdentifier("tidal_tentacle")));

    public static final SoundEvent TIDAL_HOOK_HIT = registerSoundEvent("tidal_hook_hit",
            SoundEvent.of(Cataclysm.modIdentifier("tidal_hook_hit")));

    public static final SoundEvent TIDAL_HOOK_LOOP = registerSoundEvent("tidal_hook_loop",
            SoundEvent.of(Cataclysm.modIdentifier("tidal_hook_loop")));

    public static final SoundEvent CORAL_GOLEM_HURT = registerSoundEvent("coral_golem_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("coral_golem_hurt")));

    public static final SoundEvent CORAL_GOLEM_DEATH = registerSoundEvent("coral_golem_death",
            SoundEvent.of(Cataclysm.modIdentifier("coral_golem_death")));

    public static final SoundEvent CRAB_DEATH = registerSoundEvent("crab_death",
            SoundEvent.of(Cataclysm.modIdentifier("crab_death")));

    public static final SoundEvent CRAB_HURT = registerSoundEvent("crab_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("crab_hurt")));

    public static final SoundEvent CRAB_BITE = registerSoundEvent("crab_bite",
            SoundEvent.of(Cataclysm.modIdentifier("crab_bite")));

    public static final SoundEvent REMNANT_BITE = registerSoundEvent("remnant_bite",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_bite")));

    public static final SoundEvent REMNANT_BREATHING = registerSoundEvent("remnant_breathing",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_breathing")));

    public static final SoundEvent REMNANT_CHARGE_PREPARE = registerSoundEvent("remnant_charge_prepare",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_charge_prepare")));

    public static final SoundEvent REMNANT_CHARGE_ROAR = registerSoundEvent("remnant_charge_roar",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_charge_roar")));

    public static final SoundEvent REMNANT_CHARGE_STEP = registerSoundEvent("remnant_charge_step",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_charge_step")));

    public static final SoundEvent REMNANT_STOMP = registerSoundEvent("remnant_stomp",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_stomp")));

    public static final SoundEvent REMNANT_HURT = registerSoundEvent("remnant_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_hurt")));

    public static final SoundEvent REMNANT_DEATH = registerSoundEvent("remnant_death",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_death")));

    public static final SoundEvent REMNANT_IDLE = registerSoundEvent("remnant_idle",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_idle")));

    public static final SoundEvent REMNANT_ROAR = registerSoundEvent("remnant_roar",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_roar")));

    public static final SoundEvent REMNANT_SHOCKWAVE = registerSoundEvent("remnant_shockwave",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_shockwave")));

    public static final SoundEvent REMNANT_TAIL_SLAM = registerSoundEvent("remnant_tail_slam",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_tail_slam")));

    public static final SoundEvent REMNANT_TAIL_SLAM_1 = registerSoundEvent("remnant_tail_slam_1",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_tail_slam_1")));

    public static final SoundEvent REMNANT_TAIL_SLAM_2 = registerSoundEvent("remnant_tail_slam_2",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_tail_slam_2")));

    public static final SoundEvent REMNANT_TAIL_SLAM_3 = registerSoundEvent("remnant_tail_slam_3",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_tail_slam_3")));

    public static final SoundEvent REMNANT_TAIL_SWING = registerSoundEvent("remnant_tail_swing",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_tail_swing")));

    public static final SoundEvent MODERN_REMNANT_BITE = registerSoundEvent("modern_remnant_bite",
            SoundEvent.of(Cataclysm.modIdentifier("modern_remnant_bite")));

    public static final SoundEvent MODERN_REMNANT_DEATH = registerSoundEvent("modern_remnant_death",
            SoundEvent.of(Cataclysm.modIdentifier("modern_remnant_death")));

    public static final SoundEvent MODERN_REMNANT_FILL_BUCKET = registerSoundEvent("modern_remnant_fill_bucket",
            SoundEvent.of(Cataclysm.modIdentifier("modern_remnant_fill_bucket")));

    public static final SoundEvent SANDSTORM = registerSoundEvent("sandstorm",
            SoundEvent.of(Cataclysm.modIdentifier("sandstorm")));

    public static final SoundEvent REMNANT_MUSIC = registerSoundEvent("remnant_music",
            SoundEvent.of(Cataclysm.modIdentifier("remnant_music")));

    public static final SoundEvent WATCHER_HURT = registerSoundEvent("watcher_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("watcher_hurt")));

    public static final SoundEvent WATCHER_DEATH = registerSoundEvent("watcher_death",
            SoundEvent.of(Cataclysm.modIdentifier("watcher_death")));

    public static final SoundEvent PROWLER_HURT = registerSoundEvent("prowler_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("prowler_hurt")));

    public static final SoundEvent PROWLER_DEATH = registerSoundEvent("prowler_death",
            SoundEvent.of(Cataclysm.modIdentifier("prowler_death")));

    public static final SoundEvent PROWLER_IDLE = registerSoundEvent("prowler_idle",
            SoundEvent.of(Cataclysm.modIdentifier("prowler_idle")));

    public static final SoundEvent KOBOLETON_AMBIENT = registerSoundEvent("koboleton_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("koboleton_ambient")));

    public static final SoundEvent KOBOLETON_HURT = registerSoundEvent("koboleton_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("koboleton_hurt")));

    public static final SoundEvent KOBOLETON_DEATH = registerSoundEvent("koboleton_death",
            SoundEvent.of(Cataclysm.modIdentifier("koboleton_death")));

    public static final SoundEvent KOBOLETON_STEP = registerSoundEvent("koboleton_step",
            SoundEvent.of(Cataclysm.modIdentifier("koboleton_step")));

    public static final SoundEvent FLAME_TRAP = registerSoundEvent("flame_trap",
            SoundEvent.of(Cataclysm.modIdentifier("flame_trap")));

    public static final SoundEvent SHREDDER_START = registerSoundEvent("shredder_start",
            SoundEvent.of(Cataclysm.modIdentifier("shredder_start")));

    public static final SoundEvent SHREDDER_LOOP = registerSoundEvent("shredder_loop",
            SoundEvent.of(Cataclysm.modIdentifier("shredder_loop")));

    public static final SoundEvent SHREDDER_END = registerSoundEvent("shredder_end",
            SoundEvent.of(Cataclysm.modIdentifier("shredder_end")));

    public static final SoundEvent ROCKET_LAUNCH = registerSoundEvent("rocket_launch",
            SoundEvent.of(Cataclysm.modIdentifier("rocket_launch")));

    public static final SoundEvent PROWLER_SAW_ATTACK = registerSoundEvent("prowler_saw_attack",
            SoundEvent.of(Cataclysm.modIdentifier("prowler_saw_attack")));

    public static final SoundEvent PROWLER_SAW_SPIN_ATTACK = registerSoundEvent("prowler_saw_spin_attack",
            SoundEvent.of(Cataclysm.modIdentifier("prowler_saw_spin_attack")));

    public static final SoundEvent CORALSSUS_AMBIENT = registerSoundEvent("coralssus_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("coralssus_ambient")));

    public static final SoundEvent CORALSSUS_HURT = registerSoundEvent("coralssus_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("coralssus_hurt")));

    public static final SoundEvent CORALSSUS_DEATH = registerSoundEvent("coralssus_death",
            SoundEvent.of(Cataclysm.modIdentifier("coralssus_death")));

    public static final SoundEvent CORALSSUS_ROAR = registerSoundEvent("coralssus_roar",
            SoundEvent.of(Cataclysm.modIdentifier("coralssus_roar")));


    public static final SoundEvent WADJET_AMBIENT = registerSoundEvent("wadjet_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("wadjet_ambient")));

    public static final SoundEvent WADJET_HURT = registerSoundEvent("wadjet_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("wadjet_hurt")));

    public static final SoundEvent WADJET_DEATH = registerSoundEvent("wadjet_death",
            SoundEvent.of(Cataclysm.modIdentifier("wadjet_death")));


    public static final SoundEvent KOBOLEDIATOR_AMBIENT = registerSoundEvent("kobolediator_ambient",
            SoundEvent.of(Cataclysm.modIdentifier("kobolediator_ambient")));

    public static final SoundEvent KOBOLEDIATOR_HURT = registerSoundEvent("kobolediator_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("kobolediator_hurt")));

    public static final SoundEvent KOBOLEDIATOR_DEATH = registerSoundEvent("kobolediator_death",
            SoundEvent.of(Cataclysm.modIdentifier("kobolediator_death")));

    public static final SoundEvent MALEDICTUS_BATTLE_CRY = registerSoundEvent("maledictus_battle_cry",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_battle_cry")));

    public static final SoundEvent MALEDICTUS_HURT = registerSoundEvent("maledictus_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_hurt")));

    public static final SoundEvent MALEDICTUS_LEAP = registerSoundEvent("maledictus_leap",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_leap")));

    public static final SoundEvent MALEDICTUS_MACE_SWING = registerSoundEvent("maledictus_mace_swing",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_mace_swing")));

    public static final SoundEvent MALEDICTUS_BOW_PULL = registerSoundEvent("maledictus_bow_pull",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_bow_pull")));


    public static final SoundEvent MALEDICTUS_IDLE = registerSoundEvent("maledictus_idle",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_idle")));

    public static final SoundEvent MALEDICTUS_JUMP = registerSoundEvent("maledictus_jump",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_jump")));

    public static final SoundEvent MALEDICTUS_SHORT_ROAR = registerSoundEvent("maledictus_short_roar",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_short_roar")));

    public static final SoundEvent MALEDICTUS_DEATH = registerSoundEvent("maledictus_death",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_death")));


    public static final SoundEvent MALEDICTUS_MUSIC = registerSoundEvent("maledictus_music",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_music")));


    public static final SoundEvent MALEDICTUS_MUSIC_DISC = registerSoundEvent("maledictus_music_disc",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_music_disc")));

    public static final SoundEvent PHANTOM_SPEAR = registerSoundEvent("maledictus_spear",
            SoundEvent.of(Cataclysm.modIdentifier("maledictus_spear")));

    public static final SoundEvent AXE_SWING = registerSoundEvent("axe_swing",
            SoundEvent.of(Cataclysm.modIdentifier("axe_swing")));

    public static final SoundEvent DRAUGR_IDLE = registerSoundEvent("draugr_idle",
            SoundEvent.of(Cataclysm.modIdentifier("draugr_idle")));

    public static final SoundEvent DRAUGR_HURT = registerSoundEvent("draugr_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("draugr_hurt")));

    public static final SoundEvent DRAUGR_DEATH = registerSoundEvent("draugr_death",
            SoundEvent.of(Cataclysm.modIdentifier("draugr_death")));

    public static final SoundEvent APTRGANGR_IDLE = registerSoundEvent("aptrgangr_idle",
            SoundEvent.of(Cataclysm.modIdentifier("aptrgangr_idle")));

    public static final SoundEvent APTRGANGR_HURT = registerSoundEvent("aptrgangr_hurt",
            SoundEvent.of(Cataclysm.modIdentifier("aptrgangr_hurt")));

    public static final SoundEvent APTRGANGR_DEATH = registerSoundEvent("aptrgangr_death",
            SoundEvent.of(Cataclysm.modIdentifier("aptrgangr_death")));

    public static final SoundEvent DOOR_OF_SEAL_OPEN = registerSoundEvent("door_of_seal_open",
            SoundEvent.of(Cataclysm.modIdentifier("door_of_seal_open")));

    public static final SoundEvent EXPLOSION = registerSoundEvent("explosion",
            SoundEvent.of(Cataclysm.modIdentifier("explosion")));

    public static final SoundEvent PARRY = registerSoundEvent("parry",
            SoundEvent.of(Cataclysm.modIdentifier("parry")));

    private static SoundEvent registerSoundEvent(String name, SoundEvent sound) {
        return Registry.register(Registries.SOUND_EVENT, Cataclysm.modIdentifier(name), sound);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering sound events for " + Cataclysm.MOD_ID);
    }
}
