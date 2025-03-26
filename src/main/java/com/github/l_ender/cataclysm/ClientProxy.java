package com.github.l_ender.cataclysm;

import com.github.l_ender.cataclysm.client.particle.*;
import com.github.l_ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.l_ender.cataclysm.client.render.blockentity.*;
import com.github.l_ender.cataclysm.client.render.entity.*;
import com.github.l_ender.cataclysm.client.render.etc.CurioHeadRenderer;
import com.github.l_ender.cataclysm.client.render.item.CMItemRenderProperties;
import com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer.Blazing_Grips_Renderer;
import com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSandstorm_In_A_Bottle;
import com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSticky_Gloves;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.l_ender.cataclysm.client.sound.MeatShredderSound;
import com.github.l_ender.cataclysm.client.sound.SandstormSound;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.l_ender.cataclysm.init.*;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.*;

@Environment(EnvType.CLIENT)
//@Mod.EventBusSubscriber(modid = Cataclysm.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final Int2ObjectMap<MovingSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<BlockEntity, MovingSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<>();
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();
    public static List<UUID> blockedEntityRenders = new ArrayList<>();
    private Entity referencedMob = null;
//    public void init() {
//       // FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientLayerEvent::onAddLayers);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupParticles);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerKeybinds);
//    }

    public void setupParticles() {
        Cataclysm.LOGGER.debug("Registered particle factories");
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();
        registry.register(ModParticle.SPARK, SparkParticle.Factory::new);
        registry.register(ModParticle.SOUL_LAVA, SoulLavaParticle.Factory::new);
        registry.register(ModParticle.CURSED_FLAME, CursedFlameParticle.Provider::new);
        registry.register(ModParticle.SMALL_CURSED_FLAME, CursedFlameParticle.SmallFlameProvider::new);
        registry.register(ModParticle.PHANTOM_WING_FLAME, Phantom_Wing_FlameParticle.EmissiveProvider::new);
        registry.register(ModParticle.EM_PULSE, new EM_PulseParticle.Factory());
        registry.register(ModParticle.SHOCK_WAVE, new Shock_WaveParticle.Factory());
        registry.register(ModParticle.LIGHTNING, new LightningParticle.Factory());
        registry.register(ModParticle.SPARK_TRAIL, new SparkTrailParticle.Factory());
        registry.register(ModParticle.TRACK_LIGHTNING, new TrackLightningParticle.Factory());
        registry.register(ModParticle.STORM, new StormParticle.Factory());
        registry.register(ModParticle.RING, RingParticle.RingFactory::new);
        registry.register(ModParticle.SANDSTORM, SandStormParticle.Factory::new);
        registry.register(ModParticle.TRAP_FLAME, TrapFlameParticle.Factory::new);
        registry.register(ModParticle.LIGHT_TRAIL, new LightTrailParticle.Factory());
        registry.register(ModParticle.FLAME_JET, FlameJetParticle.Factory::new);
        registry.register(ModParticle.FLARE_EXPLODE, CustomExplodeParticle.FlareFactory::new);
    }

    public void clientInit() {
//        ItemRenderer itemRendererIn = MinecraftClient.getInstance().getItemRenderer();
        EntityRendererRegistry.register(ModEntities.ENDER_GOLEM, Ender_Golem_Renderer::new);
        EntityRendererRegistry.register(ModEntities.NETHERITE_MONSTROSITY, New_Netherite_Monstrosity_Renderer::new);
        EntityRendererRegistry.register(ModEntities.NETHERITE_MINISTROSITY, Netherite_Ministrosity_Renderer::new);
//        EntityRendererRegistry.register(ModEntities.OLD_NETHERITE_MONSTROSITY, Netherite_Monstrosity_Renderer::new);
        EntityRendererRegistry.register(ModEntities.LAVA_BOMB, Lava_Bomb_Renderer::new);
        EntityRendererRegistry.register(ModEntities.FLARE_BOMB, Flare_Bomb_Renderer::new);
        EntityRendererRegistry.register(ModEntities.FLAME_JET, RendererNull::new);
//        EntityRendererRegistry.register(ModEntities.NAMELESS_SORCERER, Nameless_Sorcerer_Renderer::new);
        EntityRendererRegistry.register(ModEntities.IGNIS, Ignis_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ENDER_GUARDIAN, Ender_Guardian_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ENDER_GUARDIAN_BULLET, Ender_Guardian_bullet_Renderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_RUNE, Void_Rune_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ENDERMAPTERA, Endermaptera_Renderer::new);
        EntityRendererRegistry.register(ModEntities.IGNITED_REVENANT, Ignited_Revenant_Renderer::new);
        EntityRendererRegistry.register(ModEntities.IGNITED_BERSERKER, Ignited_Berserker_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_HARBINGER, The_Harbinger_Renderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_SCATTER_ARROW, Void_Scatter_Arrow_Renderer::new);
        EntityRendererRegistry.register(ModEntities.POISON_DART, Poison_Dart_Renderer::new);
        EntityRendererRegistry.register(ModEntities.PHANTOM_ARROW, Phantom_Arrow_Renderer::new);
        EntityRendererRegistry.register(ModEntities.SCREEN_SHAKE, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.WITHER_SMOKE_EFFECT, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.ASHEN_BREATH, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.WALL_WATCHER, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.FLAME_STRIKE, Flame_Strike_Renderer::new);
        EntityRendererRegistry.register(ModEntities.BOLT_STRIKE, Boltstrike_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CM_FALLING_BLOCK, Cm_Falling_Block_Renderer::new);
        EntityRendererRegistry.register(ModEntities.IGNIS_FIREBALL, Ignis_Fireball_Renderer::new);
        EntityRendererRegistry.register(ModEntities.IGNIS_ABYSS_FIREBALL, Ignis_Abyss_Fireball_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEATH_LASER_BEAM, Death_Laser_beam_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_BLAST, Abyss_Blast_Renderer::new);
        EntityRendererRegistry.register(ModEntities.MINI_ABYSS_BLAST, Mini_Abyss_Blast_Renderer::new);
        EntityRendererRegistry.register(ModEntities.LASER_BEAM, Laser_Beam_Renderer::new);
        EntityRendererRegistry.register(ModEntities.WITHER_MISSILE, Wither_Missile_Renderer::new);
        EntityRendererRegistry.register(ModEntities.WITHER_HOMING_MISSILE, Wither_Homing_Missile_Renderer::new);
        EntityRendererRegistry.register(ModEntities.WITHER_HOWITZER, Wither_Howitzer_Renderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_HOWITZER, Void_Howitzer_Renderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_VORTEX, Void_Vortex_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_LEVIATHAN, The_Leviathan_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_BABY_LEVIATHAN, The_Baby_Leviathan_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_PORTAL, Abyss_Portal_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_ORB, Abyss_Orb_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_BLAST_PORTAL, Abyss_Blast_Portal_Renderer::new);
        EntityRendererRegistry.register(ModEntities.PORTAL_ABYSS_BLAST, Portal_Abyss_Blast_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPLING, Deepling_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_MINE, Abyss_Mine_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CORAL_SPEAR, Thrown_Coral_Spear_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CORAL_BARDICHE, Thrown_Coral_Bardiche_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPLING_BRUTE, Deepling_Brute_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPLING_PRIEST, Deepling_Priest_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DIMENSIONAL_RIFT, Dimensional_Rift_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPLING_ANGLER, Deepling_Angler_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPLING_WARLOCK, Deepling_Warlock_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSS_MARK, Abyss_Mark_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CORAL_GOLEM, Coral_Golem_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CORALSSUS, Coralssus_Renderer::new);
        EntityRendererRegistry.register(ModEntities.LIONFISH, Lionfish_Renderer::new);
        EntityRendererRegistry.register(ModEntities.TIDAL_HOOK, Tidal_Hook_Renderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_CRAB, Amethyst_Crab_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_ANCIENT_REMNANT, Ancient_Remnant_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_REMNANT, Ancient_Remnant_Rework_Renderer::new);
        EntityRendererRegistry.register(ModEntities.MODERN_REMNANT, Modern_Remnant_Renderer::new);
        EntityRendererRegistry.register(ModEntities.SANDSTORM, Sandstorm_Renderer::new);
        EntityRendererRegistry.register(ModEntities.SANDSTORM_PROJECTILE, Sandstorm_Projectile_Renderer::new);
        EntityRendererRegistry.register(ModEntities.CURSED_SANDSTORM, Cursed_Sandstorm_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_WATCHER, The_Watcher_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_PROWLER, The_Prowler_Renderer::new);
        EntityRendererRegistry.register(ModEntities.KOBOLETON, Koboleton_Renderer::new);
        EntityRendererRegistry.register(ModEntities.KOBOLEDIATOR, Kobolediator_Renderer::new);
        EntityRendererRegistry.register(ModEntities.WADJET, Wadjet_Renderer::new);
        EntityRendererRegistry.register(ModEntities.MALEDICTUS, Maledictus_Renderer::new);
        EntityRendererRegistry.register(ModEntities.DRAUGR, Draugr_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ROYAL_DRAUGR, Royal_Draugr_Renderer::new);
        EntityRendererRegistry.register(ModEntities.ELITE_DRAUGR, Elite_Draugr_Renderer::new);
        EntityRendererRegistry.register(ModEntities.APTRGANGR, Aptrgangr_Renderer::new);
        EntityRendererRegistry.register(ModEntities.AXE_BLADE, Axe_Blade_Renderer::new);
        EntityRendererRegistry.register(ModEntities.PHANTOM_HALBERD, Phantom_Halberd_Renderer::new);
        EntityRendererRegistry.register(ModEntities.EARTHQUAKE, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_DESERT_STELE, Ancient_Desert_Stele_Renderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_CLUSTER_PROJECTILE, Amethyst_Cluster_Projectile_Renderer::new);
        EntityRendererRegistry.register(ModEntities.THE_LEVIATHAN_TONGUE, RendererNull::new);
        EntityRendererRegistry.register(ModEntities.VOID_SHARD, (render) -> new FlyingItemEntityRenderer<>(render, 0.75F, true));
        EntityRendererRegistry.register(ModEntities.EYE_OF_DUNGEON, (render) -> new FlyingItemEntityRenderer<>(render, 1.0F, true));
        EntityRendererRegistry.register(ModEntities.BLAZING_BONE, Blazing_Bone_Renderer::new);
        EntityRendererRegistry.register(ModEntities.LIONFISH_SPIKE, Lionfish_Spike_Renderer::new);
        EntityRendererRegistry.register(ModEntities.TIDAL_TENTACLE, Tidal_Tentacle_Renderer::new);
//        MinecraftForge.EVENT_BUS.register(new ClientEvent());

        try {
            ModelPredicateProviderRegistry.register(ModItems.BULWARK_OF_THE_FLAME, Identifier.ofVanilla("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);
            ModelPredicateProviderRegistry.register(ModItems.SOUL_RENDER, Identifier.ofVanilla("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);
            ModelPredicateProviderRegistry.register(ModItems.CORAL_SPEAR, Identifier.ofVanilla("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);
            ModelPredicateProviderRegistry.register(ModItems.CORAL_BARDICHE, Identifier.ofVanilla("throwing"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);
            ModelPredicateProviderRegistry.register(ModItems.MEAT_SHREDDER, Identifier.ofVanilla("using"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);
//            ModelPredicateProviderRegistry.register(Items.CROSSBOW, Cataclysm.modIdentifier( "void_scatter_arrow"), (stack, world, entity, j) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasProjectile(stack, ModItems.VOID_SCATTER_ARROW) ? 1.0F : 0.0F);
            ModelPredicateProviderRegistry.register(ModItems.CORAL_CHUNK, Identifier.ofVanilla("chunk"), (stack, level, living, j) -> (stack.getCount() % 3 == 0) ? 0.0F : (stack.getCount() % 3 == 1) ? 0.5F : 1.0F);
            ModelPredicateProviderRegistry.register(ModItems.BLACK_STEEL_TARGE, Identifier.ofVanilla("blocking"), (stack, p_239421_1_, p_239421_2_, j) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getActiveItem() == stack ? 1.0F : 0.0F);

        } catch (Exception e) {
            Cataclysm.LOGGER.warn("Could not load item models for weapons");
        }

        BlockEntityRendererFactories.register(ModTileentites.ALTAR_OF_FIRE, RendererAltar_of_Fire::new);
        BlockEntityRendererFactories.register(ModTileentites.ALTAR_OF_VOID, RendererAltar_of_Void::new);
        BlockEntityRendererFactories.register(ModTileentites.DOOR_OF_SEAL, Door_Of_Seal_Renderer::new);
        BlockEntityRendererFactories.register(ModTileentites.CURSED_TOMBSTONE, Cursed_Tombstone_Renderer::new);
        BlockEntityRendererFactories.register(ModTileentites.EMP, RendererEMP::new);
        BlockEntityRendererFactories.register(ModTileentites.MECHANICAL_FUSION_ANVIL, RendererMechanical_fusion_anvil::new);
        BlockEntityRendererFactories.register(ModTileentites.ALTAR_OF_AMETHYST, RendererAltar_of_Amethyst::new);
        BlockEntityRendererFactories.register(ModTileentites.CATACLYSM_SKULL, Cataclysm_Skull_Block_Renderer::new);
        BlockEntityRendererFactories.register(ModTileentites.ALTAR_OF_ABYSS, RendererAltar_of_Abyss::new);
        BlockEntityRendererFactories.register(ModTileentites.ABYSSAL_EGG, RendererAbyssal_Egg::new);

        TrinketRendererRegistry.registerRenderer(ModItems.SANDSTORM_IN_A_BOTTLE, new RendererSandstorm_In_A_Bottle());
        TrinketRendererRegistry.registerRenderer(ModItems.STICKY_GLOVES, new RendererSticky_Gloves());
        TrinketRendererRegistry.registerRenderer(ModItems.KOBOLEDIATOR_SKULL, new CurioHeadRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.APTRGANGR_HEAD, new CurioHeadRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.DRAUGR_HEAD, new CurioHeadRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.BLAZING_GRIPS, new Blazing_Grips_Renderer());

        this.setupParticles();

        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> CMItemstackRenderer.incrementTick());
    }

//    @Environment(EnvType.CLIENT)
//    public static Callable<BuiltinModelItemRenderer> getTEISR() {
//        return CMItemstackRenderer::new;
//    }

    public PlayerEntity getClientSidePlayer() {
        return MinecraftClient.getInstance().player;
    }

    public void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    public void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(MinecraftClient.getInstance().cameraEntity) && MinecraftClient.getInstance().options.getPerspective().isFirstPerson();
    }

    @Override
    public Object getISTERProperties() {
        return new CMItemRenderProperties();
    }

    @Override
    public Object getArmorRenderProperties() {
        return new CustomArmorRenderProperties();
    }

    public void clearSoundCacheFor(Entity entity) {
        ENTITY_SOUND_INSTANCE_MAP.remove(entity.getId());
    }

    public void clearSoundCacheFor(BlockEntity entity) {
        BLOCK_ENTITY_SOUND_INSTANCE_MAP.remove(entity);
    }

    public float getPartialTicks() {
        return MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false);
    }

    public boolean isKeyDown(int keyType) {
        if (keyType == -1) {
            return MinecraftClient.getInstance().options.leftKey.isPressed() || MinecraftClient.getInstance().options.rightKey.isPressed() || MinecraftClient.getInstance().options.forwardKey.isPressed() || MinecraftClient.getInstance().options.backKey.isPressed() || MinecraftClient.getInstance().options.jumpKey.isPressed();
        }
        if (keyType == 0) {
            return MinecraftClient.getInstance().options.jumpKey.isPressed();
        }
        if (keyType == 1) {
            return MinecraftClient.getInstance().options.sprintKey.isPressed();
        }
        if (keyType == 2) {
            return ModKeybind.KEY_ABILITY.wasPressed();
        }
        if (keyType == 3) {
            return MinecraftClient.getInstance().options.attackKey.isPressed();
        }
        if (keyType == 4) {
            return MinecraftClient.getInstance().options.sneakKey.isPressed();
        }
        if (keyType == 5) {
            return ModKeybind.HELMET_KEY_ABILITY.isPressed();
        }
        if (keyType == 6) {
            return ModKeybind.CHESTPLATE_KEY_ABILITY.isPressed();
        }
        if (keyType == 7) {
            return ModKeybind.BOOTS_KEY_ABILITY.isPressed();
        }
        return false;
    }


    @Override
    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
        if (soundEmitter instanceof Entity entity && !entity.getWorld().isClient) {
            return;
        }
        switch (type) {
            case 1:
                if (soundEmitter instanceof LivingEntity livingEntity) {
                    MeatShredderSound sound;
                    MovingSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(livingEntity.getId());
                    if (old == null || !(old instanceof MeatShredderSound shredderSound && shredderSound.isSameEntity(livingEntity))) {
                        sound = new MeatShredderSound(livingEntity);
                        ENTITY_SOUND_INSTANCE_MAP.put(livingEntity.getId(), sound);
                    } else {
                        sound = (MeatShredderSound) old;
                    }
                    if (!MinecraftClient.getInstance().getSoundManager().isPlaying(sound) && sound.canPlay()) {
                        MinecraftClient.getInstance().getSoundManager().playNextTick(sound);
                    }
                }
                break;
            case 2:
                if (soundEmitter instanceof Sandstorm_Entity sandstom) {
                    SandstormSound sound;
                    MovingSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(sandstom.getId());
                    if (old == null || !(old instanceof SandstormSound sandstomSound && sandstomSound.isSameEntity(sandstom))) {
                        sound = new SandstormSound(sandstom);
                        ENTITY_SOUND_INSTANCE_MAP.put(sandstom.getId(), sound);
                    } else {
                        sound = (SandstormSound) old;
                    }
                    if (!MinecraftClient.getInstance().getSoundManager().isPlaying(sound) && sound.canPlay()) {
                        MinecraftClient.getInstance().getSoundManager().playNextTick(sound);
                    }
                }
                break;
        }
    }


    public void removeBossBarRender(UUID bossBar) {
        bossBarRenderTypes.remove(bossBar);
    }

    public void setBossBarRender(UUID bossBar, int renderType) {
        bossBarRenderTypes.put(bossBar, renderType);
    }

}