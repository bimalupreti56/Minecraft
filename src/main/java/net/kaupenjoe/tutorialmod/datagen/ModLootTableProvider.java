package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BIMAL_BLOCK);
        addDrop(ModBlocks.BIMAL_ORE);
        addDrop(ModBlocks.BIMAL_DEEPSLATE_ORE);

//        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.BIMAL_ORE, copperLikeOreDrops(ModBlocks.BIMAL_ORE, ModItems.BIMAL_RAW_SHARD));
        addDrop(ModBlocks.BIMAL_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.BIMAL_DEEPSLATE_ORE, ModItems.BIMAL_RAW_SHARD));




        addDrop(ModBlocks.BIMAL_STAIRS);
        addDrop(ModBlocks.BIMAL_TRAPDOOR);
        addDrop(ModBlocks.BIMAL_FENCE);
        addDrop(ModBlocks.BIMAL_BUTTON);

        addDrop(ModBlocks.BIMAL_DOOR, doorDrops(ModBlocks.BIMAL_DOOR));
        addDrop(ModBlocks.BIMAL_SLAB, slabDrops(ModBlocks.BIMAL_SLAB));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 1.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
