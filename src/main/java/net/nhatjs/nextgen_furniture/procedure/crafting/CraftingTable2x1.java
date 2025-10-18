package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingTable2x1 {
    public static boolean black2x1(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        ItemStack s0 = h.slots.get(0).getStack();
        ItemStack s1 = h.slots.get(1).getStack();
        ItemStack s2 = h.slots.get(2).getStack();
        ItemStack s3 = h.slots.get(3).getStack();
        ItemStack s4 = h.slots.get(4).getStack();
        ItemStack s5 = h.slots.get(5).getStack();
        ItemStack s6 = h.slots.get(6).getStack();
        ItemStack s7 = h.slots.get(7).getStack();
        ItemStack s8 = h.slots.get(8).getStack();

        Item item = Items.WHITE_CONCRETE;
        Item item2 = Items.BLACK_CONCRETE;

        return
                s0.isOf(item2) && s1.isOf(item2) && s2.isOf(item2) &&
                s3.isOf(item2) && s4.isEmpty() && s5.isOf(item2) &&
                s6.isOf(item) && s7.isEmpty() && s8.isOf(item);
    }

    public static boolean white2x1(PlayerEntity player) {
        if (player == null) return false;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return false;

        ItemStack s0 = h.slots.get(0).getStack();
        ItemStack s1 = h.slots.get(1).getStack();
        ItemStack s2 = h.slots.get(2).getStack();
        ItemStack s3 = h.slots.get(3).getStack();
        ItemStack s4 = h.slots.get(4).getStack();
        ItemStack s5 = h.slots.get(5).getStack();
        ItemStack s6 = h.slots.get(6).getStack();
        ItemStack s7 = h.slots.get(7).getStack();
        ItemStack s8 = h.slots.get(8).getStack();

        Item item = Items.WHITE_CONCRETE;
        Item item2 = Items.BLACK_CONCRETE;

        return
                s0.isOf(item) && s1.isOf(item) && s2.isOf(item) &&
                        s3.isOf(item) && s4.isEmpty() && s5.isOf(item) &&
                        s6.isOf(item2) && s7.isEmpty() && s8.isOf(item2);
    }
}