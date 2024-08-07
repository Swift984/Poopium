package net.swift984.poopiummod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.entity.custom.ShitmiteEntity;

import java.rmi.registry.Registry;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PoopiumMod.MOD_ID);

    public static final RegistryObject<EntityType<ShitmiteEntity>> SHITMITE =
            ENTITY_TYPES.register("shitmite", () -> EntityType.Builder.of(ShitmiteEntity::new, MobCategory.CREATURE)
                    .sized(1,1).build("shitmite"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
