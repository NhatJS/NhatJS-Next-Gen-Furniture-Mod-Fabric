package net.nhatjs.nextgen_furniture.blockentity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;

public class ConsoleBlockEntity extends BlockEntity {
    public ConsoleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CONSOLE, pos, state);
    }
}
