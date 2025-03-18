package structural.pattern.adaptor.apply1;

public class Burundi implements FranceCharger {
    @Override
    public void fromFrance(String roundHole) {
    System.out.println("Burundi uses a charger with " +roundHole+ " from France.");
    }
}
