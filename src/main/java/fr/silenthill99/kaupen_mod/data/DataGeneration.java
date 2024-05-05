package fr.silenthill99.kaupen_mod.data;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.data.loot_tables.LootTableGenerator;
import fr.silenthill99.kaupen_mod.data.models_and_blockstates.BlockStateGenerator;
import fr.silenthill99.kaupen_mod.data.models_and_blockstates.ItemModelGenerator;
import fr.silenthill99.kaupen_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.kaupen_mod.data.tags.BlockTagsGenerator;
import fr.silenthill99.kaupen_mod.data.tags.ItemTagsGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new BlockStateGenerator(generator, existingFileHelper));
            generator.addProvider(new ItemModelGenerator(generator, existingFileHelper));
        }
        
        if (event.includeServer()) {
            BlockTagsGenerator blockTagsGenerator = new BlockTagsGenerator(generator, existingFileHelper);
            generator.addProvider(blockTagsGenerator);
            generator.addProvider(new ItemTagsGenerator(generator, blockTagsGenerator, existingFileHelper));
            generator.addProvider(new LootTableGenerator(generator));
            generator.addProvider(new RecipeGenerator(generator));
        }
    }
}
