package org.example.equalsbuilder;

import java.util.Objects;

public class WithoutEqualBuilder {
  public String name;
  public int age;

  public WithoutEqualBuilder(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    WithoutEqualBuilder other = (WithoutEqualBuilder) obj;
    return Objects.equals(name, other.name) && age == other.age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  public static void main(String[] args) {
    WithoutEqualBuilder a = new WithoutEqualBuilder("a", 1);
    WithoutEqualBuilder b = new WithoutEqualBuilder("a", 1);
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
