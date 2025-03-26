package com.github.l_ender.cataclysm.mixin;


import com.github.l_ender.cataclysm.capabilities.Capability;
import com.github.l_ender.cataclysm.capabilities.CapabilityType;
import com.github.l_ender.cataclysm.capabilities.ParryCapability;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.items.ModShieldDisable;
import com.github.l_ender.cataclysm.asm.LivingEntityCapabilityASM;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements LivingEntityCapabilityASM {
    @Unique
    private final LivingEntity self = (LivingEntity)(Object)this;

    @Unique
    private List<Capability<?>> capabilities;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

//    public LivingEntityMixin(EntityType<?> p_19870_, World p_19871_) {
//        super(p_19870_, p_19871_);
//    }


    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow public abstract boolean shouldDisplaySoulSpeedEffects();

    @Shadow public abstract float getMaxHealth();

    @Shadow public abstract Random getRandom();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract @Nullable LivingEntity getAttacker();

    @Shadow public abstract float getHealth();

    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow public abstract ItemStack getActiveItem();

    @Shadow protected abstract void applyDamage(DamageSource source, float amount);

    @Shadow public abstract ItemStack getStackInHand(Hand hand);

    @Shadow public abstract boolean isUsingItem();

    @Shadow protected ItemStack activeItemStack;

    @Shadow public abstract boolean blockedByShield(DamageSource source);

    @Inject(
            method = {"canTarget(Lnet/minecraft/entity/LivingEntity;)Z"},
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)

    private void CMcanAttack(LivingEntity p_21171_,CallbackInfoReturnable<Boolean> cir) {
        if (hasStatusEffect(ModEffect.EFFECTSTUN)) {
            cir.setReturnValue(false);
        }

    }

    @Inject(method = "disablesShield", at = @At("RETURN"), cancellable = true)
    private void injectDisablesShield(CallbackInfoReturnable<Boolean> cir) {
        if(cir.getReturnValue()) {
            cir.cancel();
        }
        else {
            cir.setReturnValue(getMainHandStack().getItem() instanceof ModShieldDisable shieldDisable && shieldDisable.canDisableShield(getMainHandStack(), self));
        }
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void injectInit(EntityType<? extends LivingEntity> entityType, World world, CallbackInfo ci) {
        this.capabilities = new LinkedList<>();
//        ModCapabilities.attachEntityCapability(self);
    }

    @Override
    public <T extends Capability<?>> T cataclysm$getCapability(CapabilityType<T, ?> type) {
        for (Capability<?> capability : this.capabilities) {
            if (capability.getType() == type) {
                return (T) capability;
            }
        }
        return null;
    }

    @Override
    public <T> void cataclysm$addCapability(Capability<T> capability) {
        this.capabilities.add(capability);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void injectTick(CallbackInfo ci) {
        for(Capability<?> capability : this.capabilities) {
            capability.tick();
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void injectWriteCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        NbtCompound tag = new NbtCompound();
        for(Capability<?> capability : this.capabilities) {
            tag.put(capability.getName(), capability.serializeNBT());
        }
        nbt.put("ForgeCaps", tag);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void injectReadCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        if(nbt.contains("ForgeCaps")) {
            NbtCompound tag = nbt.getCompound("ForgeCaps");
            for(Capability<?> capability : this.capabilities) {
                if(tag.contains(capability.getName())) {
                    capability.deserializeNBT(tag.getCompound(capability.getName()));
                }
            }
        }
    }

    @Inject(method = "remove", at = @At("RETURN"))
    private void injectRemove(Entity.RemovalReason reason, CallbackInfo ci) {
        this.capabilities.clear();
    }


    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void injectDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
            if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                cir.setReturnValue(false);
            }
        }
        if (getEquippedStack(EquipmentSlot.LEGS).isOf(ModItems.CURSIUM_LEGGINGS)) {
            if (source.isIn(DamageTypeTags.IS_PROJECTILE)) {
                if (getRandom().nextFloat() < 0.15F) {
                    cir.setReturnValue(false);
                }
            } else if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                if (getRandom().nextFloat() < 0.08F) {
                    cir.setReturnValue(false);
                }
            }
        }
    }

    @Inject(method = "heal", at = @At("HEAD"), cancellable = true)
    private void injectHeal(float amount, CallbackInfo ci) {
        if(hasStatusEffect(ModEffect.EFFECTABYSSAL_FEAR)) {
            ci.cancel();
        }
    }

    @Inject(method = "jump", at = @At("HEAD"))
    private void injectJump(CallbackInfo ci) {
        if(hasStatusEffect(ModEffect.EFFECTSTUN)) {
            setVelocity(getVelocity().getX(), 0.0D, getVelocity().getZ());
        }
    }

    @Inject(method = "canTarget(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("RETURN"), cancellable = true)
    private void injectCanTarget(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        if(cir.getReturnValue() && getType().isIn(ModTag.LAVA_MONSTER) && getAttacker() != target && target.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.IGNITIUM_HELMET)) {
            cir.setReturnValue(false);
        }
    }

    @ModifyVariable(method = "applyDamage", at = @At("HEAD"), argsOnly = true)
    private float modifyApplyDamage(float amount, DamageSource source) {
        if (!getWorld().isClient() && source.getSource() instanceof LivingEntity living) {
            ItemStack weapon = living.getMainHandStack();
            if (!weapon.isEmpty()) {
                if ((weapon.isOf(ModItems.ZWEIENDER))) {
                    Vec3d lookDir = new Vec3d(getRotationVector().x, 0, getRotationVector().z).normalize();
                    Vec3d vecBetween = new Vec3d(getX() - living.getX(), 0, getZ() - living.getZ()).normalize();
                    double dot = lookDir.dotProduct(vecBetween);
                    if (dot > 0.05) {
                        amount *= 2;
                        playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 0.75F, 0.5F);
                    }
                    // enchantment attack sparkles
                }

                if ((weapon.isOf(ModItems.FINAL_FRACTAL))) {
                    amount += getMaxHealth() * 0.03f;
                }
            }

            Optional<TrinketComponent> comp = TrinketsApi.getTrinketComponent(living);
            if(comp.isPresent()) {
                List<Pair<SlotReference, ItemStack>> list = comp.get().getEquipped(ModItems.BLAZING_GRIPS);
                if(list != null && !list.isEmpty()) {
                    if (getRandom().nextFloat() < 0.15F * list.size()) {
                        addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 60, 0));
                    }
                }
            }
        }
