package net.nhatjs.nextgen_furniture.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> TABLE_2X1_BLACK = createTag("table_2x1_black");
        public static final TagKey<Item> TABLE_2X1_WHITE = createTag("table_2x1_white");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name));
        }
    }
}