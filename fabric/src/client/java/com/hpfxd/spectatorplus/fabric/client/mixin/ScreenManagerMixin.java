package com.hpfxd.spectatorplus.fabric.client.mixin;

import com.hpfxd.spectatorplus.fabric.client.util.SpecUtil;
import com.hpfxd.spectatorplus.fabric.sync.packet.ServerboundOpenedInventorySyncPacket;
import com.hpfxd.spectatorplus.fabric.sync.packet.ServerboundRequestInventoryOpenPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class ScreenManagerMixin {
    @Shadow @Final private Minecraft minecraft;

    /**
     * If the server has indicated the ability to accept the {@link ServerboundRequestInventoryOpenPacket}, we want to
     * send it instead of opening the client's inventory and let the server handle
     * opening the inventory for us.
     */
    @Inject(
            method = "setScreen",
            at = @At("HEAD"),
            cancellable = true
    )
    private void spectatorplus$requestSpectatorInventoryOpen(Screen guiScreen, CallbackInfo ci) {
        if (guiScreen != null && guiScreen.getClass() == net.minecraft.client.gui.screens.inventory.InventoryScreen.class) {
            // are we currently spectating a player?
            final AbstractClientPlayer spectated = SpecUtil.getCameraPlayer(this.minecraft);
            
            if (spectated != null) {
                boolean canSend = ClientPlayNetworking.canSend(ServerboundRequestInventoryOpenPacket.TYPE);
                if (canSend) {
                    // server has registered the ability to accept the packet, we want to cancel the original setScreen call
                    // and send the packet to the server. if the server has not registered this packet, the mod will not
                    // interfere with this key's normal operation.
                    ClientPlayNetworking.send(new ServerboundRequestInventoryOpenPacket(spectated.getUUID()));
                    ci.cancel();
                    return;
                }
            }

            boolean canSendOpened = ClientPlayNetworking.canSend(ServerboundOpenedInventorySyncPacket.TYPE);
            if (canSendOpened) {
                // just let the server we've opened our inventory. this is used to sync with other users spectating this client
                ClientPlayNetworking.send(new ServerboundOpenedInventorySyncPacket());
            }
        }
    }
}
