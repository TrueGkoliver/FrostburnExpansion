package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.item.BrisksongDiscItem;
import com.teamaurora.frostburn_expansion.common.item.FrozenSporesItem;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionItems {

	public static final RegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER;

	public static final RegistryObject<Item> BRISK_SPAWN_EGG = HELPER.createSpawnEggItem("brisk", ()->FrostburnExpansionEntities.BRISK.get(), 0x84D6DB, 0x359289);
	public static final RegistryObject<Item> FROZEN_SPORES = HELPER.createItem("frozen_spores", ()->new FrozenSporesItem(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> BRISKSONG_RECORD = HELPER.createItem("music_disc_brisksong", ()->new BrisksongDiscItem(14, ()->FrostburnExpansionSounds.BRISKSONG, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> AURORAL_BOAT = HELPER.createBoatItem("auroral", FrostburnExpansionBlocks.AURORAL_PLANKS);
	public static final RegistryObject<Item> OLNEYA_BOAT = HELPER.createBoatItem("olneya", FrostburnExpansionBlocks.OLNEYA_PLANKS);

	public static final RegistryObject<Item> ANCIENT_CLOTH = HELPER.createItem("ancient_cloth", ()->new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
}
