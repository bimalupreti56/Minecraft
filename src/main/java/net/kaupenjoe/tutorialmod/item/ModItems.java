package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.tutorialmod.TutorialMod;
//import net.kaupenjoe.tutorialmod.item.custom.BimalArmorItem;
import net.kaupenjoe.tutorialmod.item.custom.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final FoodComponent Tomato = new FoodComponent.Builder().hunger(4).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000), 1f).build();
    public static final Item BIMAL_RAW_SHARD = registerItem("bimal_raw_shard", new Item(new FabricItemSettings()));
    public static final Item BIMAL_SHARD = registerItem("bimal_shard", new Item(new FabricItemSettings()));

    public static final Item BIMAL_INGOT = registerItem("bimal_ingot", new Item(new FabricItemSettings()));
    public static final Item ADASH_INGOT = registerItem("adash_ingot", new Item(new FabricItemSettings()));
    public static final Item ADASH_BOTTOM = registerItem("adash_bottom", new Item(new FabricItemSettings()));
    public static final Item ADASH_MID = registerItem("adash_mid", new Item(new FabricItemSettings()));
    public static final Item ADASH_TOP = registerItem("adash_top", new Item(new FabricItemSettings()));

    public static final Item ADASH_SPARK = registerItem("adash_spark", new Item(new FabricItemSettings()));

    public static final Item ITEM_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(200)));

    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(Tomato)));
//    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",
//            new Item(new FabricItemSettings()));
//    public static final Item BIMAL_STAFF = registerItem("bimal_staff",
//        new SwordItem(ToolMaterials.DIAMOND,50,20F,new FabricItemSettings().maxCount(1)));
    public static final Item BIMAL_STAFF = registerItem("bimal_staff", new BimalStaffItem(new FabricItemSettings().maxDamage(2000)));
    public static final Item BIMAL_BOLT = registerItem("bimal_bolt", new BimalBoltItem(new FabricItemSettings().maxDamage(2000)));
    public static final Item STAFF_EXPLOSIVE = registerItem("bimal_explosive", new Item(new FabricItemSettings()));
    public static final Item STAFF_HEAD = registerItem("staff_head", new Item(new FabricItemSettings()));

    public static final Item BOLT_HEAD = registerItem("bolt_head", new Item(new FabricItemSettings()));

    public static final Item BOLT = registerItem("bolt", new Item(new FabricItemSettings()));



    public static final Item BIMAL_SPEAR = registerItem("bimal_spear2",
            new BimalSpearItem(new FabricItemSettings().maxDamage(2000)));

    public static final Item ADASH_SWORD = registerItem("adash_sword",
            new Dashcaliber(ModToolMaterial.BIMAL_INGOT, 12, -3.0F, new FabricItemSettings().fireproof()));

    public static final Item BIMAL_SWORD = registerItem("bimal_sword",
            new SwordItem(ModToolMaterial.BIMAL_INGOT, 10, -2.0F, new FabricItemSettings()));
    public static final Item BIMAL_PICKAXE = registerItem("bimal_pickaxe",
            new PickaxeItem(ModToolMaterial.BIMAL_INGOT, 2, 2f, new FabricItemSettings()));
    public static final Item BIMAL_AXE = registerItem("bimal_axe",
            new AxeItem(ModToolMaterial.BIMAL_INGOT, 9, 2f, new FabricItemSettings()));
    public static final Item BIMAL_SHOVEL = registerItem("bimal_shovel",
            new ShovelItem(ModToolMaterial.BIMAL_INGOT, 2, 2f, new FabricItemSettings()));
    public static final Item BIMAL_HOE = registerItem("bimal_hoe",
            new HoeItem(ModToolMaterial.BIMAL_INGOT, 2, 2f, new FabricItemSettings()));
//    public static final Item STAFF_SNOW = registerItem("staff_snow",
//            new StaffSnowEntity();


    public static final Item BIMAL_HELMET = registerItem("bimal_helmet",
            new ArmorItem(ModArmorMaterials.BIMAL_INGOT, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BIMAL_CHESTPLATE = registerItem("bimal_chestplate",
            new ArmorItem(ModArmorMaterials.BIMAL_INGOT, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BIMAL_LEGGINGS = registerItem("bimal_leggings",
            new ArmorItem(ModArmorMaterials.BIMAL_INGOT, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BIMAL_BOOTS = registerItem("bimal_boots",
            new ArmorItem(ModArmorMaterials.BIMAL_INGOT, ArmorItem.Type.BOOTS, new FabricItemSettings()));
//    public static final Item BIMAL_STAFF = registerItem("bimal_staff",
//            new BowItem(new FabricItemSettings().maxCount(1)));


;
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BIMAL_SHARD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
