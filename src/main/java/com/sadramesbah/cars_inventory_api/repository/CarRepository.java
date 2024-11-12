package com.sadramesbah.cars_inventory_api.repository;

import com.sadramesbah.cars_inventory_api.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByMake(String make);

    List<Car> findByModel(String model);

    List<Car> findByYear(int year);

    List<Car> findByColor(String color);

    List<Car> findByPriceBetween(double minPrice, double maxPrice);

    List<Car> findByMileageBetween(int minMileage, int maxMileage);

    List<Car> findByMakeAndModel(String make, String model);

    List<Car> findByMakeAndYear(String make, int year);

    List<Car> findByMakeAndModelAndYear(String make, String model, int year);

    List<Car> findByMakeAndPriceBetween(String make, double minPrice, double maxPrice);

    List<Car> findByModelAndPriceBetween(String model, double minPrice, double maxPrice);

    List<Car> findByMakeAndModelAndPriceBetween(String make, String model, double minPrice, double maxPrice);

}
