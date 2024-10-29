package com.example.restapiproject.service;

import com.example.restapiproject.model.RentalModel;
import com.example.restapiproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final FeedbackService feedbackService;
    @Autowired
    public RentalService(RentalRepository rentalRepository, FeedbackService feedbackService) {
        this.rentalRepository = rentalRepository;
        this.feedbackService = feedbackService;
    }

    public List<RentalModel> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<RentalModel> getRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    public RentalModel saveRental(RentalModel rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

    public List<RentalModel> getRentalsWithoutFeedback(Long userId) {
        return rentalRepository.findByUserUserId(userId)
                .stream()
                .filter(rental -> !feedbackService.existsByRentalId(rental.getId()))
                .collect(Collectors.toList());
    }
}
