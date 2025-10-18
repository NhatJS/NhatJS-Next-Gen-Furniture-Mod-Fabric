package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingCoffeeTableWhite {
    public static boolean matches(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches(h, 0,1,2,3,5) && othersEmpty(h, 0,1,2,3,5)) return true;
        if (rowMatches(h, 3,4,5,6,8) && othersEmpty(h, 3,4,5,6,8)) return true;

        return false;
    }

    private static boolean rowMatches(ScreenHandler h, int a, int b, int c, int d, int e) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        ItemStack sd = h.slots.get(d).getStack();
        ItemStack se = h.slots.get(e).getStack();
        Item item = Items.WHITE_CONCRETE;
        return sa.isOf(item) && sb.isOf(item) && sc.isOf(item) && sd.isOf(item) && se.isOf(item);
    }

    private static boolean othersEmpty(ScreenHandler h, int x, int y, int z, int a, int b) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y || i == z || i == a || i == b) continue;
            if (!h.slots.get(i).getStack().isEmpty()) return false;
        }
        return true;
    }
}