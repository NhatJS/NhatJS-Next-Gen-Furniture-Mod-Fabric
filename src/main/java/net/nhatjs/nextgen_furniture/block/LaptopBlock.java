package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LaptopBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.FACING; // ← thêm hướng
    public static final IntProperty OPEN_STAGE = IntProperty.of("open_stage", 0, 8);
    public static final BooleanProperty OPEN_TARGET = BooleanProperty.of("open_target");
    public static final BooleanProperty SCREEN_ON = BooleanProperty.of("screen_on");
    public static final IntProperty BOOT_STAGE = IntProperty.of("boot_stage", 0, 5);

    public LaptopBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(OPEN_STAGE, 0)
                .with(OPEN_TARGET, false)
                .with(SCREEN_ON, false)
                .with(BOOT_STAGE, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> createCuboidShape(2, 0, 2, 14, 2, 14);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN_STAGE, OPEN_TARGET, SCREEN_ON, BOOT_STAGE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // đặt block xoay mặt về phía player
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        int stage = state.get(OPEN_STAGE);
        boolean screenOn = state.get(SCREEN_ON);

        // --- Sneak + Click ---
        if (player.isSneaking()) {
            if (stage == 0) {
                // mở nắp
                world.setBlockState(pos, state.with(OPEN_TARGET, true));
                world.scheduleBlockTick(pos, this, 2);
                return ActionResult.CONSUME;
            }
            if (stage == 7 || stage == 8) {
                // đóng nắp (chỉ khi màn hình off)
                if (screenOn) return ActionResult.CONSUME;
                world.setBlockState(pos, state.with(OPEN_TARGET, false));
                world.scheduleBlockTick(pos, this, 2);
                return ActionResult.CONSUME;
            }
            return ActionResult.CONSUME;
        }

        // --- Đứng + Click ---
        if (stage == 7) {
            // nắp mở hết nhưng chưa boot → bắt đầu boot
            world.setBlockState(pos, state.with(OPEN_STAGE, 8).with(BOOT_STAGE, 0).with(SCREEN_ON, false));
            world.scheduleBlockTick(pos, this, 10);
            return ActionResult.CONSUME;
        }
        if (stage == 8) {
            if (screenOn) {
                // tắt màn hình
                world.setBlockState(pos, state.with(SCREEN_ON, false).with(BOOT_STAGE, 0).with(OPEN_STAGE, 7));
            } else {
                // bật lại boot (nếu muốn toggle)
                world.setBlockState(pos, state.with(BOOT_STAGE, 0));
                world.scheduleBlockTick(pos, this, 10);
            }
            return ActionResult.CONSUME;
        }

        return ActionResult.CONSUME;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int stage = state.get(OPEN_STAGE);
        boolean wantOpen = state.get(OPEN_TARGET);

        // --- Animate nắp (0..7) ---
        if ((wantOpen && stage < 7) || (!wantOpen && stage > 0)) {
            int next = wantOpen ? stage + 1 : stage - 1;
            world.setBlockState(pos, state.with(OPEN_STAGE, next));
            world.scheduleBlockTick(pos, this, 1); // 2 tick/frame
            return;
        }

        // --- Animate boot (stage=8) ---
        if (stage == 8 && !state.get(SCREEN_ON)) {
            int boot = state.get(BOOT_STAGE);
            if (boot < 5) {
                int nextBoot = boot + 1;
                world.setBlockState(pos, state.with(BOOT_STAGE, nextBoot));
                world.scheduleBlockTick(pos, this, 20); // 10 tick/frame
            } else if (boot == 5) {
                // Boot xong → bật màn hình
                world.setBlockState(pos, state.with(SCREEN_ON, true).with(BOOT_STAGE, 0));
            }
        }
    }
}