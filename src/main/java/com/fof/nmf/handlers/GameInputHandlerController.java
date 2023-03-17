package com.fof.nmf.handlers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Handles selecting party members
 */
public class GameInputHandlerController extends InputAdapter {

    private final Viewport port;

    public GameInputHandlerController(Viewport port) {
        this.port = port;
    }

    /**
     * Is called if any mouse button is clicked
     */
    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        Vector2 wPos = port.unproject(new Vector2(x, y));



        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        Vector2 wPos = port.unproject(new Vector2(x, y));


        return false;
    }
}
