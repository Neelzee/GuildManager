package com.fof.nmf.city;

import com.fof.nmf.city.states.GameCityNoGuild;
import com.fof.nmf.city.states.GameCityGuild;
import com.fof.nmf.state.GameStateManager;

public class GameCityStateManager extends GameStateManager {

    public final GameCityGuild gameCityGuild = new GameCityGuild();

    public GameCityStateManager() {
        currentState = new GameCityNoGuild();
    }
}
