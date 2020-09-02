package com.teamaurora.frostburn_expansion.core.other;

import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class FrostburnExpansionRender {
    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_LEAF_CARPET.get(),RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.POTTED_AURORAL_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.AURORAL_LADDER.get(),RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.POTTED_OLNEYA_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLNEYA_LADDER.get(),RenderType.getCutout());
    }
}
