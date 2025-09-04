package net.nhatjs.nextgen_furniture.block;

import com.mrcrayfish.framework.FrameworkSetup;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod.MOD_ID;

public class ModBlocks {
    public static final Block LAPTOP = register("laptop",
            new LaptopBlock(Block.Settings.create().strength(1.0f).nonOpaque()));
    public static final Block TABLE_2X1_BLACK = register("table_2x1_black",
            new Table2x1Block(AbstractBlock.Settings.create().nonOpaque()));
    public static final Block TABLE_2X1_WHITE = register("table_2x1_white",
            new Table2x1Block(AbstractBlock.Settings.create().nonOpaque()));
    public static final Block TABLE_3X1_BLACK = register("table_3x1_black",
            new Table3x1Block(AbstractBlock.Settings.create().nonOpaque()));
    public static final Block TABLE_3X1_WHITE = register("table_3x1_white",
            new Table3x1Block(AbstractBlock.Settings.create().nonOpaque()));


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

    public static void init() {}
    private ModBlocks() {}

}