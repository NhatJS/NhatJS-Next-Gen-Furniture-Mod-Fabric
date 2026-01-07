package net.nhatjs.nextgen_furniture.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.*;
import net.nhatjs.nextgen_furniture.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    Identifier chair2WhiteGray = id("chair_2_white_gray");
    Identifier chair2WhiteGrayMoved = id("chair_2_white_gray_moved");
    Identifier chair2WhiteWhite = id("chair_2_white_white");
    Identifier chair2WhiteWhiteMoved = id("chair_2_white_white_moved");
    Identifier chair2WoodBirchGray = id("chair_2_wood_birch_gray");
    Identifier chair2WoodBirchGrayMoved = id("chair_2_wood_birch_gray_moved");
    Identifier chair2WoodBirchWhite = id("chair_2_wood_birch_white");
    Identifier chair2WoodBirchWhiteMoved = id("chair_2_wood_birch_white_moved");
    Identifier chair2WoodOakGray = id("chair_2_wood_oak_gray");
    Identifier chair2WoodOakGrayMoved = id("chair_2_wood_oak_gray_moved");
    Identifier chair2WoodOakWhite = id("chair_2_wood_oak_white");
    Identifier chair2WoodOakWhiteMoved = id("chair_2_wood_oak_white_moved");
    Identifier chairWhite = id("chair_white");
    Identifier chairWhiteMoved = id("chair_white_moved");
    Identifier chairWoodBirch = id("chair_wood_birch");
    Identifier chairWoodBirchMoved = id("chair_wood_birch_moved");
    Identifier chairWoodOak = id("chair_wood_oak");
    Identifier chairWoodOakMoved = id("chair_wood_oak_moved");
    Identifier floorLampOff = id("floor_lamp");
    Identifier floorLampOn = id("floor_lamp_on");
    Identifier floorLampBOff = id("floor_lamp_b");
    Identifier floorLampBOn = id("floor_lamp_b_on");
    Identifier gameConsole = id("game_console");
    Identifier gameConsoleOn = id("game_console_on");
    Identifier laptop = id("laptop_base");
    Identifier laptopOn = id("laptop_base_on");
    Identifier monitor = id("monitor_off");
    Identifier monitorOn = id("monitor_on");
    Identifier monitorDual = id("monitor_dual_off");
    Identifier monitorDualOn = id("monitor_dual_on");
    Identifier monitorDualAlternate = id("monitor_dual_alt_off");
    Identifier monitorDualAlternateOn = id("monitor_dual_alt_on");
    Identifier monitorDualAlternate2 = id("monitor_dual_alt_2_off");
    Identifier monitorDualAlternate2On = id("monitor_dual_alt_2_on");
    static Identifier pcGaming = id("pc_gaming");
    static Identifier pcGamingBoot = id("pc_gaming_boot");
    static Identifier pcGamingOn = id("pc_gaming_on");
    Identifier pictureFrame = id("picture_frame");
    static Identifier sofaGray = id("sofa_single_gray");
    static Identifier sofaLeftGray = id("sofa_left_gray");
    static Identifier sofaRightGray = id("sofa_right_gray");
    static Identifier sofaMiddleGray = id("sofa_middle_gray");;
    static Identifier sofaCornerLeftGray = id("sofa_corner_left_gray");
    static Identifier sofaCornerRightGray = id("sofa_corner_right_gray");
    static Identifier sofaWhite = id("sofa_single_white");
    static Identifier sofaLeftWhite = id("sofa_left_white");
    static Identifier sofaRightWhite = id("sofa_right_white");
    static Identifier sofaMiddleWhite = id("sofa_middle_white");;
    static Identifier sofaCornerLeftWhite = id("sofa_corner_left_white");
    static Identifier sofaCornerRightWhite = id("sofa_corner_right_white");
    static Identifier tvOled = id("tv_oled_off");
    static Identifier tvOledOn = id("tv_oled_on");
    static Identifier tvOledMount = id("tv_oled_mount_off");
    static Identifier tvOledMountOn = id("tv_oled_mount_on");

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AIO_COOLER_3_FANS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_GRAY_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_GRAY_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_WHITE_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_WHITE_WOOD_OAK);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WHITE_GRAY,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WhiteGray, chair2WhiteGrayMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WHITE_WHITE,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WhiteWhite, chair2WhiteWhiteMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WoodBirchGray, chair2WoodBirchGrayMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WoodBirchWhite, chair2WoodBirchWhiteMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WOOD_OAK_GRAY,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WoodOakGray, chair2WoodOakGrayMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_2_WOOD_OAK_WHITE,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chair2WoodOakWhite, chair2WoodOakWhiteMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_WHITE,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chairWhite, chairWhiteMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_WOOD_BIRCH,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chairWoodBirch, chairWoodBirchMoved);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.CHAIR_WOOD_OAK,
                Properties.HORIZONTAL_FACING, ChairBlock.MOVE, chairWoodOak, chairWoodOakMoved);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COFFEE_TABLE_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_CASE_GAMING);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_POWER_SUPPLY);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_2_K_M_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_2_K_M_WOOD_BIRCH_BASE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_2_K_M_WOOD_OAK_BASE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_3_K_M_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_3_K_M_WOOD_BIRCH_BASE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DRAWER_3_K_M_WOOD_OAK_BASE);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.FLOOR_LAMP,
                Properties.HORIZONTAL_FACING, FloorLampBlock.LIT, floorLampOff, floorLampOn);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.FLOOR_LAMP_B,
                Properties.HORIZONTAL_FACING, FloorLampBlock.LIT, floorLampBOff, floorLampBOn);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.GAME_CONSOLE,
                Properties.HORIZONTAL_FACING, ConsoleBlock.TURN_ON, gameConsole, gameConsoleOn);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GRAPHICS_CARD_GAMING);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.LAPTOP,
                Properties.HORIZONTAL_FACING, LaptopBlock.TURN_ON, laptop, laptopOn);
        blockStateModelGenerator.registerItemModel(ModBlocks.LAPTOP.asItem(), id("laptop"));

        registerSixFacingWithBoolean(blockStateModelGenerator, ModBlocks.LIGHT_MODERN, Properties.FACING, ModernLightBlock.LIT,
                id("light_modern"), id("light_modern"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MAINBOARD_GAMING);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MONITOR,
                Properties.HORIZONTAL_FACING, MonitorBlock.TURN_ON, monitor, monitorOn);
        blockStateModelGenerator.registerItemModel(ModBlocks.MONITOR.asItem(), monitor);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MONITOR_DUAL,
                Properties.HORIZONTAL_FACING, DualMonitorBlock.TURN_ON, monitorDual, monitorDualOn);
        blockStateModelGenerator.registerItemModel(ModBlocks.MONITOR_DUAL.asItem(), monitorDual);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MONITOR_DUAL_ALT,
                Properties.HORIZONTAL_FACING, DualMonitorAlternateBlock.TURN_ON, monitorDualAlternate, monitorDualAlternateOn);
        blockStateModelGenerator.registerItemModel(ModBlocks.MONITOR_DUAL_ALT.asItem(), monitorDualAlternate);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MONITOR_DUAL_ALT_2,
                Properties.HORIZONTAL_FACING, DualMonitorAlternate2Block.TURN_ON, monitorDualAlternate2, monitorDualAlternate2On);
        blockStateModelGenerator.registerItemModel(ModBlocks.MONITOR_DUAL_ALT_2.asItem(), monitorDualAlternate2);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MONITOR_GAMING_MINIMALIST);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MOUSE_GAMING_BLACK);

        registerGamingPCState(blockStateModelGenerator, ModBlocks.PC_GAMING, Properties.HORIZONTAL_FACING, DesktopBlock.TURN_ON,
                DesktopBlock.PC_BOOTING, pcGaming, pcGamingBoot, pcGamingOn);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_1);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_3);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_4);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_5);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_6);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_7);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_GAMING_ADDED_8);

        registerSixFacing(blockStateModelGenerator, ModBlocks.PICTURE_FRAME, Properties.FACING, pictureFrame);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_1X1_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_1X1_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_1X1_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_1X1_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_BLACK_ALT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_BLACK_ALT_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WHITE_ALT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WHITE_ALT_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_OAK_ALT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_OAK_ALT_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_2X1_WOOD_BIRCH_ALT_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_3X1_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_3X1_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_3X1_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_3X1_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_DINING_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_DINING_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TABLE_DINING_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TRASH_CAN_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TRASH_CAN_WHITE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TV_STAND_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TV_STAND_WOOD_OAK);

        registerSofa(blockStateModelGenerator, ModBlocks.SOFA_GRAY, Properties.HORIZONTAL_FACING, SofaBlock.PART,
                sofaGray, sofaLeftGray, sofaRightGray, sofaMiddleGray, sofaCornerLeftGray, sofaCornerRightGray);
        blockStateModelGenerator.registerItemModel(ModBlocks.SOFA_GRAY.asItem(), sofaGray);

        registerSofa(blockStateModelGenerator, ModBlocks.SOFA_WHITE, Properties.HORIZONTAL_FACING, SofaBlock.PART,
                sofaWhite, sofaLeftWhite, sofaRightWhite, sofaMiddleWhite, sofaCornerLeftWhite, sofaCornerRightWhite);
        blockStateModelGenerator.registerItemModel(ModBlocks.SOFA_WHITE.asItem(), sofaWhite);

        registerTVState(blockStateModelGenerator, ModBlocks.TV_OLED);
        blockStateModelGenerator.registerItemModel(ModBlocks.TV_OLED.asItem(), tvOled);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_LEFT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WARDROBE_MODERN_WOOD_BIRCH_RIGHT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WARDROBE_MODERN_WOOD_OAK_LEFT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WARDROBE_MODERN_WOOD_OAK_RIGHT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WASHING_MACHINE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COMPUTER_CPU, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPUTER_FAN_BLADE_WHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPUTER_RAM_GAMING, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAWER_WHITE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LIGHT_MODERN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.NEXTGEN_FURNITURE_LOGO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCREWDRIVER, Models.GENERATED);
    }

    public static void registerGamingPCState(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing, BooleanProperty on,
                                             BooleanProperty boot, Identifier pcOff, Identifier pcBoot, Identifier pcOn) {
        BlockStateVariantMap.TripleProperty<WeightedVariant, Direction, Boolean, Boolean> state =
                BlockStateVariantMap.TripleProperty.models(facing, on, boot);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            AxisRotation rot = switch (dir) {
                case EAST -> AxisRotation.R90;
                case SOUTH -> AxisRotation.R180;
                case WEST -> AxisRotation.R270;
                default -> AxisRotation.R0;
            };
            state.register(dir, false, false, BlockStateModelGenerator.createWeightedVariant(pcOff).apply(ModelVariantOperator.MODEL.withValue(pcOff)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            state.register(dir, true, false, BlockStateModelGenerator.createWeightedVariant(pcOn).apply(ModelVariantOperator.MODEL.withValue(pcOn)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            state.register(dir, false, true, BlockStateModelGenerator.createWeightedVariant(pcBoot).apply(ModelVariantOperator.MODEL.withValue(pcBoot)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            state.register(dir, true, true, BlockStateModelGenerator.createWeightedVariant(pcBoot).apply(ModelVariantOperator.MODEL.withValue(pcBoot)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(state)
        );
    }

    public static void registerSofa(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                         EnumProperty<SofaBlock.Part> part,
                                         Identifier single, Identifier left, Identifier right,
                                         Identifier middle, Identifier cornerLeft, Identifier cornerRight) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, SofaBlock.Part> map = BlockStateVariantMap.DoubleProperty.models(facing, part);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            AxisRotation rot = switch (dir) {
                case EAST -> AxisRotation.R90;
                case SOUTH -> AxisRotation.R180;
                case WEST -> AxisRotation.R270;
                default -> AxisRotation.R0;
            };
            map.register(dir, SofaBlock.Part.SINGLE, BlockStateModelGenerator.createWeightedVariant(single).apply(ModelVariantOperator.MODEL.withValue(single)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, SofaBlock.Part.LEFT, BlockStateModelGenerator.createWeightedVariant(left).apply(ModelVariantOperator.MODEL.withValue(left)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, SofaBlock.Part.RIGHT, BlockStateModelGenerator.createWeightedVariant(right).apply(ModelVariantOperator.MODEL.withValue(right)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, SofaBlock.Part.MIDDLE, BlockStateModelGenerator.createWeightedVariant(middle).apply(ModelVariantOperator.MODEL.withValue(middle)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, SofaBlock.Part.CORNER_LEFT, BlockStateModelGenerator.createWeightedVariant(cornerLeft).apply(ModelVariantOperator.MODEL.withValue(cornerLeft)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, SofaBlock.Part.CORNER_RIGHT, BlockStateModelGenerator.createWeightedVariant(cornerRight).apply(ModelVariantOperator.MODEL.withValue(cornerRight)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static void registerTVState(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap.TripleProperty<WeightedVariant, Direction, Boolean, TVBlock.Mount> map =
                BlockStateVariantMap.TripleProperty.models(TVBlock.FACING, TVBlock.TV_ON, TVBlock.MOUNT);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            AxisRotation rot = switch (dir) {
                case EAST -> AxisRotation.R90;
                case SOUTH -> AxisRotation.R180;
                case WEST -> AxisRotation.R270;
                default -> AxisRotation.R0;
            };
            map.register(dir, false, TVBlock.Mount.STAND, BlockStateModelGenerator.createWeightedVariant(tvOled).apply(ModelVariantOperator.MODEL.withValue(tvOled)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, true, TVBlock.Mount.STAND, BlockStateModelGenerator.createWeightedVariant(tvOledOn).apply(ModelVariantOperator.MODEL.withValue(tvOledOn)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, false, TVBlock.Mount.WALL, BlockStateModelGenerator.createWeightedVariant(tvOledMount).apply(ModelVariantOperator.MODEL.withValue(tvOledMount)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
            map.register(dir, true, TVBlock.Mount.WALL, BlockStateModelGenerator.createWeightedVariant(tvOledMountOn).apply(ModelVariantOperator.MODEL.withValue(tvOledMountOn)).apply(ModelVariantOperator.ROTATION_Y.withValue(rot)));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static void registerSixFacing(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing, Identifier model) {
        BlockStateVariantMap.SingleProperty<WeightedVariant, Direction> map = BlockStateVariantMap.SingleProperty.models(facing);

        map.register(Direction.NORTH, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)));
        map.register(Direction.EAST, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)));
        map.register(Direction.SOUTH, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)));
        map.register(Direction.WEST, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        map.register(Direction.UP, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)));
        map.register(Direction.DOWN, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static void registerHorizontalWithBoolean(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                                     BooleanProperty booleanProperty, Identifier model, Identifier modelBoolean) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, Boolean> map = BlockStateVariantMap.DoubleProperty.models(facing, booleanProperty);

        map.register(Direction.NORTH, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)));
        map.register(Direction.NORTH, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)));
        map.register(Direction.EAST, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)));
        map.register(Direction.EAST, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)));
        map.register(Direction.SOUTH, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)));
        map.register(Direction.SOUTH, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)));
        map.register(Direction.WEST, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        map.register(Direction.WEST, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static void registerSixFacingWithBoolean(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                                     BooleanProperty booleanProperty, Identifier model, Identifier modelBoolean) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, Boolean> map = BlockStateVariantMap.DoubleProperty.models(facing, booleanProperty);

        map.register(Direction.NORTH, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)));
        map.register(Direction.NORTH, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)));
        map.register(Direction.EAST, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)));
        map.register(Direction.EAST, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)));
        map.register(Direction.SOUTH, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)));
        map.register(Direction.SOUTH, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)));
        map.register(Direction.WEST, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        map.register(Direction.WEST, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        map.register(Direction.UP, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)));
        map.register(Direction.UP, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)));
        map.register(Direction.DOWN, Boolean.FALSE, BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)));
        map.register(Direction.DOWN, Boolean.TRUE, BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static Identifier id(String path) {
        return Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "block/" + path);
    }
}