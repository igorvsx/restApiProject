package com.example.restapiproject.controller;

import com.example.restapiproject.model.MaintenanceModel;
import com.example.restapiproject.service.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public List<MaintenanceModel> getAllMaintenances() {
        return maintenanceService.getAllMaintenances();
    }

    @GetMapping("/{id}")
    public MaintenanceModel getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenanceById(id).orElseThrow();
    }

    @PostMapping
    public MaintenanceModel createMaintenance(@RequestBody MaintenanceModel maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }

    @PutMapping("/{id}")
    public MaintenanceModel updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceModel maintenance) {
        maintenance.setId(id);
        return maintenanceService.saveMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
    }
}