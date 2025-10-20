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