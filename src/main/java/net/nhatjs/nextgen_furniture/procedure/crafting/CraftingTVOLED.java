package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingTVOLED {
    public static boolean matches(PlayerEntity player) {
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

        Item item = Items.BLACK_CONCRETE;
        Item item2 = Items.END_CRYSTAL;
        Item item3 = Items.REDSTONE;

        return
                s0.isOf(item) && s1.isOf(item) && s2.isOf(item) &&
                s3.isOf(item) && s4.isOf(item2) && s5.isOf(item) &&
                s6.isOf(item) && s7.isOf(item3) && s8.isOf(item);
    }
}