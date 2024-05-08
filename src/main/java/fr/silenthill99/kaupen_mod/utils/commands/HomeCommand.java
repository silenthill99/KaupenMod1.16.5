package fr.silenthill99.kaupen_mod.utils.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class HomeCommand {

    public HomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").executes((command) -> homeCommand(command.getSource())));
    }

    private int homeCommand(CommandSource source) throws CommandSyntaxException {

        ServerPlayerEntity player = source.getPlayerOrException();
        source.sendSuccess(new StringTextComponent("Merci de préciser un argument !"), true);

        return 1;
    }

}
