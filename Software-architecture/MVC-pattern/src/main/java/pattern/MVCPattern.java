package pattern;

public class MVCPattern {
  public static void main(String[] args) {
    Student_Model student = retrieveStudentData();
    pattern.Student_View view = new Student_View();
    Student_Controller controller = new Student_Controller(student, view);
    System.out.println("Initial Student Details:");
    controller.updateView();
    controller.setStudentName("Godfrey");
    controller.setStudentAge(25);
    System.out.println("\nUpdated Student Details:");
    controller.updateView();
  }

  public static Student_Model retrieveStudentData() {
    Student_Model student = new Student_Model();
    student.setName("John Doe");
    student.setAge(20);
    student.setGender("Male");
    student.setCourse("BSc in Computer Science");
    student.setDepartment("Computer Science");
    student.setAddress("Nairobi, Kenya");
    student.setPhone("0777777777");
    student.setEmail("<EMAIL>");
    return student;
  }
}
