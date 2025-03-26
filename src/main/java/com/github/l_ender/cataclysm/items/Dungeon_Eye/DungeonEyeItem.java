package com.github.l_ender.cataclysm.items.Dungeon_Eye;

import com.github.l_ender.cataclysm.entity.projectile.Eye_Of_Dungeon_Entity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.structure.Structure;

public class DungeonEyeItem extends Item {

    private final TagKey<Structure> destination;
    private final int[] eyeRBG;

    public DungeonEyeItem(TagKey<Structure> destination, int[] eyeRBG, Settings settings) {
        super(settings);
        this.destination = destination;
        this.eyeRBG = eyeRBG;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if (world instanceof ServerWorld serverlevel) {
            TagKey<Structure> destination = this.getDestination();
            if(destination == null) {
                return TypedActionResult.fail(itemstack);
            }
            BlockPos blockpos = serverlevel.locateStructure(destination, user.getBlockPos(), 100, false);
            if (blockpos != null) {
                Eye_Of_Dungeon_Entity eyeofender = new Eye_Of_Dungeon_Entity(world, user.getX(), user.getBodyY(0.5D), user.getZ());
                eyeofender.setItem(itemstack);
                eyeofender.signalTo(blockpos);

                int[] color = this.getEyeRGB();
                if(color != null && color.length >= 3) {
                    eyeofender.setR(color[0]);
                    eyeofender.setG(color[1]);
                    eyeofender.setB(color[2]);
                }

                world.emitGameEvent(GameEvent.PROJECTILE_SHOOT, eyeofender.getPos(), GameEvent.Emitter.of(user));
                world.spawnEntity(eyeofender);
                if (user instanceof ServerPlayerEntity) {
                    Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity)user, blockpos);
                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                world.syncWorldEvent(null, 1003, user.getBlockPos(), 0);
                if (!user.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }

                user.incrementStat(Stats.USED.getOrCreateStat(this));
                user.swingHand(hand, true);
                return TypedActionResult.success(itemstack);
            }
        }

        return TypedActionResult.consume(itemstack);
    }

    public int[] getEyeRGB() {
        return this.eyeRBG;
    }

    public TagKey<Structure> getDestination() {
        return this.destination;
    }
}
