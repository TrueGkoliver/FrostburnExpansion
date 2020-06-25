package com.teamaurora.frostburnexpansion.common.other;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BriskBerryExplosion extends Explosion {

	public BriskBerryExplosion(World worldIn, Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn,
			boolean causesFireIn, Mode modeIn) {
		super(worldIn, exploderIn, xIn, yIn, zIn, sizeIn, causesFireIn, modeIn);
	}
	
	
	@Override
	public void doExplosionA() {
		Set<BlockPos> set = Sets.newHashSet();
	      int i = 16;

	      for(int j = 0; j < 16; ++j) {
	         for(int k = 0; k < 16; ++k) {
	            for(int l = 0; l < 16; ++l) {
	               if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
	                  double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
	                  double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
	                  double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
	                  double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	                  d0 = d0 / d3;
	                  d1 = d1 / d3;
	                  d2 = d2 / d3;
	                  float f = this.size * (0.7F + this.world.rand.nextFloat() * 0.6F);
	                  double d4 = this.x;
	                  double d6 = this.y;
	                  double d8 = this.z;

	                  for(float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
	                     BlockPos blockpos = new BlockPos(d4, d6, d8);
	                     BlockState blockstate = this.world.getBlockState(blockpos);
	                     IFluidState ifluidstate = this.world.getFluidState(blockpos);
	                     if (!blockstate.isAir(this.world, blockpos) || !ifluidstate.isEmpty()) {
	                        float f2 = Math.max(blockstate.getExplosionResistance(this.world, blockpos, exploder, this), ifluidstate.getExplosionResistance(this.world, blockpos, exploder, this));
	                        if (this.exploder != null) {
	                           f2 = this.exploder.getExplosionResistance(this, this.world, blockpos, blockstate, ifluidstate, f2);
	                        }

	                        f -= (f2 + 0.3F) * 0.3F;
	                     }

	                     if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this, this.world, blockpos, blockstate, f))) {
	                        set.add(blockpos);
	                     }

	                     d4 += d0 * (double)0.3F;
	                     d6 += d1 * (double)0.3F;
	                     d8 += d2 * (double)0.3F;
	                  }
	               }
	            }
	         }
	}

}
