package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingChair {
    public static boolean chairwhite(PlayerEntity p) {
        if (p == null) return false;
        ScreenHandler h = p.currentScreenHandler;
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

        return
                s0.isOf(item) && s1.isEmpty() && s2.isEmpty() &&
                s3.isOf(item) && s4.isOf(item) && s5.isOf(item) &&
                s6.isOf(item) && s7.isEmpty() && s8.isOf(item);
    }

    public static boolean chairwoodoak(PlayerEntity p) {
        if (p == null) return false;
        ScreenHandler h = p.currentScreenHandler;
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

        Item item = Items.OAK_PLANKS;

        return
                s0.isOf(item) && s1.isEmpty() && s2.isEmpty() &&
                        s3.isOf(item) && s4.isOf(item) && s5.isOf(item) &&
                        s6.isOf(item) && s7.isEmpty() && s8.isOf(item);
    }

    public static boolean chairwoodbirch(PlayerEntity p) {
        if (p == null) return false;
        ScreenHandler h = p.currentScreenHandler;
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

        Item item = Items.BIRCH_PLANKS;

        return
                s0.isOf(item) && s1.isEmpty() && s2.isEmpty() &&
                        s3.isOf(item) && s4.isOf(item) && s5.isOf(item) &&
                        s6.isOf(item) && s7.isEmpty() && s8.isOf(item);
    }
}