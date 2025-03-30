package org.example.equalsbuilder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

public class ExcludingFields {
  public static void main(String[] args) {
    PersonInfo p1 = new PersonInfo("John", 20);
    PersonInfo p2 = new PersonInfo("John", 20);
    System.out.println("p1.equals(p2): " + p1.equals(p2));
    System.out.println("p1 == p2: " + (p1 == p2));
    System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
  }
}

class PersonInfo {
  private final String name;
  private final int age;

  @EqualsExclude private transient String address;

  public PersonInfo(String name, int age) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    PersonInfo other = (PersonInfo) obj;
    return new EqualsBuilder().append(name, other.name).append(age, other.age).isEquals();
  }

  @Override
  public int hashCode() {
    return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
        .append(name)
        .append(age)
        .toHashCode();
  }
}

/*
Excluding Fields with @EqualsExclude
Sometimes, you may want to exclude certain fields from comparison. You can use @EqualsExclude.

Why Use @EqualsExclude?
1.Prevents non-important fields from affecting equality.
2.Useful for transient or dynamically changing fields.
 */
