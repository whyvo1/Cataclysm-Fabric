package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.client.particle.Options.LightTrailParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;


public class Flare_Bomb_Entity extends ThrownEntity {


    public double prevDeltaMovementX, prevDeltaMovementY, prevDeltaMovementZ;

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, World world) {
        super(type, world);
    }

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, World world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {

    }



    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity shooter = this.getOwner();
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            if (!(result.getEntity() instanceof Flare_Bomb_Entity || shooter instanceof Netherite_Monstrosity_Entity && (result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity))) {
            Entity entity = result.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {

                DamageSource damagesource = this.getDamageSources().mobProjectile(this, livingentity);
                flag = entity.damage(damagesource, (float) CMConfig.FlareBombDamage);
                if (flag) {
                    if (entity.isAlive()) {
                        entity.setOnFireFor(5);
                        EnchantmentHelper.onTargetDamaged(serverlevel, entity, damagesource);
                    }
                }
            } else {

                entity.damage(this.getDamageSources().magic(), 7);
            }

        }
        }
    }


    protected void onCollision(HitResult p_37628_) {
        super.onCollision(p_37628_);
        if (!this.getWorld().isClient) {
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 1.5f, 0.75f);
            this.getWorld().sendEntityStatus(this, (byte)4);
            if(random.nextBoolean()){
                XStrikeRune(10,2);
            }else{
                PlusStrikeRune(10,2);
            }
            discard();
        }

    }




    protected void PlusStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; i++) {

            float yawRadians = (float) (Math.toRadians(90 + this.getYaw()));
            float throwAngle = yawRadians + i * MathHelper.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + (double) MathHelper.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) MathHelper.sin(throwAngle) * 1.25D * d2, this.getY() -2, this.getY() + 2, throwAngle, d3);
            }

        }

    }

    protected void XStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; i++) {

            float yawRadians = (float) (Math.toRadians(45 + this.getYaw()));
            float throwAngle = yawRadians + i * MathHelper.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + (double) MathHelper.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) MathHelper.sin(throwAngle) * 1.25D * d2, this.getY() - 2, this.getY() + 2, throwAngle, d3);
            }

        }

    }


    protected void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            if (this.getOwner() != null && this.getOwner() instanceof LivingEntity living) {
                this.getWorld().spawnEntity(new Flame_Jet_Entity(this.getWorld(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float) CMConfig.FlareBombDamage, living));
            }else{
                this.getWorld().spawnEntity(new Flame_Jet_Entity(this.getWorld(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float) CMConfig.FlareBombDamage, null));

            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        prevDeltaMovementX = getVelocity().x;
        prevDeltaMovementY = getVelocity().y;
        prevDeltaMovementZ = getVelocity().z;

        setYaw(-((float) MathHelper.atan2(getVelocity().x, getVelocity().z)) * (180F / (float)Math.PI)) ;

        if (this.getWorld().isClient){
            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
            float ran = 0.04f;
            float r = 195/255F + random.nextFloat() * ran * 1.5F;
            float g = 95/255F + random.nextFloat() * ran;
            float b = 3/255F + random.nextFloat() * ran;
            this.getWorld().addParticle((new LightTrailParticleOptions(r, g, b,0.1F,this.getHeight()/2,this.getId())),  dx, dy, dz, 0, 0, 0);

        }



     //   makeTrail();


    }

    public void makeTrail() {
        if (this.getWorld().isClient){
            for (int i = 0; i < 5; i++) {
                double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
                double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);

                getWorld().addParticle(ParticleTypes.FLAME, dx, dy, dz, -getVelocity().getX(), -getVelocity().getY(), -getVelocity().getZ());
            }
        }
    }

    public void handleStatus(byte id) {
        super.handleStatus(id);
        if (id == 4) {
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.EXPLOSION, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F, false);

            this.getWorld().addParticle(ModParticle.FLARE_EXPLODE, this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.05D, 0.005D, this.random.nextGaussian() * 0.05D);

        }

    }


    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    @Override
    protected double getGravity() {
        return 0.025D;
    }

}