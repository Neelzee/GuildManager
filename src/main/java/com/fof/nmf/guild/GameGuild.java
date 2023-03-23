package com.fof.nmf.guild;

import com.fof.nmf.utils.CurrencyConversion;

public class GameGuild {

    /**
     * Money in GP
     */
    private static int guildMoneyGp = 300;
    private static int guildMoneySp = 300;
    private static int guildMoneyCp = 300;



    public static void addMoney(int money, GameCurrency currency) {
        switch (currency) {
            case COPPER -> {
                guildMoneyCp += money;
            }
            case SILVER -> {
                guildMoneySp += money;
            }
            // Converts down, so there's never a remainder
            default -> {
                guildMoneyGp += CurrencyConversion.convert(currency, GameCurrency.GOLD, money)[0];
            }
        }
    }

    public static boolean canBuy(int value, GameCurrency currency) {
        switch (currency) {
            case COPPER -> {
                return guildMoneyCp >= value;
            }
            case SILVER -> {
                return guildMoneySp >= value;
            }
            // Converts down, so there's never a remainder
            default -> {
                return guildMoneyGp >= CurrencyConversion.convert(currency, GameCurrency.GOLD, value)[0];
            }
        }

    }

    public static void buy(int cost, GameCurrency currency) {
        switch (currency) {
            case COPPER -> {
                guildMoneyCp -= cost;
            }
            case SILVER -> {
                guildMoneySp -= cost;
            }
            // Converts down, so there's never a remainder
            default -> {
                guildMoneyGp -= CurrencyConversion.convert(currency, GameCurrency.GOLD, cost)[0];
            }
        }
    }


    public static int getGuildMoneyGp() {
        return guildMoneyGp +
                CurrencyConversion.convert(GameCurrency.COPPER, GameCurrency.GOLD, guildMoneyCp)[0] +
                CurrencyConversion.convert(GameCurrency.SILVER, GameCurrency.GOLD, guildMoneySp)[0];
    }
}
