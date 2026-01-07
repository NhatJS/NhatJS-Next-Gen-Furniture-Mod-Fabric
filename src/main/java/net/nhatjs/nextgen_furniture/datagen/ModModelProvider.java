package net.nhatjs.nextgen_furniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.*;
import net.minecraft.util.Identifier;
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
        BlockStateVariantMap horizontalBlock = BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates();

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AIO_COOLER_3_FANS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_GRAY_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_GRAY_WOOD_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_WHITE_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BED_WHITE_WOOD_OAK);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WHITE_GRAY)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WhiteGrayMoved, chair2WhiteGray)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WHITE_WHITE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WhiteWhiteMoved, chair2WhiteWhite)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WOOD_BIRCH_GRAY)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WoodBirchGrayMoved, chair2WoodBirchGray)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WOOD_BIRCH_WHITE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WoodBirchWhiteMoved, chair2WoodBirchWhite)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WOOD_OAK_GRAY)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WoodOakGrayMoved, chair2WoodOakGray)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_2_WOOD_OAK_WHITE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chair2WoodOakWhiteMoved, chair2WoodOakWhite)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_WHITE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chairWhiteMoved, chairWhite)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_WOOD_BIRCH)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chairWoodBirchMoved, chairWoodBirch)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHAIR_WOOD_OAK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChairBlock.MOVE,
                        chairWoodOakMoved, chairWoodOak)).coordinate(horizontalBlock));

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

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FLOOR_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(FloorLampBlock.LIT,
                        floorLampOn, floorLampOff)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FLOOR_LAMP_B)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(FloorLampBlock.LIT,
                        floorLampBOn, floorLampBOff)).coordinate(horizontalBlock));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GAME_CONSOLE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ConsoleBlock.TURN_ON,
                        gameConsoleOn, gameConsole)).coordinate(horizontalBlock));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GRAPHICS_CARD_GAMING);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD_MECHANICAL_BLACK_WOOD_OAK);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LAPTOP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LaptopBlock.TURN_ON,
                        laptopOn, laptop)).coordinate(horizontalBlock));

        registerSixFacingWithBoolean(blockStateModelGenerator, ModBlocks.LIGHT_MODERN, Properties.FACING, ModernLightBlock.LIT,
                id("light_modern"), id("light_modern"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MAINBOARD_GAMING);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MONITOR)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(MonitorBlock.TURN_ON,
                        monitorOn, monitor)).coordinate(horizontalBlock));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MONITOR_DUAL)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(DualMonitorBlock.TURN_ON,
                        monitorDualOn, monitorDual)).coordinate(horizontalBlock));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MONITOR_DUAL_ALT)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(DualMonitorAlternateBlock.TURN_ON,
                        monitorDualAlternateOn, monitorDualAlternate)).coordinate(horizontalBlock));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MONITOR_DUAL_ALT_2)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(DualMonitorAlternate2Block.TURN_ON,
                        monitorDualAlternate2On, monitorDualAlternate2)).coordinate(horizontalBlock));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MONITOR_GAMING_MINIMALIST);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MOUSE_GAMING_BLACK);

        registerGamingPCState(blockStateModelGenerator, ModBlocks.PC_GAMING);

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
        registerSofa(blockStateModelGenerator, ModBlocks.SOFA_WHITE, Properties.HORIZONTAL_FACING, SofaBlock.PART,
                sofaWhite, sofaLeftWhite, sofaRightWhite, sofaMiddleWhite, sofaCornerLeftWhite, sofaCornerRightWhite);

        registerTVState(blockStateModelGenerator, ModBlocks.TV_OLED);

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
        itemModelGenerator.register(ModBlocks.GAME_CONSOLE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LIGHT_MODERN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MONITOR.asItem(),
                new Model(Optional.of(monitor), Optional.empty()));
        itemModelGenerator.register(ModBlocks.MONITOR_DUAL.asItem(),
                new Model(Optional.of(monitorDual), Optional.empty()));
        itemModelGenerator.register(ModBlocks.MONITOR_DUAL_ALT.asItem(),
                new Model(Optional.of(monitorDualAlternate), Optional.empty()));
        itemModelGenerator.register(ModBlocks.MONITOR_DUAL_ALT_2.asItem(),
                new Model(Optional.of(monitorDualAlternate2), Optional.empty()));
        itemModelGenerator.register(ModItems.NEXTGEN_FURNITURE_LOGO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCREWDRIVER, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SOFA_GRAY.asItem(),
                new Model(Optional.of(sofaGray), Optional.empty()));
        itemModelGenerator.register(ModBlocks.SOFA_WHITE.asItem(),
                new Model(Optional.of(sofaWhite), Optional.empty()));
        itemModelGenerator.register(ModBlocks.TRASH_CAN_BLACK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.TRASH_CAN_WHITE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.TV_OLED.asItem(),
                new Model(Optional.of(tvOled), Optional.empty()));
    }

    public static void registerGamingPCState(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap.TripleProperty<Direction, Boolean, Boolean> state =
                BlockStateVariantMap.TripleProperty.create(DesktopBlock.FACING, DesktopBlock.TURN_ON, DesktopBlock.PC_BOOTING);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            VariantSettings.Rotation rot = switch (dir) {
                case EAST -> VariantSettings.Rotation.R90;
                case SOUTH -> VariantSettings.Rotation.R180;
                case WEST -> VariantSettings.Rotation.R270;
                default -> VariantSettings.Rotation.R0;
            };
            state.register(dir, false, false, BlockStateVariant.create().put(VariantSettings.MODEL, pcGaming).put(VariantSettings.Y, rot));
            state.register(dir, true, false, BlockStateVariant.create().put(VariantSettings.MODEL, pcGamingOn).put(VariantSettings.Y, rot));
            state.register(dir, false, true, BlockStateVariant.create().put(VariantSettings.MODEL, pcGamingBoot).put(VariantSettings.Y, rot));
            state.register(dir, true, true, BlockStateVariant.create().put(VariantSettings.MODEL, pcGamingBoot).put(VariantSettings.Y, rot));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(state)
        );
    }

    public static void registerSofa(BlockStateModelGenerator blockStateModelGenerator, Block block, DirectionProperty facing,
                                         EnumProperty<SofaBlock.Part> part,
                                         Identifier single, Identifier left, Identifier right,
                                         Identifier middle, Identifier cornerLeft, Identifier cornerRight) {
        BlockStateVariantMap.DoubleProperty<Direction, SofaBlock.Part> map = BlockStateVariantMap.DoubleProperty.create(facing, part);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            VariantSettings.Rotation rot = switch (dir) {
                case EAST  -> VariantSettings.Rotation.R90;
                case SOUTH -> VariantSettings.Rotation.R180;
                case WEST  -> VariantSettings.Rotation.R270;
                default    -> VariantSettings.Rotation.R0;
            };
            map.register(dir, SofaBlock.Part.SINGLE, BlockStateVariant.create().put(VariantSettings.MODEL, single).put(VariantSettings.Y, rot));
            map.register(dir, SofaBlock.Part.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, left).put(VariantSettings.Y, rot));
            map.register(dir, SofaBlock.Part.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, right).put(VariantSettings.Y, rot));
            map.register(dir, SofaBlock.Part.MIDDLE, BlockStateVariant.create().put(VariantSettings.MODEL, middle).put(VariantSettings.Y, rot));
            map.register(dir, SofaBlock.Part.CORNER_LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, cornerLeft).put(VariantSettings.Y, rot));
            map.register(dir, SofaBlock.Part.CORNER_RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, cornerRight).put(VariantSettings.Y, rot));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map));
    }

    public static void registerTVState(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        BlockStateVariantMap.TripleProperty<Direction, Boolean, TVBlock.Mount> map =
                BlockStateVariantMap.TripleProperty.create(TVBlock.FACING, TVBlock.TV_ON, TVBlock.MOUNT);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            VariantSettings.Rotation rot = switch (dir) {
                case EAST  -> VariantSettings.Rotation.R90;
                case SOUTH -> VariantSettings.Rotation.R180;
                case WEST  -> VariantSettings.Rotation.R270;
                default    -> VariantSettings.Rotation.R0;
            };
            map.register(dir, false, TVBlock.Mount.STAND, BlockStateVariant.create().put(VariantSettings.MODEL, tvOled).put(VariantSettings.Y, rot));
            map.register(dir, true, TVBlock.Mount.STAND, BlockStateVariant.create().put(VariantSettings.MODEL, tvOledOn).put(VariantSettings.Y, rot));
            map.register(dir, false, TVBlock.Mount.WALL, BlockStateVariant.create().put(VariantSettings.MODEL, tvOledMount).put(VariantSettings.Y, rot));
            map.register(dir, true, TVBlock.Mount.WALL, BlockStateVariant.create().put(VariantSettings.MODEL, tvOledMountOn).put(VariantSettings.Y, rot));
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map));
    }

    public static void registerSixFacing(BlockStateModelGenerator blockStateModelGenerator, Block block, DirectionProperty facing, Identifier model) {
        BlockStateVariantMap.SingleProperty<Direction> map = BlockStateVariantMap.create(facing);

        map.register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, model));
        map.register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R90));
        map.register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R180));
        map.register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R270));
        map.register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R270));
        map.register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R90));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map)
        );
    }

    public static void registerSixFacingWithBoolean(BlockStateModelGenerator blockStateModelGenerator, Block block, DirectionProperty facing,
                                                    BooleanProperty facingBoolean, Identifier model, Identifier modelOn) {
        BlockStateVariantMap.DoubleProperty<Direction, Boolean> map = BlockStateVariantMap.create(facing, facingBoolean);

        map.register(Direction.NORTH, false, BlockStateVariant.create().put(VariantSettings.MODEL, model));
        map.register(Direction.NORTH, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn));
        map.register(Direction.EAST, false, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R90));
        map.register(Direction.EAST, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R90));
        map.register(Direction.SOUTH, false, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R180));
        map.register(Direction.SOUTH, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R180));
        map.register(Direction.WEST, false, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R270));
        map.register(Direction.WEST, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R270));
        map.register(Direction.UP, false, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R270));
        map.register(Direction.UP, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.X, VariantSettings.Rotation.R270));
        map.register(Direction.DOWN, false, BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R90));
        map.register(Direction.DOWN, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.X, VariantSettings.Rotation.R90));

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map)
        );
    }

    public static Identifier id(String path) {
        return Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "block/" + path);
    }
}