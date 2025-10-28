package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

import java.util.List;

public class SofaBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<Part> PART = EnumProperty.of("part", Part.class);

    private static final MapCodec<SofaBlock> CODEC = RecordCodecBuilder.mapCodec(builder -> {
        return builder.group(DyeColor.CODEC.fieldOf("color").forGetter(block -> {
            return block.color;
        }), createSettingsCodec()).apply(builder, SofaBlock::new);
    });

    private final DyeColor color;

    public SofaBlock(DyeColor color, Settings settings)
    {
        super(settings);
        this.color = color;
    }

    public DyeColor getColor()
    {
        return this.color;
    }

    @Override
    protected MapCodec<SofaBlock> getCodec()
    {
        return CODEC;
    }

    public enum Part implements StringIdentifiable
    {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right");

        private final String name;

        Part(String name)
        {
            this.name = name;
        }

        @Override
        public String asString()
        {
            return name;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, PART);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction facing = ctx.getHorizontalPlayerFacing();
        BlockState state = this.getDefaultState().with(FACING, facing);
        if(state != null)
        {
            return state.with(PART, this.getShape(state, ctx.getWorld(), ctx.getBlockPos()));
        }
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 1, 0, 16, 7.525, 16);
        };
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction dir, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state.with(PART, this.getShape(state, world, pos));
    }

    public Part getShape(BlockState state, WorldAccess level, BlockPos pos)
    {
        Direction facing = state.get(FACING);
        Direction front = this.getSofaState(level, pos, facing.getOpposite());
        if(front != null)
        {
            if(front == facing.rotateYClockwise())
            {
                return Part.CORNER_RIGHT;
            }
            else if(front == facing.rotateYCounterclockwise())
            {
                return Part.CORNER_LEFT;
            }
        }
        boolean left = this.isConnectable(level, pos, facing, facing.rotateYCounterclockwise());
        boolean right = this.isConnectable(level, pos, facing, facing.rotateYClockwise());
        if(left && right)
        {
            return Part.MIDDLE;
        }
        else if(left)
        {
            return Part.RIGHT;
        }
        else if(right)
        {
            return Part.LEFT;
        }
        return Part.SINGLE;
    }

    private Direction getSofaState(WorldAccess level, BlockPos pos, Direction side)
    {
        BlockState relativeState = level.getBlockState(pos.offset(side));
        return relativeState.getBlock() instanceof SofaBlock ? relativeState.get(FACING) : null;
    }

    private boolean isConnectable(WorldAccess level, BlockPos pos, Direction facing, Direction offset)
    {
        BlockPos relativePos = pos.offset(offset);
        BlockState relativeState = level.getBlockState(pos.offset(offset));
        if(relativeState.getBlock() instanceof SofaBlock)
        {
            Direction other = relativeState.get(FACING);
            return other == facing || other == offset;
        }
        return relativeState.isSideSolidFullSquare(level, relativePos, offset.getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            Entity entity = null;
            List<ChairBlockEntity> entities = world.getEntitiesByType(ModEntities.SOFA, new Box(pos), chairBlockEntity -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.SOFA.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }
        return ActionResult.SUCCESS;
    }
}
