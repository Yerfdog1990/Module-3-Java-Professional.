package mvc.pattern;

/*
Acts as an intermediary between the Model and the View. Contains references to the Model and View objects.
Provides methods to update the Model (e.g., setStudentName) and to update the View (updateView).
 */
public class Student_Controller {
  private Student_Model model;
  private Student_View view;

  // Constructor
  public Student_Controller(Student_Model student, Student_View view) {
    this.model = student;
    this.view = view;
  }

  // Setters
  public void setStudentName(String name) {
    model.setName(name);
  }

  public void setStudentAge(int age) {
    model.setAge(age);
  }

  public void setStudentGender(String gender) {
    model.setGender(gender);
  }

  public void setStudentCourse(String course) {
    model.setCourse(course);
  }

  public void setStudentDepartment(String department) {
    model.setDepartment(department);
  }

  public void setStudentAddress(String address) {
    model.setAddress(address);
  }

  public void setStudentPhone(String phone) {
    model.setPhone(phone);
  }

  public void setStudentEmail(String email) {
    model.setEmail(email);
  }

  // Getters
  public String getStudentName() {
    return model.getName();
  }

  public int getStudentAge() {
    return model.getAge();
  }

  public String getStudentGender() {
    return model.getGender();
  }

  public String getStudentCourse() {
    return model.getCourse();
  }

  public String getStudentDepartment() {
    return model.getDepartment();
  }

  public String getStudentAddress() {
    return model.getAddress();
  }

  public String getStudentPhone() {
    return model.getPhone();
  }

  public String getStudentEmail() {
    return model.getEmail();
  }

  // Update student details
  public void updateView() {
    view.printStudentDetails(
        model.getName(),
        model.getDepartment(),
        model.getAge(),
        model.getAddress(),
        model.getGender(),
        model.getCourse(),
        model.getPhone(),
        model.getEmail());
  }
}
