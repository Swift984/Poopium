package net.swift984.poopiummod.block.custom;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.swift984.poopiummod.entity.ModEntities;
import net.swift984.poopiummod.entity.custom.ShitmiteEntity;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class InfestedPoopiumOreBlock extends Block {
    private final Block hostBlock;
    private static final Map<Block, Block> BLOCK_BY_HOST_BLOCK = Maps.newIdentityHashMap();
    private static final Map<BlockState, BlockState> HOST_TO_INFESTED_STATES = Maps.newIdentityHashMap();
    private static final Map<BlockState, BlockState> INFESTED_TO_HOST_STATES = Maps.newIdentityHashMap();

    public InfestedPoopiumOreBlock(Block pHostBlock, BlockBehaviour.Properties pProperties) {
        super(pProperties.destroyTime(pHostBlock.defaultDestroyTime() / 2.0F).explosionResistance(0.75F));
        this.hostBlock = pHostBlock;
        BLOCK_BY_HOST_BLOCK.put(pHostBlock, this);
    }

    public Block getHostBlock() {
        return this.hostBlock;
    }

    public static boolean isCompatibleHostBlock(BlockState pState) {
        return BLOCK_BY_HOST_BLOCK.containsKey(pState.getBlock());
    }

    private void spawnInfestation(ServerLevel pLevel, BlockPos pPos) {
        Random rand = new Random();
        for(int i = 0; i < rand.nextInt(10); i++) {
            ShitmiteEntity shitmite = ModEntities.SHITMITE.get().create(pLevel);

            if (shitmite != null) {
                shitmite.moveTo((double) pPos.getX() + 0.5, (double) pPos.getY(), (double) pPos.getZ() + 0.5, 0.0F, 0.0F);
                pLevel.addFreshEntity(shitmite);
                shitmite.spawnAnim();
            }
        }

    }

    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        super.spawnAfterBreak(pState, pLevel, pPos, pStack, pDropExperience);
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            this.spawnInfestation(pLevel, pPos);
        }

    }

    public static BlockState infestedStateByHost(BlockState pHost) {
        return getNewStateWithProperties(HOST_TO_INFESTED_STATES, pHost, () -> {
            return ((Block)BLOCK_BY_HOST_BLOCK.get(pHost.getBlock())).defaultBlockState();
        });
    }

    public BlockState hostStateByInfested(BlockState pInfested) {
        return getNewStateWithProperties(INFESTED_TO_HOST_STATES, pInfested, () -> {
            return this.getHostBlock().defaultBlockState();
        });
    }

    private static BlockState getNewStateWithProperties(Map<BlockState, BlockState> pStateMap, BlockState pState, Supplier<BlockState> pSupplier) {
        return (BlockState)pStateMap.computeIfAbsent(pState, (p_153429_) -> {
            BlockState $$2 = (BlockState)pSupplier.get();

            Property $$3;
            for(Iterator var3 = p_153429_.getProperties().iterator(); var3.hasNext(); $$2 = $$2.hasProperty($$3) ? (BlockState)$$2.setValue($$3, p_153429_.getValue($$3)) : $$2) {
                $$3 = (Property)var3.next();
            }

            return $$2;
        });
    }
}
