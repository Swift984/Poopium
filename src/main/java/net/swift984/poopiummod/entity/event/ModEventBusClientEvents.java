package net.swift984.poopiummod.entity.event;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.entity.client.ModModelLayers;
import net.swift984.poopiummod.entity.client.ShitmiteModel;

@Mod.EventBusSubscriber(modid = PoopiumMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SHITMITE_LAYER, ShitmiteModel::createBodyLayer);
    }
}
