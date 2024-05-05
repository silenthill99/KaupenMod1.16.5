package fr.silenthill99.kaupen_mod.custom.blocks;

import fr.silenthill99.kaupen_mod.custom.items.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class FirestoneBlock extends Block {
    public FirestoneBlock(Properties properties) {
        super(properties);
    }

    //Méthode exécutée avec un clic droit
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (!worldIn.isClientSide()) {
            if (handIn == Hand.MAIN_HAND) {
                System.out.println("Right click on firestone block with main hand");
            }

            if (handIn == Hand.OFF_HAND) {
                System.out.println("Right click on firestone block with off hand");
            }

        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    //Quand on fait un clic gauche sur le bloc
    @SuppressWarnings("deprecation")
    @Override
    public void attack(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if (!worldIn.isClientSide()) {
            System.out.println("I left-clicked a Firestone block");
        }
        super.attack(state, worldIn, pos, player);
    }

    // Quand une entité marche sur le bloc
    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 5);
        super.stepOn(worldIn, pos, entityIn);
    }
}
