package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Cursed_Sandstorm_Entity;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Optional;

public class Wrath_of_the_desert extends Item implements ModEnchantable {


    public Wrath_of_the_desert(Settings group) {
        super(group);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(itemstack);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
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
                int set = useTime + 1;
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

    public static float getPullingAmount(ItemStack itemStack, float partialTicks) {
        return Math.min(getLerpedUseTime(itemStack, partialTicks) / (float) getMaxLoadTime(), 1F);
    }


    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public static float getPowerForTime(int i) {
        float f = (float) i / (float) getMaxLoadTime();
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

    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity living, int timeleft) {
        if (living instanceof PlayerEntity player) {

            Entity pointedEntity = getPlayerLookTarget(level, living);
            int i = this.getMaxUseTime(stack) - timeleft;
            float f = getPowerForTime(i);
            if (!((double) f < 0.1D)) {
                if (!level.isClient) {
                    float baseYaw = player.getYaw();
                    float pitch = player.getPitch();
                    for (int j = -1; j <= 1; j++) {
                        float yaw = baseYaw + (j * 15);
                        float directionX = -MathHelper.sin(yaw * ((float) Math.PI / 180F)) * MathHelper.cos(pitch * ((float) Math.PI / 180F));
                        float directionY = -MathHelper.sin(pitch * ((float) Math.PI / 180F));
                        float directionZ = MathHelper.cos(yaw * ((float) Math.PI / 180F)) * MathHelper.cos(pitch * ((float) Math.PI / 180F));
                        double theta = yaw * (Math.PI / 180); theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double x = player.getX() + vecX;
                        double Z = player.getZ() + vecZ;
                        int p = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
                        if (pointedEntity instanceof LivingEntity target && !target.isTeammate(living)) {
                            Cursed_Sandstorm_Entity largefireball = new Cursed_Sandstorm_Entity(player, directionX, directionY, directionZ, player.getWorld(), (float) CMConfig.CursedSandstormDamage * f + (float) CMConfig.CursedSandstormDamage * f * p * 0.05F, target);
                            largefireball.setPosition(x, player.getEyeY() - 0.5D, Z);
                            largefireball.setUp(15);
                            level.spawnEntity(largefireball);
                        }else{
                            Cursed_Sandstorm_Entity largefireball = new Cursed_Sandstorm_Entity(player, directionX, directionY, directionZ, player.getWorld(), (float) CMConfig.CursedSandstormDamage * f + (float) CMConfig.CursedSandstormDamage * f * p * 0.05F, null);
                            largefireball.setPosition(x, player.getEyeY() - 0.5D, Z);
                            largefireball.setUp(15);
                            level.spawnEntity(largefireball);
                        }
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
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

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.isOf(ModItems.WRATH_OF_THE_DESERT) || !newStack.isOf(ModItems.WRATH_OF_THE_DESERT);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.wrath_of_the_desert.desc").formatted(Formatting.DARK_GREEN));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.target ==  EnchantmentTarget.BOW && enchantment != Enchantments.INFINITY && enchantment != Enchantments.FLAME && enchantment != Enchantments.PUNCH;
    }
}
