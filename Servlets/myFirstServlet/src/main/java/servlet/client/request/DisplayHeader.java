package servlet.client.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/displayHeader")
public class DisplayHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "HTTP Header Request Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>" +
                "<head><title>" + title + "</title></head>" +
                "<body bgcolor=\"#f0f0f0\">" +
                "<h1 align=\"center\">" + title + "</h1>" +
                "<table  width=\"100\" border=\"1\" align=\"center\">" +
                "<tr><th>Header Name</th><th>Header Value</th></tr>\n"
        );

        // Logic to read the HTTP header information
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println("<tr bgcolor = \"#949494\"><td>" + headerName + "</td>\n");
            String headerValue = req.getHeader(headerName);
            out.println("<td>" + headerValue + "</td></tr>\n");
        }
        out.println("</table>" +
                "</body>" +
                "</html>\n"
        );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
