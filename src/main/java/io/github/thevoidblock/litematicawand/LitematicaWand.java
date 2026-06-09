package io.github.thevoidblock.litematicawand;

import io.github.thevoidblock.litematicawand.item.Wand;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LitematicaWand implements ModInitializer {
    public static final String MOD_ID = "litematicawand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Wand.register();
        LOGGER.info("{} initialized!", MOD_ID);
    }
}
