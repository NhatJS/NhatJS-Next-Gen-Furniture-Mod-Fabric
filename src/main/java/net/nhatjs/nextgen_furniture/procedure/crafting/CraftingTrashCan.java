package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

public class CraftingTrashCan {
    public static ItemStack matches(PlayerEntity player) {
        if (player == null) return ItemStack.EMPTY;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return ItemStack.EMPTY;

        if (rowMatches(h, 0,1,3,4) && othersEmpty(h, 0,1,3,4)) return frameForModern(h.slots.get(0).getStack());
        if (rowMatches(h, 1,2,4,5) && othersEmpty(h, 1,2,4,5)) return frameForModern(h.slots.get(1).getStack());
        if (rowMatches(h, 3,4,6,7) && othersEmpty(h, 3,4,6,7)) return frameForModern(h.slots.get(3).getStack());
        if (rowMatches(h, 4,5,7,8) && othersEmpty(h, 4,5,7,8)) return frameForModern(h.slots.get(4).getStack());

        return ItemStack.EMPTY;
    }

    private static boolean rowMatches(ScreenHandler h, int a, int b, int c, int d) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        ItemStack sd = h.slots.get(d).getStack();
        if (!isModern(sa) || !isModern(sb) || !isModern(sc) || !isModern(sd)) return false;
        return sa.getItem() == sb.getItem()
                && sb.getItem() == sc.getItem()
                && sc.getItem() == sd.getItem();
    }

    private static boolean othersEmpty(ScreenHandler h, int x, int y, int z, int a) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y || i == z || i == a) continue;
            if (!h.slots.get(i).getStack().isEmpty()) return false;
        }
        return true;
    }

    private static boolean isModern(ItemStack s) {
        if (s.isEmpty()) return false;
        Item i = s.getItem();
        return i == Items.BLACK_CONCRETE || i == Items.WHITE_CONCRETE;
    }

    private static ItemStack frameForModern(ItemStack s) {
        if (s.isEmpty()) return ItemStack.EMPTY;
        Item i = s.getItem();

        if (i == Items.BLACK_CONCRETE)      return new ItemStack(ModBlocks.TRASH_CAN_BLACK, 2);
        if (i == Items.WHITE_CONCRETE)    return new ItemStack(ModBlocks.TRASH_CAN_WHITE, 2);

        return ItemStack.EMPTY;
    }
}