package net.nhatjs.nextgen_furniture;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.nhatjs.nextgen_furniture.datagen.ModItemTagProvider;
import net.nhatjs.nextgen_furniture.datagen.ModLootTableProvider;
import net.nhatjs.nextgen_furniture.datagen.ModModelProvider;
import net.nhatjs.nextgen_furniture.datagen.ModRecipeProvider;

public class NhatJSNextGenFurnitureModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
