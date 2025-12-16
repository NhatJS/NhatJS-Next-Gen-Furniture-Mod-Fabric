package net.nhatjs.nextgen_furniture.block.gamingpc;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.item.ModItems;

public class GamingPCAdded6Block extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public GamingPCAdded6Block(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(5.025, 0, 0.95, 10.975, 13.75, 15.05);
            case SOUTH -> Block.createCuboidShape(5.025, 0, 0.95, 10.975, 13.75, 15.05);
            case EAST -> Block.createCuboidShape(0.95, 0, 5.025, 15.05, 13.75, 10.975);
            case WEST -> Block.createCuboidShape(0.95, 0, 5.025, 15.05, 13.75, 10.975);
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();
        if (stack.isOf(ModItems.COMPUTER_RAM_GAMING)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.PC_GAMING_ADDED_7.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}
