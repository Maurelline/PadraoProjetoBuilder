package com.builderpattern.repository;

import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    List<Car> findAll();
    List<Car> getAvailableCars();

    List<Car> getAvailableCars(CarType carType);

    Optional<Car> getCarById(Long id);

    Car save(Car car);
}
