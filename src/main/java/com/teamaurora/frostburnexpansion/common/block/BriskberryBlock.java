package com.teamaurora.frostburnexpansion.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BriskberryBlock extends BushBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	public static final IntegerProperty TICKSLEFT = IntegerProperty.create("time_until_explosion", 0, 12000);
	protected BriskberryBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(AGE);
		builder.add(TICKSLEFT);
	}

	@Override
	public boolean canGrow(IBlockReader arg0, BlockPos arg1, BlockState arg2, boolean arg3) {
		return false;
	}
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      super.tick(state, worldIn, pos, rand);
      int i = state.get(AGE);
      if (i < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0)) {
    	 worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
         net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
      }
      if (i>=3) {
      	worldIn.setBlockState(pos, state.with(TICKSLEFT, state.get(TICKSLEFT)-1));
	  }
	}
	@Override
	public boolean canUseBonemeal(World arg0, Random arg1, BlockPos arg2, BlockState arg3) {
		return false;
	}

	@Override
	public void grow(ServerWorld world, Random arg1, BlockPos pos, BlockState state) {
		 int i = Math.min(3, state.get(AGE) + 1);
		 world.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}

}
