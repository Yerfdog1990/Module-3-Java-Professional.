package concurrencyannotations;

import net.jcip.annotations.Immutable;

@Immutable
public class ImmutablePoint {
    private final int x, y; // Since x and y are final and never change, multiple threads can safely use this class.
    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public static void main(String[] args){
       Point p = new Point(new ImmutablePoint(1,2));
       p.centerOfCircle();
    }
}
class Point {
    ImmutablePoint immutablePoint;
    public Point(ImmutablePoint immutablePoint) {
        this.immutablePoint = immutablePoint;
    }
    public void centerOfCircle() {
        double radius = (Math.sqrt(immutablePoint.getX()*immutablePoint.getX() + immutablePoint.getY()*immutablePoint.getY()));
        System.out.printf("Radius of circle: %.2fcm.", radius);
    }
}
/*
@Immutable
📌 Indicates that an object is immutable (unchangeable after creation).
Immutable objects are always thread-safe because they can't be modified.
Used for constants, value objects, and objects shared across threads.
 */
