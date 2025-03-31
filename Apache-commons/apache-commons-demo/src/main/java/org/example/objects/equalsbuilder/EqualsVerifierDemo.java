package org.example.objects.equalsbuilder;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@AllArgsConstructor
@Getter
class Car {
  private final String fuel;
  private final int year;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return new EqualsBuilder().append(fuel, car.fuel).append(year, car.year).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(fuel).append(year).toHashCode();
  }
}

final class Mazda extends Car {
  private final String model;

  public Mazda(String fuel, int year, String model) {
    super(fuel, year);
    this.model = model;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Mazda mazda = (Mazda) o;
    return Objects.equals(model, mazda.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), model);
  }
}
/*
Handling equals() with Inheritance
If a class extends another class, use appendSuper() to include the parent class's equality check.

Explanation
appendSuper(super.equals(obj)) ensures the parent class’s equals() check is included.
This guarantees correct comparison even when dealing with inheritance.
 */
