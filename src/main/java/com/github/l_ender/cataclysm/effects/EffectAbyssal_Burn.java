package com.github.l_ender.cataclysm.effects;


import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EffectAbyssal_Burn extends StatusEffect {

    public EffectAbyssal_Burn() {
        super(StatusEffectCategory.HARMFUL, 0x6500ff);
    }

    public void applyUpdateEffect(LivingEntity livingEntity, int amplifier) {
        boolean flag =   livingEntity.damage(livingEntity.getDamageSources().create(CMDamageTypes.ABYSSAL_BURN), 1.0F);
        if(flag && livingEntity.getRandom().nextFloat() < (0.75f - livingEntity.getHealth() / livingEntity.getMaxHealth())) {
            if (!livingEntity.getWorld().isClient) {
                double d0 = livingEntity.getX();
                double d1 = livingEntity.getY();
                double d2 = livingEntity.getZ();

                for (int i = 0; i < 8; ++i) {
                    double d3 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5D) * 8.0D;
                    double d4 = MathHelper.clamp(livingEntity.getY() + (double) (livingEntity.getRandom().nextInt(8) - 4), livingEntity.getWorld().getBottomY(), livingEntity.getWorld().getBottomY() + ((ServerWorld) livingEntity.getWorld()).getLogicalHeight() - 1);
                    double d5 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5D) * 8.0D;
                    if (livingEntity.hasVehicle()) {
                        livingEntity.stopRiding();
                    }
                    Vec3d vec3 = livingEntity.getPos();
                    livingEntity.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3, GameEvent.Emitter.of(livingEntity));
                    //net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(livingEntity, d3, d4, d5);
                    if (randomTeleportInwater(livingEntity,d3, d4, d5, true)) {
                        SoundEvent soundevent = livingEntity instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        livingEntity.getWorld().playSound(null, d0, d1, d2, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        livingEntity.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }

            }
        }
    }

    private boolean randomTeleportInwater(LivingEntity livingEntity,double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = livingEntity.getX();
        double d1 = livingEntity.getY();
        double d2 = livingEntity.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.ofFloored(p_20985_, p_20986_, p_20987_);
        World level = livingEntity.getWorld();
        if (level.isChunkLoaded(blockpos)) {
            boolean flag1 = false;

            while(!flag1 && blockpos.getY() > level.getBottomY()) {
                BlockPos blockpos1 = blockpos.down();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMovement()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }

            if (flag1) {
                livingEntity.requestTeleport(p_20985_, d3, p_20987_);
                if (level.isSpaceEmpty(livingEntity)) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            livingEntity.requestTeleport(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.sendEntityStatus(livingEntity, (byte)46);
            }

            if (livingEntity instanceof PathAwareEntity) {
                ((PathAwareEntity)livingEntity).getNavigation().stop();
            }

            return true;
        }
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
