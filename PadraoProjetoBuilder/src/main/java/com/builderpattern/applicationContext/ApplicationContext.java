package com.builderpattern.applicationContext;

import com.builderpattern.repository.CarArrayRepository;
import com.builderpattern.repository.CarRepository;
import com.builderpattern.service.CarService;
import com.builderpattern.service.CarServiceImpl;

public class ApplicationContext {

    private CarRepository carRepository;
    private CarService carService;

    public ApplicationContext() {
        carRepository = new CarArrayRepository();
        carService = new CarServiceImpl(carRepository);
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
