package com.teamaurora.frostburn_expansion.core.other;

import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FrostburnExpansionItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onInteractWithBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        if (event.getWorld().getBlockState(pos).getBlock() == Blocks.FLOWER_POT && item == FrostburnExpansionItems.FROZEN_SPORES.get()) {
            event.getWorld().setBlockState(pos, FrostburnExpansionBlocks.POTTED_BRISK.get().getDefaultState());
            event.getPlayer().swingArm(event.getHand());
            player.addStat(Stats.POT_FLOWER);
            if (!event.getPlayer().abilities.isCreativeMode) {
                itemStack.shrink(1);
            }
        }
    }
}
