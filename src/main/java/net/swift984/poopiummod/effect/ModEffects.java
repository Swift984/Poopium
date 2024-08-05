package net.swift984.poopiummod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PoopiumMod.MOD_ID);

    public static final RegistryObject<MobEffect> DYSENTERY = MOB_EFFECTS.register("dysentery",
            () -> new DysenteryEffect(MobEffectCategory.NEUTRAL, 8077056));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
