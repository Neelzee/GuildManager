package com.fof.nmf.party;

import com.fof.nmf.actor.GameActor;
import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.actor.adventurer.Adventurer;
import com.fof.nmf.actor.entity.GameEntity;
import com.fof.nmf.actor.monster.Monster;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.sprite.GameSprite;

import java.util.ArrayList;
import java.util.Arrays;

public class GameParty implements IGameUpdate, IGameSprite {
    private final ArrayList<StatBlock> statBlockMembers = new ArrayList<>();

    private final ArrayList<IActionBlock> actionBlockMembers = new ArrayList<>();

    private final ArrayList<GameEntity> memberSprites = new ArrayList<>();

    @Override
    public void update(float dt) {

        for (int i = 0; i < statBlockMembers.size(); i++) {
            if (statBlockMembers.get(i).isDead()) {
                statBlockMembers.remove(i);
                actionBlockMembers.remove(i);
                DungeonGame.getGame().getGameRenderer().removeGameSprites(memberSprites.get(i).getGSprite());
                memberSprites.remove(i);
                i--;
            }
        }

        for (GameActor member : memberSprites) {
            member.update();
            member.animate(dt);
        }
    }

    public GameParty(Monster[] monsters, GameEntity[] actors) {
        statBlockMembers.addAll(Arrays.stream(monsters).toList());
        actionBlockMembers.addAll(Arrays.stream(monsters).toList());
        memberSprites.addAll(Arrays.stream(actors).toList());
    }

    public GameParty(Adventurer[] adventurers, GameEntity[] actors) {
        statBlockMembers.addAll(Arrays.stream(adventurers).toList());
        actionBlockMembers.addAll(Arrays.stream(adventurers).toList());
        memberSprites.addAll(Arrays.stream(actors).toList());
    }

    @Override
    public GameSprite[] getGameSprite() {
        ArrayList<GameSprite> sprites = new ArrayList<>();
        for (GameActor member : memberSprites) {
            sprites.add(member.getGSprite());
        }

        return sprites.toArray(new GameSprite[0]);
    }

    public StatBlock[] getStatBlockMembers() {
        return statBlockMembers.toArray(new StatBlock[0]);
    }

    public IActionBlock[] getActionBlockMembers() {
        return actionBlockMembers.toArray(new IActionBlock[0]);
    }
}
