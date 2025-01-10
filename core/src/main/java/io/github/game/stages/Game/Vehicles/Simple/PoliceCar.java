package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class PoliceCar extends TransitVehicles{

    public PoliceCar(TypesVehicleTransit type){
        super(type);
        posY =80f;
    }

    @Override
    public void upSize() {
        if(width < 200){
            width += 0.8f;
            height += 0.8f;  
        }

    }

    @Override
    public void downSize() {
        if(width > 50){
            width -= 0.8f;
            height -= 0.8f; 
        }

    }
    
}
