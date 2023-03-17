package com.fof.nmf.scene.main_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.handlers.GameInputHandlerCamera;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.tilemaps.TiledMapGenerator;

public class MainWorldScene extends GameScene {


    private GameInputHandlerCamera cameraHandler;

    public MainWorldScene(DungeonGame game) {
        super(game);

        cameraHandler = new GameInputHandlerCamera(game.getGameRenderer().getCamera(), .75f);

        if (MainWorld.getMap() == null) {
            // Tiled map
            Texture tileTextures = new Texture(
                    Gdx.files.internal("src/main/resources/sprites/Ground/Grass.png")
            );

            TextureRegion[][] splitTiles = TextureRegion.split(tileTextures, 16, 16);
            TiledMap currentMap = TiledMapGenerator.generateWorldMap(
                    splitTiles,
                    64, 64,
                    16, 16
            );
            MainWorld.setMap(currentMap);
            game.getGameRenderer().setCurrentMap(currentMap);
        }

        game.getGameInputHandler().addInputProcess(cameraHandler);
        game.getGameRenderer().setHud(null);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        int speed = 100;
        if (cameraHandler.isMoveEast()) {
            game.getGameRenderer().getCamera().position.x += speed * dt;
        }

        if (cameraHandler.isMoveWest()) {
            game.getGameRenderer().getCamera().position.x -= speed * dt;
        }

        if (cameraHandler.isMoveNorth()) {
            game.getGameRenderer().getCamera().position.y += speed * dt;
        }

        if (cameraHandler.isMoveSouth()) {
            game.getGameRenderer().getCamera().position.y -= speed * dt;
        }
    }

    @Override
    public void onExit() {

    }
}
