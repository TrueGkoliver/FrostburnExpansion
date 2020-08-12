package com.teamaurora.frostburn_expansion.common.item;

import com.teamabnormals.abnormals_core.core.utils.NetworkUtil;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BrisksongDiscItem extends MusicDiscItem {

	public BrisksongDiscItem(int comparatorValueIn, SoundEvent soundIn, Properties builder) {
		super(comparatorValueIn, soundIn, builder);
	}
	public ActionResultType onItemUse(ItemUseContext context) {
	      World world = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      BlockState blockstate = world.getBlockState(blockpos);
	      if (blockstate.getBlock() == Blocks.JUKEBOX && !blockstate.get(JukeboxBlock.HAS_RECORD)) {
	         ItemStack itemstack = context.getItem();
	         if (!world.isRemote) {
	            ((JukeboxBlock)Blocks.JUKEBOX).insertRecord(world, blockpos, blockstate, itemstack);
	            world.playEvent((PlayerEntity)null, 1010, blockpos, Item.getIdFromItem(this));
	            itemstack.shrink(1);
	            world.getEntitiesWithinAABB(BriskEntity.class, new AxisAlignedBB(new BlockPos(blockpos)).grow(3.0D)).forEach(entity -> {
					if (entity.isNoEndimationPlaying()) {
						entity.setIsDancing(true);
						System.out.println(entity.getIsDancing());
						NetworkUtil.setPlayingAnimationMessage(entity, (BriskEntity.DANCE));
						System.out.println(entity.getIsDancing());
					}
			    });
	            
	            PlayerEntity playerentity = context.getPlayer();
	            if (playerentity != null) {
	               playerentity.addStat(Stats.PLAY_RECORD);
	            }
	         } else {
	        	 world.getEntitiesWithinAABB(BriskEntity.class, new AxisAlignedBB(new BlockPos(blockpos)).grow(3.0D)).forEach(entity -> {
	        		 entity.setIsDancing(true);
		        	 NetworkUtil.setPlayingAnimationMessage(entity, (BriskEntity.DANCE));
	        	 });
	        	 
	        	 
	         }

	         return ActionResultType.SUCCESS;
	      } else {
	         return ActionResultType.PASS;
	      }
	   }
	
	
}
