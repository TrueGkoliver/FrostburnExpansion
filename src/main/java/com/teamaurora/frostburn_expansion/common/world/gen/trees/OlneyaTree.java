package com.teamaurora.frostburn_expansion.common.world.gen.trees;

import com.teamaurora.frostburn_expansion.common.world.biome.FrostburnExpansionFeatureConfigs;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class OlneyaTree extends Tree {

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean wtf) {
        return FrostburnExpansionFeatures.OLENYA_TREE.withConfiguration(FrostburnExpansionFeatureConfigs.OLNEYA_TREE_CONFIG);
    }
}
