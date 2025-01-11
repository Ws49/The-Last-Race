package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class Truck extends TransitVehicles {
    public Truck(TypesVehicleTransit type){
        super(type);
    }

    @Override
    public void upSize() {
            if(width < 300){
                width += 4.1f;
                height += 4.1f; 
            }   
    }

    @Override
    public void downSize() {
        if(width > 50){
            width -= 3.1f;
            height -= 3.1f;
        }

    }
}
