package com.terriblefriends.villagertools.mixin;

import com.terriblefriends.villagertools.VillagerScreen;
import com.terriblefriends.villagertools.VillagerTools;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
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
        this.addDrawableChild(new ButtonWidget(this.width-98,this.height-20,98,20,new LiteralText("Void Trade"), (button) -> {
            VillagerTools.voidScreen = client.currentScreen;
            setScreen(null);
            System.out.println(VillagerTools.voidScreen.toString());
        }));
    }

    public void setScreen(@Nullable Screen screen) {
        if (screen == null && client.world == null) {
            screen = new TitleScreen();
        } else if (screen == null && client.player.isDead()) {
            if (client.player.showsDeathScreen()) {
                screen = new DeathScreen(null, client.world.getLevelProperties().isHardcore());
            } else {
                client.player.requestRespawn();
            }
        }

        client.currentScreen = screen;
        BufferRenderer.unbindAll();
        if (screen != null) {
            client.mouse.unlockCursor();
            KeyBinding.unpressAll();
            (screen).init(client, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight());
            client.skipGameRender = false;
        } else {
            client.getSoundManager().resumeAll();
            client.mouse.lockCursor();
        }

        client.updateWindowTitle();
    }
}
