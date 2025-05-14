package structuralpattern.bridge.apply2;

public abstract class Equipment {
    protected IProduct product;
    public Equipment(IProduct product) {
        this.product = product;
    }
    public abstract void orderEquipment();
}
