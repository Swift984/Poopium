package net.swift984.poopiummod.entity.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.entity.ModEntities;
import net.swift984.poopiummod.entity.custom.ShitmiteEntity;

@Mod.EventBusSubscriber(modid = PoopiumMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SHITMITE.get(), ShitmiteEntity.createAttributes().build());
    }
}
