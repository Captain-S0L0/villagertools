package com.terriblefriends.villagertools;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ToggleButton extends ButtonWidget {
    protected final ToggleButton.PressAction onPress;

    public ToggleButton(int x, int y, int width, int height, Text message, ToggleButton.PressAction onPress, boolean active) {
        super(x, y, width, height, message, null);
        this.onPress = onPress;
        this.active = active;
    }

    public void onPress() {
        this.onPress.onPress(this);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.visible) {
            if (this.isValidClickButton(button)) {
                boolean bl = this.clicked(mouseX, mouseY);
                if (bl) {
                    this.playDownSound(MinecraftClient.getInstance().getSoundManager());
                    this.onClick(mouseX, mouseY);
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isMouseOver(double mouseX, double mouseY) {
        return this.visible && mouseX >= (double)this.x && mouseY >= (double)this.y && mouseX < (double)(this.x + this.width) && mouseY < (double)(this.y + this.height);
    }

    protected boolean clicked(double mouseX, double mouseY) {
        return this.visible && mouseX >= (double)this.x && mouseY >= (double)this.y && mouseX < (double)(this.x + this.width) && mouseY < (double)(this.y + this.height);
    }

    public interface PressAction {
        void onPress(ToggleButton button);
    }
}
