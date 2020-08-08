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

        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.POTTED_OLENYA_SAPLING.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(FrostburnExpansionBlocks.OLENYA_LADDER.get(),RenderType.getCutout());
    }
}
