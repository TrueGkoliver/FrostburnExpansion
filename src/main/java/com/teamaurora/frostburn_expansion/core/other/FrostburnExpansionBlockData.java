package com.teamaurora.frostburn_expansion.core.other;

import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class FrostburnExpansionBlockData {
    public static void registerCompostables() {
        DataUtils.registerCompostable(0.3f, FrostburnExpansionBlocks.AURORAL_LEAVES.get());
        DataUtils.registerCompostable(0.3f, FrostburnExpansionBlocks.AURORAL_SAPLING.get());
        DataUtils.registerCompostable(0.3f, FrostburnExpansionBlocks.AURORAL_LEAF_CARPET.get());
    }

    public static void registerFlammables() {
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_LOG.get(), 5, 5);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.STRIPPED_AURORAL_LOG.get(), 5, 5);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.STRIPPED_AURORAL_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.VERTICAL_AURORAL_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(FrostburnExpansionBlocks.AURORAL_VERTICAL_SLAB.get(), 5, 20);
    }
}
