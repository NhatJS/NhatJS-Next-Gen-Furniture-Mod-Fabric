package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.block.entity.NextGenCraftingTableBlockEntity;

public class NextGenCraftingTableBlock extends BlockWithEntity {
	public NextGenCraftingTableBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return null;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) { return BlockRenderType.MODEL; }

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new NextGenCraftingTableBlockEntity(pos, state);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos,
							  PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient) {
			BlockEntity be = world.getBlockEntity(pos);
			if (be instanceof NamedScreenHandlerFactory factory) {
				player.openHandledScreen(factory);
			}
		}
		return ActionResult.SUCCESS;
	}
}