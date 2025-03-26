package com.github.l_ender.cataclysm.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class EndIceSpikeFeature extends Feature<DefaultFeatureConfig> {
       public EndIceSpikeFeature(Codec<DefaultFeatureConfig> p_66003_) {
           super(p_66003_);
       }

       public boolean generate(FeatureContext<DefaultFeatureConfig> p_159882_) {
           BlockPos blockpos = p_159882_.getOrigin();
           Random randomsource = p_159882_.getRandom();

           StructureWorldAccess worldgenlevel;
           for(worldgenlevel = p_159882_.getWorld(); worldgenlevel.isAir(blockpos) && blockpos.getY() > worldgenlevel.getBottomY() + 2; blockpos = blockpos.down()) {
           }


           blockpos = blockpos.up(randomsource.nextInt(4));
           int i = randomsource.nextInt(4) + 7;
           int j = i / 4 + randomsource.nextInt(2);
           if (j > 1 && randomsource.nextInt(60) == 0) {
               blockpos = blockpos.up(10 + randomsource.nextInt(30));
           }

           for(int k = 0; k < i; ++k) {
               float f = (1.0F - (float)k / (float)i) * (float)j;
               int l = MathHelper.ceil(f);

               for(int i1 = -l; i1 <= l; ++i1) {
                   float f1 = (float)MathHelper.abs(i1) - 0.25F;

                   for(int j1 = -l; j1 <= l; ++j1) {
                       float f2 = (float)MathHelper.abs(j1) - 0.25F;
                       if ((i1 == 0 && j1 == 0 || !(f1 * f1 + f2 * f2 > f * f)) && (i1 != -l && i1 != l && j1 != -l && j1 != l || !(randomsource.nextFloat() > 0.75F))) {
                           BlockState blockstate = worldgenlevel.getBlockState(blockpos.add(i1, k, j1));
                           if (blockstate.isAir() || isSoil(blockstate) || blockstate.isOf(Blocks.SNOW_BLOCK) || blockstate.isOf(Blocks.ICE)) {
                               this.setBlockState(worldgenlevel, blockpos.add(i1, k, j1), Blocks.PACKED_ICE.getDefaultState());
                           }

                           if (k != 0 && l > 1) {
                               blockstate = worldgenlevel.getBlockState(blockpos.add(i1, -k, j1));
                               if (blockstate.isAir() || isSoil(blockstate) || blockstate.isOf(Blocks.SNOW_BLOCK) || blockstate.isOf(Blocks.ICE)) {
                                   this.setBlockState(worldgenlevel, blockpos.add(i1, -k, j1), Blocks.PACKED_ICE.getDefaultState());
                               }
                           }
                       }
                   }
               }
           }

           int k1 = j - 1;
           if (k1 < 0) {
               k1 = 0;
           } else if (k1 > 1) {
               k1 = 1;
           }

           for(int l1 = -k1; l1 <= k1; ++l1) {
               for(int i2 = -k1; i2 <= k1; ++i2) {
                   BlockPos blockpos1 = blockpos.add(l1, -1, i2);
                   int j2 = 50;
                   if (Math.abs(l1) == 1 && Math.abs(i2) == 1) {
                       j2 = randomsource.nextInt(5);
                   }

                   while(blockpos1.getY() > 50) {
                       BlockState blockstate1 = worldgenlevel.getBlockState(blockpos1);
                       if (!blockstate1.isAir() && !isSoil(blockstate1) && !blockstate1.isOf(Blocks.SNOW_BLOCK) && !blockstate1.isOf(Blocks.ICE) && !blockstate1.isOf(Blocks.PACKED_ICE)) {
                           break;
                       }

                       this.setBlockState(worldgenlevel, blockpos1, Blocks.PACKED_ICE.getDefaultState());
                       blockpos1 = blockpos1.down();
                       --j2;
                       if (j2 <= 0) {
                           blockpos1 = blockpos1.down(randomsource.nextInt(5) + 1);
                           j2 = randomsource.nextInt(5);
                       }
                   }
               }
           }

           return true;
       }

   }