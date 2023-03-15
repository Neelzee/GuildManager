package com.fof.nmf.sprite.frame;

import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.VectorUtils;

public abstract class FrameObject {

    /**
     * Local position relative to the GameFrame
     */
    protected Vector2 localPosition;

    /**
     * Active Sprite
     */
    protected GameSprite gSprite;

    public Vector2 getLocalPosition() {
        return localPosition;
    }

    public void setLocalPosition(Vector2 localPosition) {
        this.localPosition = localPosition;
    }

    public void updateSprite(Vector2 worldPosition) {
        gSprite.setPosition(VectorUtils.add(worldPosition, localPosition));
    }

    public void setLocalPositionCenter(Vector2 localPosition) {
        this.localPosition = new Vector2(localPosition.x - gSprite.getWidth() / 2, localPosition.y - gSprite.getHeight() / 2);
    }

    public GameSprite getGameSprite() {
        return gSprite;
    }
}
