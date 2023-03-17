package com.fof.nmf.utils;

import com.badlogic.gdx.math.MathUtils;

public class GameDice {
    public static int d20() {
        return MathUtils.random(1, 20);
    }

    public static int d12() {
        return MathUtils.random(1, 12);
    }

    public static int d10() {
        return MathUtils.random(1, 10);
    }

    public static int d8() {
        return MathUtils.random(1, 8);
    }

    public static int d6() {
        return MathUtils.random(1, 6);
    }

    public static int d4() {
        return MathUtils.random(1, 4);
    }
}
