package com.fof.nmf.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fof.nmf.engine.renderer.GameRenderer;
import com.fof.nmf.scene.AdventurerPartyScene;

public class DungeonGame extends Game {

    private GameRenderer gameRenderer;

    @Override
    public void create() {
        gameRenderer = new GameRenderer(new SpriteBatch());
        setScreen(new AdventurerPartyScene(this));
    }

    @Override
    public void render()
    {
        super.render();
    }

    @Override
    public void dispose() {
        gameRenderer.dispose();
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }


}
