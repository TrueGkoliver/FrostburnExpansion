package com.teamaurora.frostburn_expansion.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.abnormals_core.common.blocks.*;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.*;
import com.teamaurora.frostburn_expansion.common.block.ImprovedFlowerPotBlock;
import com.teamaurora.frostburn_expansion.common.block.OlneyaSaplingBlock;
import com.teamaurora.frostburn_expansion.common.world.gen.trees.AuroralTree;
import com.teamaurora.frostburn_expansion.common.world.gen.trees.OlneyaTree;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import com.teamaurora.frostburn_expansion.core.other.FrostburnExpansionProperties;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionBlocks {

	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;

	//////////////////////////////////////TUNDRA CONTENT//////////////////////////////////////////////

	// Snow Bricks
	public static final RegistryObject<Block> LARGE_SNOW_BRICKS = HELPER.createBlock("large_snow_bricks", ()->new Block(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> LARGE_SNOW_BRICK_SLAB = HELPER.createBlock("large_snow_brick_slab", ()->new SlabBlock(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> LARGE_SNOW_BRICK_STAIRS = HELPER.createBlock("large_snow_brick_stairs", ()->new AbnormalsStairsBlock(LARGE_SNOW_BRICKS.get().getDefaultState(),Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> LARGE_SNOW_BRICK_WALL = HELPER.createBlock("large_snow_brick_wall", ()->new WallBlock(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_LARGE_SNOW_BRICKS = HELPER.createBlock("chiseled_large_snow_bricks", ()->new Block(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);

	public static final RegistryObject<Block> LARGE_SNOW_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "large_snow_brick_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.SNOW_BLOCK)), ItemGroup.BUILDING_BLOCKS);

	// Frozen Spore stuff
	public static final RegistryObject<Block> POTTED_BRISK = HELPER.createBlockNoItem("potted_frozen_spores", ()->new ImprovedFlowerPotBlock(FrostburnExpansionItems.FROZEN_SPORES, AbstractBlock.Properties.from(Blocks.FLOWER_POT)));
	public static final RegistryObject<Block> FROZEN_SPORE_SACK = HELPER.createCompatBlock("quark", "frozen_spore_sack", ()->new Block(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);

	//////////////////////////////////AURORA GLACIER CONTENT//////////////////////////////////////////

	// Borealene
	public static final RegistryObject<Block> BOREALENE = HELPER.createBlock("borealene", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_SLAB = HELPER.createBlock("borealene_slab", ()->new SlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_STAIRS = HELPER.createBlock("borealene_stairs", ()->new AbnormalsStairsBlock(BOREALENE.get().getDefaultState(),FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_WALL = HELPER.createBlock("borealene_wall", ()->new WallBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICKS = HELPER.createBlock("borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_SLAB = HELPER.createBlock("borealene_brick_slab", ()->new SlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_STAIRS = HELPER.createBlock("borealene_brick_stairs", ()->new AbnormalsStairsBlock(BOREALENE_BRICKS.get().getDefaultState(),FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_WALL = HELPER.createBlock("borealene_brick_wall", ()->new WallBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CRACKED_BOREALENE_BRICKS = HELPER.createBlock("cracked_borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_BOREALENE_BRICKS = HELPER.createBlock("chiseled_borealene_bricks", ()->new Block(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_PILLAR = HELPER.createBlock("borealene_pillar", ()->new RotatedPillarBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_LAMP = HELPER.createBlock("borealene_lamp", ()->new Block(FrostburnExpansionProperties.BOREALENE.setLightLevel((p_235464_0_) -> { return 14; })), ItemGroup.BUILDING_BLOCKS);

	public static final RegistryObject<Block> BOREALENE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "borealene_vertical_slab", ()->new VerticalSlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOREALENE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "borealene_brick_vertical_slab", ()->new VerticalSlabBlock(FrostburnExpansionProperties.BOREALENE), ItemGroup.BUILDING_BLOCKS);

	// Auroral Wood
	public static final RegistryObject<Block> STRIPPED_AURORAL_LOG = HELPER.createBlock("stripped_auroral_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> STRIPPED_AURORAL_WOOD = HELPER.createBlock("stripped_auroral_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_LOG= HELPER.createBlock("auroral_log", ()->new AbnormalsLogBlock(STRIPPED_AURORAL_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_WOOD = HELPER.createBlock("auroral_wood", ()->new WoodBlock(STRIPPED_AURORAL_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_LEAVES = HELPER.createBlock("auroral_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> AURORAL_SAPLING = HELPER.createBlock("auroral_sapling", ()->new AbnormalsSaplingBlock(new AuroralTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> POTTED_AURORAL_SAPLING = HELPER.createBlockNoItem("potted_auroral_sapling", ()->new FlowerPotBlock(AURORAL_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
	public static final RegistryObject<Block> AURORAL_PLANKS = HELPER.createBlock("auroral_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_SLAB = HELPER.createBlock("auroral_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_STAIRS = HELPER.createBlock("auroral_stairs", ()->new WoodStairsBlock(AURORAL_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_PRESSURE_PLATE = HELPER.createBlock("auroral_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_FENCE = HELPER.createBlock("auroral_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> AURORAL_FENCE_GATE = HELPER.createBlock("auroral_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_BUTTON = HELPER.createBlock("auroral_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_DOOR = HELPER.createBlock("auroral_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> AURORAL_TRAPDOOR = HELPER.createBlock("auroral_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
	public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> AURORAL_SIGNS = HELPER.createSignBlock("auroral", MaterialColor.PURPLE_TERRACOTTA);

	public static final RegistryObject<Block> AURORAL_BOOKSHELF = HELPER.createCompatBlock("quark", "auroral_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> VERTICAL_AURORAL_PLANKS = HELPER.createCompatBlock("quark", "vertical_auroral_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "auroral_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> AURORAL_LADDER = HELPER.createCompatBlock("quark", "auroral_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> AURORAL_LEAF_CARPET = HELPER.createCompatBlock("quark", "auroral_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(AURORAL_LEAVES.get())), ItemGroup.DECORATIONS);
	public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> AURORAL_CHESTS = HELPER.createCompatChestBlocks("auroral", MaterialColor.PURPLE_TERRACOTTA);

	public static final RegistryObject<Block> AURORAL_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "auroral_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

	/////////////////////////////////////DESERT CONTENT///////////////////////////////////////////////

	///////////////////////////////////DESERT LAKES CONTENT///////////////////////////////////////////

	// Olenya Wood
	public static final RegistryObject<Block> STRIPPED_OLNEYA_LOG = HELPER.createBlock("stripped_olneya_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> STRIPPED_OLNEYA_WOOD = HELPER.createBlock("stripped_olneya_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_LOG= HELPER.createBlock("olneya_log", ()->new AbnormalsLogBlock(STRIPPED_OLNEYA_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_WOOD = HELPER.createBlock("olneya_wood", ()->new WoodBlock(STRIPPED_OLNEYA_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_LEAVES = HELPER.createBlock("olneya_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> OLNEYA_SAPLING = HELPER.createBlock("olneya_sapling", ()->new OlneyaSaplingBlock(new OlneyaTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> POTTED_OLNEYA_SAPLING = HELPER.createBlockNoItem("potted_olneya_sapling", ()->new FlowerPotBlock(OLNEYA_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
	public static final RegistryObject<Block> OLNEYA_PLANKS = HELPER.createBlock("olneya_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_SLAB = HELPER.createBlock("olneya_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_STAIRS = HELPER.createBlock("olneya_stairs", ()->new WoodStairsBlock(OLNEYA_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_PRESSURE_PLATE = HELPER.createBlock("olneya_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> OLNEYA_FENCE = HELPER.createBlock("olneya_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> OLNEYA_FENCE_GATE = HELPER.createBlock("olneya_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> OLNEYA_BUTTON = HELPER.createBlock("olneya_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> OLNEYA_DOOR = HELPER.createBlock("olneya_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
	public static final RegistryObject<Block> OLNEYA_TRAPDOOR = HELPER.createBlock("olneya_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
	public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> OLNEYA_SIGNS = HELPER.createSignBlock("olneya", MaterialColor.PURPLE_TERRACOTTA);

	public static final RegistryObject<Block> OLNEYA_BOOKSHELF = HELPER.createCompatBlock("quark", "olneya_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> VERTICAL_OLNEYA_PLANKS = HELPER.createCompatBlock("quark", "vertical_olneya_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "olneya_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> OLNEYA_LADDER = HELPER.createCompatBlock("quark", "olneya_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> OLNEYA_LEAF_CARPET = HELPER.createCompatBlock("quark", "olneya_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(OLNEYA_LEAVES.get())), ItemGroup.DECORATIONS);
	public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> OLNEYA_CHESTS = HELPER.createCompatChestBlocks("olneya", MaterialColor.PURPLE_TERRACOTTA);

	public static final RegistryObject<Block> OLNEYA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "olneya_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);


	}
