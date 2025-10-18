package net.nhatjs.nextgen_furniture.menu;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.client.screen.NextGenCraftingMenu;

public class ModMenus {
    public static ScreenHandlerType<NextGenCraftingMenu> NEXTGEN_CRAFTING_MENU;

    public static void register() {
        NEXTGEN_CRAFTING_MENU = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID,
                "nextgen_crafting_menu"), new ScreenHandlerType<>(NextGenCraftingMenu::new, FeatureFlags.VANILLA_FEATURES));
    }
}
