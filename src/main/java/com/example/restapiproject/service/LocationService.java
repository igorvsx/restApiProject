package com.example.restapiproject.service;

import com.example.restapiproject.model.LocationModel;
import com.example.restapiproject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationModel> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<LocationModel> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    public LocationModel saveLocation(LocationModel location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
