package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DesktopBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");
    public static final BooleanProperty PC_BOOTING = BooleanProperty.of("pc_booting");

    public DesktopBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false)
                .with(PC_BOOTING, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(5.025, 0, 0.95, 10.975, 13.75, 15.05);
            case SOUTH -> Block.createCuboidShape(5.025, 0, 0.95, 10.975, 13.75, 15.05);
            case EAST -> Block.createCuboidShape(0.95, 0, 5.025, 15.05, 13.75, 10.975);
            case WEST -> Block.createCuboidShape(0.95, 0, 5.025, 15.05, 13.75, 10.975);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON, PC_BOOTING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {

        if (world.isClient) return ActionResult.SUCCESS;

        if (state.get(PC_BOOTING)) return ActionResult.CONSUME;

        world.setBlockState(
                pos,
                state.with(PC_BOOTING, true),
                Block.NOTIFY_ALL
        );

        world.scheduleBlockTick(pos, this, 25);

        return ActionResult.CONSUME;
    }

    public void scheduledTick(BlockState state, ServerWorld world,
                              BlockPos pos, Random random) {

        boolean currentlyOn = state.get(TURN_ON);

        world.setBlockState(
                pos,
                state
                        .with(TURN_ON, !currentlyOn)
                        .with(PC_BOOTING, false),
                Block.NOTIFY_ALL
        );
    }
}
