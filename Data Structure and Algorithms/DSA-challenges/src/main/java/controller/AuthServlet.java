package controller;

import java.io.IOException;
import java.net.CookieManager;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.sendRedirect("/index.jsp");
    // Create a session object if it is already not  created.
    HttpSession session = req.getSession(true);
    // Get session creation time.
    Date createdTime = new Date();
    session.setAttribute("createdTime", createdTime);
    // Get last access time of this web page.
    Date lastAccessedTime = new Date();
    session.setAttribute("lastAccessedTime", lastAccessedTime);
    // Get duration of visit
    long duration = lastAccessedTime.getTime() - createdTime.getTime();
    session.setAttribute("duration", duration);
    // Get visitor details
    String ipAddress = req.getRemoteAddr();
    session.setAttribute("ipAddress", ipAddress);
    int visitCount = (int) session.getAttribute("visitCount");
    session.setAttribute("visitCount", ++visitCount);
    String userID = session.getId();
    session.setAttribute("userID", userID);
    // Get cookies
    CookieManager cookieManager = new CookieManager();
    cookieManager.getCookieStore().getCookies();
    session.setAttribute("cookies", cookieManager.getCookieStore().getCookies());
    // Get the names of all the objects bound to this session
    Enumeration<String> names = session.getAttributeNames();
    while (names.hasMoreElements()) {
      String name = names.nextElement();
      System.out.println(name + " : " + session.getAttribute(name));
    }
  }
}
