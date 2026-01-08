package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class WashingMachineBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public WashingMachineBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape MODEL = VoxelShapes.union(
            Block.createCuboidShape(0.5, 0, 0.5, 2, 0.35, 2),
            Block.createCuboidShape(0.5, 0, 14, 2, 0.35, 15.5),
            Block.createCuboidShape(14, 0, 0.5, 15.5, 0.35, 2),
            Block.createCuboidShape(14, 0, 14, 15.5, 0.35, 15.5),
            Block.createCuboidShape(0, 0.35, 0, 16, 22.55, 16)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> MODEL;
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