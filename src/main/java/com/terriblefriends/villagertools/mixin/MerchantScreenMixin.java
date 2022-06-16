package com.terriblefriends.villagertools.mixin;

import com.terriblefriends.villagertools.ToggleButton;
import com.terriblefriends.villagertools.VillagerTools;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MerchantScreen.class)
public class MerchantScreenMixin extends Screen {

    protected MerchantScreenMixin(Text title) {
        super(title);
    }

    @Inject(at=@At("TAIL"),method="Lnet/minecraft/client/gui/screen/ingame/MerchantScreen;init()V")
    private void addGuiButton(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(this.width-98,this.height-20,98,20,Text.literal("Void Trade"), (button) -> {
            VillagerTools.voidScreen = client.currentScreen;
            VillagerTools.setScreen(null);
            if (client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
                //VillagerTools.voidVillagerPos = new ChunkPos(((EntityHitResult)client.crosshairTarget).getEntity().getBlockPos());
                VillagerTools.voidVillagerPos = new ChunkPos(client.player.getBlockPos());
            }
        }));
        this.addDrawableChild(new ToggleButton(this.width-98,this.height-40, 98, 20, Text.literal("Auto Open GUI"), (button) -> {
            VillagerTools.autoOpenVoidGui = !VillagerTools.autoOpenVoidGui;
            button.active = !button.active;
        }, VillagerTools.autoOpenVoidGui));
    }


}
