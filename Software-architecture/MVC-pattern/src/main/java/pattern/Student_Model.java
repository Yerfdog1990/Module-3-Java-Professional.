package pattern;

import lombok.Data;

// Represents the student's data and provides methods to access and modify this data.
@Data
public class Student_Model {
  private String name;
  private int age;
  private String gender;
  private String course;
  private String department;
  private String address;
  private String phone;
  private String email;
}
