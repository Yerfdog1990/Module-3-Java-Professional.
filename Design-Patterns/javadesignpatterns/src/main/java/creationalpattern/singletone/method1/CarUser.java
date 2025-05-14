package creationalpattern.singletone.method1;

public class CarUser {
    public static void main(String[] args) {
        ICar car = CarImpl.getInstance();
        car.drive();
        car.stop();
        car.setSpeed(100);
        System.out.println(car.getSpeed(1000, 10));
    }
}
