package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {

            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            BlockState state = context.getWorld().getBlockState(positionClicked);

            if (state.isOf(ModBlocks.BIMAL_BLOCK))
                player.sendMessage(Text.literal("YAYYA This is Bimal Block at position: ("
                         + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_ORE))
                player.sendMessage(Text.literal("YAYYA This is Bimal Ore at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_DEEPSLATE_ORE))
                player.sendMessage(Text.literal("YAYYA This is Bimal Deepslate Ore at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_TRAPDOOR))
                player.sendMessage(Text.literal("YAYYA This is Bimal Trapdoor at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_SLAB))
                player.sendMessage(Text.literal("YAYYA This is Bimal Slab at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_BUTTON))
                player.sendMessage(Text.literal("YAYYA This is Bimal Button at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_STAIRS))
                player.sendMessage(Text.literal("YAYYA This is Bimal Stairs at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));
            else if (state.isOf(ModBlocks.BIMAL_FENCE))
                player.sendMessage(Text.literal("YAYYA This is Bimal Fence at position: ("
                        + positionClicked.getX() + ", " + positionClicked.getY() + ", " + positionClicked.getZ() + ")"));


//            boolean foundBlock = false;
//            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
//                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
//
//                if(isValuableBlock(state)) {
//                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
//                    foundBlock = true;
//
//                    break;
//                }
//            }
//
//            if(!foundBlock) {
//                player.sendMessage(Text.literal("No Valuables Found!"));
//            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
