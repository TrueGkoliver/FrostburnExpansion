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
    public static final BlockState OLENYA_LOG = FrostburnExpansionBlocks.OLENYA_LOG.get().getDefaultState();
    public static final BlockState OLENYA_LEAVES = FrostburnExpansionBlocks.OLENYA_LEAVES.get().getDefaultState();

    public static final BaseTreeFeatureConfig AURORAL_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AURORAL_LOG), new SimpleBlockStateProvider(AURORAL_LEAVES), new SpruceFoliagePlacer(2, 1, 0, 2, 1, 1), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).setIgnoreVines().build();
    //public static final BaseTreeFeatureConfig OLENYA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OLENYA_LOG), new SimpleBlockStateProvider(OLENYA_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    public static final BaseTreeFeatureConfig OLENYA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OLENYA_LOG), new SimpleBlockStateProvider(OLENYA_LEAVES), null, null, null)).setIgnoreVines().build();
}
