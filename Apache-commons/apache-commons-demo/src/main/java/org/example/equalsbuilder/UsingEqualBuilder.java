package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class UsingEqualBuilder {
  private final String name;
  private final int age;

  public UsingEqualBuilder(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    UsingEqualBuilder other = (UsingEqualBuilder) obj;
    return new EqualsBuilder().append(name, other.name).append(age, other.age).isEquals();
  }

  public static void main(String[] args) {
    UsingEqualBuilder a = new UsingEqualBuilder("a", 1);
    UsingEqualBuilder b = new UsingEqualBuilder("a", 1);
    System.out.println("a.equals(b): " + a.equals(b));
    System.out.println("a == b: " + (a == b));
    System.out.println("a.hashCode() == b.hashCode(): " + (a.hashCode() == b.hashCode()));
    System.out.println("a.toString() == b.toString(): " + (a.toString().equals(b.toString())));
    System.out.println("a.name == b.name: " + (a.name == b.name));
    System.out.println("a.age == b.age: " + (a.age == b.age));
    System.out.println("a.name.equals(b.name): " + (a.name.equals(b.name)));
    System.out.println(
        "a.name.hashCode() == b.name.hashCode(): " + (a.name.hashCode() == b.name.hashCode()));
    System.out.println(
        "a.name.toString() == b.name.toString(): " + (a.name.toString().equals(b.name.toString())));
  }
}
/*
Understanding EqualsBuilder in Apache Commons Lang
The EqualsBuilder class from the Apache Commons Lang library helps in implementing the equals(Object obj) method in a cleaner and more efficient way.
It follows the guidelines from Effective Java by Joshua Bloch to ensure proper equality checks.

Why Use EqualsBuilder?
1.Manually implementing equals() can be tedious and error-prone. The EqualsBuilder simplifies this process by:
2.Handling complex comparisons (including float, double, and arrays).
3.Maintaining consistency between equals() and hashCode().
4.Reducing boilerplate code in equals() implementations.
 */
