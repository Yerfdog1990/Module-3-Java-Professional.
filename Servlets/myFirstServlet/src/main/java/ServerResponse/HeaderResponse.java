package ServerResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/header_response")
public class HeaderResponse extends HttpServlet {

    // Method to handle GET method request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set refresh, autoload time as 5 seconds
        resp.setIntHeader("Refresh", 3);

        // Set response content type
        resp.setContentType("text/html");

        // Get current time
        Calendar cal = new GregorianCalendar();
        String am_pm;
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        if (hour > 12) {
            am_pm = "PM";
            hour = hour - 12;
        } else {
            am_pm = "AM";
        }
        String currentTime = hour + ":" + minute + ":" + second + " " + am_pm;

        PrintWriter out = resp.getWriter();
        String title = "Auto Refresh Header Setting";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p align=\"center\">Current Time: " + currentTime + "</p>\n" +
                "</body></html>\n"
        );
    }
    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
