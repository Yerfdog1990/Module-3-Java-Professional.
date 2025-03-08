package servlet.pass.data.to.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/readAllParameters")
public class ReadAllParameters extends HttpServlet {

    // Method to handle GET method request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Read All Parameters Using Enumeration";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        resp.setContentType("text/html");
        out.println(docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                        "<tr bgcolor = \"#949494\">\n" +
                        "<th>Param Name</th>"+
                "<th>Param Value(s)</th>\n"+
                        "</tr>\n"
        );

        // Logic to read all parameters
        Enumeration paraNames = req.getParameterNames();
        while (paraNames.hasMoreElements()){
            String paraName = (String) paraNames.nextElement();
            out.println("<tr><td>" +paraName+ "</td>\n<td>");
            String[] paraValues = req.getParameterValues(paraName);

            // Read single valued data
            if (paraValues.length == 1){
                String paraValue = paraValues[0];
                if(paraValue.length() == 0)
                    out.println("<i>No Value</i>");
                 else
                    out.println(paraValue);
            }else{
                // Read multiple valued data
                out.println("<ul>");
                for (int i = 0; i < paraValues.length; i++) {
                    out.println("<li>"+paraValues[i]+"</li>");
                }
                out.println("</ul>");
            }
        }
        out.println("</tr></table>\n</body>\n</html>");
    }

    // Method to handle Post method request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
