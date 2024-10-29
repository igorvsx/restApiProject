package com.example.restapiproject.repository;

import com.example.restapiproject.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {
//    @Query("SELECT f FROM FeedbackModel f WHERE f.rental.user.userId = :userId")
//    List<FeedbackModel> findByRentalUserId(Long userId);

    @Query("SELECT f FROM FeedbackModel f JOIN FETCH f.rental r JOIN FETCH r.location")
    List<FeedbackModel> findAllWithRental();

    boolean existsByRentalId(Long rentalId);
}
