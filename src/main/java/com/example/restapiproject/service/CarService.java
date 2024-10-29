package com.example.restapiproject.service;

import com.example.restapiproject.model.CarModel;
import com.example.restapiproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<CarModel> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public CarModel saveCar(CarModel car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
