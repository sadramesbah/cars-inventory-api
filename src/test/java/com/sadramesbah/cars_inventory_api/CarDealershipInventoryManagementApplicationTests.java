package com.sadramesbah.cars_inventory_api;

import com.sadramesbah.cars_inventory_api.entity.Car;
import com.sadramesbah.cars_inventory_api.service.CarService;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

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

  @Test
  void testRetrieveCarsByColor() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Mazda", "CX-5", 2021, "Blue", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByColor("Blue");
    assertThat(cars).hasSize(2);
    assertThat(cars).extracting(Car::getColor).containsOnly("Blue");
  }

  @Test
  void testRetrieveCarsByPriceBetween() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Mazda", "CX-5", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByPriceBetween(BigDecimal.valueOf(15000.00),
        BigDecimal.valueOf(25000.00));
    assertThat(cars).hasSize(2);
    assertThat(cars).extracting(Car::getPrice)
        .containsOnly(BigDecimal.valueOf(16750.00), BigDecimal.valueOf(21000.00));
  }

  @Test
  void testRetrieveCarsByMileageBetween() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Mazda", "CX-5", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMileageBetween(50000, 90000);
    assertThat(cars).hasSize(2);
    assertThat(cars).extracting(Car::getMileage).containsOnly(89500, 60000);
  }

  @Test
  void testRetrieveCarsByMakeAndModel() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Mazda", "CX-5", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMakeAndModel("Mazda", "CX-5");
    assertThat(cars).hasSize(1);
    assertThat(cars).extracting(Car::getMake).containsOnly("Mazda");
    assertThat(cars).extracting(Car::getModel).containsOnly("CX-5");
  }

  @Test
  void testRetrieveCarsByMakeAndYear() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Honda", "Accord", 2023, "Silver", 7500,
        BigDecimal.valueOf(37000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMakeAndYear("Honda", 2020);
    assertThat(cars).hasSize(1);
    assertThat(cars).extracting(Car::getMake).containsOnly("Honda");
    assertThat(cars).extracting(Car::getYear).containsOnly(2020);
  }

  @Test
  void testRetrieveCarsByMakeModelAndYear() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Honda", "Accord", 2020, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMakeModelAndYear("Honda", "Accord", 2020);
    assertThat(cars).hasSize(2);
    assertThat(cars).extracting(Car::getMake).containsOnly("Honda");
    assertThat(cars).extracting(Car::getModel).containsOnly("Accord");
    assertThat(cars).extracting(Car::getYear).containsOnly(2020);
  }

  @Test
  void testRetrieveCarsByMakeAndPriceBetween() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Honda", "Accord", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMakeAndPriceBetween("Honda",
        BigDecimal.valueOf(20000.00), BigDecimal.valueOf(25000.00));
    assertThat(cars).hasSize(1);
    assertThat(cars).extracting(Car::getMake).containsOnly("Honda");
    assertThat(cars).extracting(Car::getPrice)
        .containsOnly(BigDecimal.valueOf(21000.00));
  }

  @Test
  void testRetrieveCarsByModelAndPriceBetween() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Honda", "Accord", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Honda", "Accord", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByModelAndPriceBetween("Accord",
        BigDecimal.valueOf(20000.00), BigDecimal.valueOf(30000.00));
    assertThat(cars).hasSize(2);
    assertThat(cars).extracting(Car::getModel).containsOnly("Accord");
    assertThat(cars).extracting(Car::getPrice)
        .containsOnly(BigDecimal.valueOf(28000.00), BigDecimal.valueOf(21000.00));
  }

  @Test
  void testRetrieveCarsByMakeModelAndPriceBetween() {
    Car car1 = new Car("1HGCM12115A004352", "Honda", "Accord", 2020, "Blue", 15000,
        BigDecimal.valueOf(28000.00));
    Car car2 = new Car("1KLMC00285A001960", "Honda", "Accord", 2021, "Silver", 60000,
        BigDecimal.valueOf(21000.00));
    Car car3 = new Car("2HGCM82633A004353", "Nissan", "Altima", 2017, "Black", 89500,
        BigDecimal.valueOf(16750.00));

    carService.saveCar(car1);
    carService.saveCar(car2);
    carService.saveCar(car3);
    List<Car> cars = carService.retrieveCarsByMakeModelAndPriceBetween("Honda", "Accord",
        BigDecimal.valueOf(25000.00), BigDecimal.valueOf(30000.00));
    assertThat(cars).hasSize(1);
    assertThat(cars).extracting(Car::getMake).containsOnly("Honda");
    assertThat(cars).extracting(Car::getModel).containsOnly("Accord");
    assertThat(cars).extracting(Car::getPrice)
        .containsOnly(BigDecimal.valueOf(28000.00));
  }
}