package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.l_ender.cataclysm.init.ModDataComponents;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.items.Components.CursedBowComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Cursed_bow extends RangedWeaponItem  {


    public Cursed_bow(net.minecraft.item.Item.Settings group) {
        super(group);

    }

    
    public TypedActionResult<ItemStack> use(World p_40672_, PlayerEntity p_40673_, Hand p_40674_) {
        ItemStack itemstack = p_40673_.getStackInHand(p_40674_);
        boolean flag = !p_40673_.getProjectileType(itemstack).isEmpty();

//        TypedActionResult<ItemStack> ret = EventHooks.onArrowNock(itemstack, p_40672_, p_40673_, p_40674_, flag);
//        if (ret != null) {
//            return ret;
        if (!p_40673_.isInCreativeMode() && !flag) {
            return TypedActionResult.fail(itemstack);
        } else {
            p_40673_.setCurrentHand(p_40674_);
            return TypedActionResult.consume(itemstack);
        }
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity pEntity) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getActiveItem().equals(stack);
        int useTime = getUseTime(stack);
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);

            if (flaskContents.PrevUseTime() != flaskContents.UseTime()) {
                stack.apply(ModDataComponents.CURSED_BOW, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
            }


            int maxLoadTime = getMaxLoadTime();
            if (using && useTime < maxLoadTime) {
                int set = useTime +  1;
                setUseTime(stack, set);
                //Cataclysm.sendMSGToServer(new MessageUpdateItemTag(entity.getId(), stack));
                }

            if (!using && useTime > 0.0F) {
                setUseTime(stack, Math.max(0, useTime - 5));
            }
        }


    private static int getMaxLoadTime() {
        return 20;
    }

    public static int getUseTime(ItemStack stack) {
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
        return flaskContents.UseTime();
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
        stack.apply(ModDataComponents.CURSED_BOW, flaskContents, component -> component.tryAddDose(useTime,getUseTime(stack)));
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        CursedBowComponent flaskContents = stack.getOrDefault(ModDataComponents.CURSED_BOW, CursedBowComponent.EMPTY);
        float prev = flaskContents.PrevUseTime();
        float current = flaskContents.UseTime();
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks){
        return Math.min(getLerpedUseTime(itemStack, partialTicks) / (float) getMaxLoadTime(), 1F);
    }


    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
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

            if (possibleEntity.canHit()) {
                float borderSize = possibleEntity.getTargetingMargin();
                Box collisionBB = possibleEntity.getBoundingBox().expand(borderSize, borderSize, borderSize);
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
        }
        return pointedEntity;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity player) {
            ItemStack itemstack = player.getProjectileType(stack);
            Entity pointedEntity = getPlayerLookTarget(level, entityLiving);
            if (!itemstack.isEmpty()) {
                int i = this.getMaxUseTime(stack, entityLiving) - timeLeft;
//                i = EventHooks.onArrowLoose(stack, level, player, i, !itemstack.isEmpty());
                if (i < 0) {
                    return;
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = load(stack, itemstack, player);
                    if (level instanceof ServerWorld serverlevel) {
                        if (!list.isEmpty()) {
                            this.shoot(serverlevel, player, player.getActiveHand(), stack, list, f, 1.0F, f == 1.0F,pointedEntity);
                        }
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }

    }

    protected void shoot(ServerWorld level, LivingEntity shooter, Hand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable Entity target) {
        float f = EnchantmentHelper.getProjectileSpread(level, weapon, shooter, 0.0F);
        float f1 = projectileItems.size() == 1 ? 0.0F : 2.0F * f / (float)(projectileItems.size() - 1);
        float f2 = (float)((projectileItems.size() - 1) % 2) * f1 / 2.0F;
        float f3 = 1.0F;

        for(int i = 0; i < projectileItems.size(); ++i) {
            ItemStack itemstack = projectileItems.get(i);
            if (!itemstack.isEmpty()) {
                boolean hommingArrows = itemstack.isOf(Items.ARROW);
                int arrowcount = itemstack.isOf(Items.ARROW) ? 3 : 2 ;
                float offsetangle = itemstack.isOf(Items.ARROW) ? 12 : 3;
                boolean flag1 = shooter.isInCreativeMode();
                for (int j = 0; j < arrowcount; j++) {

                    //AbstractArrow abstractarrow = arrowItem.createArrow(level, itemstack, player);
                    PersistentProjectileEntity abstractarrow =  this.createArrow(level, shooter, weapon, itemstack, isCrit);
                    abstractarrow = customArrow(abstractarrow);

                    if (hommingArrows) {
                        if (target instanceof LivingEntity tango && !target.isTeammate(shooter)) {
                            Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, shooter, tango);
                            hommingArrowEntity.setDamage(CMConfig.PlayerPhantomArrowbasedamage * velocity);

                            abstractarrow = hommingArrowEntity;
                        } else {
                            Phantom_Arrow_Entity hommingArrowEntity = new Phantom_Arrow_Entity(level, shooter);
                            hommingArrowEntity.setDamage(CMConfig.PlayerPhantomArrowbasedamage * velocity);

                            abstractarrow = hommingArrowEntity;
                        }
                    } else {
                        abstractarrow.setDamage(abstractarrow.getDamage() + 0.5D);
                    }
                    if (j != 1) {
                        abstractarrow.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    } else if (flag1 || shooter.isInCreativeMode()  && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                        abstractarrow.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                    }
                    abstractarrow.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + (j - (arrowcount - 1) / 2.0F) * offsetangle, 0.0F, velocity * 3, inaccuracy);
                    if (f == 1.0F) {
                        abstractarrow.setCritical(true);
                    }

                    level.spawnEntity(abstractarrow);
                    if (weapon.isEmpty()) {
                        break;
                    }
                }
            }


        }



    }

    protected PersistentProjectileEntity createArrow(World level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Item var8 = ammo.getItem();
        ArrowItem var10000;
        if (var8 instanceof ArrowItem arrowitem1) {
            var10000 = arrowitem1;
        } else {
            var10000 = (ArrowItem)Items.ARROW;
        }



        ArrowItem arrowitem = var10000;
        PersistentProjectileEntity abstractarrow = arrowitem.createArrow(level, ammo, shooter, weapon);
        if (isCrit) {
            abstractarrow.setCritical(true);
        }
        return abstractarrow;
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

    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + angle, 0.0F, velocity, inaccuracy);
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.cursed_bow.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.cursed_bow2.desc").formatted(Formatting.DARK_GREEN));
    }
}
