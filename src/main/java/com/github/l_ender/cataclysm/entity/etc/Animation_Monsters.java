package com.github.l_ender.cataclysm.entity.etc;


import com.github.l_ender.cataclysm.message.MessageMusic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.UUID;

public class Animation_Monsters extends HostileEntity implements Monster {

    protected boolean dropAfterDeathAnim = false;
    public int killDataRecentlyHit;
    public DamageSource killDataCause;
    public PlayerEntity killDataAttackingPlayer;
    public int attackTicks;

    @Environment(EnvType.CLIENT)
    public Vec3d[] socketPosArray;


    public Animation_Monsters(EntityType<? extends Animation_Monsters> entity, World world) {
        super(entity, world);
        if (world.isClient) {
            socketPosArray = new Vec3d[]{};
        }
    }

    protected void initDataTracker() {
        super.initDataTracker();
    }


    public void tick() {
        super.tick();
        if (!getWorld().isClient && getBossMusic() != null) {

            if (canPlayMusic() && this.getBossMusic() != null) {
                new MessageMusic(this.getId(), true).sendToClient(this);
            } else {
                new MessageMusic(this.getId(), false).sendToClient(this);
            }
        }
    }

    @Override
    public void handleStatus(byte id) {
        super.handleStatus(id);
    }

    public boolean canPlayerHearMusic(PlayerEntity player) {
        return player != null
                && canTarget(player)
                && distanceTo(player) < 2500;
    }

