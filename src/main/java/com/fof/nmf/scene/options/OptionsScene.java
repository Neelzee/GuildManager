package com.fof.nmf.scene.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.GameScene;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.SpritePaths;

public class OptionsScene extends GameScene {
    public OptionsScene(DungeonGame game) {
        super(game);

        GameSprite s = new GameSprite(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getSpritesPath() + "/mmb.png"
                        )
                )
        );



        game.getGameRenderer().addGameSprite(s);
        game.getGameRenderer().setHud(new OptionsHud(game.getGameRenderer().getSpriteBatch()));
    }
}
