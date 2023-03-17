package com.fof.nmf.scene.main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class MainMenuScene extends GameScene {

    private GameSprite backgroundSprite;

    public MainMenuScene(DungeonGame game) {
        super(game);

        backgroundSprite = new GameSprite(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getSpritesPath() + "/mmb.png"
                        )
                )
        );



        game.getGameRenderer().addGameSprite(backgroundSprite);
        game.getGameRenderer().setHud(new MainMenuHud(game.getGameRenderer().getSpriteBatch()));
    }

    @Override
    public void onExit() {
        game.getGameRenderer().removeGameSprites(backgroundSprite);
    }
}
