package servlets101;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {
  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("LoggingFilter invoked!");
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("LoggingFilter finished!");
  }
}