    public static void setConfigattribute(LivingEntity entity, double hpconfig, double dmgconfig) {
        EntityAttributeInstance maxHealthAttr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (maxHealthAttr != null) {
            double difference = maxHealthAttr.getBaseValue() * hpconfig - maxHealthAttr.getBaseValue();
            maxHealthAttr.addTemporaryModifier(new EntityAttributeModifier(UUID.fromString("9513569b-57b6-41f5-814e-bdc49b81799f"), "Health config multiplier", difference, EntityAttributeModifier.Operation.ADDITION));
            entity.setHealth(entity.getMaxHealth());
        }
        EntityAttributeInstance attackDamageAttr = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackDamageAttr != null) {
            double difference = attackDamageAttr.getBaseValue() * dmgconfig - attackDamageAttr.getBaseValue();
            attackDamageAttr.addTemporaryModifier(new EntityAttributeModifier(UUID.fromString("5b17d7cb-294e-4379-88ab-136c372bec9b"), "Attack config multiplier", difference, EntityAttributeModifier.Operation.ADDITION));

        }
    }

    public double calculateRange(DamageSource damagesource) {
        return damagesource.getAttacker() != null ? squaredDistanceTo(damagesource.getAttacker()) : -1;
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * (180 / Math.PI) + 90;
    }

    public void disableShield(PlayerEntity player, int ticks) {
        if (player.isBlocking()) {
            if (!player.getWorld().isClient) {
                player.getItemCooldownManager().set(player.getActiveItem().getItem(), ticks);
                player.clearActiveItem();
                player.getWorld().sendEntityStatus(this, (byte)30);
            }
        }
    }

    protected boolean canPlayMusic() {
        return !isSilent() && getTarget() instanceof PlayerEntity && getTarget() != null && this.getTarget().isAlive();
    }

    @Override
    protected void updatePostDeath() {
        onDeathUpdate(this.deathtimer());
    }

    public SoundEvent getBossMusic() {
        return null;
    }


    public int deathtimer(){
        return 20;
    }


    protected void onDeathAIUpdate() {}

    public void onDeathUpdate(int deathDuration) { // TODO copy from entityLiving
        onDeathAIUpdate();
        ++this.deathTime;
        if (this.deathTime >= deathDuration && !this.getWorld().isClient() && !this.isRemoved()) {
            this.getWorld().sendEntityStatus(this, (byte) 60);
            this.remove(RemovalReason.KILLED);
        }
    }

    @Override
    public void onDeath(DamageSource cause) // TODO copy from entityLiving
    {
//        if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, cause)) return;
        if (!this.dead) {
            Entity entity = cause.getAttacker();
            LivingEntity livingentity = this.getPrimeAdversary();
            if (this.scoreAmount >= 0 && livingentity != null) {
                livingentity.updateKilledAdvancementCriterion(this, this.scoreAmount, cause);
            }

            if (this.isSleeping()) {
                this.wakeUp();
            }

            this.dead = true;
            this.getDamageTracker().update();
            if (this.getWorld() instanceof ServerWorld) {
                if (entity == null || entity.onKilledOther((ServerWorld)this.getWorld(), this)) {
                    this.emitGameEvent(GameEvent.ENTITY_DIE);
                    this.onKilledBy(livingentity);
                    this.AfterDefeatBoss(livingentity);
                    if (!dropAfterDeathAnim){
                        this.drop(cause);
                    }
                }
            }
            killDataCause = cause;
            killDataRecentlyHit = this.playerHitTimer;
            killDataAttackingPlayer = attackingPlayer;

            this.getWorld().sendEntityStatus(this, (byte)3);
            this.setPose(EntityPose.DYING);
        }
    }

    protected void AfterDefeatBoss(@Nullable LivingEntity p_21269_) {
    }


    public void circleEntity(Entity target, float radius, float speed, boolean direction, int circleFrame, float offset, float moveSpeedMultiplier) {
        int directionInt = direction ? 1 : -1;
        double t = directionInt * circleFrame * 0.5 * speed / radius + offset;
        Vec3d movePos = target.getPos().add(radius * Math.cos(t), 0, radius * Math.sin(t));
        this.getNavigation().startMovingTo(movePos.x, movePos.y, movePos.z, speed * moveSpeedMultiplier);
    }

    protected void repelEntities(float x, float y, float z, float radius) {
        List<LivingEntity> nearbyEntities = getEntityLivingBaseNearby(x, y, z, radius);
        for (Entity entity : nearbyEntities) {
            if (entity.canHit() && !entity.noClip) {
                double angle = (getAngleBetweenEntities(this, entity) + 90) * Math.PI / 180;
                entity.setVelocity(-0.1 * Math.cos(angle), entity.getVelocity().y, -0.1 * Math.sin(angle));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public void setSocketPosArray(int index, Vec3d pos) {
        if (socketPosArray != null && socketPosArray.length > index) {
            socketPosArray[index] = pos;
        }
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    // TODO: Copied from parent classes
    @Override
    public void pushAwayFrom(Entity entityIn) {
        if (!this.isSleeping()) {
            if (!this.isConnectedThroughVehicle(entityIn)) {
                if (!entityIn.noClip && !this.noClip) {
                    double d0 = entityIn.getX() - this.getX();
                    double d1 = entityIn.getZ() - this.getZ();
                    double d2 = MathHelper.absMax(d0, d1);
                    if (d2 >= (double)0.01F) {
                        d2 = MathHelper.sqrt((float) d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;
                        if (d3 > 1.0D) {
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * (double)0.05F;
                        d1 = d1 * (double)0.05F;
                        // d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                        // d1 = d1 * (double)(1.0F - this.entityCollisionReduction);
                        if (!this.hasPassengers()) {
                            if (canBePushedByEntity(entityIn)) {
                                this.addVelocity(-d0, 0.0D, -d1);
                            }
                        }

                        if (!entityIn.hasPassengers()) {
                            entityIn.addVelocity(d0, 0.0D, d1);
                        }
                    }

                }
            }
        }
    }


    public  List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return getWorld().getEntitiesByClass(entityClass, getBoundingBox().expand(dX, dY, dZ), e -> e != this && distanceTo(e) <= r + e.getWidth() / 2f && e.getY() <= getY() + dY);
    }
}
