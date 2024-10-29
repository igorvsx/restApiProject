package com.example.restapiproject.service;

import com.example.restapiproject.model.InsuranceModel;
import com.example.restapiproject.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<InsuranceModel> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Optional<InsuranceModel> getInsuranceById(Long id) {
        return insuranceRepository.findById(id);
    }

    public InsuranceModel saveInsurance(InsuranceModel insurance) {
        return insuranceRepository.save(insurance);
    }

    public void deleteInsurance(Long id) {
        insuranceRepository.deleteById(id);
    }
}
