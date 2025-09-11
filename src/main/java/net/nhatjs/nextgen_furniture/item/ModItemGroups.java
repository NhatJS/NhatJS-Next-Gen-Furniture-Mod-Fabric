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
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "nextgen_furniture_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NEXTGEN_FURNITURE_LOGO))
                    .displayName(Text.translatable("itemgroup.nextgen_furniture.nextgen_furniture_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHAIR_WHITE);
                        entries.add(ModBlocks.CHAIR_WOOD_OAK);
                        entries.add(ModBlocks.TABLE_2X1_BLACK);
                        entries.add(ModBlocks.TABLE_2X1_WHITE);
                        entries.add(ModBlocks.TABLE_3X1_BLACK);
                        entries.add(ModBlocks.TABLE_3X1_WHITE);
                        entries.add(ModBlocks.TABLE_DINING_WHITE);
                        entries.add(ModBlocks.TABLE_DINING_WOOD_OAK);
                        entries.add(ModBlocks.PICTURE_FRAME);
                        entries.add(ModBlocks.LAPTOP);
                    }).build());

    public static void registerItemGroups() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Item Groups for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
