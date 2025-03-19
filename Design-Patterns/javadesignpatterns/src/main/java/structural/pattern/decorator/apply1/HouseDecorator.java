package structural.pattern.decorator.apply1;

public abstract class HouseDecorator implements House {
    protected House house;
    public HouseDecorator(House house) {
        this.house = house;
    }
    @Override
    public void build() {
        house.build();
    }
    public abstract void addWindows(int noOfWindows);
    public abstract void addFloor(int noOfFloors);
    public abstract void addRoof(String roofType);
    public abstract void paintHouse(String color);
}
