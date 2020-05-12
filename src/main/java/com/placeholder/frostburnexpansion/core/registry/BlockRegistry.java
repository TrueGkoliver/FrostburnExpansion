package com.placeholder.frostburnexpansion.core.registry;

import com.placeholder.frostburnexpansion.FrostburnExpansion;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, FrostburnExpansion.MODID);
	public static RegistryObject<Block> genBlock(String id, Block block) {
		BlockItem item = new BlockItem(block, new Item.Properties());
		ItemRegistry.ITEMS.register(id, ()->item);
		return BlockRegistry.BLOCKS.register(id, ()->block);
	}
}
