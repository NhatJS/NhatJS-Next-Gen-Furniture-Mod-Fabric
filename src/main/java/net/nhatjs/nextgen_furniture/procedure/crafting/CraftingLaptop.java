package net.nhatjs.nextgen_furniture.procedure.crafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;

public class CraftingLaptop {
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

        return
                s0.isOf(Items.BLACK_CONCRETE) && s1.isOf(Items.BLACK_STAINED_GLASS_PANE) && s2.isOf(Items.BLACK_CONCRETE) &&
                s3.isOf(Items.NOTE_BLOCK) && s4.isOf(Items.END_CRYSTAL) && s5.isOf(Items.STONE_BUTTON) &&
                s6.isOf(Items.WHITE_CONCRETE) && s7.isOf(Items.REDSTONE) && s8.isOf(Items.WHITE_CONCRETE);
    }
}