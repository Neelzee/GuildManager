package com.fof.nmf.city;

import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.app.DungeonGame;
import com.fof.nmf.engine.renderer.IGameSprite;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.handlers.input.IGameMouseClick;
import com.fof.nmf.scene.main_world.MainWorldHud;
import com.fof.nmf.scene.main_world.hud.MainWorldGuildHud;
import com.fof.nmf.sprite.GameSprite;

/**
 * Contains information about the City
 */
public class GameCity implements IGameSprite, IGameUpdate, IGameMouseClick {

    private GameSprite currentSprite;

    private final String cityName;

    private boolean hasGuild = false;

    public GameCity(GameSprite currentSprite, Vector2 position, String cityName) {
        this.cityName = cityName;
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

    @Override
    public void action(Vector2 screenPos, Vector2 worldPos, int pointer, int button) {
        if (!hasGuild) {
            return;
        }

        if (currentSprite.getBoundingRectangle().contains(worldPos)) {
            if (DungeonGame.getGame().getGameRenderer().getHud() instanceof MainWorldHud) {
                DungeonGame.getGame().getGameRenderer().setHud(
                        new MainWorldGuildHud(
                                DungeonGame.getGame().getGameRenderer().getSpriteBatch(),
                                this
                        )
                );
            }
        }
    }

    public void setHasGuild(boolean hasGuild) {
        this.hasGuild = hasGuild;
    }

    public String getCityName() {
        return cityName;
    }
}
