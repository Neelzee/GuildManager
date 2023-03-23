package com.fof.nmf.scene;

/**
 * All IScenes must manage the GameSprites they add to the GameRenderer,
 * and therefore remove the assets no longer in use, onExit()
 */
public interface IScene {

    /**
     * Actions to be done on a scene exit,
     * happens before setScreen()
     */
    void onExit();
}
