package net.swift984.poopiummod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.swift984.poopiummod.entity.animations.ModAnimationDefinitions;
import net.swift984.poopiummod.entity.custom.ShitmiteEntity;

public class ShitmiteModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart shitmite;
	private final ModelPart bone1;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;

	public ShitmiteModel(ModelPart root) {
		this.shitmite = root.getChild("shitmite");
		this.bone1 = shitmite.getChild("bone1");
		this.bone2 = shitmite.getChild("bone2");
		this.bone3 = shitmite.getChild("bone3");
		this.bone4 = shitmite.getChild("bone4");
		this.bone5 = shitmite.getChild("bone5");
		this.bone6 = shitmite.getChild("bone6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shitmite = partdefinition.addOrReplaceChild("shitmite", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));	//24.0F

		PartDefinition bone1 = shitmite.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone2 = shitmite.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone3 = shitmite.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(3, 3).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone4 = shitmite.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(3, 1).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone5 = shitmite.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone6 = shitmite.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(3, 5).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.SHITMITE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((ShitmiteEntity) entity).idleAnimationState, ModAnimationDefinitions.SHITMITE_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return shitmite;
	}
}