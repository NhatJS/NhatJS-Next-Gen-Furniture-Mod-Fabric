package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CoffeeTableBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CoffeeTableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-4, 0, 1, -3, 8.3, 2),
            Block.createCuboidShape(-4, 0, 14, -3, 8.3, 15),
            Block.createCuboidShape(19, 0, 1, 20, 8.3, 2),
            Block.createCuboidShape(-4.2, 8.3, 0.8, 20.2, 9, 15.2),
            Block.createCuboidShape(19, 0, 14, 20, 8.3, 15),
            Block.createCuboidShape(-3.25, 4.45, 1.75, 19.25, 8.3, 14.25)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(14, 0, -4, 15, 8.3, -3),
            Block.createCuboidShape(1, 0, -4, 2, 8.3, -3),
            Block.createCuboidShape(14, 0, 19, 15, 8.3, 20),
            Block.createCuboidShape(0.8, 8.3, -4.2, 15.2, 9, 20.2),
            Block.createCuboidShape(1, 0, 19, 2, 8.3, 20),
            Block.createCuboidShape(1.75, 4.45, -3.25, 14.25, 8.3, 19.25)
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