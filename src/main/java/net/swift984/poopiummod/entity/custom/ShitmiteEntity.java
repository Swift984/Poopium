package net.swift984.poopiummod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.InfestedBlock;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.block.custom.InfestedPoopiumOreBlock;
import net.swift984.poopiummod.entity.ModEntities;
import net.swift984.poopiummod.item.ModItems;
import net.swift984.poopiummod.sound.ModSounds;
import net.swift984.poopiummod.util.ModTags;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;

public class ShitmiteEntity extends Animal {

    public ShitmiteEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }

    }


    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1F);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.10));
        this.goalSelector.addGoal(2, new TemptGoal(this,1.20, Ingredient.of(ModItems.POOPIUM.get()), false));
    //    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));

        this.goalSelector.addGoal(3, new FollowParentGoal(this,  .150));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this,  .5f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.MOVEMENT_SPEED, .10)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.SHITMITE.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.POOPIUM.get());
    }

    @Override
    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        return InfestedPoopiumOreBlock.isCompatibleHostBlock(pLevel.getBlockState(pPos.below())) ? 10.0F : super.getWalkTargetValue(pPos, pLevel);
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SOUND_SHITMITE_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SOUND_SHITMITE_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.SOUND_SHITMITE_HIT.get();
    }
}
