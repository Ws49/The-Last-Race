package io.github.game.stages.Game.Vehicles.base;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class PlayerVehicle extends Vehicles {
    private int playerX;
    private int accelerate;
    private float durationAnimation;
    private boolean verifySpeed;
    private boolean isCollision;
    private float valueCurve;
    private Texture velocimeter;
    private BitmapFont fontSpeed;
    private BitmapFont fontPosition;
    private int position;

    public PlayerVehicle() {
        super(370, 0, 300, 200);
        setColor(Color.WHITE);
        durationAnimation = 0f;
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, durationAnimation);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        fontSpeed = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 24);
        fontPosition = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 84);
        velocimeter = AssetsControl.getInstanceAssetsControl().getTexture("velocimeterUI");
        accelerate = 0;
        hitBox.setWidth(width / 2);
        position = 0;
        verifySpeed = false;
        isCollision = false;
        isOneTexutre = true;

    }


    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(velocimeter, 730, -50, 350, 350);
        fontSpeed.setColor(Color.CYAN);
        fontPosition.setColor(Color.BLUE);
        fontSpeed.draw(batch,  String.valueOf(getAccelerate()), 860, 130);
        fontPosition.draw(batch, String.valueOf(position),800, 650);
        fontSpeed.draw(batch,  "ST", 900, 600);
    }

    private void speedUp() {
        columnFrame = 0;
        if (accelerate < 600) {
            accelerate += 1;
            metersTraveledUp(accelerate);
        } else {
            accelerate = 600;
            metersTraveledUp(accelerate);
        }
        if (accelerate < 0) {
            accelerate += 5;
            metersTraveledUp(accelerate);
        }
    }
    

    private void speedDown() {
        if (accelerate > 0) {
            accelerate -= 2;
            metersTraveledUp(accelerate);
        }
        if (accelerate < 0) {
            accelerate += 5;
            metersTraveledUp(accelerate);
        }
    }


    // verifica se o x do player esta na grama e reduz velocidade
    private void speedDownOffRoad() {

        if (accelerate >= 150 && accelerate <= 600) {
            verifySpeed = true;
        } else {
            verifySpeed = false;
        }

        if (playerX <= -5400 && accelerate > 0 && verifySpeed) {
            accelerate -= 3;

        }
        if (playerX >= 5400 && accelerate > 0 && verifySpeed) {
            accelerate -= 3;
        }
    }

    private void moveToBack() {
        if(getMetersTraveled() / 200 > 0){
            if (accelerate > -300) {
                accelerate -= 30;
            } else {
                accelerate = 0;
            }
            metersTraveledUp(accelerate);
        }
        
    }

    private void brake() {
        if (accelerate > 0) {
            accelerate -= 2;
            metersTraveledUp(accelerate);
        }
    }
    
    private void updatePLayerX(int playerX) {
        this.playerX += playerX;

    }

    private void updateMovimentInCurve() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (playerX < 5600 && playerX > -5600) {
                if (valueCurve > 0) {
                    updatePLayerX(-70);
                } else if (valueCurve < 0) {
                    updatePLayerX(70);
                }
            }
        }
    }

    private void updateTexture() {
        if (isOneTexutre) {
            switch (columnFrame) {
                case 0:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati",
                            new Vector2(70, 41));
                    break;

                case 1:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati",
                            new Vector2(71, 41));
                    break;

                case 2:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati",
                            new Vector2(74, 41));
                    break;

                default:
                    textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati",
                            new Vector2(70, 41));
                    break;
            }
        }
    }

    public void updatePosition(ArrayList<Float> metersTraveledOpponents){
        int positionAux = metersTraveledOpponents.size();
        for (Float metersOpponent : metersTraveledOpponents) {
            if(getMetersTraveled() - metersOpponent > 0){
                positionAux--;
            }else{
                positionAux++;
            }
        }
    
        position = (positionAux + 2)/ 2;
       
    }
    
    @Override
    public void update() {

        hitBox.x = posX + (width / 4);
        hitBox.y = posY + 54;

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

            if (playerX >= -5600) {
                updatePLayerX(-200);
            }

            columnFrame = 1;

        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            if (playerX <= 5600) {
                updatePLayerX(200);
            }

            columnFrame = 2;

        }

        if (isCollision == true) {
            moveToBack();
        }
    }

    public int getPlayerX() {
        return playerX;
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
        return (int) ((accelerate) * 0.25f);
    }

}
