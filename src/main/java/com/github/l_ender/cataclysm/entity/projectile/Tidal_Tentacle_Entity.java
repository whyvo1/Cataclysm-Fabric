package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.l_ender.cataclysm.entity.util.TidalTentacleUtil;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Tidal_Tentacle_Entity extends Entity {

    private static final TrackedData<Optional<UUID>> CREATOR_ID = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final TrackedData<Integer> FROM_ID = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> TARGET_COUNT = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CURRENT_TARGET_ID = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> PROGRESS = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Boolean> RETRACTING = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> HAS_CLAW = DataTracker.registerData(Tidal_Tentacle_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private List<Entity> previouslyTouched = new ArrayList<>();
    private boolean hasChained = false;
    public float prevProgress = 0;
    public static final float MAX_EXTEND_TIME = 5F;

    public Tidal_Tentacle_Entity(EntityType<?> type, World level) {
        super(type, level);
    }

//    public Tidal_Tentacle_Entity(PlayMessages.SpawnEntity spawnEntity, World world) {
//        this(ModEntities.TIDAL_TENTACLE.get(), world);
//    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return (Packet<ClientPlayPacketListener>) NetworkHooks.getEntitySpawningPacket(this);
//    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(CREATOR_ID, Optional.empty());
        this.dataTracker.startTracking(FROM_ID, -1);
        this.dataTracker.startTracking(TARGET_COUNT, 0);
        this.dataTracker.startTracking(CURRENT_TARGET_ID, -1);
        this.dataTracker.startTracking(PROGRESS, 0F);
        this.dataTracker.startTracking(DAMAGE, 3F);
        this.dataTracker.startTracking(RETRACTING, false);
        this.dataTracker.startTracking(HAS_CLAW, true);
    }

    @Override
    public void tick() {
        float progress = this.getProgress();
        this.prevProgress = progress;
        super.tick();
        Entity creator = getCreatorEntity();
        Entity current = getToEntity();
        if(age == 1){
            if(!this.getWorld().isClient){
                this.playSound(ModSounds.TIDAL_TENTACLE,1.0F, 0.8F + this.random.nextFloat() * 0.4F);
            }
        }
        if(!this.isRetracting() && progress < MAX_EXTEND_TIME){
            this.setProgress(progress + 1);
        }
        if(this.isRetracting() && progress > 0F){
            this.setProgress(progress - 1);
        }
        if(this.isRetracting() && progress == 0F){
            Entity from = this.getFromEntity();
            if(from instanceof Tidal_Tentacle_Entity tendonSegment){
                tendonSegment.setRetracting(true);
                updateLastTendon(tendonSegment);
            }else{
                updateLastTendon(null);
            }

            kill();
        }
        if (creator instanceof LivingEntity) {
            if (current != null) {
                Vec3d target = new Vec3d(current.getX(), current.getBodyY(0.4F), current.getZ());
                Vec3d lerp = target.subtract(this.getPos());
                this.setVelocity(lerp.multiply(0.5F));
                if(!this.getWorld().isClient){
                    if(progress >= MAX_EXTEND_TIME){
                        if (this.age % 2 == 0) {
                            Entity entity = getCreatorEntity();
                            if(entity instanceof LivingEntity) {
                                if (current != creator && current.damage(getDamageSources().mobProjectile(this, (LivingEntity) entity), this.getBaseDamage())) {
                                    StatusEffectInstance effectinstance1 = ((LivingEntity)current).getStatusEffect(ModEffect.EFFECTABYSSAL_CURSE);
                                    int i = 1;
                                    if (effectinstance1 != null) {
                                        i += effectinstance1.getAmplifier();
                                        ((LivingEntity)current).removeStatusEffectInternal(ModEffect.EFFECTABYSSAL_CURSE);
                                    } else {
                                        --i;
                                    }

                                    i = MathHelper.clamp(i, 0, 4);
                                    StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTABYSSAL_CURSE, 60, i, false, true, true);
                                    ((LivingEntity)current).addStatusEffect(effectinstance);

                                    this.applyDamageEffects((LivingEntity) creator, current);
                                }
                            }
                        }
                    }
                }
            }
        }
        Vec3d vector3d = this.getVelocity();
        if(!this.getWorld().isClient){
            if(!hasChained){
                if(this.getTargetsHit() > 5){
                    this.setRetracting(true);
                }else if(creator instanceof LivingEntity && this.getProgress() >= MAX_EXTEND_TIME) {
                    Entity closestValid = null;
                    for (Entity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(12.0D))) {
                        if (!entity.equals(creator) && !previouslyTouched.contains(entity) && isValidTarget((LivingEntity) creator, entity) && this.hasLineOfSight(entity)) {
                            if (closestValid == null || this.distanceTo(entity) < this.distanceTo(closestValid)) {
                                closestValid = entity;
                            }
                        }
                    }
                    if(closestValid != null){
                        createChain(closestValid);
                        hasChained = true;
                    }else{
                        this.setRetracting(true);
                    }
                }
            }
        }

        double d0 = this.getX() + vector3d.x;
        double d1 = this.getY() + vector3d.y;
        double d2 = this.getZ() + vector3d.z;
        this.setVelocity(vector3d.multiply(0.99F));
        this.setPosition(d0, d1, d2);
    }

    @Override
    public void kill() {
        if(!getWorld().isClient && getCreatorEntity() instanceof PlayerEntity player) {
            TidalTentacleCapability hookCapability = ModCapabilities.getOrCreate(player, ModCapabilities.TIDAL_TENTACLE_CAPABILITY);
            if (hookCapability != null) {
                hookCapability.setHasTentacle(false);
            }
        }

        super.kill();
    }

    private boolean isValidTarget(LivingEntity creator, Entity entity) {
        if(!creator.isTeammate(entity) && !entity.isTeammate(creator) && entity instanceof MobEntity){
            return true;
        }
        return creator.getAttacking() != null && creator.getAttacking().getUuid().equals(entity.getUuid()) || creator.getAttacker() != null && creator.getAttacker().getUuid().equals(entity.getUuid());
    }

    private double getDamageForItem(ItemStack itemStack) {
        Multimap<EntityAttribute, EntityAttributeModifier> map = itemStack.getAttributeModifiers(EquipmentSlot.MAINHAND);
        if (!map.isEmpty()) {
            double d = 0;
            for (EntityAttributeModifier mod : map.get(EntityAttributes.GENERIC_ATTACK_DAMAGE)) {
                d += mod.getValue();
            }
            return d;
        }
        return 0;
    }

    private boolean hasLineOfSight(Entity entity) {
        if (entity.getWorld() != this.getWorld()) {
            return false;
        } else {
            Vec3d vec3 = new Vec3d(this.getX(), this.getEyeY(), this.getZ());
            Vec3d vec31 = new Vec3d(entity.getX(), entity.getEyeY(), entity.getZ());
            if (vec31.distanceTo(vec3) > 128.0D) {
                return false;
            } else {
                return this.getWorld().raycast(new RaycastContext(vec3, vec31, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this)).getType() == HitResult.Type.MISS;
            }
        }
    }

    private void updateLastTendon(Tidal_Tentacle_Entity lastTendon){
        Entity creator = getCreatorEntity();
        if(creator == null){
            creator = getWorld().getPlayerByUuid(this.getCreatorEntityUUID());
        }
        if(creator instanceof LivingEntity){
            TidalTentacleUtil.setLastTentacle((LivingEntity)creator, lastTendon);
        }
    }

    private void createChain(Entity closestValid) {
        this.dataTracker.set(HAS_CLAW, false);
        Tidal_Tentacle_Entity child = ModEntities.TIDAL_TENTACLE.create(this.getWorld());
        child.previouslyTouched = new ArrayList<>(previouslyTouched);
        child.previouslyTouched.add(closestValid);
        child.setCreatorEntityUUID(this.getCreatorEntityUUID());
        child.setFromEntityID(this.getId());
        child.setToEntityID(closestValid.getId());
        child.setPosition(closestValid.getX(), closestValid.getBodyY(0.4F), closestValid.getZ());
        child.setTargetsHit(this.getTargetsHit() + 1);
        updateLastTendon(child);
        this.getWorld().spawnEntity(child);
    }


    private float getBaseDamage() {
        return this.dataTracker.get(DAMAGE);
    }

    public UUID getCreatorEntityUUID() {
        return this.dataTracker.get(CREATOR_ID).orElse(null);
    }

    public void setCreatorEntityUUID(UUID id) {
        this.dataTracker.set(CREATOR_ID, Optional.ofNullable(id));
    }

    public Entity getCreatorEntity() {
        UUID uuid = getCreatorEntityUUID();
        if(uuid != null && !this.getWorld().isClient){
            return ((ServerWorld) getWorld()).getEntity(uuid);
        }
        return null;
    }

    public int getFromEntityID() {
        return this.dataTracker.get(FROM_ID);
    }

    public void setFromEntityID(int id) {
        this.dataTracker.set(FROM_ID, id);
    }

    public Entity getFromEntity() {
        return getFromEntityID() == -1 ? null : this.getWorld().getEntityById(getFromEntityID());
    }

    public int getToEntityID() {
        return this.dataTracker.get(CURRENT_TARGET_ID);
    }

    public void setToEntityID(int id) {
        this.dataTracker.set(CURRENT_TARGET_ID, id);
    }

    public Entity getToEntity() {
        return getToEntityID() == -1 ? null : this.getWorld().getEntityById(getToEntityID());
    }

    public int getTargetsHit() {
        return this.dataTracker.get(TARGET_COUNT);
    }

    public void setTargetsHit(int i) {
        this.dataTracker.set(TARGET_COUNT, i);
    }

    public float getProgress() {
        return this.dataTracker.get(PROGRESS);
    }

    public void setProgress(float progress) {
        this.dataTracker.set(PROGRESS, progress);
    }

    public boolean isRetracting() {
        return this.dataTracker.get(RETRACTING);
    }

    public void setRetracting(boolean retract) {
        this.dataTracker.set(RETRACTING, retract);
    }


    public boolean hasClaw() {
        return this.dataTracker.get(HAS_CLAW);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound p_20052_) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound p_20139_) {

    }

    public boolean isCreator(Entity mob) {
        return this.getCreatorEntityUUID() != null && mob.getUuid().equals(this.getCreatorEntityUUID());
    }
}
