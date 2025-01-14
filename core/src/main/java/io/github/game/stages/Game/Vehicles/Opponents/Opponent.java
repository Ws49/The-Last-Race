package io.github.game.stages.Game.Vehicles.Opponents;

import java.util.Random;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class Opponent extends TransitVehicles {

    public Opponent(TypesVehicleTransit type,int maxSpeed) {
        super(type);
        posY = 80f;
        setMetersTraveled(100);
        speed = new Random().nextInt(100, maxSpeed);
    }

    @Override
    public void updateSize(float widthRoad) {
        int w = currentTRegion.getRegionWidth();
        int h = currentTRegion.getRegionHeight();

        float newWidth = w * widthRoad / 100;
        float newHeight = h * widthRoad / 100;

        if(newHeight < startWidth + 100){
            width = newWidth;
            height = newHeight;
        }
        
    }
    
}
