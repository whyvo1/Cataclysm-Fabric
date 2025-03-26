package com.github.l_ender.cataclysm.mixin;


import com.github.l_ender.lionfishapi.server.event.StandOnFluidCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Entity.class)
public class EntityMixin{

    @ModifyVariable(method = "move",
            ordinal = 1,
            index = 3,
            name = "mo",
            at = @At(value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/entity/Entity;adjustMovementForCollisions(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;"))
    public Vec3d fluidCollision(Vec3d original) {
        if (!((Entity) (Object) this instanceof LivingEntity entity))
            return original;

        if (original.y > 0)
            return original;

        World level = entity.getEntityWorld();

        double[][] offsets = {
                {0.5, 0, 0.5}, {0.5, 0, 0}, {0.5, -1, 0}, {0.5, 0, -0.5},
                {0, 0, 0.5}, {0, 0, 0}, {0, -1, 0}, {0, 0, -0.5},
                {-0.5, 0, 0.5}, {-0.5, 0, 0}, {-0.5, -1, 0}, {-0.5, 0, -0.5}
        };

        double highestValue = original.y;
        FluidState highestFluid = null;

        for (double[] offset : offsets) {
            BlockPos sourcePos = entity.getBlockPos();
            BlockPos pos = BlockPos.ofFloored(sourcePos.getX() + offset[0], sourcePos.getY() + offset[1], sourcePos.getZ() + offset[2]);

            FluidState fluidState = level.getFluidState(pos);

            if (fluidState.isEmpty())
                continue;

            VoxelShape shape = VoxelShapes.fullCube().offset(pos.getX(), pos.getY() + fluidState.getHeight(), pos.getZ());

            if (VoxelShapes.matchesAnywhere(shape, VoxelShapes.cuboid(entity.getBoundingBox().expand(0.5)), BooleanBiFunction.AND)) {
                double height = shape.getMax(Direction.Axis.Y) - entity.getY() - 1;

                if (highestValue < height) {
                    highestValue = height;
                    highestFluid = fluidState;
                }
            }
        }

        if (highestFluid == null)
            return original;

        ActionResult result = StandOnFluidCallback.EVENT.invoker().interact(entity, highestFluid);

        if(result == ActionResult.FAIL) {
            entity.fallDistance = 0F;
            entity.setOnGround(true);
            return new Vec3d(original.x, highestValue, original.z);
        }

//        StandOnFluidEvent event = new StandOnFluidEvent(entity, highestFluid);
//
//        MinecraftForge.EVENT_BUS.post(event);
//
//        if (event.isCanceled()) {
//            entity.fallDistance = 0F;
//            entity.setOnGround(true);
//
//            return new Vec3d(original.x, highestValue, original.z);
//        }

        return original;
    }
}

