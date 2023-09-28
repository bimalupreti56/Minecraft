package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.BIMAL_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BIMAL_SHARD);
                        entries.add(ModItems.BIMAL_RAW_SHARD);
                        entries.add(ModItems.BIMAL_INGOT);
                        entries.add(ModItems.ITEM_DETECTOR);


                        entries.add(ModItems.BIMAL_STAFF);
                        entries.add(ModItems.BIMAL_HELMET);
                        entries.add(ModItems.BIMAL_LEGGINGS);
                        entries.add(ModItems.BIMAL_BOOTS);
                        entries.add(ModItems.BIMAL_CHESTPLATE);

                        entries.add(ModItems.STAFF_EXPLOSIVE);
                        entries.add(ModItems.BIMAL_BOLT);
                        entries.add(ModItems.BOLT);
                        entries.add(ModItems.STAFF_HEAD);
                        entries.add(ModItems.BOLT_HEAD);
                        entries.add(ModItems.ADASH_SWORD);
                        entries.add(ModItems.ADASH_INGOT);


                        entries.add(ModItems.BIMAL_SWORD);
                        entries.add(ModItems.BIMAL_PICKAXE);
                        entries.add(ModItems.BIMAL_AXE);
                        entries.add(ModItems.BIMAL_SHOVEL);
                        entries.add(ModItems.BIMAL_HOE);
                        entries.add(ModItems.BIMAL_SPEAR);


                        entries.add(ModItems.TOMATO);
//                        entries.add(ModItems.COAL_BRIQUETTE);

                        entries.add(ModBlocks.BIMAL_BLOCK);
                        entries.add(ModBlocks.BIMAL_ORE);
                        entries.add(ModBlocks.BIMAL_DEEPSLATE_ORE);


                        entries.add(ModBlocks.BIMAL_STAIRS);
                        entries.add(ModBlocks.BIMAL_SLAB);
                        entries.add(ModBlocks.BIMAL_FENCE);
                        entries.add(ModBlocks.BIMAL_BUTTON);
//                        entries.add(ModBlocks.BIMAL_DOOR);
                        entries.add(ModBlocks.BIMAL_TRAPDOOR);

                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
