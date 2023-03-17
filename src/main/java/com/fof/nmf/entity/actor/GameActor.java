package com.fof.nmf.entity.actor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.sprite.GameSprite;

/**
 * All moving Actors in the Game, inherit from GameActor.
 * GameActors manages animation
 */
public class GameActor {

    /**
     * The GameSprite instance
     */
    protected GameSprite gSprite;

    /**
     * The GameWorld position of this Actor
     */
    protected Vector2 position;

    /**
     * Sprite Texture Region
     */
    protected final TextureRegion[][] textures;

    /**
     * ActorState, i.e. what animation it should use
     */
    protected ActorState state;

    /**
     * Duration of animation cycle, in seconds
     */
    protected final float animationCycle;

    /**
     * Current duration of animation cycle, in seconds
     */
    protected float time = 0;

    public GameActor(GameSprite gSprite, TextureRegion[][] textures, float animationCycle) {
        this.gSprite = gSprite;
        this.textures = textures;
        this.animationCycle = animationCycle;
        state = ActorState.STANDING_SOUTH;
        position = new Vector2();
    }

    /**
     * Changes the ActorState of this instance,
     * which is used by setting what animation state this Actor is in
     */
    public void changeState(ActorState state) {
        if (this.state.equals(state)) {
            return;
        }
        this.state = state;
    }

    /**
     * Animates the sprite, by changing the sprite.
     * A sprite change occurs every texture-region[ActorState.value].length / animationCycle seconds
     */
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

    public TextureRegion[][] getTextures() {
        return textures;
    }

    public float getAnimationCycle() {
        return animationCycle;
    }

    public GameSprite getGSprite() {
        return gSprite;
    }

    /**
     * Ensures the sprite is at the correct position,
     * by setting the sprites position to this Instances position
     */
    public void update() {
        gSprite.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void addX(float dx) {
        position.x += dx;
    }

    public void addY(float dy) {
        position.y += dy;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
