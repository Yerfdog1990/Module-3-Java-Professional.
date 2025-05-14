package structuralpattern.composite.apply1;

public class Client {
    public static void main(String[] args){
        ImageEditor imageEditor = new ImageEditor();
        imageEditor.load();
        imageEditor.groupSelected();
  }
}
