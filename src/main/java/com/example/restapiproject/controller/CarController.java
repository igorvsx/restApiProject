package com.example.restapiproject.controller;

import com.example.restapiproject.model.CarModel;
import com.example.restapiproject.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarModel> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarModel getCarById(@PathVariable Long id) {
        return carService.getCarById(id).orElseThrow();
    }

    @PostMapping
    public CarModel createCar(@RequestBody CarModel car) {
        return carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public CarModel updateCar(@PathVariable Long id, @RequestBody CarModel car) {
        car.setId(id);
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
