package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.blockentity.ModBlockEntities;
import net.nhatjs.nextgen_furniture.blockentity.client.LaptopBlockEntity;
import org.jetbrains.annotations.Nullable;

public class LaptopBlock extends BlockWithEntity {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public LaptopBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    public static final MapCodec<LaptopBlock> CODEC = createCodec(LaptopBlock::new);

    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> createCuboidShape(2, 0, 2, 14, 2, 14);
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

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LaptopBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state,
                                                                  BlockEntityType<T> type) {
        return type == ModBlockEntities.LAPTOP ? (w, p, s, be) -> {
            if (be instanceof LaptopBlockEntity lap) {
                LaptopBlockEntity.tick(w, p, s, lap);
            }
        } : null;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;

        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof LaptopBlockEntity lap)) return ActionResult.PASS;

        boolean sneaking = player.isSneaking() || player.isInSneakingPose();

        if (sneaking) {
            if (lap.isPowered()) {
                return ActionResult.CONSUME;
            }
            lap.setTargetOpen(!lap.isTargetOpen());
            world.updateListeners(pos, state, state, 3);
            return ActionResult.CONSUME;
        } else {
            if (lap.isOpenEnough()) {
                lap.setPowered(!lap.isPowered());
                world.updateListeners(pos, state, state, 3);
                return ActionResult.CONSUME;
            }
            return ActionResult.CONSUME;
        }
    }
}