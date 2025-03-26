package com.github.l_ender.cataclysm.items;


import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import java.util.List;

public class infernal_forge extends PickaxeItem implements ModDamageable, ModShieldDisable {
    public infernal_forge(ToolMaterial toolMaterial, Settings props) {

        super(toolMaterial, props);
    }

    @Override
    public boolean postHit(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient) {
            target.playSound(ModSounds.HAMMERTIME, 0.5F, 0.5F);
            target.takeKnockback( 1F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        if (player.getMainHandStack() == stack) {
            EarthQuake(context);
            player.getItemCooldownManager().set(this, CMConfig.InfernalForgeCooldown);
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private void EarthQuake(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        boolean berserk = player.getMaxHealth() * 1 / 2 >= player.getHealth();
        double radius = 4.0D;
        ScreenShake_Entity.ScreenShake(world, player.getPos(), 30, 0.1f, 0, 30);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EXPLOSION, SoundCategory.PLAYERS, 1.5f, 1F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        List<Entity> list = world.getOtherEntities(player, player.getBoundingBox().expand(radius, radius, radius));
        for (Entity entity : list) {
            if (entity instanceof LivingEntity) {
                entity.damage(world.getDamageSources().mobAttack(player), (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                entity.setVelocity(entity.getVelocity().multiply(0.0, 2.0, 0.0));
                if (berserk) {
                    entity.setOnFireFor((int) 5.0);
                }
            }
        }
        if (world.isClient) {
            BlockState block = world.getBlockState(player.getBlockPos().down());
            double NumberofParticles = radius * 4.0D;

            for (double i = 0.0D; i < 80; i++) {
                double d0 = player.getX() + radius * MathHelper.sin((float) (i / NumberofParticles * 360.0f));
                double d1 = player.getY() + 0.15;
                double d2 = player.getZ() + radius * MathHelper.cos((float) (i / NumberofParticles * 360.0f));
                double d3 = world.getRandom().nextGaussian() * 0.2D;
                double d4 = world.getRandom().nextGaussian() * 0.2D;
                double d5 = world.getRandom().nextGaussian() * 0.2D;
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                if (berserk) {
                    world.addParticle(ParticleTypes.FLAME, d0, d1, d2, d3, d4, d5);

                }
            }

        }
    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canDisableShield(ItemStack stack, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.infernal_forge.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.infernal_forge.desc2").formatted(Formatting.DARK_GREEN));
    }
}







