package com.fof.nmf.scene.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fof.nmf.engine.renderer.GameRenderer;

public abstract class GameHud implements IHud{

    protected final Stage stage;

    protected final Viewport viewport;

    protected final SpriteBatch spriteBatch;

    public GameHud(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        viewport = new FitViewport(GameRenderer.V_WIDTH, GameRenderer.V_HEIGHT);
        this.stage = new Stage(viewport);
    }


    @Override
    public Stage getStage() {
        return stage;
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
