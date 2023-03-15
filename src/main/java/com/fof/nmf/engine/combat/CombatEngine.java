package com.fof.nmf.engine.combat;

import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.party.GameParty;
import com.fof.nmf.sprite.GameSprite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombatEngine implements IGameUpdate, IGameSprite {
    private final GameParty adventurerParty;

    private final GameParty monsterParty;

    private final IActionBlock[] turnOrder;

    private int turn = 0;

    public CombatEngine(GameParty adventurerParty, GameParty monsterParty) {
        this.adventurerParty = adventurerParty;
        this.monsterParty = monsterParty;

        ArrayList<IActionBlock> turnOrder = new ArrayList<>();
        ArrayList<Integer> initiativeOrder = new ArrayList<>();
        turnOrder.addAll(List.of(adventurerParty.getActionBlockMembers()));
        turnOrder.addAll(List.of(monsterParty.getActionBlockMembers()));

        for (IActionBlock init : turnOrder) {
            initiativeOrder.add(init.rollInitiative());
        }

        turnOrder.sort(Comparator.comparingInt(o -> initiativeOrder.get(turnOrder.indexOf(o))));

        this.turnOrder = turnOrder.toArray(new IActionBlock[0]);
    }

    /**
     * Returns the current IAction instance, as specified by the initiative.
     */
    public IActionBlock getCurrentActionInstance() {
        return turnOrder[turn % turnOrder.length];
    }

    public void nextTurn() {
        turn++;
    }

    @Override
    public GameSprite[] getGameSprite() {
        ArrayList<GameSprite> sprites = new ArrayList<>();
        sprites.addAll(List.of(monsterParty.getGameSprite()));
        sprites.addAll(List.of(adventurerParty.getGameSprite()));
        return sprites.toArray(new GameSprite[0]);
    }

    @Override
    public void update(float dt) {
        monsterParty.update(dt);
        adventurerParty.update(dt);
    }
}
