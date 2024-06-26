package fr.silenthill99.kaupen_mod.data.tags;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModBlocks;
import fr.silenthill99.kaupen_mod.init.ModItems;
import fr.silenthill99.kaupen_mod.utils.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTagsGenerator extends ItemTagsProvider {
    public ItemTagsGenerator(DataGenerator gen, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, provider, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.ModItemTags.AMETHYST).add(
                ModItems.AMETHYST.get()
        );

        tag(ItemTags.LEAVES).add(
                ModBlocks.REDWOOD_LEAVES.get().asItem()
        );

        tag(ItemTags.LOGS).add(
                ModBlocks.REDWOOD_LOG.get().asItem()
        );

        tag(ItemTags.PLANKS).add(
                ModBlocks.REDWOOD_PLANKS.get().asItem()
        );

        tag(ModTags.ModItemTags.REDWOOD_LOGS).add(
                ModBlocks.REDWOOD_LOG.get().asItem(),
                ModBlocks.REDWOOD_WOOD.get().asItem(),
                ModBlocks.STRIPPED_REDWOOD_LOG.get().asItem(),
                ModBlocks.STRIPPED_REDWOOD_WOOD.get().asItem()
        );
    }
}
