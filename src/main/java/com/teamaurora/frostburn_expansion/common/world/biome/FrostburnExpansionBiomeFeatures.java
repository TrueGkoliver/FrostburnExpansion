package com.teamaurora.frostburn_expansion.common.world.biome;

import com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrostburnExpansionBiomeFeatures {
    public static BlockState BLUE_ICE = Blocks.BLUE_ICE.getDefaultState();
    public static BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
    public static BlockState BOREALENE = FrostburnExpansionBlocks.BOREALENE.get().getDefaultState();

    public static void addIceVariants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.PACKED_ICE, BLUE_ICE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 64, 0, 192))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.PACKED_ICE, SNOW, 43)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 64, 0, 192))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.PACKED_ICE, BOREALENE, 63)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 64, 0, 192))));
    }

    public static void addGlacierFreezeTopLayer(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FrostburnExpansionFeatures.ICE_AND_SNOW_NO_BOREALENE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    }

    public static void addAuroralTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FrostburnExpansionFeatures.AURORAL_TREE.withConfiguration(FrostburnExpansionFeatureConfigs.AURORAL_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 1))));
    }
}
