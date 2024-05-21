package fr.silenthill99.kaupen_mod.data.models_and_blockstates;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModBlocks;
import fr.silenthill99.kaupen_mod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AMETHYST.get());
        simpleItem(ModItems.FIRESTONE.get());
        toolItem(ModItems.AMETHYST_SWORD.get());
        toolItem(ModItems.AMETHYST_PICKAXE.get());
        toolItem(ModItems.AMETHYST_AXE.get());
        toolItem(ModItems.AMETHYST_SHOVEL.get());
        toolItem(ModItems.AMETHYST_HOE.get());
        simpleItem(ModItems.AMETHYST_BOOTS.get());
        simpleItem(ModItems.AMETHYST_CHESTPLATE.get());
        simpleItem(ModItems.AMETHYST_LEGGINGS.get());
        simpleItem(ModItems.AMETHYST_HELMET.get());
        doorBlockItem((DoorBlock) ModBlocks.AMETHYST_DOOR.get());
        simpleItem(ModItems.OATS.get());
        crossBlockItem(ModBlocks.REDWOOD_SAPLING.get());
        simpleItem(ModItems.AMETHYST_HORSE_ARMOR.get());
        cross(ModBlocks.HYACINTH.getId().getPath(), modLoc("block/" + ModBlocks.HYACINTH.getId().getPath()));
    }

    private void simpleItem(Item item) {
        String name = item.getRegistryName().getPath();
        withExistingParent(name, mcLoc("item/generated")).texture("layer0", modLoc("item/" + name));
    }

    private void toolItem(Item item) {
        String name = item.getRegistryName().getPath();
        withExistingParent(name, mcLoc("item/handheld")).texture("layer0", modLoc("item/" + name));
    }

    private void doorBlockItem(DoorBlock door) {
        simpleItem(door.asItem());
    }

    private void crossBlockItem(Block block) {
        String name = block.getRegistryName().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + name));
    }
}
