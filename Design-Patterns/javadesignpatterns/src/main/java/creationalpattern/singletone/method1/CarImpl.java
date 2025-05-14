package creationalpattern.singletone.method1;

public class CarImpl implements ICar {
    // Single instance
    private static CarImpl car;

    // Private constructor
    private CarImpl() {
        System.out.println("Welcome to our car yard!");
    }
    public static CarImpl getInstance() {
        if(car == null) {
            car = new CarImpl();
            System.out.println("A new car has been created.");
        }
        return car;
    }

    @Override
    public void drive() {
        System.out.println("Driving the car...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car...");
    }

    @Override
    public void setSpeed(int speed) {
        System.out.println("Setting the speed to " + speed + " km/h.");
    }

    @Override
    public String getSpeed(double distance, double time) {
        return "The car travelled " + distance + " km in " + time + " seconds. Hence its speed was " + (distance/time) + " km/h.";
    }
}
