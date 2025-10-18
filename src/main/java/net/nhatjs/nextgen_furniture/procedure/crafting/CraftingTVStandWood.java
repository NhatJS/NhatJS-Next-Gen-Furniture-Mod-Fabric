package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

public class CraftingTVStandWood {
    public static ItemStack matches(PlayerEntity player) {
        if (player == null) return ItemStack.EMPTY;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return ItemStack.EMPTY;

        if (rowMatches(h, 0,1,2,3,4,5) && othersEmpty(h, 0,1,2,3,4,5))
            return frameForWood(h.slots.get(0).getStack());
        if (rowMatches(h, 3,4,5,6,7,8) && othersEmpty(h, 3,4,5,6,7,8))
            return frameForWood(h.slots.get(3).getStack());

        return ItemStack.EMPTY;
    }

    private static boolean rowMatches(ScreenHandler h, int a, int b, int c, int d, int e, int f) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        ItemStack sd = h.slots.get(d).getStack();
        ItemStack se = h.slots.get(e).getStack();
        ItemStack sf = h.slots.get(f).getStack();
        if (!isPlank(sa) || !isPlank(sb) || !isPlank(sc) || !isPlank(sd) || !isPlank(sf)) return false;
        if (!se.isOf(Items.CHEST)) return false;
        return sa.getItem() == sb.getItem()
                && sb.getItem() == sc.getItem()
                && sc.getItem() == sd.getItem()
                && sd.getItem() == sf.getItem();
    }

    private static boolean othersEmpty(ScreenHandler h, int x, int y, int z, int a, int b, int c) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y || i == z || i == a || i == b || i == c) continue;
            if (!h.slots.get(i).getStack().isEmpty()) return false;
        }
        return true;
    }

    private static boolean isPlank(ItemStack s) {
        if (s.isEmpty()) return false;
        Item i = s.getItem();
        return i == Items.OAK_PLANKS || i == Items.BIRCH_PLANKS;
    }

    private static ItemStack frameForWood(ItemStack s) {
        if (s.isEmpty()) return ItemStack.EMPTY;
        Item i = s.getItem();

        if (i == Items.OAK_PLANKS)      return new ItemStack(ModBlocks.TV_STAND_WOOD_OAK);
        if (i == Items.BIRCH_PLANKS)    return new ItemStack(ModBlocks.TV_STAND_WOOD_BIRCH);

        return ItemStack.EMPTY;
    }
}