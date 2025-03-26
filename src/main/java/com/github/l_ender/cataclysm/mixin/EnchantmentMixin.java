package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.items.ModEnchantable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
    @Unique
    private final Enchantment self = (Enchantment)(Object)this;

    @Inject(method = "isAcceptableItem", at = @At("RETURN"), cancellable = true)
    public void injectIsAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(stack.getItem() instanceof ModEnchantable enchantable ? enchantable.canApplyAtEnchantingTable(stack, self) : cir.getReturnValue());
    }
}
