package com.github.l_ender.cataclysm.items.Dungeon_Eye;

import com.github.l_ender.cataclysm.entity.projectile.Eye_Of_Dungeon_Entity;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class FlameEyeItem extends Item {

    public FlameEyeItem(net.minecraft.item.Item.Settings group) {
        super(group);

    }

    public TypedActionResult<ItemStack> use(World p_41184_, PlayerEntity p_41185_, Hand p_41186_) {
        ItemStack itemstack = p_41185_.getStackInHand(p_41186_);
        p_41185_.setCurrentHand(p_41186_);
        if (p_41184_ instanceof ServerWorld) {
            ServerWorld serverlevel = (ServerWorld)p_41184_;
            BlockPos blockpos = serverlevel.locateStructure(ModTag.EYE_OF_FLAME_LOCATED, p_41185_.getBlockPos(), 100, false);
            if (blockpos != null) {
                Eye_Of_Dungeon_Entity eyeofender = new Eye_Of_Dungeon_Entity(p_41184_, p_41185_.getX(), p_41185_.getBodyY(0.5D), p_41185_.getZ());
                eyeofender.setItem(itemstack);
                eyeofender.signalTo(blockpos);
                eyeofender.setR(252);
                eyeofender.setG(149);
                eyeofender.setB(0);
                p_41184_.emitGameEvent(GameEvent.PROJECTILE_SHOOT, eyeofender.getPos(), GameEvent.Emitter.of(p_41185_));
                p_41184_.spawnEntity(eyeofender);
                if (p_41185_ instanceof ServerPlayerEntity) {
                    Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity)p_41185_, blockpos);
                }

                p_41184_.playSound((PlayerEntity)null, p_41185_.getX(), p_41185_.getY(), p_41185_.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (p_41184_.getRandom().nextFloat() * 0.4F + 0.8F));
                p_41184_.syncWorldEvent((PlayerEntity)null, 1003, p_41185_.getBlockPos(), 0);
                if (!p_41185_.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }

                p_41185_.incrementStat(Stats.USED.getOrCreateStat(this));
                p_41185_.swingHand(p_41186_, true);
                return TypedActionResult.success(itemstack);
            }
        }

        return TypedActionResult.consume(itemstack);
    }

}


