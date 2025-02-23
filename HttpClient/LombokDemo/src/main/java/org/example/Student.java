package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
  private String name;
  private int age;
  private String form;
  private String nationality;
  private String address;
  private String gender;
  private String phone;
  private String email;
  private String parentName;
  private String StudentID;
}
