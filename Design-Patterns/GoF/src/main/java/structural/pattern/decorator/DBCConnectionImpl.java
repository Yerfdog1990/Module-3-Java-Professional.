package structural.pattern.decorator;

public class DBCConnectionImpl implements DBCConnection {
  @Override
  public Connection getConnection() {
    return new ConnectionImpl();
  }
}
