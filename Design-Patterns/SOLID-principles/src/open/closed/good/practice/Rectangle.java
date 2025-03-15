package open.closed.good.practice;

public class Rectangle implements IAreaCalculator {
    @Override
    public void calculateArea() {
        System.out.println("Rectangle area is: 100");
    }
}
