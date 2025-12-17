package net.nhatjs.nextgen_furniture.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

import java.util.function.Function;

public class ModItems {
    public static final Item NEXTGEN_FURNITURE_LOGO = registerItem("nextgen_furniture_logo", Item::new);
    public static final Item COMPUTER_FAN_BLADE_WHITE = registerItem("computer_fan_blade_white", Item::new);
    public static final Item COMPUTER_RAM_GAMING = registerItem("computer_ram_gaming", Item::new);
    public static final Item COMPUTER_CPU = registerItem("computer_cpu", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
