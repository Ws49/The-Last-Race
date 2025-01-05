package io.github.game.stages.Game.Vehicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class TruckVehicle extends Vehicles {
    boolean updateside;
    public TruckVehicle() {
        super(500, 100, 250, 250);
        setColor(Color.WHITE);
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Truck", new Vector2(64, 64));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 2, 100f);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        updateside = false;
    }

    public void update(int speedPlayer) {
        super.update();
        speedUp(100);

        if (getSpeed() - speedPlayer > 0) {
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                if(!updateside){
                    posX = posX + 1.5f;
                }
                updateside = true;

            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            
                    posX -= 1.7f;
                
    
            }
            if (width > 20) {
                posY += 0.9;
                width -= 1.1;
            }

            if (height > 20) {
                height -= 1.1;
            }

            if (posY > 280) {
                posY = 290;
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
                width = 250;
                height = 250;
                setColor(VisibleVehicle.INVISIBLE.getColor());
            } else {
                setColor(Color.WHITE);
            }
        }


        


    }
}
