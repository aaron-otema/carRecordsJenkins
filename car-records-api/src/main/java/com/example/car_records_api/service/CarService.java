package com.example.car_records_api.service;

import com.example.car_records_api.model.Car;

import java.util.UUID;

public interface CarService {
    Car createCar(Car car);
    Car getCarById(UUID id);
    Car deleteCarById(UUID id);

}
