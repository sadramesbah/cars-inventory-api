package com.sadramesbah.cars_inventory_api.controller;

import com.sadramesbah.cars_inventory_api.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }
}