package MVC_pattern;

// Represents how the data (student details) should be displayed to the user. Contains a method
// (printStudentDetails) to print the student’s
public class Student_View {
  public void printStudentDetails(
      String studentName,
      String department,
      int age,
      String address,
      String gender,
      String course,
      String phone,
      String email) {
    System.out.println("Student Name: " + studentName);
    System.out.println("Department: " + department);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("Gender: " + gender);
    System.out.println("Course: " + course);
    System.out.println("Phone: " + phone);
    System.out.println("Email: " + email);
  }
}
