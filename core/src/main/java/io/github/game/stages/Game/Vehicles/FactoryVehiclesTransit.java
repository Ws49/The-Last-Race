package io.github.game.stages.Game.Vehicles;

import io.github.game.stages.Game.Vehicles.Simple.JeepCar;
import io.github.game.stages.Game.Vehicles.Simple.PoliceCar;
import io.github.game.stages.Game.Vehicles.Simple.SimpleCar;
import io.github.game.stages.Game.Vehicles.Simple.Truck;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;
//FACTORY
public final class FactoryVehiclesTransit {
    public static TransitVehicles getVehicle(TypesVehicleTransit type){
        switch (type) {
            case TRUCK:
                return new Truck(TypesVehicleTransit.TRUCK);
            case TRUCK2:
                return new Truck(TypesVehicleTransit.TRUCK2);
            case TRUCK3:
                return new Truck(TypesVehicleTransit.TRUCK3);
            case POLICE:
                return new PoliceCar(TypesVehicleTransit.POLICE);
            case JEEP:
                return new JeepCar(TypesVehicleTransit.JEEP);
            case  CAR_PINK:
                return new SimpleCar(TypesVehicleTransit.CAR_PINK);
            case  CAR_GREEN:
                return new SimpleCar(TypesVehicleTransit.CAR_GREEN);
            default:
                return new Truck(TypesVehicleTransit.TRUCK);

                
        }
    }
}
