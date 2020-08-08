package com.teamaurora.frostburn_expansion.core.registry;

import com.teamaurora.frostburn_expansion.common.effect.FrailtyEffect;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostburnExpansionEffects {

	public static final DeferredRegister<Effect> POTION_EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, FrostburnExpansion.MODID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, FrostburnExpansion.MODID);
	public static final RegistryObject<FrailtyEffect> FRAILTY = POTION_EFFECTS.register("fraility", ()->new FrailtyEffect());
	
	public static final RegistryObject<Potion> POTION_FRAILTY = POTIONS.register("frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 3600)));
	public static final RegistryObject<Potion> POTION_FRAILTY_LONG = POTIONS.register("long_frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 9600)));
	public static final RegistryObject<Potion> POTION_FRAILTY_STRONG = POTIONS.register("strong_frailty", ()->new Potion(new EffectInstance(FRAILTY.get(), 1800, 1)));
}
