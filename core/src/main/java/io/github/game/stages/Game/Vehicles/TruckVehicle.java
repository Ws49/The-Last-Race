package io.github.game.stages.Game.Vehicles;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class TruckVehicle extends Vehicles implements ListenerCurve{

    int modeDirection;


    public TruckVehicle() {
        super(500, 100, 250, 250);
        setColor(Color.WHITE);
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Truck", new Vector2(64, 64));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 2, 100f);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        modeDirection =0;
    
    }

    private void updatePosY(int speedPlayer){
        
        if (getSpeed() - speedPlayer > 0) {
            if (width > 20) {
                posY += 0.9;
                width -= 1.1;
            }
            if (height > 20) {
                height -= 1.1;
            }
            if (posY > 280) {
                posY = 290;
                posX = 500;
                setColor(VisibleVehicle.INVISIBLE.getColor());
            } else {
                setColor(Color.WHITE);
            }

        } else {
            posY -= 0.9;
            width += 1.1;
            height += 1.1;

            if (posY < 100) {
                posY = 100;
                posX = 500;
                width = 250;
                height = 250;
                setColor(VisibleVehicle.INVISIBLE.getColor());
            } else {
                setColor(Color.WHITE);
            }
        }
    }

    private void straightWay(int speedPlayer, int playerX){
       updatePosY(speedPlayer);
    }
    
    private void leftWay(int speedPlayer){
        updatePosY(speedPlayer);
        if (getSpeed() - speedPlayer > 0) {
            if(posX > 450){
                posX -= 0.9;
            }else if(posX > 280){
                posX -= 0.9;
            }
        } else {
            if(posX < 312){
                posX += 2.9;
            }else if(posX < 550){
                posX += 1.1;
            }
        }

        if (posY < 100) {
            posX = 490;
        } else if (posY > 280) {
            posX = 280;
        } 
        System.out.println(posX);
    }

    public void update(int speedPlayer, int playerX) {
        super.update();
        speedUp(100);
        switch (modeDirection) {
            case 0:
               straightWay(speedPlayer,playerX);
                break;
            case -1:
                leftWay(speedPlayer);
                break;
        
            default:
                break;

        }

        if(playerX != -3200 && playerX != 3200){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                posX+=10f;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                posX-=10f;
            }
        }

    }

    @Override
    public void setCurve(float curve) {
        if(curve == 0f){
            modeDirection =0;
        }else if(curve == -0.5f){
            modeDirection =-1;
        }else if(curve == 0.5f){
            modeDirection =1;
        }
    }
}
