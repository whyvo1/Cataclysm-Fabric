package com.github.l_ender.cataclysm.client.render.etc;

import com.github.l_ender.cataclysm.config.CMConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;

public class LavaVisionFluidRenderer extends FluidRenderer {

    private static final Identifier WATER_STILL = Identifier.ofVanilla("block/water_still");
    private static final Identifier WATER_FLOW = Identifier.ofVanilla("block/water_flow");
    private static final Identifier WATER_OVERLAY = Identifier.ofVanilla("block/water_overlay");
    private static final Identifier LAVA_STILL = Identifier.ofVanilla("block/lava_still");
    private static final Identifier LAVA_FLOW = Identifier.ofVanilla("block/lava_flow");

    /* Copied from the vanilla superclass */
    private static boolean isFaceOccludedByNeighbor(BlockView p_239283_0_, BlockPos p_239283_1_, Direction p_239283_2_, float p_239283_3_) {
        BlockPos blockpos = p_239283_1_.offset(p_239283_2_);
        BlockState blockstate = p_239283_0_.getBlockState(blockpos);
        return isSideCovered(p_239283_0_, p_239283_2_, p_239283_3_, blockpos, blockstate);
    }

    private static boolean isSideCovered(BlockView p_239284_0_, Direction p_239284_1_, float p_239284_2_, BlockPos p_239284_3_, BlockState p_239284_4_) {
        if (p_239284_4_.isOpaque()) {
            VoxelShape voxelshape = VoxelShapes.cuboid(0.0D, 0.0D, 0.0D, 1.0D, p_239284_2_, 1.0D);
            VoxelShape voxelshape1 = p_239284_4_.getCullingShape(p_239284_0_, p_239284_3_);
            return VoxelShapes.isSideCovered(voxelshape, voxelshape1, p_239284_1_);
        } else {
            return false;
        }
    }

    private static boolean isAdjacentFluidSameAs(BlockView worldIn, BlockPos pos, Direction side, FluidState state) {
        BlockPos blockpos = pos.offset(side);
        FluidState fluidstate = worldIn.getFluidState(blockpos);
        return fluidstate.getFluid().matchesType(state.getFluid());
    }

