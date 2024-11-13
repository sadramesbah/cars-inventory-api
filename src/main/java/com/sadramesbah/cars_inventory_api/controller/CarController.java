package com.sadramesbah.cars_inventory_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadramesbah.cars_inventory_api.entity.Car;
import com.sadramesbah.cars_inventory_api.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  // Saves a new car
  @PostMapping("/car")
  public ResponseEntity<Car> saveCar(@RequestBody Car car) {
    Car savedCar = carService.saveCar(car);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
  }

  // Retrieves car by ID
  @GetMapping("/car/{carId}")
  public ResponseEntity<Car> retrieveCarById(@PathVariable Long carId) {
    Optional<Car> carOptional = carService.retrieveCarById(carId);
    return carOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  }

  // Retrieves all cars
  @GetMapping("/cars")
  public ResponseEntity<List<Car>> retrieveAllCars() {
    List<Car> cars = carService.retrieveAllCars();
    return ResponseEntity.ok(cars);
  }

  // Updates details of an existing car
  @PutMapping(path = "/car/{carId}")
  public ResponseEntity<Car> updateCar(@PathVariable Long carId, @RequestBody Car car) {
    Optional<Car> updatedCarOptional = carService.updateCar(carId, car);
    return updatedCarOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  }

  // Deletes a car by ID
  @DeleteMapping("/car/{carId}")
  public ResponseEntity<String> deleteCar(@PathVariable Long carId) {
    boolean isDeleted = carService.deleteCar(carId);
    if (isDeleted) {
      return ResponseEntity.ok(
          String.format("Car with ID: %d has been deleted successfully", carId));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(String.format(
              "Failed to delete car with ID: %d. Car does not exist or an internal error occurred.",
              carId));
    }
  }
}