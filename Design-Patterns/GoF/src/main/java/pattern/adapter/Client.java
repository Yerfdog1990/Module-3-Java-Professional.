package pattern.adapter;

public class Client {
  public static void main(String[] args) {
    System.out.println("Log4JSLF4JAdapter implementation:");
    Logger logger = new Log4JSLF4JAdapter(new Log4JLogger());
    logger.info("This is an info message");
    logger.error("This is an error message");
    logger.debug("This is a debug message");
    logger.warn("This is a warn message");
    logger.trace("This is a trace message");
    logger.fatal("This is a fatal message");

    System.out.println("\nLog4JSLF4UtilAdapter implementation:");
    Logger logger2 = new Log4JSLF4UtilAdapter(new Log4JUtilLogger());
    logger2.info("This is an info message");
    logger2.error("This is an error message");
    logger2.debug("This is a debug message");
    logger2.warn("This is a warn message");
    logger2.trace("This is a trace message");
    logger2.fatal("This is a fatal message");
  }

  private static Logger interfaceLogger() {
    return new Log4JSLF4UtilAdapter(new Log4JUtilLogger());
  }
}
