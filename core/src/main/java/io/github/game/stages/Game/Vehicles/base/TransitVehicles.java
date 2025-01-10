package io.github.game.stages.Game.Vehicles.base;




import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;

public class TransitVehicles extends Vehicles implements TransitParticipant{

    private int positionInTrack = 0;
    private boolean postionValid;
    private boolean oldPositionValid;
    private boolean inScreen;


    public TransitVehicles(TypesVehicleTransit typeVehicle) {
        super(500, 100, typeVehicle.getWidth(), typeVehicle.getHeight());

        setColor(Color.WHITE);

        textureRegions = typeVehicle.getRegionTexture();
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, typeVehicle.getLineFrame(), typeVehicle.getDurationAnimation());
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        lineFrame = typeVehicle.getLineFrame();
        isOneTexutre = true;
    
        postionValid = false;
        oldPositionValid = false;
        inScreen = false;
       
        setMetersTraveled(0);
    }



    public void nextPoint(float y, float x){

        if(oldPositionValid != postionValid){
            if(y > 150){
                width = 40;
                height = 40;
                posY = y;
            }
            inScreen = true;
        }

        if(postionValid){    
            posX = x + 10;
            if(posY < y){
                posY ++;
                width -= 1.1f;
                height -= 1.1f;
            }else if(posY > y && y > 0){
                posY -- ;
                width += 1.1f;
                height += 1.1f;
            }else if(posY > 0){
                posY -- ;
                width += 1.1f;
                height += 1.1f;
            }else if(posY <= 0){
                 postionValid = false;
            }
        }

        oldPositionValid = postionValid;

        if(postionValid == false){
            inScreen = false;
        }
    }

    
    @Override
    public void update() {
        metersTraveledUp(300);
    }

    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
    }

    public boolean isInScreen() {
        return inScreen;
    }

    public void setInScreen(boolean inScreen) {
        this.inScreen = inScreen;
    }


    public void setpostionValid(boolean postionValid) {
        this.postionValid = postionValid;
    }

    public int getPositionInTrack() {
        return positionInTrack;
    }

    public void setPositionInTrack(int positionInTrack) {
        this.positionInTrack = positionInTrack;
    }

}
