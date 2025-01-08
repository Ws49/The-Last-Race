package io.github.game.stages.Game.Vehicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public class PlayerVehicle  extends Vehicles{
    private int playerX;
    private int accelerate;
    private float durationAnimation;
    public PlayerVehicle(){
        super(400, 0,150,150);
        setColor(Color.WHITE);
        durationAnimation  = 0.01f;
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car",new Vector2(87,60));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, durationAnimation);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        accelerate = 0;
    }

    public int getPlayerX() {
        return playerX;
    }
    public void updatePLayerX(int playerX) {
        this.playerX += playerX;
    }
    public void brake(){
        if(accelerate > 0){
            accelerate -= 2;
            speedUp(accelerate);
         }
    }

    public void update(){

        super.update();
          if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(accelerate < 300){
                accelerate += 1;
                speedUp(accelerate);
            }else{
                accelerate = 300;
                speedUp(accelerate);
            }
        }else{
            if(accelerate > 0){
               accelerate -= 2;
               speedUp(accelerate);
            }
           
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
