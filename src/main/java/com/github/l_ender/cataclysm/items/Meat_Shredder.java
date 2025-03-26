package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


import java.util.List;
import java.util.Optional;

public class Meat_Shredder extends Item {

	public Meat_Shredder(Settings properties) {
		super(properties);

	}

	public static AttributeModifiersComponent createAttributes() {
		return AttributeModifiersComponent.builder()
				.add(
						EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.5D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
				)
				.add(
						EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.6F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
				)
				.build();
	}


	public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
		ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
		Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
		ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);
		if (otheritem.isIn(ConventionalItemTags.SHIELD_TOOLS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
			return TypedActionResult.fail(item);
		}else{
			p_77659_2_.setCurrentHand(p_77659_3_);
			p_77659_1_.playSound(null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), ModSounds.SHREDDER_START, SoundCategory.PLAYERS, 1.5f, 1F / (p_77659_2_.getRandom().nextFloat() * 0.4F + 0.8F));
			return TypedActionResult.consume(item);
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
	public void usageTick(World level, LivingEntity living, ItemStack stack, int count) {
		double range = 2.5D;
		Vec3d srcVec = living.getEyePos();
		Vec3d lookVec = living.getRotationVec(1.0F);
		Vec3d destVec = srcVec.add(lookVec.getX() * range, lookVec.getY() * range, lookVec.getZ() * range);
		float var9 = 1.0F;
		List<Entity> possibleList = level.getOtherEntities(living, living.getBoundingBox().stretch(lookVec.getX() * range, lookVec.getY() * range, lookVec.getZ() * range).expand(var9, var9, var9));

		boolean flag = false;
		for (Entity entity : possibleList) {
			if (entity instanceof LivingEntity) {
				float borderSize = 0.5F;
				Box collisionBB = entity.getBoundingBox().expand(borderSize, borderSize, borderSize);
				Optional<Vec3d> interceptPos = collisionBB.raycast(srcVec, destVec);
				if (collisionBB.contains(srcVec)) {
					flag =true;
				} else if (interceptPos.isPresent()) {
					flag =true;
				}

				if (flag) {
					if (entity.damage(CMDamageTypes.causeShredderDamage(living), (float) living.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) / 8.5F)) {
					}
					double d0 = (level.getRandom().nextFloat() - 0.5F) + entity.getVelocity().x;
					double d1 = (level.getRandom().nextFloat() - 0.5F) + entity.getVelocity().y;
					double d2 = (level.getRandom().nextFloat() - 0.5F) + entity.getVelocity().z;
					double dist = 1F + level.getRandom().nextFloat() * 0.2F;
					double d3 = d0 * dist;
					double d4 = d1 * dist;
					double d5 = d2 * dist;
					entity.getWorld().addParticle(ModParticle.SPARK, entity.getX(), living.getEyeY() - 0.1D + (entity.getEyePos().y - living.getEyeY()), entity.getZ(), d3, d4, d5);
				}
			}
		}
	}

	@Override
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity living, int remainingUseTicks) {
		world.playSound(null, living.getX(), living.getY(), living.getZ(), ModSounds.SHREDDER_END, SoundCategory.PLAYERS, 1.5f, 1F / (living.getRandom().nextFloat() * 0.4F + 0.8F));
	}

	public float getMiningSpeed(ItemStack p_41004_, BlockState p_41005_) {
		float speed = 15;

		return p_41005_.isIn(BlockTags.AXE_MINEABLE) ? speed : 1.0F;
	}

	@Override
	public int getMaxUseTime(ItemStack p_43419_, LivingEntity p_345001_) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}


	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
		tooltips.add(Text.translatable("item.cataclysm.meat_shredder.desc").formatted(Formatting.DARK_GREEN));
	}
}