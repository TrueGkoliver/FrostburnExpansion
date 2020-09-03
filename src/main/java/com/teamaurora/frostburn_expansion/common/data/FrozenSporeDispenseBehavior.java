package com.teamaurora.frostburn_expansion.common.data;

import com.teamaurora.frostburn_expansion.common.entity.FrozenSporesEntity;
import com.teamaurora.frostburn_expansion.common.item.FrozenSporesItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrozenSporeDispenseBehavior extends OptionalDispenseBehavior {
    @SuppressWarnings("deprecation")
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        this.setSuccessful(false);
        Item item = stack.getItem();
        if (item instanceof FrozenSporesItem) {
            Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            World worldIn = source.getWorld().getWorld();
            BlockPos pos = source.getBlockPos().offset(direction);
            if (!worldIn.isRemote) {
                FrozenSporesEntity blossom = new FrozenSporesEntity(worldIn, pos.getX(), pos.getY(), pos.getZ());
                blossom.setItem(stack);
                blossom.shoot((double)direction.getXOffset(), (double)((float)direction.getYOffset() + 0.1F), (double)direction.getZOffset(), 1.1F, 6.0F);

                worldIn.addEntity(blossom);
            }
            stack.shrink(1);
            this.setSuccessful(true);
        }
        return stack;
    }
}
