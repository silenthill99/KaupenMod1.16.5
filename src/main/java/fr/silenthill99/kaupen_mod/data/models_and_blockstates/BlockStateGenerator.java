package fr.silenthill99.kaupen_mod.data.models_and_blockstates;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {

    private String path;
    private Block amethystBlock = ModBlocks.AMETHYST_BLOCK.get();

    public BlockStateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.AMETHYST_ORE.get());
        simpleBlock(amethystBlock);
        simpleBlock(ModBlocks.FIRESTONE_BLOCK.get());
        stairsBlock((StairsBlock) ModBlocks.AMETHYST_STAIRS.get(), blockTexture(amethystBlock));
        fenceBlock((FenceBlock) ModBlocks.AMETHYST_FENCE.get(), blockTexture(amethystBlock));
        fenceGateBlock((FenceGateBlock) ModBlocks.AMETHYST_FENCE_GATE.get(), blockTexture(amethystBlock));
        slabBlock((SlabBlock) ModBlocks.AMETHYST_SLAB.get(), blockTexture(ModBlocks.AMETHYST_BLOCK.get()),
                blockTexture(ModBlocks.AMETHYST_BLOCK.get()));
        buttonBlock((AbstractButtonBlock) ModBlocks.AMETHYST_BUTTON.get());
        pressurePlateBlock((PressurePlateBlock) ModBlocks.AMETHYST_PRESSURE_PLATE.get());
        doorBlock((DoorBlock) ModBlocks.AMETHYST_DOOR.get(),
                modLoc("block/" + ModBlocks.AMETHYST_DOOR.getId().getPath() + "_bottom"),
                modLoc("block/" + ModBlocks.AMETHYST_DOOR.getId().getPath() + "_top"));
        trapdoorBlock((TrapDoorBlock) ModBlocks.AMETHYST_TRAPDOOR.get(),
                blockTexture(ModBlocks.AMETHYST_TRAPDOOR.get()), true);
        logBlock((RotatedPillarBlock) ModBlocks.REDWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.REDWOOD_WOOD.get(), blockTexture(ModBlocks.REDWOOD_LOG.get()),
                blockTexture(ModBlocks.REDWOOD_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_REDWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_REDWOOD_WOOD.get(),
                blockTexture(ModBlocks.STRIPPED_REDWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_REDWOOD_LOG.get()));
        simpleBlock(ModBlocks.REDWOOD_PLANKS.get());
        leavesBlock((LeavesBlock) ModBlocks.REDWOOD_LEAVES.get());
    }

    @Override
    public void simpleBlock(Block block) {
        super.simpleBlock(block);
        simpleBlockItem(block, cubeAll(block));
    }

    @Override
    public void stairsBlock(StairsBlock block, ResourceLocation texture) {
        super.stairsBlock(block, texture);
        path = block.getRegistryName().getPath();
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    @Override
    public void fenceBlock(FenceBlock block, ResourceLocation texture) {
        super.fenceBlock(block, texture);
        path = block.getRegistryName().getPath();
        simpleBlockItem(block, models().fenceInventory(path + "_inventory", texture));
    }

    @Override
    public void fenceGateBlock(FenceGateBlock block, ResourceLocation texture) {
        super.fenceGateBlock(block, texture);
        path = block.getRegistryName().getPath();
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    @Override
    public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        super.slabBlock(block, doubleslab, texture);
        path = block.getRegistryName().getPath();
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    private void buttonBlock(AbstractButtonBlock button) {
        path = button.getRegistryName().getPath();
        simpleBlockItem(button, new ModelFile.UncheckedModelFile(modLoc("block/" + path + "_inventory")));
    }

    private void pressurePlateBlock(PressurePlateBlock block) {
        path = block.getRegistryName().getPath();
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    @Override
    public void trapdoorBlock(TrapDoorBlock block, ResourceLocation texture, boolean orientable) {
        path = block.getRegistryName().getPath();
        super.trapdoorBlock(block, texture, orientable);
        simpleBlockItem(block, models().trapdoorBottom(path + "_bottom", modLoc("block/" + path)));
    }

    @Override
    public void axisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        path = block.getRegistryName().getPath();
        super.axisBlock(block, side, end);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    @Override
    public void logBlock(RotatedPillarBlock block) {
        path = block.getRegistryName().getPath();
        super.logBlock(block);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    private void leavesBlock(LeavesBlock block) {
        path = block.getRegistryName().getPath();
        simpleBlock(block);
        simpleBlockItem(block, models().singleTexture(path, mcLoc("block/leaves"), "all", blockTexture(block)));
    }
}
