package net.swift984.poopiummod.item;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties OBAMACOPTER_SMOOTHIE = new FoodProperties.Builder()
            .alwaysEat().meat().nutrition(20).saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1200), .05f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 1200), .01f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), .25f).build();
    public static final FoodProperties PEACHERPOP = new FoodProperties.Builder()
            .alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 3), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 600, 10), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 600), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 600, 10),1.0f).build();
    public static final FoodProperties MUSIC_DISC_POOPTUNES = new FoodProperties.Builder()
            .alwaysEat().meat()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 600, 2, true, false), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 6000, 100, true, false), 1.0f).build();
}
