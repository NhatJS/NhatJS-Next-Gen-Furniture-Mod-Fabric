package net.nhatjs.nextgen_furniture.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.blockentity.client.LaptopBlockEntity;

public final class ModBlockEntities {
    public static final BlockEntityType<LaptopBlockEntity> LAPTOP = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID, "laptop_screen"),
            FabricBlockEntityTypeBuilder.create(LaptopBlockEntity::new, ModBlocks.LAPTOP).build(null));

    public static void registerModBlockEntities() {
        NhatJSNextGenFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSNextGenFurnitureMod.MOD_ID);
    }
}