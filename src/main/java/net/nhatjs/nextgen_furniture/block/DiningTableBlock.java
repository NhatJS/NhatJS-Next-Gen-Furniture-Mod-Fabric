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

public class DiningTableBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public DiningTableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-16, 13.75, 0, 32, 16, 16),
            Block.createCuboidShape(29.1, 0.1, 1.65, 30.4, 0.75, 14.35),
            Block.createCuboidShape(-14.4, 0.1, 1.65, -13.1, 0.75, 14.35),
            Block.createCuboidShape(-14.5, 0, 0.75, -13, 13.75, 1.65),
            Block.createCuboidShape(-14.5, 0, 14.35, -13, 13.75, 15.25),
            Block.createCuboidShape(29, 0, 14.35, 30.5, 13.75, 15.25),
            Block.createCuboidShape(29, 0, 0.75, 30.5, 13.75, 1.65)
    );


    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0, 13.75, -16, 16, 16, 32),
            Block.createCuboidShape(1.65, 0.1, 29.1, 14.35, 0.75, 30.4),
            Block.createCuboidShape(1.65, 0.1, -14.4, 14.35, 0.75, -13.1),
            Block.createCuboidShape(14.3, 0, -14.5, 15.25, 13.75, -13),
            Block.createCuboidShape(0.75, 0, -14.5, 1.65, 13.75, -13),
            Block.createCuboidShape(0.75, 0, 29, 1.65, 13.75, 30.5),
            Block.createCuboidShape(14.35, 0, 29, 15.25, 13.75, 30.5)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> HORIZONTAL;
            case SOUTH -> HORIZONTAL;
            case EAST -> VERTICAL;
            case WEST -> VERTICAL;
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