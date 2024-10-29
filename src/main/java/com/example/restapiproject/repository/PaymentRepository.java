package com.example.restapiproject.repository;

import com.example.restapiproject.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
