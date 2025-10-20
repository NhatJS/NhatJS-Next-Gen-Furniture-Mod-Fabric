package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChairBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty MOVE = BooleanProperty.of("move");

    public ChairBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(MOVE, false));
    }

    private static VoxelShape shapeFor(Direction d) {
        return switch (d) {
            default -> Block.createCuboidShape(3, 0, 2.25, 13, 10.65, 13.75);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return state.get(MOVE) ? VoxelShapes.empty() : shapeFor(state.get(FACING));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return shapeFor(state.get(FACING));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, MOVE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        boolean move = state.get(MOVE);

        if (player.isSneaking()) {
            if (move == false) {
                world.setBlockState(pos, state.with(MOVE, true));
                return ActionResult.SUCCESS;
            }
            if (move == true) {
                world.setBlockState(pos, state.with(MOVE, false));
                return ActionResult.SUCCESS;
            }
            return ActionResult.SUCCESS;
        }
        if (move == true) {
            return ActionResult.SUCCESS;
        }
        if (!world.isClient()) {
            Entity entity = null;
            List<ChairBlockEntity> entities = world.getEntitiesByType(ModEntities.CHAIR, new Box(pos), chairBlockEntity -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }
        return ActionResult.SUCCESS;
    }
}
