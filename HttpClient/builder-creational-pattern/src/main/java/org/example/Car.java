package org.example;

public class Car {
  private final String model;
  private final String colour;
  private final String countryOfOrigin;
  private final int year;
  private final int mileage;
  private final double engineSize;
  private final String wheelDrive;
  private final String fuelType;
  private final double fuelConsumption;

  // Private constructor
  Car(CarBuilder builder) {
    this.model = builder.model;
    this.colour = builder.colour;
    this.countryOfOrigin = builder.countryOfOrigin;
    this.year = builder.year;
    this.mileage = builder.mileage;
    this.engineSize = builder.engineSize;
    this.wheelDrive = builder.wheelDrive;
    this.fuelType = builder.fuelType;
    this.fuelConsumption = builder.fuelConsumption;

    if (builder.fuelConsumption < 0) {
      throw new IllegalArgumentException("Fuel consumption cannot be negative");
    }
    if (builder.fuelConsumption > 0 && builder.fuelType == null) {
      throw new IllegalArgumentException(
          "Fuel type cannot be null when fuel consumption is greater than zero");
    }
    if (builder.fuelConsumption == 0 && builder.fuelType != null) {
      throw new IllegalArgumentException("Fuel type cannot be null when fuel consumption is zero");
    }
    if (builder.year > java.time.Year.now().getValue() || builder.year < 1886) {
      throw new IllegalArgumentException("Year must be between 1886 and the current year");
    }
    if (builder.mileage < 0) {
      throw new IllegalArgumentException("Mileage cannot be negative");
    }
    if (builder.engineSize <= 0) {
      throw new IllegalArgumentException("Engine size must be positive");
    }
    if (!"FWD".equals(builder.wheelDrive)
        && !"RWD".equals(builder.wheelDrive)
        && !"AWD".equals(builder.wheelDrive)) {
      throw new IllegalArgumentException("Wheel drive must be one of 'FWD', 'RWD', or 'AWD'");
    }
    if (builder.model == null || builder.model.isEmpty()) {
      throw new IllegalArgumentException("Model cannot be null or empty");
    }
    if (builder.colour == null || builder.colour.isEmpty()) {
      throw new IllegalArgumentException("Colour cannot be null or empty");
    }
    if (builder.countryOfOrigin == null || builder.countryOfOrigin.isEmpty()) {
      throw new IllegalArgumentException("Country of origin cannot be null or empty");
    }
  }

  @Override
  public String toString() {
    return STR."Car{model='\{model}', colour='\{colour}', countryOfOrigin='\{countryOfOrigin}', year=\{year}, mileage=\{mileage}, engineSize=\{engineSize}, wheelDrive='\{wheelDrive}', fuelType='\{fuelType}', fuelConsumption=\{fuelConsumption}}";
  }

  // Car builder class
  static class CarBuilder {
    private String model;
    private String colour;
    private String countryOfOrigin;
    private int year;
    private int mileage;
    private double engineSize;
    private String wheelDrive;
    private String fuelType;
    private double fuelConsumption;

    // Setters
    public CarBuilder setModel(String model) {
      this.model = model;
      return this;
    }

    public CarBuilder setColour(String colour) {
      this.colour = colour;
      return this;
    }

    public CarBuilder setCountryOfOrigin(String countryOfOrigin) {
      this.countryOfOrigin = countryOfOrigin;
      return this;
    }

    public CarBuilder setYear(int year) {
      this.year = year;
      return this;
    }

    public CarBuilder setMileage(int mileage) {
      this.mileage = mileage;
      return this;
    }

    public CarBuilder setEngineSize(double engineSize) {
      this.engineSize = engineSize;
      return this;
    }

    public CarBuilder setWheelDrive(String wheelDrive) {
      this.wheelDrive = wheelDrive;
      return this;
    }

    public CarBuilder setFuelType(String fuelType) {
      this.fuelType = fuelType;
      return this;
    }

    public CarBuilder setFuelConsumption(double fuelConsumption) {
      this.fuelConsumption = fuelConsumption;
      return this;
    }

    public Car build() {
      return new Car(this);
    }
  }
}
