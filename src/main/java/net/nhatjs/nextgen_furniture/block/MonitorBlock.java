package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MonitorBlock extends HorizontalFacingBlock {
    public static MapCodec<MonitorBlock> CODEC = createCodec(MonitorBlock::new);
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public MonitorBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 11, 16, 13, 15),
            Block.createCuboidShape(-0.5, 0, 1.25, 16.5, 0.025, 7.75),
            Block.createCuboidShape(5.15, 0.025, 3.025, 14.45, 0.725, 6.5),
            Block.createCuboidShape(1.5, 0.025, 3.475, 3.325, 0.74, 6.025)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 1, 16, 13, 5),
            Block.createCuboidShape(-0.5, 0, 8.25, 16.5, 0.025, 14.75),
            Block.createCuboidShape(1.55, 0.025, 9.5, 10.85, 0.725, 12.975),
            Block.createCuboidShape(12.675, 0.025, 9.975, 14.5, 0.75, 12.525)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1, 0, 0, 5, 13, 16),
            Block.createCuboidShape(8.25, 0, -0.5, 14.75, 0.025, 16.5),
            Block.createCuboidShape(9.5, 0.025, 5.15, 12.975, 0.725, 14.45),
            Block.createCuboidShape(9.975, 0.025, 1.5, 12.525, 0.75, 3.325)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(11, 0, 0, 15, 13, 16),
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
        boolean current = state.get(TURN_ON);
        if (player.getMainHandStack().getItem() == ModBlocks.MONITOR_GAMING_MINIMALIST.asItem() && !current) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.MONITOR_DUAL.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing)
                    .with(DualMonitorBlock.TURN_ON, false), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        else {
            world.setBlockState(pos, state.with(TURN_ON, !current), 3);
        }
        return ActionResult.SUCCESS;
    }
}
