package net.nhatjs.nextgen_furniture.procedure;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class NextGenConsumeInputsProcedure {
    public static void execute(Inventory beInv) {
        if (beInv == null) return;
        for (int i=0;i<9;i++) {
            ItemStack s = beInv.getStack(i);
            if (!s.isEmpty()) s.decrement(1);
        }
    }
}