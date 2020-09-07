package com.teamaurora.frostburn_expansion.common.world.gen.feature;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraftforge.common.IPlantable;

import java.util.*;

public class AuroralTreeFeature extends Feature<BaseTreeFeatureConfig> {
    public AuroralTreeFeature(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean func_230362_a_(ISeedReader worldIn, StructureManager manager, ChunkGenerator generator, Random rand, BlockPos position, BaseTreeFeatureConfig config) {
        int heightOffset = rand.nextInt(3);
        int i = 10 + heightOffset;
        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
            boolean flag = false;
            for (int x = -2; x <= 2; x++) {
                for (int y = 0; y <= i + 1; y++) {
                    for (int z = -2; z <= 2; z++) {
                        if (((Math.abs(x) != 2 || Math.abs(z) != 2) && y >= 3) || ((x == 0 && z == 0))) {
                            if (!isAirOrLeaves(worldIn, position.add(x, y, z))) {
                                flag = true;
                            }
                        }
                    }
                }
            }
            if (flag) {
                return false;
            } else {
                if (isValidGround(worldIn, position.down())) {
                    List<BlockPos> logPos = new ArrayList<>();
                    List<BlockPos> leafPos = new ArrayList<>();
                    setDirtAt(worldIn, position.down());

                    for (int j = 0; j < i; j++) {
                        placeLogAt(worldIn, position.up(j), rand, config, logPos);
                    }

                    placeLeafAt(worldIn, position.up(i + 1), rand, config, leafPos);
                    placeSmallRingAt(worldIn, position.up(i), rand, config, leafPos);
                    placeSmallDiscAt(worldIn, position.up(i-1), rand, config, leafPos);

                    placeLargeRingAt(worldIn, position.up(i-2), rand, config, leafPos);
                    placeLargeDiscAt(worldIn, position.up(i-3), rand, config, leafPos);
                    placeLargeRingAt(worldIn, position.up(i-4), rand, config, leafPos);
                    placeLargeDiscAt(worldIn, position.up(i-5), rand, config, leafPos);
                    placeLargeRingAt(worldIn, position.up(i-6), rand, config, leafPos);
                    placeLargeDiscAt(worldIn, position.up(i-7), rand, config, leafPos);

                    placeSmallRingAt(worldIn, position.up(i-8), rand, config, leafPos);

                    Set<BlockPos> decSet = Sets.newHashSet();
                    MutableBoundingBox mutableBoundingBox = MutableBoundingBox.getNewBoundingBox();
                    if (!config.decorators.isEmpty()) {
                        logPos.sort(Comparator.comparingInt(Vector3i::getY));
                        leafPos.sort(Comparator.comparingInt(Vector3i::getY));
                        config.decorators.forEach((decorator)->{
                            decorator.func_225576_a_(worldIn, rand, logPos, leafPos, decSet, mutableBoundingBox);
                        });
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private void placeSmallRingAt(ISeedReader worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaf) {
        placeLeafAt(worldIn, pos, rand, config, leaf);
        placeLeafAt(worldIn, pos.north(), rand, config, leaf);
        placeLeafAt(worldIn, pos.east(), rand, config, leaf);
        placeLeafAt(worldIn, pos.south(), rand, config, leaf);
        placeLeafAt(worldIn, pos.west(), rand, config, leaf);
    }

    private void placeSmallDiscAt(ISeedReader worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaf) {
        placeSmallRingAt(worldIn, pos, rand, config, leaf);
        placeRandomLeafAt(worldIn, pos.add(-1, 0, -1), rand, config, leaf);
        placeRandomLeafAt(worldIn, pos.add(-1, 0, 1), rand, config, leaf);
        placeRandomLeafAt(worldIn, pos.add(1, 0, -1), rand, config, leaf);
        placeRandomLeafAt(worldIn, pos.add(1, 0, 1), rand, config, leaf);
    }

    private void placeLargeRingAt(ISeedReader worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaf) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if ((Math.abs(x) == 2 && Math.abs(z) == 1) || (Math.abs(z) == 2 && Math.abs(x) == 1)) {
                    placeRandomLeafAt(worldIn, pos.add(x, 0, z), rand, config, leaf);
                } else if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    placeLeafAt(worldIn, pos.add(x, 0, z), rand, config, leaf);
                }
            }
        }
    }

    private void placeLargeDiscAt(ISeedReader worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaf) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    placeLeafAt(worldIn, pos.add(x, 0, z), rand, config, leaf);
                }
            }
        }
    }

    private void placeLogAt(IWorldWriter worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> log) {
        this.setLogState(worldIn, pos, config.trunkProvider.getBlockState(rand, pos));
        log.add(pos);
    }

    private void placeRandomLeafAt(IWorldGenerationReader world, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaves) {
        if (rand.nextBoolean()) {
            placeLeafAt(world, pos, rand, config, leaves);
        }
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Random rand, BaseTreeFeatureConfig config, List<BlockPos> leaves)
    {
        if (isAirOrLeaves(world, pos))
        {
            this.setLogState(world, pos, config.leavesProvider.getBlockState(rand, pos).with(LeavesBlock.DISTANCE, 1));
            leaves.add(pos);
        }
    }

    protected final void setLogState(IWorldWriter worldIn, BlockPos pos, BlockState state) {
        worldIn.setBlockState(pos, state, 18);
    }

    public static boolean isAir(IWorldGenerationBaseReader worldIn, BlockPos pos)
    {
        if (!(worldIn instanceof net.minecraft.world.IBlockReader))
        {
            return worldIn.hasBlockState(pos, BlockState::isAir);
        }
        else
        {
            return worldIn.hasBlockState(pos, state -> state.isAir((net.minecraft.world.IBlockReader) worldIn, pos));
        }
    }

    public static boolean isAirOrLeaves(IWorldGenerationBaseReader worldIn, BlockPos pos)
    {
        if (worldIn instanceof net.minecraft.world.IWorldReader)
        {
            return worldIn.hasBlockState(pos, state -> state.canBeReplacedByLeaves((net.minecraft.world.IWorldReader) worldIn, pos));
        }
        return worldIn.hasBlockState(pos, (state) -> {
            return state.isAir() || state.isIn(BlockTags.LEAVES) || state.getBlock() == Blocks.SNOW;
        });
    }

    public static void setDirtAt(IWorld worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block == Blocks.GRASS_BLOCK || block == Blocks.FARMLAND)
        {
            worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState(), 18);
        }
    }

    public static boolean isValidGround(IWorld world, BlockPos pos)
    {
        return world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (IPlantable) Blocks.BIRCH_SAPLING);
    }
}