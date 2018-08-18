package rasto.softwaredesignpatterns.flyweight;

import java.awt.Color;
import java.util.logging.Logger;

public class Car implements Vehicle {
    private Logger logger = Logger.getLogger(Car.class.getName());

    private Object engine;
    private Color color;

    public Car(Object engine, Color color) {
        this.engine = engine;
        this.color = color;
    }

    public Car() {

    }

    @Override
    public void start() {
        logger.info("Car started");
    }

    @Override
    public void stop() {
        logger.info("Car stopped");
    }

    @Override
    public Color getColor() {
        return color;
    }

    public Object getEngine() {
        return engine;
    }

    public void setEngine(Object engine) {
        this.engine = engine;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
