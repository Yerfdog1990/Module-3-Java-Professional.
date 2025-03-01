package servlets101;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session-showcase")
public class SessionShowCaseServlet extends HttpServlet {
  private static final String PARAMS_KEY = "params-key";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    Map<String, String[]> parameterMap = addSessionAndRequestParams(req);
    req.getSession().setAttribute(PARAMS_KEY, parameterMap);
    resp.setContentType("text/plain");
    resp.getWriter().println(mapAsString(parameterMap));
    resp.getWriter().println("Is session new? " + req.getSession().isNew() + "");
    session.invalidate();
  }

  private String mapAsString(Map<String, String[]> map) {
    StringBuilder paramMapString = new StringBuilder();
    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      paramMapString
          .append(entry.getKey())
          .append(": ")
          .append(java.util.Arrays.toString(entry.getValue()))
          .append(System.lineSeparator());
    }
    return paramMapString.toString();
  }

  private Map<String, String[]> getParameterFromSession(HttpServletRequest req) {
    HttpSession session = req.getSession();
    return (Map<String, String[]>) session.getAttribute(PARAMS_KEY);
  }

  private Map<String, String[]> addSessionAndRequestParams(HttpServletRequest req) {
    Map<String, String[]> parameterFromSession = notNullMap(getParameterFromSession(req));
    Map<String, String[]> requiredParams = notNullMap(req.getParameterMap());
    Map<String, String[]> allParams = new java.util.HashMap<>(parameterFromSession);
    allParams.putAll(requiredParams);
    return allParams;
  }

  private Map<String, String[]> notNullMap(Map<String, String[]> map) {
    if (map == null) {
      return new java.util.HashMap<>();
    }
    return map;
  }
}
