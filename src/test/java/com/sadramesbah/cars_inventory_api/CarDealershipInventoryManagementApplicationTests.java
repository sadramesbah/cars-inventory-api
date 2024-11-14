package com.sadramesbah.cars_inventory_api;

import com.sadramesbah.cars_inventory_api.entity.Car;
import com.sadramesbah.cars_inventory_api.service.CarService;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CarDealershipInventoryManagementApplicationTests {

  @Autowired
  private CarService carService;

  @Test
  void contextLoads() {
  }

  @Test
  void testSaveCar() {
    Car car = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));

    Car savedCar = carService.saveCar(car);
    assertThat(savedCar).isNotNull();
    assertThat(savedCar.getId()).isNotNull();
    assertThat(savedCar.getVin()).isEqualTo("1HGCM12115A004352");
  }

  @Test
  void testRetrieveCarById() {
    Car car = new Car("1HGCM12115A004352", "Mazda", "CX-5", 2023, "Blue", 15000,
        BigDecimal.valueOf(28000.00));

    Car savedCar = carService.saveCar(car);
    assertThat(savedCar).isNotNull();
    Optional<Car> retrievedCar = carService.retrieveCarById(savedCar.getId());
    assertThat(retrievedCar).isPresent();
    assertThat(retrievedCar.get().getVin()).isEqualTo("1HGCM12115A004352");
  }

  @Test
  void testUpdateCar() {
    Car car1 = new Car("1HGCM12115A004352", "Mazda", "CX-5", 2023, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Mazda", "CX-5", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));

    Car savedCar = carService.saveCar(car1);
    assertThat(savedCar).isNotNull();
    Optional<Car> updatedCar = carService.updateCar(savedCar.getId(), car2);
    assertThat(updatedCar).isPresent();
    assertThat(updatedCar.get().getVin()).isEqualTo("1KLMC00285A001960");
    assertThat(updatedCar.get().getColor()).isEqualTo("Silver");
  }

  @Test
  void testDeleteCar() {
    Car car = new Car("1HGCM12115A004352", "Mazda", "CX-5", 2023, "Blue", 15000,
        BigDecimal.valueOf(28000.00));

    Car savedCar = carService.saveCar(car);
    assertThat(savedCar).isNotNull();
    carService.deleteCar(savedCar.getId());
    Optional<Car> retrievedCar = carService.retrieveCarById(savedCar.getId());
    assertThat(retrievedCar).isNotPresent();
  }
}