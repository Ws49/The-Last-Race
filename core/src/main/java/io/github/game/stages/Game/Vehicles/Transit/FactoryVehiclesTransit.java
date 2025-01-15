package io.github.game.stages.Game.Vehicles.Transit;

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
