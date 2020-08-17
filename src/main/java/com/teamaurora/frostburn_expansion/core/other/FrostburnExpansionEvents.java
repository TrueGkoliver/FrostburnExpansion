package com.teamaurora.frostburn_expansion.core.other;

import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID)
public class FrostburnExpansionEvents {
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof BriskEntity) {
            // code shamelessly stolen from Savage & Ravage since my loot table solution wasn't working
            BriskEntity brisk = (BriskEntity) event.getEntity();
            if (event.getSource().isExplosion()) {
                brisk.entityDropItem(new ItemStack(FrostburnExpansionItems.FROZEN_SPORES.get(), 1 + brisk.world.rand.nextInt(5)));
            }
        }
    }
}
