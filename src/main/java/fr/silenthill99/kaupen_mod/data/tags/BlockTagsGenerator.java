package fr.silenthill99.kaupen_mod.data.tags;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModBlocks;
import fr.silenthill99.kaupen_mod.utils.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.ModBlockTags.FIRESTONE_CLICKABLE_BLOCKS).add(
                Blocks.OBSIDIAN,
                Blocks.NETHERRACK,
                ModBlocks.FIRESTONE_BLOCK.get()
        );
        tag(BlockTags.FENCES).add(
                ModBlocks.AMETHYST_FENCE.get()
        );
        tag(BlockTags.FENCE_GATES).add(
                ModBlocks.AMETHYST_FENCE_GATE.get()
        );
    }
}
