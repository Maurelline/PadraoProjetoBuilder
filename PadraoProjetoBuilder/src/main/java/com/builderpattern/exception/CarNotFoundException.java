package com.builderpattern.exception;

public class CarNotFoundException extends EntityNotFoundException{
    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Long carId) {
        this("carro com id %d não existe".formatted(carId));
    }
}
