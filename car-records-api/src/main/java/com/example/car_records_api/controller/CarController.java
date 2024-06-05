package com.example.car_records_api.controller;

import com.example.car_records_api.model.Car;
import com.example.car_records_api.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    public final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable UUID id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable UUID id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok("Account deleted");

    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Car> updateCar(@PathVariable UUID id, @RequestBody Car car) {
        String make = car.getMake();
        String model = car.getModel();
        return ResponseEntity.ok(car);

    }

}
