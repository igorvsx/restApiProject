package com.example.restapiproject.service;

import com.example.restapiproject.model.FeedbackModel;
import com.example.restapiproject.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<FeedbackModel> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public List<FeedbackModel> getAllWithRental() { return feedbackRepository.findAllWithRental();}

    public Optional<FeedbackModel> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public FeedbackModel saveFeedback(FeedbackModel feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public boolean existsByRentalId(Long rentalId) {
        return feedbackRepository.existsByRentalId(rentalId);
    }

}
