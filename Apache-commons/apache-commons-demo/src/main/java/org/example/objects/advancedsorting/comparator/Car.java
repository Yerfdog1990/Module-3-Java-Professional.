package org.example.objects.advancedsorting.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.Data;

@Data
public class Car {
  private final String model;
  private final int year;

  @Override
  public String toString() {
    return model + " " + year;
  }
}

class sortByModelAndYear implements Comparator<Car> {
  @Override
  public int compare(Car o1, Car o2) {
    // Compare ny model first
    int modelCompare = o1.getModel().compareTo(o2.getModel());
    // Then compare by year
    int yearCompare = o1.getYear() - o2.getYear();
    return yearCompare == 0 ? modelCompare : yearCompare;
  }
}

class CompareMultipleFields {
  public static void main(String[] args) {
    List<Car> carList = new ArrayList<>();
    carList.add(new Car("Mazda", 2010));
    carList.add(new Car("Mazda", 2011));
    carList.add(new Car("BMW", 2012));
    carList.add(new Car("Ford", 2013));
    carList.add(new Car("Ford", 2014));
    carList.add(new Car("Ford", 2015));
    carList.add(new Car("Ford", 2016));
    // Original List
    System.out.println("Original List ");

    // Iterating List
    for (Car car : carList) {
      System.out.println(car);
    }

    // Sorting by model then year using sortByModelAndYear
    Collections.sort(carList, new sortByModelAndYear());
    System.out.println("\nSorted List by model then year");

    // Iterating list
    for (Car car : carList) {
      System.out.println(car);
    }
  }
}
