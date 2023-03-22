package com.fof.nmf.city;

import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.sprite.GameSprite;

/**
 * Contains information about the City
 */
public class GameCity implements IGameSprite, IGameUpdate {

    private GameSprite currentSprite;

    public GameCity(GameSprite currentSprite, Vector2 position) {
        currentSprite.setPosition(position);
        this.currentSprite = currentSprite;
    }

    @Override
    public GameSprite[] getGameSprite() {
        return new GameSprite[]{currentSprite};
    }

    @Override
    public void update(float dt) {

    }
}
