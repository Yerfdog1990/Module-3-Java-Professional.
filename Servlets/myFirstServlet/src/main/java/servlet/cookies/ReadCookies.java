package servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/readCookies")
public class ReadCookies extends HttpServlet {

    // Method to handle Get method request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = null;
        Cookie cookie = null;
        // Get an array of Cookies associated with this domain
        cookies = req.getCookies();

        // Set response content type
        PrintWriter out = resp.getWriter();
        String title = "Reading Cookies Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" );
        if(cookies != null ) {
            out.println("<h2> Found Cookies Name and Value</h2>");

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print("Name : " + cookie.getName( ) + ",  ");
                out.print("Value: " + cookie.getValue( ) + " <br/>");
            }
        } else {
            out.println("<h2>No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
