package io.github.thevoidblock.litematicawand.command;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import static io.github.thevoidblock.litematicawand.item.WandItem.WAND;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal;

public class WandCommand {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register(
                (dispatcher, _) -> dispatcher.register(
                        literal("lwand").executes(context -> {
                            ItemStack stack = WAND.getDefaultInstance();
                            context.getSource().sendFeedback(Component.translatable("commands.litematicawand.lwand", stack.count(), stack.getDisplayName()));
                            context.getSource().getPlayer().getInventory().add(stack);
                            return Command.SINGLE_SUCCESS;
                        })
                ));
    }
}
