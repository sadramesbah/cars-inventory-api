package com.sadramesbah.cars_inventory_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "car_id", nullable = false, unique = true)
  private Long id;

  @Column(name = "car_vin", length = 17, nullable = false)
  private String vin;

  @Column(name = "car_make", length = 50, nullable = false)
  private String make;

  @Column(name = "car_model", length = 50, nullable = false)
  private String model;

  @Column(name = "car_year", length = 4, nullable = false)
  private int year;

  @Column(name = "car_color", length = 20, nullable = false)
  private String color;

  @Column(name = "car_mileage", length = 6, nullable = false)
  private int mileage;

  @Column(name = "car_price", precision = 10, scale = 2, nullable = false)
  private double price;


  // Default constructor
  public Car() {
  }

  // Parameterized constructor
  public Car(String vin, String make, String model, int year, String color, int mileage,
      double price) {
    this.vin = vin;
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.mileage = mileage;
    this.price = price;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
