package net.nhatjs.nextgen_furniture.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup NEXTGEN_FURNITURE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "nextgen_furniture_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NEXTGEN_FURNITURE_LOGO))
                    .displayName(Text.translatable("itemgroup.nextgen_furniture.nextgen_furniture_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHAIR_WHITE);
                        entries.add(ModBlocks.CHAIR_WOOD_OAK);
                        entries.add(ModBlocks.CHAIR_WOOD_BIRCH);
                        entries.add(ModBlocks.CHAIR_2_WHITE_GRAY);
                        entries.add(ModBlocks.CHAIR_2_WHITE_WHITE);
                        entries.add(ModBlocks.CHAIR_2_WOOD_OAK_GRAY);
                        entries.add(ModBlocks.CHAIR_2_WOOD_OAK_WHITE);
                        entries.add(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY);
                        entries.add(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE);
                        entries.add(ModBlocks.TABLE_1X1_BLACK);
                        entries.add(ModBlocks.TABLE_1X1_WHITE);
                        entries.add(ModBlocks.TABLE_2X1_BLACK);
                        entries.add(ModBlocks.TABLE_2X1_WHITE);
                        entries.add(ModBlocks.TABLE_3X1_BLACK);
                        entries.add(ModBlocks.TABLE_3X1_WHITE);
                        entries.add(ModBlocks.COFFEE_TABLE_WHITE);
                        entries.add(ModBlocks.TABLE_DINING_WHITE);
                        entries.add(ModBlocks.TABLE_DINING_WOOD_OAK);
                        entries.add(ModBlocks.TABLE_DINING_WOOD_BIRCH);
                        entries.add(ModBlocks.TV_STAND_WOOD_OAK);
                        entries.add(ModBlocks.TV_STAND_WOOD_BIRCH);
                        entries.add(ModBlocks.BED_GRAY_WOOD_OAK);
                        entries.add(ModBlocks.BED_GRAY_WOOD_BIRCH);
                        entries.add(ModBlocks.BED_WHITE_WOOD_OAK);
                        entries.add(ModBlocks.BED_WHITE_WOOD_BIRCH);
                        entries.add(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT);
                        entries.add(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT);
                        entries.add(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT);
                        entries.add(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT);
                        entries.add(ModBlocks.PICTURE_FRAME);
                        entries.add(ModBlocks.TRASH_CAN_BLACK);
                        entries.add(ModBlocks.TRASH_CAN_WHITE);
                        entries.add(ModBlocks.SOFA_GRAY);
                        entries.add(ModBlocks.SOFA_WHITE);
                        entries.add(ModBlocks.FLOOR_LAMP);
                        entries.add(ModBlocks.FLOOR_LAMP_B);
                        entries.add(ModBlocks.MONITOR);
                        entries.add(ModBlocks.MONITOR_GAMING_MINIMALIST);
                        entries.add(ModBlocks.KEYBOARD_MECHANICAL_BLACK);
                        entries.add(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK);
                        entries.add(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH);
                        entries.add(ModBlocks.MOUSE_GAMING_BLACK);
                        entries.add(ModBlocks.PC_GAMING);
                        entries.add(ModBlocks.LAPTOP);
                        entries.add(ModBlocks.TV_OLED);
                        entries.add(ModBlocks.GAME_CONSOLE);
                        entries.add(ModBlocks.COMPUTER_CASE_GAMING);
                        entries.add(ModItems.COMPUTER_FAN_BLADE_WHITE);
                        entries.add(ModItems.COMPUTER_RAM_GAMING);
                        entries.add(ModBlocks.COMPUTER_POWER_SUPPLY);
                        entries.add(ModBlocks.MAINBOARD_GAMING);
                        entries.add(ModBlocks.GRAPHICS_CARD_GAMING);
                        entries.add(ModBlocks.AIO_COOLER_3_FANS);
                        entries.add(ModItems.COMPUTER_CPU);
                    }).build());

    public static void registerItemGroups() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Item Groups for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
