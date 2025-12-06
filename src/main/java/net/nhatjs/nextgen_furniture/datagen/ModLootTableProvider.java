package net.nhatjs.nextgen_furniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHAIR_WHITE);
        addDrop(ModBlocks.CHAIR_WOOD_OAK);
        addDrop(ModBlocks.TABLE_2X1_BLACK);
        addDrop(ModBlocks.TABLE_2X1_BLACK_ALT);
        addDrop(ModBlocks.TABLE_2X1_BLACK_ALT_2);
        addDrop(ModBlocks.TABLE_2X1_WHITE);
        addDrop(ModBlocks.TABLE_2X1_WHITE_ALT);
        addDrop(ModBlocks.TABLE_2X1_WHITE_ALT_2);
        addDrop(ModBlocks.TABLE_3X1_BLACK);
        addDrop(ModBlocks.TABLE_3X1_WHITE);
        addDrop(ModBlocks.COFFEE_TABLE_WHITE);
        addDrop(ModBlocks.TABLE_DINING_WHITE);
        addDrop(ModBlocks.TABLE_DINING_WOOD_OAK);
        addDrop(ModBlocks.TV_STAND_WOOD_OAK);
        addDrop(ModBlocks.PICTURE_FRAME);
        addDrop(ModBlocks.TRASH_CAN_BLACK);
        addDrop(ModBlocks.TRASH_CAN_WHITE);
        addDrop(ModBlocks.SOFA_GRAY);
        addDrop(ModBlocks.SOFA_WHITE);
        addDrop(ModBlocks.FLOOR_LAMP);
        addDrop(ModBlocks.LAPTOP);
        addDrop(ModBlocks.TV_OLED);

        addDrop(ModBlocks.CHAIR_WOOD_BIRCH);
        addDrop(ModBlocks.TV_STAND_WOOD_BIRCH);
        addDrop(ModBlocks.TABLE_DINING_WOOD_BIRCH);
        addDrop(ModBlocks.TABLE_1X1_BLACK);
        addDrop(ModBlocks.TABLE_1X1_WHITE);
        addDrop(ModBlocks.FLOOR_LAMP_B);
        addDrop(ModBlocks.BED_GRAY_WOOD_OAK);
        addDrop(ModBlocks.BED_GRAY_WOOD_BIRCH);;
        addDrop(ModBlocks.BED_WHITE_WOOD_OAK);
        addDrop(ModBlocks.BED_WHITE_WOOD_BIRCH);
        
        addDrop(ModBlocks.MONITOR);
        addDrop(ModBlocks.MONITOR_GAMING_MINIMALIST);
        addDrop(ModBlocks.MOUSE_GAMING_BLACK);
        addDrop(ModBlocks.KEYBOARD_MECHANICAL_BLACK);
        addDrop(ModBlocks.GAME_CONSOLE);
    }
}
