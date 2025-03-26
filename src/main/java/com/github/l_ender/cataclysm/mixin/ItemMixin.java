package com.github.l_ender.cataclysm.mixin;


import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemMixin {

    @Shadow public abstract ItemStack getStack();

    @Inject(
            method = {"damage"},
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)

    public void Cmhurt(DamageSource damageSource, float p_32014_, CallbackInfoReturnable<Boolean> cir) {
        if (!this.getStack().isEmpty() && damageSource.isIn(DamageTypeTags.IS_EXPLOSION) && this.getStack().isIn(ModTag.EXPLOSION_IMMUNE_ITEM)) {
            cir.setReturnValue(false);
        }

    }

}

