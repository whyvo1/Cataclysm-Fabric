package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Cursed_bow extends BowItem {


    public Cursed_bow(Settings group) {
        super(group);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }
    
    public TypedActionResult<ItemStack> use(World p_40672_, PlayerEntity p_40673_, Hand p_40674_) {
        ItemStack itemstack = p_40673_.getStackInHand(p_40674_);
        boolean flag = !p_40673_.getProjectileType(itemstack).isEmpty();

        if (!p_40673_.getAbilities().creativeMode && !flag) {
            return TypedActionResult.fail(itemstack);
        } else {
            p_40673_.setCurrentHand(p_40674_);
            return TypedActionResult.consume(itemstack);
        }
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getActiveItem().equals(stack);
        int useTime = getUseTime(stack);
        if (level.isClient) {
            NbtCompound tag = stack.getOrCreateNbt();
            if (tag.getInt("PrevUseTime") != tag.getInt("UseTime")) {
                tag.putInt("PrevUseTime", getUseTime(stack));
            }

            int maxLoadTime = getMaxLoadTime();
            if (using && useTime < maxLoadTime) {
                int set = useTime +  1;
                setUseTime(stack, set);
                //Cataclysm.sendMSGToServer(new MessageUpdateItemTag(entity.getId(), stack));
                }
            }
            if (!using && useTime > 0.0F) {
                setUseTime(stack, Math.max(0, useTime - 5));
            }
        }


    private static int getMaxLoadTime() {
        return 20;
    }

    public static int getUseTime(ItemStack stack) {
        NbtCompound compoundtag = stack.getNbt();
        return compoundtag != null ? compoundtag.getInt("UseTime") : 0;
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        NbtCompound tag = stack.getOrCreateNbt();
        tag.putInt("PrevUseTime", getUseTime(stack));
        tag.putInt("UseTime", useTime);
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        NbtCompound compoundtag = stack.getNbt();
        float prev = compoundtag != null ? (float) compoundtag.getInt("PrevUseTime") : 0F;
        float current = compoundtag != null ? (float) compoundtag.getInt("UseTime") : 0F;
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks){
        return Math.min(getLerpedUseTime(itemStack, partialTicks) / (float) getMaxLoadTime(), 1F);
    }

    public static float getPowerForTime(int i) {
        float f = (float) i / (float)getMaxLoadTime();
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    private Entity getPlayerLookTarget(World level, LivingEntity living) {
        Entity pointedEntity = null;
        double range = 40.0D;
        Vec3d srcVec = living.getEyePos();
        Vec3d lookVec = living.getRotationVec(1.0F);
        Vec3d destVec = srcVec.add(lookVec.getX() * range, lookVec.getY() * range, lookVec.getZ() * range);
        float var9 = 2.0F;
        List<Entity> possibleList = level.getOtherEntities(living, living.getBoundingBox().stretch(lookVec.getX() * range, lookVec.getY() * range, lookVec.getZ() * range).expand(var9, var9, var9));
        double hitDist = 0;

        for (Entity possibleEntity : possibleList) {
            Box collisionBB = possibleEntity.getBoundingBox().expand(1.0d, 1.0d, 1.0d);
            Optional<Vec3d> interceptPos = collisionBB.raycast(srcVec, destVec);

            if (collisionBB.contains(srcVec)) {
                if (0.0D < hitDist || hitDist == 0.0D) {
                    pointedEntity = possibleEntity;
                    hitDist = 0.0D;
                }
            } else if (interceptPos.isPresent()) {
                double possibleDist = srcVec.distanceTo(interceptPos.get());

                if (possibleDist < hitDist || hitDist == 0.0D) {
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }

        }
        return pointedEntity;
    }

    public static boolean isInfinite(ItemStack stack, ItemStack bow, PlayerEntity player) {
        return EnchantmentHelper.getLevel(Enchantments.INFINITY, bow) > 0;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity living, int timeleft) {
        if (living instanceof PlayerEntity player) {
            boolean flag = player.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = player.getProjectileType(stack);
            Entity pointedEntity = getPlayerLookTarget(level, living);

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }
                int i = this.getMaxUseTime(stack) - timeleft;
                if (i < 0) return;

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().creativeMode || (itemstack.getItem() instanceof ArrowItem && isInfinite(itemstack, stack, player));
                    if (!level.isClient) {
                        ArrowItem arrowItem = itemstack.getItem() instanceof ArrowItem arrow ? arrow : (ArrowItem) Items.ARROW;
                        boolean hommingArrows = itemstack.isOf(Items.ARROW);
                        int arrowcount = itemstack.isOf(Items.ARROW) ? 3 : 2 ;
                        float offsetangle = itemstack.isOf(Items.ARROW) ? 12 : 3;
                        for (int j = 0; j < arrowcount; j++) {

                            PersistentProjectileEntity abstractarrow = arrowItem.createArrow(level, itemstack, player);
                            abstractarrow = customArrow(abstractarrow);

                            int p = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
                            if (hommingArrows) {
                                if (pointedEntity instanceof LivingEntity target && !target.isTeammate(living)) {
                                    Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, living, target);
                                    hommingArrowEntity.setDamage(CMConfig.PlayerPhantomArrowbasedamage * f);
                                    if (p > 0) {
                                        hommingArrowEntity.setDamage(hommingArrowEntity.getDamage() + (double)p * 0.35D + 0.5D);
                                    }
                                    abstractarrow = hommingArrowEntity;
                                } else {
                                    Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, living);
                                    hommingArrowEntity.setDamage(CMConfig.PlayerPhantomArrowbasedamage * f);
                                    if (p > 0) {
                                        hommingArrowEntity.setDamage(hommingArrowEntity.getDamage() + (double)p * 0.35D + 0.5D);
                                    }
                                    abstractarrow = hommingArrowEntity;
                                }
                            }else{
                                if (p > 0) {
                                    abstractarrow.setDamage(abstractarrow.getDamage() + (double)p * 0.7D + 0.5D);
                                }
                            }
                            if (j != 1) {
                                abstractarrow.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                            } else if (flag1 || player.getAbilities().creativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                                abstractarrow.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                            }

                            abstractarrow.setVelocity(player, player.getPitch(), player.getYaw() + (j - (arrowcount - 1) / 2.0F) * offsetangle, 0.0F, f * 3.0F, 1.0F);
                            if (f == 1.0F) {
                                abstractarrow.setCritical(true);
                            }

                            int k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
                            if (k > 0) {
                                abstractarrow.setPunch(k);
                            }

                            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                                abstractarrow.setOnFireFor(100);
                            }
                            level.spawnEntity(abstractarrow);
                        }

                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().creativeMode) {
                        itemstack.decrement(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeOne(itemstack);
                        }
                    }

                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    public PersistentProjectileEntity customArrow(PersistentProjectileEntity arrow) {
        return arrow;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }


    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.isOf(ModItems.CURSED_BOW) || !newStack.isOf(ModItems.CURSED_BOW);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 64;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.cursed_bow.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.cursed_bow2.desc").formatted(Formatting.DARK_GREEN));
    }
}
