package pattern.decorator;

public class DBCConnectionDecorator implements DBCConnection {
  private final DBCConnection source;

  public DBCConnectionDecorator(DBCConnection source) {
    this.source = source;
  }

  @Override
  public Connection getConnection() {
    System.out.println("getConnection called");
    return source.getConnection();
  }
}
