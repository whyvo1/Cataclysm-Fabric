package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import java.util.List;
import java.util.function.Predicate;

public class Netherite_Effigy extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);

    public Netherite_Effigy(Settings properties) {
        super(properties);
    }



    public TypedActionResult<ItemStack> use(World p_40622_, PlayerEntity p_40623_, Hand p_40624_) {
        ItemStack itemstack = p_40623_.getStackInHand(p_40624_);
        HitResult hitresult = raycast(p_40622_, p_40623_, RaycastContext.FluidHandling.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemstack);
        } else {
            Vec3d vec3 = p_40623_.getRotationVec(1.0F);
            Vec3d vec31 = hitresult.getPos();
            double d0 = 5.0D;
            List<Entity> list = p_40622_.getOtherEntities(p_40623_, p_40623_.getBoundingBox().stretch(vec3.multiply(5.0D)).expand(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                for(Entity entity : list) {
                    Box aabb = entity.getBoundingBox().expand((double)entity.getTargetingMargin());
                    if (aabb.contains(vec31)) {
                        return TypedActionResult.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                Netherite_Ministrosity_Entity remnantEntity = ModEntities.NETHERITE_MINISTROSITY.create(p_40622_);
                remnantEntity.setPosition(vec31.x, vec31.y, vec31.z);
                remnantEntity.setIsAwaken(false);
                if (!p_40622_.isSpaceEmpty(remnantEntity, remnantEntity.getBoundingBox())) {
                    return TypedActionResult.fail(itemstack);
                } else {
                    if (!p_40622_.isClient) {
                        p_40622_.spawnEntity(remnantEntity);
                        p_40622_.emitGameEvent(p_40623_, GameEvent.ENTITY_PLACE, vec31);
                        if (!p_40623_.getAbilities().creativeMode) {
                            itemstack.decrement(1);
                        }
                    }
                    p_40623_.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemstack, p_40622_.isClient());
                }
            } else {
                return TypedActionResult.pass(itemstack);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.netherite_effigy.desc").formatted(Formatting.DARK_GREEN));
    }

}
