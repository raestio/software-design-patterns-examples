package rasto.softwaredesignpatterns.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private Map<Color, Vehicle> vehiclesCached = new HashMap<>();

    public Vehicle createVehicle(Color color) {
        Vehicle vehicle = vehiclesCached.computeIfAbsent(color, color1 -> {
            Car newVehicle = new Car();
            newVehicle.setColor(color1);
            newVehicle.setEngine(new Object());
            return newVehicle;
        });
        return vehicle;
    }
}
