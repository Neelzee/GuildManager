package com.fof.nmf.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.tilemaps.TiledMapGenerator;


public abstract class GameScene implements Screen {

    protected final DungeonGame game;

    public GameScene(DungeonGame game) {
        this.game = game;
    }

    protected void update(float dt) {
        game.getGameRenderer().update(dt);
    }

    protected void handleInput(float dt) {}

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0, 0, 0, 1);  // Sets background color too white
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);  // Clears sprite from previous render call
        update(dt);
        game.getGameRenderer().render(dt);
    }

    @Override
    public void resize(int width, int height) {
        game.getGameRenderer().resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
