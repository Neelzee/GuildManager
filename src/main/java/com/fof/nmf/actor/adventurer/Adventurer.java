package com.fof.nmf.actor.adventurer;

import com.badlogic.gdx.math.MathUtils;
import com.fof.nmf.actor.DamageType;
import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.utils.Modifier;

import java.util.ArrayList;

public class Adventurer extends StatBlock implements IActionBlock {

    private GameClass gClass;

    /**
     * How many successes or failures needed for saving throws
     */
    private final int savingThrowsLimit = 3;

    private int level;

    private float experience;

    /**
     * Saving throws, max 2*savingThrowsLimit rolls
     */
    private final ArrayList<Boolean> savingThrows = new ArrayList<>();

    /**
     * If the instance has failed all saving throws, or has less currenHp than negative maxHp
     */
    protected boolean isDead;


    /**
     * Checks if the Instance is instantly dead after taking damage
     */
    protected void isInstantDead() {
        if (currentHp < 0 && currentHp >= maxHp) {
            isDead = true;
        }
    }

    /**
     * Rolls a saving throw, at the given index.
     *
     * @param advantage if the Instance has advantage or not
     */
    public boolean savingThrow(boolean advantage) {
        int dice = MathUtils.random(1, 20);
        if (advantage) {
            int d2 = MathUtils.random(1, 20);
            if (d2 > dice) {
                dice = d2;
            }
        }

        if (2 * savingThrowsLimit < savingThrows.size()) {
            throw new RuntimeException("Index out of bounds");
        }

        if (dice == 20) {
            currentHp = 1;
            savingThrows.clear();
            return true;
        }

        savingThrows.add(dice <= 10);

        // Checks is dead
        if (savingThrows.size() >= 3) {
            checkSavingThrows();
        }

        return dice <= 10;
    }

    @Override
    public void takeDamage(float damage, DamageType damageType) {
        super.takeDamage(damage, damageType);

        // Attacked while unconscious results in an auto failed saving throw
        if (currentHp <= 0) {
            savingThrows.add(false);
        }

        isInstantDead();
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
    public boolean isDead() {
        if (currentHp > 0) {
            return false;
        }

        checkSavingThrows();

        return isDead;
    }

    /**
     * Checks if Instance is dead or not.
     */
    private void checkSavingThrows() {
        int failures = 0;
        int successes = 0;
        for (Boolean savingThrow : savingThrows) {
            if (savingThrow) {
                successes++;
            } else {
                failures++;
            }
        }

        if (successes >= 3) {
            currentHp = 1;
            savingThrows.clear();
            return;
        }

        if (failures >= 3) {
            isDead = true;
        }
    }
}
