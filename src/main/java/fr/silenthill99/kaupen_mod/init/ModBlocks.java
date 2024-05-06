package fr.silenthill99.kaupen_mod.init;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.custom.blocks.FirestoneBlock;
import fr.silenthill99.kaupen_mod.custom.blocks.crops.OatsBlock;
import fr.silenthill99.kaupen_mod.custom.trees.RedwoodTree;
import fr.silenthill99.kaupen_mod.utils.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> AMETHYST_ORE = createBlock("amethyst_ore",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()
                    .strength(5f)));

    public static final RegistryObject<Block> AMETHYST_BLOCK = createBlock("amethyst_block", () -> new Block(
            AbstractBlock.Properties.copy(ModBlocks.AMETHYST_ORE.get())));

    public static final RegistryObject<Block> FIRESTONE_BLOCK = createBlock("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(2)
                    .requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)
                    .strength(8)));

    public static final RegistryObject<Block> AMETHYST_STAIRS = createBlock("amethyst_stairs",
            () -> new StairsBlock(() -> AMETHYST_BLOCK.get().defaultBlockState(), AbstractBlock.Properties
                    .of(Material.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AMETHYST_FENCE = createBlock("amethyst_fence",
            () -> new FenceBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(6f)));

    public static final RegistryObject<Block> AMETHYST_FENCE_GATE = createBlock("amethyst_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.copy(AMETHYST_FENCE.get())));

    public static final RegistryObject<Block> AMETHYST_SLAB = createBlock("amethyst_slab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(AMETHYST_FENCE.get())));

    public static final RegistryObject<Block> AMETHYST_BUTTON = createBlock("amethyst_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.copy(AMETHYST_FENCE.get()).noCollission()));

    public static final RegistryObject<Block> AMETHYST_PRESSURE_PLATE = createBlock("amethyst_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.copy(
                    AMETHYST_FENCE.get())));

    public static final RegistryObject<Block> AMETHYST_DOOR = createBlock("amethyst_door",
            () -> new DoorBlock(AbstractBlock.Properties.copy(AMETHYST_FENCE.get()).noOcclusion()));

    public static final RegistryObject<Block> AMETHYST_TRAPDOOR = createBlock("amethyst_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(2)
                    .requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(6).noOcclusion()));

    public static final RegistryObject<Block> OATS = BLOCKS.register("oats_crops",
            () -> new OatsBlock(AbstractBlock.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> REDWOOD_LOG = createBlock("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> REDWOOD_WOOD = createBlock("redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = createBlock("stripped_redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = createBlock("stripped_redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> REDWOOD_PLANKS = createBlock("redwood_planks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> REDWOOD_LEAVES = createBlock("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2f).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion()));

    public static final RegistryObject<Block> REDWOOD_SAPLING = createBlock("redwood_sapling",
            () -> new SaplingBlock(new RedwoodTree(), AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)));


    private static <T extends Block> RegistryObject<T> createBlock(String name, Supplier<T> supplier) {
        RegistryObject<T> BLOCK = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(BLOCK.get(), new Item.Properties().tab(
                ModItemGroups.TUTORIAL_GROUP.getGroup())){
        });
        return BLOCK;
    }
}
