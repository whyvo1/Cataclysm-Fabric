package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Unique
    private final PlayerEntity self = (PlayerEntity)(Object)this;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setHealth(F)V"))
    private void injectApplyDamage(DamageSource source, float amount, CallbackInfo ci) {
        //        LivingEntity entity = event.getEntity();
        if (getHealth() <= amount && hasStatusEffect(ModEffect.EFFECTSTUN)) {
            removeStatusEffect(ModEffect.EFFECTSTUN);
        }
        if (source != null && source.getSource() != null && getEquippedStack(EquipmentSlot.LEGS).isOf(ModItems.IGNITIUM_LEGGINGS)) {
//            Entity attacker = source.getSource();
            if (source.getSource() instanceof LivingEntity attacker && attacker != self && getRandom().nextFloat() < 0.5F) {
                StatusEffectInstance effectinstance1 = attacker.getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    attacker.removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                } else {
                    --i;
                }

                i = MathHelper.clamp(i, 0, 4);
                attacker.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, false, true));

                if (!attacker.isOnFire()) {
                    attacker.setOnFireFor(5);
                }
            }
        }
    }

    @ModifyConstant(method = "attack", constant = @Constant(floatValue = 1.5F))
    private float modifyConstantAttack(float value, Entity target) {
        ItemStack weapon = getMainHandStack();
        if (!weapon.isEmpty() && target instanceof LivingEntity) {
            if (weapon.isOf(ModItems.THE_ANNIHILATOR)) {
                return 2.25F;
            }
            if (weapon.getItem() == ModItems.THE_IMMOLATOR) {
                return 2.0F;
            }
        }
        return value;
    }

    @ModifyVariable(method = "attack", at = @At("STORE"), name = "bl3")
    private boolean modifyVariableAttack(boolean value, Entity target) {
        if(target instanceof LivingEntity livingEntity && getMainHandStack().isOf(ModItems.THE_IMMOLATOR) && livingEntity.hasStatusEffect(ModEffect.EFFECTBLAZING_BRAND)) {
            return true;
        }
        return value;
    }

}
