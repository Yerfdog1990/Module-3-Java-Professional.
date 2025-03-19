package structural.pattern.decorator.apply1;

public class HouseDesign extends HouseDecorator {
    public HouseDesign(House house) {
        super(house);
    }

    @Override
    public void addWindows(int noOfWindows) {
        System.out.println("Adding " + noOfWindows + " windows to house.");
    }

    @Override
    public void addFloor(int noOfFloors) {
        System.out.println("Adding " + noOfFloors + " floors to house.");
    }

    @Override
    public void addRoof(String roofType) {
        System.out.println("Adding " + roofType + " roof to house.");
    }

    @Override
    public void paintHouse(String color) {
        System.out.println("Painting house with color " + color);
    }
}
