package structuralpattern.bridge.apply1;

public class Client {
    public static void main(String[] args){
        LibraryAPI javaPrograming = new JavaPrograming();
        javaPrograming.readBook("Java Programing", "<NAME>", "Pearson Education", 2018, "1st Edition", 123456789);
        System.out.println("========================================");

        LibraryAPI pythonProgramming = new PythonProgramming();
        pythonProgramming.readBook("Python Programming", "<NAME>", "Pearson Education", 2019, "2nd Edition", 987654321);
        System.out.println("========================================");

        LibraryAPI rubyProgramming = new RubyProgramming();
        rubyProgramming.readBook("Ruby Programming", "<NAME>", "Pearson Education", 2017, "3rd Edition", 111111111);
    }
}
