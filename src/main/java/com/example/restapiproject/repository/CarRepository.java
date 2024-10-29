package com.example.restapiproject.repository;

import com.example.restapiproject.model.CarModel;
import com.example.restapiproject.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {
}
