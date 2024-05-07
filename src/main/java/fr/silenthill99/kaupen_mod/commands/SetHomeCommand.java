package fr.silenthill99.kaupen_mod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.silenthill99.kaupen_mod.Main;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class SetHomeCommand {

    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set").executes(command -> {
            return setHome(command.getSource());
        })));
    }

    private int setHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrException();
        BlockPos playerPos = player.blockPosition();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        player.getPersistentData().putIntArray(Main.MODID + "homepos",
                new int[]{playerPos.getX(), playerPos.getY(), playerPos.getZ()});

        source.sendSuccess(new StringTextComponent("Set home at " + pos), true);
        return 1;
    }
}
