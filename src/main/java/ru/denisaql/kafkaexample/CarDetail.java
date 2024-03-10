package ru.denisaql.kafkaexample;

import lombok.Data;

@Data
public class CarDetail {
    private String company;
    private String model;
    private Integer year;
}