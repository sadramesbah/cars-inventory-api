package com.sadramesbah.cars_inventory_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "cars")
public class Car {

  @Column(name = "car_id", nullable = false, unique = true)
  private Long id;

  @Column(name = "car_vin", length = 17, nullable = false)
  private String vin;

  @Column(length = 50, nullable = false)
  private String make;

  @Column(length = 50, nullable = false)
  private String model;

  @Column(length = 4, nullable = false)
  private int year;

  @Column(length = 20, nullable = false)
  private String color;

  @Column(length = 6, nullable = false)
  private int mileage;

  @Column(precision = 10, scale = 2, nullable = false)
  private double price;


  // Default constructor
  public Car() {
  }

  // Parameterized constructor
  public Car(Long id, String vin, String make, String model, int year, String color, int mileage,
      double price) {
    this.id = id;
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

  public void setId(Long id) {
    this.id = id;
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
