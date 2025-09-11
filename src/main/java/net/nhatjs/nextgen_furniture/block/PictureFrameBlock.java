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
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class PictureFrameBlock extends Block {
    public static final DirectionProperty FACING = Properties.FACING;

    public PictureFrameBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(3.5, 2, 15.65, 12.5, 14, 16);
            case SOUTH -> Block.createCuboidShape(3.5, 2, 0, 12.5, 14, 0.35);
            case EAST -> Block.createCuboidShape(0, 2, 3.5, 0.35, 14, 12.5);
            case WEST -> Block.createCuboidShape(15.65, 2, 3.5, 16, 14, 12.5);
            case UP -> Block.createCuboidShape(3.5, 0, 2, 12.5, 0.35, 14);
            case DOWN -> Block.createCuboidShape(3.5, 15.65, 2, 12.5, 16, 14);
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}