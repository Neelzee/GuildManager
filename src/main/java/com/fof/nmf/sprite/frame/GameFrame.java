package com.fof.nmf.sprite.frame;

import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.VectorUtils;

import java.util.ArrayList;

public class GameFrame {
    private GameSprite background;

    private final ArrayList<FrameObject> children = new ArrayList<>();

    private Vector2 worldPosition;

    public GameFrame(GameSprite background, Vector2 worldPosition) {
        this.background = background;
        this.worldPosition = worldPosition;
        this.background.setPosition(worldPosition.x, worldPosition.y);
    }


    public void addChild(FrameObject child) {
        child.updateSprite(worldPosition);
        children.add(child);
    }

    public GameSprite[] getGameSprites() {
        ArrayList<GameSprite> sprites = new ArrayList<>();
        sprites.add(background);

        for (FrameObject frameObject : children) {
            sprites.add(frameObject.getGameSprite());
        }


        return sprites.toArray(new GameSprite[0]);
    }
}
