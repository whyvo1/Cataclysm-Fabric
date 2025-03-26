package com.github.l_ender.cataclysm.entity.Pet;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.Pet.AI.InternalPetStateGoal;
import com.github.l_ender.cataclysm.entity.Pet.AI.TameableAIFollowOwner;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.inventory.MinistrostiyMenu;
import com.github.l_ender.cataclysm.message.MessageMiniinventory;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.RideableInventory;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import net.minecraft.world.event.GameEvent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

public class Netherite_Ministrosity_Entity extends InternalAnimationPet implements Bucketable,InventoryChangedListener, RideableInventory {
    private static final TrackedData<Boolean> FROM_BUCKET = DataTracker.registerData(Netherite_Ministrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_AWAKEN = DataTracker.registerData(Netherite_Ministrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public SimpleInventory miniInventory;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState operationAnimationState = new AnimationState();
    public AnimationState chestopenAnimationState = new AnimationState();
    public AnimationState chestloopAnimationState = new AnimationState();
    public AnimationState chestcloseAnimationState = new AnimationState();
    public AnimationState sitstartAnimationState = new AnimationState();
    public AnimationState sitendAnimationState = new AnimationState();

    public Netherite_Ministrosity_Entity(EntityType type, World world) {
        super(type, world);
        this.createInventory();
        this.experiencePoints = 0;
        setConfigattribute(this, CMConfig.MinistrosityHealthMultiplier,1);
        this.setStepHeight(1.0F);

    }

    protected void initGoals() {
        this.goalSelector.add(0, new SitGoal(this));
        this.goalSelector.add(6, new TameableAIFollowOwner(this, 1.3D, 6.0F, 2.0F, true));
        this.goalSelector.add(6, new TemptGoal(this, 1.0D, Ingredient.ofItems(Items.SNIFFER_EGG), false));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D, 60));
        this.goalSelector.add(1, new InternalPetStateGoal(this,1,1,0,0,0){

            @Override
            public boolean canStart() {
                return super.canStart() ;
            }

            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
        });

        this.goalSelector.add(0, new InternalPetStateGoal(this,1,2,0,40,0){
            @Override
            public boolean canStart() {
                return super.canStart() && Netherite_Ministrosity_Entity.this.getIsAwaken();
            }
        });


       // this.goalSelector.addGoal(1, new InternalPetStateGoal(this,5,5,0,10,0));

    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MINISTROSITY_HURT;
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public boolean isOpen() {
        return this.getAttackState() == 3 || this.getAttackState() == 4;
    }

    public void setIsAwaken(boolean isAwaken) {
        this.dataTracker.set(IS_AWAKEN, isAwaken);
        if (!isAwaken) {
            this.setAttackState(1);
        }
    }

    public boolean getIsAwaken() {
        return this.dataTracker.get(IS_AWAKEN);
    }

    protected int getInventorySize() {
        return 17;
    }



    protected void createInventory() {
        SimpleInventory simplecontainer = this.miniInventory;
        this.miniInventory = new SimpleInventory(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.size(), this.miniInventory.size());

            for(int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getStack(j);
                if (!itemstack.isEmpty()) {
                    this.miniInventory.setStack(j, itemstack.copy());
                }
            }
        }

        this.miniInventory.addListener(this);
//        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.miniInventory));
    }

    @Override
    public void openInventory(PlayerEntity playerEntity) {
        if(playerEntity instanceof ServerPlayerEntity serverplayer) {
            if (isAlive()) {
                if (serverplayer.currentScreenHandler != serverplayer.playerScreenHandler) {
                    serverplayer.closeHandledScreen();
                }

                this.setAttackState(3);
                serverplayer.incrementScreenHandlerSyncId();
                new MessageMiniinventory(serverplayer.screenHandlerSyncId, this.miniInventory.size(), this.getId()).sendToClient(serverplayer);
                serverplayer.currentScreenHandler = new MinistrostiyMenu(serverplayer.screenHandlerSyncId, serverplayer.getInventory(), this.miniInventory, this);
                serverplayer.onScreenHandlerOpened(serverplayer.currentScreenHandler);
//                MinecraftForge.EVENT_BUS.post(new PlayerContainerEvent.Open(serverplayer, serverplayer.currentScreenHandler));
            }
        }

    }


    public int getInventoryColumns() {
        return 5;
    }

