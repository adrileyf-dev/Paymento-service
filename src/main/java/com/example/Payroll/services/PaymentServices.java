package com.example.Payroll.services;

import com.example.Payroll.entities.Payment;
import com.example.Payroll.entities.Worker;
import com.example.Payroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PaymentServices {

    private final WorkerFeignClient workerFeignClient;
     public Payment getPayment(long workId, int days){
         Worker woker = workerFeignClient.findById(workId).getBody();  //getForObject(Host + "/workers/{id}",Worker.class,uriVariables);
         return new Payment(woker.getName(), woker.getDailyIncome(), days);
     }

}
