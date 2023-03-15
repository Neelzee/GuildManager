package com.fof.nmf.handlers.input;

import com.badlogic.gdx.math.Vector2;

public interface IGameMouseClick {

    void action(Vector2 screenPos, Vector2 worldPos, int pointer, int button);
}
