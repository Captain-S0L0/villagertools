package com.terriblefriends.villagertools.mixin;

import com.terriblefriends.villagertools.Messager;
import com.terriblefriends.villagertools.VillagerTools;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(TradeOfferList.class)
public class TradeOfferListMixin {
    @Inject(at=@At("HEAD"),method="Lnet/minecraft/village/TradeOfferList;fromPacket(Lnet/minecraft/network/PacketByteBuf;)Lnet/minecraft/village/TradeOfferList;", cancellable = true)
    private static void findValidTrades(PacketByteBuf buf, CallbackInfoReturnable<TradeOfferList> cir) {
        TradeOfferList tradeOfferList = new TradeOfferList();
        int i = buf.readByte() & 255;

        for(int j = 0; j < i; ++j) {
            ItemStack itemStack = buf.readItemStack();
            ItemStack itemStack2 = buf.readItemStack();
            ItemStack itemStack3 = buf.readItemStack();
            boolean bl = buf.readBoolean();
            int k = buf.readInt();
            int l = buf.readInt();
            int m = buf.readInt();
            int n = buf.readInt();
            float f = buf.readFloat();
            int o = buf.readInt();

            if (itemStack2.getItem() == Items.ENCHANTED_BOOK) {
                Map<Enchantment, Integer> bookEnchantMap = EnchantmentHelper.get(itemStack2);
                for (Enchantment bookEnchantmentToCheck : bookEnchantMap.keySet()) {
                    int bookEnchantLevel = bookEnchantMap.get(bookEnchantmentToCheck);
                    if (!VillagerTools.enabledEnchantments.get(bookEnchantmentToCheck)) {
                        break;
                    }
                    int maxEnchantLevel = VillagerTools.maxEnchantLevels.get(bookEnchantmentToCheck);
                    if (bookEnchantLevel == maxEnchantLevel && itemStack.getCount() <= 64) {
                        Messager.rawchat("!!!!!!!");
                        Messager.chatText(Text.literal("Max Enchantment Found! ").append(Text.translatable(bookEnchantmentToCheck.getTranslationKey())));
                        Messager.rawchat("!!!!!!!");
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F));
                        if (VillagerTools.autoDisableOnFind) {
                            VillagerTools.enabledEnchantments.put(bookEnchantmentToCheck, false);
                        }
                    }
                }
            }
            TradeOffer tradeOffer = new TradeOffer(itemStack, itemStack3, itemStack2, k, l, m, f, o);
            if (bl) {
                tradeOffer.disable();
            }

            tradeOffer.setSpecialPrice(n);
            tradeOfferList.add(tradeOffer);
        }

        cir.setReturnValue(tradeOfferList);
        if (cir.isCancellable()) {cir.cancel();}
    }

}
