package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.gamingpc.*;

import java.util.function.Function;

import static net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod.MOD_ID;

public class ModBlocks {
    public static Block CHAIR_WHITE = registerBlock("chair_white",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_WOOD_OAK = registerBlock("chair_wood_oak",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_BLACK = registerBlock("table_2x1_black",
            properties -> new Table2x1CenterBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_BLACK_ALT = registerBlock("table_2x1_black_alt",
            properties -> new Table2x1LeftBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_BLACK_ALT_2 = registerBlock("table_2x1_black_alt_2",
            properties -> new Table2x1RightBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_WHITE = registerBlock("table_2x1_white",
            properties -> new Table2x1CenterBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_WHITE_ALT = registerBlock("table_2x1_white_alt",
            properties -> new Table2x1LeftBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_2X1_WHITE_ALT_2 = registerBlock("table_2x1_white_alt_2",
            properties -> new Table2x1RightBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_3X1_BLACK = registerBlock("table_3x1_black",
            properties -> new Table3x1Block(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_3X1_WHITE = registerBlock("table_3x1_white",
            properties -> new Table3x1Block(properties.strength(1.0f).nonOpaque()));
    public static Block COFFEE_TABLE_WHITE = registerBlock("coffee_table_white",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_DINING_WHITE = registerBlock("table_dining_white",
            properties -> new DiningTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_DINING_WOOD_OAK = registerBlock("table_dining_wood_oak",
            properties -> new DiningTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TV_STAND_WOOD_OAK = registerBlock("tv_stand_wood_oak",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PICTURE_FRAME = registerBlock("picture_frame",
            properties -> new PictureFrameBlock(properties.strength(0.2f).nonOpaque()));
    public static Block TRASH_CAN_BLACK = registerBlock("trash_can_black",
            properties -> new TrashCanBlock(properties.strength(0.2f).nonOpaque()));
    public static Block TRASH_CAN_WHITE = registerBlock("trash_can_white",
            properties -> new TrashCanBlock(properties.strength(0.2f).nonOpaque()));
    public static Block SOFA_GRAY = registerBlock("sofa_gray",
            properties -> new SofaBlock(DyeColor.GRAY, properties.strength(1.0f).nonOpaque()));
    public static Block FLOOR_LAMP = registerBlock("floor_lamp",
            properties -> new FloorLampBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LAPTOP = registerBlock("laptop",
            properties -> new LaptopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TV_OLED = registerBlock("tv_oled",
            properties -> new TVBlock(properties.strength(1.0f).nonOpaque()));

    public static Block CHAIR_WOOD_BIRCH = registerBlock("chair_wood_birch",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TV_STAND_WOOD_BIRCH = registerBlock("tv_stand_wood_birch",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_DINING_WOOD_BIRCH = registerBlock("table_dining_wood_birch",
            properties -> new DiningTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_1X1_BLACK = registerBlock("table_1x1_black",
            properties -> new Table1x1Block(properties.strength(1.0f).nonOpaque()));
    public static Block TABLE_1X1_WHITE = registerBlock("table_1x1_white",
            properties -> new Table1x1Block(properties.strength(1.0f).nonOpaque()));
    public static Block FLOOR_LAMP_B = registerBlock("floor_lamp_b",
            properties -> new FloorLampBlock(properties.strength(1.0f).nonOpaque()));
    public static Block SOFA_WHITE = registerBlock("sofa_white",
            properties -> new SofaBlock(DyeColor.WHITE, properties.strength(1.0f).nonOpaque()));
    public static Block BED_GRAY_WOOD_OAK = registerBlock("bed_gray_wood_oak",
            properties -> new BedWoodBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BED_GRAY_WOOD_BIRCH = registerBlock("bed_gray_wood_birch",
            properties -> new BedWoodBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BED_WHITE_WOOD_OAK = registerBlock("bed_white_wood_oak",
            properties -> new BedWoodBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BED_WHITE_WOOD_BIRCH = registerBlock("bed_white_wood_birch",
            properties -> new BedWoodBlock(properties.strength(1.0f).nonOpaque()));

    public static Block MONITOR = registerBlock("monitor",
            properties -> new MonitorBlock(properties.strength(1.0F).nonOpaque()));
    public static Block MONITOR_GAMING_MINIMALIST = registerBlock("monitor_gaming_minimalist",
            properties -> new MonitorTypesBlock(properties.strength(1.0F).nonOpaque()));
    public static Block MOUSE_GAMING_BLACK = registerBlock("mouse_gaming_black",
            properties -> new ComputerMouseBlock(properties.strength(1.0F).nonOpaque()));
    public static Block KEYBOARD_MECHANICAL_BLACK = registerBlock("keyboard_mechanical_black",
            properties -> new KeyboardBlock(properties.strength(1.0F).nonOpaque()));
    public static Block GAME_CONSOLE = registerBlock("game_console",
            properties -> new ConsoleBlock(properties.strength(1.0F).nonOpaque()));

    public static Block KEYBOARD_MECHANICAL_BLACK_WOOD_OAK = registerBlock("keyboard_mechanical_black_wood_oak",
            properties -> new KeyboardBlock(properties.strength(1.0F).nonOpaque()));
    public static Block KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH = registerBlock("keyboard_mechanical_black_wood_birch",
            properties -> new KeyboardBlock(properties.strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_OAK_LEFT = registerBlock("wardrobe_modern_wood_oak_left",
            properties -> new WardrobeBlock(properties.strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_BIRCH_LEFT = registerBlock("wardrobe_modern_wood_birch_left",
            properties -> new WardrobeBlock(properties.strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_OAK_RIGHT = registerBlock("wardrobe_modern_wood_oak_right",
            properties -> new WardrobeBlock(properties.strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_BIRCH_RIGHT = registerBlock("wardrobe_modern_wood_birch_right",
            properties -> new WardrobeBlock(properties.strength(1.0F).nonOpaque()));
    public static Block CHAIR_2_WHITE_WHITE = registerBlock("chair_2_white_white",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WHITE_GRAY = registerBlock("chair_2_white_gray",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_OAK_WHITE = registerBlock("chair_2_wood_oak_white",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_OAK_GRAY = registerBlock("chair_2_wood_oak_gray",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_BIRCH_WHITE = registerBlock("chair_2_wood_birch_white",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_BIRCH_GRAY = registerBlock("chair_2_wood_birch_gray",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC_GAMING = registerBlock("pc_gaming",
            properties -> new DesktopBlock(properties.strength(2.0F).nonOpaque()));
    public static Block COMPUTER_CASE_GAMING = registerBlock("computer_case_gaming",
            properties -> new ComputerCaseBlock(properties.strength(0.6F).nonOpaque()));
    public static Block COMPUTER_POWER_SUPPLY = registerBlock("computer_power_supply",
            properties -> new PowerSupplyBlock(properties.strength(0.5F).nonOpaque()));
    public static Block MAINBOARD_GAMING = registerBlock("mainboard_gaming",
            properties -> new MainboardBlock(properties.strength(0.75F).nonOpaque()));
    public static Block GRAPHICS_CARD_GAMING = registerBlock("graphics_card_gaming",
            properties -> new GraphicsCardBlock(properties.strength(0.75F).nonOpaque()));
    public static Block AIO_COOLER_3_FANS = registerBlock("aio_cooler_3_fans",
            properties -> new AIOCoolerBlock(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_1 = registerBlock("pc_gaming_added_1",
            properties -> new GamingPCAdded1Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_2 = registerBlock("pc_gaming_added_2",
            properties -> new GamingPCAdded2Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_3 = registerBlock("pc_gaming_added_3",
            properties -> new GamingPCAdded3Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_4 = registerBlock("pc_gaming_added_4",
            properties -> new GamingPCAdded4Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_5 = registerBlock("pc_gaming_added_5",
            properties -> new GamingPCAdded5Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_6 = registerBlock("pc_gaming_added_6",
            properties -> new GamingPCAdded6Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_7 = registerBlock("pc_gaming_added_7",
            properties -> new GamingPCAdded7Block(properties.strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_8 = registerBlock("pc_gaming_added_8",
            properties -> new GamingPCAdded8Block(properties.strength(0.75F).nonOpaque()));

    public static Block MONITOR_DUAL = registerBlock("monitor_dual",
            properties -> new DualMonitorBlock(properties.strength(1F).nonOpaque()));
    public static Block MONITOR_DUAL_ALT = registerBlock("monitor_dual_alt",
            properties -> new DualMonitorAlternateBlock(properties.strength(1F).nonOpaque()));
    public static Block MONITOR_DUAL_ALT_2 = registerBlock("monitor_dual_alt_2",
            properties -> new DualMonitorAlternate2Block(properties.strength(1F).nonOpaque()));

    public static Block DRAWER_3_K_M_WOOD_OAK = registerBlock("drawer_3_k_m_wood_oak",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_3_K_M_WOOD_BIRCH = registerBlock("drawer_3_k_m_wood_birch",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_3_K_M_WOOD_OAK_BASE = registerBlock("drawer_3_k_m_wood_oak_base",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_3_K_M_WOOD_BIRCH_BASE = registerBlock("drawer_3_k_m_wood_birch_base",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_2_K_M_WOOD_OAK = registerBlock("drawer_2_k_m_wood_oak",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_2_K_M_WOOD_BIRCH = registerBlock("drawer_2_k_m_wood_birch",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_2_K_M_WOOD_OAK_BASE = registerBlock("drawer_2_k_m_wood_oak_base",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block DRAWER_2_K_M_WOOD_BIRCH_BASE = registerBlock("drawer_2_k_m_wood_birch_base",
            properties -> new DrawerBlock(properties.strength(1F).nonOpaque()));
    public static Block LIGHT_MODERN = registerBlock("light_modern",
            properties -> new ModernLightBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_1X1_WOOD_OAK = registerBlock("table_1x1_wood_oak",
            properties -> new Table1x1Block(properties.strength(1F).nonOpaque()));
    public static Block TABLE_1X1_WOOD_BIRCH = registerBlock("table_1x1_wood_birch",
            properties -> new Table1x1Block(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_OAK = registerBlock("table_2x1_wood_oak",
            properties -> new Table2x1CenterBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_BIRCH = registerBlock("table_2x1_wood_birch",
            properties -> new Table2x1CenterBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_OAK_ALT = registerBlock("table_2x1_wood_oak_alt",
            properties -> new Table2x1LeftBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_BIRCH_ALT = registerBlock("table_2x1_wood_birch_alt",
            properties -> new Table2x1LeftBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_OAK_ALT_2 = registerBlock("table_2x1_wood_oak_alt_2",
            properties -> new Table2x1RightBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_2X1_WOOD_BIRCH_ALT_2 = registerBlock("table_2x1_wood_birch_alt_2",
            properties -> new Table2x1RightBlock(properties.strength(1F).nonOpaque()));
    public static Block TABLE_3X1_WOOD_OAK = registerBlock("table_3x1_wood_oak",
            properties -> new Table3x1Block(properties.strength(1F).nonOpaque()));
    public static Block TABLE_3X1_WOOD_BIRCH = registerBlock("table_3x1_wood_birch",
            properties -> new Table3x1Block(properties.strength(1F).nonOpaque()));
    public static Block WASHING_MACHINE = registerBlock("washing_machine",
            properties -> new WashingMachineBlock(properties.strength(1F).nonOpaque()));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }

    private ModBlocks() {}
}