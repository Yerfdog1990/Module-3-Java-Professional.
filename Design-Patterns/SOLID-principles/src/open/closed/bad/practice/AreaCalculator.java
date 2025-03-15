package open.closed.bad.practice;

import java.awt.*;

/*
Open/Closed Principle
According to the open/closed principle, components must be open for extension, but, closed for modification.
To understand this principle, let us take an example of a class that calculates the area of a shape.
 */
public class AreaCalculator {
    public static void main(String[] args) {
        calculateArea(new Rectangle());
    }

    public static double calculateArea(Shape shape) {
        double areaOfShape = 0;
        if (shape instanceof Square) {
            System.out.println("Calculating area of a circle");
        } else if (shape instanceof Rectangle) {
            System.out.println("Calculating area of a rectangle");
        }
        return areaOfShape;
    }
}
abstract class Shape {
}

class Square extends Shape {
}

class Rectangle extends Shape {
}
/*
The problem with the above example is that if there is a new instance of type
Shape for which you need to calculate the area in the future, you have to modify the above class by adding another conditional else-if block.
You will end up doing this for every new object of the Shape type.

To overcome this, you can create an interface and have each Shape implement this interface. Then, each class can provide its own implementation for calculating the area.
This will make your program easily extensible in the future.
 */