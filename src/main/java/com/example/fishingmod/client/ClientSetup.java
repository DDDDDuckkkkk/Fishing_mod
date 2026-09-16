package com.example.fishingmod.client;

import com.example.fishingmod.FishingMod;
import com.example.fishingmod.client.model.FishingRodModel;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ClientSetup {

    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FishingMod.LURE.get(), LureRenderer::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FishingRodModel.LAYER_LOCATION, FishingRodModel::createBodyLayer);
    }
}
