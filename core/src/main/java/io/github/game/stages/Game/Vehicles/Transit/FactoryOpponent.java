package io.github.game.stages.Game.Vehicles.Transit;

import io.github.game.stages.Game.Vehicles.base.Vehicles;

public class FactoryOpponent {
    public static Vehicles getOponnent(TypesVehicleTransit type, int maxSpeed){
        switch (type) {
            case FERRARI:
                return new Opponent(type,maxSpeed);
        
            default:
                return new Opponent(type,maxSpeed); 
        }
    }
}
