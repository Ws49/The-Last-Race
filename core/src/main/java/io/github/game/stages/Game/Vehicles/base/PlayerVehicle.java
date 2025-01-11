package io.github.game.stages.Game.Vehicles.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class PlayerVehicle extends Vehicles {
    private int playerX;
    private int accelerate;
    private float durationAnimation;
    private boolean verifySpeed;

    public PlayerVehicle() {
        super(400, 0, 150, 150);
        setColor(Color.WHITE);
        durationAnimation = 0.01f;
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car", new Vector2(87, 60));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, durationAnimation);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        accelerate = 0;
        verifySpeed = false;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void updatePLayerX(int playerX) {
        this.playerX += playerX;

    }

    public void brake() {
        if (accelerate > 0) {
            accelerate -= 2;
            metersTraveledUp(accelerate);
        }
    }

    @Override
    public void update() {
        // verifica se o x do player esta na grama e reduz velocidade
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (accelerate < 600) {
                accelerate += 1;
                metersTraveledUp(accelerate);
            } else {
                accelerate = 600;
                metersTraveledUp(accelerate);
            }

            if(accelerate >= 150 && accelerate <= 600){
                verifySpeed = true;
            }else{
                verifySpeed = false;
            }

            if (playerX <= -2600 && playerX >= -3200 && accelerate > 0 && verifySpeed) {
                accelerate -= 3;

            }
            if (playerX >= 2600 && playerX <= 3200 && accelerate > 0 && verifySpeed) {
                accelerate -= 3;
            }

        } else {
            if (accelerate > 0) {
                accelerate -= 2;
                metersTraveledUp(accelerate);
            }

        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (getMetersTraveled() > 0) {
                brake();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (playerX > -3200) {
                updatePLayerX(-200);
            }

        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (playerX < 3200) {
                updatePLayerX(200);
            }

        }

    }

    public int getAccelerate() {
        return (int)((accelerate) * 0.55f);
    }

}
