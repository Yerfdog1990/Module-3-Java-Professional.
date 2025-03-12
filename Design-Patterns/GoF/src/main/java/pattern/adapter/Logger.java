package pattern.adapter;

// Target interface
public interface Logger {
  void info(String msg);

  void error(String msg);

  void debug(String msg);

  void warn(String msg);

  void trace(String msg);

  void fatal(String msg);
}
