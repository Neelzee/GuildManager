package com.fof.nmf.scene.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class OptionsScene extends GameScene {

    private GameSprite background;

    public OptionsScene(DungeonGame game) {
        super(game);

        background = new GameSprite(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getSpritesPath() + "/mmb.png"
                        )
                )
        );



        game.getGameRenderer().addGameSprite(background);
        game.getGameRenderer().setHud(new OptionsHud(game.getGameRenderer().getSpriteBatch()));
    }

    @Override
    public void onExit() {
        game.getGameRenderer().removeGameSprites(background);
    }
}
