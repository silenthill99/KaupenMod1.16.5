package fr.silenthill99.kaupen_mod.custom.items;

import fr.silenthill99.kaupen_mod.utils.ModTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class Firestone extends Item  {
    public Firestone(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();

        if (!world.isClientSide) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getClickedPos());

            richtClickOnCertainBlockState(clickedBlock, context, playerEntity);
            stack.hurtAndBreak(1, playerEntity, player -> player.broadcastBreakEvent(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag FlagIn) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.kaupen_mod.firestone_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.kaupen_mod.firestone"));
        }
    }

    private void richtClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {

        boolean playerIsNotOnFire = !playerEntity.isOnFire();

        if (random.nextFloat() > 0.5f) {
            lightEntityOnFire(playerEntity, 6);
        } else if (playerIsNotOnFire && blockIsValidForResistance(clickedBlock)) {
            gainFireResistanceAndDestroyBlock(playerEntity, context.getLevel(), context.getClickedPos());
        } else {
            lightGroundOnFire(context);
        }

    }

    private boolean blockIsValidForResistance(BlockState clickedBlock) {
        return clickedBlock.is(ModTags.ModBlockTags.FIRESTONE_CLICKABLE_BLOCKS);
    }

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setSecondsOnFire(second);
    }

    private void gainFireResistanceAndDestroyBlock(PlayerEntity playerEntity, World world, BlockPos pos) {
        gainFireResistance(playerEntity);
        world.destroyBlock(pos, false);
    }

    public static void gainFireResistance(PlayerEntity playerEntity) {
        playerEntity.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));
    }

    public static void lightGroundOnFire(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos().offset(context.getClickedFace().getNormal());
        
        if (AbstractFireBlock.canBePlacedAt(world, blockpos, context.getHorizontalDirection())) {
            world.playSound(playerentity, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS,
                    1.0F, random.nextFloat() * 0.4F + 0.8F);

            BlockState blockstate = AbstractFireBlock.getState(world, blockpos);
            world.setBlock(blockpos, blockstate, 11);
        }
    }
}
