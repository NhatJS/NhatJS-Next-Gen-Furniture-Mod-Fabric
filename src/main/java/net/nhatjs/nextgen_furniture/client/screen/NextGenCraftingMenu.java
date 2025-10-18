package net.nhatjs.nextgen_furniture.client.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.nextgen_furniture.block.entity.NextGenCraftingTableBlockEntity;
import net.nhatjs.nextgen_furniture.menu.ModMenus;
import net.nhatjs.nextgen_furniture.procedure.NextGenConsumeInputsProcedure;
import net.nhatjs.nextgen_furniture.procedure.NextGenUpdateOutputProcedure;

public class NextGenCraftingMenu extends ScreenHandler {
    private final Inventory inv;
    public final BlockPos pos;
    private final PlayerInventory playerInv;

    public NextGenCraftingMenu(int syncId, PlayerInventory playerInv) {
        this(syncId, playerInv, new SimpleInventory(NextGenCraftingTableBlockEntity.SIZE));
    }

    public NextGenCraftingMenu(int syncId, PlayerInventory playerInv, Inventory beInv) {
        super(ModMenus.NEXTGEN_CRAFTING_MENU, syncId);
        this.playerInv = playerInv;
        this.inv = beInv;
        beInv.onOpen(playerInv.player);
        this.pos = (beInv instanceof NextGenCraftingTableBlockEntity be) ? be.getPos() : playerInv.player.getBlockPos();

        // input 3x3 (0..8)
        int x0 = 30, y0 = 17, idx = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final int slotIndex = idx;
                this.addSlot(new Slot(this.inv, slotIndex, x0 + c * 18, y0 + r * 18) {
                    @Override
                    public void markDirty() {
                        super.markDirty();
                        // CHỈ SERVER mới cập nhật output
                        if (!playerInv.player.getWorld().isClient) {
                            net.nhatjs.nextgen_furniture.procedure.NextGenUpdateOutputProcedure
                                    .execute(playerInv.player);
                        }
                    }
                });
                idx++;
            }
        }

        // output (9)
        this.addSlot(new Slot(beInv, NextGenCraftingTableBlockEntity.OUTPUT, 124, 35) {
            @Override public boolean canInsert(ItemStack stack) { return false; }
            @Override public boolean canTakeItems(PlayerEntity player) { return !this.getStack().isEmpty(); }
            @Override public void onTakeItem(PlayerEntity player, ItemStack taken) {
                NextGenConsumeInputsProcedure.execute(inv);      // trừ input
                NextGenUpdateOutputProcedure.execute(player);   // update lại output
                super.onTakeItem(player, taken);
            }
        });

        // player inv
        int py=84;
        for (int r=0;r<3;r++) for (int c=0;c<9;c++)
            this.addSlot(new Slot(playerInv, 9 + r*9 + c, 8 + c*18, py + r*18));
        // hotbar
        int hy=142;
        for (int c=0;c<9;c++) this.addSlot(new Slot(playerInv, c, 8 + c*18, hy));
    }

    @Override public boolean canUse(PlayerEntity player) { return inv.canPlayerUse(player); }

    @Override
    public void onContentChanged(Inventory inventory) {
        super.onContentChanged(inventory);
        PlayerEntity p = this.playerInv.player;
        if (!p.getWorld().isClient) NextGenUpdateOutputProcedure.execute(p);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack copy = ItemStack.EMPTY;
        Slot s = this.slots.get(index);
        if (s != null && s.hasStack()) {
            ItemStack cur = s.getStack();
            copy = cur.copy();
            int beEnd = 10, invStart = beEnd, invEnd = invStart + 36;

            if (index < beEnd) {
                if (!insertItem(cur, invStart, invEnd, true)) return ItemStack.EMPTY;
            } else {
                if (!insertItem(cur, 0, 9, false)) return ItemStack.EMPTY;
            }
            if (cur.isEmpty()) s.setStack(ItemStack.EMPTY); else s.markDirty();
            if (cur.getCount() == copy.getCount()) return ItemStack.EMPTY;
            s.onTakeItem(player, cur);
        }
        return copy;
    }
}