    public void onInventoryChanged(Inventory p_30548_) {

    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "idle" -> this.idleAnimationState;
            case "sleep" -> this.sleepAnimationState;
            case "operation" -> this.operationAnimationState;
            case "chest_open" -> this.chestopenAnimationState;
            case "chest_loop" -> this.chestloopAnimationState;
            case "chest_close" -> this.chestcloseAnimationState;
            case "sit_start" -> this.sitstartAnimationState;
            case "sit_end" -> this.sitendAnimationState;
            default -> new AnimationState();
        };
//        if (input == "idle") {
//            return this.idleAnimationState;
//        } else if (input == "sleep") {
//            return this.sleepAnimationState;
//        } else if (input == "operation") {
//            return this.operationAnimationState;
//        } else if (input == "chest_open") {
//            return this.chestopenAnimationState;
//        } else if (input == "chest_loop") {
//            return this.chestloopAnimationState;
//        } else if (input == "chest_close") {
//            return this.chestcloseAnimationState;
//        } else if (input == "sit_start") {
//            return this.sitstartAnimationState;
//        } else if (input == "sit_end") {
//            return this.sitendAnimationState;
//
//        }else {
//            return new AnimationState();
//        }
    }




    public static DefaultAttributeContainer.Builder ministrosity() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 120.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 5D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4F);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public void travel(Vec3d vec3d) {
        if (this.isSitting()) {
            if (this.getNavigation().getCurrentPath() != null) {
                this.getNavigation().stop();
            }
            vec3d = Vec3d.ZERO;
        }
        super.travel(vec3d);
    }


    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.isOf(DamageTypes.IN_WALL) || source.isOf(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    protected void dropInventory() {
        super.dropInventory();
        if (miniInventory != null) {
            for (int i = 0; i < miniInventory.size(); ++i) {
                ItemStack itemstack = miniInventory.getStack(i);
                if (!itemstack.isEmpty()) {
                    this.dropStack(itemstack, 0.0F);
                }
            }
        }
    }


    public boolean canBreatheInWater() {
        return true;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FROM_BUCKET, false);
        this.dataTracker.startTracking(IS_AWAKEN, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
        compound.putBoolean("is_Awaken", this.getIsAwaken());
        NbtList listtag = new NbtList();

        for(int i = 2; i < this.miniInventory.size(); ++i) {
            ItemStack itemstack = this.miniInventory.getStack(i);
            if (!itemstack.isEmpty()) {
                NbtCompound compoundtag = new NbtCompound();
                compoundtag.putByte("Slot", (byte)i);
                itemstack.writeNbt(compoundtag);
                listtag.add(compoundtag);
            }
        }

        compound.put("Items", listtag);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
        this.setIsAwaken(compound.getBoolean("is_Awaken"));
        this.createInventory();
        NbtList listtag = compound.getList("Items", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            NbtCompound compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 2 && j < this.miniInventory.size()) {
                this.miniInventory.setStack(j, ItemStack.fromNbt(compoundtag));
            }
        }

    }


    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    this.stopAllAnimationStates();
                    this.sleepAnimationState.startIfNotRunning(this.age);
                }
                case 2 -> {
                    this.stopAllAnimationStates();
                    this.operationAnimationState.startIfNotRunning(this.age);
                }
                case 3 -> {
                    this.stopAllAnimationStates();
                    this.chestopenAnimationState.startIfNotRunning(this.age);
                }
                case 4 -> {
                    this.stopAllAnimationStates();
                    this.chestloopAnimationState.startIfNotRunning(this.age);
                }
                case 5 -> {
                    this.stopAllAnimationStates();
                    this.chestcloseAnimationState.startIfNotRunning(this.age);
                }
            }
        }
        if (COMMAND.equals(p_21104_)) {
            switch (this.getCommand()) {
                case 0 -> {
                    this.sitAnimationStates();
                    this.sitendAnimationState.startIfNotRunning(this.age);
                }
                case 1 -> this.sitAnimationStates();
                case 2 -> {
                    this.sitAnimationStates();
                    this.sitstartAnimationState.startIfNotRunning(this.age);
                }

            }
        }

        super.onTrackedDataSet(p_21104_);
    }


    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.operationAnimationState.stop();
        this.chestopenAnimationState.stop();
        this.chestloopAnimationState.stop();
        this.chestcloseAnimationState.stop();
    }

    public void sitAnimationStates() {
        this.sitstartAnimationState.stop();
        this.sitendAnimationState.stop();
    }


    @Override
    public boolean isFromBucket() {
        return this.dataTracker.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean sit) {
        this.dataTracker.set(FROM_BUCKET, sit);
    }

    @Override
    public void copyDataToStack(@NotNull ItemStack bucket) {
        NbtCompound platTag = new NbtCompound();
        NbtCompound compound = bucket.getOrCreateNbt();
        this.writeCustomDataToNbt(platTag);
        Bucketable.copyDataToStack(this, bucket);
        compound.put("MinistrosityData", platTag);

    }

    @Override
    public void copyDataFromNbt(NbtCompound p_148832_) {
        Bucketable.copyDataFromNbt(this, p_148832_);
        if (p_148832_.contains("MinistrosityData")) {
            this.readCustomDataFromNbt(p_148832_.getCompound("MinistrosityData"));
        }
    }

    @Override
    @NotNull
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.NETHERITE_MINISTROSITY_BUCKET);
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return ModSounds.MINISTROSITY_FILL_BUCKET;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        boolean owner = this.isTamed() && isOwner(player);
        ActionResult type = super.interactMob(player, hand);
        if (owner) {
            Optional<ActionResult> result = emptybucketMobPickup(player, hand, this);
            if (result.isPresent()) {
                return result.get();
            }else{
                if (!player.isSneaking()) {
                    this.openInventory(player);
                    this.setCommand(2);
                    this.setSitting(true);
                    return ActionResult.success(this.getWorld().isClient);
                }
            }

        }


        if (!isTamed() && stack.isOf(ModItems.LAVA_POWER_CELL)) {
            this.eat(player, hand, stack);
            this.emitGameEvent(GameEvent.EAT);
//            if (!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
            this.setOwner(player);
            this.setIsAwaken(true);
            this.getWorld().sendEntityStatus(this, (byte) 7);
//            } else {
//                this.getWorld().sendEntityStatus(this, (byte) 6);
//            }
            return ActionResult.SUCCESS;
        }


        if (isTamed() && stack.isOf(Items.COAL) && this.getHealth() < this.getMaxHealth()) {
            this.heal(5);
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            this.emitGameEvent(GameEvent.EAT, this);
            return ActionResult.SUCCESS;

        }

        ActionResult interactionresult = stack.useOnEntity(player, this, hand);
        if (interactionresult != ActionResult.SUCCESS && type != ActionResult.SUCCESS && isTamed() && isOwner(player)) {
            if (player.isSneaking()) {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                }
                player.sendMessage(Text.translatable("entity.cataclysm.all.command_" + this.getCommand(), this.getName()), true);
                boolean sit = this.getCommand() == 2;
                if (sit) {
                    this.setSitting(true);
                    return ActionResult.SUCCESS;
                } else {
                    this.setSitting(false);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return type;
    }


    private static <T extends LivingEntity & Bucketable> Optional<ActionResult> emptybucketMobPickup(PlayerEntity p_148829_, Hand p_148830_, T p_148831_) {
        ItemStack itemstack = p_148829_.getStackInHand(p_148830_);
        if (itemstack.getItem() == Items.BUCKET && p_148831_.isAlive()) {
            p_148831_.playSound(p_148831_.getBucketFillSound(), 1.0F, 1.0F);
            ItemStack itemstack1 = p_148831_.getBucketItem();
            p_148831_.copyDataToStack(itemstack1);
            ItemStack itemstack2 = ItemUsage.exchangeStack(itemstack, p_148829_, itemstack1, false);
            p_148829_.setStackInHand(p_148830_, itemstack2);
            World level = p_148831_.getWorld();
            if (!level.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)p_148829_, itemstack1);
            }

            p_148831_.discard();
            return Optional.of(ActionResult.success(level.isClient));
        } else {
            return Optional.empty();
        }
    }

    public void tickMovement() {
        super.tickMovement();
        if ((this.isSitting() || isOpen())  && this.getNavigation().isIdle()) {
            this.getNavigation().stop();
        }
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning( this.getAttackState() == 0, this.age);
        }
        if(this.getAttackState() == 3){
            if(this.attackTicks == 1){
                this.playSound(SoundEvents.ENTITY_SHULKER_AMBIENT, 1.0F, 2.0F);
            }
            if(this.attackTicks >= 9){
                this.setAttackState(4);
            }


        }
        if(this.getAttackState() == 5){
            if(this.attackTicks == 1){
                this.playSound(SoundEvents.ENTITY_SHULKER_AMBIENT, 1.0F, 2.0F);
            }
            if(this.attackTicks >= 10){
                this.setAttackState(0);
            }
        }

        if (this.getWorld().isClient){
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }

    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    public boolean isTeammate(Entity entityIn) {
        if (this.isTamed()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }
            if (entityIn instanceof TameableEntity) {
                return ((TameableEntity) entityIn).isOwner(livingentity);
            }
            if (livingentity != null) {
                return livingentity.isTeammate(entityIn);
            }
        }

        return super.isTeammate(entityIn);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }


//    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

//    @Override
//    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.math.Direction facing) {
//        if (this.isAlive() && capability == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER && itemHandler != null)
//            return itemHandler.cast();
//        return super.getCapability(capability, facing);
//    }

//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//        if (itemHandler != null) {
//            net.minecraftforge.common.util.LazyOptional<?> oldHandler = itemHandler;
//            itemHandler = null;
//            oldHandler.invalidate();
//        }
//    }

    public boolean hasInventoryChanged(Inventory p_149512_) {
        return this.miniInventory != p_149512_;
    }
}
