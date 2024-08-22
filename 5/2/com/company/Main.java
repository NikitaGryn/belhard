package com.company;

import com.company.details.Engine;
import com.company.professions.Driver;
import com.company.vehicles.Car;
import com.company.vehicles.Lorry;
import com.company.vehicles.SportCar;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver("Петя Иванов", 25, 20);
        Engine engine = new Engine(200, "Toyota");

        Car car = new Car("Toyota", "C", 1600, driver, engine);
        Lorry lorry = new Lorry("Kamaz", "B", 8000, driver, engine, 12000);
        SportCar sportCar = new SportCar("Ferrari", "S", 1200, driver, engine, 350);

        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);

        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
