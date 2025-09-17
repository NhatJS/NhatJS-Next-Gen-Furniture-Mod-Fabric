package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TVBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TV_ON = BooleanProperty.of("tv_on");
    public static final EnumProperty<Mount> MOUNT = EnumProperty.of("mount", Mount.class);

    public enum Mount implements StringIdentifiable
    {
        STAND("stand"),
        WALL("wall");

        private final String name;

        Mount(String name)
        {
            this.name = name;
        }

        @Override
        public String asString()
        {
            return name;
        }
    }

    public TVBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TV_ON, false)
                .with(MOUNT, Mount.STAND));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TV_ON, MOUNT);
    }

    private static final VoxelShape NORTH_MOUNT = Block.createCuboidShape(-10.75, 4.45, 14.6, 26.75, 26.3, 16);
    private static final VoxelShape SOUTH_MOUNT = Block.createCuboidShape(-10.75, 4.45, 0, 26.75, 26.3, 1.4);
    private static final VoxelShape WEST_MOUNT = Block.createCuboidShape(14.6, 4.45, -10.75, 16, 26.3, 26.75);
    private static final VoxelShape EAST_MOUNT = Block.createCuboidShape(0, 4.45, -10.75, 1.4, 26.3, 26.75);

    private static final VoxelShape NORTH_STAND = Block.createCuboidShape(-10.75, 1.75, 12.1, 26.75, 23.8, 13.7);
    private static final VoxelShape SOUTH_STAND = Block.createCuboidShape(-10.75, 1.75, 2.3, 26.75, 23.8, 3.9);
    private static final VoxelShape WEST_STAND = Block.createCuboidShape(12.1, 1.75, -10.75, 13.7, 23.8, 26.75);
    private static final VoxelShape EAST_STAND = Block.createCuboidShape(2.3, 1.75, -10.75, 3.9, 23.8, 26.75);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean wall = state.get(MOUNT) == Mount.WALL;
        return switch (direction) {
            default -> wall ? NORTH_MOUNT : VoxelShapes.union(NORTH_STAND);
            case SOUTH -> wall ? SOUTH_MOUNT : VoxelShapes.union(SOUTH_STAND);
            case EAST -> wall ? EAST_MOUNT : VoxelShapes.union(EAST_STAND);
            case WEST -> wall ? WEST_MOUNT : VoxelShapes.union(WEST_STAND);
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction face = ctx.getSide();
        if (face.getAxis().isHorizontal()) {
            BlockPos back = ctx.getBlockPos().offset(face.getOpposite());
            if (hasSupport(ctx.getWorld(), back, face)) {
                return getDefaultState()
                        .with(FACING, face)
                        .with(MOUNT, Mount.WALL)
                        .with(TV_ON, false);
            }
            return null;
        }
        return getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(MOUNT, Mount.STAND)
                .with(TV_ON, false);
    }

    private boolean hasSupport(WorldView world, BlockPos pos, Direction supportFace) {
        BlockState bs = world.getBlockState(pos);
        return bs.isSideSolidFullSquare(world, pos, supportFace) || bs.isSolidBlock(world, pos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            boolean next = !state.get(TV_ON);
            world.setBlockState(pos, state.with(TV_ON, next), Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
