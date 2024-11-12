package com.sadramesbah.cars_inventory_api.service;

import com.sadramesbah.cars_inventory_api.repository.CarRepository;
import com.sadramesbah.cars_inventory_api.entity.Car;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarService.class);
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car) {
        try {
            return carRepository.save(car);

        } catch (Exception e) {
            logger.error("Failed to save car: {}", e.getMessage());
            throw new RuntimeException("Failed to save car: " + e.getMessage());
        }
    }
}
