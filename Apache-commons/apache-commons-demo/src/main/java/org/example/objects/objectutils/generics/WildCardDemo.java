package org.example.objects.objectutils.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {
  public static void main(String[] args) {
    School school = new School();
    List<String> data = List.of("Year 1", "Year 2", "Year 3", "Year 4", "Year 5");
    school.printData(data);
    Student student = new Student();
    List<Student> students = new ArrayList<>();
    students.add(new Student());
    student.printStudentData(students);
    Teacher teacher = new Teacher();
    teacher.studentList = students;
    teacher.assignStudentsToTeacher(new ArrayList<>(students));
    for (Student s : students) {
      System.out.println(s.studentList);
    }
  }
}

class School {

  // Unbounded wildcard
  protected void printData(List<?> data) {
    System.out.println("Unbounded Wildcard:");
    for (Object datum : data) {
      System.out.println(datum);
    }
  }
}

class Student {
  List<String> studentList = List.of("Student 1", "Student 2", "Student 3");

  // Upper bound
  protected void printStudentData(List<? extends Object> students) {

    System.out.println("Upper bound wildcard:");
    for (Object student : studentList) {
      System.out.println(student);
    }
  }
}

class Teacher {
  List<Student> studentList;

  // Lower-bound wildcard
  protected void assignStudentsToTeacher(List<? super List<Student>> teachers) {
    // Add list of teachers
    System.out.println("Lower bound wildcard:");
    teachers.add(studentList);
  }
}
