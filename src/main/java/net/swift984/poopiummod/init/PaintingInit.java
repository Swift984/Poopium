package net.swift984.poopiummod.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;

public class PaintingInit {
    public static final DeferredRegister<PaintingVariant> PAINTINGS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PoopiumMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> PEACHERPOP_PAINTING = PAINTINGS.register("peacherpop_painting",
            () -> new PaintingVariant(64, 64));
}
