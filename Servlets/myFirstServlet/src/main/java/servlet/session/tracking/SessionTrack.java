package servlet.session.tracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sessionTrack")
public class SessionTrack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessedTime = new Date(session.getLastAccessedTime());

        // Handle expiry time safely
        Date expiryTime;
        if (session.getMaxInactiveInterval() > 0) {
            expiryTime = new Date(session.getMaxInactiveInterval() * 1000L + session.getCreationTime());
        } else {
            expiryTime = null;  // Session does not expire
        }

        PrintWriter out = resp.getWriter();
        String title = "Welcome Back to my website";
        Integer visitCount = 0;  // Ensure visitCount is initialized
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "123456789";

        // Check if this is a new or returning user
        if (session.isNew()) {
            title = "Welcome to my website";
            session.setAttribute(userIDKey, userID);
        } else {
            if (session.getAttribute(visitCountKey) == null) {
                visitCount = 0;
            } else {
                visitCount = (Integer) session.getAttribute(visitCountKey);
            }
            visitCount++;  // Increment visit count
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        // Set response content type
        resp.setContentType("text/html");

        // Generate response
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\">Session Information</h2>\n" +
                "<table border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "  <th>Session info</th><th>value</th></tr>\n" +
                "<tr><td>JSESSIONID</td><td>" + session.getId() + "</td></tr>\n" +
                "<tr><td>Creation time</td><td>" + creationTime + "</td></tr>\n" +
                "<tr><td>Time of last access</td><td>" + lastAccessedTime + "</td></tr>\n" +
                "<tr><td>User ID</td><td>" + userID + "</td></tr>\n" +
                "<tr><td>Number of visits</td><td>" + visitCount + "</td></tr>\n" +
                "<tr><td>Expiry time</td><td>" + (expiryTime != null ? expiryTime : "Session does not expire") + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>"
        );

        out.close();
    }
}
