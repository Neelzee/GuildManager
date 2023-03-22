package com.fof.nmf.scene.main_world.quest_table;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Used to display sprites
 */
public class QuestTable {

    private final Label questNameLbl;

    private final Label questRewardLbl;

    private final Table questTable;

    public QuestTable(LabelStyle labelStyle) {
        questNameLbl = new Label(
                "Quest321",
                labelStyle
        );

        questRewardLbl = new Label(
                "100",
                labelStyle
        );

        questTable = new Table();
        questTable.setFillParent(true);
        questTable.add(questNameLbl).row();
        questTable.add(questRewardLbl).row();
    }

    public void changeName(String name) {
        questNameLbl.setText(name);
    }

    public void changeReward(int cost) {
        questRewardLbl.setText(cost);
    }

    public Table getQuestTable() {
        return questTable;
    }
}
