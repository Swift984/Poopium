package net.swift984.poopiummod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.block.custom.InfestedPoopiumOreBlock;
import net.swift984.poopiummod.block.custom.PoopiumCropBlock;
import net.swift984.poopiummod.item.ModItems;
import net.swift984.poopiummod.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PoopiumMod.MOD_ID);

    public static final RegistryObject<Block> POOPIUM_BLOCK = registerBlock("poopium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .destroyTime(1f).friction(0.4F).sound(ModSounds.POOPIUM_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> OXIDIZED_FECULANT_BLOCK = registerBlock("oxidized_feculant_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> POOPIUM_ORE = registerBlock("poopium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,7)));
    public static final RegistryObject<Block> DIARRHEA_BLOCK = registerBlock("diarrhea_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)
                    .friction(0.4F).sound(ModSounds.POOPIUM_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> GRAYSON_STATUE_BLOCK = registerBlock("grayson_statue_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)
                    .instrument(NoteBlockInstrument.BANJO).lightLevel(value -> 15).destroyTime(1.0f).friction(4F).sound(SoundType.AMETHYST_CLUSTER)));
    public static final RegistryObject<Block> INFESTED_POOPIUM_ORE = registerBlock("infested_poopium_ore",
            () -> new InfestedPoopiumOreBlock(Blocks.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));

    public static final RegistryObject<Block> POOPIUM_CROP = BLOCKS.register("poopium_crop",
            () -> new PoopiumCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).noOcclusion().noCollission()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
