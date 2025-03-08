package servlet.form.data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/get_method_url")
public class GET_method_url extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "GET Method Example using URL";
        PrintWriter out = resp.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
                out.println(docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n"+
                        "<h1>"+title+"</h1>\n"+
                        "<ul>\n"+
                        "<li>\n"+
                        "<b>First name:</b>\t\n" + req.getParameter("firstName") +
                        "</li>\n"+
                        "<li>\n"+
                        "<b>Last name:</b>\t\n" + req.getParameter("lastName") +
                        "</li>\n"+
                        "</ul>\n"+
                        "</body>\n"+
                        "</html>\n"
                );
    }
}
