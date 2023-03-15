package com.fof.nmf.scene.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.fof.nmf.actor.StatBlock;

public class StatBlockHud extends GameHud {

    private final Label hp;

    private final TextButton actionButton;

    private final TextButton bonusActionButton;

    private final TextButton moveButton;

    private final BitmapFont font = new BitmapFont();

    private final StatBlock block;

    public StatBlockHud(SpriteBatch sb, StatBlock block) {
        super(sb);
        this.block = block;
        this.hp = new Label(
                MathUtils.floor(block.getCurrentHp()) + "/" + block.getMaxHp(),
                new LabelStyle(
                        font,
                        Color.WHITE
                )
        );

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.fontColor = Color.WHITE;

        actionButton = new TextButton(
                "Action",
                textButtonStyle
        );

        actionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("ACTION!");
            }
        });

        bonusActionButton = new TextButton(
                "Bonus Action",
                textButtonStyle
        );

        bonusActionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("BONUS ACTION!");
            }
        });

        moveButton = new TextButton(
                "Move",
                textButtonStyle
        );

        moveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("MOVE!");
            }
        });

        int padding = 5;

        Table hp = new Table();
        hp.add(this.hp).padLeft(padding);

        Table buttons = new Table();
        buttons.add(actionButton).padRight(padding).padLeft(padding).expandX();
        buttons.add(bonusActionButton).padRight(padding).padLeft(padding).expandX();
        buttons.add(moveButton).padRight(padding).padLeft(padding).expandX();

        Table table = new Table();
        table.setFillParent(true);
        table.bottom().left();
        table.add(hp).align(Align.left).row();
        table.add(buttons).row();

        stage.addActor(table);
    }

    @Override
    public void update(float dt) {
        hp.setText(MathUtils.floor(block.getCurrentHp()) + "/" + block.getMaxHp());
    }
}
