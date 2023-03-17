package com.fof.nmf.entity.creature;

import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.entity.actor.GameActor;
import com.fof.nmf.entity.stats.IActionBlock;
import com.fof.nmf.entity.stats.StatBlock;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.GameDice;
import com.fof.nmf.utils.Modifier;

/**
 * A GameCreature, is either a player or a monster.
 */
public abstract class GameCreature extends StatBlock implements IActionBlock, IGameUpdate, IGameSprite {
    private GameActor gameActor;

    public GameCreature(GameActor gameActor) {
        this.gameActor = gameActor;
    }

    @Override
    public float attack() {
        return GameDice.d20();
    }

    @Override
    public int rollInitiative() {
        return GameDice.d20() + initiativeBonus;
    }

    @Override
    public int getDamage(boolean crit) {
        int val = GameDice.d12();
        return (crit ? 2 * val : val) + proficiency + Modifier.getModifier(strength);
    }

    @Override
    public void update(float dt) {
        gameActor.update();
    }

    @Override
    public GameSprite[] getGameSprite() {
        return new GameSprite[]{gameActor.getGSprite()};
    }

    public GameActor getGameActor() {
        return gameActor;
    }
}
