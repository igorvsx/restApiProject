package com.example.restapiproject.repository;

import com.example.restapiproject.model.CarModel;
import com.example.restapiproject.model.InsuranceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<InsuranceModel, Long> {
    Optional<InsuranceModel> findByCar(CarModel car);
}
