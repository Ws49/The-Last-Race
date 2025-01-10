package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class SimpleCar extends TransitVehicles{
    public SimpleCar(TypesVehicleTransit type){
        super(type);
    }

    @Override
    public void upSize() {
        if(width < 250){
            width += 0.7f;
            height += 0.7f;  
        }

    }

    @Override
    public void downSize() {
        if(width > 50){
            width -= 0.7f;
            height -= 0.7f;
        }

    }
}
