package org.example;

public class StudentRegister {
  public String registerStudent() {
    StringBuilder registrations = new StringBuilder();
    
    registrations
        .append(
            new Student.StudentBuilder()
                .name("Yerfdog")
                .age(12)
                .form("Year 10")
                .nationality("Kenyan")
                .address("Nairobi")
                .gender("Male")
                .phone("+254721234567")
                .email("yerfdog@example.com")
                .parentName("Mary")
                .StudentID("STU001")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Jane Doe")
                .age(14)
                .form("Year 9")
                .nationality("American")
                .address("New York")
                .gender("Female")
                .phone("+15551234567")
                .email("jane.doe@example.com")
                .parentName("Emily")
                .StudentID("STU002")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("John Smith")
                .age(15)
                .form("Year 11")
                .nationality("British")
                .address("London")
                .gender("Male")
                .phone("+447700900123")
                .email("john.smith@example.com")
                .parentName("Jonathan")
                .StudentID("STU003")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Aisha Hassan")
                .age(13)
                .form("Year 8")
                .nationality("Kenyan")
                .address("Mombasa")
                .gender("Female")
                .phone("+254712345678")
                .email("aisha.hassan@example.com")
                .parentName("Fatima")
                .StudentID("STU004")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Carlos Rivera")
                .age(16)
                .form("Year 12")
                .nationality("Mexican")
                .address("Mexico City")
                .gender("Male")
                .phone("+525512345678")
                .email("carlos.rivera@example.com")
                .parentName("Sofia")
                .StudentID("STU005")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Linda Brown")
                .age(14)
                .form("Year 10")
                .nationality("Canadian")
                .address("Toronto")
                .gender("Female")
                .phone("+14161234567")
                .email("linda.brown@example.com")
                .parentName("William")
                .StudentID("STU006")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Wang Wei")
                .age(13)
                .form("Year 9")
                .nationality("Chinese")
                .address("Beijing")
                .gender("Male")
                .phone("+8613012345678")
                .email("wang.wei@example.cn")
                .parentName("Lan")
                .StudentID("STU007")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Elena Ivanova")
                .age(14)
                .form("Year 10")
                .nationality("Russian")
                .address("Moscow")
                .gender("Female")
                .phone("+74951234567")
                .email("elena.ivanova@example.ru")
                .parentName("Anastasia")
                .StudentID("STU008")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Ahmed Ali")
                .age(15)
                .form("Year 11")
                .nationality("Egyptian")
                .address("Cairo")
                .gender("Male")
                .phone("+20212345678")
                .email("ahmed.ali@example.eg")
                .parentName("Hassan")
                .StudentID("STU009")
                .build()
                .toString())
        .append("\n");

    registrations
        .append(
            new Student.StudentBuilder()
                .name("Priya Kapoor")
                .age(16)
                .form("Year 12")
                .nationality("Indian")
                .address("Mumbai")
                .gender("Female")
                .phone("+919812345678")
                .email("priya.kapoor@example.in")
                .parentName("Anita")
                .StudentID("STU010")
                .build()
                .toString())
        .append("\n");

    return registrations.toString();
  }
}
