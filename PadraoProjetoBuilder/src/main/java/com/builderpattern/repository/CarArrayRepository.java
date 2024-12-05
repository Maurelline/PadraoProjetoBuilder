package com.builderpattern.repository;

import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarArrayRepository implements CarRepository {

    private static Long id;

    public CarArrayRepository() {
        id = cars.stream().count() + 1;
    }

    private final List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1L, "ABC123", "Toyota Camry", Year.of(2023), "Toyota", "Blue", "123456789", CarType.COMBUSTION_CAR, true),
            new Car(2L, "XYZ456", "Honda Accord", Year.of(2020), "Honda", "Red", "987654321", CarType.COMBUSTION_CAR, false),
            new Car(3L, "DEF789", "Ford Mustang", Year.of(2018), "Ford", "Yellow", "456789012", CarType.HYBRID, true),
            new Car(4L, "GHI012", "Chevrolet Malibu", Year.of(1999), "Chevrolet", "Silver", "789012345", CarType.COMBUSTION_CAR, false),
            new Car(5L, "JKL345", "Tesla Model S", Year.of(2000), "Tesla", "Black", "012345678", CarType.ELECTRIC_CAR, true),
            new Car(6L, "MNO678", "Volkswagen Golf", Year.of(2023), "Volkswagen", "Green", "234567890", CarType.COMBUSTION_CAR, false),
            new Car(7L, "PQR901", "Mercedes-Benz C-Class", Year.of(2010), "Mercedes-Benz", "White", "345678901", CarType.HYBRID, true),
            new Car(8L, "STU234", "Nissan Altima", Year.of(2015), "Nissan", "Gray", "456789012", CarType.COMBUSTION_CAR, false),
            new Car(9L, "VWX567", "BMW 3 Series", Year.of(2005), "BMW", "Purple", "567890123", CarType.HYBRID, true),
            new Car(10L, "YZA890", "Audi A4", Year.of(2008), "Audi", "Orange", "678901234", CarType.HYBRID, false)
    ));

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public List<Car> getAvailableCars() {
        return cars.stream()
                .filter(Car::isAvailable)
                .toList();
    }

    @Override
    public List<Car> getAvailableCars(CarType carType) {
        return cars.stream()
                .filter(car -> car.getCarType().equals(carType))
                .filter(Car::isAvailable)
                .toList();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    @Override
    public Car save(Car car) {
        setId(car);
        cars.add(car);

        return car;
    }

    private void setId(Car car) {
        car.setId(id);
        id++;
    }
}
