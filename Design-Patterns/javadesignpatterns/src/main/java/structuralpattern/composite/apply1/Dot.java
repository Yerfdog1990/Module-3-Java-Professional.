package structuralpattern.composite.apply1;

// Leaf
public class Dot implements Graphic {
    int x, y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
    this.x += this.x;
    this.y += this.y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a dot at " + x + ", " + y);
    }
}
