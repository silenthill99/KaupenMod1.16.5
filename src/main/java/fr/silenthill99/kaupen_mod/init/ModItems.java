package fr.silenthill99.kaupen_mod.init;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.custom.items.Firestone;
import fr.silenthill99.kaupen_mod.utils.ModArmorMaterials;
import fr.silenthill99.kaupen_mod.utils.ModItemGroups;
import fr.silenthill99.kaupen_mod.utils.ModItemTiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())
                    .durability(8)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModItemTiers.AMETHYST, 2, 3, new
                    Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModItemTiers.AMETHYST, 0, -1,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModItemTiers.AMETHYST, 0, -1,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModItemTiers.AMETHYST, 4, -6,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModItemTiers.AMETHYST, 2, 3f,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.FEET,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

    public static final RegistryObject<Item> OATS = ITEMS.register("oats",
            () -> new BlockItem(ModBlocks.OATS.get(), new Item.Properties().food(
                    new Food.Builder()
                            .nutrition(1)
                            .saturationMod(0.1f)
                            .fast()
                            .build()
            ).tab(ModItemGroups.TUTORIAL_GROUP.getGroup())));

}
