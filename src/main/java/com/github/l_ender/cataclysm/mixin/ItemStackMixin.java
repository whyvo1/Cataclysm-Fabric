package com.github.l_ender.cataclysm.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract Item getItem();

    @Inject(method = "isDamageable", at = @At("RETURN"), cancellable = true)
    public void injectIsDamageable(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() && getItem().isDamageable());
    }
}
