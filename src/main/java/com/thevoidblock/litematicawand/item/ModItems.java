package com.thevoidblock.litematicawand.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.mojang.text2speech.Narrator.LOGGER;
import static com.thevoidblock.litematicawand.LitematicaWand.MOD_ID;

public class ModItems {

    public static final RegistryKey<Item> WAND_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "wand"));
    public static final Item WAND = registerItem(new Item(new Item.Settings().registryKey(WAND_KEY)), WAND_KEY);

    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries) {
        entries.add(WAND);
    }

    private static Item registerItem(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(
                Registries.ITEM,
                registryKey.getValue(),
                item
        );
    }

    public static void registerModItems() {
        LOGGER.info("Registering Mod Items for {}", MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(ModItems::addItemsToOperatorItemGroup);
    }
}
