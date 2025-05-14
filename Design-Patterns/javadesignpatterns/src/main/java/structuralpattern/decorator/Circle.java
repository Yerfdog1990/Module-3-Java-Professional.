package structuralpattern.decorator;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle. Inside Circle class.");
    }
}
