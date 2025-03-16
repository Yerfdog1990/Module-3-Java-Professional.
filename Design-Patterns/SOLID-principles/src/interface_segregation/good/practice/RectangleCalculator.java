package interface_segregation.good.practice;

public interface RectangleCalculator {
    void calculateArea(double width, double height);
}
class Rectangle implements RectangleCalculator {
    @Override
    public void calculateArea(double width, double height) {
        System.out.println("Rectangle area is: " + (width * height));
    }
}
