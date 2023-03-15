package com.fof.nmf.actor.monster;

import com.badlogic.gdx.math.MathUtils;
import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.utils.Modifier;

public class Monster extends StatBlock implements IActionBlock {
    @Override
    public float attack() {
        return MathUtils.random(1, 20) + proficiency + Modifier.getModifier(strength);
    }

    @Override
    public int rollInitiative() {
        return MathUtils.random(1, 20) + initiativeBonus;
    }
}
