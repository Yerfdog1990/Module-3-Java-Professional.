package org.example.objects.advancedsorting.comparable;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Country implements Comparable {
  private String name;
  private int population;

  @Override
  public String toString() {
    return name + " : " + population;
  }

  @Override
  public int compareTo(Object obj) {
    Country other = (Country) obj;
    if (this.population < other.getPopulation())
      return -1; // This object is smaller than the other one
    if (this.population > other.getPopulation())
      return 1; // This object is larger than the other one
    return 0; // Both objects are the same
  }
}

class CompareCountries {
  // Main method
  public static void main(String[] args) {
    List<Country> countryList = new ArrayList<>();
    countryList.add(new Country("India", 129_000_000));
    countryList.add(new Country("USA", 331_000_000));
    countryList.add(new Country("China", 1_400_000_000));
    countryList.add(new Country("Brazil", 214_000_000));
    countryList.add(new Country("Russia", 144_000_000));
    countryList.add(new Country("Australia", 26_000_000));
    countryList.add(new Country("Canada", 38_000_000));

    countryList.sort(null);
    for (Country country : countryList) {
      System.out.println(country);
    }
  }
}
/*
The Comparable Interface
The Comparable interface allows an object to specify its own sorting rule with a compareTo() method.
The compareTo() method takes an object as an argument and compares the comparable with the argument to decide which one should go first in a list.
Like the comparator, the compareTo() method returns a number which is:
1.Negative if the comparable should go first in a list.
2.Positive if the other object should go first in a list.
3.Zero if the order does not matter.

Many native Java classes implement the Comparable interface, such as String and Integer.
This is why strings and numbers do not need a comparator to be sorted.

Comparator vs. Comparable
A comparator is an object with one method that is used to compare two different objects.
A comparable is an object which can compare itself with other objects.
It is easier to use the Comparable interface when possible, but the Comparator interface is more powerful because it allows you to sort any kind of object even if you cannot change its code.
 */
