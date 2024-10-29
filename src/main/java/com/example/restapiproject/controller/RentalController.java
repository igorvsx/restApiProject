package com.example.restapiproject.controller;

import com.example.restapiproject.model.RentalModel;
import com.example.restapiproject.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<RentalModel> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public RentalModel getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id).orElseThrow();
    }

    @PostMapping
    public RentalModel createRental(@RequestBody RentalModel rental) {
        return rentalService.saveRental(rental);
    }

    @PutMapping("/{id}")
    public RentalModel updateRental(@PathVariable Long id, @RequestBody RentalModel rental) {
        rental.setId(id);
        return rentalService.saveRental(rental);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }

    @GetMapping("/without-feedback/user/{userId}")
    public List<RentalModel> getRentalsWithoutFeedback(@PathVariable Long userId) {
        return rentalService.getRentalsWithoutFeedback(userId);
    }
}