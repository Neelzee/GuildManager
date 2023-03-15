package com.fof.nmf.handlers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameInputHandlerCamera extends InputAdapter {

    private final OrthographicCamera camera;

    private final float zoomFactor;

    private boolean moveNorth;
    private boolean moveSouth;
    private boolean moveEast;
    private boolean moveWest;

    public GameInputHandlerCamera(OrthographicCamera camera, float zoomFactor) {
        this.camera = camera;
        this.zoomFactor = zoomFactor;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            moveWest = true;
        }

        if (keycode == Input.Keys.D) {
            moveEast = true;
        }

        if (keycode == Input.Keys.W) {
            moveNorth = true;
        }

        if (keycode == Input.Keys.S) {
            moveSouth = true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            moveWest = false;
        }

        if (keycode == Input.Keys.D) {
            moveEast = false;
        }

        if (keycode == Input.Keys.W) {
            moveNorth = false;
        }

        if (keycode == Input.Keys.S) {
            moveSouth = false;
        }

        return false;
    }

    @Override
    public boolean scrolled (float amountX, float amountY) {

        camera.zoom += amountY * zoomFactor;

        return false;
    }

    public boolean isMoveNorth() {
        return moveNorth;
    }

    public boolean isMoveSouth() {
        return moveSouth;
    }

    public boolean isMoveEast() {
        return moveEast;
    }

    public boolean isMoveWest() {
        return moveWest;
    }
}
