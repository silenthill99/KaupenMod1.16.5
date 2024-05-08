package fr.silenthill99.kaupen_mod.utils.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.silenthill99.kaupen_mod.Main;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnHomeCommand {

    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes(command -> {
            return returnHome(command.getSource());
        })));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {

        ServerPlayerEntity player = source.getPlayerOrException();
        boolean hasHomepos = player.getPersistentData().getIntArray(Main.MODID + "homepos").length != 0;

        if (hasHomepos) {
            int[] playerPos = player.getPersistentData().getIntArray(Main.MODID + "homepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);
            source.sendSuccess(new StringTextComponent("Player return home !"), true);
            return 1;
        } else {
            source.sendSuccess(new StringTextComponent("No home Position has been set"), true);
            return -1;
        }
    }

}
