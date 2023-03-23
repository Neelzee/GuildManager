package com.fof.nmf.scene.main_world.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.city.GameCity;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_world.MainWorldHud;

public class MainWorldGuildHud extends GameHud {

    private Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    private GameCity city;

    private final Label cityNameLbl = new Label("", labelStyle);

    public MainWorldGuildHud(SpriteBatch spriteBatch, GameCity city) {
        super(spriteBatch);

        Table t = new Table();
        t.setFillParent(true);
        t.top();
        t.add(cityNameLbl);
        stage.addActor(t);
        this.city = city;
        cityNameLbl.setText(city.getCityName());
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            DungeonGame.getGame().getGameRenderer().setHud(new MainWorldHud(spriteBatch));
        }
    }
}
