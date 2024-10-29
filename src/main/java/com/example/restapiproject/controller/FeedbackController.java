package com.example.restapiproject.controller;

import com.example.restapiproject.model.FeedbackModel;
import com.example.restapiproject.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<FeedbackModel> getAllFeedbacks() {
        return feedbackService.getAllWithRental();
    }

    @GetMapping("/{id}")
    public FeedbackModel getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id).orElseThrow();
    }

    @PostMapping
    public FeedbackModel createFeedback(@RequestBody FeedbackModel feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @PutMapping("/{id}")
    public FeedbackModel updateFeedback(@PathVariable Long id, @RequestBody FeedbackModel feedback) {
        feedback.setId(id);
        return feedbackService.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
