package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.gamingpc.*;

import static net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod.MOD_ID;

public class ModBlocks {
    public static final Block CHAIR_WHITE = register("chair_white",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block CHAIR_WOOD_OAK = register("chair_wood_oak",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK = register("table_2x1_black",
            new Table2x1CenterBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK_ALT = register("table_2x1_black_alt",
            new Table2x1LeftBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK_ALT_2 = register("table_2x1_black_alt_2",
            new Table2x1RightBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE = register("table_2x1_white",
            new Table2x1CenterBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE_ALT = register("table_2x1_white_alt",
            new Table2x1LeftBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE_ALT_2 = register("table_2x1_white_alt_2",
            new Table2x1RightBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_3X1_BLACK = register("table_3x1_black",
            new Table3x1Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_3X1_WHITE = register("table_3x1_white",
            new Table3x1Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block COFFEE_TABLE_WHITE = register("coffee_table_white",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_DINING_WHITE = register("table_dining_white",
            new DiningTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_DINING_WOOD_OAK = register("table_dining_wood_oak",
            new DiningTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TV_STAND_WOOD_OAK = register("tv_stand_wood_oak",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block PICTURE_FRAME = register("picture_frame",
            new PictureFrameBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static final Block TRASH_CAN_BLACK = register("trash_can_black",
            new TrashCanBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static final Block TRASH_CAN_WHITE = register("trash_can_white",
            new TrashCanBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static final Block SOFA_GRAY = register("sofa_gray",
            new SofaBlock(DyeColor.GRAY, AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block FLOOR_LAMP = register("floor_lamp",
            new FloorLampBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block LAPTOP = register("laptop",
            new LaptopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TV_OLED = register("tv_oled",
            new TVBlock(Block.Settings.create().strength(1.0f).nonOpaque()));

    public static final Block CHAIR_WOOD_BIRCH = register("chair_wood_birch",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TV_STAND_WOOD_BIRCH = register("tv_stand_wood_birch",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_DINING_WOOD_BIRCH = register("table_dining_wood_birch",
            new DiningTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_1X1_BLACK = register("table_1x1_black",
            new Table1x1Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_1X1_WHITE = register("table_1x1_white",
            new Table1x1Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block FLOOR_LAMP_B = register("floor_lamp_b",
            new FloorLampBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block SOFA_WHITE = register("sofa_white",
            new SofaBlock(DyeColor.WHITE, AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block BED_GRAY_WOOD_OAK = register("bed_gray_wood_oak",
            new BedWoodBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block BED_GRAY_WOOD_BIRCH = register("bed_gray_wood_birch",
            new BedWoodBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block BED_WHITE_WOOD_OAK = register("bed_white_wood_oak",
            new BedWoodBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block BED_WHITE_WOOD_BIRCH = register("bed_white_wood_birch",
            new BedWoodBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    
    public static Block MONITOR = register("monitor",
            new MonitorBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block MONITOR_GAMING_MINIMALIST = register("monitor_gaming_minimalist",
            new MonitorTypesBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block MOUSE_GAMING_BLACK = register("mouse_gaming_black",
            new ComputerMouseBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block KEYBOARD_MECHANICAL_BLACK = register("keyboard_mechanical_black",
            new KeyboardBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block GAME_CONSOLE = register("game_console",
            new ConsoleBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));

    public static Block KEYBOARD_MECHANICAL_BLACK_WOOD_OAK = register("keyboard_mechanical_black_wood_oak",
            new KeyboardBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH = register("keyboard_mechanical_black_wood_birch",
            new KeyboardBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_OAK_LEFT = register("wardrobe_modern_wood_oak_left",
            new WardrobeBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_BIRCH_LEFT = register("wardrobe_modern_wood_birch_left",
            new WardrobeBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_OAK_RIGHT = register("wardrobe_modern_wood_oak_right",
            new WardrobeBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block WARDROBE_MODERN_WOOD_BIRCH_RIGHT = register("wardrobe_modern_wood_birch_right",
            new WardrobeBlock(AbstractBlock.Settings.create().strength(1.0F).nonOpaque()));
    public static Block CHAIR_2_WHITE_WHITE = register("chair_2_white_white",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WHITE_GRAY = register("chair_2_white_gray",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_OAK_WHITE = register("chair_2_wood_oak_white",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_OAK_GRAY = register("chair_2_wood_oak_gray",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_BIRCH_WHITE = register("chair_2_wood_birch_white",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block CHAIR_2_WOOD_BIRCH_GRAY = register("chair_2_wood_birch_gray",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block PC_GAMING = register("pc_gaming",
            new DesktopBlock(AbstractBlock.Settings.create().strength(2.0F).nonOpaque()));
    public static Block COMPUTER_CASE_GAMING = register("computer_case_gaming",
            new ComputerCaseBlock(AbstractBlock.Settings.create().strength(0.6F).nonOpaque()));
    public static Block COMPUTER_POWER_SUPPLY = register("computer_power_supply",
            new PowerSupplyBlock(AbstractBlock.Settings.create().strength(0.5F).nonOpaque()));
    public static Block MAINBOARD_GAMING = register("mainboard_gaming",
            new MainboardBlock(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block GRAPHICS_CARD_GAMING = register("graphics_card_gaming",
            new GraphicsCardBlock(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block AIO_COOLER_3_FANS = register("aio_cooler_3_fans",
            new AIOCoolerBlock(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_1 = register("pc_gaming_added_1",
            new GamingPCAdded1Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_2 = register("pc_gaming_added_2",
            new GamingPCAdded2Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_3 = register("pc_gaming_added_3",
            new GamingPCAdded3Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_4 = register("pc_gaming_added_4",
            new GamingPCAdded4Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_5 = register("pc_gaming_added_5",
            new GamingPCAdded5Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_6 = register("pc_gaming_added_6",
            new GamingPCAdded6Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_7 = register("pc_gaming_added_7",
            new GamingPCAdded7Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));
    public static Block PC_GAMING_ADDED_8 = register("pc_gaming_added_8",
            new GamingPCAdded8Block(AbstractBlock.Settings.create().strength(0.75F).nonOpaque()));

    public static Block MONITOR_DUAL = register("monitor_dual",
            new DualMonitorBlock(AbstractBlock.Settings.create().strength(1F).nonOpaque()));
    public static Block MONITOR_DUAL_ALT = register("monitor_dual_alt",
            new DualMonitorAlternateBlock(AbstractBlock.Settings.create().strength(1F).nonOpaque()));
    public static Block MONITOR_DUAL_ALT_2 = register("monitor_dual_alt_2",
            new DualMonitorAlternate2Block(AbstractBlock.Settings.create().strength(1F).nonOpaque()));

    private static <T extends Block> T register(String name, T block) {
        Identifier id = Identifier.of(MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    private static void registerItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Blocks for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
    private ModBlocks() {}

}