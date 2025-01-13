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
    private boolean isCollision;
    private float valueCurve;

    public PlayerVehicle() {
        super(370, 0, 300, 200);
        setColor(Color.WHITE);
        durationAnimation = 0f;
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, durationAnimation);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        accelerate = 0;
        hitBox.setHeight(height);
        verifySpeed = false;
        isCollision = false;
        isOneTexutre = true;
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


    public void speedUp(){
        columnFrame = 0;
        if (accelerate < 600) {
            accelerate += 1;
            metersTraveledUp(accelerate);
        } else {
            accelerate = 600;
            metersTraveledUp(accelerate);
        }
        if(accelerate < 0){
            accelerate += 5;
            metersTraveledUp(accelerate);
        }
    }

    public void speedDown(){
        if (accelerate > 0) {
            accelerate -= 2;
            metersTraveledUp(accelerate);
        }
        if(accelerate < 0){
            accelerate += 5;
            metersTraveledUp(accelerate);
        }

    }
    
    // verifica se o x do player esta na grama e reduz velocidade
    public void speedDownOffRoad(){
        
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
    }
    

    public void moveToBack(){
        if(accelerate > -300){
            accelerate -= 30;
        }else{
            accelerate = 0;
        }
        metersTraveledUp(accelerate);
    }

    public void updateMovimentInCurve(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if(playerX < 3200 && playerX > -3200){
                if(valueCurve > 0){
                    updatePLayerX(-30);
                }else if(valueCurve < 0){
                    updatePLayerX(30);
                }
            }
        }
    }
    
    public void updateTexture(){
        if(isOneTexutre){
            switch (columnFrame) {
                case 0:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41));
                    break;

                case 1:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(71, 41));
                    break;

                case 2:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(74, 41));
                    break;
            
                default:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41));
                    break;
            }
        }
    }

    @Override
    public void update(){
        
        super.update();

        updateMovimentInCurve();
        updateTexture();

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            speedUp();
            speedDownOffRoad();
        } else {
            columnFrame = 0;
            speedDown();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (getMetersTraveled() > 0) {
                brake();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            
                updatePLayerX(-200);
            
            columnFrame = 1;

        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
         
                updatePLayerX(200);
            
            columnFrame = 2;

        }

        if(isCollision == true){
            moveToBack();
        }

    }

    public void setValueCurve(float valueCurve) {
        this.valueCurve = valueCurve;
    }

    public boolean isCollision() {
        return isCollision;
    }

    public void setCollision(boolean isCollision) {
        this.isCollision = isCollision;
    }

    public int getAccelerate() {
        return (int)((accelerate) * 0.55f);
    }

}
