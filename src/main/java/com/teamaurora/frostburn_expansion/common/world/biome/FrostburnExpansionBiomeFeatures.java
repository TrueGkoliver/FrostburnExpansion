package com.teamaurora.frostburn_expansion.common.world.biome;

import com.google.common.collect.ImmutableList;
import com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import static net.minecraft.world.biome.DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG;

public class FrostburnExpansionBiomeFeatures {
    public static BlockState BLUE_ICE = Blocks.BLUE_ICE.getDefaultState();
    public static BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
    public static BlockState BOREALENE = FrostburnExpansionBlocks.BOREALENE.get().getDefaultState();

    public static BlockState WATER = Blocks.WATER.getDefaultState();

    public static void addIceVariants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.PACKED_ICE, BLUE_ICE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 64, 0, 192))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.ALL_ICE, SNOW, 43)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 64, 0, 192))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FrostburnExpansionFeatures.NOT_SHIT_ORE.withConfiguration(new NotShitOreFeatureConfig(NotShitOreFeatureConfig.FillerBlockType.PACKED_ICE, BOREALENE, 63)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 64, 0, 192))));
    }

    public static void addFrozenFossils(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, FrostburnExpansionFeatures.GLACIER_FOSSILS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(3))));
    }

    public static void addGlacierFreezeTopLayer(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FrostburnExpansionFeatures.ICE_AND_SNOW_NO_BOREALENE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    }

    public static void addAuroralTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FrostburnExpansionFeatures.AURORAL_TREE.withConfiguration(FrostburnExpansionFeatureConfigs.AURORAL_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 1))));
    }

    public static void addNotSoSparseBerryBushes(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(2))));
    }

    public static void addDesertLakesFeatures(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.LAKES, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(3))));
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, FrostburnExpansionFeatures.OASIS_GRASS_PLACER.withConfiguration(new NoFeatureConfig()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(32))));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FrostburnExpansionFeatures.OLNEYA_TREE.withConfiguration(FrostburnExpansionFeatureConfigs.OLNEYA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
    }

    public static void addSparseOlneyaTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FrostburnExpansionFeatures.OLNEYA_TREE.withConfiguration(FrostburnExpansionFeatureConfigs.OLNEYA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.0065F, 1))));
    }
}
