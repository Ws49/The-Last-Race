package io.github.game.stages.Game.Vehicles.Simple;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class JeepCar extends TransitVehicles {
    public JeepCar(TypesVehicleTransit type) {
        super(type);
        posY = 80f;
    }

    @Override
    public void upSize() {
        if (width < 250) {
            width += 1.1f;
            height += 1.1f;
        }

    }

    @Override
    public void downSize() {
       
            if (width > 50) {
                width -=2.1f;
                height -= 2.1f;
            }
        

    }
}
