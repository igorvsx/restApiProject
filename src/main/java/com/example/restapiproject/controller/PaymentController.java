package com.example.restapiproject.controller;

import com.example.restapiproject.model.PaymentModel;
import com.example.restapiproject.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentModel> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentModel getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id).orElseThrow();
    }

    @PostMapping
    public PaymentModel createPayment(@RequestBody PaymentModel payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/{id}")
    public PaymentModel updatePayment(@PathVariable Long id, @RequestBody PaymentModel payment) {
        payment.setId(id);
        return paymentService.savePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}