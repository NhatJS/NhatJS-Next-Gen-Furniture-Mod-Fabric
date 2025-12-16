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
            Block.createCuboidShape(5.275, 0, 9.6, 10.725, 0.225, 15.3),
            Block.createCuboidShape(6.925, 0.225, 13.475, 9.075, 10.575, 15.025),
            Block.createCuboidShape(7.25, 7.425, 12.25, 8.75, 8.725, 13.475),
            Block.createCuboidShape(-0.15, 3.35, 11.075, 16.15, 12.75, 12.25),

            Block.createCuboidShape(-0.5, 0, 1.25, 16.5, 0.025, 7.75),
            Block.createCuboidShape(5.15, 0.025, 3.025, 14.45, 0.725, 6.5),
            Block.createCuboidShape(1.5, 0.025, 3.475, 3.325, 0.74, 6.025)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(5.275, 0, 0.7, 10.725, 0.225, 6.4),
            Block.createCuboidShape(6.925, 0.225, 0.975, 9.075, 10.575, 2.525),
            Block.createCuboidShape(7.25, 7.425, 2.525, 8.75, 8.725, 3.75),
            Block.createCuboidShape(-0.15, 3.35, 3.75, 16.15, 12.75, 4.925),

            Block.createCuboidShape(-0.5, 0, 8.25, 16.5, 0.025, 14.75),
            Block.createCuboidShape(1.55, 0.025, 9.5, 10.85, 0.725, 12.975),
            Block.createCuboidShape(12.675, 0.025, 9.975, 14.5, 0.75, 12.525)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0.7, 0, 5.275, 6.4, 0.225, 10.725),
            Block.createCuboidShape(0.975, 0.225, 6.925, 2.525, 10.575, 9.075),
            Block.createCuboidShape(2.525, 7.425, 7.25, 3.75, 8.725, 8.75),
            Block.createCuboidShape(3.75, 3.35, -0.15, 4.925, 12.75, 16.15),

            Block.createCuboidShape(8.25, 0, -0.5, 14.75, 0.025, 16.5),
            Block.createCuboidShape(9.5, 0.025, 5.15, 12.975, 0.725, 14.45),
            Block.createCuboidShape(9.975, 0.025, 1.5, 12.525, 0.75, 3.325)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.6, 0, 5.275, 15.3, 0.225, 10.725),
            Block.createCuboidShape(13.475, 0.225, 6.925, 15.025, 10.575, 9.075),
            Block.createCuboidShape(12.25, 7.425, 7.25, 13.475, 8.725, 8.75),
            Block.createCuboidShape(11.075, 3.35, -0.15, 12.25, 12.75, 16.15),

            Block.createCuboidShape(1.25, 0, -0.5, 7.75, 0.025, 16.5),
            Block.createCuboidShape(3.025, 0.025, 1.55, 6.5, 0.725, 10.85),
            Block.createCuboidShape(3.475, 0.025, 12.675, 6.025, 0.75, 14.5)
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
