package net.nhatjs.nextgen_furniture.blockentity.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.block.LaptopBlock;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;

public class LaptopBlockEntity extends BlockEntity {
    private float open;
    private float prevOpen;
    private boolean targetOpen;
    private boolean powered;

    private static final float OPEN_MIN = 0.2f;

    public LaptopBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAPTOP, pos, state);
    }

    public float getOpen() {return open;}
    public float getPrevOpen() {return prevOpen;}
    public boolean isTargetOpen() { return targetOpen; }

    public void setTargetOpen(boolean v) {
        targetOpen = v;
        if (!v) setPowered(false);
        markDirty(); sync();
    }

    public boolean isOpenEnough() {return open >= OPEN_MIN; }

    public boolean isPowered() {return powered; }

    public void setPowered(boolean v) {
        if (powered == v) return;
        powered = v;
        markDirty();
        sync();

        if (world != null && !world.isClient()) {
            BlockState s = world.getBlockState(pos);
            if (s.contains(LaptopBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(LaptopBlock.TURN_ON, v), Block.NOTIFY_ALL);
            }
        }
    }

    public static void tick(World w, BlockPos p, BlockState s, LaptopBlockEntity be) {
        be.prevOpen = be.open;
        float speed = 0.08f; //speed open/close
        float target = be.targetOpen ? 1f : 0f;

        if (be.open < target) be.open = Math.min(target, be.open + speed);
        else if (be.open > target) be.open = Math.max(target, be.open - speed);

        if (!w.isClient() && Math.abs(be.open - target) < 1e-3) {
            be.sync();
            //((ServerWorld) w).getChunkManager().markForUpdate(p);
            //w.updateListeners(p, s, s, 3);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup reg) {
        super.writeNbt(nbt, reg);
        nbt.putFloat("open", open);
        nbt.putFloat("prevOpen", prevOpen);
        nbt.putBoolean("targetOpen", targetOpen);
        nbt.putBoolean("powered", powered);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup reg) {
        super.readNbt(nbt, reg);
        open = nbt.getFloat("open");
        prevOpen = nbt.contains("prevOpen") ? nbt.getFloat("prevOpen") : open;
        targetOpen = nbt.getBoolean("targetOpen");
        powered = nbt.getBoolean("powered");
    }

    private void sync() {
        if (world instanceof ServerWorld sw) {
            sw.getChunkManager().markForUpdate(pos);
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    @Override public Packet<ClientPlayPacketListener> toUpdatePacket() { return BlockEntityUpdateS2CPacket.create(this);}
    @Override public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup reg) {return createNbt(reg);}
}