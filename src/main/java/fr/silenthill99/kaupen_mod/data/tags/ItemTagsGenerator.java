package fr.silenthill99.kaupen_mod.data.tags;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModItems;
import fr.silenthill99.kaupen_mod.utils.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
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
    }
}
