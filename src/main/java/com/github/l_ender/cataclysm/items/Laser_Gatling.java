package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import com.github.l_ender.cataclysm.init.ModDataComponents;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import java.util.List;
import java.util.function.Predicate;

public class Laser_Gatling extends Item {
    private static final String TAG_CHARGED = "Charged";

    public static final Predicate<ItemStack> REDSTONE = (stack) -> {
        return stack.getItem() == Items.REDSTONE;
    };

    public Laser_Gatling(Settings properties) {
        super(properties);
    }


    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return isUsable(pStack) ? Integer.MAX_VALUE : 0;
    }

    public boolean isItemBarVisible(ItemStack itemStack) {
        return super.isItemBarVisible(itemStack) && isUsable(itemStack);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

 

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getStackInHand(handIn);
        playerIn.setCurrentHand(handIn);
        if(!isUsable(itemstack)){
            ItemStack ammo = findAmmo(playerIn);
            boolean flag = playerIn.isCreative();
            if(!ammo.isEmpty()){
                ammo.decrement(1);
                flag = true;
            }
            if(flag){
                itemstack.setDamage(0);
            }
        }
        return TypedActionResult.consume(itemstack);
    }

    public ItemStack findAmmo(PlayerEntity entity) {
        if(entity.isCreative()){
            return ItemStack.EMPTY;
        }
        for(int i = 0; i < entity.getInventory().size(); ++i) {
            ItemStack itemstack1 = entity.getInventory().getStack(i);
            if (REDSTONE.test(itemstack1)) {
                return itemstack1;
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !ItemStack.areItemsEqual(oldStack, newStack);
    }

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if(isUsable(stack)) {
            stack.set(ModDataComponents.LASER_GATLING, false);
            if (count % 2 == 0) {
                Vec3d vector3d = livingEntityIn.getRotationVec(1.0F);
                Vec3d vec3 = vector3d.normalize();

                Laser_Beam_Entity laser = new Laser_Beam_Entity(livingEntityIn, vec3,worldIn,(float)CMConfig.Laserdamage);

                float yRot = (float) (MathHelper.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;



                float xRot = (float) -(MathHelper.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

                laser.setYaw(yRot);
                laser.setPitch(xRot);
                laser.setPos(livingEntityIn.getX(),livingEntityIn.getY() + livingEntityIn.getStandingEyeHeight() * 0.8F,livingEntityIn.getZ());
                Random rand = worldIn.getRandom();
                livingEntityIn.emitGameEvent(GameEvent.ITEM_INTERACT_START);
                livingEntityIn.playSound(ModSounds.HARBINGER_LASER,0.2F, 1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F);
                if (!worldIn.isClient) {
                    worldIn.spawnEntity(laser);
                }
                stack.damage(1, livingEntityIn, EquipmentSlot.MAINHAND);
            }
        }else{
            if(livingEntityIn instanceof PlayerEntity){
                ItemStack ammo = findAmmo((PlayerEntity)livingEntityIn);
                boolean flag = ((PlayerEntity) livingEntityIn).isCreative();
                if(!ammo.isEmpty()){
                    ammo.decrement(1);
                    flag = true;
                }
                if(flag){
                    ((PlayerEntity) livingEntityIn).getItemCooldownManager().set(this, 20);
                    stack.setDamage(0);
                }
                livingEntityIn.clearActiveItem();
            }
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity living, int remainingUseTicks) {

        stack.set(ModDataComponents.LASER_GATLING, false);

    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity living && living.getActiveItem().equals(stack);

            if (using ) {
                stack.set(ModDataComponents.LASER_GATLING, true);
            }
            if (!using) {
                stack.set(ModDataComponents.LASER_GATLING, false);
            }

    }

    public static boolean isCharged(ItemStack p_40933_) {

        return p_40933_.getOrDefault(ModDataComponents.LASER_GATLING, true);
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.laser_gatling.desc").formatted(Formatting.DARK_GREEN));
    }
}
