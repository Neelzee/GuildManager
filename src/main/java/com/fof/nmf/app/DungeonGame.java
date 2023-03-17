package com.fof.nmf.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fof.nmf.engine.input.GameInputHandler;
import com.fof.nmf.engine.renderer.GameRenderer;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.scene.main_menu.MainMenuScene;

public class DungeonGame extends Game {

    private static DungeonGame game;

    private GameRenderer gameRenderer;

    private GameInputHandler gameInputHandler;

    private GameScene scene;

    @Override
    public void create() {
        game = this;
        gameRenderer = new GameRenderer(new SpriteBatch());
        gameInputHandler = new GameInputHandler();
        setScreen(new MainMenuScene(this));
        Gdx.input.setInputProcessor(gameInputHandler.getMultiplexer());
    }

    /**
     * Changes the scene
     * @param scene
     */
    @Override
    public void setScreen(Screen scene) {
        if (this.scene != null) {
            this.scene.onExit();
        }
        if (scene instanceof GameScene) {
            this.scene = (GameScene) scene;
        }
        super.setScreen(scene);
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
