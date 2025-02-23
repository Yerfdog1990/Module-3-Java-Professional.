package org.example;

public class CarProduction {
  public Car makeCar1() {
    return new Car.CarBuilder()
        .setColour("White")
        .setModel("BMW")
        .setCountryOfOrigin("Germany")
        .setYear(2020)
        .setMileage(100000)
        .setEngineSize(1.6)
        .setWheelDrive("AWD")
        .setFuelType("Petrol")
        .setFuelConsumption(10.0)
        .build();
  }

  public Car makeCar2() {
    return new Car.CarBuilder()
        .setColour("Black")
        .setModel("Mercedes")
        .setCountryOfOrigin("Germany")
        .setYear(2021)
        .setMileage(50000)
        .setEngineSize(2.0)
        .setWheelDrive("RWD")
        .setFuelType("Diesel")
        .setFuelConsumption(8.5)
        .build();
  }

  public Car makeCar3() {
    return new Car.CarBuilder()
        .setColour("Blue")
        .setModel("Tesla")
        .setCountryOfOrigin("USA")
        .setYear(2022)
        .setMileage(20000)
        .setEngineSize(0.0)
        .setWheelDrive("AWD")
        .setFuelType("Electric")
        .setFuelConsumption(0.0)
        .build();
  }

  public Car makeCar4() {
    return new Car.CarBuilder()
        .setColour("Red")
        .setModel("Ferrari")
        .setCountryOfOrigin("Italy")
        .setYear(2019)
        .setMileage(15000)
        .setEngineSize(4.5)
        .setWheelDrive("RWD")
        .setFuelType("Petrol")
        .setFuelConsumption(12.5)
        .build();
  }

  public Car makeCar5() {
    return new Car.CarBuilder()
        .setColour("Green")
        .setModel("Toyota")
        .setCountryOfOrigin("Japan")
        .setYear(2018)
        .setMileage(120000)
        .setEngineSize(1.8)
        .setWheelDrive("FWD")
        .setFuelType("Hybrid")
        .setFuelConsumption(5.0)
        .build();
  }
}
