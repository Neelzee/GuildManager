package com.fof.nmf.scene.options;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_menu.MainMenuScene;

public class OptionsHud extends GameHud {
    public OptionsHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table menu = new Table();
        TextButton.TextButtonStyle tbStyle = new TextButton.TextButtonStyle();
        tbStyle.font = new BitmapFont();
        tbStyle.fontColor = Color.WHITE;
        TextButton musicBtn = new TextButton("Music", tbStyle);
        TextButton soundBtn = new TextButton("Sound", tbStyle);
        TextButton resolutionBtn = new TextButton("Resolution", tbStyle);
        TextButton backBtn = new TextButton("Back", tbStyle);

        musicBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        soundBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        resolutionBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                DungeonGame.getGame().setScreen(new MainMenuScene(DungeonGame.getGame()));
            }
        });

        menu.add(musicBtn).row();
        menu.add(soundBtn).row();
        menu.add(resolutionBtn).row();
        menu.add(backBtn).row();

        menu.center();
        menu.setFillParent(true);
        stage.addActor(menu);


        DungeonGame.getGame().getGameInputHandler().addInputProcess(stage);
    }

    @Override
    public void update(float dt) {

    }
}
