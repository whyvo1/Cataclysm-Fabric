package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.Optional;
import java.util.UUID;

public class The_Leviathan_Tongue_Entity extends Entity {

    private static final TrackedData<Optional<UUID>> CONTROLLER_UUID = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final TrackedData<Integer> CONTROLLER_ID = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> TARGET_ID = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> DURATION = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> MAX_DURATION = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> COMING_BACK = DataTracker.registerData(The_Leviathan_Tongue_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int destroyBlocksTick;

    public The_Leviathan_Tongue_Entity(EntityType<?> entityType, World level) {
        super(entityType, level);
    }


//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }


    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(CONTROLLER_UUID, Optional.empty());
        this.dataTracker.startTracking(CONTROLLER_ID, -1);
        this.dataTracker.startTracking(TARGET_ID, -1);
        this.dataTracker.startTracking(DURATION, 0);
        this.dataTracker.startTracking(MAX_DURATION, 0);
        this.dataTracker.startTracking(COMING_BACK, false);
    }


    public void tick() {
        super.tick();
        Entity controller = getController();
        Entity target = getTarget();

        if (!this.getPassengerList().isEmpty() && this.getPassengerList().get(0).isSneaking()) {
            this.getPassengerList().get(0).setSneaking(false);
        }

        if(this.getDuration() <= this.getMaxDuration()) {
            this.setDuration(this.getDuration() + 1);
        }


        if (!this.getWorld().isClient) {
            if(CMConfig.LeviathanBlockBreaking){
                blockbreak(0.25d,0.25d,0.25d);
            }else{
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    blockbreak(0.25d,0.25d,0.25d);
                }
            }
        }

        if (controller instanceof The_Leviathan_Entity levi) {
            this.dataTracker.set(CONTROLLER_ID, levi.getId());
            levi.setTongueUUID(this.getUuid());
            if (!getWorld().isClient) {
                Entity e = levi.getTarget();
                this.dataTracker.set(TARGET_ID, e != null && e.isAlive() ? e.getId() : -1);
            }


            boolean attacking = !this.getComingBack() && target != null && target.isAlive();
            Vec3d vec3 = attacking ? target.getEyePos() : levi.getTonguePosition();
            float speed = attacking ? 0.095f : 0.15f;
            Vec3d want = vec3.subtract(this.getPos());
            if (target != null && !this.getComingBack()) {
                if (want.length() < target.getWidth() + 1F) {
                    hurtEntity(levi, target);
                    this.setComingBack(true);
                }
            }
            directMovementTowards(vec3, speed);

            if (this.getDuration() >= this.getMaxDuration() / 2) {
                if (!this.getComingBack()) {
                    this.setComingBack(true);
                }
            }
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.9F));
    }

    private void hurtEntity(LivingEntity holder, Entity target) {
        if(target.damage(getDamageSources().mobAttack(holder), 6)){
            if (!this.getWorld().isClient) {
                target.startRiding(this);
//                Utilities.trySendOverlayMessage(target, Text.translatable("entity.cataclysm.you_cant_escape"));
            }
        }
    }




    private void blockbreak(double x, double y, double z) {
        if (!this.getWorld().isClient) {
            if (this.destroyBlocksTick > 0) {
                --this.destroyBlocksTick;
                return;
            }

            boolean flag = false;
            Box aabb = this.getBoundingBox().expand(x, y, z);
            for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(aabb.minY), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
                BlockState blockstate = this.getWorld().getBlockState(blockpos);
                if (!blockstate.isAir() && !blockstate.isIn(ModTag.LEVIATHAN_IMMUNE)) {
                    flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                }
            }
            if (flag) {
                destroyBlocksTick = 15;
            }
        }
    }


    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }


    private void directMovementTowards(Vec3d moveTo, float speed) {
        Vec3d want = moveTo.subtract(this.getPos());
        if (want.length() > 1F) {
            want = want.normalize();
        }
        float targetXRot = (float) (-(MathHelper.atan2(want.y, want.horizontalLength()) * (double) (180F / (float) Math.PI)));
        float targetYRot = (float) (-MathHelper.atan2(want.x, want.z) * (double) (180F / (float) Math.PI));
        this.setPitch(MathHelper.stepUnwrappedAngleTowards(this.getPitch(), targetXRot, 5F));
        this.setYaw(MathHelper.stepUnwrappedAngleTowards(this.getYaw(), targetYRot, 5F));
        this.setVelocity(this.getVelocity().add(want.multiply(speed)));

    }

    public boolean shouldRiderSit() {
        return false;
    }

    public double getMountedHeightOffset() {
        return -0.5D;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound tag) {
        if (tag.containsUuid("ControllerUUID")) {
            this.setControllerUUID(tag.getUuid("ControllerUUID"));
        }
        this.setDuration(tag.getInt("Duration"));
        this.setDuration(tag.getInt("Max_Duration"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound tag) {
        if (this.getControllerUUID() != null) {
            tag.putUuid("ControllerUUID", this.getControllerUUID());
        }
        tag.putInt("Duration", getDuration());
        tag.putInt("Max_Duration", getMaxDuration());
    }


    @Nullable
    public UUID getControllerUUID() {
        return this.dataTracker.get(CONTROLLER_UUID).orElse(null);
    }

    public void setControllerUUID(@Nullable UUID uniqueId) {
        this.dataTracker.set(CONTROLLER_UUID, Optional.ofNullable(uniqueId));
    }

    public int getDuration() {
        return this.dataTracker.get(DURATION);
    }

    public void setDuration(int i) {
        this.dataTracker.set(DURATION, i);
    }

    public int getMaxDuration() {
        return this.dataTracker.get(MAX_DURATION);
    }

    public void setMaxDuration(int i) {
        this.dataTracker.set(MAX_DURATION, i);
    }

    public boolean getComingBack() {
        return this.dataTracker.get(COMING_BACK);
    }

    public void setComingBack(boolean i) {
        this.dataTracker.set(COMING_BACK, i);
    }


    public Entity getController() {
        if (!getWorld().isClient) {
            final UUID id = getControllerUUID();
            return id == null ? null : ((ServerWorld) getWorld()).getEntity(id);
        } else {
            int id = this.dataTracker.get(CONTROLLER_ID);
            return id == -1 ? null : getWorld().getEntityById(id);
        }
    }

    public Entity getTarget() {
        int id = this.dataTracker.get(TARGET_ID);
        return id == -1 ? null : getWorld().getEntityById(id);
    }
}
