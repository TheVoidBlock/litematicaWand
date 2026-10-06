package io.github.thevoidblock.litematicawand.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import io.github.thevoidblock.litematicawand.item.WandItem;
import io.netty.channel.ChannelFutureListener;
import net.minecraft.network.Connection;
import net.minecraft.network.HashedStack;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import net.minecraft.network.protocol.game.ServerboundSetCreativeModeSlotPacket;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Connection.class)
public class ConnectionMixin {
    @WrapMethod(method = "sendPacket")
    private void sendPacket(Packet<?> packet, @Nullable ChannelFutureListener listener, boolean flush, Operation<Void> original) {
        boolean isWandClick = packet instanceof ServerboundContainerClickPacket clickPacket
                && ((clickPacket.carriedItem() instanceof HashedStack.ActualItem actualItem && actualItem.item().is(WandItem.WAND_KEY))
                || clickPacket.changedSlots().values().stream().anyMatch(slot -> slot instanceof HashedStack.ActualItem slotItem && slotItem.item().is(WandItem.WAND_KEY)));

        boolean isWandCreativeSlot = packet instanceof ServerboundSetCreativeModeSlotPacket setCreativeModeSlotPacket
                && setCreativeModeSlotPacket.itemStack().getItem().equals(WandItem.WAND);

        if (!isWandClick && !isWandCreativeSlot) {
            original.call(packet, listener, flush);
        }
    }
}
