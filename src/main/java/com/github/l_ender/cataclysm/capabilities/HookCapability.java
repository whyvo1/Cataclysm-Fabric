package com.github.l_ender.cataclysm.capabilities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;

public class HookCapability extends Capability<LivingEntity> {
//    public static Identifier ID = Cataclysm.modIdentifier("hook_cap");

    private boolean hook;
    public LivingEntity owner;
//    public static String NAME = "hook";

    public HookCapability(CapabilityType<HookCapability, LivingEntity> type, LivingEntity owner) {
        super(type);
        this.hook = false;
        this.owner = owner;
    }

    @Override
    public void tick() {
        if (this.hasHook()) {
            if (!owner.isOnGround()) {
                owner.onLanding();
            }
        }
    }

    public void setHasHook(boolean hook) {
        this.hook = hook;
    }

    public boolean hasHook() {
        return this.hook;
    }

    @Override
    public NbtCompound serializeNBT() {
        NbtCompound tag = new NbtCompound();
        tag.putBoolean("hasHook", this.hasHook());
        return tag;
    }

    @Override
    public void deserializeNBT(NbtCompound nbt) {
        this.setHasHook(nbt.getBoolean("hasHook"));
    }

    @Override
    public String getName() {
        return "cataclysm:hook_cap";
    }

//    public static class HookProvider implements ICapabilityProvider, ICapabilitySerializable<NbtCompound> {
//        private final LazyOptional<IHookCapability> instance = LazyOptional.of(HookCapability.HookCapabilityImp::new);
//
//        @Override
//        public NbtCompound serializeNBT() {
//            return instance.orElseThrow(NullPointerException::new).serializeNBT();
//        }
//
//        @Override
//        public void deserializeNBT(NbtCompound nbt) {
//            instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
//        }
//
//        @NotNull
//        @Override
//        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
//            return ModCapabilities.HOOK_CAPABILITY.orEmpty(cap, instance.cast());
//        }
//    }
//
//    public interface IHookCapability extends INBTSerializable<NbtCompound> {
//
//
//        void tick(LivingEntity entity);
//
//        void setHasHook(boolean hasHook);
//
//        boolean hasHook();
//
//
//    }
//
//    public static class HookCapabilityImp implements IHookCapability {
//
//
//
//    }
}
