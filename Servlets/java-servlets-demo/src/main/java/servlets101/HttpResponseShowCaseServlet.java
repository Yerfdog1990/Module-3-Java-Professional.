package servlets101;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/http-response-showcase")
public class HttpResponseShowCaseServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.setContentType("text/html");
    resp.setHeader("X-Custom-Header", "Hello World!");
    resp.getWriter().println("<h1>Hello World from Servlet (RESPONSE)!</h1>");
  }
}
