package org.example;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    ComplexNumber complexNumber1 = ComplexNumber.valueOf(1, 2);
    ComplexNumber complexNumber2 = ComplexNumber.valueOf(3, 4);

    System.out.println(complexNumber1.plus(complexNumber2));
    System.out.println(complexNumber1.minus(complexNumber2));
    System.out.println(complexNumber1.times(complexNumber2));
    System.out.println(complexNumber1.dividedBy(complexNumber2));
  }
}
