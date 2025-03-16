package liskov.substitution.good.practice;

public abstract class NonFlyingBirds {
    abstract void runs();
}
class Ostrich extends NonFlyingBirds {
    @Override
    void runs() {
        System.out.println("Ostrich is running");
    }
}
