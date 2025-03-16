package liskov.substitution.bad.practice;

/*
The Liskov substitution principle states that you must be able to replace
a superclass object with a subclass object without affecting the correctness of the program.
 */
public abstract class Bird {
    abstract void fly();
}
class Eagle extends Bird {
    @Override
    void fly() {
        System.out.println("Eagle flying");
    }
}
class Ostrich extends Bird {
    @Override
    void fly() {
        System.out.println("Ostrich flying");
    }
}
class Main{
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        eagle.fly();
        Bird ostrich = new Ostrich();
        ostrich.fly();// Not practical since an ostrich cannot fly
    }
    /*
    In the above example, the Eagle class and the Ostrich class both extend the Bird class and override the fly() method. However, the Ostrich class is forced to provide a dummy implementation because it cannot fly, and therefore it does not behave the same way if we replace the Bird class object with it.
    This violates the Liskov substitution principle. To address this, we can create a separate class for birds that can fly and have the Eagle extend it, while other birds can extend a different class, which will not include any fly behavior.
     */
}
