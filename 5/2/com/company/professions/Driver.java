package com.company.professions;

public class Driver extends Person {
    private int drivingExperience;

    public Driver(String fullName, int age, int drivingExperience) {
        super(fullName, age);
        this.drivingExperience = drivingExperience;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "fullName='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", drivingExperience=" + drivingExperience +
                '}';
    }
}
