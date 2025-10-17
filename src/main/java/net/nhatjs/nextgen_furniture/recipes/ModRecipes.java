package net.nhatjs.nextgen_furniture.recipes;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;

public class ModRecipes {
    public static final RecipeType<NextGenShapedRecipe> NEXTGEN_TYPE =
            Registry.register(Registries.RECIPE_TYPE,
                    Identifier.of("nextgen_furniture", "nextgen_crafting"),
                    new RecipeType<>() { public String toString() { return "nextgen_furniture:nextgen_crafting"; }});

    // Serializer cho JSON "nextgen_furniture:nextgen_shaped"
    public static final RecipeSerializer<NextGenShapedRecipe> NEXTGEN_SHAPED =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of("nextgen_furniture", "nextgen_shaped"),
                    new NextGenShapedRecipe.Serializer());  // class bạn sẽ tạo ở bước 2

    public static void registerModRecipes() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Recipes for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}
