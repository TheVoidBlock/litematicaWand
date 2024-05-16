package com.thevoidblock.litematicawand.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mojang.text2speech.Narrator.LOGGER;
import static com.thevoidblock.litematicawand.LitematicaWand.MOD_ID;

public class ModItems {

    public static final Item WAND = registerItem("wand", new Item(new FabricItemSettings()));

    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries) {
        entries.add(WAND);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        LOGGER.info("Registering Mod Items for {}", MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(ModItems::addItemsToOperatorItemGroup);
    }
}
