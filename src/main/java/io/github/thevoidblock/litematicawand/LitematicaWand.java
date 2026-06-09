package io.github.thevoidblock.litematicawand;

import io.github.thevoidblock.litematicawand.command.WandCommand;
import io.github.thevoidblock.litematicawand.item.WandItem;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LitematicaWand implements ModInitializer {
    public static final String MOD_ID = "litematicawand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        WandItem.register();
        WandCommand.register();
        LOGGER.info("{} initialized!", MOD_ID);
    }
}
