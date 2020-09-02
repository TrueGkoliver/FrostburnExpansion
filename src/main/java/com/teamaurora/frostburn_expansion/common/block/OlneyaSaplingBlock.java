package com.teamaurora.frostburn_expansion.common.block;

import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsSaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.Tags;

public class OlneyaSaplingBlock extends AbnormalsSaplingBlock {
    public OlneyaSaplingBlock(Tree tree, Properties properties) {
        super(tree, properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(Tags.Blocks.SAND) || super.isValidGround(state, worldIn, pos);
    }
}
