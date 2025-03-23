package threadsafety;

import net.jcip.annotations.ThreadSafe;

/*
A class is thread‐safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or
interleaving of the execution of those threads by the runtime environment, and with no additional synchronization or
other coordination on the part of the calling code.

If multiple threads access the same mutable state variable without appropriate synchronization, your program is
broken. There are three ways to fix it:
• Don't share the state variable across threads;
• Make the state variable immutable; or
• Use synchronization whenever accessing the state variable.
 */

@ThreadSafe
class Calculator {
    // Make the state variable immutable
    private final double length;
    private final double width;
    private final double height;
    private final double radius;

    public Calculator(double length, double width, double height, double radius) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }
}
class SurfaceAreaCalculator{
    Calculator calculator;
    public SurfaceAreaCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    public double getSurfaceAreaOfCuboid(){
        return 2*(calculator.getLength()*calculator.getWidth() + 
                calculator.getLength()*calculator.getHeight() + 
                calculator.getWidth()*calculator.getHeight());
    }
    public double getSurfaceAreaOfSphere(){
        return 4*Math.PI*calculator.getRadius()*calculator.getRadius();
    }
    public double getSurfaceAreaOfCylinder(){
    return 2 * (Math.PI * calculator.getRadius() * calculator.getRadius()) + 
            (2 * Math.PI * calculator.getRadius() * calculator.getHeight());
    }
}

class VolumeCalculator {
  Calculator calculator;

  public VolumeCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  public double getVolumeOfCuboid() {
    return calculator.getLength() * calculator.getWidth() * calculator.getHeight();
  }

  public double getVolumeOfSphere() {
    return 4 / 3
        * Math.PI
        * calculator.getRadius()
        * calculator.getRadius()
        * calculator.getRadius();
  }

  public double getVolumeOfCylinder() {
    return Math.PI * calculator.getRadius() * calculator.getRadius() * calculator.getHeight();
  }
}

class CalculatorDemo{
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 20, 15, 5);
        SurfaceAreaCalculator surfaceAreaCalculator = new SurfaceAreaCalculator(calculator);
        VolumeCalculator volumeCalculator = new VolumeCalculator(calculator);
        System.out.printf("Surface Area of Cuboid = %.2fcm\u00B2",  surfaceAreaCalculator.getSurfaceAreaOfCuboid());
        System.out.printf("\nSurface Area of Sphere = %.2fcm\u00B2", surfaceAreaCalculator.getSurfaceAreaOfSphere());
        System.out.printf("\nSurface Area of Cylinder = %.2fcm\u00B2", surfaceAreaCalculator.getSurfaceAreaOfCylinder());
        System.out.printf("\nVolume of Cuboid = %.2fcm\u00B3", volumeCalculator.getVolumeOfCuboid());
        System.out.printf("\nVolume of Sphere = %.2fcm\u00B3", volumeCalculator.getVolumeOfSphere());
        System.out.printf("\nVolume of Cylinder = %.2fcm\u00B3", volumeCalculator.getVolumeOfCylinder());
    }
}
