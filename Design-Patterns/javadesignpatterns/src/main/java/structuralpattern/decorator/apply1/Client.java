package structuralpattern.decorator.apply1;

public class Client {
    public static void main(String[] args){
        System.out.println("Designing house 1");
        House house = new Designer1();
        HouseDesign design1 = new HouseDesign(house);
        design1.build();
        design1.paintHouse("red");
        design1.addRoof("iron sheet");
        design1.addWindows(5);
        design1.addFloor(5);
        System.out.println("\nDesigning house 2");
        house = new Designer2();
        HouseDesign design2 = new HouseDesign(house);
        design2.build();
        design2.paintHouse("blue");
        design2.addRoof("wooden");
        design2.addWindows(10);
        design2.addFloor(10);
    }
}
