package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber c = a.plus(b);
        System.out.println(c.realPart() + " + " + c.imaginaryPart() +"i");
        ComplexNumber d = a.minus(b);
        System.out.println(d.realPart() + " " + d.imaginaryPart() +"i");
  }
}