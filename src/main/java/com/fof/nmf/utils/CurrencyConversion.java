package com.fof.nmf.utils;

import com.badlogic.gdx.math.MathUtils;
import com.fof.nmf.guild.GameCurrency;

import java.util.HashMap;

public class CurrencyConversion {


    private final static HashMap<GameCurrency, HashMap<GameCurrency, Float>> conversionTable = new HashMap<>();

    private static void setConversionTable() {
        // Copper
        HashMap<GameCurrency, Float> copper = new HashMap<>();
        copper.put(GameCurrency.COPPER, 1f);
        copper.put(GameCurrency.SILVER, 10f);
        copper.put(GameCurrency.ELECTRUM, 50f);
        copper.put(GameCurrency.GOLD, 100f);
        copper.put(GameCurrency.PLATINUM, 1000f);
        conversionTable.put(GameCurrency.COPPER, copper);

        HashMap<GameCurrency, Float> silver = new HashMap<>();
        silver.put(GameCurrency.COPPER, .1f);
        silver.put(GameCurrency.SILVER, 1f);
        silver.put(GameCurrency.ELECTRUM, 5f);
        silver.put(GameCurrency.GOLD, 10f);
        silver.put(GameCurrency.PLATINUM, 100f);
        conversionTable.put(GameCurrency.SILVER, silver);

        HashMap<GameCurrency, Float> electrum = new HashMap<>();
        electrum.put(GameCurrency.COPPER, .05f);
        electrum.put(GameCurrency.SILVER, 5f);
        electrum.put(GameCurrency.ELECTRUM, 1f);
        electrum.put(GameCurrency.GOLD, 2f);
        electrum.put(GameCurrency.PLATINUM, 50f);
        conversionTable.put(GameCurrency.ELECTRUM, electrum);

        HashMap<GameCurrency, Float> gold = new HashMap<>();
        gold.put(GameCurrency.COPPER, .001f);
        gold.put(GameCurrency.SILVER, .1f);
        gold.put(GameCurrency.ELECTRUM, .5f);
        gold.put(GameCurrency.GOLD, 1f);
        gold.put(GameCurrency.PLATINUM, 10f);
        conversionTable.put(GameCurrency.GOLD, gold);

        HashMap<GameCurrency, Float> platinum = new HashMap<>();
        platinum.put(GameCurrency.COPPER, .0001f);
        platinum.put(GameCurrency.SILVER, .01f);
        platinum.put(GameCurrency.ELECTRUM, .02f);
        platinum.put(GameCurrency.GOLD, .1f);
        platinum.put(GameCurrency.PLATINUM, 1f);
        conversionTable.put(GameCurrency.PLATINUM, platinum);
    }

    /**
     * Converts from a given currency, to another one.
     * Returns an array, where the first element is the conversion, rounded down in the "to" currency.
     * And the second element, is the remained, in the "from" currency, if any.
     */
    public static int[] convert(GameCurrency from, GameCurrency to, int value) {

        if (conversionTable.isEmpty()) {
            setConversionTable();
        }

        int val = MathUtils.floor(conversionTable.get(from).get(to) * value);
        int remainder = MathUtils.ceil(value - val);
        return new int[]{val, remainder};
    }


}
