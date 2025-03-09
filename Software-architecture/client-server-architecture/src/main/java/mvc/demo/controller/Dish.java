package mvc.demo.controller;

import lombok.Data;

@Data
public class Dish {
  private final String representation;

  public Dish(String representation) {
    this.representation = representation;
  }
}
