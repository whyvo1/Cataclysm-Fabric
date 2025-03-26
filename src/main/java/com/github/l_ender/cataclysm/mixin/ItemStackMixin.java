package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.items.ModDamageable;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.component.ComponentHolder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ComponentHolder, FabricItemStack {

    @Unique
    private final ItemStack self = (ItemStack) (Object) this;

    @Shadow public abstract Item getItem();

    @Inject(method = "isDamageable", at = @At("RETURN"), cancellable = true)
    public void injectIsDamageable(CallbackInfoReturnable<Boolean> cir) {
        if(getItem() instanceof ModDamageable damageable) {
            cir.setReturnValue(cir.getReturnValue() && damageable.isDamageable(self));
        }
    }
}
