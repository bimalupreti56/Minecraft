package net.kaupenjoe.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block BIMAL_BLOCK = registerBlock("bimal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block BIMAL_ORE = registerBlock("bimal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(5, 8)));
    public static final Block BIMAL_DEEPSLATE_ORE = registerBlock("deepslate_bimal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(5, 8)));
//    public static final Block SOUND_BLOCK = registerBlock("sound_block",
//            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block BIMAL_STAIRS = registerBlock("bimal_stairs",
            new StairsBlock(ModBlocks.BIMAL_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.ACACIA_STAIRS)));
    public static final Block BIMAL_SLAB = registerBlock("bimal_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SLAB)));

    public static final Block BIMAL_BUTTON = registerBlock("bimal_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.IRON, 10, true));
//    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
//            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
//                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final Block BIMAL_FENCE = registerBlock("bimal_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
//    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
//            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
//    public static final Block RUBY_WALL = registerBlock("ruby_wall",
//            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block BIMAL_DOOR = registerBlock("bimal_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_DOOR).nonOpaque(), BlockSetType.IRON));
    public static final Block BIMAL_TRAPDOOR = registerBlock("bimal_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
