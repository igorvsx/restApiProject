package com.example.restapiproject.service;

import com.example.restapiproject.model.PaymentModel;
import com.example.restapiproject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentModel> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<PaymentModel> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public PaymentModel savePayment(PaymentModel payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
