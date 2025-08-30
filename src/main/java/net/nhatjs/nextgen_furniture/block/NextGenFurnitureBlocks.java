package net.nhatjs.nextgen_furniture.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class NextGenFurnitureBlocks {
    public static final Block LIGHT_GRAY_CEMENTO = registerBlock("light_gray_cemento",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block MODERN_TABLE = registerBlock("modern_table",
            new TableBlock(AbstractBlock.Settings.create().nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Blocks for " + NhatJSNextGenFurnitureMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(NextGenFurnitureBlocks.LIGHT_GRAY_CEMENTO);
        });
    }
}
