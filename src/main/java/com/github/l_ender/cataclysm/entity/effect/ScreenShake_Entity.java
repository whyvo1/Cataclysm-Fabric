package com.github.l_ender.cataclysm.entity.effect;


import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ScreenShake_Entity extends Entity {
    private static final TrackedData<Float> RADIUS = DataTracker.registerData(ScreenShake_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> MAGNITUDE = DataTracker.registerData(ScreenShake_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(ScreenShake_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> FADE_DURATION = DataTracker.registerData(ScreenShake_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    public ScreenShake_Entity(EntityType<?> type, World world) {
        super(type, world);
    }

    public ScreenShake_Entity(World world, Vec3d position, float radius, float magnitude, int duration, int fadeDuration) {
        super(ModEntities.SCREEN_SHAKE, world);
        setRadius(radius);
        setMagnitude(magnitude);
        setDuration(duration);
        setFadeDuration(fadeDuration);
        setPosition(position.x, position.y, position.z);
    }

    @Environment(EnvType.CLIENT)
    public float getShakeAmount(PlayerEntity player, float delta) {
        float ticksDelta = age + delta;
        float timeFrac = 1.0f - (ticksDelta - getDuration()) / (getFadeDuration() + 1.0f);
        float baseAmount = ticksDelta < getDuration() ? getMagnitude() : timeFrac * timeFrac * getMagnitude();
        Vec3d playerPos = player.getCameraPosVec(delta);
        float distFrac = (float) (1.0f - MathHelper.clamp(getPos().distanceTo(playerPos) / getRadius(), 0, 1));
        return baseAmount * distFrac * distFrac;
    }

    @Override
    public void tick() {
        super.tick();
        if (age > getDuration() + getFadeDuration()) discard();
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(RADIUS, 10.0f);
        this.dataTracker.startTracking(MAGNITUDE, 1.0f);
        this.dataTracker.startTracking(DURATION, 0);
        this.dataTracker.startTracking(FADE_DURATION, 5);
    }

    public float getRadius() {
        return this.dataTracker.get(RADIUS);
    }

    public void setRadius(float radius) {
        this.dataTracker.set(RADIUS, radius);
    }

    public float getMagnitude() {
        return this.dataTracker.get(MAGNITUDE);
    }

    public void setMagnitude(float magnitude) {
        this.dataTracker.set(MAGNITUDE, magnitude);
    }

    public int getDuration() {
        return this.dataTracker.get(DURATION);
    }

    public void setDuration(int duration) {
        this.dataTracker.set(DURATION, duration);
    }

    public int getFadeDuration() {
        return this.dataTracker.get(FADE_DURATION);
    }

    public void setFadeDuration(int fadeDuration) {
        this.dataTracker.set(FADE_DURATION, fadeDuration);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound compound) {
        setRadius(compound.getFloat("radius"));
        setMagnitude(compound.getFloat("magnitude"));
        setDuration(compound.getInt("duration"));
        setFadeDuration(compound.getInt("fade_duration"));
        age = compound.getInt("ticks_existed");
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putFloat("radius", getRadius());
        compound.putFloat("magnitude", getMagnitude());
        compound.putInt("duration", getDuration());
        compound.putInt("fade_duration", getFadeDuration());
        compound.putInt("ticks_existed", age);
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    public static void ScreenShake(World world, Vec3d position, float radius, float magnitude, int duration, int fadeDuration) {
        if (!world.isClient) {
            ScreenShake_Entity ScreenShake = new ScreenShake_Entity(world, position, radius, magnitude, duration, fadeDuration);
            world.spawnEntity(ScreenShake);
        }
    }
}
