package structural.pattern.bridge.apply;

public abstract class Book {
    protected LibraryAPI libraryAPI;
    public Book(LibraryAPI libraryAPI) {
        this.libraryAPI = libraryAPI;
    }
    public abstract void read();
}
