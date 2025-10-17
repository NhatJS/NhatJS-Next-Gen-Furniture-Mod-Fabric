package net.nhatjs.nextgen_furniture.recipes;

import com.mojang.serialization.MapCodec;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class NextGenShapedRecipe implements Recipe<CraftingRecipeInput> {
    public final ShapedRecipe vanilla; // bọc recipe shaped gốc

    public NextGenShapedRecipe(ShapedRecipe vanilla) { this.vanilla = vanilla; }

    @Override public boolean matches(CraftingRecipeInput inv, World world) { return vanilla.matches(inv, world); }
    @Override public ItemStack craft(CraftingRecipeInput inv, RegistryWrapper.WrapperLookup reg) { return vanilla.craft(inv, reg); }
    @Override public boolean fits(int w, int h) { return vanilla.fits(w, h); }
    @Override public ItemStack getResult(RegistryWrapper.WrapperLookup reg) { return vanilla.getResult(reg); }
    @Override public RecipeSerializer<?> getSerializer() { return ModRecipes.NEXTGEN_SHAPED; }
    @Override public RecipeType<?> getType() { return ModRecipes.NEXTGEN_TYPE; }
    public CraftingRecipeCategory getCategory() { return vanilla.getCategory(); }

    public DefaultedList<ItemStack> getRemainder(CraftingRecipeInput recipeInput, DynamicRegistryManager regs) {
        return vanilla.getRemainder(recipeInput);
    }

    /** Serializer: lấy codec của ShapedRecipe và chuyển thành NextGenShapedRecipe */
    public static class Serializer implements RecipeSerializer<NextGenShapedRecipe> {
        // JSON codec
        @Override
        public MapCodec<NextGenShapedRecipe> codec() {
            return ShapedRecipe.Serializer.CODEC.xmap(NextGenShapedRecipe::new, r -> r.vanilla);
        }

        @Override
        public PacketCodec<RegistryByteBuf, NextGenShapedRecipe> packetCodec() {
            return ShapedRecipe.Serializer.PACKET_CODEC.xmap(NextGenShapedRecipe::new, r -> r.vanilla);
        }
    }
}