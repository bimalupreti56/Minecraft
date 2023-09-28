package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    //generates texture for block cube and block state as well
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool bimalPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BIMAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIMAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIMAL_DEEPSLATE_ORE);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        bimalPool.stairs(ModBlocks.BIMAL_STAIRS);
        bimalPool.slab(ModBlocks.BIMAL_SLAB);
        bimalPool.button(ModBlocks.BIMAL_BUTTON);
        bimalPool.fence(ModBlocks.BIMAL_FENCE);

        blockStateModelGenerator.registerDoor(ModBlocks.BIMAL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BIMAL_TRAPDOOR);

    }

    @Override
    //generate texture for items
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.BIMAL_RAW_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIMAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIMAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADASH_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADASH_BOTTOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADASH_MID, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADASH_TOP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADASH_SPARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIMAL_SPEAR, Models.HANDHELD);


        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.ITEM_DETECTOR, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.BIMAL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BIMAL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BIMAL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BIMAL_BOOTS);

        itemModelGenerator.register(ModItems.STAFF_EXPLOSIVE,Models.GENERATED);
        itemModelGenerator.register(ModItems.STAFF_HEAD,Models.GENERATED);
        itemModelGenerator.register(ModItems.BOLT_HEAD,Models.GENERATED);

        itemModelGenerator.register(ModItems.BOLT,Models.GENERATED);
        itemModelGenerator.register(ModItems.BIMAL_STAFF,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_BOLT,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_SWORD,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIMAL_HOE,Models.HANDHELD);


    }
}
