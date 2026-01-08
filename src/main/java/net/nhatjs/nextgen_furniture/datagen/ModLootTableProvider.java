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

        addDrop(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK);
        addDrop(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH);
        addDrop(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT);
        addDrop(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT);
        addDrop(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT);
        addDrop(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT);
        addDrop(ModBlocks.CHAIR_2_WHITE_GRAY);
        addDrop(ModBlocks.CHAIR_2_WHITE_WHITE);
        addDrop(ModBlocks.CHAIR_2_WOOD_OAK_GRAY);
        addDrop(ModBlocks.CHAIR_2_WOOD_OAK_WHITE);
        addDrop(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY);
        addDrop(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE);
        addDrop(ModBlocks.PC_GAMING);
        addDrop(ModBlocks.COMPUTER_CASE_GAMING);
        addDrop(ModBlocks.COMPUTER_POWER_SUPPLY);
        addDrop(ModBlocks.MAINBOARD_GAMING);
        addDrop(ModBlocks.GRAPHICS_CARD_GAMING);
        addDrop(ModBlocks.AIO_COOLER_3_FANS);
        addDrop(ModBlocks.PC_GAMING_ADDED_1);
        addDrop(ModBlocks.PC_GAMING_ADDED_2);
        addDrop(ModBlocks.PC_GAMING_ADDED_3);
        addDrop(ModBlocks.PC_GAMING_ADDED_4);
        addDrop(ModBlocks.PC_GAMING_ADDED_5);
        addDrop(ModBlocks.PC_GAMING_ADDED_6);
        addDrop(ModBlocks.PC_GAMING_ADDED_7);
        addDrop(ModBlocks.PC_GAMING_ADDED_8);

        addDrop(ModBlocks.MONITOR_DUAL);
        addDrop(ModBlocks.MONITOR_DUAL_ALT);
        addDrop(ModBlocks.MONITOR_DUAL_ALT_2);

        addDrop(ModBlocks.DRAWER_3_K_M_WOOD_OAK);
        addDrop(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH);
        addDrop(ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE);
        addDrop(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE);
        addDrop(ModBlocks.DRAWER_2_K_M_WOOD_OAK);
        addDrop(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH);
        addDrop(ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE);
        addDrop(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE);
        addDrop(ModBlocks.LIGHT_MODERN);
        addDrop(ModBlocks.TABLE_1X1_WOOD_OAK);
        addDrop(ModBlocks.TABLE_1X1_WOOD_BIRCH);
        addDrop(ModBlocks.TABLE_2X1_WOOD_OAK);
        addDrop(ModBlocks.TABLE_2X1_WOOD_OAK_ALT);
        addDrop(ModBlocks.TABLE_2X1_WOOD_OAK_ALT_2);
        addDrop(ModBlocks.TABLE_2X1_WOOD_BIRCH);
        addDrop(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT);
        addDrop(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT_2);
        addDrop(ModBlocks.TABLE_3X1_WOOD_OAK);
        addDrop(ModBlocks.TABLE_3X1_WOOD_BIRCH);
        addDrop(ModBlocks.WASHING_MACHINE);
    }
}
