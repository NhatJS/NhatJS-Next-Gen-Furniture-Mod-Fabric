package net.nhatjs.nextgen_furniture.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<NextGenCraftingTableScreenHandler> NEXTGEN_CRAFTING_TABLE =
            Registry.register(Registries.SCREEN_HANDLER,
                    Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "nextgen_crafting_table"),
                    new ScreenHandlerType<>(NextGenCraftingTableScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    public static void registerModScreenHandlers() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Screen Handlers for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
