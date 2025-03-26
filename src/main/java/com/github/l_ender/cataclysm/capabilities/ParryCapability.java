package com.github.l_ender.cataclysm.capabilities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;


public class ParryCapability extends Capability<LivingEntity> {
//    public static Identifier ID = Cataclysm.modIdentifier("parry_cap");

    public int frame;

    public LivingEntity owner;

    public ParryCapability(CapabilityType<ParryCapability, LivingEntity> type, LivingEntity owner) {
        super(type);
        this.owner = owner;
    }

    public void setParryFrame(int timer) {
        this.frame = timer;
    }

    public int getParryFrame() {
        return frame;
    }

    @Override
    public NbtCompound serializeNBT() {
        NbtCompound tag = new NbtCompound();
        tag.putInt("frame", this.getParryFrame());
        return tag;
    }

    @Override
    public void deserializeNBT(NbtCompound nbt) {
        this.setParryFrame(nbt.getInt("frame"));
    }

    @Override
    public String getName() {
        return "cataclysm:parry_cap";
    }


//    public interface IParryCapability extends INBTSerializable<NbtCompound> {
//
//
//
//        void setParryFrame(int frame);
//
//        int getParryFrame();
//
//    }
//
//    public static class ParryCapabilityImp implements IParryCapability {
//
//
//
//        public static class ParryProvider implements ICapabilityProvider, ICapabilitySerializable<NbtCompound> {
//            private final LazyOptional<ParryCapability.IParryCapability> instance = LazyOptional.of(ParryCapabilityImp::new);
//
//            @Override
//            public NbtCompound serializeNBT() {
//                return instance.orElseThrow(NullPointerException::new).serializeNBT();
//            }
//
//            @Override
//            public void deserializeNBT(NbtCompound nbt) {
//                instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
//            }
//
//            @NotNull
//            @Override
//            public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
//                return ModCapabilities.PARRY_CAPABILITY.orEmpty(cap, instance.cast());
//            }
//        }
//    }
}
