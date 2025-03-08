package servlet.form.data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get_method_form")
public class GET_method_form extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "GET Method Example Using Form";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        resp.setContentType("text/html");
        resp.getWriter().println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title>" + "</head>\n" +
                "<body color=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
               "<form action=\"/myFirstServlet/get_method_form\" method=\"get\">\n" +
                "    <label for=\"username\">Name:</label>\n" +
                "    <input type=\"text\" id=\"username\" name=\"username\"><br><br>\n" +
                "\n" +
                "    <label>Gender:</label>\n" +
                "    <input type=\"radio\" name=\"gender\" value=\"male\"> Male\n" +
                "    <input type=\"radio\" name=\"gender\" value=\"female\"> Female<br><br><br>\n" +
                "\n" +
                "    <label>Marital Status:</label><br>\n" +
                "    <input type=\"radio\" name=\"marital_status\" value=\"single\"> Single<br>\n" +
                "    <input type=\"radio\" name=\"marital_status\" value=\"married\"> Married<br>\n" +
                "    <input type=\"radio\" name=\"marital_status\" value=\"widow\"> Widow<br>\n" +
                "    <input type=\"radio\" name=\"marital_status\" value=\"prefer_not_to_say\"> Prefer not to say<br><br><br>\n" +
                "\n" +
                "    <label>Do you have a medical history of diabetes?</label><br>\n" +
                "    <input type=\"radio\" name=\"diabetes\" value=\"yes\"> Yes<br>\n" +
                "    <input type=\"radio\" name=\"diabetes\" value=\"no\"> No<br><br><br>\n" +
                "\n" +
                "    <label for=\"feedback\">Your Feedback:</label><br>\n" +
                "    <textarea id=\"feedback\" name=\"feedback\" rows=\"4\" cols=\"50\"></textarea><br><br><br>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Submit\">"+
                "  </form>\n" +
                "  <br><br><br>\n"+
                "</body>\n" +
                "</html>");
    }
}
