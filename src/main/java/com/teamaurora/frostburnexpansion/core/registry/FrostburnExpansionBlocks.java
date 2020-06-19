package com.teamaurora.frostburnexpansion.core.registry;

import com.teamabnormals.abnormals_core.common.blocks.AbnormalsStairsBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.*;
import com.teamaurora.frostburnexpansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburnexpansion.core.data.FrostburnExpansionProperties;
import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionBlocks {

	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;

	///////////////////////////////////////////////////////////////////////////////////////////////pls styop being buggy

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

	public static final RegistryObject<Block> STRIPPED_AURORAL_LOG = HELPER.createBlock("stripped_auroral_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_LOG= HELPER.createBlock("auroral_log", ()->new AbnormalsLogBlock(STRIPPED_AURORAL_LOG, MaterialColor.PURPLE, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> STRIPPED_AURORAL_WOOD = HELPER.createBlock("stripped_auroral_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_WOOD = HELPER.createBlock("auroral_wood", ()->new WoodBlock(STRIPPED_AURORAL_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_PLANKS = HELPER.createBlock("auroral_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_SLAB = HELPER.createBlock("auroral_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_STAIRS = HELPER.createBlock("auroral_stairs", ()->new WoodStairsBlock(AURORAL_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_PRESSURE_PLATE = HELPER.createBlock("auroral_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_FENCE = HELPER.createBlock("auroral_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> AURORAL_FENCE_GATE = HELPER.createBlock("auroral_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_BUTTON = HELPER.createBlock("auroral_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
}
