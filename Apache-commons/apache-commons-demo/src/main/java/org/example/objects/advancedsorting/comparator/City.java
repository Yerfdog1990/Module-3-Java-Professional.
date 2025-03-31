package org.example.objects.advancedsorting.comparator;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class City {
  private final String name;
  private final int population;

  @Override
  public String toString() {
    return name + " : " + population;
  }
}

class UsingMethodReference {
  public static void main(String[] args) {
    List<City> cityList = new ArrayList<>();
    cityList.add(new City("New York", 8_500_000));
    cityList.add(new City("Los Angeles", 3_900_000));
    cityList.add(new City("Chicago", 2_695_000));
    cityList.add(new City("Houston", 2_150_000));
    cityList.add(new City("Philadelphia", 1_524_000));
    cityList.add(new City("Phoenix", 1_450_000));
    cityList.add(new City("San Antonio", 1_290_000));
    cityList.add(new City("Dallas", 1_250_000));
    cityList.add(new City("San Diego", 1_083_000));
    cityList.add(new City("San Jose", 998_000));

    // Original list
    System.out.println("Original List ");
    for (City city : cityList) {
      System.out.println(city);
    }

    // Sort by population then by name
    cityList.sort(Comparator.comparing(City::getPopulation).thenComparing(City::getName));
    System.out.println("\nSorted List by population then by name");
    for (City city : cityList) {
      System.out.println(city);
    }
  }
}
