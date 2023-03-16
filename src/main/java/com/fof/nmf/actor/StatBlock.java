package com.fof.nmf.actor;

import com.fof.nmf.utils.GameDice;

import java.util.ArrayList;

public class StatBlock {

    /**
     * Max Hp
     */
    protected int maxHp;

    /**
     * Attacks must equal or exceed this value to hit
     */
    protected int armorClass;

    /**
     * Bonus added too skills if the Instance is proficient at that skill
     */
    protected int proficiency;

    /**
     * Current hp
     */
    protected float currentHp;

    /**
     * Temporary hit-points
     */
    protected float tempHp;

    /**
     * Bonus added to initiative rolls
     */
    protected int initiativeBonus;

    protected int strength;

    protected int constitution;

    protected int dexterity;

    protected int wisdom;

    protected int intelligence;

    protected int charisma;

    /**
     * How far the Instance can move on one turn, in feet.
     */
    protected int moveSpeed;

    /**
     * Damage Types that the Instance is resistant too, i.e. they take 50% less damage from that type
     */
    protected ArrayList<DamageType> resistances = new ArrayList<>();

    /**
     * Damage Types that the Instance is immune too, i.e. they take no damage from that type
     */
    protected ArrayList<DamageType> immune = new ArrayList<>();

    public StatBlock() {
        maxHp = 4;
        currentHp = maxHp;
        strength = 10;
        constitution = 10;
        dexterity = 10;
        wisdom = 10;
        intelligence = 10;
        charisma = 10;
        moveSpeed = 30;
        proficiency = 0;
        initiativeBonus = 0;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }


    public int getDexterity() {
        return dexterity;
    }


    public int getWisdom() {
        return wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getProficiency() {
        return proficiency;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    /**
     * Returns True if the attack is successful.
     */
    public boolean tryAttack(float attack) {
        return attack >= armorClass;
    }

    /**
     * Checks if the Instance is immune or resistant to the damage type,
     * then applies the damage, if any.
     */
    public void takeDamage(float damage, DamageType damageType) {
        if (immune.contains(damageType)) {
            return;
        }

        if (resistances.contains(damageType)) {
            damage /= 2;
        }

        if (tempHp > 0 && tempHp >= damage) {
            tempHp -= damage;
        } else if (tempHp > 0) {
            tempHp = 0;
            damage -= tempHp;
            currentHp -= damage;
        } else if (tempHp == 0) {
            currentHp -= damage;
        }
    }

    public boolean isDead() {

        return !(currentHp > 0);
    }
}
