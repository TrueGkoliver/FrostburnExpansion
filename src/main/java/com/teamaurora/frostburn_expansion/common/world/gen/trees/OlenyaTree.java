package com.teamaurora.frostburn_expansion.common.world.gen.trees;

import com.teamaurora.frostburn_expansion.common.world.biome.FrostburnExpansionFeatureConfigs;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class OlenyaTree extends Tree {

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean wtf) {
        return Feature.field_236291_c_.withConfiguration(FrostburnExpansionFeatureConfigs.OLENYA_TREE_CONFIG);
    }
}
