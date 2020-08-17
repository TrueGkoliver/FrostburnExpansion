package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.effect.FrailtyEffect;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FrostburnExpansionEffects {


	public static final DeferredRegister<Effect> POTION_EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, FrostburnExpansion.MODID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, FrostburnExpansion.MODID);
	public static final RegistryObject<FrailtyEffect> FRAILTY = POTION_EFFECTS.register("frailty", ()->new FrailtyEffect());
	
	public static final RegistryObject<Potion> POTION_FRAILTY = POTIONS.register("frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 3600)));
	public static final RegistryObject<Potion> POTION_FRAILTY_LONG = POTIONS.register("long_frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 9600)));
	public static final RegistryObject<Potion> POTION_FRAILTY_STRONG = POTIONS.register("strong_frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 1800, 1)));

	@ObjectHolder("quark:resistance")
	public static final Potion POTION_FORTITUDE = null;

	public static void registerBrewingRecipes() {
		PotionBrewing.addMix(Potions.AWKWARD, FrostburnExpansionItems.FROZEN_SPORES.get(), POTION_FRAILTY.get());
		PotionBrewing.addMix(POTION_FRAILTY.get(), Items.GLOWSTONE_DUST, POTION_FRAILTY_STRONG.get());
		PotionBrewing.addMix(POTION_FRAILTY.get(), Items.REDSTONE, POTION_FRAILTY_LONG.get());

		if (POTION_FORTITUDE != null) {
			PotionBrewing.addMix(POTION_FORTITUDE, Items.FERMENTED_SPIDER_EYE, POTION_FRAILTY.get());
		}
	}
}
