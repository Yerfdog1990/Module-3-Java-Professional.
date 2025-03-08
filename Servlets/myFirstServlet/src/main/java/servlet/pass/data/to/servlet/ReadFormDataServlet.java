package servlet.pass.data.to.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readFormData")
public class ReadFormDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Reading Form Data";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body style=\"background-color: #f0f0f0;\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n");

        // Reading text input
        String username = request.getParameter("username");
        out.println("<li><b>Name:</b> " + (username != null ? username : "Not provided") + "</li>\n\n");

        // Reading radio button (gender)
        String gender = request.getParameter("gender");
        out.println("<li><b>Gender:</b> " + (gender != null ? gender : "Not selected") + "</li>\n\n");

        // Reading radio button (marital status)
        String maritalStatus = request.getParameter("marital_status");
        out.println("<li><b>Marital Status:</b> " + (maritalStatus != null ? maritalStatus : "Not selected") + "</li>\n\n");

        // Reading radio button (diabetes history)
        String diabetes = request.getParameter("diabetes");
        out.println("<li><b>Diabetes History:</b> " + (diabetes != null ? diabetes : "Not provided") + "</li>\n\n");

        // Reading textarea (feedback)
        String feedback = request.getParameter("feedback");
        out.println("<li><b>Feedback:</b> " + (feedback != null ? feedback : "No feedback given") + "</li>\n\n");

        out.println("</ul>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
