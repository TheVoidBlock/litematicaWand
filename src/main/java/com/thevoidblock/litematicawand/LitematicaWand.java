package com.thevoidblock.litematicawand;

import com.thevoidblock.litematicawand.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LitematicaWand implements ModInitializer {

    public static final String MOD_ID = "litematicawand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItems.registerModItems();

        LOGGER.info("{} initialized!", MOD_ID);
    }
}
