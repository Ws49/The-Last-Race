package io.github.game.stages.Game.Vehicles.base;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;

public abstract class TransitVehicles extends Vehicles implements TransitParticipant {

    private boolean postionValid;
    private boolean inScreen;
    private boolean wasSurpassed;
    private boolean rightRoad;
    protected float startWidth;
    protected float startHeight;
    protected int speed;

    public abstract void updateSize(float widthRoad);

    public TransitVehicles(TypesVehicleTransit typeVehicle) {
        super(0, 100, typeVehicle.getWidth(), typeVehicle.getHeight());

        setColor(Color.WHITE);

        textureRegions = typeVehicle.getRegionTexture();
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, typeVehicle.getLineFrame(),typeVehicle.getDurationAnimation());
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        lineFrame = typeVehicle.getLineFrame();
        isOneTexutre = true;

        postionValid = false;
        inScreen = false;

        wasSurpassed = false;
        rightRoad = new Random().nextBoolean();

        if (rightRoad) {
            posX = 450;
        } else {
            posX = 50;
        }

        startHeight = height;
        startWidth = width;
    }

    // recebe a coordenada x e y da pista

    public void nextPoint(float coordX, float coordY, float withRoad) {
        goPoint(coordX, coordY, withRoad);
        updateSize(withRoad);

    }

    private void goPoint(float coordX, float coordY,float widthRoad) {

        if (coordY < 290 ) {
            // verifica se ta proximo

            if (coordY > -100) { 
                if(rightRoad && coordX > 0 && postionValid){
                    inScreen = true;
                    postionValid = true;
                }else if(!rightRoad && coordX < -400){
                    inScreen = true;
                    postionValid = true;
                }
            }else{
                postionValid = false;
                inScreen = false;
            }

            if (postionValid) {
   
                    if (rightRoad) {  
                            posX  = coordX - ((widthRoad / 280) / (coordX / 280)) * 300;
                
                          
         
                            // posX = coordX - (((coordY - 280) * 15 + 20));
                         } else {
                            // posX = coordX + 30;
                 
                          posX = coordX + ((coordY / 280) * 10 + 30);
                    }
            
                if (posY < coordY) {
                    wasSurpassed = false;
                    posY = coordY;
                } else if (posY > coordY) {
                    wasSurpassed = true;
                    posY--;
                }else if(coordY < 0){
                    posY -= 24;
                }

            }

        } else if (coordY > 680 && !wasSurpassed) {
            if (posY <= 280) {
                posY++;
            }
        }

    }

    @Override
    public void update() {
        hitBox.x = posX;
        hitBox.y = posY;
        if (!inScreen) {
            hitBox.setY(-1000);
            hitBox.setX(-1000);
        }

        metersTraveledUp(speed);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
    @Override
    public boolean isInScreen() {
        return inScreen;
    }

    public boolean isRightRoad() {
        return rightRoad;
    }

    public void setInScreen(boolean inScreen) {
        this.inScreen = inScreen;
    }

    public void setpostionValid(boolean postionValid) {
        this.postionValid = postionValid;
    }

    @Override
    public Rectangle getColision() {
        return hitBox;
    }

}
