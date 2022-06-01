package com.terriblefriends.villagertools.mixin;

import com.terriblefriends.villagertools.VillagerTools;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientChunkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientChunkManager.class)
public class ClientChunkManagerMixin {
    @Inject(at=@At("HEAD"),method="Lnet/minecraft/client/world/ClientChunkManager;unload(II)V")
    private void openVoidGUIAuto(int chunkX, int chunkZ, CallbackInfo ci) {
        if (VillagerTools.voidVillagerPos != null && chunkX == VillagerTools.voidVillagerPos.x && chunkZ == VillagerTools.voidVillagerPos.z) {
            MinecraftClient.getInstance().setScreen(VillagerTools.voidScreen);
            VillagerTools.voidVillagerPos = null;
            VillagerTools.voidScreen = null;
        }
    }
}
