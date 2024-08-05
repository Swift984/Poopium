package net.swift984.poopiummod.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.swift984.poopiummod.block.ModBlocks;
import net.swift984.poopiummod.sound.ModSounds;

public class DysenteryEffect extends MobEffect {
    public DysenteryEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            if (pLivingEntity.isCrouching()){
                BlockState state = pLivingEntity.level().getBlockState(pLivingEntity.blockPosition().below());
                if (!state.isAir()) return;
                pLivingEntity.level().setBlockAndUpdate(pLivingEntity.blockPosition().below(), ModBlocks.DIARRHEA_BLOCK.get().defaultBlockState());
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
