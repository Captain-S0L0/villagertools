package com.terriblefriends.villagertools.mixin;

import com.terriblefriends.villagertools.ToggleButton;
import com.terriblefriends.villagertools.VillagerScreen;
import com.terriblefriends.villagertools.VillagerTools;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }


    @Inject(at=@At("TAIL"),method="Lnet/minecraft/client/gui/screen/GameMenuScreen;initWidgets()V")

    private void addGuiButton(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(this.width-98,this.height-20,98,20,new LiteralText("Librarian Helper"), (button) -> {
            this.client.setScreen(new VillagerScreen(new LiteralText("cheese")));
        }));
        this.addDrawableChild(new ToggleButton(this.width-98,this.height-40,98,20,new LiteralText("Open Void Trade"), (button) -> {
            if (VillagerTools.voidScreen != null) {
                this.client.setScreen(VillagerTools.voidScreen);
                VillagerTools.voidScreen = null;
                VillagerTools.voidVillagerPos = null;
            }
        }, VillagerTools.voidScreen != null));
    }
}
