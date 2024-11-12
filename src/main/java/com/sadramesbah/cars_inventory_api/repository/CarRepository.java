package com.sadramesbah.cars_inventory_api.repository;

import com.sadramesbah.cars_inventory_api.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {}
