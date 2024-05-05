package fr.silenthill99.kaupen_mod.data.loot_tables.blocks;

import fr.silenthill99.kaupen_mod.init.ModBlocks;
import fr.silenthill99.kaupen_mod.init.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.fml.RegistryObject;

import java.util.stream.Collectors;

public class BlockLootTableGenerator extends BlockLootTables {
    @Override
    protected void addTables() {
        dropSelf(ModBlocks.AMETHYST_ORE.get());
        dropSelf(ModBlocks.AMETHYST_BLOCK.get());
        dropSelf(ModBlocks.FIRESTONE_BLOCK.get());
        dropSelf(ModBlocks.AMETHYST_STAIRS.get());
        dropSelf(ModBlocks.AMETHYST_FENCE.get());
        dropSelf(ModBlocks.AMETHYST_FENCE_GATE.get());
        dropSelf(ModBlocks.AMETHYST_SLAB.get());
        dropSelf(ModBlocks.AMETHYST_BUTTON.get());
        dropSelf(ModBlocks.AMETHYST_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.AMETHYST_TRAPDOOR.get());
        add(ModBlocks.AMETHYST_DOOR.get(), block -> createDoorTable(block));

        ILootCondition.IBuilder ilootcondition$ibuilder1 = BlockStateProperty
                .hasBlockStateProperties(ModBlocks.OATS.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropsBlock.AGE, 7));

        add(ModBlocks.OATS.get(), block -> createCropDrops(block, ModItems.OATS.get(), ModItems.OATS.get(), ilootcondition$ibuilder1));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}
