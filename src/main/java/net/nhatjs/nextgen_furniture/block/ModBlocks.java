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
            new FloorLampBlock(Block.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block LAPTOP = register("laptop",
            new LaptopBlock(Block.Settings.create().strength(1.0f).nonOpaque()));
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
            new FloorLampBlock(Block.Settings.create().strength(1.0f).nonOpaque()));
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

    private static <T extends Block> T register(String name, T block) {
        Identifier id = Identifier.of(MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Blocks for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
    private ModBlocks() {}

}