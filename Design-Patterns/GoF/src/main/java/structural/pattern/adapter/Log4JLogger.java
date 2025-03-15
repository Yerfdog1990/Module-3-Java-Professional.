package structural.pattern.adapter;

// Adaptee
public class Log4JLogger {
  public void logInfo(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }

  public void logError(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }

  public void logDebug(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }

  public void logWarn(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }

  public void logTrace(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }

  public void logFatal(String msg) {
    System.out.println("Log4JLogger: " + msg);
  }
}
