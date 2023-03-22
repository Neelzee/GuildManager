package com.fof.nmf.state.states;

import com.fof.nmf.state.GameStateManager;

public abstract class GameState {

    /**
     * Called once this state starts
     */
    public abstract void enterState();

    /**
     * Called on every update call
     */
    public abstract void updateState(GameStateManager context);

    /**
     * Called once this state ends
     */
    public abstract void exitState();
}
