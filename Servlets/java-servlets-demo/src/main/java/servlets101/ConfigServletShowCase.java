package servlets101;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/config-servlet-showcase"},
    initParams = {
      @WebInitParam(name = "param1", value = "value1"),
      @WebInitParam(name = "param2", value = "value2")
    })
public class ConfigServletShowCase extends HttpServlet {
  public ConfigServletShowCase() {
    System.out.println("Servlet instantiated!");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("Servlet initialized!");
    getServletContext().setAttribute("globalAtt", "some value");
    ServletConfig config = getServletConfig();
    Enumeration<String> paramNames = config.getInitParameterNames();
    Map<String, String> params = new HashMap<>();
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      params.put(paramName, config.getInitParameter(paramName));
    }
    System.out.println(params);
  }

  @Override
  public void destroy() {
    System.out.println("Servlet destroyed!");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello World from Servlet (CONFIG)!");
    resp.getWriter().println(getServletConfig().getInitParameter("param1"));
    System.out.println("In the doGet method!");
  }
}
