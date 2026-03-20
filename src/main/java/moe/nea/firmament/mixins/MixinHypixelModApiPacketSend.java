package moe.nea.firmament.mixin;

import net.hypixel.modapi.HypixelModAPI;
import net.hypixel.modapi.packet.HypixelPacket;
import net.hypixel.modapi.packet.impl.serverbound.ServerboundModListPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = HypixelModAPI.class, remap = false)
public class MixinHypixelModApiPacketSend {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void blockModListPacket(HypixelPacket packet, CallbackInfo ci) {
        if (packet instanceof ServerboundModListPacket) {
            ci.cancel();
        }
    }
}
