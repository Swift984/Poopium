package net.swift984.poopiummod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.block.ModBlocks;
import net.swift984.poopiummod.init.PaintingInit;
import net.swift984.poopiummod.potion.ModPotions;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PoopiumMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> POOPIUM_TAB = CREATIVE_MODE_TABS.register("poopium_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.POOPIUM.get()))
                    .title(Component.translatable("creativetab.poopium_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.POOPIUM.get());
                        pOutput.accept(ModItems.DUNG_FUEL.get());
                        pOutput.accept(ModItems.OXIDIZED_FECULANT.get());
                        pOutput.accept(ModItems.ANCIENT_FECULANT.get());
                        pOutput.accept(ModItems.OBAMACOPTER_SMOOTHIE.get());
                        pOutput.accept(ModItems.PEACHERPOP.get());
                        pOutput.accept(ModItems.SHITSWORD.get());
                        pOutput.accept(ModItems.POOPSTICK.get());
                        pOutput.accept(ModItems.POOP_SCOOPER.get());
                        pOutput.accept(ModItems.MUSIC_DISC_POOPTUNES.get());
                        pOutput.accept(ModItems.MUSIC_DISC_OMBLY.get());
                        pOutput.accept(ModItems.MUSIC_DISC_WADE.get());
                        pOutput.accept(ModItems.POOPIUM_SEEDS.get());
                        pOutput.accept(ModItems.POOPIUM_SEED_FRAGMENT.get());

                        pOutput.accept(ModBlocks.POOPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.POOPIUM_ORE.get());
                        pOutput.accept(ModBlocks.INFESTED_POOPIUM_ORE.get());
                        pOutput.accept(ModBlocks.OXIDIZED_FECULANT_BLOCK.get());
                        pOutput.accept(ModBlocks.DIARRHEA_BLOCK.get());
                        pOutput.accept(ModBlocks.GRAYSON_STATUE_BLOCK.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
