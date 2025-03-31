package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EqualsWithInheritance {
  public static void main(String[] args) {
    DogInfo dog1 = new DogInfo("Canis lupus familiaris", "Bulldog");
    DogInfo dog2 = new DogInfo("Canis lupus familiaris", "Bulldog");
    System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
    System.out.println("dog1 == dog2: " + (dog1 == dog2));
    System.out.println(
        "dog1.hashCode() == dog2.hashCode(): " + (dog1.hashCode() == dog2.hashCode()));
  }
}

class AnimalInfo {
  protected String species;

  public AnimalInfo(String species) {
    this.species = species;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    AnimalInfo other = (AnimalInfo) obj;
    return new EqualsBuilder().append(species, other.species).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(species).toHashCode();
  }
}

final class DogInfo extends AnimalInfo {
  private String breed;

  public DogInfo(String species, String breed) {
    super(species);
    this.breed = breed;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) return false;

    DogInfo other = (DogInfo) obj;
    return new EqualsBuilder()
        .appendSuper(super.equals(obj)) // Include superclass comparison
        .append(breed, other.breed)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(breed).toHashCode();
  }
}
/*
Handling equals() with Inheritance
If a class extends another class, use appendSuper() to include the parent class's equality check.

Explanation
appendSuper(super.equals(obj)) ensures the parent class’s equals() check is included.
This guarantees correct comparison even when dealing with inheritance.
 */
