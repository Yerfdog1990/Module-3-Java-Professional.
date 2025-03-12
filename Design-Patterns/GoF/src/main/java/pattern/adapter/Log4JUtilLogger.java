package pattern.adapter;

public class Log4JUtilLogger {
  public void logInfo(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }

  public void logError(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }

  public void logDebug(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }

  public void logWarn(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }

  public void logTrace(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }

  public void logFatal(String msg) {
    System.out.println("Log4JUtilLogger: " + msg);
  }
}
