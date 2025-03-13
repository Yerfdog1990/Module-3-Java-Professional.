package pattern.decorator;

public class Client {
  public static void main(String[] args) {
    Connection connection = new DBCConnectionDecorator(new DBCConnectionImpl()).getConnection();
    System.out.println(connection);
  }
}
