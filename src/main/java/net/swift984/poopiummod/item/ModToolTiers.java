package net.swift984.poopiummod.item;

import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.util.ModTags;

public class ModToolTiers {
    public static final Tier POOPIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5,700,12f,4f,60,
                    ModTags.Blocks.NEEDS_POOPIUM_TOOL, () -> Ingredient.of(ModItems.POOPIUM.get())),
            new ResourceLocation(PoopiumMod.MOD_ID,"poopium"), List.of(Tiers.NETHERITE), List.of());
}
