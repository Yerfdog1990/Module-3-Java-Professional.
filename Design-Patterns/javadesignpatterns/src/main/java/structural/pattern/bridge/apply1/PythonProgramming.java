package structural.pattern.bridge.apply1;

public class PythonProgramming implements LibraryAPI {
    @Override
    public void readBook(String title, String author, String publisher, int year, String edition, int ISBN) {
        System.out.printf("Reading Python Programming book: \nTitle: %s.\nAuthor: %s.\nPublisher: %s.\nYear: %d.\nEdition: %s.\nISBN: %d.",  title, author, publisher, year, edition, ISBN);
    }
}
