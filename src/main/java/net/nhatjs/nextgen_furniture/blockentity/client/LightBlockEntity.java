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
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.nextgen_furniture.block.ModernLightBlock;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;

public class LightBlockEntity extends BlockEntity {
    private boolean powered;

    public LightBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LIGHT_EXTRA, pos, state);
    }

    public boolean isPowered() {return powered; }

    public void setPowered(boolean v) {
        if (powered == v) return;
        powered = v;
        markDirty();
        sync();

        if (world != null && !world.isClient()) {
            BlockState s = world.getBlockState(pos);
            if (s.contains(ModernLightBlock.LIT)) {
                world.setBlockState(pos, s.with(ModernLightBlock.LIT, v), Block.NOTIFY_ALL);
            }
        }
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putBoolean("powered", powered);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        view.getBoolean("powered", powered);
    }

    private void sync() {
        if (world instanceof ServerWorld sw) {
            sw.getChunkManager().markForUpdate(pos);
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override public Packet<ClientPlayPacketListener> toUpdatePacket() { return BlockEntityUpdateS2CPacket.create(this);}
    @Override public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup reg) {return createNbt(reg);}
}