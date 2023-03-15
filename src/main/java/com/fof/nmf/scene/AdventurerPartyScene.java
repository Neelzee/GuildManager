package com.fof.nmf.scene;

import com.fof.nmf.actor.StatBlock;
import com.fof.nmf.actor.adventurer.Adventurer;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.StatBlockHud;

public class AdventurerPartyScene extends GameScene {

    private StatBlock block;

    public AdventurerPartyScene(DungeonGame game) {
        super(game);

        block = new Adventurer();

        StatBlockHud hud = new StatBlockHud(game.getGameRenderer().getSpriteBatch(), block);
        game.getGameRenderer().setHud(hud);
    }

    @Override
    protected void handleInput(float dt) {

    }
}
