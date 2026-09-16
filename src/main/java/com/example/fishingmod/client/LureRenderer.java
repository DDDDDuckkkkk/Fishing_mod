package com.example.fishingmod.client;

import com.example.fishingmod.FishingMod;
import com.example.fishingmod.client.model.FishingRodModel;
import com.example.fishingmod.entity.LureEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

// 拟饵实体的渲染器，复用你的 Blockbench 鱼竿模型作为可视化标记
// TODO: 有 Geo 模型后可替换为真正的米诺/亮片模型
public class LureRenderer extends EntityRenderer<LureEntity> {

    private final FishingRodModel<LureEntity> model;

    public LureRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new FishingRodModel<>(context.bakeLayer(FishingRodModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(LureEntity entity) {
        return new ResourceLocation(FishingMod.MODID, "textures/entity/fishing_rod.png");
    }

    @Override
    public void render(LureEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0, 1.2, 0.0);
        poseStack.scale(-1.0F, -1.0F, 1.0F); // 翻转到实体渲染坐标系
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
