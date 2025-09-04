package net.nhatjs.nextgen_furniture.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
