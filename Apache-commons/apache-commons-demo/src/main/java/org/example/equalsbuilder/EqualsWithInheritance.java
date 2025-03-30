package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class EqualsWithInheritance {
  public static void main(String[] args) {
    Dog dog1 = new Dog("Canis lupus familiaris", "Bulldog");
    Dog dog2 = new Dog("Canis lupus familiaris", "Bulldog");
    System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
    System.out.println("dog1 == dog2: " + (dog1 == dog2));
  }
}

class Animal {
  protected String species;

  public Animal(String species) {
    this.species = species;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    Animal other = (Animal) obj;
    return new EqualsBuilder().append(species, other.species).isEquals();
  }
}

class Dog extends Animal {
  private String breed;

  public Dog(String species, String breed) {
    super(species);
    this.breed = breed;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) return false;

    Dog other = (Dog) obj;
    return new EqualsBuilder()
        .appendSuper(super.equals(obj)) // Include superclass comparison
        .append(breed, other.breed)
        .isEquals();
  }
}
/*
Handling equals() with Inheritance
If a class extends another class, use appendSuper() to include the parent class's equality check.

Explanation
appendSuper(super.equals(obj)) ensures the parent class’s equals() check is included.
This guarantees correct comparison even when dealing with inheritance.
 */
