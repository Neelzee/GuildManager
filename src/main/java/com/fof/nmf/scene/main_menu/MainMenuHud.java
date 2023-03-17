package com.fof.nmf.scene.main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.AdventurerPartyScene;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.options.OptionsHud;
import com.fof.nmf.scene.options.OptionsScene;

public class MainMenuHud extends GameHud {
    public MainMenuHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table menu = new Table();
        TextButtonStyle tbStyle = new TextButtonStyle();
        tbStyle.font = new BitmapFont();
        tbStyle.fontColor = Color.WHITE;
        TextButton start = new TextButton("Start", tbStyle);
        TextButton options = new TextButton("Options", tbStyle);
        TextButton exit = new TextButton("Exit", tbStyle);

        start.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Start");
                DungeonGame.getGame().setScreen(new AdventurerPartyScene(DungeonGame.getGame()));
            }
        });

        options.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Options");
                DungeonGame.getGame().setScreen(new OptionsScene(DungeonGame.getGame()));
            }
        });

        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        menu.add(start).row();
        menu.add(options).row();
        menu.add(exit).row();

        menu.center();
        menu.setFillParent(true);
        stage.addActor(menu);


        DungeonGame.getGame().getGameInputHandler().addInputProcess(stage);
    }


    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void update(float dt) {

    }
}
