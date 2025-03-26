package com.github.l_ender.cataclysm.client.render.blockentity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.l_ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.l_ender.cataclysm.client.model.block.Door_Of_Seal_Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

public class Door_Of_Seal_Renderer implements BlockEntityRenderer<Door_Of_Seal_BlockEntity> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/door_of_seal.png");
    private static final Door_Of_Seal_Model MODEL = new Door_Of_Seal_Model();

    public Door_Of_Seal_Renderer(BlockEntityRendererFactory.Context rendererDispatcherIn) {
    }

    public boolean shouldRenderOffScreen(Door_Of_Seal_BlockEntity p_112138_) {
        return true;
    }

    public int getRenderDistance() {
        return 256;
    }

    public boolean shouldRender(Door_Of_Seal_BlockEntity entity, Vec3d p_173532_) {
        return Vec3d.ofCenter(entity.getPos()).multiply(1.0D, 0.0D, 1.0D).isInRange(p_173532_.multiply(1.0D, 0.0D, 1.0D), (double)this.getRenderDistance());

    }


//    @Override
//    public net.minecraft.util.math.Box getRenderBoundingBox(Door_Of_Seal_BlockEntity blockEntity) {
//        net.minecraft.util.math.BlockPos pos = blockEntity.getPos();
//
//        return new net.minecraft.util.math.Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 3.0, pos.getY() + 8, pos.getZ() + 3.0);
//
//    }



    @Override
    public void render(Door_Of_Seal_BlockEntity entity, float delta, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, int overlay) {
        poseStack.push();
        Direction dir = entity.getCachedState().get(Door_of_Seal_Block.FACING);
        if(dir == Direction.NORTH){
            poseStack.translate(0.5, 1.501F, 0.5F);
        }else if(dir == Direction.EAST){
            poseStack.translate(0.5F, 1.501F, 0.5F);
        }else if(dir == Direction.SOUTH){
            poseStack.translate(0.5, 1.501F, 0.5F);
        }else if(dir == Direction.WEST){
            poseStack.translate(0.5F, 1.501F, 0.5F);
        }
        poseStack.multiply(dir.getOpposite().getRotationQuaternion());
        poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        MODEL.animate(entity, delta);
        MODEL.render(poseStack, buffer.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), packedLight, overlay);
        poseStack.pop();
    }
}
