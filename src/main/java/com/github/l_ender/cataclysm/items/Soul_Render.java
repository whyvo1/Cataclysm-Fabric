package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.capabilities.RenderRushCapability;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.fabricators_of_create.porting_lib.attributes.PortingLibAttributes;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Soul_Render extends Item implements More_Tool_Attribute, ModEnchantable {
	private final Multimap<EntityAttribute, EntityAttributeModifier> whirligigsawAttributes;

	public Soul_Render(Settings properties) {
		super(properties);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 14D, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.9F, EntityAttributeModifier.Operation.ADDITION));
		builder.put(PortingLibAttributes.ENTITY_REACH, new EntityAttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Tool modifier", 2.0F, EntityAttributeModifier.Operation.ADDITION));
		builder.put(PortingLibAttributes.BLOCK_REACH, new EntityAttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, "Tool modifier", 2.0F, EntityAttributeModifier.Operation.ADDITION));

		this.whirligigsawAttributes = builder.build();
	}


	@Override
	public void onStoppedUsing(ItemStack stack, World level, LivingEntity livingEntity, int timeLeft) {
		boolean hasSucceeded = false;
		if (livingEntity instanceof PlayerEntity player) {
			int i = this.getMaxUseTime(stack) - timeLeft;
			if(livingEntity.isSneaking()) {
				StrikeWindmillHalberd(level,player,7, 5, 1.0, 1.0, 0.2, 1);
				if (!level.isClient) {
					player.getItemCooldownManager().set(this, CMConfig.SoulRenderCooldown);
				}
			}else{
				int t = MathHelper.clamp(i, 0, 60);
				if (t > 0) {
					float f = 0.1F * t;
					Vec3d vec3 = player.getVelocity().add(player.getRotationVec(1.0F).normalize().multiply(f, f * 0.15F, f));
					livingEntity.setVelocity(vec3.add(0, (livingEntity.isOnGround() ? 0.2F : 0), 0));
					RenderRushCapability ChargeCapability = ModCapabilities.getOrCreate(livingEntity, ModCapabilities.RENDER_RUSH_CAPABILITY);
					if (ChargeCapability != null) {
						ChargeCapability.setRush(true);
						ChargeCapability.setTimer(t / 2);
						ChargeCapability.setdamage((float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
						hasSucceeded = true;
					}

					if (!level.isClient) {
						if (hasSucceeded) {
							player.getItemCooldownManager().set(this, CMConfig.SoulRenderCooldown);
						}
					}
				}
			}
		}
	}

	private void StrikeWindmillHalberd(World level,LivingEntity player,int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
		float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
		for (int branch = 0; branch < numberOfBranches; ++branch) {
			float baseAngle = angleIncrement * branch;
			for (int i = 0; i < particlesPerBranch; ++i) {
				double currentRadius = initialRadius + i * radiusIncrement;
				float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

				double xOffset = currentRadius * Math.cos(currentAngle);
				double zOffset = currentRadius * Math.sin(currentAngle);

				double spawnX = player.getX() + xOffset;
				double spawnY = player.getY() + 0.3D;
				double spawnZ = player.getZ() + zOffset;
				int d3 = delay * (i + 1);
				double deltaX = level.getRandom().nextGaussian() * 0.007D;
				double deltaY = level.getRandom().nextGaussian() * 0.007D;
				double deltaZ = level.getRandom().nextGaussian() * 0.007D;
				if (level.isClient) {
					level.addParticle(ModParticle.PHANTOM_WING_FLAME, spawnX, spawnY, spawnZ, deltaX, deltaY, deltaZ);
				}
				this.spawnHalberd(spawnX, spawnZ, player.getY() -5, player.getY() + 3, currentAngle, d3,level,player);

			}
		}
	}

	private void spawnHalberd(double x, double z, double minY, double maxY, float rotation, int delay, World world, LivingEntity player) {
		BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
		boolean flag = false;
		double d0 = 0.0D;

		do {
			BlockPos blockpos1 = blockpos.down();
			BlockState blockstate = world.getBlockState(blockpos1);
			if (blockstate.isSideSolidFullSquare(world, blockpos1, Direction.UP)) {
				if (!world.isAir(blockpos)) {
					BlockState blockstate1 = world.getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.getMax(Direction.Axis.Y);
					}
				}

				flag = true;
				break;
			}

			blockpos = blockpos.down();
		} while(blockpos.getY() >= MathHelper.floor(minY) - 1);
		if (flag) {
			world.spawnEntity(new Phantom_Halberd_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, delay, player,(float)CMConfig.PhantomHalberddamage));
		}
	}

	public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
		ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
		Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;

		ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);

		if (otheritem.isIn(ConventionalItemTags.SHIELDS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
			return TypedActionResult.fail(item);
		}else{
			p_77659_2_.setCurrentHand(p_77659_3_);
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
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.target == EnchantmentTarget.WEAPON && enchantment != Enchantments.SWEEPING;
	}

	public float getMiningSpeedMultiplier(ItemStack p_41004_, BlockState p_41005_) {
		float speed = 15;
		return p_41005_.isIn(BlockTags.AXE_MINEABLE) ? speed : 1.0F;
	}

	public static float getPowerForTime(int i) {
		float f = (float) i / (float)getMaxLoadTime();
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	private static int getMaxLoadTime() {
		return 20;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
	}

//	@Override
//	public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//		consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
		return equipmentSlot == EquipmentSlot.MAINHAND ? this.whirligigsawAttributes : super.getAttributeModifiers(equipmentSlot);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
		tooltip.add(Text.translatable("item.cataclysm.soul_render.desc").formatted(Formatting.DARK_GREEN));
		tooltip.add(Text.translatable("item.cataclysm.soul_render2.desc").formatted(Formatting.DARK_GREEN));
	}
}