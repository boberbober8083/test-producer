package ru.denisaql.kafkaexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/car")
public class MainController {
    private final List<CarDetail> details = initCars();

    private List<CarDetail> initCars() {
        CarDetail c1 = new CarDetail();
        c1.setYear(2004);
        c1.setModel("F40");
        c1.setCompany("BMW");

        CarDetail c2 = new CarDetail();
        c2.setYear(1977);
        c2.setModel("7 Series");
        c2.setCompany("BMW");

        CarDetail c3 = new CarDetail();
        c3.setYear(1994);
        c3.setModel("Avalon");
        c3.setCompany("Toyota");

        CarDetail c4 = new CarDetail();
        c4.setYear(1982);
        c4.setModel("Camry");
        c4.setCompany("Toyota");

        CarDetail c5 = new CarDetail();
        c5.setYear(2000);
        c5.setModel("Escape");
        c5.setCompany("Ford");

        return List.of(c1, c2, c3, c4, c5);
    }

    @GetMapping
    public List<CarDetail> carDetails() {
        return details;
    }

    @GetMapping("/show")
    public CarDetail carDetails(@RequestParam String id) {
        Integer i = Integer.valueOf(id);
        return details.get(i % details.size());
    }
}