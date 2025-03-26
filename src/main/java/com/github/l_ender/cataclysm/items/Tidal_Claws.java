package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.capabilities.HookCapability;
import com.github.l_ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.l_ender.cataclysm.entity.projectile.Tidal_Hook_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.l_ender.cataclysm.entity.util.TidalTentacleUtil;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Tidal_Claws extends Item implements ILeftClick, ModEnchantable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> ClawsAttributes;


    public Tidal_Claws(Settings group) {
        super(group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 7.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.4F, EntityAttributeModifier.Operation.ADDITION));
        this.ClawsAttributes = builder.build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
    }


    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity player) {
        launchTendonsAt(stack, player, entity);
        return super.postHit(stack, entity, player);
    }

    private boolean isCharged(PlayerEntity player, ItemStack stack){
        return player.getAttackCooldownProgress(0.5F) > 0.9F;
    }

    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn){
        if(stack.isOf(ModItems.TIDAL_CLAWS) && (!(playerIn instanceof PlayerEntity) || isCharged((PlayerEntity)playerIn, stack))){
            World worldIn = playerIn.getWorld();
            if(worldIn.isClient()){
                return true;
            }
            Entity closestValid = null;
            Vec3d playerEyes = playerIn.getCameraPosVec(1.0F);
            HitResult hitresult = worldIn.raycast(new RaycastContext(playerEyes, playerEyes.add(playerIn.getRotationVector().multiply(16.0D)), RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, playerIn));
            if (hitresult instanceof EntityHitResult) {
                Entity entity = ((EntityHitResult) hitresult).getEntity();
                if (!entity.equals(playerIn) && !playerIn.isTeammate(entity) && !entity.isTeammate(playerIn) && entity instanceof MobEntity && playerIn.canSee(entity)) {
                    closestValid = entity;
                }
            } else {
                for (Entity entity : worldIn.getNonSpectatingEntities(LivingEntity.class, playerIn.getBoundingBox().expand(16.0D))) {
                    if (!entity.equals(playerIn) && !playerIn.isTeammate(entity) && !entity.isTeammate(playerIn) && entity instanceof MobEntity && playerIn.canSee(entity)) {
                        if (closestValid == null || playerIn.distanceTo(entity) < playerIn.distanceTo(closestValid)) {
                            closestValid = entity;
                        }
                    }
                }
            }
            return launchTendonsAt(stack, playerIn, closestValid);
        }
        return false;
    }

    public boolean launchTendonsAt(ItemStack stack, LivingEntity playerIn, Entity closestValid) {
        World worldIn = playerIn.getWorld();
        TidalTentacleCapability tentacleCapability = ModCapabilities.getOrCreate(playerIn, ModCapabilities.TIDAL_TENTACLE_CAPABILITY);
        if (tentacleCapability != null) {
            if (TidalTentacleUtil.canLaunchTentacles(worldIn, playerIn)) {
                TidalTentacleUtil.retractFarTentacles(worldIn, playerIn);
                if (!worldIn.isClient) {
                    if (closestValid != null) {
                        Tidal_Tentacle_Entity segment = ModEntities.TIDAL_TENTACLE.create(worldIn);
                        segment.copyPositionAndRotation(playerIn);
                        worldIn.spawnEntity(segment);
                        segment.setCreatorEntityUUID(playerIn.getUuid());
                        segment.setFromEntityID(playerIn.getId());
                        segment.setToEntityID(closestValid.getId());
                        segment.copyPositionAndRotation(playerIn);
                        segment.setProgress(0.0F);
                        TidalTentacleUtil.setLastTentacle(playerIn, segment);
                        return true;
                    }
                }
            }

        }
        return false;
    }



    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        HookCapability hookCapability = ModCapabilities.getOrCreate(user, ModCapabilities.HOOK_CAPABILITY);
        if (hookCapability != null) {
            if(!level.isClient) {
                if(!hookCapability.hasHook()) {
                    double maxRange = 30;
                    double maxSpeed = 12;

                    Tidal_Hook_Entity hookshot = new Tidal_Hook_Entity(ModEntities.TIDAL_HOOK, user, level);
                    hookshot.setProperties(stack, maxRange, maxSpeed, user.getPitch(), user.getYaw(), 0f, 1.5f * (float) (maxSpeed / 10));
                    level.spawnEntity(hookshot);
                }
            }
            user.setCurrentHand(hand);
            hookCapability.setHasHook(true);
        }

        return super.use(level, user, hand);
    }

    public ItemStack finishUsing(ItemStack p_40712_, World p_40713_, LivingEntity p_40714_) {
        HookCapability hookCapability = ModCapabilities.getOrCreate(p_40714_, ModCapabilities.HOOK_CAPABILITY);
        if (hookCapability != null) {
            hookCapability.setHasHook(false);
        }
        return super.finishUsing(p_40712_, p_40713_, p_40714_);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        HookCapability hookCapability = ModCapabilities.getOrCreate(user, ModCapabilities.HOOK_CAPABILITY);
        if (hookCapability != null) {
            hookCapability.setHasHook(false);
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    public boolean canMine(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.target == EnchantmentTarget.WEAPON && enchantment != Enchantments.SWEEPING;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.ClawsAttributes : super.getAttributeModifiers(equipmentSlot);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.tidal_claws.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.tidal_claws.desc2").formatted(Formatting.DARK_GREEN));
    }
}