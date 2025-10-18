package net.nhatjs.nextgen_furniture.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.nhatjs.nextgen_furniture.client.screen.NextGenCraftingMenu;
import net.nhatjs.nextgen_furniture.entity.ModBlockEntities;

public class NextGenCraftingTableBlockEntity extends LockableContainerBlockEntity implements SidedInventory {
    public static final int SIZE = 10;
    public static final int OUTPUT = 9;

    private DefaultedList<ItemStack> items = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);

    public NextGenCraftingTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NEXTGEN_CRAFTING_BE, pos, state);
    }

    @Override protected Text getContainerName() {
        return Text.translatable("block.nextgen_furniture.nextgen_crafting_table");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new NextGenCraftingMenu(syncId, playerInventory, this);
    }

    // ---- inventory ----
    @Override public int size() { return items.size(); }
    @Override public boolean isEmpty() { for (ItemStack s: items) if (!s.isEmpty()) return false; return true; }
    @Override public ItemStack getStack(int slot) { return items.get(slot); }
    @Override public void clear() { items.clear(); markDirtyAndSync(); }
    @Override public boolean canPlayerUse(PlayerEntity p) {
        return world != null && world.getBlockEntity(pos) == this && p.squaredDistanceTo(
                pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5) <= 64.0;
    }
    @Override public void setStack(int slot, ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > stack.getMaxCount()) stack.setCount(stack.getMaxCount());
        markDirtyAndSync();
    }
    @Override public ItemStack removeStack(int slot, int amount) {
        ItemStack out = Inventories.splitStack(items, slot, amount);
        if (!out.isEmpty()) markDirtyAndSync();
        return out;
    }
    @Override public ItemStack removeStack(int slot) {
        ItemStack out = Inventories.removeStack(items, slot);
        if (!out.isEmpty()) markDirtyAndSync();
        return out;
    }

    private void markDirtyAndSync() {
        markDirty();
        if (world != null && !world.isClient) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    // ---- 1.21 container components (KHÔNG trả null) ----
    @Override protected DefaultedList<ItemStack> getHeldStacks() { return items; }
    @Override protected void setHeldStacks(DefaultedList<ItemStack> stacks) {
        this.items = (stacks != null) ? stacks : DefaultedList.ofSize(SIZE, ItemStack.EMPTY);
    }

    // ---- NBT 1.21 ----
    @Override public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup reg) {
        super.readNbt(nbt, reg);
        items = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);
        Inventories.readNbt(nbt, items, reg);
    }
    @Override protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup reg) {
        super.writeNbt(nbt, reg);
        Inventories.writeNbt(nbt, items, reg);
    }
    @Override public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup reg) {
        NbtCompound nbt = super.toInitialChunkDataNbt(reg);
        Inventories.writeNbt(nbt, items, reg);
        return nbt;
    }
    @Override public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    // ---- hoppers (tuỳ) ----
    private static final int[] TOP = new int[]{0,1,2,3,4,5,6,7,8};
    private static final int[] SIDE = new int[]{0,1,2,3,4,5,6,7,8};
    private static final int[] BOTTOM = new int[]{OUTPUT};
    @Override public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) return BOTTOM;
        if (side == Direction.UP) return TOP;
        return SIDE;
    }
    @Override public boolean canInsert(int slot, ItemStack stack, Direction dir) { return slot != OUTPUT; }
    @Override public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == OUTPUT && dir == Direction.DOWN;
    }
}
