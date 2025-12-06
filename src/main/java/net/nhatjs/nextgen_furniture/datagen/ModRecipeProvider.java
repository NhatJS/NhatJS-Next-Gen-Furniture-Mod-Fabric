package net.nhatjs.nextgen_furniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.nextgen_furniture.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //wood
                Block planksBirch = Blocks.BIRCH_PLANKS;
                Block planksOak = Blocks.OAK_PLANKS;

                //stone
                Block buttonStone = Blocks.STONE_BUTTON;

                //wool
                Block woolGray = Blocks.GRAY_WOOL;
                Block woolWhite = Blocks.WHITE_WOOL;

                //banner

                //concrete
                Block concreteBlack = Blocks.BLACK_CONCRETE;
                Block concreteWhite = Blocks.WHITE_CONCRETE;

                //terracotta
                Block terracottaCyan = Blocks.CYAN_TERRACOTTA;

                //dye
                Item dyeWhite = Items.WHITE_DYE;

                //misc
                Item stick = Items.STICK;

                //glass pane
                Block glassPaneStainedBlack = Blocks.BLACK_STAINED_GLASS_PANE;

                //electronic
                Item redstone = Items.REDSTONE;
                Block redstoneLamp = Blocks.REDSTONE_LAMP;

                //nextgen furniture mod
                Block table1x1Black = ModBlocks.TABLE_1X1_BLACK;
                Block table1x1White = ModBlocks.TABLE_1X1_WHITE;
                Block monitorGamingMinimalist = ModBlocks.MONITOR_GAMING_MINIMALIST;
                Block keyboardMechanicalBlack = ModBlocks.KEYBOARD_MECHANICAL_BLACK;
                Block mouseGamingBlack = ModBlocks.MOUSE_GAMING_BLACK;

                //others
                Block bedGray = Blocks.GRAY_BED;
                Block bedWhite = Blocks.WHITE_BED;
                Block noteBlock = Blocks.NOTE_BLOCK;
                Item endCrystal = Items.END_CRYSTAL;
                Block chest = Blocks.CHEST;
                Item painting = Items.PAINTING;

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BED_GRAY_WOOD_BIRCH)
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', bedGray)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(bedGray), conditionsFromItem(bedGray))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BED_GRAY_WOOD_OAK)
                        .pattern("121")
                        .input('1', planksOak)
                        .input('2', bedGray)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(bedGray), conditionsFromItem(bedGray))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BED_WHITE_WOOD_BIRCH)
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', bedWhite)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(bedWhite), conditionsFromItem(bedWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BED_WHITE_WOOD_OAK)
                        .pattern("121")
                        .input('1', planksOak)
                        .input('2', bedWhite)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(bedWhite), conditionsFromItem(bedWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WHITE, 2)
                        .pattern("2  ")
                        .pattern("211")
                        .pattern("2 2")
                        .input('1', concreteWhite)
                        .input('2', stick)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WOOD_BIRCH, 2)
                        .pattern("2  ")
                        .pattern("211")
                        .pattern("2 2")
                        .input('1', planksBirch)
                        .input('2', stick)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CHAIR_WOOD_OAK, 2)
                        .pattern("2  ")
                        .pattern("211")
                        .pattern("2 2")
                        .input('1', planksOak)
                        .input('2', stick)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.COFFEE_TABLE_WHITE, 2)
                        .pattern("111")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.FLOOR_LAMP)
                        .pattern(" 2 ")
                        .pattern(" 1 ")
                        .pattern("3 3")
                        .input('1', planksOak)
                        .input('2', redstoneLamp)
                        .input('3', stick)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.FLOOR_LAMP_B)
                        .pattern(" 2 ")
                        .pattern(" 1 ")
                        .pattern("3 3")
                        .input('1', planksBirch)
                        .input('2', redstoneLamp)
                        .input('3', stick)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.GAME_CONSOLE)
                        .pattern("121")
                        .pattern("141")
                        .pattern("131")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .input('3', endCrystal)
                        .input('4', buttonStone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KEYBOARD_MECHANICAL_BLACK)
                        .pattern("222")
                        .pattern("313")
                        .input('1', concreteBlack)
                        .input('2', buttonStone)
                        .input('3', dyeWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(dyeWhite), conditionsFromItem(dyeWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LAPTOP)
                        .pattern("131")
                        .pattern("567")
                        .pattern("242")
                        .input('1', concreteBlack)
                        .input('2', concreteWhite)
                        .input('3', glassPaneStainedBlack)
                        .input('4', redstone)
                        .input('5', noteBlock)
                        .input('6', endCrystal)
                        .input('7', buttonStone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(glassPaneStainedBlack), conditionsFromItem(glassPaneStainedBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(noteBlock), conditionsFromItem(noteBlock))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR)
                        .pattern("1 ")
                        .pattern("23")
                        .input('1', monitorGamingMinimalist)
                        .input('2', keyboardMechanicalBlack)
                        .input('3', mouseGamingBlack)
                        .criterion(hasItem(monitorGamingMinimalist), conditionsFromItem(monitorGamingMinimalist))
                        .criterion(hasItem(keyboardMechanicalBlack), conditionsFromItem(keyboardMechanicalBlack))
                        .criterion(hasItem(mouseGamingBlack), conditionsFromItem(mouseGamingBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR_GAMING_MINIMALIST)
                        .pattern("141")
                        .pattern("121")
                        .pattern(" 3 ")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', terracottaCyan)
                        .input('4', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(terracottaCyan), conditionsFromItem(terracottaCyan))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MOUSE_GAMING_BLACK)
                        .pattern(" 1 ")
                        .pattern("324")
                        .pattern(" 1 ")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', buttonStone)
                        .input('4', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.PICTURE_FRAME)
                        .pattern("121")
                        .input('1', planksOak)
                        .input('2', painting)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(painting), conditionsFromItem(painting))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.SOFA_GRAY, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolGray)
                        .criterion(hasItem(woolGray), conditionsFromItem(woolGray))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.SOFA_WHITE, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolWhite)
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_BLACK, 2)
                        .pattern("11")
                        .pattern("22")
                        .input('1', concreteBlack)
                        .input('2', stick)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_1X1_WHITE, 2)
                        .pattern("11")
                        .pattern("22")
                        .input('1', concreteWhite)
                        .input('2', stick)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(stick), conditionsFromItem(stick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_BLACK)
                        .pattern("11")
                        .input('1', table1x1Black)
                        .criterion(hasItem(table1x1Black), conditionsFromItem(table1x1Black))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_2X1_WHITE)
                        .pattern("11")
                        .input('1', table1x1White)
                        .criterion(hasItem(table1x1White), conditionsFromItem(table1x1White))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WHITE, 2)
                        .pattern("111")
                        .pattern("2 2")
                        .input('1', concreteWhite)
                        .input('2', concreteBlack)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WOOD_BIRCH, 2)
                        .pattern("111")
                        .pattern("2 2")
                        .input('1', planksBirch)
                        .input('2', concreteBlack)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TABLE_DINING_WOOD_OAK, 2)
                        .pattern("111")
                        .pattern("2 2")
                        .input('1', planksOak)
                        .input('2', concreteBlack)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TRASH_CAN_BLACK, 2)
                        .pattern("1")
                        .pattern("1")
                        .input('1', concreteBlack)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TRASH_CAN_WHITE, 2)
                        .pattern("1")
                        .pattern("1")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TV_OLED)
                        .pattern("111")
                        .pattern("121")
                        .pattern("131")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TV_STAND_WOOD_BIRCH)
                        .pattern("121")
                        .pattern("3 3")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', concreteBlack)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TV_STAND_WOOD_OAK)
                        .pattern("121")
                        .pattern("3 3")
                        .input('1', planksOak)
                        .input('2', chest)
                        .input('3', concreteBlack)
                        .criterion(hasItem(planksOak), conditionsFromItem(planksOak))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "NhatJSFurnitureMod Recipes";
    }
}
