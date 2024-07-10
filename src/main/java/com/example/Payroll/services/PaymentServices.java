package com.example.Payroll.services;

import com.example.Payroll.entities.Payment;
import com.example.Payroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PaymentServices {
    @Value("${Payroll.host}")
    private  String Host;

    private final RestTemplate restTemplate;
     public Payment getPayment(long workId, int days){
         Map<String,String>  uriVariables = new HashMap<>();
         uriVariables.put("id",""+workId);
         Worker woker = restTemplate.getForObject(Host + "/workers/{id}",Worker.class,uriVariables);
         return new Payment(woker.getName(), woker.getDailyIncome(), days);
     }

}
