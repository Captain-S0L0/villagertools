package com.terriblefriends.villagertools;

import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.*;

public class VillagerScreen extends Screen {

    private static final List<Enchantment> level_one = new ArrayList<>();
    private static final List<Enchantment> level_two = new ArrayList<>();
    private static final List<Enchantment> level_three = new ArrayList<>();
    private static final List<Enchantment> level_four = new ArrayList<>();
    private static final List<Enchantment> level_five = new ArrayList<>();
    
    static {
        level_one.add(Enchantments.AQUA_AFFINITY);
        level_one.add(Enchantments.CHANNELING);
        level_one.add(Enchantments.BINDING_CURSE);
        level_one.add(Enchantments.VANISHING_CURSE);
        level_one.add(Enchantments.FLAME);
        level_one.add(Enchantments.INFINITY);
        level_one.add(Enchantments.MENDING);
        level_one.add(Enchantments.MULTISHOT);
        level_one.add(Enchantments.SILK_TOUCH);

        level_two.add(Enchantments.FIRE_ASPECT);
        level_two.add(Enchantments.FROST_WALKER);
        level_two.add(Enchantments.KNOCKBACK);
        level_two.add(Enchantments.PUNCH);

        level_three.add(Enchantments.DEPTH_STRIDER);
        level_three.add(Enchantments.FORTUNE);
        level_three.add(Enchantments.LOOTING);
        level_three.add(Enchantments.LOYALTY);
        level_three.add(Enchantments.LUCK_OF_THE_SEA);
        level_three.add(Enchantments.LURE);
        level_three.add(Enchantments.QUICK_CHARGE);
        level_three.add(Enchantments.RESPIRATION);
        level_three.add(Enchantments.RIPTIDE);
        level_three.add(Enchantments.SWEEPING);
        level_three.add(Enchantments.THORNS);
        level_three.add(Enchantments.UNBREAKING);

        level_four.add(Enchantments.BLAST_PROTECTION);
        level_four.add(Enchantments.FEATHER_FALLING);
        level_four.add(Enchantments.FIRE_PROTECTION);
        level_four.add(Enchantments.PIERCING);
        level_four.add(Enchantments.PROJECTILE_PROTECTION);
        level_four.add(Enchantments.PROTECTION);

        level_five.add(Enchantments.BANE_OF_ARTHROPODS);
        level_five.add(Enchantments.EFFICIENCY);
        level_five.add(Enchantments.IMPALING);
        level_five.add(Enchantments.POWER);
        level_five.add(Enchantments.SHARPNESS);
        level_five.add(Enchantments.SMITE);
    }

    public VillagerScreen(Text title) {
        super(title);
    }
    
    protected void init() {
        int row = 0;
        int column = 0;
        Iterator level_one_iterator = level_one.iterator();
        while (level_one_iterator.hasNext()) {
            Enchantment level_one_next = (Enchantment)level_one_iterator.next();
            this.addDrawableChild(new EnchantmentButton((100 * column), (25 * row), 98, 20, new TranslatableText(level_one_next.getTranslationKey()), (button) -> {
                Boolean to = !VillagerTools.enabledEnchantments.get(button.getEnchantment());
                button.active = to;
                VillagerTools.enabledEnchantments.put(button.getEnchantment(), to);
            }, level_one_next, VillagerTools.enabledEnchantments.get(level_one_next)));
            row++;
        }
        row = 0;
        column = 1;
        Iterator level_two_iterator = level_two.iterator();
        while (level_two_iterator.hasNext()) {
            Enchantment level_two_next = (Enchantment)level_two_iterator.next();
            this.addDrawableChild(new EnchantmentButton((100 * column), (25 * row), 98, 20, new TranslatableText(level_two_next.getTranslationKey()), (button) -> {
                Boolean to = !VillagerTools.enabledEnchantments.get(button.getEnchantment());
                button.active = to;
                VillagerTools.enabledEnchantments.put(button.getEnchantment(), to);
            }, level_two_next, VillagerTools.enabledEnchantments.get(level_two_next)));
            row++;
        }
        row = 0;
        column = 2;
        Iterator level_three_iterator = level_three.iterator();
        while (level_three_iterator.hasNext()) {
            Enchantment level_three_next = (Enchantment)level_three_iterator.next();
            this.addDrawableChild(new EnchantmentButton((100 * column), (25 * row), 98, 20, new TranslatableText(level_three_next.getTranslationKey()), (button) -> {
                Boolean to = !VillagerTools.enabledEnchantments.get(button.getEnchantment());
                button.active = to;
                VillagerTools.enabledEnchantments.put(button.getEnchantment(), to);
            }, level_three_next, VillagerTools.enabledEnchantments.get(level_three_next)));
            row++;
        }
        row = 0;
        column = 3;
        Iterator level_four_iterator = level_four.iterator();
        while (level_four_iterator.hasNext()) {
            Enchantment level_four_next = (Enchantment)level_four_iterator.next();
            this.addDrawableChild(new EnchantmentButton((100 * column), (25 * row), 98, 20, new TranslatableText(level_four_next.getTranslationKey()), (button) -> {
                Boolean to = !VillagerTools.enabledEnchantments.get(button.getEnchantment());
                button.active = to;
                VillagerTools.enabledEnchantments.put(button.getEnchantment(), to);
            }, level_four_next, VillagerTools.enabledEnchantments.get(level_four_next)));
            row++;
        }
        row = 0;
        column = 4;
        Iterator level_five_iterator = level_five.iterator();
        while (level_five_iterator.hasNext()) {
            Enchantment level_five_next = (Enchantment)level_five_iterator.next();
            this.addDrawableChild(new EnchantmentButton((100 * column), (25 * row), 98, 20, new TranslatableText(level_five_next.getTranslationKey()), (button) -> {
                Boolean to = !VillagerTools.enabledEnchantments.get(button.getEnchantment());
                button.active = to;
                VillagerTools.enabledEnchantments.put(button.getEnchantment(), to);
            }, level_five_next, VillagerTools.enabledEnchantments.get(level_five_next)));
            row++;
        }


        this.addDrawableChild(new ToggleButton(this.width-98, this.height-20,98,20,new LiteralText("Auto Disable On Find"), (button) -> {
            VillagerTools.autoDisableOnFind = !VillagerTools.autoDisableOnFind;
            button.active = !button.active;
        }, VillagerTools.autoDisableOnFind));
        this.addDrawableChild(new ButtonWidget(this.width-98, this.height-40,98,20,new LiteralText("Disable All"), (button) -> {
            for (Enchantment enchantment : VillagerTools.enabledEnchantments.keySet()) {
                VillagerTools.enabledEnchantments.put(enchantment, false);
            }
            for (Element w : this.children()) {
                if (w instanceof EnchantmentButton) {
                    ((ButtonWidget) w).active = false;
                }
            }
        }));
        this.addDrawableChild(new ButtonWidget(this.width-98, this.height-60,98,20,new LiteralText("Enable All"), (button) -> {
            for (Enchantment enchantment : VillagerTools.enabledEnchantments.keySet()) {
                VillagerTools.enabledEnchantments.put(enchantment, true);
            }
            for (Element w : this.children()) {
                if (w instanceof EnchantmentButton) {
                    ((ButtonWidget) w).active = true;
                }
            }
        }));
    }
}
