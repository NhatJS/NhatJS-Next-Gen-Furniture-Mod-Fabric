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
import net.minecraft.world.BlockView;

public class KeyboardBlock extends Block {
    public static final EnumProperty<net.minecraft.util.math.Direction> FACING = Properties.HORIZONTAL_FACING;

    public KeyboardBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, net.minecraft.util.math.Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(5.15, 0.025, 3.025, 14.45, 0.75, 6.5);
            case SOUTH -> Block.createCuboidShape(1.55, 0.025, 9.5, 10.85, 0.75, 12.975);
            case EAST -> Block.createCuboidShape(9.5, 0.025, 5.15, 12.975, 0.75, 14.45);
            case WEST -> Block.createCuboidShape(3.025, 0.025, 1.55, 6.5, 0.75, 10.85);
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
