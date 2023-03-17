package com.fof.nmf.scene.hud;

import com.badlogic.gdx.scenes.scene2d.Stage;

public interface IHud {
    Stage getStage();

    /**
     * Hud updates
     * @param dt delta time
     */
    void update(float dt);

    void resize(int width, int height);
}
