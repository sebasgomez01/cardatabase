package com.csgp.cardatabase.web;

import org.springframework.web.bind.annotation.RestController;
import com.csgp.cardatabase.domain.CarRepository;
import com.csgp.cardatabase.domain.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class CarController {

    private final CarRepository respository;

    // inyección de CarRepository
    CarController(CarRepository respository) {
        this.respository = respository;
    }

    @GetMapping("cars")
    public Iterable<Car> getCars() {
        return respository.findAll();
    }
}
