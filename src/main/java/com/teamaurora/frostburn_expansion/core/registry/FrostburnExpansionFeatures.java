package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.world.biome.FrostburnExpansionBiomeFeatures;
import com.teamaurora.frostburn_expansion.common.world.gen.feature.*;
import com.teamaurora.frostburn_expansion.common.world.gen.surfacebuilders.GlacierSurfaceBuilder;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionFeatures {

    public static final Feature<BaseTreeFeatureConfig> OLNEYA_TREE = new OlneyaTreeFeature(BaseTreeFeatureConfig.CODEC_BASE_TREE_FEATURE_CONFIG);
    public static final Feature<BaseTreeFeatureConfig> AURORAL_TREE = new AuroralTreeFeature(BaseTreeFeatureConfig.CODEC_BASE_TREE_FEATURE_CONFIG);

    public static final Feature<NotShitOreFeatureConfig> NOT_SHIT_ORE = new NotShitOreFeature(NotShitOreFeatureConfig.field_236566_a_);
    public static final Feature<NoFeatureConfig> ICE_AND_SNOW_NO_BOREALENE = new IceAndSnowNoBorealeneFeature(NoFeatureConfig.field_236558_a_);
    public static final Feature<NoFeatureConfig> GLACIER_FOSSILS = new GlacierFossilsFeature(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> OASIS_GRASS_PLACER = new DesertLakesGrassFeature(NoFeatureConfig.field_236558_a_);

    public static final SurfaceBuilder<SurfaceBuilderConfig> GLACIER = new GlacierSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        event.getRegistry().registerAll(
                OLNEYA_TREE.setRegistryName(FrostburnExpansion.MODID, "olneya_tree"),
                AURORAL_TREE.setRegistryName(FrostburnExpansion.MODID, "auroral_tree"),

                NOT_SHIT_ORE.setRegistryName(FrostburnExpansion.MODID, "better_ore"),
                ICE_AND_SNOW_NO_BOREALENE.setRegistryName(FrostburnExpansion.MODID, "ice_and_snow_modified"),
                GLACIER_FOSSILS.setRegistryName(FrostburnExpansion.MODID, "glacier_fossil"),

                OASIS_GRASS_PLACER.setRegistryName(FrostburnExpansion.MODID, "oasis_grass_placer")
        );
    }

    @SubscribeEvent
    public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        event.getRegistry().registerAll(
                GLACIER.setRegistryName(FrostburnExpansion.MODID, "glacier")
        );
    }

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.forEach(FrostburnExpansionFeatures::generate);
    }

    public static void generate(Biome biome) {
        if (biome == Biomes.SNOWY_TUNDRA || biome == Biomes.SNOWY_MOUNTAINS) {
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
        } else if (biome == Biomes.SNOWY_TAIGA || biome == Biomes.SNOWY_TAIGA_HILLS || biome == Biomes.SNOWY_TAIGA_MOUNTAINS) {
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
            DefaultBiomeFeatures.addSparseBerryBushes(biome);
        }
        if (biome == Biomes.DESERT_LAKES) {
            FrostburnExpansionBiomeFeatures.addDesertLakesFeatures(biome);
        } else if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS) {
            FrostburnExpansionBiomeFeatures.addSparseOlneyaTrees(biome);
        }
    }
}
