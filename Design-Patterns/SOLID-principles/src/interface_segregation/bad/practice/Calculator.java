package interface_segregation.bad.practice;

/*
Interface Segregation Principle
According to the interface segregation principle, you should build small,
focused interfaces that do not force the client to implement behavior they do not need.
 */
public interface Calculator {
    void calculateArea(double radius);
    void calculateArea(double length, double breadth);
}
class RectangleArea implements Calculator {
    @Override
    public void calculateArea(double length, double breadth) {
        System.out.println("Area of a rectangle: " + length * breadth);
    }
    @Override
    public void calculateArea(double radius) {
        System.out.println("Forced to implement this method even if a rectangle does not have radius.");
    }
}
class CircleArea implements Calculator{
    @Override
    public void calculateArea(double radius) {
        System.out.printf("Area of a circle: %.2f\n", (Math.PI*radius*radius));
    }
    @Override
    public void calculateArea(double length, double breath){
        System.out.println( "Forced to implement this method even if a circle does not have length and breath.");
    }
}
class Main{
    public static void main(String[] args) {
        RectangleArea rectangleArea = new RectangleArea();
        rectangleArea.calculateArea(10, 20);
        rectangleArea.calculateArea(10);
        CircleArea circleArea = new CircleArea();
        circleArea.calculateArea(10);
        circleArea.calculateArea(10, 20);
    }
    /*
    The issue with this is that a Rectangle class is forced to implement a method calculateArea(double radius), which it does not need.
    On the other hand, a Circle class is forced to implement calculateArea(double length, double breath), which it does not need.
    To overcome this, we can segregate the interface and have two separate interfaces each having one method to be implemented separately.
    This will allow individual shapes to decide what to implement.
     */
}
