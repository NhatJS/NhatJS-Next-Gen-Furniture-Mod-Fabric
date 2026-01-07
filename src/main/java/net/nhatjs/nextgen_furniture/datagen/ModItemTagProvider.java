package net.nhatjs.nextgen_furniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TABLE_2X1_BLACK)
                .add(ModBlocks.TABLE_2X1_BLACK.asItem())
                .add(ModBlocks.TABLE_2X1_BLACK_ALT.asItem())
                .add(ModBlocks.TABLE_2X1_BLACK_ALT_2.asItem());

        valueLookupBuilder(ModTags.Items.TABLE_2X1_WHITE)
                .add(ModBlocks.TABLE_2X1_WHITE.asItem())
                .add(ModBlocks.TABLE_2X1_WHITE_ALT.asItem())
                .add(ModBlocks.TABLE_2X1_WHITE_ALT_2.asItem());

        valueLookupBuilder(ModTags.Items.TABLE_2X1_WOOD_OAK)
                .add(ModBlocks.TABLE_2X1_WOOD_OAK.asItem())
                .add(ModBlocks.TABLE_2X1_WOOD_OAK_ALT.asItem())
                .add(ModBlocks.TABLE_2X1_WOOD_OAK_ALT_2.asItem());

        valueLookupBuilder(ModTags.Items.TABLE_2X1_WOOD_BIRCH)
                .add(ModBlocks.TABLE_2X1_WOOD_BIRCH.asItem())
                .add(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT.asItem())
                .add(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT_2.asItem());
    }
}
