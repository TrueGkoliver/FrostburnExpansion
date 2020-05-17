package com.teamaurora.frostburnexpansion.core.registry;

import com.teamabnormals.abnormals_core.common.blocks.AbnormalsStairsBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.StrippedLogBlock;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.core.data.FrostburnExpansionProperties;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionBlocks {

	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;

	///////////////////////////////////////////////////////////////////////////////////////////////

	public static final RegistryObject<Block> BOREALENE = HELPER.createBlock("borealene", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_SLAB = HELPER.createBlock("borealene_slab", ()->new SlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_STAIRS = HELPER.createBlock("borealene_stairs", ()->new AbnormalsStairsBlock(BOREALENE.get().getDefaultState(),FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICKS = HELPER.createBlock("borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_SLAB = HELPER.createBlock("borealene_brick_slab", ()->new SlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_STAIRS = HELPER.createBlock("borealene_brick_stairs", ()->new AbnormalsStairsBlock(BOREALENE_BRICKS.get().getDefaultState(),FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_WALL = HELPER.createBlock("borealene_brick_wall", ()->new WallBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CRACKED_BOREALENE_BRICKS = HELPER.createBlock("cracked_borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_BOREALENE_BRICKS = HELPER.createBlock("chiseled_borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_PILLAR = HELPER.createBlock("borealene_pillar", ()->new RotatedPillarBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_LAMP = HELPER.createBlock("borealene_lamp", ()->new Block(FrostburnExpansionProperties.BOREALENE.lightValue(14)), ItemGroup.BUILDING_BLOCKS);

	public static final RegistryObject<Block> SNOW_BRICKS = HELPER.createBlock("snow_bricks", ()->new Block(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> SNOW_BRICK_SLAB = HELPER.createBlock("snow_brick_slab", ()->new SlabBlock(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> SNOW_BRICK_STAIRS = HELPER.createBlock("snow_brick_stairs", ()->new AbnormalsStairsBlock(SNOW_BRICKS.get().getDefaultState(),Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> SNOW_BRICK_WALL = HELPER.createBlock("snow_brick_wall", ()->new WallBlock(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_SNOW_BRICKS = HELPER.createBlock("chiseled_snow_bricks", ()->new Block(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
}
