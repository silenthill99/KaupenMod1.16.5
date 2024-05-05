package fr.silenthill99.kaupen_mod.data.recipes;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModBlocks;
import fr.silenthill99.kaupen_mod.init.ModItems;
import fr.silenthill99.kaupen_mod.utils.ModTags;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.AMETHYST_ORE.get())
                .pattern("#S#")
                .pattern("S#S")
                .pattern("#S#")
                .define('#', ModTags.ModItemTags.AMETHYST)
                .define('S', Blocks.STONE)
                .unlockedBy("tags", has(ModTags.ModItemTags.AMETHYST))
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.STONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.AMETHYST_BLOCK.get())
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .define('0', ModItems.AMETHYST.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.AMETHYST.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.AMETHYST.get(), 9)
                .requires(ModBlocks.AMETHYST_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.AMETHYST_BLOCK.get()))
                .save(consumer, new ResourceLocation(Main.MODID, "amethyst_from_amethyst_block"));

        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.AMETHYST_ORE.get()), ModItems.AMETHYST.get(),
                0.1f, 100)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.AMETHYST_ORE.get()))
                .save(consumer, new ResourceLocation(Main.MODID, "amethyst_from_blasting"));

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.AMETHYST_ORE.get()), ModItems.AMETHYST.get(),
                0.1f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.AMETHYST_ORE.get()))
                .save(consumer, new ResourceLocation(Main.MODID, "amethyst_from_smelting"));
    }
}
