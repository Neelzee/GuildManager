package com.fof.nmf.scene.main_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.city.GameCity;
import com.fof.nmf.handlers.GameInputHandlerCamera;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.tilemaps.TiledMapGenerator;
import com.fof.nmf.utils.SpritePaths;

import java.util.ArrayList;

public class MainWorldScene extends GameScene {


    private GameInputHandlerCamera cameraHandler;

    private final ArrayList<GameCity> cities = new ArrayList<>();

    private int i = 0;

    public MainWorldScene(DungeonGame game) {
        super(game);

        // Standard scene creation
        {
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
            game.getGameRenderer().setHud(new MainWorldHud(game.getGameRenderer().getSpriteBatch()));
        }

        // Places cities
        {

            Texture cityTexture = new Texture(
                    Gdx.files.internal(
                            SpritePaths.getSpritesPath() + "/buildings/cyan/cyan_barracks.png"
                    )
            );

            TextureRegion[][] citySprites = TextureRegion.split(cityTexture, 16, 16);

            for (int i = 0; i < 5; i++) {
                GameCity c = new GameCity(
                        new GameSprite(citySprites[0][0]),
                        new Vector2(MathUtils.random(16, 16*64 - 16), MathUtils.random(16, 16*64 - 16)),
                        Integer.toString(MathUtils.random(0, 10)));
                System.out.println(c.getGameSprite()[0].getPosition());
                cities.add(c);
                c.setHasGuild(true);
                game.getGameRenderer().addGameSprite(c);
                game.getGameInputHandler().addInputHandler(c);
            }


            game.getGameRenderer().getCamera().position.x = cities.get(0).getGameSprite()[0].getX();
            game.getGameRenderer().getCamera().position.y = cities.get(0).getGameSprite()[0].getY();
        }
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            i++;

            if (i == cities.size()) {
                i = 0;
            }

            game.getGameRenderer().getCamera().position.x = cities.get(i).getGameSprite()[0].getX();
            game.getGameRenderer().getCamera().position.y = cities.get(i).getGameSprite()[0].getY();
        }

        for (GameCity c : cities) {
           c.update(dt);
        }
    }

    @Override
    public void onExit() {
        for (GameCity c : cities) {
            game.getGameRenderer().removeGameSprites(c);
        }
    }
}
