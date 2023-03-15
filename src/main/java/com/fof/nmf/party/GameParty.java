package com.fof.nmf.party;

import com.fof.nmf.actor.GameActor;
import com.fof.nmf.actor.IActionBlock;
import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.sprite.GameSprite;

import java.util.ArrayList;

public class GameParty implements IGameUpdate, IGameSprite {
    private StatBlock[] statBlockMembers;

    private IActionBlock[] actionBlockMembers;

    private GameActor[] memberSprites;

    @Override
    public void update(float dt) {
        for (GameActor member : memberSprites) {
            member.update();
            member.animate(dt);
        }
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
        return statBlockMembers;
    }

    public IActionBlock[] getActionBlockMembers() {
        return actionBlockMembers;
    }
}
