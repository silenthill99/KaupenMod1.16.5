package fr.silenthill99.kaupen_mod.world;

import fr.silenthill99.kaupen_mod.Main;
import fr.silenthill99.kaupen_mod.world.gen.ModOreGeneration;
import fr.silenthill99.kaupen_mod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
    }

}