//            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS));
        return amount;
    }

//    @Unique
//    private boolean needRedirectDamage = false;
//
//    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
//    public void injectApplyDamageHead(DamageSource source, float amount, CallbackInfo ci) {
//        if(needRedirectDamage) {
//            needRedirectDamage = false;
//            applyDamage(source, this.handleHurt(source, amount));
//            needRedirectDamage = true;
//            ci.cancel();
//        }
//    }
//
//    private float handleHurt(DamageSource source, float amount) {
//        if (!getWorld().isClient() && source.getSource() instanceof LivingEntity living) {
//            ItemStack weapon = living.getMainHandStack();
//            if (!weapon.isEmpty()) {
//                if ((weapon.isOf(ModItems.ZWEIENDER))) {
//                    Vec3d lookDir = new Vec3d(getRotationVector().x, 0, getRotationVector().z).normalize();
//                    Vec3d vecBetween = new Vec3d(getX() - living.getX(), 0, getZ() - living.getZ()).normalize();
//                    double dot = lookDir.dotProduct(vecBetween);
//                    if (dot > 0.05) {
//                        amount *= 2;
//                        playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 0.75F, 0.5F);
//                    }
//                    // enchantment attack sparkles
//                }
//
//                if ((weapon.isOf(ModItems.FINAL_FRACTAL))) {
//                    amount += getMaxHealth() * 0.03f;
//                }
//            }
//
//            Optional<TrinketComponent> comp = TrinketsApi.getTrinketComponent(living);
//            if(comp.isPresent()) {
//                List<Pair<SlotReference, ItemStack>> list = comp.get().getEquipped(ModItems.BLAZING_GRIPS);
//                if(list != null && !list.isEmpty()) {
//                    if (getRandom().nextFloat() < 0.15F * list.size()) {
//                        addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 60, 0));
//                    }
//                }
//            }
//        }
//            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS));
//        return amount;
//    }

    @Inject(method = "applyDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"))
    private void injectApplyDamageInvoke(DamageSource source, float amount, CallbackInfo ci) {
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

    @Inject(method = "blockedByShield", at = @At("RETURN"), cancellable = true)
    private void injectBlockedByShield(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if(source.isOf(CMDamageTypes.MALEDICTIO_SAGITTA)) {
            cir.setReturnValue(false);
        }

        ParryCapability parryCapability = cataclysm$getCapability(ModCapabilities.PARRY_CAPABILITY);

        if(getActiveItem().isOf(ModItems.BULWARK_OF_THE_FLAME)) {
            if (parryCapability != null) {
                if (parryCapability.getParryFrame() < 15) {
                    if (source.getSource() instanceof LivingEntity livingEntity) {
                        livingEntity.setOnFireFor(3);
                        livingEntity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.8f, 1.3F);
                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, 0);
                        livingEntity.takeKnockback(0.5F, getX() - livingEntity.getX(), getZ() - livingEntity.getZ());
                        livingEntity.addStatusEffect(effectinstance);
                    }
                }
            }
        }
    }

    @ModifyVariable(method = "handleFallDamage", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyHandleFallDamage(float fallDistance) {
        if(getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.CURSIUM_BOOTS)) {
            return fallDistance * 0.3F;
        }
        return fallDistance;
    }

    @Inject(method = "setCurrentHand", at = @At("HEAD"))
    private void injectSetCurrentHand(Hand hand, CallbackInfo ci) {
        ItemStack itemStack = getStackInHand(hand);
        if(!itemStack.isEmpty() && isUsingItem()) {
            if (itemStack.isOf(ModItems.BULWARK_OF_THE_FLAME) && self instanceof PlayerEntity player && player.handSwingProgress == 0 && !player.getItemCooldownManager().isCoolingDown(itemStack.getItem())) {
                ParryCapability parryCapability = self.cataclysm$getCapability(ModCapabilities.PARRY_CAPABILITY);
                if (parryCapability != null) {
                    parryCapability.setParryFrame(0);
                }
            }
        }
    }

    @Inject(method = "tickItemStackUsage", at = @At("HEAD"))
    private void injectTickItemStackUsage(ItemStack stack, CallbackInfo ci) {
        if(stack.isOf(ModItems.BULWARK_OF_THE_FLAME) && self instanceof PlayerEntity) {
            ParryCapability parryCapability = self.cataclysm$getCapability(ModCapabilities.PARRY_CAPABILITY);
            if (parryCapability != null) {
                parryCapability.setParryFrame(parryCapability.getParryFrame() + 1);
            }
        }
    }

    @Inject(method = "stopUsingItem", at = @At("HEAD"))
    private void injectStopUsingItem(CallbackInfo ci) {
        if(activeItemStack.isOf(ModItems.BULWARK_OF_THE_FLAME) && self instanceof PlayerEntity) {
            ParryCapability parryCapability = self.cataclysm$getCapability(ModCapabilities.PARRY_CAPABILITY);
            if (parryCapability != null) {
                parryCapability.setParryFrame(0);
            }
        }
    }
}


