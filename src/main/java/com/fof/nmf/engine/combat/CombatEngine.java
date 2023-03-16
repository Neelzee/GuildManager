package com.fof.nmf.engine.combat;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.party.GameParty;
import com.fof.nmf.sprite.GameSprite;

import java.util.*;

public class CombatEngine implements IGameUpdate, IGameSprite {
    private final GameParty adventurerParty;

    private final GameParty monsterParty;

    private final IActionBlock[] actionBlocks;

    private final StatBlock[] statBlocks;

    private final GameSprite[] gameSprites;

    private int turn = 0;

    public CombatEngine(GameParty adventurerParty, GameParty monsterParty) {
        this.adventurerParty = adventurerParty;
        this.monsterParty = monsterParty;

        ArrayList<IActionBlock> actionBlocks = new ArrayList<>();
        ArrayList<StatBlock> statBlocks = new ArrayList<>();
        ArrayList<GameSprite> gameSprites = new ArrayList<>();


        ArrayList<Integer> initiativeOrder = new ArrayList<>();
        actionBlocks.addAll(List.of(adventurerParty.getActionBlockMembers()));
        actionBlocks.addAll(List.of(monsterParty.getActionBlockMembers()));
        statBlocks.addAll(List.of(adventurerParty.getStatBlockMembers()));
        statBlocks.addAll(List.of(monsterParty.getStatBlockMembers()));
        gameSprites.addAll(List.of(adventurerParty.getGameSprite()));
        gameSprites.addAll(List.of(monsterParty.getGameSprite()));

        for (IActionBlock init : actionBlocks) {
            initiativeOrder.add(init.rollInitiative());
        }

        actionBlocks.sort(Comparator.comparingInt(o -> initiativeOrder.get(actionBlocks.indexOf(o))));
        statBlocks.sort(Comparator.comparingInt(o -> initiativeOrder.get(statBlocks.indexOf(o))));
        gameSprites.sort(Comparator.comparingInt(o -> initiativeOrder.get(gameSprites.indexOf(o))));

        this.actionBlocks = actionBlocks.toArray(new IActionBlock[0]);
        this.statBlocks = statBlocks.toArray(new StatBlock[0]);
        this.gameSprites = gameSprites.toArray(new GameSprite[0]);
    }

    /**
     * Returns the current IAction instance, as specified by the initiative.
     */
    public IActionBlock getCurrentActionInstance() {
        return actionBlocks[turn % actionBlocks.length];
    }

    public StatBlock getCurrentStatBlockInstance() {
        return statBlocks[turn % statBlocks.length];
    }

    public GameSprite getCurrentGameSpriteInstance() {
        return gameSprites[turn % gameSprites.length];
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
        Vector2 pos = getCurrentGameSpriteInstance().getPosition();
        DungeonGame.getGame().getGameRenderer().getCamera().position.x = pos.x;
        DungeonGame.getGame().getGameRenderer().getCamera().position.y = pos.y;
    }

    public StatBlock[] getEnemies() {
        if (Arrays.stream(adventurerParty.getActionBlockMembers()).toList().contains(getCurrentActionInstance())) {
            return monsterParty.getStatBlockMembers();
        }
        return adventurerParty.getStatBlockMembers();
    }
}
