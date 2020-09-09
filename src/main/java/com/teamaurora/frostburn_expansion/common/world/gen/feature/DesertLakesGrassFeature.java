package com.teamaurora.frostburn_expansion.common.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.dispenser.IPosition;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class DesertLakesGrassFeature extends Feature<NoFeatureConfig> {
    public DesertLakesGrassFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_230362_a_(ISeedReader worldIn, StructureManager manager, ChunkGenerator generator, Random rand, BlockPos position, NoFeatureConfig config) {
        boolean flag = false;
        if (position.getY() >= 5 && position.getY() <= worldIn.getHeight() - 5) {
            boolean water = false;
            for (BlockPos pos : BlockPos.getAllInBoxMutable(position.add(-4, -4, -4), position.add(4, 4, 4))) {
                if (pos.withinDistance(position, 4.0F)) {
                    if (worldIn.getBlockState(pos).getBlock() == Blocks.WATER) {
                        water = true;
                    }
                }
            }
            if (water) {
                for (BlockPos pos : BlockPos.getAllInBoxMutable(position.add(-4, -4, -4), position.add(4, 4, 4))) {
                    if (pos.withinDistance(position, 4.0F)) {
                        if (worldIn.isAirBlock(pos.up()) && worldIn.getBlockState(pos).getBlock() == Blocks.SAND) {
                            int chanceThing = (int)Math.ceil(Math.sqrt(pos.distanceSq(pos.getX(), pos.getY(), pos.getZ(), true)));
                            if (chanceThing < 1) chanceThing = 1;
                            if (rand.nextInt(chanceThing) == 0) {
                                worldIn.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState(), 2);
                            }
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        } else {
            return false;
        }
    }
}