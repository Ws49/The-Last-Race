package io.github.game.stages.Game.Vehicles.Transit;

import java.util.Random;

class Opponent extends TransitVehicles {

    public Opponent(TypesVehicleTransit type,int maxSpeed) {
        super(type);
        posY = 80f;
        setMetersTraveled(1000);
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
