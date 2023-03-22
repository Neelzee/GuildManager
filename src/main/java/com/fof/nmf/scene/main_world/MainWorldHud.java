package com.fof.nmf.scene.main_world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_world.hud.MainWorldQuestHUD;

/**
 * HUD that is displayed on the main world
 */
public class MainWorldHud extends GameHud {
    public MainWorldHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        TextButton.TextButtonStyle tbStyle = new TextButton.TextButtonStyle();
        tbStyle.font = new BitmapFont();
        tbStyle.fontColor = Color.WHITE;
        TextButton questBtn = new TextButton("Quests", tbStyle);

        questBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Enter Quest Manager");
                DungeonGame.getGame().getGameRenderer().setHud(new MainWorldQuestHUD(spriteBatch));
            }
        });

        table.add(questBtn);

        stage.addActor(table);
        DungeonGame.getGame().getGameInputHandler().addInputProcess(getStage());

    }

    @Override
    public void update(float dt) {

    }
}
