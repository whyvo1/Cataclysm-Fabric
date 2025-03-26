package com.github.l_ender.cataclysm.init;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.*;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.*;
import com.github.l_ender.cataclysm.entity.AnimationMonster.Endermaptera_Entity;
import com.github.l_ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.github.l_ender.cataclysm.entity.AnimationMonster.The_Watcher_Entity;
import com.github.l_ender.cataclysm.entity.Deepling.*;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.*;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.l_ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.l_ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.github.l_ender.cataclysm.entity.effect.*;
import com.github.l_ender.cataclysm.entity.projectile.*;
import com.google.common.base.Predicates;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;

import java.util.function.Predicate;

public class ModEntities {

    public static final EntityType<Ender_Golem_Entity> ENDER_GOLEM = registerEntityType("ender_golem", EntityType.Builder.create(Ender_Golem_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.5F, 3.5F)
            .makeFireImmune()
            .build());

    public static final EntityType<Ender_Guardian_Entity> ENDER_GUARDIAN = registerEntityType("ender_guardian", EntityType.Builder.create(Ender_Guardian_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.5F, 3.8F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .alwaysUpdateVelocity(true)
            .build());


    public static final EntityType<Netherite_Monstrosity_Entity> NETHERITE_MONSTROSITY = registerEntityType("netherite_monstrosity", EntityType.Builder.create(Netherite_Monstrosity_Entity::new, SpawnGroup.MONSTER)
            .dimensions(3.0f, 5.75f)
            .makeFireImmune()
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Netherite_Ministrosity_Entity> NETHERITE_MINISTROSITY  = registerEntityType("netherite_ministrosity", EntityType.Builder.create(Netherite_Ministrosity_Entity::new, SpawnGroup.CREATURE)
            .dimensions(0.5F, 0.9F)
            .maxTrackingRange(10)
            .makeFireImmune()
            .build());

    public static final EntityType<Lava_Bomb_Entity> LAVA_BOMB = registerEntityType("lava_bomb", EntityType.Builder.<Lava_Bomb_Entity>create(Lava_Bomb_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Flare_Bomb_Entity> FLARE_BOMB = registerEntityType("flare_bomb", EntityType.Builder.<Flare_Bomb_Entity>create(Flare_Bomb_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Flame_Jet_Entity> FLAME_JET = registerEntityType("flame_jet", EntityType.Builder.<Flame_Jet_Entity>create(Flame_Jet_Entity::new, SpawnGroup.MISC)
            .dimensions(0.6F, 2.5F)
            .maxTrackingRange(6)
            .trackingTickInterval(2)
            .makeFireImmune()
            .build());


    public static final EntityType<Ignis_Entity> IGNIS = registerEntityType("ignis", EntityType.Builder.create(Ignis_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.25F, 3.5F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Ender_Guardian_Bullet_Entity> ENDER_GUARDIAN_BULLET = registerEntityType("ender_guardian_bullet", EntityType.Builder.<Ender_Guardian_Bullet_Entity>create(Ender_Guardian_Bullet_Entity::new, SpawnGroup.MISC)
            .dimensions(0.3125f, 0.3125f)
            .trackingTickInterval(1)
            .maxTrackingRange(64)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Void_Rune_Entity> VOID_RUNE = registerEntityType("void_rune", EntityType.Builder.<Void_Rune_Entity>create(Void_Rune_Entity::new, SpawnGroup.MISC)
            .dimensions(0.6F, 1.95F)
            .maxTrackingRange(6)
            .trackingTickInterval(2)
            .makeFireImmune()
            .build());

    public static final EntityType<Abyss_Mine_Entity> ABYSS_MINE = registerEntityType("abyss_mine", EntityType.Builder.<Abyss_Mine_Entity>create(Abyss_Mine_Entity::new, SpawnGroup.MISC)
            .dimensions(1.0F, 1.0F)
            .maxTrackingRange(6)
            .trackingTickInterval(2)
            .makeFireImmune()
            .build());

    public static final EntityType<Endermaptera_Entity> ENDERMAPTERA = registerEntityType("endermaptera", EntityType.Builder.create(Endermaptera_Entity::new, SpawnGroup.MONSTER)
            .dimensions(1.2F, 0.8f)
            .makeFireImmune()
            .build());

    public static final EntityType<Deepling_Entity> DEEPLING = registerEntityType("deepling", EntityType.Builder.<Deepling_Entity>create(Deepling_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 2.3f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Deepling_Brute_Entity> DEEPLING_BRUTE = registerEntityType("deepling_brute", EntityType.Builder.<Deepling_Brute_Entity>create(Deepling_Brute_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.7F, 2.6f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Deepling_Angler_Entity> DEEPLING_ANGLER = registerEntityType("deepling_angler", EntityType.Builder.create(Deepling_Angler_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.65F, 2.45f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Deepling_Priest_Entity> DEEPLING_PRIEST = registerEntityType("deepling_priest", EntityType.Builder.create(Deepling_Priest_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 2.3f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Deepling_Warlock_Entity> DEEPLING_WARLOCK = registerEntityType("deepling_warlock", EntityType.Builder.create(Deepling_Warlock_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 2.3f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Abyss_Mark_Entity> ABYSS_MARK = registerEntityType("abyss_mark", EntityType.Builder.<Abyss_Mark_Entity>create(Abyss_Mark_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Lionfish_Entity> LIONFISH = registerEntityType("lionfish", EntityType.Builder.create(Lionfish_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 0.55f)
            .maxTrackingRange(6)
            .build());

    public static final EntityType<Coral_Golem_Entity> CORAL_GOLEM = registerEntityType("coral_golem", EntityType.Builder.create(Coral_Golem_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.5F, 2.7F)
            .maxTrackingRange(10)
            .build());

    public static final EntityType<Coralssus_Entity> CORALSSUS = registerEntityType("coralssus", EntityType.Builder.create(Coralssus_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.75F, 2.85F)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Ignited_Revenant_Entity> IGNITED_REVENANT = registerEntityType("ignited_revenant", EntityType.Builder.create(Ignited_Revenant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(1.6F, 2.8f)
            .makeFireImmune()
            .build());

    public static final EntityType<Ignited_Berserker_Entity> IGNITED_BERSERKER = registerEntityType("ignited_berserker", EntityType.Builder.create(Ignited_Berserker_Entity::new, SpawnGroup.MONSTER)
            .dimensions(1.0F, 2.4f)
            .makeFireImmune()
            .build());

    public static final EntityType<The_Harbinger_Entity> THE_HARBINGER = registerEntityType("the_harbinger", EntityType.Builder.create(The_Harbinger_Entity::new, SpawnGroup.MONSTER)
            .dimensions(1.6F, 3.75F)
            .makeFireImmune()
            .allowSpawningInside(Blocks.WITHER_ROSE)
            .maxTrackingRange(10)
            .build());

    public static final EntityType<The_Watcher_Entity> THE_WATCHER = registerEntityType("the_watcher", EntityType.Builder.create(The_Watcher_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.85F, 0.85f)
            .makeFireImmune()
            .build());

    public static final EntityType<The_Prowler_Entity> THE_PROWLER = registerEntityType("the_prowler", EntityType.Builder.create(The_Prowler_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.5F, 2.75F)
            .makeFireImmune()
            .maxTrackingRange(8)
            .build());

    public static final EntityType<The_Leviathan_Entity> THE_LEVIATHAN = registerEntityType("the_leviathan", EntityType.Builder.create(The_Leviathan_Entity::new, SpawnGroup.MONSTER)
            .dimensions(4.5F, 3F)
            .makeFireImmune()
            .maxTrackingRange(8)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<The_Baby_Leviathan_Entity> THE_BABY_LEVIATHAN = registerEntityType("the_baby_leviathan", EntityType.Builder.create(The_Baby_Leviathan_Entity::new, SpawnGroup.CREATURE)
            .dimensions(0.75F, 0.42F)
            .maxTrackingRange(10)
            .makeFireImmune()
            .build());

    public static final EntityType<Void_Scatter_Arrow_Entity> VOID_SCATTER_ARROW = registerEntityType("void_scatter_arrow", EntityType.Builder.<Void_Scatter_Arrow_Entity>create(Void_Scatter_Arrow_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(20)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Poison_Dart_Entity> POISON_DART = registerEntityType("poison_dart", EntityType.Builder.<Poison_Dart_Entity>create(Poison_Dart_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(20)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Phantom_Arrow_Entity> PHANTOM_ARROW = registerEntityType("phantom_arrow", EntityType.Builder.<Phantom_Arrow_Entity>create(Phantom_Arrow_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(1)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Phantom_Halberd_Entity> PHANTOM_HALBERD = registerEntityType("phantom_halberd", EntityType.Builder.<Phantom_Halberd_Entity>create(Phantom_Halberd_Entity::new, SpawnGroup.MISC)
            .dimensions(0.6F, 1.95F)
            .maxTrackingRange(6)
            .trackingTickInterval(2)
            .makeFireImmune()
            .build());

    public static final EntityType<Void_Shard_Entity> VOID_SHARD = registerEntityType("void_shard", EntityType.Builder.<Void_Shard_Entity>create(Void_Shard_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(20)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Blazing_Bone_Entity> BLAZING_BONE = registerEntityType("blazing_bone", EntityType.Builder.<Blazing_Bone_Entity>create(Blazing_Bone_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(20)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Lionfish_Spike_Entity> LIONFISH_SPIKE = registerEntityType("lionfish_spike", EntityType.Builder.<Lionfish_Spike_Entity>create(Lionfish_Spike_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .trackingTickInterval(20)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<ScreenShake_Entity> SCREEN_SHAKE = registerEntityType("screen_shake", EntityType.Builder.<ScreenShake_Entity>create(ScreenShake_Entity::new, SpawnGroup.MISC)
            .disableSummon()
            .dimensions(0.0f, 0.0f)
            .trackingTickInterval(Integer.MAX_VALUE)
            .build());


    public static final EntityType<Cm_Falling_Block_Entity> CM_FALLING_BLOCK = registerEntityType("cm_falling_block", EntityType.Builder.<Cm_Falling_Block_Entity>create(Cm_Falling_Block_Entity::new, SpawnGroup.MISC)
            .dimensions(0.98F, 0.98F)
            .maxTrackingRange(10)
            .trackingTickInterval(20)
            .build());

    public static final EntityType<Ignis_Fireball_Entity> IGNIS_FIREBALL = registerEntityType("ignis_fireball", EntityType.Builder.<Ignis_Fireball_Entity>create(Ignis_Fireball_Entity::new, SpawnGroup.MISC)
            .dimensions(0.6F, 0.6F)
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Ignis_Abyss_Fireball_Entity> IGNIS_ABYSS_FIREBALL = registerEntityType("ignis_abyss_fireball", EntityType.Builder.<Ignis_Abyss_Fireball_Entity>create(Ignis_Abyss_Fireball_Entity::new, SpawnGroup.MISC)
            .dimensions(0.6F, 0.6F)
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Wither_Smoke_Effect_Entity> WITHER_SMOKE_EFFECT = registerEntityType("wither_smoke_effect", EntityType.Builder.<Wither_Smoke_Effect_Entity>create(Wither_Smoke_Effect_Entity::new, SpawnGroup.MISC)
            .dimensions(6.0F, 0.5F)
            .makeFireImmune()
            .maxTrackingRange(10).trackingTickInterval(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Flame_Strike_Entity> FLAME_STRIKE = registerEntityType("flame_strike", EntityType.Builder.<Flame_Strike_Entity>create(Flame_Strike_Entity::new, SpawnGroup.MISC)
            .dimensions(6.0F, 0.5F)
            .makeFireImmune()
            .maxTrackingRange(10).trackingTickInterval(Integer.MAX_VALUE)
            .build());




    public static final EntityType<Bolt_strike_Entity> BOLT_STRIKE = registerEntityType("bolt_strike", EntityType.Builder.<Bolt_strike_Entity>create(Bolt_strike_Entity::new, SpawnGroup.MISC)
            .dimensions(0.0F, 0.0F)
            .maxTrackingRange(16)
            .trackingTickInterval(Integer.MAX_VALUE)
            .build());


    public static final EntityType<Ashen_Breath_Entity> ASHEN_BREATH = registerEntityType("ashen_breath", EntityType.Builder.<Ashen_Breath_Entity>create(Ashen_Breath_Entity::new, SpawnGroup.MISC)
            .dimensions(0.0f, 0.0f)
            .makeFireImmune()
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Wall_Watcher_Entity> WALL_WATCHER = registerEntityType("wall_watcher", EntityType.Builder.<Wall_Watcher_Entity>create(Wall_Watcher_Entity::new, SpawnGroup.MISC)
            .dimensions(0.0F, 0.0F)
            .disableSummon()
            .makeFireImmune()
            .build());

    public static final EntityType<Death_Laser_Beam_Entity> DEATH_LASER_BEAM = registerEntityType("death_laser_beam", EntityType.Builder.<Death_Laser_Beam_Entity>create(Death_Laser_Beam_Entity::new, SpawnGroup.MISC)
            .dimensions(0.1F, 0.1F)
            .makeFireImmune()
            .build());

    public static final EntityType<Abyss_Blast_Entity> ABYSS_BLAST = registerEntityType("abyss_blast", EntityType.Builder.<Abyss_Blast_Entity>create(Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(0.1F, 0.1F)
            .makeFireImmune()
            .build());

    public static final EntityType<Mini_Abyss_Blast_Entity> MINI_ABYSS_BLAST = registerEntityType("mini_abyss_blast", EntityType.Builder.<Mini_Abyss_Blast_Entity>create(Mini_Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(0.1F, 0.1F)
            .makeFireImmune()
            .build());

    public static final EntityType<Portal_Abyss_Blast_Entity> PORTAL_ABYSS_BLAST = registerEntityType("portal_abyss_blast", EntityType.Builder.<Portal_Abyss_Blast_Entity>create(Portal_Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(0.1F, 0.1F)
            .makeFireImmune()
            .build());


    public static final EntityType<Laser_Beam_Entity> LASER_BEAM = registerEntityType("laser_beam", EntityType.Builder.<Laser_Beam_Entity>create(Laser_Beam_Entity::new, SpawnGroup.MISC)
            .dimensions(0.3125F, 0.3125F)
            .makeFireImmune()
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Wither_Missile_Entity> WITHER_MISSILE = registerEntityType("wither_missile", EntityType.Builder.<Wither_Missile_Entity>create(Wither_Missile_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 0.5F)
            .maxTrackingRange(4)
            .build());

    public static final EntityType<Wither_Homing_Missile_Entity> WITHER_HOMING_MISSILE = registerEntityType("wither_homing_missile", EntityType.Builder.<Wither_Homing_Missile_Entity>create(Wither_Homing_Missile_Entity::new, SpawnGroup.MISC)
            .dimensions(0.25F, 0.25F)
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Wither_Howitzer_Entity> WITHER_HOWITZER = registerEntityType("wither_howitzer", EntityType.Builder.<Wither_Howitzer_Entity>create(Wither_Howitzer_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Abyss_Orb_Entity> ABYSS_ORB = registerEntityType("abyss_orb", EntityType.Builder.<Abyss_Orb_Entity>create(Abyss_Orb_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Void_Howitzer_Entity> VOID_HOWITZER = registerEntityType("void_howitzer", EntityType.Builder.<Void_Howitzer_Entity>create(Void_Howitzer_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.5f)
            .makeFireImmune()
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Eye_Of_Dungeon_Entity> EYE_OF_DUNGEON = registerEntityType("eye_of_dungeon", EntityType.Builder.<Eye_Of_Dungeon_Entity>create(Eye_Of_Dungeon_Entity::new, SpawnGroup.MISC)
            .dimensions(0.25F, 0.25F)
            .maxTrackingRange(4)
            .trackingTickInterval(4)
            .build());

    public static final EntityType<Void_Vortex_Entity> VOID_VORTEX = registerEntityType("void_vortex", EntityType.Builder.<Void_Vortex_Entity>create(Void_Vortex_Entity::new, SpawnGroup.MISC)
            .dimensions(2.5F, 0.5F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .trackingTickInterval(Integer.MAX_VALUE)
            .build());

    public static final EntityType<The_Leviathan_Tongue_Entity> THE_LEVIATHAN_TONGUE = registerEntityType("the_leviathan_tongue", EntityType.Builder.<The_Leviathan_Tongue_Entity>create(The_Leviathan_Tongue_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 0.5F)
            .build());

    public static final EntityType<Tidal_Tentacle_Entity> TIDAL_TENTACLE = registerEntityType("tidal_tentacle", EntityType.Builder.<Tidal_Tentacle_Entity>create(Tidal_Tentacle_Entity::new, SpawnGroup.MISC)
            .dimensions(0.1F, 0.1F)
            .build());

    public static final EntityType<Tidal_Hook_Entity> TIDAL_HOOK = registerEntityType("tidal_hook", EntityType.Builder.<Tidal_Hook_Entity>create(Tidal_Hook_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 0.5F)
            .build());

    public static final EntityType<Abyss_Portal_Entity> ABYSS_PORTAL = registerEntityType("abyss_portal", EntityType.Builder.<Abyss_Portal_Entity>create(Abyss_Portal_Entity::new, SpawnGroup.MISC)
            .makeFireImmune()
            .dimensions(3F, 0.15f)
            .build());


    public static final EntityType<Abyss_Blast_Portal_Entity> ABYSS_BLAST_PORTAL = registerEntityType("abyss_blast_portal", EntityType.Builder.<Abyss_Blast_Portal_Entity>create(Abyss_Blast_Portal_Entity::new, SpawnGroup.MISC)
            .dimensions(4.0f, 0.5f)
            .makeFireImmune()
            .maxTrackingRange(4)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<ThrownCoral_Spear_Entity> CORAL_SPEAR = registerEntityType("coral_spear", EntityType.Builder.<ThrownCoral_Spear_Entity>create(ThrownCoral_Spear_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 0.5F)
            .maxTrackingRange(4)
            .trackingTickInterval(20)
            .build());

    public static final EntityType<ThrownCoral_Bardiche_Entity> CORAL_BARDICHE = registerEntityType("coral_bardiche", EntityType.Builder.<ThrownCoral_Bardiche_Entity>create(ThrownCoral_Bardiche_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 0.5F)
            .maxTrackingRange(4)
            .trackingTickInterval(20)
            .build());

    public static final EntityType<Dimensional_Rift_Entity> DIMENSIONAL_RIFT = registerEntityType("dimensional_rift", EntityType.Builder.<Dimensional_Rift_Entity>create(Dimensional_Rift_Entity::new, SpawnGroup.MISC)
            .dimensions(2.0F, 2.0F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .trackingTickInterval(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Amethyst_Crab_Entity> AMETHYST_CRAB = registerEntityType("amethyst_crab", EntityType.Builder.create(Amethyst_Crab_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.5F, 2.6F)
            .makeFireImmune()
            .build());

    public static final EntityType<EarthQuake_Entity> EARTHQUAKE = registerEntityType("earthquake", EntityType.Builder.<EarthQuake_Entity>create(EarthQuake_Entity::new, SpawnGroup.MISC)
            .alwaysUpdateVelocity(true)
            .maxTrackingRange(20)
            .trackingTickInterval(1)
            .dimensions(0.5f, 0.5f)
            .build());

    public static final EntityType<Amethyst_Cluster_Projectile_Entity> AMETHYST_CLUSTER_PROJECTILE = registerEntityType("amethyst_cluster_projectile", EntityType.Builder.<Amethyst_Cluster_Projectile_Entity>create(Amethyst_Cluster_Projectile_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5f, 0.0f)
            .makeFireImmune()
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .build());

    public static final EntityType<Ancient_Ancient_Remnant_Entity> ANCIENT_ANCIENT_REMNANT = registerEntityType("ancient_ancient_remnant", EntityType.Builder.create(Ancient_Ancient_Remnant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(3.8F, 5F)
            .makeFireImmune()
            .maxTrackingRange(8)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Ancient_Remnant_Entity> ANCIENT_REMNANT = registerEntityType("ancient_remnant", EntityType.Builder.create(Ancient_Remnant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(4.35F, 5F)
            .makeFireImmune()
            .maxTrackingRange(8)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Modern_Remnant_Entity> MODERN_REMNANT = registerEntityType("modern_remnant", EntityType.Builder.create(Modern_Remnant_Entity::new, SpawnGroup.CREATURE)
            .dimensions(0.75F, 0.42F)
            .maxTrackingRange(10)
            .makeFireImmune()
            .build());

    public static final EntityType<Koboleton_Entity> KOBOLETON = registerEntityType("koboleton", EntityType.Builder.create(Koboleton_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.85F, 1.6f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Kobolediator_Entity> KOBOLEDIATOR = registerEntityType("kobolediator", EntityType.Builder.create(Kobolediator_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.4F, 4.4f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Wadjet_Entity> WADJET = registerEntityType("wadjet", EntityType.Builder.create(Wadjet_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.85F, 3.4f)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Sandstorm_Entity> SANDSTORM = registerEntityType("sandstorm", EntityType.Builder.<Sandstorm_Entity>create(Sandstorm_Entity::new, SpawnGroup.MISC)
            .dimensions(2.5F, 4.5F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .trackingTickInterval(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Sandstorm_Projectile> SANDSTORM_PROJECTILE = registerEntityType("sandstorm_projectile", EntityType.Builder.<Sandstorm_Projectile>create(Sandstorm_Projectile::new, SpawnGroup.MISC)
            .dimensions(0.5F, 1.0F)
            .maxTrackingRange(4)
            .trackingTickInterval(1)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Cursed_Sandstorm_Entity> CURSED_SANDSTORM = registerEntityType("cursed_sandstorm", EntityType.Builder.<Cursed_Sandstorm_Entity>create(Cursed_Sandstorm_Entity::new, SpawnGroup.MISC)
            .dimensions(0.5F, 1.0F)
            .alwaysUpdateVelocity(true)
            .trackingTickInterval(1)
            .maxTrackingRange(20)
            .alwaysUpdateVelocity(true)
            .build());

    public static final EntityType<Ancient_Desert_Stele_Entity> ANCIENT_DESERT_STELE = registerEntityType("ancient_desert_stele", EntityType.Builder.<Ancient_Desert_Stele_Entity>create(Ancient_Desert_Stele_Entity::new, SpawnGroup.MISC)
            .dimensions(0.8F, 1.375F)
            .maxTrackingRange(6)
            .trackingTickInterval(2)
            .alwaysUpdateVelocity(true)
            .makeFireImmune()
            .build());

    public static final EntityType<Maledictus_Entity> MALEDICTUS = registerEntityType("maledictus", EntityType.Builder.create(Maledictus_Entity::new, SpawnGroup.MONSTER)
            .dimensions(1.5F, 3.0F)
            .makeFireImmune()
            .maxTrackingRange(10)
            .alwaysUpdateVelocity(true)
            .build());


    public static final EntityType<Draugr_Entity> DRAUGR = registerEntityType("draugr", EntityType.Builder.create(Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.95F)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Royal_Draugr_Entity> ROYAL_DRAUGR = registerEntityType("royal_draugr", EntityType.Builder.create(Royal_Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.95F)
            .maxTrackingRange(8)
            .build());

    public static final EntityType<Elite_Draugr_Entity> ELITE_DRAUGR = registerEntityType("elite_draugr", EntityType.Builder.create(Elite_Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(0.8F, 2.6F)
            .maxTrackingRange(8)
            .build());


    public static final EntityType<Aptrgangr_Entity> APTRGANGR = registerEntityType("aptrgangr", EntityType.Builder.create(Aptrgangr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(2.4F, 4.0f)
            .maxTrackingRange(8)
            .build());




    public static final EntityType<Axe_Blade_Entity> AXE_BLADE = registerEntityType("axe_blade", EntityType.Builder.<Axe_Blade_Entity>create(Axe_Blade_Entity::new, SpawnGroup.MISC)
            .dimensions(1.2F, 2.5F)
            .maxTrackingRange(4)
            .trackingTickInterval(1)
            .alwaysUpdateVelocity(true)
            .build());


    public static Predicate<LivingEntity> buildPredicateFromTag(TagKey<EntityType<?>> entityTag){
        if(entityTag == null){
            return Predicates.alwaysFalse();
        }else{
            return (com.google.common.base.Predicate<LivingEntity>) e -> e.isAlive() && e.getType().isIn(entityTag);
        }
    }

    public static boolean rollSpawn(int rolls, Random random, SpawnReason reason){
        if(SpawnReason.isAnySpawner(reason)){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }

    private static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, Cataclysm.modIdentifier(name), entityType);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering entities for " + Cataclysm.MOD_ID);
    }

    public static void initializeEntityTypes() {
        SpawnRestriction.register(ENDERMAPTERA, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Endermaptera_Entity::canSpawn);
        SpawnRestriction.register(KOBOLETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Koboleton_Entity::checkKoboletonSpawnRules);
        SpawnRestriction.register(DEEPLING_ANGLER, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Angler_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_BRUTE, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Brute_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_WARLOCK, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Warlock_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_PRIEST, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Priest_Entity::candeeplingSpawn);
        SpawnRestriction.register(CORAL_GOLEM, SpawnLocationTypes.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Coral_Golem_Entity::cangolemSpawn);
        SpawnRestriction.register(AMETHYST_CRAB, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Amethyst_Crab_Entity::canCrabSpawnSpawnRules);
        SpawnRestriction.register(IGNITED_BERSERKER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);
        FabricDefaultAttributeRegistry.register(ENDER_GOLEM, Ender_Golem_Entity.ender_golem().build());
        FabricDefaultAttributeRegistry.register(NETHERITE_MINISTROSITY, Netherite_Ministrosity_Entity.ministrosity().build());
        FabricDefaultAttributeRegistry.register(NETHERITE_MONSTROSITY, Netherite_Monstrosity_Entity.netherite_monstrosity().build());
        FabricDefaultAttributeRegistry.register(IGNIS, Ignis_Entity.ignis().build());
        FabricDefaultAttributeRegistry.register(ENDER_GUARDIAN, Ender_Guardian_Entity.ender_guardian().build());
        FabricDefaultAttributeRegistry.register(ENDERMAPTERA, Endermaptera_Entity.endermaptera().build());
        FabricDefaultAttributeRegistry.register(IGNITED_REVENANT, Ignited_Revenant_Entity.ignited_revenant().build());
        FabricDefaultAttributeRegistry.register(IGNITED_BERSERKER, Ignited_Berserker_Entity.ignited_berserker().build());
        FabricDefaultAttributeRegistry.register(THE_HARBINGER, The_Harbinger_Entity.harbinger().build());
        FabricDefaultAttributeRegistry.register(THE_LEVIATHAN, The_Leviathan_Entity.leviathan().build());
        FabricDefaultAttributeRegistry.register(THE_BABY_LEVIATHAN, The_Baby_Leviathan_Entity.babyleviathan().build());
        FabricDefaultAttributeRegistry.register(DEEPLING, Deepling_Entity.deepling().build());
        FabricDefaultAttributeRegistry.register(DEEPLING_BRUTE, Deepling_Brute_Entity.deeplingbrute().build());
        FabricDefaultAttributeRegistry.register(DEEPLING_ANGLER, Deepling_Angler_Entity.deepling().build());
        FabricDefaultAttributeRegistry.register(DEEPLING_PRIEST, Deepling_Priest_Entity.deeplingpriest().build());
        FabricDefaultAttributeRegistry.register(DEEPLING_WARLOCK, Deepling_Warlock_Entity.deeplingwarlock().build());
        FabricDefaultAttributeRegistry.register(CORAL_GOLEM, Coral_Golem_Entity.coralgolem().build());
        FabricDefaultAttributeRegistry.register(CORALSSUS, Coralssus_Entity.coralssus().build());
        FabricDefaultAttributeRegistry.register(LIONFISH, Lionfish_Entity.lionfish().build());
        FabricDefaultAttributeRegistry.register(AMETHYST_CRAB, Amethyst_Crab_Entity.amethyst_crab().build());
        FabricDefaultAttributeRegistry.register(ANCIENT_ANCIENT_REMNANT, Ancient_Ancient_Remnant_Entity.ancient_remnant().build());
        FabricDefaultAttributeRegistry.register(MODERN_REMNANT, Modern_Remnant_Entity.modernremnant().build());
        FabricDefaultAttributeRegistry.register(KOBOLETON, Koboleton_Entity.koboleton().build());
        FabricDefaultAttributeRegistry.register(THE_WATCHER, The_Watcher_Entity.the_watcher().build());
        FabricDefaultAttributeRegistry.register(THE_PROWLER, The_Prowler_Entity.the_prowler().build());
        FabricDefaultAttributeRegistry.register(KOBOLEDIATOR, Kobolediator_Entity.kobolediator().build());
        FabricDefaultAttributeRegistry.register(APTRGANGR, Aptrgangr_Entity.aptrgangr().build());
        FabricDefaultAttributeRegistry.register(WADJET, Wadjet_Entity.wadjet().build());
        FabricDefaultAttributeRegistry.register(MALEDICTUS, Maledictus_Entity.maledictus().build());
        FabricDefaultAttributeRegistry.register(ANCIENT_REMNANT, Ancient_Remnant_Entity.maledictus().build());
        FabricDefaultAttributeRegistry.register(DRAUGR, Draugr_Entity.draugr().build());
        FabricDefaultAttributeRegistry.register(ROYAL_DRAUGR, Royal_Draugr_Entity.royal_draugr().build());
        FabricDefaultAttributeRegistry.register(ELITE_DRAUGR, Elite_Draugr_Entity.elite_draugr().build());
    }
}