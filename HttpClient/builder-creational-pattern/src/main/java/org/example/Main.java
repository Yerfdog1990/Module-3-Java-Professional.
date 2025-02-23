package org.example;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    CarProduction carProduction = new CarProduction();
    Car car1 = carProduction.makeCar1();
    System.out.println(">" + car1 + "<");
  }
}
