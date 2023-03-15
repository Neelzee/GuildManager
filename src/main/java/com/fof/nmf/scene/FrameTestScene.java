package com.fof.nmf.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.utils.SpritePaths;
import com.fof.nmf.handlers.GameInputHandler;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.sprite.frame.GameButton;
import com.fof.nmf.sprite.frame.GameFrame;

public class FrameTestScene extends GameScene {

    private GameFrame frame;

    private GameButton button;
    public FrameTestScene(DungeonGame game) {
        super(game);

        GameSprite background = new GameSprite(
                new Sprite(
                        new Texture(
                                Gdx.files.internal(
                                        SpritePaths.getSpritesPath() + "/User Interface/background/Background.png"
                                )
                        )
                )
        );

        button = new GameButton(
                new GameSprite(
                        new Sprite(
                                new Texture(
                                        Gdx.files.internal(
                                                SpritePaths.getSpritesPath() + "/User Interface/background/Button Active.png"
                                        )
                                )
                        )
                ),
                new GameSprite(
                        new Sprite(
                                new Texture(
                                        Gdx.files.internal(
                                                SpritePaths.getSpritesPath() + "/User Interface/background/button_deactive.png"
                                        )
                                )
                        )
                ),
                new Vector2()
        );

        button.setLocalPositionCenter(new Vector2(background.getWidth() / 2, background.getHeight() / 2));

        InputMultiplexer multiplexer = new InputMultiplexer();
        GameInputHandler inputHandler = new GameInputHandler(game.getGameRenderer().getGamePort());
        inputHandler.addClicker(button);
        multiplexer.addProcessor(inputHandler);
        Gdx.input.setInputProcessor(multiplexer);
        frame = new GameFrame(background, new Vector2(100, 100));
        frame.addChild(button);
    }

    @Override
    public void handleInput(float dt) {

    }
}
