package com.fof.nmf.scene.main_world.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.guild.GameCurrency;
import com.fof.nmf.guild.GameGuild;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_world.MainWorldHud;
import com.fof.nmf.utils.SpritePaths;

public class MainWorldEconomyHud extends GameHud {

    private LabelStyle labelStyle = new LabelStyle(new BitmapFont(), Color.WHITE);

    private final String goldPieceAffix = "Gold Pieces";

    private final Label goldPiecesLbl = new Label("0 " + goldPieceAffix, labelStyle);


    public MainWorldEconomyHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table hud = new Table();

        hud.setFillParent(true);
        hud.top().left();
        Table moneyTbl = new Table();

        Image img = new Image(
                new Texture(
                        Gdx.files.internal(
                                SpritePaths.getSpritesPath() + "/mmb.png"
                        )
                )
        );

        moneyTbl.add(img).width(16).height(16).left();
        moneyTbl.add(goldPiecesLbl).left();
        hud.add(moneyTbl);
        stage.addActor(hud);
    }

    @Override
    public void update(float dt) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            System.out.println("Adding money");
            GameGuild.addMoney(100, GameCurrency.GOLD);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            System.out.println("Changing hud");
            DungeonGame.getGame().getGameRenderer().setHud(new MainWorldHud(spriteBatch));
        }

        goldPiecesLbl.setText(GameGuild.getGuildMoneyGp() + " " + goldPieceAffix);
    }
}
