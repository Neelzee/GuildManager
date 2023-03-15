package com.fof.nmf.utils;

import com.badlogic.gdx.math.MathUtils;

public class Modifier {
    public static int getModifier(int value) {
        return MathUtils.floor((value - 10) / 2f);
    }
}
