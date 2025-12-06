package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MonitorBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public MonitorBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(5.4, 0, 9.525, 10.6, 0.225, 14.975),
            Block.createCuboidShape(6.975, 0.225, 13.225, 9.025, 10.075, 14.675),
            Block.createCuboidShape(7.275, 7.075, 12.05, 8.725, 8.325, 13.225),
            Block.createCuboidShape(0.225, 3.2, 10.925, 15.775, 12.15, 12.05),

            Block.createCuboidShape(-0.4, 0, 1.25, 16.4, 0.025, 7.75),
            Block.createCuboidShape(5.15, 0.025, 3.025, 14.45, 0.75, 6.5),
            Block.createCuboidShape(1.5, 0.025, 3, 3.325, 0.775, 6.525)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(5.4, 0, 1.025, 10.6, 0.225, 6.475),
            Block.createCuboidShape(6.975, 0.225, 1.325, 9.025, 10.075, 2.775),
            Block.createCuboidShape(7.275, 7.075, 2.775, 8.725, 8.325, 3.95),
            Block.createCuboidShape(0.225, 3.2, 3.95, 15.775, 12.15, 5.075),

            Block.createCuboidShape(-0.4, 0, 8.25, 16.4, 0.025, 14.75),
            Block.createCuboidShape(1.55, 0.025, 9.5, 10.85, 0.75, 12.975),
            Block.createCuboidShape(12.675, 0.025, 9.475, 14.5, 0.775, 13)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1.025, 0, 5.4, 6.475, 0.225, 10.6),
            Block.createCuboidShape(1.325, 0.225, 6.975, 2.775, 10.075, 9.025),
            Block.createCuboidShape(2.775, 7.075, 7.275, 3.95, 8.325, 8.725),
            Block.createCuboidShape(3.95, 3.2, 0.225, 5.075, 12.15, 15.775),

            Block.createCuboidShape(8.25, 0, -0.4, 14.75, 0.025, 16.4),
            Block.createCuboidShape(9.5, 0.025, 5.15, 12.975, 0.75, 14.45),
            Block.createCuboidShape(9.475, 0.025, 1.5, 13, 0.775, 3.325)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.525, 0, 5.4, 14.975, 0.225, 10.6),
            Block.createCuboidShape(13.225, 0.225, 6.975, 14.675, 10.075, 9.025),
            Block.createCuboidShape(12.05, 7.075, 7.275, 13.225, 8.325, 8.725),
            Block.createCuboidShape(10.925, 3.2, 0.225, 12.05, 12.15, 15.775),

            Block.createCuboidShape(1.25, 0, -0.4, 7.75, 0.025, 16.4),
            Block.createCuboidShape(3.025, 0.025, 1.55, 6.5, 0.75, 10.85),
            Block.createCuboidShape(3, 0.025, 12.675, 6.525, 0.775, 14.5)
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
        builder.add(FACING, TURN_ON);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            boolean current = state.get(TURN_ON);
            world.setBlockState(pos, state.with(TURN_ON, !current), 3);
        }
        return ActionResult.SUCCESS;
    }
}
