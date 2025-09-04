package net.nhatjs.nextgen_furniture;

import net.fabricmc.api.ModInitializer;

import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.item.ModItemGroups;
import net.nhatjs.nextgen_furniture.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhatJSNextGenFurnitureMod implements ModInitializer {
	public static final String MOD_ID = "nextgen_furniture";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.init();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}