package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ModInitializer;

import net.nhatjs.nextgen_furniture.block.NextGenFurnitureBlocks;
import net.nhatjs.nextgen_furniture.item.NextGenFurnitureItemGroups;
import net.nhatjs.nextgen_furniture.item.NextGenFurnitureItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhatJSNextGenFurnitureMod implements ModInitializer {
	public static final String MOD_ID = "nextgen_furniture";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		NextGenFurnitureBlocks.registerModBlocks();
		NextGenFurnitureItems.registerModItems();
		NextGenFurnitureItemGroups.registerItemGroups();
	}
}