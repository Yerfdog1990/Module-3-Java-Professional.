package structuralpattern.bridge.apply1;

public class JavaPrograming implements LibraryAPI {
    @Override
    public void readBook(String title, String author, String publisher, int year, String edition, int ISBN) {
        System.out.printf("Reading Java Programing book: \nTitle: %s.\nAuthor: %s.\nPublisher: %s.\nYear: %d.\nEdition: %s.\nISBN: %d.",  title, author, publisher, year, edition, ISBN);
    }
}
