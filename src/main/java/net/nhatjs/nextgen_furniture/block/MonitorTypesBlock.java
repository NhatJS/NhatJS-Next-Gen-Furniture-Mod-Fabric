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
            Block.createCuboidShape(5.4, 0, 9.525, 10.6, 0.225, 14.975),
            Block.createCuboidShape(6.975, 0.225, 13.225, 9.025, 10.075, 14.675),
            Block.createCuboidShape(7.275, 7.075, 12.05, 8.725, 8.325, 13.225),
            Block.createCuboidShape(0.225, 3.2, 10.925, 15.775, 12.15, 12.05)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(5.4, 0, 1.025, 10.6, 0.225, 6.475),
            Block.createCuboidShape(6.975, 0.225, 1.325, 9.025, 10.075, 2.775),
            Block.createCuboidShape(7.275, 7.075, 2.775, 8.725, 8.325, 3.95),
            Block.createCuboidShape(0.225, 3.2, 3.95, 15.775, 12.15, 5.075)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1.025, 0, 5.4, 6.475, 0.225, 10.6),
            Block.createCuboidShape(1.325, 0.225, 6.975, 2.775, 10.075, 9.025),
            Block.createCuboidShape(2.775, 7.075, 7.275, 3.95, 8.325, 8.725),
            Block.createCuboidShape(3.95, 3.2, 0.225, 5.075, 12.15, 15.775)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.525, 0, 5.4, 14.975, 0.225, 10.6),
            Block.createCuboidShape(13.225, 0.225, 6.975, 14.675, 10.075, 9.025),
            Block.createCuboidShape(12.05, 7.075, 7.275, 13.225, 8.325, 8.725),
            Block.createCuboidShape(10.925, 3.2, 0.225, 12.05, 12.15, 15.775)
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