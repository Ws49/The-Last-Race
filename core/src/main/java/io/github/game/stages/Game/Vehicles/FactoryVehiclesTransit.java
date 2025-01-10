package io.github.game.stages.Game.Vehicles;

import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;
//FACTORY
public final class FactoryVehiclesTransit {
    public static TransitVehicles getVehicle(TypesVehicleTransit type){
        switch (type) {
            case TRUCK:
                return new TransitVehicles(TypesVehicleTransit.TRUCK);
            case TRUCK2:
                return new TransitVehicles(TypesVehicleTransit.TRUCK2);
            case POLICE:
                return new TransitVehicles(TypesVehicleTransit.POLICE);
            case JEEP:
                return new TransitVehicles(TypesVehicleTransit.JEEP);
            case SHELBY:
                return new TransitVehicles(TypesVehicleTransit.SHELBY);
            default:
                return new TransitVehicles(TypesVehicleTransit.TRUCK);

                
        }
    }
}
