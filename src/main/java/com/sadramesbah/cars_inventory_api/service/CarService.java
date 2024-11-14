package com.sadramesbah.cars_inventory_api.service;

import com.sadramesbah.cars_inventory_api.repository.CarRepository;
import com.sadramesbah.cars_inventory_api.entity.Car;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
      String errorMessage = String.format(
          "Failed to save the car with ID: %d, Make: %s, Model: %s, VIN: %s. Error: %s",
          car.getId(), car.getMake(), car.getModel(), car.getVin(), e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveAllCars() {
    try {
      return carRepository.findAll();

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve all cars. Error: %s", e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public Optional<Car> retrieveCarById(Long id) {
    try {
      return carRepository.findById(id);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve car by ID: %d. Error: %s", id,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMake(String make) {
    try {
      return carRepository.findByMake(make);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve cars by Make: %s. Error: %s", make,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByModel(String model) {
    try {
      return carRepository.findByModel(model);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve cars by Model: %s. Error: %s", model,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByYear(int year) {
    try {
      return carRepository.findByYear(year);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve cars by Year: %d. Error: %s", year,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByColor(String color) {
    try {
      return carRepository.findByColor(color);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to retrieve cars by Color: %s. Error: %s", color,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
    try {
      return carRepository.findByPriceBetween(minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Price Range: %.2f - %.2f. Error: %s", minPrice, maxPrice,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMileageBetween(int minMileage, int maxMileage) {
    try {
      return carRepository.findByMileageBetween(minMileage, maxMileage);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Mileage Range: %d - %d. Error: %s", minMileage, maxMileage,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeAndModel(String make, String model) {
    try {
      return carRepository.findByMakeAndModel(make, model);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s and Model: %s. Error: %s", make, model,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeAndYear(String make, int year) {
    try {
      return carRepository.findByMakeAndYear(make, year);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s and Year: %d. Error: %s", make, year,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeModelAndYear(String make, String model, int year) {
    try {
      return carRepository.findByMakeAndModelAndYear(make, model, year);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s, Model: %s, and Year: %d. Error: %s", make, model,
          year, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeAndPriceBetween(String make, BigDecimal minPrice,
      BigDecimal maxPrice) {
    try {
      return carRepository.findByMakeAndPriceBetween(make, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s and Price Range: %.2f - %.2f. Error: %s", make,
          minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByModelAndPriceBetween(String model, BigDecimal minPrice,
      BigDecimal maxPrice) {
    try {
      return carRepository.findByModelAndPriceBetween(model, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Model: %s and Price Range: %.2f - %.2f. Error: %s", model,
          minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeModelAndPriceBetween(String make, String model,
      BigDecimal minPrice,
      BigDecimal maxPrice) {
    try {
      return carRepository.findByMakeAndModelAndPriceBetween(make, model, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s, Model: %s, and Price Range: %.2f - %.2f. Error: %s",
          make, model, minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public Optional<Car> updateCar(Long id, Car car) {
    try {
      Optional<Car> existingCar = carRepository.findById(id);
      if (existingCar.isPresent()) {
        Car carToUpdate = existingCar.get();
        carToUpdate.setVin(car.getVin());
        carToUpdate.setMake(car.getMake());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setYear(car.getYear());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setMileage(car.getMileage());
        carToUpdate.setPrice(car.getPrice());
        return Optional.of(carRepository.save(carToUpdate));

      } else {
        String errorMessage = String.format(
            "Car with ID: %d does not exist. Update operation aborted.", id);
        logger.warn(errorMessage);
        return Optional.empty();
      }

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to update car with ID: %d, Make: %s, Model: %s, VIN: %s. Error: %s",
          id, car.getMake(), car.getModel(), car.getVin(), e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public boolean deleteCar(Long id) {
    try {
      if (carRepository.existsById(id)) {
        carRepository.deleteById(id);
        return true;

      } else {
        String errorMessage = String.format("Car with ID: %d does not exist. Deletion aborted.",
            id);
        logger.warn(errorMessage);
        return false;
      }

    } catch (Exception e) {
      String errorMessage = String.format("Failed to delete car by ID: %d. Error: %s", id,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

}
