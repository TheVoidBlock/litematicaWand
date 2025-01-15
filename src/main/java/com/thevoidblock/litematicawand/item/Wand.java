package com.thevoidblock.litematicawand.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.thevoidblock.litematicawand.LitematicaWand.MOD_ID;

public class Wand {

    public static final RegistryKey<Item> WAND_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "wand"));
    public static final Item WAND = Registry.register(
            Registries.ITEM,
            WAND_KEY,
            new Item(new Item.Settings().registryKey(WAND_KEY))
    );

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> entries.add(WAND));
    }
}
