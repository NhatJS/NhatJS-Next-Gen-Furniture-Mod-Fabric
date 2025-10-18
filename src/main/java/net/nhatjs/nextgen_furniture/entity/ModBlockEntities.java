package net.nhatjs.nextgen_furniture.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.nextgen_furniture.NhatJSNextGenFurnitureMod;
import net.nhatjs.nextgen_furniture.block.ModBlocks;
import net.nhatjs.nextgen_furniture.block.entity.NextGenCraftingTableBlockEntity;

public class ModBlockEntities {
    public static BlockEntityType<NextGenCraftingTableBlockEntity> NEXTGEN_CRAFTING_BE;

    public static void register() {
        NEXTGEN_CRAFTING_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(NhatJSNextGenFurnitureMod.MOD_ID,
                "nextgen_crafting_table"), BlockEntityType.Builder.create(NextGenCraftingTableBlockEntity::new, ModBlocks.NEXTGEN_CRAFTING_TABLE)
                .build(null)
        );
    }
}
