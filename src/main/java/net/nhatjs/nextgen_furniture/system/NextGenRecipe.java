package net.nhatjs.nextgen_furniture.system;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Map;

public class NextGenRecipe {
    public final int width;
    public final int height;
    public final String[] pattern; // length=height, each string length=width
    public final Map<Character, Item> key = new Object2ObjectOpenHashMap<>();
    public final ItemStack result;

    public NextGenRecipe(int w, int h, String[] patt, Map<Character, Identifier> keyIds, Identifier resultId, int count) {
        this.width = w; this.height = h; this.pattern = patt;
        keyIds.forEach((ch, id) -> key.put(ch, Registries.ITEM.get(id)));
        this.result = new ItemStack(Registries.ITEM.get(resultId), Math.max(1, count));
    }
}