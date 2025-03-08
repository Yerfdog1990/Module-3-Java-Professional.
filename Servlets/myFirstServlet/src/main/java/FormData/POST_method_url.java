package FormData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post_method_url")
public class POST_method_url extends HttpServlet {

    // Method to handle GET method request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String title = "POST Method Example using URL";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        PrintWriter out = resp.getWriter();
        out.println(docType+
                "<html>"+
                "<head><title>"+title+"</title></head>"+
                "<body bgcolor=\"#f0f0f0\">"+
                "<h1 align=\"center\">"+title+"</h1>"+
                "<ul>"+
                "<li><b>First name:</b>\t\n" + req.getParameter("firstName") + "</li>\n"+
                "<li><b>Last name:</b>\t\n" + req.getParameter("lastName") + "</li>\n"+
                "</ul>"+
                "</body>"+
                "</html"
        );
    }
    // Method to handle POST method request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
