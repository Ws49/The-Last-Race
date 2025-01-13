package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class SimpleCar extends TransitVehicles{
    public SimpleCar(TypesVehicleTransit type){
        super(type);
    }

    @Override
    public void updateSize(float widthRoad) {
        int w = currentTRegion.getRegionWidth();
        int h = currentTRegion.getRegionHeight();

        float newWidth = w * widthRoad / 150;
        float newHeight = h * widthRoad / 150;

        if(newHeight < startWidth){
            width = newWidth;
            height = newHeight;
        }
        
    }
}
