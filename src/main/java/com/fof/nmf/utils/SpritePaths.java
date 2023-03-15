package com.fof.nmf.utils;

public class SpritePaths {
    private static final String SpritesPath = "src/main/resources/sprites";
    private static final String CharactersPath = SpritesPath + "/characters";
    private static final String ChampionsPath = CharactersPath + "/champions";
    private static final String ArthaxPath = ChampionsPath + "/arthax.png";
    private static final String BörgPath = ChampionsPath + "/börg.png";
    private static final String GangblancPath = ChampionsPath + "/gangblanc.png";
    private static final String GrumPath = ChampionsPath + "/grum.png";
    private static final String KanjiPath = ChampionsPath + "/kanji.png";
    private static final String KatanPath = ChampionsPath + "/katan.png";
    private static final String OkomoPath = ChampionsPath + "/okomo.png";
    private static final String ZhinjaPath = ChampionsPath + "/zhinja.png";

    private static final String HighlightPath = SpritesPath + "/highlight.png";

    public static String getSpritesPath() {
        return SpritesPath;
    }

    public static String getCharactersPath() {
        return CharactersPath;
    }

    public static String getArthaxPath() {
        return ArthaxPath;
    }

    public static String getBörgPath() {
        return BörgPath;
    }

    public static String getHighlightPath() {
        return HighlightPath;
    }
}
