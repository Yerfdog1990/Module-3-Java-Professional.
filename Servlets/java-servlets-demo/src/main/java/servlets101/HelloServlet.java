package servlets101;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello World from Servlet (GET)!");
    resp.getWriter().println(getServletContext().getAttribute("globalAtt"));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello World from Servlet (POST)!");
  }

//  @Override
//  protected void service(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    resp.setContentType("text/plain");
//    resp.getWriter().println("Hello World from Servlet (SERVICE)!");
//  }
}
