package structural.pattern.adapter;

// Adapter implementation
public class Log4JSLF4JAdapter implements Logger {
  private final Log4JLogger log4JLogger;

  public Log4JSLF4JAdapter(Log4JLogger log4JLogger) {
    this.log4JLogger = log4JLogger;
  }

  @Override
  public void info(String msg) {
    log4JLogger.logInfo(msg);
  }

  @Override
  public void error(String msg) {
    log4JLogger.logError(msg);
  }

  @Override
  public void debug(String msg) {
    log4JLogger.logDebug(msg);
  }

  @Override
  public void warn(String msg) {
    log4JLogger.logWarn(msg);
  }

  @Override
  public void trace(String msg) {
    log4JLogger.logTrace(msg);
  }

  @Override
  public void fatal(String msg) {
    log4JLogger.logFatal(msg);
  }
}
