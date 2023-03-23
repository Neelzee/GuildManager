package com.fof.nmf.state;


import com.fof.nmf.state.states.GameState;

public abstract class GameStateManager {

    protected GameState currentState;

    /**
     * Changes the current state to the given state
     */
    public void changeState(GameState state) {
        currentState.exitState();
        currentState = state;
        currentState.enterState();
    }

    /**
     * Updates the current state
     */
    public void updateState() {
        currentState.updateState(this);
    }
}
