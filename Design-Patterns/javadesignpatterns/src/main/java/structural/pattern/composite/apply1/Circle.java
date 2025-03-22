package structural.pattern.composite.apply1;

// Extend leaf
public class Circle extends Dot{
private final int radius;
public Circle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
}

    @Override
    public void draw() {
    System.out.println("Draw circle at " + "("+ x + ", " + y +")"+ " with radius " + radius + " cm.");
    }
}
