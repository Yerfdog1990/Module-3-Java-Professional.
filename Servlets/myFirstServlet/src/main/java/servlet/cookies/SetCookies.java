package servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setCookies")
public class SetCookies extends HttpServlet {
    // Method to handle Get method request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create cookies for user inputs.
        Cookie userName = new Cookie("userName", req.getParameter("userName"));
        Cookie gender = new Cookie("gender", req.getParameter("gender"));
        Cookie marital_status = new Cookie("marital_status", req.getParameter("marital_status"));
        Cookie diabetes = new Cookie("diabetes", req.getParameter("diabetes"));
        Cookie feedback = new Cookie("feedback", req.getParameter("feedback"));

        // Set expiry date after 24 Hrs for both the cookies.
        int expiry = 24 * 60 * 60; // 24 hours in seconds
        userName.setMaxAge(expiry);
        gender.setMaxAge(expiry);
        marital_status.setMaxAge(expiry);
        diabetes.setMaxAge(expiry);
        feedback.setMaxAge(expiry);

        // Add all the cookies in the response header.
        resp.addCookie(userName);
        resp.addCookie(gender);
        resp.addCookie(marital_status);
        resp.addCookie(diabetes);
        resp.addCookie(feedback);

        // Set response content type.
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Set Cookies Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>" +
                "<head><title>" + title + "</title></head>" +
                "<body bgcolor=\"#f0f0f0\">" +
                "<h1 align=\"center\">" + title + "</h1>" +
                "<ul>\n"+
                "<li><b>User Name:</b>\t\n" + req.getParameter("userName") + "</li>\n"+
                "<li><b>Gender:</b>\t\n" + req.getParameter("gender") + "</li>\n"+
                "<li><b>Marital Status:</b>\t\n" + req.getParameter("marital_status") + "</li>\n"+
                "<li><b>Diabetes:</b>\t\n" + req.getParameter("diabetes") + "</li>\n"+
                "<li><b>Feedback:</b>\t\n" + req.getParameter("feedback") + "</li>\n"+
                "</ul>"+
                "</body></html>");
    }
    // Method to handle Post method request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
