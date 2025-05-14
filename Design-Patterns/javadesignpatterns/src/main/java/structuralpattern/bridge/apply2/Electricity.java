package structuralpattern.bridge.apply2;

public class Electricity implements IProduct{
    @Override
    public void showProduct() {
        System.out.println("I am Electricity");
    }
}
