package com.builderpattern.model;

import java.time.Year;
import java.util.Objects;

public class Car {

    private Long id;
    private String licensePlate;
    private String model;
    private Year releaseYear;
    private String brand;
    private String color;
    private String vin;
    private CarType carType;
    private boolean isAvailable;

    public Car(Long id, String licensePlate, String model, Year releaseYear, String brand, String color,
               String vin, CarType carType, boolean isAvailable) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.releaseYear = releaseYear;
        this.brand = brand;
        this.color = color;
        this.vin = vin;
        this.carType = carType;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", releaseYear=" + releaseYear +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", carType=" + carType +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
