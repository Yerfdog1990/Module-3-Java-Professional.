package structural.pattern.bridge.apply2;

public class Client {
    public static void main(String[] args) {
        IProduct electricity = new Electricity();
        electricity.showProduct();
        System.out.println("=========================");
        Subject order = new Subject(electricity);
        order.orderEquipment();
    }
}
