package io.github.game.stages.Game.Vehicles.Simple;

import java.util.Random;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class PoliceCar extends TransitVehicles {

    public PoliceCar(TypesVehicleTransit type) {
        super(type);
        posY = 80f;
            setMetersTraveled(new Random().nextInt(0,100000));
        speed = new Random().nextInt(70, 400);
    }
    @Override
    public void updateSize(float widthRoad) {
        int w = currentTRegion.getRegionWidth();
        int h = currentTRegion.getRegionHeight();

        float newWidth = w * widthRoad / 100;
        float newHeight = h * widthRoad / 100;

        if(newHeight < startWidth ){
            width = newWidth;
            height = newHeight;
        }
        
    }

}
