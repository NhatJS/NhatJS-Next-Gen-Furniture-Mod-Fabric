package net.nhatjs.nextgen_furniture.blockentity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;

public class TrashCanBlockEntity extends BlockEntity {
    public TrashCanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRASH_CAN, pos, state);
    }
}
