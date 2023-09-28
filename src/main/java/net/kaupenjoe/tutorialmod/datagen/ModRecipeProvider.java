package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> BIMAL_SMELTABLES = List.of(ModItems.BIMAL_RAW_SHARD);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, BIMAL_SMELTABLES, RecipeCategory.MISC, ModItems.BIMAL_SHARD,
                0.7f, 200, "bimal");
//        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
//                0.7f, 100, "ruby");
//
//        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BIMAL_INGOT, RecipeCategory.DECORATIONS,
//                ModBlocks.BIMAL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADASH_INGOT,2)
                .pattern("SSS")
                .pattern("SGS")
                .pattern("SSS")
                .input('G', ModItems.BIMAL_INGOT)
                .input('S',Items.LAPIS_LAZULI)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADASH_INGOT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADASH_SWORD,1)
                .pattern("  T")
                .pattern(" M ")
                .pattern("B  ")
                .input('T', ModItems.ADASH_TOP)
                .input('M', ModItems.ADASH_MID)
                .input('B', ModItems.ADASH_BOTTOM)

                .criterion(hasItem(ModItems.ADASH_TOP), conditionsFromItem(ModItems.ADASH_TOP))
                .criterion(hasItem(ModItems.ADASH_MID), conditionsFromItem(ModItems.ADASH_MID))
                .criterion(hasItem(ModItems.ADASH_BOTTOM), conditionsFromItem(ModItems.ADASH_BOTTOM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADASH_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADASH_TOP,1)
                .pattern("   ")
                .pattern("ASA")
                .pattern("   ")
                .input('A', ModItems.ADASH_INGOT)
                .input('S', Items.SHULKER_SHELL)
                .criterion(hasItem(ModItems.ADASH_INGOT), conditionsFromItem(ModItems.ADASH_INGOT))
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADASH_TOP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADASH_MID,1)
                .pattern("   ")
                .pattern("ASA")
                .pattern("   ")
                .input('A', ModItems.ADASH_INGOT)
                .input('S',Items.SHIELD)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.SHIELD), conditionsFromItem(Items.SHIELD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADASH_MID)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADASH_BOTTOM,1)
                .pattern("   ")
                .pattern("LSL")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADASH_BOTTOM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BIMAL_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.BIMAL_INGOT)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BIMAL_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_STAFF)
                .pattern(" BH")
                .pattern(" SB")
                .pattern("S  ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .input('H', ModItems.STAFF_HEAD)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.STAFF_HEAD), conditionsFromItem(ModItems.STAFF_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_STAFF)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_BOLT)
                .pattern(" BH")
                .pattern(" SB")
                .pattern("S  ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .input('H', ModItems.BOLT_HEAD)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.BOLT_HEAD), conditionsFromItem(ModItems.BOLT_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_BOLT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STAFF_HEAD)
                .pattern("FGF")
                .pattern("GCG")
                .pattern("FGF")
                .input('C', Items.FIRE_CHARGE)
                .input('G', Items.GUNPOWDER)
                .input('F', Items.BLAZE_POWDER)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STAFF_HEAD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BOLT_HEAD)
                .pattern("FGF")
                .pattern("GCG")
                .pattern("FGF")
                .input('C', Items.LIGHTNING_ROD)
                .input('G', Items.COPPER_INGOT)
                .input('F', Items.BLAZE_POWDER)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BOLT_HEAD)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STAFF_EXPLOSIVE,4)
                .input(Items.GUNPOWDER)
                .input(Items.BLAZE_POWDER)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STAFF_EXPLOSIVE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BOLT,4)
                .input(Items.COPPER_INGOT)
                .input(Items.BLAZE_POWDER)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BOLT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ITEM_DETECTOR)
                .pattern(" BR")
                .pattern(" BB")
                .pattern("Ss ")
                .input('B', ModItems.BIMAL_SHARD)
                .input('S', Items.STICK)
                .input('s', Items.STRING)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.BIMAL_SHARD), conditionsFromItem(ModItems.BIMAL_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ITEM_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BIMAL_PICKAXE)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BIMAL_SWORD)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BIMAL_AXE)
                .pattern(" BB")
                .pattern(" SB")
                .pattern(" S ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BIMAL_SHOVEL)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BIMAL_HOE)
                .pattern(" BB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BIMAL_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.BIMAL_INGOT)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BIMAL_INGOT)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.BIMAL_INGOT)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BIMAL_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.BIMAL_INGOT)
                .criterion(hasItem(ModItems.BIMAL_INGOT), conditionsFromItem(ModItems.BIMAL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BIMAL_BOOTS)));


    }
}
