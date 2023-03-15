package com.fof.nmf.engine.renderer;

/**
 * Things that should be updated every frame
 */
public interface IGameUpdate {

    /**
     * Update call
     * @param dt delta time
     */
    void update(float dt);
}
