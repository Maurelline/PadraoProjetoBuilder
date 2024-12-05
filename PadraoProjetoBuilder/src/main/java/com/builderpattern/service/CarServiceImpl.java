package com.builderpattern.service;

import com.builderpattern.exception.BusinessException;
import com.builderpattern.exception.CarNotFoundException;
import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;
import com.builderpattern.repository.CarRepository;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailableCars() {
        return carRepository.getAvailableCars();
    }

    @Override
    public List<Car> getAvailableCars(CarType carType) {
        return carRepository.getAvailableCars(carType);
    }

    @Override
    public Car getById(Long carId) {
        return carRepository.getCarById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));
    }

    @Override
    public Car insert(Car car) {
        validateCar(car);

        return carRepository.save(car);
    }

    private void validateCar(Car car) {
        if (car.getLicensePlate() == null) {
            throw new BusinessException("License plate is required");
        }

        if (car.getModel() == null) {
            throw new BusinessException("Model is required");
        }

        if (car.getCarType() == null) {
            throw new BusinessException("Car type is required");
        }
    }

    @Override
    public Car activate(Long carId) {
        Car car = getById(carId);

        if (car.isAvailable()) {
            throw new BusinessException("Carro com id %d já esta ativado".formatted(carId));
        }

        car.setAvailable(true);

        return car;
    }

    @Override
    public Car deactivate(Long carId) {
        Car car = getById(carId);

        if (!car.isAvailable()) {
            throw new BusinessException("Carro com id %d já esta desativado".formatted(carId));
        }

        car.setAvailable(false);

        return car;
    }
}
