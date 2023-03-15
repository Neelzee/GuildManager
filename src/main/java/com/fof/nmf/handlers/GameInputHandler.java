package com.fof.nmf.handlers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fof.nmf.handlers.input.IGameMouseClick;

import java.util.ArrayList;

public class GameInputHandler implements InputProcessor {

    private final Viewport port;

    private final ArrayList<IGameMouseClick> mouseClickers = new ArrayList<>();

    public GameInputHandler(Viewport port) {
        this.port = port;
    }

    public void addClicker(IGameMouseClick clicker) {
        mouseClickers.add(clicker);
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {

        Vector2 screenPos = new Vector2(x, y);
        Vector2 worldPos = port.unproject(screenPos);

        for (IGameMouseClick action : mouseClickers) {
            action.action(screenPos, worldPos, pointer, button);
        }

        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
