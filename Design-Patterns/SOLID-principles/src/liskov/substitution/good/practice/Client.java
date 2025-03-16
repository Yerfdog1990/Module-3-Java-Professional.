package liskov.substitution.good.practice;

public class Client {
    public static void main(String[] args) {
        FlyingBirds eagle = new Eagle();
        eagle.fly();
        NonFlyingBirds ostrich = new Ostrich();
        ostrich.runs();
    }
}
