package com.fof.nmf.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.engine.renderer.IGameSprite;

public class GameSprite extends Sprite implements IGameSprite {
    public GameSprite(TextureRegion texture) {
        super(texture);
    }

    public GameSprite(Texture texture) {
        super(texture);
    }

    public void changeTexture(TextureRegion texture)
    {
        super.setTexture(texture.getTexture());
    }

    /**
     * Sets position relative to the bottom left corner of the sprite
     */
    public void setPosition(Vector2 position) {
         setPosition(position.x, position.y);
    }

    /**
     * Sets position relative to the center of the sprite
     */
    public void setPositionCenter(Vector2 position) {
        setPosition(new Vector2(position.x + super.getWidth() / 2, position.y + super.getHeight() / 2));
    }

    public Vector2 getPosition() {
        return new Vector2(getX(), getY());
    }

    @Override
    public GameSprite[] getGameSprite() {
        return new GameSprite[]{this};
    }
}
