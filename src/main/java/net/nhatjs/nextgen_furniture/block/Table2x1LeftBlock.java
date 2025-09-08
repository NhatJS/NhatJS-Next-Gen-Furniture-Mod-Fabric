package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class Table2x1LeftBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public Table2x1LeftBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(0, 15.25, 0, 32, 16, 16),
            Block.createCuboidShape(0.5, 0, 0.5, 1.5, 15.25, 1.5),
            Block.createCuboidShape(0.5, 0, 14.5, 1.5, 15.25, 15.5),
            Block.createCuboidShape(30.5, 0, 0.5, 31.5, 15.25, 1.5),
            Block.createCuboidShape(30.5, 0, 14.5, 31.5, 15.25, 15.5)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(-16, 15.25, 0, 16, 16, 16),
            Block.createCuboidShape(-15.5, 0, 0.5, -14.5, 15.25, 1.5),
            Block.createCuboidShape(-15.5, 0, 14.5, -14.5, 15.25, 15.5),
            Block.createCuboidShape(14.5, 0, 0.5, 15.5, 15.25, 1.5),
            Block.createCuboidShape(14.5, 0, 14.5, 15.5, 15.25, 15.5)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0, 15.25, 0, 16, 16, 32),
            Block.createCuboidShape(14.5, 0, 0.5, 15.5, 15.25, 1.5),
            Block.createCuboidShape(0.5, 0, 0.5, 1.5, 15.25, 1.5),
            Block.createCuboidShape(14.5, 0, 30.5, 15.5, 15.25, 31.5),
            Block.createCuboidShape(0.5, 0, 30.5, 1.5, 15.25, 31.5)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(0, 15.25, -16, 16, 16, 16),
            Block.createCuboidShape(14.5, 0, -15.5, 15.5, 15.25, -14.5),
            Block.createCuboidShape(0.5, 0, -15.5, 1.5, 15.25, -14.5),
            Block.createCuboidShape(14.5, 0, 14.5, 15.5, 15.25, 15.5),
            Block.createCuboidShape(0.5, 0, 14.5, 1.5, 15.25, 15.5)
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

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        super.onUse(state, world, pos, player, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        double hitX = hit.getBlockPos().getX();
        double hitY = hit.getBlockPos().getY();
        double hitZ = hit.getBlockPos().getZ();
        Direction direction = hit.getSide();
        if (player.isSneaking()) {
            if ((world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.TABLE_2X1_BLACK_ALT) {
                {
                    BlockPos _bp = BlockPos.ofFloored(x, y, z);
                    BlockState _bs = ModBlocks.TABLE_2X1_BLACK_ALT_2.getDefaultState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getEntries().entrySet()) {
                        Property _property = _bs.getBlock().getStateManager().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.get(_property) != null)
                            try {
                                _bs = _bs.withIfExists(_property, (Comparable) entry.getValue());
                            } catch (Exception e) {
                            }
                    }
                    world.setBlockState(_bp, _bs, 3);
                }
            }
            if ((world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.TABLE_2X1_WHITE_ALT) {
                {
                    BlockPos _bp = BlockPos.ofFloored(x, y, z);
                    BlockState _bs = ModBlocks.TABLE_2X1_WHITE_ALT_2.getDefaultState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getEntries().entrySet()) {
                        Property _property = _bs.getBlock().getStateManager().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.get(_property) != null)
                            try {
                                _bs = _bs.withIfExists(_property, (Comparable) entry.getValue());
                            } catch (Exception e) {
                            }
                    }
                    world.setBlockState(_bp, _bs, 3);
                }
            }
        }
        else {
            return ActionResult.PASS;
        }
        return ActionResult.SUCCESS;
    }
}