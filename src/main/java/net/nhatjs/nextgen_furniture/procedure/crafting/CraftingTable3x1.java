package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

public class CraftingTable3x1 {
    public static boolean black3x1(PlayerEntity player) {
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
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_BLACK.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    public static boolean black3x1alt(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches2(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches2(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches2(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches2(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_BLACK_ALT.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    public static boolean black3x1alt2(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches3(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches3(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches3(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches3(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_BLACK_ALT_2.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    public static boolean white3x1(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches4(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches4(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches4(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches4(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_WHITE.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    public static boolean white3x1alt(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches5(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches5(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches5(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches5(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_WHITE_ALT.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    public static boolean white3x1alt2(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        if (rowMatches6(h, 0,1,2) && othersEmpty(h, 0,1,2)) return true;
        if (rowMatches6(h, 3,4,5) && othersEmpty(h, 3,4,5)) return true;
        if (rowMatches6(h, 6,7,8) && othersEmpty(h, 6,7,8)) return true;

        return false;
    }

    private static boolean rowMatches6(ScreenHandler h, int a, int b, int c) {
        ItemStack sa = h.slots.get(a).getStack();
        ItemStack sb = h.slots.get(b).getStack();
        ItemStack sc = h.slots.get(c).getStack();
        return sa.isOf(Items.BLACK_CONCRETE) && sb.isOf(ModBlocks.TABLE_2X1_WHITE_ALT_2.asItem()) && sc.isOf(Items.BLACK_CONCRETE);
    }

    private static boolean othersEmpty(ScreenHandler h, int x, int y, int z) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y || i == z) continue;
            if (!h.slots.get(i).getStack().isEmpty()) return false;
        }
        return true;
    }
}