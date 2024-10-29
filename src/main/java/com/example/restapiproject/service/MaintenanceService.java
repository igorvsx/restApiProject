package com.example.restapiproject.service;

import com.example.restapiproject.model.MaintenanceModel;
import com.example.restapiproject.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<MaintenanceModel> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public Optional<MaintenanceModel> getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id);
    }

    public MaintenanceModel saveMaintenance(MaintenanceModel maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public void deleteMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }
}
