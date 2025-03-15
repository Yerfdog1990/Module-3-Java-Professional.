package structural.pattern.adapter;

public class Log4JSLF4UtilAdapter implements Logger {
  private final Log4JUtilLogger logger;

  public Log4JSLF4UtilAdapter(Log4JUtilLogger logger) {
    this.logger = logger;
  }

  @Override
  public void info(String msg) {
    logger.logInfo(msg);
  }

  @Override
  public void error(String msg) {
    logger.logError(msg);
  }

  @Override
  public void debug(String msg) {
    logger.logDebug(msg);
  }

  @Override
  public void warn(String msg) {
    logger.logWarn(msg);
  }

  @Override
  public void trace(String msg) {
    logger.logTrace(msg);
  }

  @Override
  public void fatal(String msg) {
    logger.logFatal(msg);
  }
}
