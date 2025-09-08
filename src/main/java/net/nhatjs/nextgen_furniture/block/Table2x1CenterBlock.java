package net.nhatjs.nextgen_furniture.block;


import net.minecraft.block.*;
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

public class Table2x1CenterBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public Table2x1CenterBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-8, 15.25, 0, 24, 16, 16),
            Block.createCuboidShape(-7.5, 0, 0.5, -6.5, 15.25, 1.5),
            Block.createCuboidShape(-7.5, 0, 14.5, -6.5, 15.25, 15.5),
            Block.createCuboidShape(22.5, 0, 0.5, 23.5, 15.25, 1.5),
            Block.createCuboidShape(22.5, 0, 14.5, 23.5, 15.25, 15.5)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0, 15.25, -8, 16, 16, 24),
            Block.createCuboidShape(14.5, 0, -7.5, 15.5, 15.25, -6.5),
            Block.createCuboidShape(0.5, 0, -7.5, 1.5, 15.25, -6.5),
            Block.createCuboidShape(14.5, 0, 22.5, 15.5, 15.25, 23.5),
            Block.createCuboidShape(0.5, 0, 22.5, 1.5, 15.25, 23.5)
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
            if ((world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.TABLE_2X1_BLACK) {
                {
                    BlockPos _bp = BlockPos.ofFloored(x, y, z);
                    BlockState _bs = ModBlocks.TABLE_2X1_BLACK_ALT.getDefaultState();
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
            else if ((world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.TABLE_2X1_WHITE) {
                {
                    BlockPos _bp = BlockPos.ofFloored(x, y, z);
                    BlockState _bs = ModBlocks.TABLE_2X1_WHITE_ALT.getDefaultState();
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