    @Override
    public void render(BlockRenderView lightReaderIn, BlockPos posIn, VertexConsumer vertexBuilderIn, BlockState blockstateIn, FluidState fluidStateIn) {
        try {
            if (fluidStateIn.isIn(FluidTags.LAVA)) {
                boolean flag = fluidStateIn.isIn(FluidTags.LAVA);
                Sprite[] atextureatlassprite = getFluidAtlas(lightReaderIn, posIn, fluidStateIn);
                int i = getFluidColor(fluidStateIn, lightReaderIn, posIn);
                float alpha = (float) CMConfig.LavaVisionOpacity;
                float f = (float)(i >> 16 & 255) / 255.0F;
                float f1 = (float)(i >> 8 & 255) / 255.0F;
                float f2 = (float)(i & 255) / 255.0F;
                BlockState blockstate = lightReaderIn.getBlockState(posIn.offset(Direction.DOWN));
                FluidState fluidstate = blockstate.getFluidState();
                BlockState blockstate1 = lightReaderIn.getBlockState(posIn.offset(Direction.UP));
                FluidState fluidstate1 = blockstate1.getFluidState();
                BlockState blockstate2 = lightReaderIn.getBlockState(posIn.offset(Direction.NORTH));
                FluidState fluidstate2 = blockstate2.getFluidState();
                BlockState blockstate3 = lightReaderIn.getBlockState(posIn.offset(Direction.SOUTH));
                FluidState fluidstate3 = blockstate3.getFluidState();
                BlockState blockstate4 = lightReaderIn.getBlockState(posIn.offset(Direction.WEST));
                FluidState fluidstate4 = blockstate4.getFluidState();
                BlockState blockstate5 = lightReaderIn.getBlockState(posIn.offset(Direction.EAST));
                FluidState fluidstate5 = blockstate5.getFluidState();
                boolean flag1 = !isNeighborSameFluidVanilla(fluidStateIn, fluidstate1);
                boolean flag2 = shouldRenderSide(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.DOWN, fluidstate) && !isFaceOccludedByNeighborVanilla(lightReaderIn, posIn, Direction.DOWN, 0.8888889F, blockstate);
                boolean flag3 = shouldRenderSide(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.NORTH, fluidstate2);
                boolean flag4 = shouldRenderSide(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.SOUTH, fluidstate3);
                boolean flag5 = shouldRenderSide(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.WEST, fluidstate4);
                boolean flag6 = shouldRenderSide(lightReaderIn, posIn, fluidStateIn, blockstateIn, Direction.EAST, fluidstate5);
                if (!flag1 && !flag2 && !flag6 && !flag5 && !flag3 && !flag4) {
                    return;
                } else {
                    boolean flag7 = false;
                    float f3 = lightReaderIn.getBrightness(Direction.DOWN, true);
                    float f4 = lightReaderIn.getBrightness(Direction.UP, true);
                    float f5 = lightReaderIn.getBrightness(Direction.NORTH, true);
                    float f6 = lightReaderIn.getBrightness(Direction.WEST, true);
                    Fluid fluid = fluidStateIn.getFluid();
                    float f11 = this.getFluidHeight(lightReaderIn, posIn, fluid);
                    float f7;
                    float f8;
                    float f9;
                    float f10;
                    if (f11 >= 1.0F) {
                        f7 = 1.0F;
                        f8 = 1.0F;
                        f9 = 1.0F;
                        f10 = 1.0F;
                    } else {
                        float f12 = this.getFluidHeight(lightReaderIn, fluid, posIn.north(), blockstate2, fluidstate2);
                        float f13 = this.getFluidHeight(lightReaderIn, fluid, posIn.south(), blockstate3, fluidstate3);
                        float f14 = this.getFluidHeight(lightReaderIn, fluid, posIn.east(), blockstate5, fluidstate5);
                        float f15 = this.getFluidHeight(lightReaderIn, fluid, posIn.west(), blockstate4, fluidstate4);
                        f7 = this.calculateFluidHeight(lightReaderIn, fluid, f11, f12, f14, posIn.offset(Direction.NORTH).offset(Direction.EAST));
                        f8 = this.calculateFluidHeight(lightReaderIn, fluid, f11, f12, f15, posIn.offset(Direction.NORTH).offset(Direction.WEST));
                        f9 = this.calculateFluidHeight(lightReaderIn, fluid, f11, f13, f14, posIn.offset(Direction.SOUTH).offset(Direction.EAST));
                        f10 = this.calculateFluidHeight(lightReaderIn, fluid, f11, f13, f15, posIn.offset(Direction.SOUTH).offset(Direction.WEST));
                    }

                    float d1 = (posIn.getX() & 15);
                    float d2 = (posIn.getY() & 15);
                    float d0 = (posIn.getZ() & 15);
                    float f16 = 0.001F;
                    float f17 = flag2 ? 0.001F : 0.0F;
                    if (flag1 && !isFaceOccludedByNeighborVanilla(lightReaderIn, posIn, Direction.UP, Math.min(Math.min(f8, f10), Math.min(f9, f7)), blockstate1)) {
                        flag7 = true;
                        f8 -= 0.001F;
                        f10 -= 0.001F;
                        f9 -= 0.001F;
                        f7 -= 0.001F;
                        Vec3d vec3 = fluidStateIn.getVelocity(lightReaderIn, posIn);
                        float f18;
                        float f19;
                        float f20;
                        float f21;
                        float f22;
                        float f23;
                        float f24;
                        float f25;
                        if (vec3.x == 0.0D && vec3.z == 0.0D) {
                            Sprite textureatlassprite1 = atextureatlassprite[0];
                            f18 = textureatlassprite1.getFrameU(0.0F);
                            f22 = textureatlassprite1.getFrameV(0.0F);
                            f19 = f18;
                            f23 = textureatlassprite1.getFrameV(16.0F);
                            f20 = textureatlassprite1.getFrameU(16.0F);
                            f24 = f23;
                            f21 = f20;
                            f25 = f22;
                        } else {
                            Sprite textureatlassprite = atextureatlassprite[1];
                            float f26 = (float)MathHelper.atan2(vec3.z, vec3.x) - ((float)Math.PI / 2F);
                            float f27 = MathHelper.sin(f26) * 0.25F;
                            float f28 = MathHelper.cos(f26) * 0.25F;
                            float f29 = 8.0F;
                            f18 = textureatlassprite.getFrameU((8.0F + (-f28 - f27) * 16.0F));
                            f22 = textureatlassprite.getFrameV((8.0F + (-f28 + f27) * 16.0F));
                            f19 = textureatlassprite.getFrameU((8.0F + (-f28 + f27) * 16.0F));
                            f23 = textureatlassprite.getFrameV((8.0F + (f28 + f27) * 16.0F));
                            f20 = textureatlassprite.getFrameU((8.0F + (f28 + f27) * 16.0F));
                            f24 = textureatlassprite.getFrameV((8.0F + (f28 - f27) * 16.0F));
                            f21 = textureatlassprite.getFrameU((8.0F + (f28 - f27) * 16.0F));
                            f25 = textureatlassprite.getFrameV((8.0F + (-f28 - f27) * 16.0F));
                        }

                        float f49 = (f18 + f19 + f20 + f21) / 4.0F;
                        float f50 = (f22 + f23 + f24 + f25) / 4.0F;
                        float f51 = (float)atextureatlassprite[0].getContents().getWidth() / (atextureatlassprite[0].getMaxU() - atextureatlassprite[0].getMinU());
                        float f52 = (float)atextureatlassprite[0].getContents().getHeight() / (atextureatlassprite[0].getMaxV() - atextureatlassprite[0].getMinV());
                        float f53 = 4.0F / Math.max(f52, f51);
                        f18 = MathHelper.lerp(f53, f18, f49);
                        f19 = MathHelper.lerp(f53, f19, f49);
                        f20 = MathHelper.lerp(f53, f20, f49);
                        f21 = MathHelper.lerp(f53, f21, f49);
                        f22 = MathHelper.lerp(f53, f22, f50);
                        f23 = MathHelper.lerp(f53, f23, f50);
                        f24 = MathHelper.lerp(f53, f24, f50);
                        f25 = MathHelper.lerp(f53, f25, f50);
                        int j = this.getCombinedAverageLight(lightReaderIn, posIn);
                        float f30 = f4 * f;
                        float f31 = f4 * f1;
                        float f32 = f4 * f2;

                        this.vertexVanilla(vertexBuilderIn, d1 + 0.0f, d2 + f8, d0 + 0.0f, f30, f31, f32, alpha, f18, f22, j);
                        this.vertexVanilla(vertexBuilderIn, d1 + 0.0f, d2 + f10, d0 + 1.0f, f30, f31, f32, alpha, f19, f23, j);
                        this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f9, d0 + 1.0f, f30, f31, f32, alpha, f20, f24, j);
                        this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f7, d0 + 0.0f, f30, f31, f32, alpha, f21, f25, j);
                        if (fluidStateIn.canFlowTo(lightReaderIn, posIn.up())) {
                            this.vertexVanilla(vertexBuilderIn, d1 + 0.0f, d2 + f8, d0 + 0.0f, f30, f31, f32, alpha, f18, f22, j);
                            this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f7, d0 + 0.0f, f30, f31, f32, alpha, f21, f25, j);
                            this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f9, d0 + 1.0f, f30, f31, f32, alpha, f20, f24, j);
                            this.vertexVanilla(vertexBuilderIn, d1 + 0.0f, d2 +f10, d0 + 1.0f, f30, f31, f32, alpha, f19, f23, j);
                        }
                    }

