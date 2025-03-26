package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import java.util.UUID;

public class Dimensional_Rift_Entity extends Entity {

    protected static final TrackedData<Integer> LIFESPAN = DataTracker.registerData(Dimensional_Rift_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    protected static final TrackedData<Integer> STAGE = DataTracker.registerData(Dimensional_Rift_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    private boolean madeParticle = false;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;
    public int ambientSoundTime;
    private final ObjectArrayList<BlockPos> toBlow = new ObjectArrayList<>();
    public Dimensional_Rift_Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Dimensional_Rift_Entity(World worldIn, double x, double y, double z, LivingEntity casterIn) {
        this(ModEntities.DIMENSIONAL_RIFT, worldIn);
        this.setOwner(casterIn);
        this.setLifespan(300);
        this.setPosition(x, y, z);
    }


    public void tick() {
        super.tick();
        if(!madeOpenNoise){
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.playSound(ModSounds.BLACK_HOLE_OPENING, 0.7F, 1 + random.nextFloat() * 0.2F);
            madeOpenNoise = true;
        }


        for (Entity entity : this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(30))) {
            if (entity != owner) {
                if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().invulnerable) continue;
                if (isTeammate(entity)) continue;
                if (entity instanceof The_Leviathan_Entity) continue;
                if (entity instanceof The_Leviathan_Tongue_Entity) continue;
                Vec3d diff = entity.getPos().subtract(this.getPos().add(0, 0, 0));
                if (entity instanceof LivingEntity) {
                    diff = diff.normalize().multiply( getStage() * 0.015);
                    entity.setVelocity(entity.getVelocity().subtract(diff));
                } else if(!entity.getType().isIn(ModTag.DIMENSIONAL_LIFT_IMMUNE)) {
                    diff = diff.normalize().multiply(getStage() * 0.045);
                    entity.setVelocity(entity.getVelocity().subtract(diff));
                }
            }
        }
            berserkBlockBreaking(15, 15, 15);

            for (LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.2D, 0.0D, 0.2D))) {
                this.damage(livingentity);
            }

            for (Entity entity : this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(0.5))) {
                if (entity instanceof Cm_Falling_Block_Entity) {
                    entity.remove(RemovalReason.DISCARDED);
                }
            }


            if (this.random.nextInt(3000) < this.ambientSoundTime++) {
                this.resetAmbientSoundTime();
                this.playSound(ModSounds.BLACK_HOLE_LOOP, 0.7F, 1 + random.nextFloat() * 0.2F);
            }



        this.setLifespan(this.getLifespan() - 1);
        if(this.getLifespan() <= 100){
            if(!madeCloseNoise){
                this.emitGameEvent(GameEvent.ENTITY_PLACE);
                this.playSound(ModSounds.BLACK_HOLE_CLOSING, 0.7F, 1 + random.nextFloat() * 0.2F);
                madeCloseNoise = true;
            }
            if(this.age % 40 == 0){
                this.setStage(this.getStage() - 1);
            }

            if (this.getStage() <= 0) {
                if(!madeParticle){
                    if (this.getWorld().isClient) {
                        this.getWorld().addParticle(ModParticle.SHOCK_WAVE, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                    }else{
                        this.getWorld().createExplosion(this.owner, this.getX(), this.getY(), this.getZ(), 4.0F, false, World.ExplosionSourceType.NONE);
                    }
                    madeParticle = true;
                }else{
                    this.discard();
                }
            }
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity && !(Hitentity instanceof The_Leviathan_Entity)) {
            if (this.age % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.damage(getDamageSources().magic(), (float) CMConfig.DimensionalRiftdamage);
                } else {
                    if (livingentity.isTeammate(Hitentity)) {
                        return;
                    }
                    Hitentity.damage(getDamageSources().indirectMagic(this, livingentity), (float) CMConfig.DimensionalRiftdamage);
                }
            }
        }
    }


    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());
        if (!this.getWorld().isClient) {
            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = -y; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);

                            BlockPos blockonpos = new BlockPos(i3, k+1, l);

                            BlockState block = getWorld().getBlockState(blockpos);
                            BlockState blockon = getWorld().getBlockState(blockonpos);
                            BlockEntity tileEntity = getWorld().getBlockEntity(blockpos);
                            if ((blockon == Blocks.AIR.getDefaultState() || blockon == Blocks.WATER.getDefaultState()) && block != Blocks.AIR.getDefaultState() && !block.isIn(ModTag.LEVIATHAN_IMMUNE)) {
                                if (tileEntity == null && random.nextInt(2000) == 0) {
                                    this.getWorld().removeBlock(blockpos, true);
                                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), i3 + 0.5D, k + 0.5D, l + 0.5D, block, 5);
                                    getWorld().setBlockState(blockpos, block.getFluidState().getBlockState(), 3);
                                    getWorld().spawnEntity(fallingBlockEntity);

                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public int getAmbientSoundInterval() {
        return 80;
    }

    private void resetAmbientSoundTime() {
        this.ambientSoundTime = -this.getAmbientSoundInterval();
    }

    public int getLifespan() {
        return this.dataTracker.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.dataTracker.set(LIFESPAN, i);
    }

    public int getStage() {
        return this.dataTracker.get(STAGE);
    }

    public void setStage(int i) {
        this.dataTracker.set(STAGE, i);
    }


    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.ownerUUID = p_19719_ == null ? null : p_19719_.getUuid();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(LIFESPAN, 300);
        p_326229_.add(STAGE, 0);
    }

    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        this.setStage(compound.getInt("Stage"));
        if (compound.containsUuid("Owner")) {
            this.ownerUUID = compound.getUuid("Owner");
        }

    }

    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Lifespan", getLifespan());
        compound.putInt("Stage", getStage());
        if (this.ownerUUID != null) {
            compound.putUuid("Owner", this.ownerUUID);
        }

    }


}
