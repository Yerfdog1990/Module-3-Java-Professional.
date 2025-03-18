package structural.pattern.bridge.apply2;

public class Subject extends Equipment{
    public Subject(IProduct product) {
        super(product);
    }

    @Override
    public void orderEquipment() {
        System.out.println("Order Subject");
        product.showProduct();
    }
}
