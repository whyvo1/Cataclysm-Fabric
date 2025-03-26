package com.github.l_ender.cataclysm.world.data;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

public class CMWorldData extends PersistentState {

    private static final String IDENTIFIER = "cataclysm_world_data";
    private boolean LeviathanBossDefeatedOnce = false;
    private boolean IgnisBossDefeatedOnce = false;

    private CMWorldData() {
        super();
    }

    public static PersistentState.Type<CMWorldData> factory() {
        return new PersistentState.Type<>(CMWorldData::new, CMWorldData::load, null);
    }


    public static CMWorldData get(World world, RegistryKey<World> dim) {
        if (world instanceof ServerWorld) {
            ServerWorld overworld = world.getServer().getWorld(dim);
            PersistentStateManager storage = overworld.getPersistentStateManager();
            CMWorldData data = storage.getOrCreate(CMWorldData.factory(), IDENTIFIER);
            if (data != null) {
                data.markDirty();
            }
            return data;
        }
        return null;
    }


    public static CMWorldData load(NbtCompound nbt, RegistryWrapper.WrapperLookup p_323806_) {
        CMWorldData data = new CMWorldData();
        data.LeviathanBossDefeatedOnce = nbt.getBoolean("LeviathanDefeatedOnce");
        data.IgnisBossDefeatedOnce = nbt.getBoolean("IgnisDefeatedOnce");
        return data;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound compound, RegistryWrapper.WrapperLookup p_323890_) {
        compound.putBoolean("LeviathanDefeatedOnce", LeviathanBossDefeatedOnce);
        compound.putBoolean("IgnisDefeatedOnce", IgnisBossDefeatedOnce);
        return compound;
    }



    public boolean isLeviathanDefeatedOnce(){
        return LeviathanBossDefeatedOnce;
    }

    public void setLeviathanDefeatedOnce(boolean defeatedOnce){
        this.LeviathanBossDefeatedOnce = defeatedOnce;
    }

    public boolean isIgnisDefeatedOnce(){
        return IgnisBossDefeatedOnce;
    }

    public void setIgnisDefeatedOnce(boolean defeatedOnce){
        this.IgnisBossDefeatedOnce = defeatedOnce;
    }

}
