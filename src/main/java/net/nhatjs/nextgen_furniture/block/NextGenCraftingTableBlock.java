package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.screen.NextGenCraftingTableScreenHandler;

public class NextGenCraftingTableBlock extends Block {
	private static final Text TITLE = Text.translatable("container.nextgen_furniture.nextgen_crafting_table");

	public NextGenCraftingTableBlock(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos,
							  PlayerEntity player, BlockHitResult hit) {
		if (world.isClient) return ActionResult.SUCCESS;
		player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
				(syncId, inv, p) -> new NextGenCraftingTableScreenHandler(
						syncId, inv, ScreenHandlerContext.create(world, pos)),
				TITLE
		));
		return ActionResult.CONSUME;
	}
}