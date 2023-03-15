package com.fof.nmf.sprite.frame;

import com.badlogic.gdx.math.Vector2;
import com.fof.nmf.handlers.input.IGameMouseClick;
import com.fof.nmf.engine.renderer.IGameUpdate;
import com.fof.nmf.sprite.GameSprite;
import com.fof.nmf.utils.VectorUtils;

public class GameButton extends FrameObject implements IGameMouseClick, IFrameObject, IGameUpdate {
    private final GameSprite buttonActive;
    private final GameSprite buttonDeActive;

    /**
     * How long the button is pushed down, i.e. when the status changes
     */
    private final float downTime = 1;

    private boolean status = false;

    private float time = 0;

    public GameButton(GameSprite buttonActive, GameSprite buttonDeActive, Vector2 localPosition) {
        this.buttonActive = buttonActive;
        this.buttonDeActive = buttonDeActive;
        super.gSprite = buttonDeActive;
        super.localPosition = localPosition;
    }

    @Override
    public void updateSprite(Vector2 worldPos) {
        buttonActive.setPosition(VectorUtils.add(worldPos, localPosition));
        buttonDeActive.setPosition(VectorUtils.add(worldPos, localPosition));
    }

    private boolean contains(Vector2 point) {
        return buttonActive.getBoundingRectangle().contains(point) ||
                buttonDeActive.getBoundingRectangle().contains(point);
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public void action(Vector2 screenPos, Vector2 worldPos, int pointer, int button) {
        System.out.println("you clicked");
        if (contains(worldPos)) {
            status = !status;
            System.out.println(status);
        }
        gSprite = status ? buttonActive : buttonDeActive;
    }

    @Override
    public void update(float dt) {
        if (!status) {
            return;
        }

        time += dt;
        if (time >= downTime) {
            status = false;
            gSprite = buttonDeActive;
            time = 0;
        }
    }
}
