package com.sadramesbah.cars_inventory_api.service;

import com.sadramesbah.cars_inventory_api.repository.CarRepository;
import com.sadramesbah.cars_inventory_api.entity.Car;
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

  public List<Car> retrieveCarsByPriceRange(double minPrice, double maxPrice) {
    try {
      return carRepository.findByPriceRange(minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Price Range: %.2f - %.2f. Error: %s", minPrice, maxPrice,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMileageRange(int minMileage, int maxMileage) {
    try {
      return carRepository.findByMileageRange(minMileage, maxMileage);

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

  public List<Car> retrieveCarsByMakeAndPriceRange(String make, double minPrice, double maxPrice) {
    try {
      return carRepository.findByMakeAndPriceRange(make, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s and Price Range: %.2f - %.2f. Error: %s", make,
          minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByModelAndPriceRange(String model, double minPrice,
      double maxPrice) {
    try {
      return carRepository.findByModelAndPriceRange(model, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Model: %s and Price Range: %.2f - %.2f. Error: %s", model,
          minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public List<Car> retrieveCarsByMakeModelAndPriceRange(String make, String model, double minPrice,
      double maxPrice) {
    try {
      return carRepository.findByMakeAndModelAndPriceRange(make, model, minPrice, maxPrice);

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to retrieve cars by Make: %s, Model: %s, and Price Range: %.2f - %.2f. Error: %s",
          make, model, minPrice, maxPrice, e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public Car updateCar(Car car) {
    try {
      Optional<Car> existingCar = carRepository.findById(car.getId());
      if (existingCar.isPresent()) {
        return carRepository.save(car);

      } else {
        String errorMessage = String.format("Car with ID: %d does not exist. Update operation aborted.", car.getId());
        logger.warn(errorMessage);
        throw new RuntimeException(errorMessage);
      }

    } catch (Exception e) {
      String errorMessage = String.format(
          "Failed to update car with ID: %d, Make: %s, Model: %s, VIN: %s. Error: %s",
          car.getId(), car.getMake(), car.getModel(), car.getVin(), e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }

  public void deleteCar(Long id) {
    try {
      carRepository.deleteById(id);

    } catch (Exception e) {
      String errorMessage = String.format("Failed to delete car by ID: %d. Error: %s", id,
          e.getMessage());
      logger.error(errorMessage);
      throw new RuntimeException(errorMessage);
    }
  }
}
