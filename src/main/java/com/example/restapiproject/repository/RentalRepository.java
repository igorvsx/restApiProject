package com.example.restapiproject.repository;

import com.example.restapiproject.model.RentalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalModel, Long> {
    List<RentalModel> findByUserUserId(Long userId);
}
