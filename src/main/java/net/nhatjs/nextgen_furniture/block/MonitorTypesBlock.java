package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MonitorTypesBlock extends Block {
    public static final EnumProperty<net.minecraft.util.math.Direction> FACING = Properties.HORIZONTAL_FACING;

    public MonitorTypesBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, net.minecraft.util.math.Direction.NORTH));
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(5.275, 0, 9.6, 10.725, 0.225, 15.3),
            Block.createCuboidShape(6.925, 0.225, 13.475, 9.075, 10.575, 15.025),
            Block.createCuboidShape(7.25, 7.425, 12.25, 8.75, 8.725, 13.475),
            Block.createCuboidShape(-0.15, 3.35, 11.075, 16.15, 12.75, 12.25)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(5.275, 0, 0.7, 10.725, 0.225, 6.4),
            Block.createCuboidShape(6.925, 0.225, 0.975, 9.075, 10.575, 2.525),
            Block.createCuboidShape(7.25, 7.425, 2.525, 8.75, 8.725, 3.75),
            Block.createCuboidShape(-0.15, 3.35, 3.75, 16.15, 12.75, 4.925)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0.7, 0, 5.275, 6.4, 0.225, 10.725),
            Block.createCuboidShape(0.975, 0.225, 6.925, 2.525, 10.575, 9.075),
            Block.createCuboidShape(2.525, 7.425, 7.25, 3.75, 8.725, 8.75),
            Block.createCuboidShape(3.75, 3.35, -0.15, 4.925, 12.75, 16.15)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.6, 0, 5.275, 15.3, 0.225, 10.725),
            Block.createCuboidShape(13.475, 0.225, 6.925, 15.025, 10.575, 9.075),
            Block.createCuboidShape(12.25, 7.425, 7.25, 13.475, 8.725, 8.75),
            Block.createCuboidShape(11.075, 3.35, -0.15, 12.25, 12.75, 16.15)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}