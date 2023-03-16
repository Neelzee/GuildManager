package com.fof.nmf.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fof.nmf.engine.input.GameInputHandler;
import com.fof.nmf.engine.renderer.GameRenderer;
import com.fof.nmf.scene.AdventurerPartyScene;

public class DungeonGame extends Game {

    private static DungeonGame game;

    private GameRenderer gameRenderer;

    private GameInputHandler gameInputHandler;

    @Override
    public void create() {
        game = this;
        gameRenderer = new GameRenderer(new SpriteBatch());
        gameInputHandler = new GameInputHandler();
        setScreen(new AdventurerPartyScene(this));
        Gdx.input.setInputProcessor(gameInputHandler.getMultiplexer());
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

    public GameInputHandler getGameInputHandler() {
        return gameInputHandler;
    }

    public static DungeonGame getGame() {
        return game;
    }
}
