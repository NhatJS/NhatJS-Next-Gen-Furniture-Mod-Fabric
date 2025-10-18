package net.nhatjs.nextgen_furniture.procedure;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.procedure.crafting.*;

public class NextGenUpdateOutputProcedure {
    public static void execute(PlayerEntity player) {
        if (player == null) return;
        ScreenHandler h = player.currentScreenHandler;
        if (h == null || h.slots.size() < 10) return;

        ItemStack[] in = new ItemStack[9];
        for (int i=0;i<9;i++) in[i] = h.slots.get(i).getStack();

        if (CraftingChair.chairwhite(player)) { h.slots.get(9).setStack(new ItemStack(ModBlocks.CHAIR_WHITE, 2)); h.sendContentUpdates(); return; }
        if (CraftingChair.chairwoodoak(player)) { h.slots.get(9).setStack(new ItemStack(ModBlocks.CHAIR_WOOD_OAK, 2)); h.sendContentUpdates(); return; }
        if (CraftingChair.chairwoodbirch(player)) { h.slots.get(9).setStack(new ItemStack(ModBlocks.CHAIR_WOOD_BIRCH, 2)); h.sendContentUpdates(); return; }
        if (CraftingCoffeeTableWhite.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.COFFEE_TABLE_WHITE, 2));h.sendContentUpdates();return;}
        if (CraftingFloorLamp.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.FLOOR_LAMP, 1));h.sendContentUpdates();return;}
        if (CraftingLaptop.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.LAPTOP, 1));h.sendContentUpdates();return;}
        if (CraftingPictureFrame.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.PICTURE_FRAME, 1));h.sendContentUpdates();return;}
        if (CraftingSofa.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.SOFA, 2));h.sendContentUpdates();return;}
        if (CraftingTable2x1.black2x1(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_2X1_BLACK, 2));h.sendContentUpdates();return;}
        if (CraftingTable2x1.white2x1(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_2X1_WHITE, 2));h.sendContentUpdates();return;}
        if (CraftingTable3x1.black3x1(player) || CraftingTable3x1.black3x1alt(player) || CraftingTable3x1.black3x1alt2(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_3X1_BLACK, 1));h.sendContentUpdates();return;}
        if (CraftingTable3x1.white3x1(player) || CraftingTable3x1.white3x1alt(player) || CraftingTable3x1.white3x1alt2(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_3X1_WHITE, 1));h.sendContentUpdates();return;}
        if (CraftingTableDining.white(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_DINING_WHITE, 2));h.sendContentUpdates();return;}
        if (CraftingTableDining.woodoak(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TABLE_DINING_WOOD_OAK, 2));h.sendContentUpdates();return;}

        ItemStack trashCan = CraftingTrashCan.matches(player);
        if (!trashCan.isEmpty()) {h.slots.get(9).setStack(trashCan);h.sendContentUpdates();return;}

        if (CraftingTVOLED.matches(player)) {h.slots.get(9).setStack(new ItemStack(ModBlocks.TV_OLED, 1));h.sendContentUpdates();return;}

        ItemStack tvStand = CraftingTVStandWood.matches(player);
        if (!tvStand.isEmpty()) {h.slots.get(9).setStack(tvStand);h.sendContentUpdates();return;}

        h.slots.get(9).setStack(ItemStack.EMPTY);
        h.sendContentUpdates();
    }

    private static boolean allSame(ItemStack[] arr, Item item) {
        for (ItemStack s : arr) if (s.isEmpty() || !s.isOf(item)) return false;
        return true;
    }
}
