package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class Truck extends TransitVehicles {
    public Truck(TypesVehicleTransit type){
        super(type);
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
