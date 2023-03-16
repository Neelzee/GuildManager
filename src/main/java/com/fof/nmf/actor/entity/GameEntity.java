package com.fof.nmf.actor.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.actor.ActorState;
import com.fof.nmf.actor.GameActor;
import com.fof.nmf.sprite.GameSprite;

public class GameEntity extends GameActor {
    public GameEntity(GameSprite gSprite, TextureRegion[][] textures, float animationCycle) {
        super(gSprite, textures, animationCycle);
    }

    public GameEntity(GameSprite gSprite, Sprite selectedSprite, TextureRegion[][] textures, float animationCycle) {
        super(gSprite, selectedSprite, textures, animationCycle);
    }

    @Override
    public void animate(float dt) {
        time += dt;

        if (time >= getAnimationCycle()) {
            time = 0;
        }
        float fraction = time / getAnimationCycle();
        int index = (int) Math.floor(fraction * (getTextures()[0].length - 1));

        TextureRegion texture = getTextures()[0][0];
        switch (state) {

            case STANDING_NORTH -> texture = getTextures()[1][1];
            case STANDING_SOUTH -> texture = getTextures()[0][1];
            case STANDING_WEST -> texture = getTextures()[2][1];
            case STANDING_EAST -> texture = getTextures()[3][1];
            case WALKING_SOUTH -> texture = getTextures()[0][index];
            case WALKING_NORTH -> texture = getTextures()[1][index];
            case WALKING_WEST -> texture = getTextures()[2][index];
            case WALKING_EAST -> texture = getTextures()[3][index];
            case ATTACKING_SOUTH -> texture = getTextures()[5][index];
            case ATTACKING_NORTH -> texture = getTextures()[4][index];
            case ATTACKING_EAST -> texture = getTextures()[7][index];
            case ATTACKING_WEST -> texture = getTextures()[6][index];
        }

        gSprite.changeTexture(texture);
    }

    @Override
    public void sitStill() {
        switch (state) {
            case WALKING_SOUTH, ATTACKING_SOUTH -> state = ActorState.STANDING_SOUTH;
            case WALKING_NORTH, ATTACKING_NORTH -> state = ActorState.ATTACKING_NORTH;
            case WALKING_WEST, ATTACKING_WEST -> state = ActorState.STANDING_WEST;
            case WALKING_EAST, ATTACKING_EAST -> state = ActorState.STANDING_EAST;
        }
    }
}
