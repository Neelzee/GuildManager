package com.fof.nmf.actor;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.sprite.GameSprite;

public abstract class GameActor {
    protected GameSprite gSprite;

    private Sprite selectedSprite;

    private boolean isSelected;

    protected Vector2 position;

    private TextureRegion[][] textures;

    protected ActorState state;

    private final float animationCycle;

    protected float time = 0;

    public GameActor(GameSprite gSprite, TextureRegion[][] textures, float animationCycle) {
        this.gSprite = gSprite;
        this.textures = textures;
        this.animationCycle = animationCycle;
        state = ActorState.STANDING_SOUTH;
        position = new Vector2();
        isSelected = false;
    }

    public GameActor(GameSprite gSprite, Sprite selectedSprite, TextureRegion[][] textures, float animationCycle) {
        this.gSprite = gSprite;
        this.selectedSprite = selectedSprite;
        this.textures = textures;
        this.animationCycle = animationCycle;
        state = ActorState.STANDING_SOUTH;
        position = new Vector2();
    }

    public void changeState(ActorState state) {
        if (this.state.equals(state)) {
            return;
        }
        this.state = state;
    }

    public abstract void animate(float dt);

    public abstract void sitStill();

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
     * Ensures the sprite is at the correct position
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

    public Sprite getSelectedSprite() {
        return selectedSprite;
    }

    public void setSelectedSprite(Sprite selectedSprite) {
        this.selectedSprite = selectedSprite;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
