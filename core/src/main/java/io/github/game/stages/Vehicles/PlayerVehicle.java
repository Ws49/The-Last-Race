package io.github.game.stages.Vehicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class PlayerVehicle  extends Vehicles{
    private int playerX;

    public PlayerVehicle(){
        super(400, 100,150,150);
        setColor(Color.WHITE);
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car",new Vector2(87,60));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, 0.01f);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
    }

    public int getPlayerX() {
        return playerX;
    }
    public void updatePLayerX(int playerX) {
        this.playerX += playerX;
    }
    public void brake(){
        if(speed > 200){
            speed -= 200;
        }
    }

    public void update(){
        super.update();
          if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            speedUp(200);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(getSpeed() > 0){
               brake();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(playerX > -3200){
                updatePLayerX(-200);
            }
           
   
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(playerX < 3200){
                updatePLayerX(200);
            }

        }
    }
}
