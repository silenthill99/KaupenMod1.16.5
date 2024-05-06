package fr.silenthill99.kaupen_mod.custom.trees;

import fr.silenthill99.kaupen_mod.world.gen.ModConfigureFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class RedwoodTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean b) {

        return ModConfigureFeatures.REDWOOD;

    }

}
