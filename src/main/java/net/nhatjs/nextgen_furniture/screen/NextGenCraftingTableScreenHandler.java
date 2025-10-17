package net.nhatjs.nextgen_furniture.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.recipes.ModRecipes;

public class NextGenCraftingTableScreenHandler extends ScreenHandler {
    private final CraftingInventory input = new CraftingInventory(this, 3, 3);
    private final CraftingResultInventory output = new CraftingResultInventory();
    private final ScreenHandlerContext context;

    // TODO: truyền đúng ScreenHandlerType của bạn tại chỗ gọi new (client+server)
    public NextGenCraftingTableScreenHandler(int syncId, PlayerInventory inv, ScreenHandlerContext ctx) {
        super(ModScreenHandlers.NEXTGEN_CRAFTING_TABLE, syncId);
        this.context = ctx;
        PlayerEntity player = inv.player;

        // ----- Output slot (index 0)
        this.addSlot(new Slot(output, 0, 124, 35) {
            @Override public boolean canInsert(ItemStack stack) { return false; }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                context.run((world, pos) -> {
                    var opt = world.getRecipeManager().getFirstMatch(ModRecipes.NEXTGEN_TYPE, input.createRecipeInput(), world);
                    if (opt.isPresent()) {
                        DynamicRegistryManager regs = world.getRegistryManager();
                        DefaultedList<ItemStack> remainders =
                                opt.get().value().getRemainder(input.createRecipeInput(), regs);

                        for (int i = 0; i < input.size(); i++) {
                            ItemStack in = input.getStack(i);
                            ItemStack rem = remainders.get(i);

                            if (!in.isEmpty()) {
                                // tiêu hao 1 item ở mỗi ô tham gia công thức
                                input.removeStack(i, 1);
                                in = input.getStack(i); // cập nhật tham chiếu hiện tại
                            }

                            if (!rem.isEmpty()) {
                                // nếu còn lại (chai xô, xô nước…)
                                if (in.isEmpty()) {
                                    input.setStack(i, rem);
                                } else if (!player.getInventory().insertStack(rem.copy())) {
                                    // nếu không nhét được vào túi thì thả ra ngoài
                                    player.dropItem(rem.copy(), false);
                                }
                            }
                        }
                    }
                    // gửi sync lại client
                    sendContentUpdates();
                });
                super.onTakeItem(player, stack);
            }
        });

        // ----- 3x3 input (index 1..9)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                this.addSlot(new Slot(input, col + row * 3, 30 + col * 18, 17 + row * 18));
            }
        }

        // ----- Player inventory (index 10..36)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        // ----- Hotbar (index 37..45)
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 142));
        }

        // Tính kết quả ban đầu
        this.onContentChanged(input);
    }

    // Client convenience ctor
    public NextGenCraftingTableScreenHandler(int syncId, PlayerInventory inv) {
        this(syncId, inv, ScreenHandlerContext.EMPTY);
    }

    // === Craft logic: giữ nguyên như vanilla, chỉ đổi RecipeType ===
    @Override
    public void onContentChanged(Inventory inv) {
        super.onContentChanged(inv);
        context.run((world, pos) -> updateResult());
    }

    private void updateResult() {
        context.run((world, pos) -> {
            if (world.isClient()) return;
            var opt = world.getRecipeManager().getFirstMatch(ModRecipes.NEXTGEN_TYPE, input.createRecipeInput(), world);
            ItemStack result = opt.map(e -> e.value().craft(input.createRecipeInput(), world.getRegistryManager())).orElse(ItemStack.EMPTY);
            output.setStack(0, result);
            sendContentUpdates();
        });
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        // giống vanilla: chỉ cho dùng khi đứng gần block bạn
        return canUse(this.context, player, ModBlocks.NEXTGEN_CRAFTING_TABLE);
    }

    // === Shift-click (copy từ CraftingScreenHandler, sửa chỉ số) ===
    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack in = slot.getStack();
            newStack = in.copy();

            // output slot
            if (index == 0) {
                if (!this.insertItem(in, 10, 46, true)) return ItemStack.EMPTY;
                slot.onQuickTransfer(in, newStack);
            }
            // input grid -> player inv
            else if (index >= 1 && index < 10) {
                if (!this.insertItem(in, 10, 46, false)) return ItemStack.EMPTY;
            }
            // player inv -> input grid
            else if (!this.insertItem(in, 1, 10, false)) {
                // hotbar <-> main inv swap
                if (index < 37) {
                    if (!this.insertItem(in, 37, 46, false)) return ItemStack.EMPTY;
                } else if (!this.insertItem(in, 10, 37, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (in.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();

            if (in.getCount() == newStack.getCount()) return ItemStack.EMPTY;
            slot.onTakeItem(player, in);
        }
        return newStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, input));
    }
}
