package structural.pattern.composite.apply1;

import java.util.ArrayList;
import java.util.List;

// Composite class
public class CompoundGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    // Add children
    public void add(Graphic child) {
        children.add(child);
    }
    // Remove children
    public void remove(Graphic child) {
        children.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for (Graphic child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void draw() {
    System.out.println("Drawing a compound graphic containing: ");
    for (Graphic child : children) {
        child.draw();
        }
    }
}
