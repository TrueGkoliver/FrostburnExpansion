package com.teamaurora.frostburn_expansion.common.world.biome;

import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class FrostburnExpansionFeatureConfigs {
    public static final BlockState AURORAL_LOG = FrostburnExpansionBlocks.AURORAL_LOG.get().getDefaultState();
    public static final BlockState AURORAL_LEAVES = FrostburnExpansionBlocks.AURORAL_LEAVES.get().getDefaultState();
    public static final BlockState OLNEYA_LOG = FrostburnExpansionBlocks.OLNEYA_LOG.get().getDefaultState();
    public static final BlockState OLNEYA_LEAVES = FrostburnExpansionBlocks.OLNEYA_LEAVES.get().getDefaultState();

    public static final BaseTreeFeatureConfig AURORAL_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AURORAL_LOG), new SimpleBlockStateProvider(AURORAL_LEAVES), null, null, null)).setIgnoreVines().build();
    public static final BaseTreeFeatureConfig OLNEYA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OLNEYA_LOG), new SimpleBlockStateProvider(OLNEYA_LEAVES), null, null, null)).setIgnoreVines().build();
}
