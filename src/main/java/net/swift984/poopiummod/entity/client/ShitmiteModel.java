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

public class ShitmiteModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart shitmite;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;

	public ShitmiteModel(ModelPart root) {
		this.shitmite = root.getChild("shitmite");
		this.bone = shitmite.getChild("bone");
		this.bone2 = shitmite.getChild("bone2");
		this.bone3 = shitmite.getChild("bone3");
		this.bone4 = shitmite.getChild("bone4");
		this.bone5 = shitmite.getChild("bone5");
		this.bone6 = shitmite.getChild("bone6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();



		float pX = 0,
				pY = 0,
				pZ = 0;

        float rX = 0;
		float rY = 0;
		float rZ = 0;

		PartDefinition shitmite = partdefinition.addOrReplaceChild("shitmite", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0, 0.0F));

		PartDefinition bone = shitmite.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 2).addBox(-1f, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 24.0F, pZ, rX, rY, rZ));

		PartDefinition bone2 = shitmite.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 24.0F, pZ, rX, rY, rZ));

		PartDefinition bone3 = shitmite.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(3, 3).addBox(-1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 24.0F, pZ, rX, rY, rZ));

		PartDefinition bone4 = shitmite.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(3, 1).addBox(-1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 24.0F, pZ, rX, rY, rZ));

		PartDefinition bone5 = shitmite.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 4).addBox(-1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 24.0F, pZ, rX, rY, rZ));

		PartDefinition bone6 = shitmite.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(3, 5).addBox(-1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, pZ, rX, rY, rZ));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return shitmite;
	}
}