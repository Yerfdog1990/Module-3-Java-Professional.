package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import nl.jqno.equalsverifier.EqualsVerifier;

public class EqualsVerifierDemo {
  public static void main(String[] args) {
    // Verify equals and hashCode for DogInfo
    EqualsVerifier.forClass(DogInfo.class).verify();
  }
}

class AnimalInfo {
  final String species;

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

class DogInfo extends AnimalInfo {
  String breed;

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
