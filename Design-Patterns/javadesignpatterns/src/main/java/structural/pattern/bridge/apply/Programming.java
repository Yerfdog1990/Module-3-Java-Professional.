package structural.pattern.bridge.apply;

public class Programming extends Book{
    public Programming(LibraryAPI libraryAPI) {
        super(libraryAPI);
    }
    @Override
    public void read() {
        libraryAPI.readBook("Java Programing", "<NAME>", "Wiley", 2018, "1st Edition", 123456789);
        libraryAPI.readBook("Python Programming", "<NAME>", "Packt", 2018, "1st Edition", 123456789);
        libraryAPI.readBook("Ruby Programming", "<NAME>", "O'Reilly", 2018, "1st Edition", 123456789);

    }
}
