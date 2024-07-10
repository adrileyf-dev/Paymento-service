package com.example.Payroll.entities;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Worker {
    private Long id;
    private String name;
    private Double dailyIncome;
}
