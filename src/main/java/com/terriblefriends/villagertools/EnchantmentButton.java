package com.terriblefriends.villagertools;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.text.Text;

public class EnchantmentButton extends ToggleButton {
    private final Enchantment enchantment;
    protected final EnchantmentButton.PressAction onPress;

    public EnchantmentButton(int x, int y, int width, int height, Text message, PressAction onPress, Enchantment enchantment, boolean active) {
        super(x, y, width, height, message, null, active);
        this.onPress = onPress;
        this.enchantment = enchantment;
    }

    public void onPress() {
        this.onPress.onPress(this);
    }

    public Enchantment getEnchantment() {
        return this.enchantment;
    }

    public interface PressAction {
        void onPress(EnchantmentButton button);
    }
}
