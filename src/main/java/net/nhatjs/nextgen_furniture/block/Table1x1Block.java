package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Table1x1Block extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;


    public Table1x1Block(Settings settings) {
        super(settings);
    }

    private static final VoxelShape DEFAULT = VoxelShapes.union(
            Block.createCuboidShape(14.5, 0, 0.5, 15.5, 15.25, 1.5),
            Block.createCuboidShape(0.5, 0, 0.5, 1.5, 15.25, 1.5),
            Block.createCuboidShape(0.5, 0, 14.5, 1.5, 15.25, 15.5),
            Block.createCuboidShape(14.5, 0, 14.5, 15.5, 15.25, 15.5),
            Block.createCuboidShape(0, 15.25, 0, 16, 16, 16)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> DEFAULT;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}