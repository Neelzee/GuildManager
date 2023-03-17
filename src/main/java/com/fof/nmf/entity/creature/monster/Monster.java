package com.fof.nmf.entity.creature.monster;

import com.badlogic.gdx.math.MathUtils;
import com.fof.nmf.entity.actor.GameActor;
import com.fof.nmf.entity.creature.GameCreature;
import com.fof.nmf.entity.stats.IActionBlock;
import com.fof.nmf.entity.stats.StatBlock;
import com.fof.nmf.utils.GameDice;
import com.fof.nmf.utils.Modifier;

public class Monster extends GameCreature {
    public Monster(GameActor gameActor) {
        super(gameActor);
    }

    @Override
    public float attack() {
        return MathUtils.random(1, 20) + proficiency + Modifier.getModifier(strength);
    }

    @Override
    public int rollInitiative() {
        return MathUtils.random(1, 20) + initiativeBonus;
    }

    @Override
    public int getDamage(boolean crit) {
        int val = GameDice.d12();
        return (crit ? 2 * val : val) + proficiency + strength;
    }
}
