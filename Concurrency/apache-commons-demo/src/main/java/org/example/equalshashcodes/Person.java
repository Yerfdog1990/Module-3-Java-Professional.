package org.example.equalshashcodes;

import java.util.HashMap;

public class Person {
  public String name;
  public int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && name.equals(person.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + age;
    return result;
  }

  public static void main(String[] args) {
    Person p1 = new Person("John", 20);
    Person p2 = new Person("John", 20);
    System.out.println(p1.equals(p2));
    System.out.println(p1.hashCode() == p2.hashCode());
    System.out.println(p1.hashCode());
    System.out.println(p2.hashCode());
    System.out.println(p1.name.hashCode());
    System.out.println(p2.name.hashCode());

    HashMap<Person, String> map = new HashMap<>();
    map.put(p1, "John");
    map.put(p2, "John");
    System.out.println(map.hashCode());
  }
}
