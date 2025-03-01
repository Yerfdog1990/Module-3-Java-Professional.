package servlets101;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("AuthenticationFilter invoked!");
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("AuthenticationFilter finished!");
  }
}
