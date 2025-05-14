package structuralpattern.composite.apply1;

import java.util.ArrayList;
import java.util.List;

public class ImageEditor {
    private CompoundGraphic allComponents;
    private List<Graphic> components;

    public ImageEditor() {
        allComponents = new CompoundGraphic();
        components = new ArrayList<>();
    }

    public void load(){
        Dot dot = new Dot(1,2);
        Circle circle = new Circle(3,4,5);
        allComponents.add(dot);
        allComponents.add(circle);
    }
    public void groupSelected(){
        CompoundGraphic selectedComponent = new CompoundGraphic();
        for (Graphic component : components) {
            selectedComponent.add(component);
            allComponents.remove(selectedComponent);
        }
        allComponents.add(selectedComponent);
        allComponents.draw();
    }
}
