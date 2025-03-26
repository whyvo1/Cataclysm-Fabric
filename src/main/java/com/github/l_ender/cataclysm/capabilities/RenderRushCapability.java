package com.github.l_ender.cataclysm.capabilities;

import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;


public class RenderRushCapability extends Capability<LivingEntity> {
//    public static Identifier ID = Cataclysm.modIdentifier("render_rush_cap");

    private boolean rush;
    public int Timer;
    public float damage;
    public LivingEntity owner;

    public RenderRushCapability(CapabilityType<RenderRushCapability, LivingEntity> type, LivingEntity owner) {
        super(type);
        this.owner = owner;
    }

    @Override
    public void tick() {
        if(isRush()) {
            int standingOnY = MathHelper.floor(owner.getY()) - 3;
            double headY = owner.getY() + 2.0D;
            float yawRadians = (float) (Math.toRadians(90 + owner.getYaw()));
            int temp = getTimer();

            setTimer(temp - 1);
            //Deal with rocket punch is valid
            if (temp > 0) {
                double yaw = Math.toRadians(owner.getYaw() + 90);
                double xExpand = 3 * Math.cos(yaw);
                double zExpand = 3 * Math.sin(yaw);
                Box attackRange = owner.getBoundingBox().stretch(xExpand, 0, zExpand);
                for (LivingEntity target : owner.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
                    if (!target.isTeammate(owner) && target != owner) {
                        target.damage(owner.getDamageSources().mobAttack(owner), getdamage());

                    }
                }


                if(temp % 2 ==0){
                    this.spawnFangs(owner.getX(), headY, owner.getZ(), standingOnY, yawRadians, 1, owner.getWorld(), owner);
                    double x = owner.getX();
                    double y = owner.getY() + owner.getHeight() / 2;
                    double z = owner.getZ();
                    float yaw2 = (float) Math.toRadians(-owner.getYaw());
                    float yaw3 = (float) Math.toRadians(-owner.getYaw() + 180);
                    owner.getWorld().addParticle(new RingParticle.RingData(yaw2, 0, 20, 0.337f, 0.925f, 0.8f, 1.0f, 30f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);

                    owner.getWorld().addParticle(new RingParticle.RingData(yaw3, 0, 20, 0.337f, 0.925f, 0.8f, 1.0f, 30f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);

                }
            }

            if (temp == 0) {
                setRush(false);

            }
        }
    }


    private void spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, World world, LivingEntity player) {
        BlockPos blockpos = BlockPos.ofFloored(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(world, blockpos1, Direction.UP)) {
                if (!world.isAir(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.spawnEntity(new Phantom_Halberd_Entity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, player,(float) CMConfig.PhantomHalberddamage));
        }
    }

    public void setRush(boolean charge) {
        this.rush = charge;
    }

    public boolean isRush() {
        return this.rush;
    }

    public void setdamage(float damage) {
        this.damage = damage;
    }

    public float getdamage() {
        return this.damage;
    }

    public void setTimer(int timer) {
        this.Timer = timer;
    }

    public int getTimer() {
        return Timer;
    }

    @Override
    public NbtCompound serializeNBT() {
        NbtCompound tag = new NbtCompound();
        tag.putBoolean("isRush", this.isRush());
        tag.putFloat("damage", this.getdamage());
        tag.putInt("timer", this.getTimer());
        return tag;
    }

    @Override
    public void deserializeNBT(NbtCompound nbt) {
        this.setRush(nbt.getBoolean("isRush"));
        this.setdamage(nbt.getFloat("damage"));
        this.setTimer(nbt.getInt("timer"));

    }

    @Override
    public String getName() {
        return "cataclysm:render_rush_cap";
    }


//    public interface IRenderRushCapability extends INBTSerializable<NbtCompound> {
//
//        void tick(LivingEntity entity);
//
//        void setRush(boolean getCharge);
//
//        boolean isRush();
//
//        void setTimer(int timer);
//
//        int getTimer();
//
//        void setdamage(float damage);
//
//        float getdamage();
//
//
//    }
//
//    public static class RenderRushCapabilityImp implements IRenderRushCapability {
//
//
//
//        public static class RenderRushProvider implements ICapabilityProvider, ICapabilitySerializable<NbtCompound> {
//            private final LazyOptional<IRenderRushCapability> instance = LazyOptional.of(RenderRushCapabilityImp::new);
//
//            @Override
//            public NbtCompound serializeNBT() {
//                return instance.orElseThrow(NullPointerException::new).serializeNBT();
//            }
//
//            @Override
//            public void deserializeNBT(NbtCompound nbt) {
//                instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
//            }
//
//            @NotNull
//            @Override
//            public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
//                return ModCapabilities.RENDER_RUSH_CAPABILITY.orEmpty(cap, instance.cast());
//            }
//        }
//    }
}
