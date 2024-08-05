package net.swift984.poopiummod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, PoopiumMod.MOD_ID);

    public static final RegistryObject<Potion> DYSENTERY_POTION = POTIONS.register("dysentery_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.DYSENTERY.get(), 1800, 0),
                    new MobEffectInstance(MobEffects.CONFUSION, 600, 0, true, false, false),
                    new MobEffectInstance(MobEffects.HUNGER, 600, 4, true, false, false)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
