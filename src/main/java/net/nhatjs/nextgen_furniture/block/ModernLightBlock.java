package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
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
import net.nhatjs.nextgen_furniture.blockentity.client.LightBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ModernLightBlock extends BlockWithEntity {
    public static final EnumProperty<Direction> FACING = Properties.FACING;
    public static final BooleanProperty LIT = BooleanProperty.of("lamp");

    public ModernLightBlock(Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 13 : 0));
        setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(LIT, false));
    }

    public static final MapCodec<ModernLightBlock> CODEC = createCodec(ModernLightBlock::new);

    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> createCuboidShape(5, 5, 15, 11, 11, 16);
            case SOUTH -> createCuboidShape(5, 5, 0, 11, 11, 1);
            case EAST -> createCuboidShape(0, 5, 5, 1, 11, 11);
            case WEST -> createCuboidShape(15, 5, 5, 16, 11, 11);
            case UP -> createCuboidShape(5, 0, 5, 11, 1, 11);
            case DOWN -> createCuboidShape(5, 15, 5, 11, 16, 11);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LightBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof LightBlockEntity light)) return ActionResult.PASS;
        light.setPowered(!light.isPowered());
        world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        return ActionResult.SUCCESS;
    }
}