                    if (flag2) {
                        float f40 = atextureatlassprite[0].getMinU();
                        float f41 = atextureatlassprite[0].getMaxU();
                        float f42 = atextureatlassprite[0].getMinV();
                        float f43 = atextureatlassprite[0].getMaxV();
                        int l = this.getCombinedAverageLight(lightReaderIn, posIn.down());
                        float f46 = f3 * f;
                        float f47 = f3 * f1;
                        float f48 = f3 * f2;

                        this.vertexVanilla(vertexBuilderIn, d1, d2 + f17, d0 + 1.0f, f46, f47, f48, alpha, f40, f43, l);
                        this.vertexVanilla(vertexBuilderIn, d1, d2 + f17, d0, f46, f47, f48, alpha, f40, f42, l);
                        this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f17, d0, f46, f47, f48, alpha, f41, f42, l);
                        this.vertexVanilla(vertexBuilderIn, d1 + 1.0f, d2 + f17, d0 + 1.0f, f46, f47, f48, alpha, f41, f43, l);
                        flag7 = true;
                    }

                    int k = this.getCombinedAverageLight(lightReaderIn, posIn);

                    for(Direction direction : Direction.Type.HORIZONTAL) {
                        float f44;
                        float f45;
                        float d3;
                        float d4;
                        float d5;
                        float d6;
                        boolean flag8;
                        switch(direction) {
                            case NORTH:
                                f44 = f8;
                                f45 = f7;
                                d3 = d1;
                                d5 = d1 + 1.0f;
                                d4 = d0 + 0.001F;
                                d6 = d0 + 0.001F;
                                flag8 = flag3;
                                break;
                            case SOUTH:
                                f44 = f9;
                                f45 = f10;
                                d3 = d1 + 1.0f;
                                d5 = d1;
                                d4 = d0 + 1.0f - 0.001F;
                                d6 = d0 + 1.0f - 0.001F;
                                flag8 = flag4;
                                break;
                            case WEST:
                                f44 = f10;
                                f45 = f8;
                                d3 = d1 + 0.001F;
                                d5 = d1 + 0.001F;
                                d4 = d0 + 1.0f;
                                d6 = d0;
                                flag8 = flag5;
                                break;
                            default:
                                f44 = f7;
                                f45 = f9;
                                d3 = d1 + 1.0f - 0.001F;
                                d5 = d1 + 1.0f - 0.001F;
                                d4 = d0;
                                d6 = d0 + 1.0f;
                                flag8 = flag6;
                        }

                        if (flag8 && !isFaceOccludedByNeighborVanilla(lightReaderIn, posIn, direction, Math.max(f44, f45), lightReaderIn.getBlockState(posIn.offset(direction)))) {
                            flag7 = true;
                            BlockPos blockpos = posIn.offset(direction);
                            Sprite textureatlassprite2 = atextureatlassprite[1];
                            if (atextureatlassprite[2] != null) {
                                if (shouldDisplayFluidOverlay(lightReaderIn.getBlockState(blockpos))) {
                                    textureatlassprite2 = atextureatlassprite[2];
                                }
                            }

                            float f54 = textureatlassprite2.getFrameU(0.0F);
                            float f55 = textureatlassprite2.getFrameU(8.0F);
                            float f33 = textureatlassprite2.getFrameV(((1.0F - f44) * 16.0F * 0.5F));
                            float f34 = textureatlassprite2.getFrameV(((1.0F - f45) * 16.0F * 0.5F));
                            float f35 = textureatlassprite2.getFrameV(8.0F);
                            float f36 = direction.getAxis() == Direction.Axis.Z ? f5 : f6;
                            float f37 = f4 * f36 * f;
                            float f38 = f4 * f36 * f1;
                            float f39 = f4 * f36 * f2;

                            this.vertexVanilla(vertexBuilderIn, d3, d2 + f44, d4, f37, f38, f39, alpha, f54, f33, k);
                            this.vertexVanilla(vertexBuilderIn, d5, d2 + f45, d6, f37, f38, f39, alpha, f55, f34, k);
                            this.vertexVanilla(vertexBuilderIn, d5, d2 + f17, d6, f37, f38, f39, alpha, f55, f35, k);
                            this.vertexVanilla(vertexBuilderIn, d3, d2 + f17, d4, f37, f38, f39, alpha, f54, f35, k);
                            if (false) {
                                this.vertexVanilla(vertexBuilderIn, d3, d2 + f17, d4, f37, f38, f39, alpha, f54, f35, k);
                                this.vertexVanilla(vertexBuilderIn, d5, d2 + f17, d6, f37, f38, f39, alpha, f55, f35, k);
                                this.vertexVanilla(vertexBuilderIn, d5, d2 + f45, d6, f37, f38, f39, alpha, f55, f34, k);
                                this.vertexVanilla(vertexBuilderIn, d3, d2 + f44, d4, f37, f38, f39, alpha, f54, f33, k);
                            }
                        }
                    }

                    return;
                }
            } else {
                super.render(lightReaderIn, posIn, vertexBuilderIn, blockstateIn, fluidStateIn);
            }
        } catch (Exception e) {
        }
    }

    private static boolean shouldDisplayFluidOverlay(BlockState state) {
        return state.getBlock() instanceof TransparentBlock || state.getBlock() instanceof LeavesBlock;
    }

    private static Sprite[] getFluidAtlas(BlockRenderView lightReader, BlockPos pos, FluidState fluidState) {
        Sprite[] sprites = new Sprite[]{null, null, null};
        MinecraftClient client = MinecraftClient.getInstance();
        if(fluidState.isOf(Fluids.WATER)) {
            sprites[0] = client.getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(WATER_STILL);
            sprites[1] = client.getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(WATER_FLOW);
            sprites[2] = client.getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(WATER_OVERLAY);
        } else if (fluidState.isOf(Fluids.LAVA)) {
            sprites[0] = client.getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(LAVA_STILL);
            sprites[1] = client.getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(LAVA_FLOW);
        }
        return sprites;
    }

    private static int getFluidColor(FluidState fluidState, BlockRenderView lightReader, BlockPos pos) {
        if(fluidState.isOf(Fluids.WATER)) {
            return BiomeColors.getWaterColor(lightReader, pos);
        }
        return -1;
    }

    private void vertexVanilla(VertexConsumer vertexBuilderIn, float x, float y, float z, float red, float green, float blue, float alpha, float u, float v, int packedLight) {
        vertexBuilderIn.vertex(x, y, z).color(red, green, blue, alpha).texture(u, v).light(packedLight).normal(0.0F, 1.0F, 0.0F);
    }

    private int getCombinedAverageLight(BlockRenderView lightReaderIn, BlockPos posIn) {
        int i = WorldRenderer.getLightmapCoordinates(lightReaderIn, posIn);
        int j = WorldRenderer.getLightmapCoordinates(lightReaderIn, posIn.up());
        int k = i & 255;
        int l = j & 255;
        int i1 = i >> 16 & 255;
        int j1 = j >> 16 & 255;
        return (k > l ? k : l) | (i1 > j1 ? i1 : j1) << 16;
    }

    private float getFluidHeight(BlockView reader, BlockPos pos, Fluid fluidIn) {
        int i = 0;
        float f = 0.0F;

        for (int j = 0; j < 4; ++j) {
            BlockPos blockpos = pos.add(-(j & 1), 0, -(j >> 1 & 1));
            if (reader.getFluidState(blockpos.up()).getFluid().matchesType(fluidIn)) {
                return 1.0F;
            }

            FluidState fluidstate = reader.getFluidState(blockpos);
            if (fluidstate.getFluid().matchesType(fluidIn)) {
                float f1 = fluidstate.getHeight(reader, blockpos);
                if (f1 >= 0.8F) {
                    f += f1 * 10.0F;
                    i += 10;
                } else {
                    f += f1;
                    ++i;
                }
            } else if (!reader.getBlockState(blockpos).isSolid()) {
                ++i;
            }
        }

        return f / (float) i;
    }

    private static boolean isNeighborSameFluidVanilla(FluidState p_203186_, FluidState p_203187_) {
        return p_203187_.getFluid().matchesType(p_203186_.getFluid());
    }

    private static boolean isFaceOccludedByStateVanilla(BlockView p_110979_, Direction p_110980_, float p_110981_, BlockPos p_110982_, BlockState p_110983_) {
        if (p_110983_.isOpaque()) {
            VoxelShape voxelshape = VoxelShapes.cuboid(0.0D, 0.0D, 0.0D, 1.0D, p_110981_, 1.0D);
            VoxelShape voxelshape1 = p_110983_.getCullingShape(p_110979_, p_110982_);
            return VoxelShapes.isSideCovered(voxelshape, voxelshape1, p_110980_);
        } else {
            return false;
        }
    }

    private static boolean isFaceOccludedByNeighborVanilla(BlockView p_203180_, BlockPos p_203181_, Direction p_203182_, float p_203183_, BlockState p_203184_) {
        return isFaceOccludedByStateVanilla(p_203180_, p_203182_, p_203183_, p_203181_.offset(p_203182_), p_203184_);
    }

    private static boolean isFaceOccludedBySelfVanilla(BlockView p_110960_, BlockPos p_110961_, BlockState p_110962_, Direction p_110963_) {
        return isFaceOccludedByStateVanilla(p_110960_, p_110963_.getOpposite(), 1.0F, p_110961_, p_110962_);
    }

    private float calculateFluidHeight(BlockRenderView p_203150_, Fluid p_203151_, float p_203152_, float p_203153_, float p_203154_, BlockPos p_203155_) {
        if (!(p_203154_ >= 1.0F) && !(p_203153_ >= 1.0F)) {
            float[] afloat = new float[2];
            if (p_203154_ > 0.0F || p_203153_ > 0.0F) {
                float f = this.getFluidHeight(p_203150_, p_203151_, p_203155_);
                if (f >= 1.0F) {
                    return 1.0F;
                }

                this.addHeight(afloat, f);
            }

            this.addHeight(afloat, p_203152_);
            this.addHeight(afloat, p_203154_);
            this.addHeight(afloat, p_203153_);
            return afloat[0] / afloat[1];
        } else {
            return 1.0F;
        }
    }

    private void addHeight(float[] p_203189_, float p_203190_) {
        if (p_203190_ >= 0.8F) {
            p_203189_[0] += p_203190_ * 10.0F;
            p_203189_[1] += 10.0F;
        } else if (p_203190_ >= 0.0F) {
            p_203189_[0] += p_203190_;
            p_203189_[1] += 1.0F;
        }

    }

    private float getFluidHeight(BlockRenderView p_203157_, Fluid p_203158_, BlockPos p_203159_) {
        BlockState blockstate = p_203157_.getBlockState(p_203159_);
        return this.getFluidHeight(p_203157_, p_203158_, p_203159_, blockstate, blockstate.getFluidState());
    }

    private float getFluidHeight(BlockRenderView p_203161_, Fluid p_203162_, BlockPos p_203163_, BlockState p_203164_, FluidState p_203165_) {
        if (p_203162_.matchesType(p_203165_.getFluid())) {
            BlockState blockstate = p_203161_.getBlockState(p_203163_.up());
            return p_203162_.matchesType(blockstate.getFluidState().getFluid()) ? 1.0F : p_203165_.getHeight();
        } else {
            return !p_203164_.isSolid() ? 0.0F : -1.0F;
        }
    }
}

