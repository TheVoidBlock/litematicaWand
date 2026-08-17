package io.github.thevoidblock.litematicawand.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import fi.dy.masa.litematica.util.EntityUtils;
import io.github.thevoidblock.litematicawand.item.WandItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityUtils.class)
public class EntityUtilsMixin {
    @WrapMethod(method = "hasToolItemInHand")
    private static boolean hasToolItemInHand(LivingEntity entity, InteractionHand hand, Operation<Boolean> original) {
        return entity.getItemInHand(hand).getItem().equals(WandItem.WAND) || original.call(entity, hand);
    }
}
