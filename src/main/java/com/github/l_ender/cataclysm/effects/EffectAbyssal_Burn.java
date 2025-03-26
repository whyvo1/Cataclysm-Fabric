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

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        boolean flag =   LivingEntityIn.damage(LivingEntityIn.getDamageSources().create(CMDamageTypes.ABYSSAL_BURN), 1.0F);
        if(flag && LivingEntityIn.getRandom().nextFloat() < (0.75f - LivingEntityIn.getHealth() / LivingEntityIn.getMaxHealth())) {
            if (!LivingEntityIn.getWorld().isClient) {
                double d0 = LivingEntityIn.getX();
                double d1 = LivingEntityIn.getY();
                double d2 = LivingEntityIn.getZ();

                for (int i = 0; i < 8; ++i) {
                    double d3 = LivingEntityIn.getX() + (LivingEntityIn.getRandom().nextDouble() - 0.5D) * 8.0D;
                    double d4 = MathHelper.clamp(LivingEntityIn.getY() + (double) (LivingEntityIn.getRandom().nextInt(8) - 4), LivingEntityIn.getWorld().getBottomY(), LivingEntityIn.getWorld().getBottomY() + ((ServerWorld) LivingEntityIn.getWorld()).getLogicalHeight() - 1);
                    double d5 = LivingEntityIn.getZ() + (LivingEntityIn.getRandom().nextDouble() - 0.5D) * 8.0D;
                    if (LivingEntityIn.hasVehicle()) {
                        LivingEntityIn.stopRiding();
                    }
                    Vec3d vec3 = LivingEntityIn.getPos();
                    LivingEntityIn.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3, GameEvent.Emitter.of(LivingEntityIn));

//                    EntityTeleportEvent.ChorusFruit event =  new EntityTeleportEvent.ChorusFruit(LivingEntityIn, d3, d4, d5);
                    if (randomTeleportInwater(LivingEntityIn, d3, d4, d5, true)) {
                        SoundEvent soundevent = LivingEntityIn instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        LivingEntityIn.getWorld().playSound(null, d0, d1, d2, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        LivingEntityIn.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }

            }
        }
        return  true;
    }

    private boolean randomTeleportInwater(LivingEntity LivingEntityIn,double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = LivingEntityIn.getX();
        double d1 = LivingEntityIn.getY();
        double d2 = LivingEntityIn.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.ofFloored(p_20985_, p_20986_, p_20987_);
        World level = LivingEntityIn.getWorld();
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
                LivingEntityIn.requestTeleport(p_20985_, d3, p_20987_);
                if (level.isSpaceEmpty(LivingEntityIn)) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            LivingEntityIn.requestTeleport(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.sendEntityStatus(LivingEntityIn, (byte)46);
            }

            if (LivingEntityIn instanceof PathAwareEntity) {
                ((PathAwareEntity)LivingEntityIn).getNavigation().stop();
            }

            return true;
        }
    }


    @Override
    public boolean canApplyUpdateEffect(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i <= 0 || p_295629_ % i == 0;
    }

}
