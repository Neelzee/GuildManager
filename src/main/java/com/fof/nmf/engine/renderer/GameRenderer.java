package com.fof.nmf.engine.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fof.nmf.scene.hud.IHud;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.tilemaps.TiledDungeonMapGenerator;
import com.fof.nmf.tilemaps.TiledMapGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Has the responsibility of managing all GameSprites that should be rendered, and in what order.
 * How sprite render order works, is that the last sprite that is drawn, is the sprite that is on top.
 */
public class GameRenderer implements Disposable {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;

    /**
     * Spritebatch, used for rendering
     */
    private final SpriteBatch spriteBatch;

    /**
     * ArrayList of all sprites that should be rendered
     */
    private final ArrayList<IGameSprite> gameSprites = new ArrayList<>();

    /**
     * ArrayList of all actors that has an update, happens before sprite render
     */
    private final ArrayList<IGameUpdate> gameUpdates = new ArrayList<>();

    /**
     * Current tile map
     */
    private TiledMap currentMap;

    /**
     * Map renderer
     */
    private OrthogonalTiledMapRenderer mapRenderer;

    /**
     * Camera
     */
    private OrthographicCamera camera;

    /**
     * Viewport
     */
    private final Viewport gamePort;

    /**
     * Hud
     */
    private IHud hud;

    public GameRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        this.camera = new OrthographicCamera();
        this.gamePort = new FitViewport(V_WIDTH, V_HEIGHT, this.camera);
        camera.position.set(gamePort.getWorldWidth() / 2f, gamePort.getWorldHeight() / 2f, 0);
        gamePort.setCamera(camera);
    }

    public void setCurrentMap(TiledMap currentMap) {
        this.currentMap = currentMap;
        this.mapRenderer = new OrthogonalTiledMapRenderer(currentMap, 1f);
    }

    public void setHud(IHud hud) {
        this.hud = hud;
    }

    public void render(float dt) {
        spriteBatch.setProjectionMatrix(camera.combined);
        if (mapRenderer != null) {
            mapRenderer.render();
        }
        spriteBatch.begin();
        for (IGameSprite gSprite : gameSprites) {
            for (GameSprite s : gSprite.getGameSprite()) {
                spriteBatch.draw(s, s.getPosition().x, s.getPosition().y);
            }
        }
        spriteBatch.end();

        // Since hud is drawn last, all sprites are below the hud

        if (hud == null) {
            return;
        }

        hud.getStage().act(dt);
        hud.getStage().draw();
    }

    public void update(float dt) {
        if (hud != null) {
            hud.update(dt);
        }
        camera.update();

        if (mapRenderer != null) {
            mapRenderer.setView(camera);
        }

        for (IGameUpdate actor : gameUpdates) {
            actor.update(dt);
        }
    }

    @Override
    public void dispose() {
        if (mapRenderer != null) {
            mapRenderer.dispose();
        }

        if (currentMap != null) {
            currentMap.dispose();
        }
        spriteBatch.dispose();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getGamePort() {
        return gamePort;
    }

    public void resize(int width, int height) {
        gamePort.update(width, height);
        if (hud == null) {
            return;
        }
        hud.resize(width, height);
    }

    public void addIGameUpdate(IGameUpdate updater) {
        gameUpdates.add(updater);
    }

    public void addGameSprite(IGameSprite sprite) {
        gameSprites.add(sprite);
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public void removeGameSprites(GameSprite gameSprite) {
        gameSprites.remove(gameSprite);
    }

    public void removeGameSprites(IGameSprite gameSprite) {
        gameSprites.removeAll(List.of(gameSprite.getGameSprite()));
    }

    public void removeIGameUpdate(IGameUpdate updater) {
        gameUpdates.remove(updater);
    }

    public IHud getHud() {
        return hud;
    }
}
