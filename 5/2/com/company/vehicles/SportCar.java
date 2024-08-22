package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class SportCar extends Car {
    private double maxSpeed;

    public SportCar(String brand, String carClass, double weight, Driver driver, Engine engine, double maxSpeed) {
        super(brand, carClass, weight, driver, engine);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "brand='" + super.toString() + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
