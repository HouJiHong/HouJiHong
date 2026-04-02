package com.HJh.test.ZuoYeTest.qiche;

public class Car {
    private String brand;
    private double displacement;
    private double fuelConsumption;
    private double speed;

    public void ignition() {
        System.out.println("点火");
    }
    public void shutOff() {
        System.out.println("熄火");
    }
    public void forward() {
        System.out.println("前进");
    }
    public void reverse() {
        System.out.println("后退");
    }
    public void honk() {
        System.out.println("鸣笛");
    }

    public Car(String brand, double displacement, double fuelConsumption, double speed) {
        this.brand = brand;
        this.displacement = displacement;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
