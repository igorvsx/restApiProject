package com.example.restapiproject.controller;

import com.example.restapiproject.model.LocationModel;
import com.example.restapiproject.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationModel> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationModel getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id).orElseThrow();
    }

    @PostMapping
    public LocationModel createLocation(@RequestBody LocationModel location) {
        return locationService.saveLocation(location);
    }

    @PutMapping("/{id}")
    public LocationModel updateLocation(@PathVariable Long id, @RequestBody LocationModel location) {
        location.setId(id);
        return locationService.saveLocation(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}