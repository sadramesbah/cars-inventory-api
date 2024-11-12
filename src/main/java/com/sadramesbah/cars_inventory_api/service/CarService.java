package com.sadramesbah.cars_inventory_api.service;

import com.sadramesbah.cars_inventory_api.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
