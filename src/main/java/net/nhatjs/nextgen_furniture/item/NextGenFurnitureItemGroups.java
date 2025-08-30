package net.nhatjs.nextgen_furniture.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.NextGenFurnitureBlocks;

public class NextGenFurnitureItemGroups {
    public static final ItemGroup NEXTGEN_FURNITURE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "light_gray_"),
            FabricItemGroup.builder().icon(() -> new ItemStack(NextGenFurnitureBlocks.LIGHT_GRAY_CEMENTO))
                    .displayName(Text.translatable("itemgroup.nextgen_furniture.nextgen_furniture_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(NextGenFurnitureBlocks.LIGHT_GRAY_CEMENTO);
                        entries.add(NextGenFurnitureBlocks.MODERN_TABLE);
                    }).build());

    public static void registerItemGroups() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Item Groups for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
