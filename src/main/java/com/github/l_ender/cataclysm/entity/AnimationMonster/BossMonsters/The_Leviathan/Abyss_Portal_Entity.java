package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Abyss_Portal_Entity extends Entity {

    protected static final TrackedData<Integer> LIFESPAN = DataTracker.registerData(Abyss_Portal_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    protected static final TrackedData<Boolean> ENTRANCE = DataTracker.registerData(Abyss_Portal_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Optional<BlockPos>> DESTINATION = DataTracker.registerData(Abyss_Portal_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_BLOCK_POS);
    private static final TrackedData<Optional<UUID>> SISTER_UUID = DataTracker.registerData(Abyss_Portal_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);

    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    private boolean isDummy = false;
    private boolean hasClearedObstructions;


    public Abyss_Portal_Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

//    public Abyss_Portal_Entity(PlayMessages.SpawnEntity spawnEntity, World level) {
//        this(ModEntities.ABYSS_PORTAL.get(), level);
//    }


//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    public void tick() {
        super.tick();
        if (this.age == 1) {
            if(this.getLifespan() == 0){
                this.setLifespan(2000);
            }
        }
        if(!madeOpenNoise){
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.playSound(SoundEvents.BLOCK_END_PORTAL_SPAWN, 1.0F, 1 + random.nextFloat() * 0.2F);
            madeOpenNoise = true;
        }
        if(random.nextFloat() < 0.5F && getWorld().isClient && Math.min(age, this.getLifespan()) >= 20){
            double particleX = this.getBoundingBox().minX + random.nextFloat() * (this.getBoundingBox().maxX - this.getBoundingBox().minX);
            double particleY = this.getBoundingBox().minY + random.nextFloat() * (this.getBoundingBox().maxY - this.getBoundingBox().minY);
            double particleZ = this.getBoundingBox().minZ + random.nextFloat() * (this.getBoundingBox().maxZ - this.getBoundingBox().minZ);
            getWorld().addParticle(ParticleTypes.PORTAL, particleX, particleY, particleZ, 0.1 * random.nextGaussian(), 0.1 * random.nextGaussian(), 0.1 * random.nextGaussian());
        }
        List<Entity> entities = new ArrayList<>();
        entities.addAll(this.getWorld().getOtherEntities(this, this.getBoundingBox().contract(0.2F)));
        entities.addAll(this.getWorld().getNonSpectatingEntities(The_Leviathan_Entity.class, this.getBoundingBox().expand(3)));
        if (!getWorld().isClient) {
            if (this.getDestination() != null && this.getLifespan() > 20 && age > 20 && this.getEntrance()) {
                for (Entity e : entities) {
                    if(e.hasPortalCooldown() || e.isSneaking() || e instanceof Abyss_Portal_Entity ){
                        continue;
                    }
                     if (e instanceof The_Leviathan_Entity) {
                        ((The_Leviathan_Entity) e).teleportTo(Vec3d.ofCenter(this.getDestination()));
                        e.resetPortalCooldown();
                        ((The_Leviathan_Entity) e).resetPortalLogic();
                    }else {
                        e.teleport(this.getDestination().getX() + 0.5f, this.getDestination().getY() + 0.5f, this.getDestination().getZ() + 0.5f);
                        e.resetPortalCooldown();
                     }
                }
            }
        }
        this.setLifespan(this.getLifespan() - 1);
        if(this.getLifespan() <= 20){
            if(!madeCloseNoise){
                this.emitGameEvent(GameEvent.ENTITY_PLACE);
//                this.playSound(AMSoundRegistry.VOID_PORTAL_CLOSE.get(), 1.0F, 1 + random.nextFloat() * 0.2F);
                madeCloseNoise = true;
            }
        }
        if (this.getLifespan() <= 0) {
            this.remove(RemovalReason.DISCARDED);
        }
    }



    public int getLifespan() {
        return this.dataTracker.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.dataTracker.set(LIFESPAN, i);
    }


    public boolean getEntrance() {
        return this.dataTracker.get(ENTRANCE);
    }

    public void setEntrance(boolean entrance) {
        this.dataTracker.set(ENTRANCE, entrance);
    }

    public BlockPos getDestination() {
        return this.dataTracker.get(DESTINATION).orElse(null);
    }

    public void setDestination(BlockPos destination) {
        this.dataTracker.set(DESTINATION, Optional.ofNullable(destination));
        if (this.getSisterId() == null) {
            createAndSetSister(getWorld(), null);
        }
    }

    public void createAndSetSister(World world, Direction dir){
        Abyss_Portal_Entity portal = ModEntities.ABYSS_PORTAL.create(world);
        BlockPos safeDestination = this.getDestination();
        portal.teleport(safeDestination.getX() + 0.5f, safeDestination.getY() + 0.5f, safeDestination.getZ() + 0.5f);
        portal.link(this);
        portal.setEntrance(false);
        world.spawnEntity(portal);
    }

    public void setDestination(BlockPos destination, Direction dir) {
        this.dataTracker.set(DESTINATION, Optional.ofNullable(destination));
        if (this.getSisterId() == null ) {
            createAndSetSister(getWorld(), dir);
        }
    }

    public void link(Abyss_Portal_Entity portal) {
        this.setSisterId(portal.getUuid());
        portal.setSisterId(this.getUuid());
        portal.setLifespan(this.getLifespan());
        this.setDestination(portal.getBlockPos());
        portal.setDestination(this.getBlockPos());
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(LIFESPAN, 300);
        this.dataTracker.startTracking(SISTER_UUID, Optional.empty());
        this.dataTracker.startTracking(DESTINATION, Optional.empty());
        this.dataTracker.startTracking(ENTRANCE, true);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        if (compound.contains("DX")) {
            int i = compound.getInt("DX");
            int j = compound.getInt("DY");
            int k = compound.getInt("DZ");
            this.dataTracker.set(DESTINATION, Optional.of(new BlockPos(i, j, k)));
        } else {
            this.dataTracker.set(DESTINATION, Optional.empty());
        }
        if (compound.containsUuid("SisterUUID")) {
            this.setSisterId(compound.getUuid("SisterUUID"));
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Lifespan", getLifespan());
        BlockPos blockpos = this.getDestination();
        if (blockpos != null) {
            compound.putInt("DX", blockpos.getX());
            compound.putInt("DY", blockpos.getY());
            compound.putInt("DZ", blockpos.getZ());
        }
        if (this.getSisterId() != null) {
            compound.putUuid("SisterUUID", this.getSisterId());
        }
    }

    public Entity getSister() {
        UUID id = getSisterId();
        if (id != null && !getWorld().isClient) {
            return ((ServerWorld) getWorld()).getEntity(id);
        }
        return null;
    }

    @Override
    public boolean shouldRender(double distance) {

        return distance < 1024;
    }

    @Nullable
    public UUID getSisterId() {
        return this.dataTracker.get(SISTER_UUID).orElse(null);
    }

    public void setSisterId(@Nullable UUID uniqueId) {
        this.dataTracker.set(SISTER_UUID, Optional.ofNullable(uniqueId));
    }

}
