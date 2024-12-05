package com.builderpattern.builder;

import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;

import java.time.Year;

public interface CarBuilder {
    CarBuilder licensePlate(String licensePlate);
    CarBuilder model(String model);
    CarBuilder releaseYear(Year releaseYear);
    CarBuilder brand(String brand);
    CarBuilder color(String color);
    CarBuilder vin(String vin);
    CarBuilder carType(CarType carType);
    Car build();
}
