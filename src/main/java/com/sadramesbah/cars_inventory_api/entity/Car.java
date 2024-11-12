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
}
