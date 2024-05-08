package fr.silenthill99.kaupen_mod.events;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.utils.commands.ReturnHomeCommand;
import fr.silenthill99.kaupen_mod.utils.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if (!event.getOriginal().getCommandSenderWorld().isClientSide) {
            event.getPlayer().getPersistentData().putIntArray(Main.MODID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(Main.MODID + "homepos"));
        }
    }

}
