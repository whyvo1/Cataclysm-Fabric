package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Eye_Of_Dungeon_Entity extends Entity implements FlyingItemEntity {
    private static final TrackedData<ItemStack> DATA_ITEM_STACK = DataTracker.registerData(Eye_Of_Dungeon_Entity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private static final TrackedData<Integer> R = DataTracker.registerData(Eye_Of_Dungeon_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> G = DataTracker.registerData(Eye_Of_Dungeon_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> B = DataTracker.registerData(Eye_Of_Dungeon_Entity.class, TrackedDataHandlerRegistry.INTEGER);


    private double tx;
    private double ty;
    private double tz;
    private int life;

    public Eye_Of_Dungeon_Entity(EntityType<? extends Eye_Of_Dungeon_Entity> p_36957_, World p_36958_) {
        super(p_36957_, p_36958_);
    }

    public Eye_Of_Dungeon_Entity(World p_36960_, double p_36961_, double p_36962_, double p_36963_) {
        this(ModEntities.EYE_OF_DUNGEON, p_36960_);
        this.setPosition(p_36961_, p_36962_, p_36963_);
    }



    public ItemStack getStack() {
        return this.getDataTracker().get(DATA_ITEM_STACK);
    }

    public void setItem(ItemStack p_32046_) {
        this.getDataTracker().set(DATA_ITEM_STACK, Util.make(p_32046_.copy(), (p_36978_) -> {
            p_36978_.setCount(1);
        }));
    }

    private ItemStack getItemRaw() {
        return this.getDataTracker().get(DATA_ITEM_STACK);
    }


    public int getR()
    {
        return this.dataTracker.get(R);
    }

    public void setR(int r)
    {
        this.dataTracker.set(R, r);
    }

    public int getG()
    {
        return this.dataTracker.get(G);
    }

    public void setG(int g)
    {
        this.dataTracker.set(G, g);
    }


    public int getB()
    {
        return this.dataTracker.get(B);
    }

    public void setB(int b)
    {
        this.dataTracker.set(B, b);
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DATA_ITEM_STACK, ItemStack.EMPTY);
        p_326229_.add(R, 0);
        p_326229_.add(G, 0);
        p_326229_.add(B, 0);
    }


    public void setVelocityClient(double p_36984_, double p_36985_, double p_36986_) {
        this.setVelocity(p_36984_, p_36985_, p_36986_);
        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            double d0 = Math.sqrt(p_36984_ * p_36984_ + p_36986_ * p_36986_);
            this.setYaw((float)(MathHelper.atan2(p_36984_, p_36986_) * (double)(180F / (float)Math.PI)));
            this.setPitch((float)(MathHelper.atan2(p_36985_, d0) * (double)(180F / (float)Math.PI)));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }

    }

    public void signalTo(BlockPos p_36968_) {
        double d0 = p_36968_.getX();
        int i = p_36968_.getY();
        double d1 = p_36968_.getZ();
        double d2 = d0 - this.getX();
        double d3 = d1 - this.getZ();
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        if (d4 > 12.0D) {
            this.tx = this.getX() + d2 / d4 * 12.0D;
            this.tz = this.getZ() + d3 / d4 * 12.0D;
            this.ty = this.getY() + 8.0D;
        } else {
            this.tx = d0;
            this.ty = i;
            this.tz = d1;
        }

        this.life = 0;
    }

    public void tick() {
        if (this.getStack().isEmpty()) {
            this.discard();
        } else {
            super.tick();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            double d3 = vec3.horizontalLength();
            this.setPitch(lerpRotation(this.prevPitch, (float) (MathHelper.atan2(vec3.y, d3) * (double) (180F / (float) Math.PI))));
            this.setYaw(lerpRotation(this.prevYaw, (float) (MathHelper.atan2(vec3.x, vec3.z) * (double) (180F / (float) Math.PI))));
            if (!this.getWorld().isClient) {
                double d4 = this.tx - d0;
                double d5 = this.tz - d2;
                float f = (float) Math.sqrt(d4 * d4 + d5 * d5);
                float f1 = (float) MathHelper.atan2(d5, d4);
                double d6 = MathHelper.lerp(0.0025D, d3, f);
                double d7 = vec3.y;
                if (f < 1.0F) {
                    d6 *= 0.8D;
                    d7 *= 0.8D;
                }

                int j = this.getY() < this.ty ? 1 : -1;
                vec3 = new Vec3d(Math.cos(f1) * d6, d7 + ((double) j - d7) * (double) 0.015F, Math.sin(f1) * d6);
                this.setVelocity(vec3);
            }

            float f2 = 0.25F;
            if (this.isTouchingWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
            } else {
                this.getWorld().addParticle((new LightningParticleOptions(this.getR(), this.getG(),  this.getB())), d0 - vec3.x * 0.25D + this.random.nextDouble() * 0.6D - 0.3D, d1 - vec3.y * 0.25D - 0.5D, d2 - vec3.z * 0.25D + this.random.nextDouble() * 0.6D - 0.3D, vec3.x, vec3.y, vec3.z);
            }

            if (!this.getWorld().isClient) {
                this.setPosition(d0, d1, d2);
                ++this.life;
                if (this.life > 80 && !this.getWorld().isClient) {
                    this.playSound(SoundEvents.ENTITY_ENDER_EYE_DEATH, 1.0F, 1.0F);
                    this.discard();
                    ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), this.getStack());
                    itemEntity.setGlowing(true);
                    this.getWorld().spawnEntity(itemEntity);
                }
            } else {
                this.setPos(d0, d1, d2);
            }

        }
    }

    public static float lerpRotation(float p_37274_, float p_37275_) {
        while(p_37275_ - p_37274_ < -180.0F) {
            p_37274_ -= 360.0F;
        }

        while(p_37275_ - p_37274_ >= 180.0F) {
            p_37274_ += 360.0F;
        }

        return MathHelper.lerp(0.2F, p_37274_, p_37275_);
    }

    public void writeCustomDataToNbt(NbtCompound p_36975_) {
        ItemStack itemstack = this.getItemRaw();
        if (!itemstack.isEmpty()) {
            p_36975_.put("Item", this.getStack().encode(this.getRegistryManager()));
        }
        p_36975_.putInt("R", this.getR());
        p_36975_.putInt("G", this.getG());
        p_36975_.putInt("B", this.getB());
    }

    public void readCustomDataFromNbt(NbtCompound p_36970_) {
        if (p_36970_.contains("Item", 10)) {
            this.setItem(ItemStack.fromNbt(this.getRegistryManager(), p_36970_.getCompound("Item")).orElse(this.getDefaultItem()));
        } else {
            this.setItem(this.getDefaultItem());
        }
        this.setR(p_36970_.getInt("R"));
        this.setG(p_36970_.getInt("G"));
        this.setB(p_36970_.getInt("B"));
    }

    private ItemStack getDefaultItem() {
        return new ItemStack(ModItems.DESERT_EYE);
    }


    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    public boolean isAttackable() {
        return false;
    }


}
