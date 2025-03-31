package org.example.objects.advancedsorting.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.Data;

@Data
public class Student {
  private final String name;
  private final int age;

  @Override
  public String toString() {
    return name + " " + age;
  }
}

class SortByName implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return o1.getName().compareTo(o2.getName());
  }
}

class SortByAge implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return o1.getAge() - o2.getAge();
  }
}

class CompareSingleField {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("John", 20));
    studentList.add(new Student("Jane", 21));
    studentList.add(new Student("Jill", 19));
    studentList.add(new Student("Joe", 22));

    // Print unordered list
    System.out.println("Before sorting: " + studentList);

    // Print order by name
    Collections.sort(studentList, new SortByName());
    System.out.println("Sorting by name: " + studentList);

    // Print order by age
    Collections.sort(studentList, new SortByAge());
    System.out.println("Sorting by age: " + studentList);
  }
}
/*
Understanding the Comparator Interface in Simple Terms
In Java, when you have a list of objects (like students with roll numbers, names, etc.), you might want to sort them in different ways—maybe by roll number, by name, or even by date of birth.
The Comparator interface helps you do that easily without modifying the original class.

What is a Comparator?
A Comparator is a tool that helps compare two objects. It tells Java which object is greater, smaller, or if they are equal.

How Does Sorting Work?
Java has a built-in Collections.sort() method that sorts lists. When sorting objects, Java doesn’t know how to compare them unless you provide logic using Comparator.

The Comparator interface has a method:
public int compare(Object obj1, Object obj2)
1.Returns -1 if obj1 is smaller than obj2
2.Returns 0 if they are equal
3Returns 1 if obj1 is greater than obj2

How It Works
Step 1:We create a Student class with age and name.
Step 2:We create two separate Comparator classes to compare by age and name.
Step 3:We use Collections.sort() and pass the list along with the required comparator.
Java automatically sorts the list based on the comparator logic.

Key Takeaways
1.Comparator lets us sort objects based on different criteria.
2.We implement Comparator and override the compare() method.
3.Collections.sort() uses the comparator to sort the list.
4.You can create multiple comparator classes for different sorting needs.
*/
