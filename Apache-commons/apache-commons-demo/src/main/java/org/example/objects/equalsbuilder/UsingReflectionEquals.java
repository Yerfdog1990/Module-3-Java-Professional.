package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UsingReflectionEquals {
  public static void main(String[] args) {
    Person p1 = new Person("John", 20);
    Person p2 = new Person("John", 20);
    System.out.println("p1.equals(p2): " + p1.equals(p2));
    System.out.println("p1 == p2: " + (p1 == p2));
    System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
  }
}

class Person {
  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(name).append(age).toHashCode();
  }
}
/*
Using reflectionEquals() for Automatic Comparisons
Instead of manually specifying fields, reflectionEquals() can compare all fields automatically.

How It Works
Uses reflection to compare all fields automatically.
Caveat: Slower performance due to reflection.
Security Restriction: May fail under a security manager.
 */
