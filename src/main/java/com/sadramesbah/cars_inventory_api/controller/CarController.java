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

  // Retrieves cars by make
  @GetMapping("/cars/make/{make}")
  public ResponseEntity<List<Car>> retrieveCarsByMake(@PathVariable String make) {
    List<Car> cars = carService.retrieveCarsByMake(make);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by model
  @GetMapping("/cars/model/{model}")
  public ResponseEntity<List<Car>> retrieveCarsByModel(@PathVariable String model) {
    List<Car> cars = carService.retrieveCarsByModel(model);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by year
  @GetMapping("/cars/year/{year}")
  public ResponseEntity<List<Car>> retrieveCarsByYear(@PathVariable int year) {
    List<Car> cars = carService.retrieveCarsByYear(year);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by color
  @GetMapping("/cars/color/{color}")
  public ResponseEntity<List<Car>> retrieveCarsByColor(@PathVariable String color) {
    List<Car> cars = carService.retrieveCarsByColor(color);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by price range
  @GetMapping("/cars/price/{minPrice}/{maxPrice}")
  public ResponseEntity<List<Car>> retrieveCarsByPriceRange(@PathVariable double minPrice,
      @PathVariable double maxPrice) {
    List<Car> cars = carService.retrieveCarsByPriceRange(minPrice, maxPrice);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by mileage range
  @GetMapping("/cars/mileage/{minMileage}/{maxMileage}")
  public ResponseEntity<List<Car>> retrieveCarsByMileageRange(@PathVariable int minMileage,
      @PathVariable int maxMileage) {
    List<Car> cars = carService.retrieveCarsByMileageRange(minMileage, maxMileage);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by make and model
  @GetMapping("/cars/make/{make}/model/{model}")
  public ResponseEntity<List<Car>> retrieveCarsByMakeAndModel(@PathVariable String make,
      @PathVariable String model) {
    List<Car> cars = carService.retrieveCarsByMakeAndModel(make, model);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by make and year
  @GetMapping("/cars/make/{make}/year/{year}")
  public ResponseEntity<List<Car>> retrieveCarsByMakeAndYear(@PathVariable String make,
      @PathVariable int year) {
    List<Car> cars = carService.retrieveCarsByMakeAndYear(make, year);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by make, model, and year
  @GetMapping("/cars/make/{make}/model/{model}/year/{year}")
  public ResponseEntity<List<Car>> retrieveCarsByMakeModelAndYear(@PathVariable String make,
      @PathVariable String model, @PathVariable int year) {
    List<Car> cars = carService.retrieveCarsByMakeModelAndYear(make, model, year);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by make and price range
  @GetMapping("/cars/make/{make}/price/{minPrice}/{maxPrice}")
  public ResponseEntity<List<Car>> retrieveCarsByMakeAndPriceRange(@PathVariable String make,
      @PathVariable double minPrice, @PathVariable double maxPrice) {
    List<Car> cars = carService.retrieveCarsByMakeAndPriceRange(make, minPrice, maxPrice);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by model and price range
  @GetMapping("/cars/model/{model}/price/{minPrice}/{maxPrice}")
  public ResponseEntity<List<Car>> retrieveCarsByModelAndPriceRange(@PathVariable String model,
      @PathVariable double minPrice, @PathVariable double maxPrice) {
    List<Car> cars = carService.retrieveCarsByModelAndPriceRange(model, minPrice, maxPrice);
    return ResponseEntity.ok(cars);
  }

  // Retrieves cars by make, model, and price range
  @GetMapping("/cars/make/{make}/model/{model}/price/{minPrice}/{maxPrice}")
  public ResponseEntity<List<Car>> retrieveCarsByMakeModelAndPriceRange(@PathVariable String make,
      @PathVariable String model, @PathVariable double minPrice, @PathVariable double maxPrice) {
    List<Car> cars = carService.retrieveCarsByMakeModelAndPriceRange(make, model, minPrice,
        maxPrice);
    return ResponseEntity.ok(cars);
  }
}