package liskov.substitution.good.practice;

public abstract class FlyingBirds {
   abstract void fly();
}
class Eagle extends FlyingBirds {
    @Override
    void fly() {
        System.out.println("Eagle is flying");
    }
}
