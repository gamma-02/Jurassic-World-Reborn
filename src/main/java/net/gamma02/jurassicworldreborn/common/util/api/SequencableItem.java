package net.gamma02.jurassicworldreborn.common.util.api;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public interface SequencableItem extends RebornIngredientItem {
    static SequencableItem getSequencableItem(ItemStack stack) {
        if (stack != null) {
            Item item = stack.getItem();

            if (item instanceof BlockItem blockItem) {
                Block block = blockItem.getBlock();

                if (block instanceof SequencableItem) {
                    return (SequencableItem) block;
                }
            } else if (item instanceof SequencableItem) {
                return (SequencableItem) item;
            }
        }

        return null;
    }

    static boolean isSequencableItem(ItemStack stack) {
        return getSequencableItem(stack) != null;
    }

    static int randomQuality(RandomSource rand) {
        return (rand.nextInt(20) + 1) * 5;
    }

    boolean isSequencable(ItemStack stack);

    ItemStack getSequenceOutput(ItemStack stack, RandomSource random);
}
