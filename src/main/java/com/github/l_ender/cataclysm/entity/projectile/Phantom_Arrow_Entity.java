package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.client.particle.Options.TrackLightningParticleOptions;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import org.jetbrains.annotations.Nullable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.UUID;

public class Phantom_Arrow_Entity extends PersistentProjectileEntity {
    private static final TrackedData<Integer> TRANSPARENCY  = DataTracker.registerData(Phantom_Arrow_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private boolean stopSeeking;
    public Phantom_Arrow_Entity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    public Phantom_Arrow_Entity(EntityType type, double x, double y, double z, World worldIn) {
        this(type, worldIn);
        this.setPosition(x, y, z);
    }

    public Phantom_Arrow_Entity(World worldIn, LivingEntity shooter, @Nullable LivingEntity finalTarget) {
        this(ModEntities.PHANTOM_ARROW, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        this.finalTarget = finalTarget;
        if (shooter instanceof PlayerEntity) {
            this.pickupType = PickupPermission.ALLOWED;
        }
    }

    public Phantom_Arrow_Entity(World worldIn, LivingEntity shooter) {
        this(ModEntities.PHANTOM_ARROW, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof PlayerEntity) {
            this.pickupType = PickupPermission.ALLOWED;
        }
    }

    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(TRANSPARENCY, 0);
    }


    public int getTransparency() {
        return this.dataTracker.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.dataTracker.set(TRANSPARENCY, trans);
    }

    public void writeCustomDataToNbt(NbtCompound p_37357_) {
        super.writeCustomDataToNbt(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.putUuid("Target", this.finalTarget.getUuid());
        }
    }

    public void readCustomDataFromNbt(NbtCompound p_37353_) {
        super.readCustomDataFromNbt(p_37353_);
        if (p_37353_.containsUuid("Target")) {
            this.targetId = p_37353_.getUuid("Target");
        }
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerWorld) this.getWorld()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
            setTransparency(this.life);
            if (!inGround ) {
                if(!stopSeeking) {
                    if (this.finalTarget != null && this.finalTarget.isAlive() || (this.finalTarget instanceof PlayerEntity && !this.finalTarget.isSpectator())) {
                        float sqrt = (float) this.getVelocity().length();
                        if (sqrt > 1.25F) {
                            if (this.age > 2) {
                                if (finalTarget != null) {
                                    Vec3d arcVec = finalTarget.getPos().add(0, 0.65F * finalTarget.getHeight(), 0).subtract(this.getPos());
                                    if (arcVec.length() > finalTarget.getWidth()) {
                                        this.setVelocity(this.getVelocity().multiply(0.625F).add(arcVec.normalize().multiply(0.4775F)));

                                    }
                                }

                            }

                        }
                    }
                }
            }
        }else{
            Vec3d center = this.getPos().add(this.getVelocity());
            Vec3d vec3 = center.add(new Vec3d(random.nextFloat() - 0.5F, random.nextFloat() - 0.5F, random.nextFloat() - 0.5F));
            this.getWorld().addParticle((new TrackLightningParticleOptions(26, 107,  89)), center.x, center.y, center.z, vec3.x, vec3.y, vec3.z);
            Vec3d vec31 = this.getVelocity();
            double d5 = vec31.x;
            double d6 = vec31.y;
            double d1 = vec31.z;
            for(int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ModParticle.CURSED_FLAME, this.getX() + d5 * (double)i / 4.0D, this.getY() + d6 * (double)i / 4.0D, this.getZ() + d1 * (double)i / 4.0D, 0, 0, 0);
            }
        }
    }


    protected void age() {
        ++this.life;
        if (this.life >= 200) {
            this.discard();
        }

    }





    @Override
    protected void onEntityHit(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float)this.getDamage();
        Entity entity1 = this.getOwner();
        DamageSource damagesource = CMDamageTypes.causeMaledictioSagittaDamage(this, entity1 == null ? this : entity1);
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            f = EnchantmentHelper.getDamage(serverlevel, this.getWeaponStack(), entity, damagesource, f);
        }
        boolean flag = entity.getType() == EntityType.ENDERMAN;
        this.stopSeeking = true;
        if (this.isOnFire() && !flag) {
            entity.setOnFireFor(5);
        }
        if (entity.damage(damagesource, f)) {
            if (flag) {
                return;
            }

            if (this.getWorld() instanceof ServerWorld serverlevel1) {
                EnchantmentHelper.onTargetDamaged(serverlevel1, entity, damagesource, this.getWeaponStack());
            }

            if (entity instanceof LivingEntity livingentity) {
                this.knockback(livingentity, damagesource);
                this.onHit(livingentity);
            }
        } else {
            this.setVelocity(this.getVelocity().multiply(-0.1D));
            this.setYaw(this.getYaw() + 180.0F);
            this.prevYaw += 180.0F;
            if (!this.getWorld().isClient && this.getVelocity().lengthSquared() < 1.0E-7D) {
                if (this.pickupType == PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1F);
                }
            }
            this.discard();
        }

        this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));

    }


    @Override
    public ItemStack getWeaponStack() {
        return this.getItemStack();
    }

    protected void onHit(LivingEntity entity) {
        //stopSeeking = true;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.ARROW);
    }



}
