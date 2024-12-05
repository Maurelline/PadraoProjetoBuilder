package com.builderpattern.service;

import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    List<Car> getAvailableCars();

    List<Car> getAvailableCars(CarType carType);

    Car getById(Long carId);

    Car insert(Car car);

    Car activate(Long carId);

    Car deactivate(Long carId);
}
