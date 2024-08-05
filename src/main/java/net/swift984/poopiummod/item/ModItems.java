package net.swift984.poopiummod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.block.ModBlocks;
import net.swift984.poopiummod.item.custom.FuelItem;
import net.swift984.poopiummod.item.custom.PoopiumItem;
import net.swift984.poopiummod.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PoopiumMod.MOD_ID);

    public static final RegistryObject<Item> POOPIUM = ITEMS.register("poopium",
            () -> new PoopiumItem(new Item.Properties()));
    public static final RegistryObject<Item> OXIDIZED_FECULANT = ITEMS.register("oxidized_feculant",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBAMACOPTER_SMOOTHIE = ITEMS.register("obamacopter_smoothie",
            () -> new Item(new Item.Properties().food(ModFoods.OBAMACOPTER_SMOOTHIE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PEACHERPOP = ITEMS.register("peacherpop",
            () -> new Item(new Item.Properties().food(ModFoods.PEACHERPOP).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> MUSIC_DISC_POOPTUNES = ITEMS.register("music_disc_pooptunes",
            () -> new RecordItem(1, ModSounds.POOPTUNES, new Item.Properties().food(ModFoods.MUSIC_DISC_POOPTUNES)
                    .stacksTo(1).fireResistant().rarity(Rarity.EPIC), 2760));
    public static final RegistryObject<Item> MUSIC_DISC_OMBLY = ITEMS.register("music_disc_ombly",
            () -> new RecordItem(1, ModSounds.OMBLY, new Item.Properties()
                    .stacksTo(1).fireResistant().rarity(Rarity.EPIC), 1420));
    public static final RegistryObject<Item> MUSIC_DISC_WADE = ITEMS.register("music_disc_wade",
            () -> new RecordItem(1, ModSounds.WADE, new Item.Properties()
                    .stacksTo(1).fireResistant().rarity(Rarity.EPIC), 2340));
    public static final RegistryObject<Item> SHITSWORD = ITEMS.register("shitsword",
            () -> new SwordItem(ModToolTiers.POOPIUM,6,-2, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> POOP_SCOOPER = ITEMS.register("poop_scooper",
            () -> new ShovelItem(ModToolTiers.POOPIUM,1,-3, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> POOPIUM_SEEDS = ITEMS.register("poopium_seeds",
            () -> new ItemNameBlockItem(ModBlocks.POOPIUM_CROP.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> POOPIUM_SEED_FRAGMENT = ITEMS.register("poopium_seed_fragment",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DUNG_FUEL = ITEMS.register("dung_fuel",
            () -> new FuelItem(new Item.Properties().rarity(Rarity.COMMON), 6400));
    public static final RegistryObject<Item> POOPSTICK = ITEMS.register("poopstick",
            () -> new SwordItem(ModToolTiers.POOPIUM,415,0.1f, new Item.Properties()
                    .rarity(Rarity.EPIC).durability(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ANCIENT_FECULANT = ITEMS.register("ancient_feculant",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
