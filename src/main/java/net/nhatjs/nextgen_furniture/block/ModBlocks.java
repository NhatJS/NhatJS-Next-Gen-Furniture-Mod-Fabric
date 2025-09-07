package net.nhatjs.nextgen_furniture.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModBlocks {
    public static final Block CHAIR_WHITE = registerBlock("chair_white",
            new ChairBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "chair_white"))).strength(1.0f).nonOpaque()));
    public static final Block CHAIR_WOOD_OAK = registerBlock("chair_wood_oak",
            new ChairBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "chair_wood_oak"))).strength(1.0f).nonOpaque()));
    public static final Block LAPTOP = registerBlock("laptop",
            new LaptopBlock(Block.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "laptop"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK = registerBlock("table_2x1_black",
            new Table2x1CenterBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_black"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK_ALT = registerBlock("table_2x1_black_alt",
            new Table2x1LeftBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_black_alt"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK_ALT_2 = registerBlock("table_2x1_black_alt_2",
            new Table2x1RightBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_black_alt_2"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE = registerBlock("table_2x1_white",
            new Table2x1CenterBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_white"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE_ALT = registerBlock("table_2x1_white_alt",
            new Table2x1LeftBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_white_alt"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_WHITE_ALT_2 = registerBlock("table_2x1_white_alt_2",
            new Table2x1RightBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_2x1_white_alt_2"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_3X1_BLACK = registerBlock("table_3x1_black",
            new Table3x1Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_3x1_black"))).strength(1.0f).nonOpaque()));
    public static final Block TABLE_3X1_WHITE = registerBlock("table_3x1_white",
            new Table3x1Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "table_3x1_white"))).strength(1.0f).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Blocks for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}