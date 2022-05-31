package com.terriblefriends.villagertools;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;

public class VillagerTools implements ModInitializer {
    public static Map<Enchantment, Boolean> enabledEnchantments = new HashMap<>();
    public static Map<Enchantment, Integer> maxEnchantLevels = new HashMap<>();
    public static boolean autoDisableOnFind = true;
    public static boolean voidScreenSaved = false;
    public static Screen voidScreen;

    static {
        enabledEnchantments.put(Enchantments.AQUA_AFFINITY, true);
        enabledEnchantments.put(Enchantments.CHANNELING, true);
        enabledEnchantments.put(Enchantments.BINDING_CURSE, true);
        enabledEnchantments.put(Enchantments.VANISHING_CURSE, true);
        enabledEnchantments.put(Enchantments.FLAME, true);
        enabledEnchantments.put(Enchantments.INFINITY, true);
        enabledEnchantments.put(Enchantments.MENDING, true);
        enabledEnchantments.put(Enchantments.MULTISHOT, true);
        enabledEnchantments.put(Enchantments.SILK_TOUCH, true);
        enabledEnchantments.put(Enchantments.FIRE_ASPECT, true);
        enabledEnchantments.put(Enchantments.FROST_WALKER, true);
        enabledEnchantments.put(Enchantments.KNOCKBACK, true);
        enabledEnchantments.put(Enchantments.PUNCH, true);
        enabledEnchantments.put(Enchantments.DEPTH_STRIDER, true);
        enabledEnchantments.put(Enchantments.FORTUNE, true);
        enabledEnchantments.put(Enchantments.LOOTING, true);
        enabledEnchantments.put(Enchantments.LOYALTY, true);
        enabledEnchantments.put(Enchantments.LUCK_OF_THE_SEA, true);
        enabledEnchantments.put(Enchantments.LURE, true);
        enabledEnchantments.put(Enchantments.QUICK_CHARGE, true);
        enabledEnchantments.put(Enchantments.RESPIRATION, true);
        enabledEnchantments.put(Enchantments.RIPTIDE, true);
        enabledEnchantments.put(Enchantments.SWEEPING, true);
        enabledEnchantments.put(Enchantments.THORNS, true);
        enabledEnchantments.put(Enchantments.UNBREAKING, true);
        enabledEnchantments.put(Enchantments.BLAST_PROTECTION, true);
        enabledEnchantments.put(Enchantments.FEATHER_FALLING, true);
        enabledEnchantments.put(Enchantments.FIRE_PROTECTION, true);
        enabledEnchantments.put(Enchantments.PIERCING, true);
        enabledEnchantments.put(Enchantments.PROJECTILE_PROTECTION, true);
        enabledEnchantments.put(Enchantments.PROTECTION, true);
        enabledEnchantments.put(Enchantments.BANE_OF_ARTHROPODS, true);
        enabledEnchantments.put(Enchantments.EFFICIENCY, true);
        enabledEnchantments.put(Enchantments.IMPALING, true);
        enabledEnchantments.put(Enchantments.POWER, true);
        enabledEnchantments.put(Enchantments.SHARPNESS, true);
        enabledEnchantments.put(Enchantments.SMITE, true);

        maxEnchantLevels.put(Enchantments.AQUA_AFFINITY,1);
        maxEnchantLevels.put(Enchantments.CHANNELING,1);
        maxEnchantLevels.put(Enchantments.BINDING_CURSE,1);
        maxEnchantLevels.put(Enchantments.VANISHING_CURSE,1);
        maxEnchantLevels.put(Enchantments.FLAME,1);
        maxEnchantLevels.put(Enchantments.INFINITY,1);
        maxEnchantLevels.put(Enchantments.MENDING,1);
        maxEnchantLevels.put(Enchantments.MULTISHOT,1);
        maxEnchantLevels.put(Enchantments.SILK_TOUCH,1);
        maxEnchantLevels.put(Enchantments.FIRE_ASPECT,2);
        maxEnchantLevels.put(Enchantments.FROST_WALKER,2);
        maxEnchantLevels.put(Enchantments.KNOCKBACK,2);
        maxEnchantLevels.put(Enchantments.PUNCH,2);
        maxEnchantLevels.put(Enchantments.DEPTH_STRIDER,3);
        maxEnchantLevels.put(Enchantments.FORTUNE,3);
        maxEnchantLevels.put(Enchantments.LOOTING,3);
        maxEnchantLevels.put(Enchantments.LOYALTY,3);
        maxEnchantLevels.put(Enchantments.LUCK_OF_THE_SEA,3);
        maxEnchantLevels.put(Enchantments.LURE,3);
        maxEnchantLevels.put(Enchantments.QUICK_CHARGE,3);
        maxEnchantLevels.put(Enchantments.RESPIRATION,3);
        maxEnchantLevels.put(Enchantments.RIPTIDE,3);
        maxEnchantLevels.put(Enchantments.SWEEPING,3);
        maxEnchantLevels.put(Enchantments.THORNS,3);
        maxEnchantLevels.put(Enchantments.UNBREAKING,3);
        maxEnchantLevels.put(Enchantments.BLAST_PROTECTION,4);
        maxEnchantLevels.put(Enchantments.FEATHER_FALLING,4);
        maxEnchantLevels.put(Enchantments.FIRE_PROTECTION,4);
        maxEnchantLevels.put(Enchantments.PIERCING,4);
        maxEnchantLevels.put(Enchantments.PROJECTILE_PROTECTION,4);
        maxEnchantLevels.put(Enchantments.PROTECTION,4);
        maxEnchantLevels.put(Enchantments.BANE_OF_ARTHROPODS,5);
        maxEnchantLevels.put(Enchantments.EFFICIENCY,5);
        maxEnchantLevels.put(Enchantments.IMPALING,5);
        maxEnchantLevels.put(Enchantments.POWER,5);
        maxEnchantLevels.put(Enchantments.SHARPNESS,5);
        maxEnchantLevels.put(Enchantments.SMITE,5);
    }

    @Override
    public void onInitialize() {

    }
}
