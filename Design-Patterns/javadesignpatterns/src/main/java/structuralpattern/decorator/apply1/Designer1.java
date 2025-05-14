package structuralpattern.decorator.apply1;

public class Designer1 implements House{
    @Override
    public void build() {
        System.out.println("Building a house for a client 1");
    }
}
