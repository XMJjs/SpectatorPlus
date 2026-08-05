package com.hpfxd.spectatorplus.fabric.sync.packet;

import com.hpfxd.spectatorplus.fabric.sync.ServerboundSyncPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public final class ServerboundRequestInventoryOpenPacket implements ServerboundSyncPacket {
    public static final StreamCodec<FriendlyByteBuf, ServerboundRequestInventoryOpenPacket> STREAM_CODEC = CustomPacketPayload.codec(ServerboundRequestInventoryOpenPacket::write, ServerboundRequestInventoryOpenPacket::new);
    public static final CustomPacketPayload.Type<ServerboundRequestInventoryOpenPacket> TYPE = new CustomPacketPayload.Type<>(Identifier.parse("spectatorplus:request_inventory_open"));

    public ServerboundRequestInventoryOpenPacket() {
    }

    public ServerboundRequestInventoryOpenPacket(FriendlyByteBuf buf) {
    }

    public void write(FriendlyByteBuf buf) {
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
