package net.nhatjs.nextgen_furniture.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModItems {
    public static final Item NEXTGEN_FURNITURE_LOGO = registerItem("nextgen_furniture_logo", new Item(new Item.Settings()));
    public static final Item COMPUTER_FAN_BLADE_WHITE = registerItem("computer_fan_blade_white", new Item(new Item.Settings()));
    public static final Item COMPUTER_RAM_GAMING = registerItem("computer_ram_gaming", new Item(new Item.Settings()));
    public static final Item COMPUTER_CPU = registerItem("computer_cpu", new Item(new Item.Settings()));
    public static final Item SCREWDRIVER = registerItem("screwdriver", new Item(new Item.Settings()));
    public static final Item DRAWER_WHITE = registerItem("drawer_white", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
