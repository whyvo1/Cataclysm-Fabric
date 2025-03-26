package com.github.l_ender.cataclysm.blocks;


import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.blockentities.AltarOfFire_Block_Entity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Altar_Of_Fire_Block extends BlockWithEntity {

    public Altar_Of_Fire_Block() {
        super(Settings.create()
                .nonOpaque()
                .luminance((block) -> 7)
                .emissiveLighting((block, world, pos) -> true)
                .strength(-1.0F, 3600000.0F)
                .dropsNothing()
                .sounds(BlockSoundGroup.METAL));

    }


    public void randomDisplayTick(BlockState p_220918_, World p_220919_, BlockPos p_220920_, Random p_220921_) {
        if ( p_220921_.nextInt(5) == 0) {
            for(int i = 0; i < p_220921_.nextInt(1) + 1; ++i) {
                p_220919_.addParticle(ParticleTypes.LAVA, (double)p_220920_.getX() + 0.5D, (double)p_220920_.getY() + 1.5D, (double)p_220920_.getZ() + 0.5D, p_220921_.nextFloat() / 2.0F, 5.0E-5D, p_220921_.nextFloat() / 2.0F);
            }
        }
    }

    public void onEntityCollision(BlockState p_51269_, World p_51270_, BlockPos p_51271_, Entity p_51272_) {
        if ( p_51272_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_51272_)) {
            p_51272_.damage(p_51270_.getDamageSources().inFire(), 3);
        }

        super.onEntityCollision(p_51269_, p_51270_, p_51271_, p_51272_);
    }

    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(handIn);
        if (worldIn.getBlockEntity(pos) instanceof AltarOfFire_Block_Entity aof && (!player.isSneaking() && heldItem.getItem() != this.asItem())) {
            ItemStack copy = heldItem.copy();
            copy.setCount(1);
            if(aof.getStack(0).isEmpty()){
                aof.setStack(0, copy);
                if(!player.isCreative()){
                    heldItem.decrement(1);
                }
            }else{
                dropStack(worldIn, pos, aof.getStack(0).copy());
                aof.setStack(0, ItemStack.EMPTY);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfFire_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.ALTAR_OF_FIRE, AltarOfFire_Block_Entity::commonTick);
    }

}