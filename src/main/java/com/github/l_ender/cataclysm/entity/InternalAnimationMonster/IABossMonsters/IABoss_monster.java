package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters;


import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.Utilities;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.Monster;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IABoss_monster extends Internal_Animation_Monster implements Monster {
    private int reducedDamageTicks;
    private int homeTicks;
    public static final int HOME_COOLDOWN = CMConfig.Return_Home * 20;
    private static TrackedData<BlockPos> HOME_POS = DataTracker.registerData(IABoss_monster.class, TrackedDataHandlerRegistry.BLOCK_POS);

    public IABoss_monster(EntityType<? extends IABoss_monster> entity, World world) {
        super(entity, world);
    }

    public void setHomePos(BlockPos homePos) {
        this.dataTracker.set(HOME_POS, homePos);
    }

    BlockPos getHomePos() {
        return this.dataTracker.get(HOME_POS);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HOME_POS, BlockPos.ORIGIN);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        BlockPos home = getHomePos();
        nbt.putInt("HomePosX", home.getX());
        nbt.putInt("HomePosY", home.getY());
        nbt.putInt("HomePosZ", home.getZ());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        int i = nbt.getInt("HomePosX");
        int j = nbt.getInt("HomePosY");
        int k = nbt.getInt("HomePosZ");
        this.setHomePos(new BlockPos(i, j, k));
        super.readCustomDataFromNbt(nbt);
    }

    @Override
    public @Nullable EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.homeTicks = HOME_COOLDOWN;
        this.setHomePos(this.getBlockPos());
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.damage(source, damage);
        } else {
            damage = Math.min(DamageCap(), damage);
        }
        if (ReducedDamage(source)) {
            if (reducedDamageTicks > 0) {
                float reductionFactor = 1.0f - ((float) reducedDamageTicks / DamageTime());
                damage *= reductionFactor;
            }
        }
        boolean flag = super.damage(source, damage);
        if (ReducedDamage(source)) {
            if (flag) {
                reducedDamageTicks = DamageTime();
            }
        }
        return flag;
    }

    public boolean ReducedDamage(DamageSource damageSource){
        return !damageSource.isIn(ModTag.BYPASSES_HURT_TIME) && DamageTime() > 0;
    }

    public float DamageCap() {
        return Float.MAX_VALUE;
    }

    public int DamageTime() {
        return 0;
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient()) {
            if (reducedDamageTicks > 0) reducedDamageTicks--;
            LivingEntity target = this.getTarget();
            if(CMConfig.Return_Home > 0) {
                if (homeTicks > 0) homeTicks--;
                if (!isAiDisabled() ) {
                    if (target != null) {
                        homeTicks = HOME_COOLDOWN;
                    }

                    if (homeTicks <= 0) {
                        if (!this.getHomePos().equals(BlockPos.ORIGIN)) {
                            if (!this.getHomePos().isWithinDistance(this.getPos(), 16.0F)) {
                                this.refreshPositionAndAngles((double) this.getHomePos().getX() + (double) 0.5F, (double) this.getHomePos().getY(), (double) this.getHomePos().getZ() + (double) 0.5F, this.getYaw(), this.getPitch());
                                homeTicks = HOME_COOLDOWN;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }


    public boolean canHaveStatusEffect(StatusEffectInstance p_34192_) {
        return Utilities.isEffectInTag(p_34192_.getEffectType(), ModTag.EFFECTIVE_FOR_BOSSES) && super.canHaveStatusEffect(p_34192_);
    }

    public boolean canImmediatelyDespawn(double p_21542_) {
        return false;
    }

    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }
}
