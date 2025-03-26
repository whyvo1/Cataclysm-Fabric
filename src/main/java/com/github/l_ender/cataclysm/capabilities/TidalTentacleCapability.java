package com.github.l_ender.cataclysm.capabilities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.UUID;

public class TidalTentacleCapability extends Capability<LivingEntity> {
//    public static Identifier ID = Cataclysm.modIdentifier("tentacle_cap");

    private UUID lastTentacle;
    private boolean tentacle;
    public int id;
    public LivingEntity owner;

    public TidalTentacleCapability(CapabilityType<TidalTentacleCapability, LivingEntity> type, LivingEntity owner) {
        super(type);
        this.owner = owner;
    }

    public void setHasTentacle(boolean Tentacle) {
        this.tentacle = Tentacle;
    }

    public boolean hasTentacle() {
        return this.tentacle;
    }

    public void setLastTentacleID(int frozenPitch) {
        this.id = frozenPitch;
    }

    public int getLastTentacleID() {
        return id;
    }

    public void setLastTentacleUUID(UUID livingEntity) {
        lastTentacle = livingEntity;
    }

    public UUID getLastTentacleUUID() {
        return lastTentacle;
    }


    @Override
    public NbtCompound serializeNBT() {
        NbtCompound tag = new NbtCompound();
        tag.putBoolean("hasTentacle", this.hasTentacle());
        tag.putInt("getLastTentacleID", this.getLastTentacleID());
        if (getLastTentacleUUID() != null) {
            tag.putUuid("getLastTentacleUUID", getLastTentacleUUID());
        }
        return tag;
    }

    @Override
    public void deserializeNBT(NbtCompound nbt) {
        this.setHasTentacle(nbt.getBoolean("hasTentacle"));
        this.setLastTentacleID(nbt.getInt("getLastTentacleID"));
        try {
            setLastTentacleUUID(nbt.getUuid("getLastTentacleUUID"));
        }
        catch (NullPointerException ignored) {}
    }

    @Override
    public String getName() {
        return "cataclysm:tentacle_cap";
    }

//    public interface ITentacleCapability extends INBTSerializable<NbtCompound> {
//
//        void setHasTentacle(boolean hasTentacle);
//
//        boolean hasTentacle();
//
//        void setLastTentacleID(int id);
//
//        int getLastTentacleID();
//
//        UUID getLastTentacleUUID();
//
//        void setLastTentacleUUID(UUID livingEntity);
//
//    }
//
//    public static class TentacleCapabilityImp implements ITentacleCapability {
//
//
//        public static class TentacleProvider implements ICapabilityProvider, ICapabilitySerializable<NbtCompound> {
//            private final LazyOptional<ITentacleCapability> instance = LazyOptional.of(TidalTentacleCapability.TentacleCapabilityImp::new);
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
//                return ModCapabilities.TENTACLE_CAPABILITY.orEmpty(cap, instance.cast());
//            }
//        }
//    }
}
