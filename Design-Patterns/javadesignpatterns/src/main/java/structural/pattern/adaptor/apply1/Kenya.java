package structural.pattern.adaptor.apply1;

public class Kenya implements UKCharger {
    @Override
    public void fromUK(String squareHole) {
        System.out.println("Kenya uses charger with " +squareHole+ " from UK.");
    }
}
