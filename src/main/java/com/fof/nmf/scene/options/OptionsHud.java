package com.fof.nmf.scene.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_menu.MainMenuHud;
import com.fof.nmf.scene.main_menu.MainMenuScene;

public class OptionsHud extends GameHud {
    public OptionsHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table menu = new Table();
        TextButton.TextButtonStyle tbStyle = new TextButton.TextButtonStyle();
        tbStyle.font = new BitmapFont();
        tbStyle.fontColor = Color.WHITE;
        TextButton music = new TextButton("Music", tbStyle);
        TextButton sound = new TextButton("Sound", tbStyle);
        TextButton resolution = new TextButton("Resolution", tbStyle);
        TextButton back = new TextButton("Back", tbStyle);

        music.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        sound.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        resolution.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                DungeonGame.getGame().setScreen(new MainMenuScene(DungeonGame.getGame()));
            }
        });

        menu.add(music).row();
        menu.add(sound).row();
        menu.add(resolution).row();
        menu.add(back).row();

        menu.center();
        menu.setFillParent(true);
        stage.addActor(menu);


        DungeonGame.getGame().getGameInputHandler().addInputProcess(stage);
    }

    @Override
    public void update(float dt) {

    }
}
