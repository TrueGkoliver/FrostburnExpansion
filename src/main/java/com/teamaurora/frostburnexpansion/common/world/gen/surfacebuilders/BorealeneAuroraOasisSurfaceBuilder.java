package com.teamaurora.frostburnexpansion.common.world.gen.surfacebuilders;

import com.mojang.datafixers.Dynamic;
import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionBlocks;
import com.teamaurora.frostburnexpansion.core.registry.FrostburnExpansionFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class BorealeneAuroraOasisSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public BorealeneAuroraOasisSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
        super(function);
    }

    @Override
    public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig surfaceBlocks) {
        if (noise < 2.0D) {
            FrostburnExpansionFeatures.AURORA_OASIS.buildSurface(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
        } else {
            BlockState state = FrostburnExpansionBlocks.BOREALENE.get().getDefaultState();
            FrostburnExpansionFeatures.AURORA_OASIS.buildSurface(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(state, state, state));
        }
    }
}