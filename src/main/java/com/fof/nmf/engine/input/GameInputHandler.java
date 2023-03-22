package com.fof.nmf.engine.input;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.handlers.input.IGameInput;
import com.fof.nmf.handlers.input.IGameMouseClick;

import java.util.ArrayList;

public class GameInputHandler implements InputProcessor {

    private ArrayList<IGameInput> handlers = new ArrayList<>();
    private ArrayList<IGameMouseClick> clickers = new ArrayList<>();

    private InputMultiplexer multiplexer = new InputMultiplexer();

    private final Viewport viewport = DungeonGame.getGame().getGameRenderer().getGamePort();

    public GameInputHandler() {
        multiplexer.addProcessor(this);
    }

    public void addInputProcess(InputProcessor processor) {
        multiplexer.addProcessor(processor);
    }

    public void addInputHandler(IGameInput handler) {
        handlers.add(handler);
    }

    public void addInputHandler(IGameMouseClick clicker) {
        clickers.add(clicker);
    }

    public InputMultiplexer getMultiplexer() {
        return multiplexer;
    }

    @Override
    public boolean keyDown(int i) {
        for (IGameInput handler: handlers) {
            handler.keyDown(i);
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        for (IGameInput handler: handlers) {
            handler.keyUp(i);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        for (IGameInput handler: handlers) {
            handler.keyTyped(c);
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 screenPos = new Vector2(screenX, screenY);

        Vector2 worldPos = viewport.unproject(screenPos);

        for (IGameInput handler: handlers) {
            handler.touchDown(screenX, screenY, pointer, button);
        }
        for (IGameMouseClick gm : clickers) {
            gm.action(screenPos, worldPos, pointer, button);
        }
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        for (IGameInput handler: handlers) {
            handler.touchUp(i, i1, i2, i3);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        for (IGameInput handler: handlers) {
            handler.touchDragged(i, i1, i2);
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        for (IGameInput handler: handlers) {
            handler.mouseMoved(i, i1);
        }
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        for (IGameInput handler: handlers) {
            handler.scrolled(v, v1);
        }
        return false;
    }
}
