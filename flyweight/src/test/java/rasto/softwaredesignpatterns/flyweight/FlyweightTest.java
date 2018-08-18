package rasto.softwaredesignpatterns.flyweight;

import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author Rastislav Zlacky (rastislav.zlacky@inventi.cz) on 18.08.2018.
 */
public class FlyweightTest {

    private static final int ITERATIONS = 1000000;

    @Test
    public void flyweightTest() {
        List<Color> colorList = Arrays.asList(Color.MAGENTA, Color.BLACK, Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.WHITE);

        long timeStart = System.nanoTime();
        createVehiclesFromFactory(colorList);
        long timeDurationFromFactory = System.nanoTime() - timeStart;

        timeStart = System.nanoTime();
        createVehiclesFromInstanceCreation(colorList);
        long timeDurationFromInstanceCreation = System.nanoTime() - timeStart;

        Logger.getLogger(FlyweightTest.class.getName()).info(timeDurationFromFactory + " < " + timeDurationFromInstanceCreation);
        Assert.assertTrue(timeDurationFromFactory < timeDurationFromInstanceCreation);
    }

    private void createVehiclesFromInstanceCreation(List<Color> colorList) {
        IntStream.range(0, ITERATIONS).forEach(value -> colorList.forEach(color -> {
                Vehicle vehicle = new Car(new Object(), color);
            }
        ));
    }

    private void createVehiclesFromFactory(List<Color> colorList) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        IntStream.range(0, ITERATIONS).forEach(value -> colorList.forEach(vehicleFactory::createVehicle));
    }
}
