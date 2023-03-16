package com.fof.nmf.handlers.input;

import com.badlogic.gdx.math.Vector2;

public interface IGameInput {
    
    boolean keyDown(int i);

    
    boolean keyUp(int i);

    
    boolean keyTyped(char c);

    
    boolean touchDown(int x, int y, int pointer, int button);

    
    boolean touchUp(int x, int y, int pointer, int button);

    
    boolean touchDragged(int i, int i1, int i2);

    
    boolean mouseMoved(int i, int i1);

    
    boolean scrolled(float v, float v1);
}
