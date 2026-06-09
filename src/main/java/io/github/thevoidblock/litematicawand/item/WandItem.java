package io.github.thevoidblock.litematicawand.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static io.github.thevoidblock.litematicawand.LitematicaWand.MOD_ID;

public class WandItem {
    public static final ResourceKey<Item> WAND_KEY = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "wand"));
    public static final Item WAND = Registry.register(
            BuiltInRegistries.ITEM,
            WAND_KEY,
            new Item(new Item.Properties().stacksTo(1).setId(WAND_KEY))
    );

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS).register(entries -> entries.accept(WAND));
    }
}
