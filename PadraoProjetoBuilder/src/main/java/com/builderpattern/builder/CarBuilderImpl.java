package com.builderpattern.builder;

import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;

import java.time.Year;

public class CarBuilderImpl implements CarBuilder {

    private String licensePlate;
    private String model;
    private Year releaseYear;
    private String brand;
    private String color;
    private String vin;
    private CarType carType;

    @Override
    public CarBuilder licensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    @Override
    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder releaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    @Override
    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder vin(String vin) {
        this.vin = vin;
        return this;
    }

    @Override
    public CarBuilder carType(CarType carType) {
        this.carType = carType;
        return this;
    }

    @Override
    public Car build() {
        return new Car(null, licensePlate, model, releaseYear, brand, color, vin, carType, true);
    }
}
