package com.example.Payroll.resources;

import com.example.Payroll.entities.Payment;
import com.example.Payroll.services.PaymentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
    public final PaymentServices paymentServices;
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days){
        Payment payment = paymentServices.getPayment(workerId,days);
        return ResponseEntity.ok(payment);
    }
}
