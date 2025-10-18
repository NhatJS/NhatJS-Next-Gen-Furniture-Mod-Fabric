package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingPictureFrame {
    public static boolean matches(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.OAK_PLANKS) && sb.isOf(Items.PAINTING) && sc.isOf(Items.OAK_PLANKS);
    }

    private static boolean othersEmpty(ScreenHandler h, int x, int y, int z) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y || i == z) continue;
            if (!h.slots.get(i).getStack().isEmpty()) return false;
        }
        return true;
    }
}