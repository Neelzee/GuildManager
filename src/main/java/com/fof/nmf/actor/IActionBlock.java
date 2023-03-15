package com.fof.nmf.actor;

public interface IActionBlock {

    /**
     * Returns the attack value, i.e.
     * the value that must be equal or greater than the armorClass to result in a successful attack
     * @return Attack Value = d20 + weapon modifier + proficiency bonus + skill modifier.
     */
    float attack();

    /**
     * Returns the initiative value, i.e.
     * the value that is used to determine when an Instance does their turn.
     * @return Initiative = d20 + initiative modifier
     */
    int rollInitiative();
}
