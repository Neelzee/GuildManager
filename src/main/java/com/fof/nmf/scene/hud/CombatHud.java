package com.fof.nmf.scene.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fof.nmf.engine.renderer.GameRenderer;
import com.fof.nmf.utils.SpritePaths;

public class CombatHud implements IHud {
    private final Stage stage;

    private final Viewport viewport;

    private Label test;

    private Button button;

    public CombatHud(SpriteBatch sb) {
        viewport = new FitViewport(GameRenderer.V_WIDTH, GameRenderer.V_HEIGHT);
        stage = new Stage(viewport, sb);

        Table table = new Table();

        // Puts everything in the table at the bottom of the viewport
        table.bottom();

        // Is the size of the stage?
        table.setFillParent(true);
        test = new Label("TEST TEXT", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.fontColor = Color.WHITE;
        button = new TextButton("Click ME", textButtonStyle);

        button.add(test);

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Thomas e BIG BRAIN!");
            }
        });


        table.add(test).expandX();
        table.add(button).expandX();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void onExit() {
        stage.dispose();
    }
}
