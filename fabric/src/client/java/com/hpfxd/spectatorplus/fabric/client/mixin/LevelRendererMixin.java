package com.hpfxd.spectatorplus.fabric.client.mixin;

import com.hpfxd.spectatorplus.fabric.client.SpectatorClientMod;
import com.hpfxd.spectatorplus.fabric.client.util.SpecUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {



    // @Inject(
    //         method = "renderEntity(Lnet/minecraft/world/entity/Entity;DDDFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;)V",
    //         at = @At("HEAD"),
    //         cancellable = true
    // )
    // private void spectatorplus$hideOtherSpectators(Entity entity, double camX, double camY, double camZ, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, CallbackInfo ci) {
    //     if (!SpectatorClientMod.config.showSpectators && this.minecraft.player.isSpectator() && entity instanceof final RemotePlayer player && player.isSpectator()) {
    //         ci.cancel();
    //     }
    // }
}
