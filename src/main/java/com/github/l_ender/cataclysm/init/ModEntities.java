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
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;

import java.util.function.Predicate;

//@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

//    public static final DeferredRegister<EntityType<?> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Cataclysm.MODID);


    public static final EntityType<Ender_Golem_Entity> ENDER_GOLEM = registerEntityType("ender_golem", createFabricEntityTypeBuilder(Ender_Golem_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.5F, 3.5F))
            .fireImmune()
            .build());

    public static final EntityType<Ender_Guardian_Entity> ENDER_GUARDIAN = registerEntityType("ender_guardian", createFabricEntityTypeBuilder(Ender_Guardian_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.5F, 3.8F))
            .fireImmune()
            .trackRangeChunks(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Old_Netherite_Monstrosity_Entity> OLD_NETHERITE_MONSTROSITY = registerEntityType("old_netherite_monstrosity", createFabricEntityTypeBuilder(Old_Netherite_Monstrosity_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(3.0f, 5.75F))
            .fireImmune()
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Netherite_Monstrosity_Entity> NETHERITE_MONSTROSITY = registerEntityType("netherite_monstrosity", createFabricEntityTypeBuilder(Netherite_Monstrosity_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(3.0f, 5.75F))
            .fireImmune()
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Netherite_Ministrosity_Entity> NETHERITE_MINISTROSITY  = registerEntityType("netherite_ministrosity", createFabricEntityTypeBuilder(Netherite_Ministrosity_Entity::new, SpawnGroup.CREATURE)
            .dimensions(EntityDimensions.changing(0.5F, 0.9F))
            .trackRangeChunks(10)
            .fireImmune()
            .build());

    public static final EntityType<Lava_Bomb_Entity> LAVA_BOMB = registerEntityType("lava_bomb", ModEntities.<Lava_Bomb_Entity>createFabricEntityTypeBuilder(Lava_Bomb_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Flare_Bomb_Entity> FLARE_BOMB = registerEntityType("flare_bomb", ModEntities.<Flare_Bomb_Entity>createFabricEntityTypeBuilder(Flare_Bomb_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Flame_Jet_Entity> FLAME_JET = registerEntityType("flame_jet", ModEntities.<Flame_Jet_Entity>createFabricEntityTypeBuilder(Flame_Jet_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.6F, 2.5F))
            .trackRangeChunks(6)
            .trackedUpdateRate(2)
            .fireImmune()
            .build());

    public static final EntityType<Nameless_Sorcerer_Entity> NAMELESS_SORCERER = registerEntityType("nameless_sorcerer", createFabricEntityTypeBuilder(Nameless_Sorcerer_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 1.95F))
            .build());

    public static final EntityType<Ignis_Entity> IGNIS = registerEntityType("ignis", createFabricEntityTypeBuilder(Ignis_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.25F, 3.5F))
            .fireImmune()
            .trackRangeChunks(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Ender_Guardian_Bullet_Entity> ENDER_GUARDIAN_BULLET = registerEntityType("ender_guardian_bullet", ModEntities.<Ender_Guardian_Bullet_Entity>createFabricEntityTypeBuilder(Ender_Guardian_Bullet_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.3125f, 0.3125F))
            .trackedUpdateRate(1)
            .trackRangeChunks(64)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Void_Rune_Entity> VOID_RUNE = registerEntityType("void_rune", ModEntities.<Void_Rune_Entity>createFabricEntityTypeBuilder(Void_Rune_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.6F, 1.95F))
            .trackRangeChunks(6)
            .trackedUpdateRate(2)
            .fireImmune()
            .build());

    public static final EntityType<Abyss_Mine_Entity> ABYSS_MINE = registerEntityType("abyss_mine", ModEntities.<Abyss_Mine_Entity>createFabricEntityTypeBuilder(Abyss_Mine_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(1.0F, 1.0F))
            .trackRangeChunks(6)
            .trackedUpdateRate(2)
            .fireImmune()
            .build());

    public static final EntityType<Endermaptera_Entity> ENDERMAPTERA = registerEntityType("endermaptera", createFabricEntityTypeBuilder(Endermaptera_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(1.2F, 0.8F))
            .fireImmune()
            .build());

    public static final EntityType<Deepling_Entity> DEEPLING = registerEntityType("deepling", ModEntities.<Deepling_Entity>createFabricEntityTypeBuilder(Deepling_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 2.3F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Deepling_Brute_Entity> DEEPLING_BRUTE = registerEntityType("deepling_brute", ModEntities.<Deepling_Brute_Entity>createFabricEntityTypeBuilder(Deepling_Brute_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.7F, 2.6F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Deepling_Angler_Entity> DEEPLING_ANGLER = registerEntityType("deepling_angler", createFabricEntityTypeBuilder(Deepling_Angler_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.65F, 2.45F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Deepling_Priest_Entity> DEEPLING_PRIEST = registerEntityType("deepling_priest", createFabricEntityTypeBuilder(Deepling_Priest_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 2.3F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Deepling_Warlock_Entity> DEEPLING_WARLOCK = registerEntityType("deepling_warlock", createFabricEntityTypeBuilder(Deepling_Warlock_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 2.3F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Abyss_Mark_Entity> ABYSS_MARK = registerEntityType("abyss_mark", ModEntities.<Abyss_Mark_Entity>createFabricEntityTypeBuilder(Abyss_Mark_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Lionfish_Entity> LIONFISH = registerEntityType("lionfish", createFabricEntityTypeBuilder(Lionfish_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 0.55F))
            .trackRangeChunks(6)
            .build());

    public static final EntityType<Coral_Golem_Entity> CORAL_GOLEM = registerEntityType("coral_golem", createFabricEntityTypeBuilder(Coral_Golem_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.5F, 2.7F))
            .trackRangeChunks(10)
            .build());

    public static final EntityType<Coralssus_Entity> CORALSSUS = registerEntityType("coralssus", createFabricEntityTypeBuilder(Coralssus_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.75F, 2.85F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Ignited_Revenant_Entity> IGNITED_REVENANT = registerEntityType("ignited_revenant", createFabricEntityTypeBuilder(Ignited_Revenant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(1.6F, 2.8F))
            .fireImmune()
            .build());

    public static final EntityType<Ignited_Berserker_Entity> IGNITED_BERSERKER = registerEntityType("ignited_berserker", createFabricEntityTypeBuilder(Ignited_Berserker_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(1.0F, 2.4F))
            .fireImmune()
            .build());

    public static final EntityType<The_Harbinger_Entity> THE_HARBINGER = registerEntityType("the_harbinger", createFabricEntityTypeBuilder(The_Harbinger_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(1.6F, 3.75F))
            .fireImmune()
            .specificSpawnBlocks(Blocks.WITHER_ROSE)
            .trackRangeChunks(10)
            .build());

    public static final EntityType<The_Watcher_Entity> THE_WATCHER = registerEntityType("the_watcher", createFabricEntityTypeBuilder(The_Watcher_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.85F, 0.85F))
            .fireImmune()
            .build());

    public static final EntityType<The_Prowler_Entity> THE_PROWLER = registerEntityType("the_prowler", createFabricEntityTypeBuilder(The_Prowler_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.5F, 2.75F))
            .fireImmune()
            .trackRangeChunks(8)
            .build());

    public static final EntityType<The_Leviathan_Entity> THE_LEVIATHAN = registerEntityType("the_leviathan", createFabricEntityTypeBuilder(The_Leviathan_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(4.5F, 3F))
            .fireImmune()
            .trackRangeChunks(8)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<The_Baby_Leviathan_Entity> THE_BABY_LEVIATHAN = registerEntityType("the_baby_leviathan", createFabricEntityTypeBuilder(The_Baby_Leviathan_Entity::new, SpawnGroup.CREATURE)
            .dimensions(EntityDimensions.changing(0.75F, 0.42F))
            .trackRangeChunks(10)
            .fireImmune()
            .build());

    public static final EntityType<Void_Scatter_Arrow_Entity> VOID_SCATTER_ARROW = registerEntityType("void_scatter_arrow", ModEntities.<Void_Scatter_Arrow_Entity>createFabricEntityTypeBuilder(Void_Scatter_Arrow_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
//            .setCustomClientFactory(Void_Scatter_Arrow_Entity::new)
            .trackedUpdateRate(20)
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Poison_Dart_Entity> POISON_DART = registerEntityType("poison_dart", ModEntities.<Poison_Dart_Entity>createFabricEntityTypeBuilder(Poison_Dart_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
//            .setCustomClientFactory(Poison_Dart_Entity::new)
            .trackedUpdateRate(20)
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Phantom_Arrow_Entity> PHANTOM_ARROW = registerEntityType("phantom_arrow", ModEntities.<Phantom_Arrow_Entity>createFabricEntityTypeBuilder(Phantom_Arrow_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
//            .setCustomClientFactory(Phantom_Arrow_Entity::new)
            .trackedUpdateRate(1)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Phantom_Halberd_Entity> PHANTOM_HALBERD = registerEntityType("phantom_halberd", ModEntities.<Phantom_Halberd_Entity>createFabricEntityTypeBuilder(Phantom_Halberd_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.6F, 1.95F))
            .trackRangeChunks(6)
            .trackedUpdateRate(2)
            .fireImmune()
            .build());

    public static final EntityType<Void_Shard_Entity> VOID_SHARD = registerEntityType("void_shard", ModEntities.<Void_Shard_Entity>createFabricEntityTypeBuilder(Void_Shard_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
//            .setCustomClientFactory(Void_Shard_Entity::new)
            .trackedUpdateRate(20)
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Blazing_Bone_Entity> BLAZING_BONE = registerEntityType("blazing_bone", ModEntities.<Blazing_Bone_Entity>createFabricEntityTypeBuilder(Blazing_Bone_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .trackedUpdateRate(20)
            .trackRangeChunks(4)
            .build());

    public static final EntityType<Lionfish_Spike_Entity> LIONFISH_SPIKE = registerEntityType("lionfish_spike", ModEntities.<Lionfish_Spike_Entity>createFabricEntityTypeBuilder(Lionfish_Spike_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .trackedUpdateRate(20)
            .trackRangeChunks(4)
            .build());

    public static final EntityType<ScreenShake_Entity> SCREEN_SHAKE = registerEntityType("screen_shake", ModEntities.<ScreenShake_Entity>createFabricEntityTypeBuilder(ScreenShake_Entity::new, SpawnGroup.MISC)
            .disableSummon()
            .dimensions(EntityDimensions.changing(0.0f, 0.0F))
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build());


    public static final EntityType<Cm_Falling_Block_Entity> CM_FALLING_BLOCK = registerEntityType("cm_falling_block", ModEntities.<Cm_Falling_Block_Entity>createFabricEntityTypeBuilder(Cm_Falling_Block_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.98F, 0.98F))
            .trackRangeChunks(10)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Ignis_Fireball_Entity> IGNIS_FIREBALL = registerEntityType("ignis_fireball", ModEntities.<Ignis_Fireball_Entity>createFabricEntityTypeBuilder(Ignis_Fireball_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.6F, 0.6F))
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Ignis_Abyss_Fireball_Entity> IGNIS_ABYSS_FIREBALL = registerEntityType("ignis_abyss_fireball", ModEntities.<Ignis_Abyss_Fireball_Entity>createFabricEntityTypeBuilder(Ignis_Abyss_Fireball_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.6F, 0.6F))
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Wither_Smoke_Effect_Entity> WITHER_SMOKE_EFFECT = registerEntityType("wither_smoke_effect", ModEntities.<Wither_Smoke_Effect_Entity>createFabricEntityTypeBuilder(Wither_Smoke_Effect_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(6.0F, 0.5F))
            .fireImmune()
            .trackRangeChunks(10).trackedUpdateRate(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Flame_Strike_Entity> FLAME_STRIKE = registerEntityType("flame_strike", ModEntities.<Flame_Strike_Entity>createFabricEntityTypeBuilder(Flame_Strike_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(6.0F, 0.5F))
            .fireImmune()
            .trackRangeChunks(10).trackedUpdateRate(Integer.MAX_VALUE)
            .build());


    public static final EntityType<Boltstrike_Entity> BOLT_STRIKE = registerEntityType("bolt_strike", ModEntities.<Boltstrike_Entity>createFabricEntityTypeBuilder(Boltstrike_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.0F, 0.0F))
            .trackRangeChunks(16)
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build());



    public static final EntityType<Ashen_Breath_Entity> ASHEN_BREATH = registerEntityType("ashen_breath", ModEntities.<Ashen_Breath_Entity>createFabricEntityTypeBuilder(Ashen_Breath_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.0f, 0.0F))
            .fireImmune()
            .trackedUpdateRate(1)
            .build());

    public static final EntityType<Wall_Watcher_Entity> WALL_WATCHER = registerEntityType("wall_watcher", ModEntities.<Wall_Watcher_Entity>createFabricEntityTypeBuilder(Wall_Watcher_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.0F, 0.0F))
            .disableSummon()
            .fireImmune()
            .build());

    public static final EntityType<Death_Laser_Beam_Entity> DEATH_LASER_BEAM = registerEntityType("death_laser_beam", ModEntities.<Death_Laser_Beam_Entity>createFabricEntityTypeBuilder(Death_Laser_Beam_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.1F, 0.1F))
            .fireImmune()
            .build());

    public static final EntityType<Abyss_Blast_Entity> ABYSS_BLAST = registerEntityType("abyss_blast", ModEntities.<Abyss_Blast_Entity>createFabricEntityTypeBuilder(Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.1F, 0.1F))
            .fireImmune()
            .build());

    public static final EntityType<Mini_Abyss_Blast_Entity> MINI_ABYSS_BLAST = registerEntityType("mini_abyss_blast", ModEntities.<Mini_Abyss_Blast_Entity>createFabricEntityTypeBuilder(Mini_Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.1F, 0.1F))
            .fireImmune()
            .build());

    public static final EntityType<Portal_Abyss_Blast_Entity> PORTAL_ABYSS_BLAST = registerEntityType("portal_abyss_blast", ModEntities.<Portal_Abyss_Blast_Entity>createFabricEntityTypeBuilder(Portal_Abyss_Blast_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.1F, 0.1F))
            .fireImmune()
            .build());


    public static final EntityType<Laser_Beam_Entity> LASER_BEAM = registerEntityType("laser_beam", ModEntities.<Laser_Beam_Entity>createFabricEntityTypeBuilder(Laser_Beam_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.3125F, 0.3125F))
            .fireImmune()
            .trackRangeChunks(4)
            .trackedUpdateRate(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Wither_Missile_Entity> WITHER_MISSILE = registerEntityType("wither_missile", ModEntities.<Wither_Missile_Entity>createFabricEntityTypeBuilder(Wither_Missile_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 0.5F))
            .trackRangeChunks(4)
            .trackedUpdateRate(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Wither_Homing_Missile_Entity> WITHER_HOMING_MISSILE = registerEntityType("wither_homing_missile", ModEntities.<Wither_Homing_Missile_Entity>createFabricEntityTypeBuilder(Wither_Homing_Missile_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.25F, 0.25F))
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Wither_Howitzer_Entity> WITHER_HOWITZER = registerEntityType("wither_howitzer", ModEntities.<Wither_Howitzer_Entity>createFabricEntityTypeBuilder(Wither_Howitzer_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Abyss_Orb_Entity> ABYSS_ORB = registerEntityType("abyss_orb", ModEntities.<Abyss_Orb_Entity>createFabricEntityTypeBuilder(Abyss_Orb_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Void_Howitzer_Entity> VOID_HOWITZER = registerEntityType("void_howitzer", ModEntities.<Void_Howitzer_Entity>createFabricEntityTypeBuilder(Void_Howitzer_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .fireImmune()
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Eye_Of_Dungeon_Entity> EYE_OF_DUNGEON = registerEntityType("eye_of_dungeon", ModEntities.<Eye_Of_Dungeon_Entity>createFabricEntityTypeBuilder(Eye_Of_Dungeon_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.25F, 0.25F))
            .trackRangeChunks(4)
            .trackedUpdateRate(4)
            .build());

    public static final EntityType<Void_Vortex_Entity> VOID_VORTEX = registerEntityType("void_vortex", ModEntities.<Void_Vortex_Entity>createFabricEntityTypeBuilder(Void_Vortex_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(2.5F, 0.5F))
            .fireImmune()
            .trackRangeChunks(10)
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build());

    public static final EntityType<The_Leviathan_Tongue_Entity> THE_LEVIATHAN_TONGUE = registerEntityType("the_leviathan_tongue", ModEntities.<The_Leviathan_Tongue_Entity>createFabricEntityTypeBuilder(The_Leviathan_Tongue_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 0.5F))
            .build());

    public static final EntityType<Tidal_Tentacle_Entity> TIDAL_TENTACLE = registerEntityType("tidal_tentacle", ModEntities.<Tidal_Tentacle_Entity>createFabricEntityTypeBuilder(Tidal_Tentacle_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.1F, 0.1F))
            .build());

    public static final EntityType<Tidal_Hook_Entity> TIDAL_HOOK = registerEntityType("tidal_hook", ModEntities.<Tidal_Hook_Entity>createFabricEntityTypeBuilder(Tidal_Hook_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 0.5F))
            .build());

    public static final EntityType<Abyss_Portal_Entity> ABYSS_PORTAL = registerEntityType("abyss_portal", ModEntities.<Abyss_Portal_Entity>createFabricEntityTypeBuilder(Abyss_Portal_Entity::new, SpawnGroup.MISC)
            .fireImmune()
            .dimensions(EntityDimensions.changing(3F, 0.15F))
//            .setCustomClientFactory(Abyss_Portal_Entity::new)
            .build());


    public static final EntityType<Abyss_Blast_Portal_Entity> ABYSS_BLAST_PORTAL = registerEntityType("abyss_blast_portal", ModEntities.<Abyss_Blast_Portal_Entity>createFabricEntityTypeBuilder(Abyss_Blast_Portal_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(4.0f, 0.5F))
            .fireImmune()
            .trackRangeChunks(4)
            .trackedUpdateRate(10)
            .build());

    public static final EntityType<ThrownCoral_Spear_Entity> CORAL_SPEAR = registerEntityType("coral_spear", ModEntities.<ThrownCoral_Spear_Entity>createFabricEntityTypeBuilder(ThrownCoral_Spear_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 0.5F))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<ThrownCoral_Bardiche_Entity> CORAL_BARDICHE = registerEntityType("coral_bardiche", ModEntities.<ThrownCoral_Bardiche_Entity>createFabricEntityTypeBuilder(ThrownCoral_Bardiche_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 0.5F))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Dimensional_Rift_Entity> DIMENSIONAL_RIFT = registerEntityType("dimensional_rift", ModEntities.<Dimensional_Rift_Entity>createFabricEntityTypeBuilder(Dimensional_Rift_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(2.0F, 2.0F))
            .fireImmune()
            .trackRangeChunks(10)
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Amethyst_Crab_Entity> AMETHYST_CRAB = registerEntityType("amethyst_crab", createFabricEntityTypeBuilder(Amethyst_Crab_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.5F, 2.6F))
            .fireImmune()
            .build());

    public static final EntityType<EarthQuake_Entity> EARTHQUAKE = registerEntityType("earthquake", ModEntities.<EarthQuake_Entity>createFabricEntityTypeBuilder(EarthQuake_Entity::new, SpawnGroup.MISC)
            .forceTrackedVelocityUpdates(true)
            .trackRangeChunks(20)
            .trackedUpdateRate(1)
            .dimensions(EntityDimensions.changing(0.5f, 0.5F))
            .build());

    public static final EntityType<Amethyst_Cluster_Projectile_Entity> AMETHYST_CLUSTER_PROJECTILE = registerEntityType("amethyst_cluster_projectile", ModEntities.<Amethyst_Cluster_Projectile_Entity>createFabricEntityTypeBuilder(Amethyst_Cluster_Projectile_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5f, 0.0F))
            .fireImmune()
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(20)
            .build());

    public static final EntityType<Ancient_Ancient_Remnant_Entity> ANCIENT_ANCIENT_REMNANT = registerEntityType("ancient_ancient_remnant", createFabricEntityTypeBuilder(Ancient_Ancient_Remnant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(3.8F, 5F))
            .fireImmune()
            .trackRangeChunks(8)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Ancient_Remnant_Entity> ANCIENT_REMNANT = registerEntityType("ancient_remnant", createFabricEntityTypeBuilder(Ancient_Remnant_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(4.35F, 5F))
            .fireImmune()
            .trackRangeChunks(8)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Modern_Remnant_Entity> MODERN_REMNANT = registerEntityType("modern_remnant", createFabricEntityTypeBuilder(Modern_Remnant_Entity::new, SpawnGroup.CREATURE)
            .dimensions(EntityDimensions.changing(0.75F, 0.42F))
            .trackRangeChunks(10)
            .fireImmune()
            .build());

    public static final EntityType<Koboleton_Entity> KOBOLETON = registerEntityType("koboleton", createFabricEntityTypeBuilder(Koboleton_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.85F, 1.6F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Kobolediator_Entity> KOBOLEDIATOR = registerEntityType("kobolediator", createFabricEntityTypeBuilder(Kobolediator_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.4F, 4.4F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Wadjet_Entity> WADJET = registerEntityType("wadjet", createFabricEntityTypeBuilder(Wadjet_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.85F, 3.4F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Sandstorm_Entity> SANDSTORM = registerEntityType("sandstorm", ModEntities.<Sandstorm_Entity>createFabricEntityTypeBuilder(Sandstorm_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(2.5F, 4.5F))
            .fireImmune()
            .trackRangeChunks(10)
            .trackedUpdateRate(Integer.MAX_VALUE)
            .build());

    public static final EntityType<Sandstorm_Projectile> SANDSTORM_PROJECTILE = registerEntityType("sandstorm_projectile", ModEntities.<Sandstorm_Projectile>createFabricEntityTypeBuilder(Sandstorm_Projectile::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 1.0F))
            .trackRangeChunks(4)
            .trackedUpdateRate(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Cursed_Sandstorm_Entity> CURSED_SANDSTORM = registerEntityType("cursed_sandstorm", ModEntities.<Cursed_Sandstorm_Entity>createFabricEntityTypeBuilder(Cursed_Sandstorm_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.5F, 1.0F))
            .forceTrackedVelocityUpdates(true)
            .trackedUpdateRate(1)
            .trackRangeChunks(20)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static final EntityType<Ancient_Desert_Stele_Entity> ANCIENT_DESERT_STELE = registerEntityType("ancient_desert_stele", ModEntities.<Ancient_Desert_Stele_Entity>createFabricEntityTypeBuilder(Ancient_Desert_Stele_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(0.8F, 1.375F))
            .trackRangeChunks(6)
            .trackedUpdateRate(2)
            .forceTrackedVelocityUpdates(true)
            .fireImmune()
            .build());

    public static final EntityType<Maledictus_Entity> MALEDICTUS = registerEntityType("maledictus", createFabricEntityTypeBuilder(Maledictus_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(1.5F, 3.0F))
            .fireImmune()
            .trackRangeChunks(10)
            .forceTrackedVelocityUpdates(true)
            .build());


    public static final EntityType<Draugr_Entity> DRAUGR = registerEntityType("draugr", createFabricEntityTypeBuilder(Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 1.95F))
            .trackRangeChunks(10)
            .build());

    public static final EntityType<Royal_Draugr_Entity> ROYAL_DRAUGR = registerEntityType("royal_draugr", createFabricEntityTypeBuilder(Royal_Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.6F, 1.95F))
            .trackRangeChunks(10)
            .build());

    public static final EntityType<Elite_Draugr_Entity> ELITE_DRAUGR = registerEntityType("elite_draugr", createFabricEntityTypeBuilder(Elite_Draugr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(0.8F, 2.6F))
            .trackRangeChunks(10)
            .build());


    public static final EntityType<Aptrgangr_Entity> APTRGANGR = registerEntityType("aptrgangr", createFabricEntityTypeBuilder(Aptrgangr_Entity::new, SpawnGroup.MONSTER)
            .dimensions(EntityDimensions.changing(2.4F, 4.0F))
            .trackRangeChunks(8)
            .build());

    public static final EntityType<Axe_Blade_Entity> AXE_BLADE = registerEntityType("axe_blade", ModEntities.<Axe_Blade_Entity>createFabricEntityTypeBuilder(Axe_Blade_Entity::new, SpawnGroup.MISC)
            .dimensions(EntityDimensions.changing(1.2F, 2.5F))
            .trackRangeChunks(4)
            .trackedUpdateRate(10)
            .forceTrackedVelocityUpdates(true)
            .build());

    public static Predicate<LivingEntity> buildPredicateFromTag(TagKey<EntityType<?>> entityTag){
        if(entityTag == null){
            return Predicates.alwaysFalse();
        }else{
            return e -> e.isAlive() && e.getType().isIn(entityTag);
        }
    }

    public static boolean rollSpawn(int rolls, Random random, SpawnReason reason){
        if(reason == SpawnReason.SPAWNER){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }

    private static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, Cataclysm.modIdentifier(name), entityType);
    }
    
    private static <T extends Entity> FabricEntityTypeBuilder<T> createFabricEntityTypeBuilder(EntityType.EntityFactory<T> factory, SpawnGroup spawnGroup) {
        return FabricEntityTypeBuilder.create(spawnGroup, factory);
    }

    public static void initializeEntityTypes() {
        SpawnRestriction.register(ENDERMAPTERA, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Endermaptera_Entity::canSpawn);
        SpawnRestriction.register(KOBOLETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Koboleton_Entity::checkKoboletonSpawnRules);
        SpawnRestriction.register(DEEPLING_ANGLER, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Angler_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_BRUTE, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Brute_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_WARLOCK, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Warlock_Entity::candeeplingSpawn);
        SpawnRestriction.register(DEEPLING_PRIEST, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Deepling_Priest_Entity::candeeplingSpawn);
        SpawnRestriction.register(CORAL_GOLEM, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Coral_Golem_Entity::cangolemSpawn);
        SpawnRestriction.register(AMETHYST_CRAB, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Amethyst_Crab_Entity::canCrabSpawnSpawnRules);
        SpawnRestriction.register(IGNITED_BERSERKER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);

        registerDefaultAttribute(ENDER_GOLEM, Ender_Golem_Entity.ender_golem());
        registerDefaultAttribute(NETHERITE_MINISTROSITY, Netherite_Ministrosity_Entity.ministrosity());
        registerDefaultAttribute(NETHERITE_MONSTROSITY, Netherite_Monstrosity_Entity.netherite_monstrosity());
        registerDefaultAttribute(OLD_NETHERITE_MONSTROSITY, Old_Netherite_Monstrosity_Entity.netherite_monstrosity());
        registerDefaultAttribute(NAMELESS_SORCERER, Nameless_Sorcerer_Entity.nameless_sorcerer());
        registerDefaultAttribute(IGNIS, Ignis_Entity.ignis());
        registerDefaultAttribute(ENDER_GUARDIAN, Ender_Guardian_Entity.ender_guardian());
        registerDefaultAttribute(ENDERMAPTERA, Endermaptera_Entity.endermaptera());
        registerDefaultAttribute(IGNITED_REVENANT, Ignited_Revenant_Entity.ignited_revenant());
        registerDefaultAttribute(IGNITED_BERSERKER, Ignited_Berserker_Entity.ignited_berserker());
        registerDefaultAttribute(THE_HARBINGER, The_Harbinger_Entity.harbinger());
        registerDefaultAttribute(THE_LEVIATHAN, The_Leviathan_Entity.leviathan());
        registerDefaultAttribute(THE_BABY_LEVIATHAN, The_Baby_Leviathan_Entity.babyleviathan());
        registerDefaultAttribute(DEEPLING, Deepling_Entity.deepling());
        registerDefaultAttribute(DEEPLING_BRUTE, Deepling_Brute_Entity.deeplingbrute());
        registerDefaultAttribute(DEEPLING_ANGLER, Deepling_Angler_Entity.deepling());
        registerDefaultAttribute(DEEPLING_PRIEST, Deepling_Priest_Entity.deeplingpriest());
        registerDefaultAttribute(DEEPLING_WARLOCK, Deepling_Warlock_Entity.deeplingwarlock());
        registerDefaultAttribute(CORAL_GOLEM, Coral_Golem_Entity.coralgolem());
        registerDefaultAttribute(CORALSSUS, Coralssus_Entity.coralssus());
        registerDefaultAttribute(LIONFISH, Lionfish_Entity.lionfish());
        registerDefaultAttribute(AMETHYST_CRAB, Amethyst_Crab_Entity.amethyst_crab());
        registerDefaultAttribute(ANCIENT_ANCIENT_REMNANT, Ancient_Ancient_Remnant_Entity.ancient_remnant());
        registerDefaultAttribute(MODERN_REMNANT, Modern_Remnant_Entity.modernremnant());
        registerDefaultAttribute(KOBOLETON, Koboleton_Entity.koboleton());
        registerDefaultAttribute(THE_WATCHER, The_Watcher_Entity.the_watcher());
        registerDefaultAttribute(THE_PROWLER, The_Prowler_Entity.the_prowler());
        registerDefaultAttribute(KOBOLEDIATOR, Kobolediator_Entity.kobolediator());
        registerDefaultAttribute(APTRGANGR, Aptrgangr_Entity.aptrgangr());
        registerDefaultAttribute(WADJET, Wadjet_Entity.wadjet());
        registerDefaultAttribute(MALEDICTUS, Maledictus_Entity.maledictus());
        registerDefaultAttribute(ANCIENT_REMNANT, Ancient_Remnant_Entity.maledictus());
        registerDefaultAttribute(DRAUGR, Draugr_Entity.draugr());
        registerDefaultAttribute(ROYAL_DRAUGR, Royal_Draugr_Entity.royal_draugr());
        registerDefaultAttribute(ELITE_DRAUGR, Elite_Draugr_Entity.elite_draugr());
    }

    private static void registerDefaultAttribute(EntityType<? extends LivingEntity> type, DefaultAttributeContainer.Builder builder) {
        FabricDefaultAttributeRegistry.register(type, builder);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering entities for " + Cataclysm.MOD_ID);
    }
}

