package net.swift984.poopiummod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.swift984.poopiummod.PoopiumMod;
import net.swift984.poopiummod.entity.custom.ShitmiteEntity;

public class ShitmiteRenderer extends MobRenderer<ShitmiteEntity, ShitmiteModel<ShitmiteEntity>> {
    public ShitmiteRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShitmiteModel<>(pContext.bakeLayer(ModModelLayers.SHITMITE_LAYER)), .2f);

    }

    @Override
    public ResourceLocation getTextureLocation(ShitmiteEntity shitmiteEntity) {
        return new ResourceLocation(PoopiumMod.MOD_ID, "textures/entity/shitmite.png");
    }

    @Override
    public void render(ShitmiteEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }



        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
