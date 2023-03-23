package com.fof.nmf.scene.main_world.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.scene.hud.GameHud;
import com.fof.nmf.scene.main_world.MainWorldHud;
import com.fof.nmf.scene.main_world.quest_table.QuestTable;

public class MainWorldQuestHud extends GameHud {

    private final LabelStyle labelStyle = new LabelStyle(new BitmapFont(), Color.WHITE);

    private final Table quests = new Table();


    public MainWorldQuestHud(SpriteBatch spriteBatch) {
        super(spriteBatch);

        Table mainTable = new Table();
        mainTable.top();
        mainTable.setFillParent(true);
        Table header = new Table();
        Label mainLbl = new Label("Quests", labelStyle);
        header.add(mainLbl);
        mainTable.add(header).row();
        mainTable.add(quests).row();

        quests.add(new QuestTable(labelStyle).getQuestTable()).row();
        quests.add(new QuestTable(labelStyle).getQuestTable()).row();
        quests.add(new QuestTable(labelStyle).getQuestTable()).row();

        stage.addActor(mainTable);
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            QuestTable t = new QuestTable(labelStyle);
            t.changeName("Quest " + quests.getRows());
            quests.add(t.getQuestTable()).row();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            DungeonGame.getGame().getGameRenderer().setHud(new MainWorldHud(spriteBatch));
            System.out.println("Exit Quest Manager");
        }
    }
}
