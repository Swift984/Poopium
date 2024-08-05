package net.swift984.poopiummod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.swift984.poopiummod.PoopiumMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_POOPIUM_TOOL = tag("needs_poopium_tool");


        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PoopiumMod.MOD_ID, name));
        }
    }

    public static class Items {


        public static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PoopiumMod.MOD_ID, name));
        }
    }
}
