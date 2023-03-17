package com.fof.nmf.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.MainMenuHud;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class MainMenuScene extends GameScene {
    public MainMenuScene(DungeonGame game) {
        super(game);

        GameSprite s = new GameSprite(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getSpritesPath() + "/mmb.png"
                        )
                )
        );



        game.getGameRenderer().addGameSprite(s);
        game.getGameRenderer().setHud(new MainMenuHud(game.getGameRenderer().getSpriteBatch()));
    }
}
