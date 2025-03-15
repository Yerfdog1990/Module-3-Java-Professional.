package structural.pattern.decorator;

public class Client {
    public static void main(String[] args){
        Shape circle = new Circle();
        circle.draw();
        System.out.println("=========================");
        Shape rectangle = new Rectangle();
        rectangle.draw();

        Shape redCircle = new RedShapeDecorator(circle);
        redCircle.draw();
        System.out.println("=========================");
        Shape redRectangle = new RedShapeDecorator(rectangle);
        redRectangle.draw();
    }
}
