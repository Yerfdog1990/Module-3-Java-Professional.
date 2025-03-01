package servlets101;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/http-request-showcase")
public class HttpRequestShowCaseServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    String method = req.getMethod();
    String uri = req.getRequestURI();
    String url = req.getRequestURL().toString();
    String queryString = req.getQueryString();
    String contextPath = req.getContextPath();
    Map<String, String[]> parameterMap = req.getParameterMap();
    String remoteAddr = req.getRemoteAddr();
    String remoteHost = req.getRemoteHost();
    String remoteUser = req.getRemoteUser();
    String authType = req.getAuthType();
    StringBuilder headersTable = new StringBuilder();
    var headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      String headerValue = req.getHeader(headerName);
      headersTable
          .append("<tr><td>")
          .append(headerName)
          .append("</td><td>")
          .append(headerValue)
          .append("</td></tr>");
    }

    resp.getWriter()
        .println(
            """
<html><body>""");
    resp.getWriter().println("<table>");
    resp.getWriter().println("<tr><th>Name</th><th>Value</th></tr>");
    resp.getWriter().println("<tr><td>Method</td><td>" + method + "</td></tr>");
    resp.getWriter().println("<tr><td>URI</td><td>" + uri + "</td></tr>");
    resp.getWriter().println("<tr><td>URL</td><td>" + url + "</td></tr>");
    resp.getWriter().println("<tr><td>Query String</td><td>" + queryString + "</td></tr>");
    resp.getWriter().println("<tr><td>Context Path</td><td>" + contextPath + "</td></tr>");
    resp.getWriter().println("<tr><td>Parameter Map</td><td>" + parameterMap + "</td></tr>");
    resp.getWriter().println("<tr><td>Remote Address</td><td>" + remoteAddr + "</td></tr>");
    resp.getWriter().println("<tr><td>Remote Host</td><td>" + remoteHost + "</td></tr>");
    resp.getWriter().println("<tr><td>Remote User</td><td>" + remoteUser + "</td></tr>");
    resp.getWriter().println("<tr><td>Auth Type</td><td>" + authType + "</td></tr>");
    resp.getWriter().println(headersTable);
    resp.getWriter().println("</table>");
    resp.getWriter()
        .println(
            """
</body></html>""");
  }
}
