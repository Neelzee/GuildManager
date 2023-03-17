package com.fof.nmf.scene.main_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.fof.nmf.guild.GameCurrency;
import com.fof.nmf.guild.GameGuild;
import com.fof.nmf.scene.hud.GameHud;

/**
 * Main World HUD
 */
public class MainWorldHud extends GameHud {

    private Label moneyLabel;

    public MainWorldHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        // The table at the top of the screen
        Table infoDisplay = new Table();
        infoDisplay.setFillParent(true);
        infoDisplay.top();

        moneyLabel = new Label("Gold Pieces: " + GameGuild.getGuildMoneyGp(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        infoDisplay.add(moneyLabel).expandX();


        stage.addActor(infoDisplay);
    }

    @Override
    public void update(float dt) {
        moneyLabel.setText("Gold Pieces: " + GameGuild.getGuildMoneyGp());

        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            GameGuild.buy(10, GameCurrency.GOLD);
        }
    }
}
