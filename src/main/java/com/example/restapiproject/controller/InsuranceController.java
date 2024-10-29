package com.example.restapiproject.controller;

import com.example.restapiproject.model.InsuranceModel;
import com.example.restapiproject.service.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public List<InsuranceModel> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/{id}")
    public InsuranceModel getInsuranceById(@PathVariable Long id) {
        return insuranceService.getInsuranceById(id).orElseThrow();
    }

    @PostMapping
    public InsuranceModel createInsurance(@RequestBody InsuranceModel insurance) {
        return insuranceService.saveInsurance(insurance);
    }

    @PutMapping("/{id}")
    public InsuranceModel updateInsurance(@PathVariable Long id, @RequestBody InsuranceModel insurance) {
        insurance.setId(id);
        return insuranceService.saveInsurance(insurance);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
    }
}