package com.example.restapiproject.repository;

import com.example.restapiproject.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel, Long> {
}
