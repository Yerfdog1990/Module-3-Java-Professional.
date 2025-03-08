package servlet.exceptions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error")
public class ErrorHandler extends HttpServlet {
    // Method to handle GET method request.
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        // Analyze the servlet exception
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if(servletName == null){
            servletName = "Unknown servlet";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if(requestUri == null){
            requestUri = "Unknown request URI";
        }

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Error Handler Servlet Example";
        String docType =  "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        out.println(docType+ "<html>\n"+
                "<head><title>"+title+"</title></head>\n"+
                "<body color = \"#f0f0f0\">\n");
        if(throwable == null && statusCode == null){
            out.println("<h2>No exception or status code provided</h2>\n");
            out.println("Please return to the <a href=\"" + response.encodeURL("http://localhost:8080/") +"\">Home Page</a>.");
        } else if (statusCode != null) {
            out.println("The status code : " + statusCode);
        } else {
            out.println("<h2>Error information</h2>");
            out.println("Servlet Name : " + servletName + "</br></br>");
            out.println("Exception Type : " + throwable.getClass( ).getName( ) + "</br></br>");
            out.println("The request URI: " + requestUri + "<br><br>");
            out.println("The exception message: " + throwable.getMessage( ));
        }
        out.println("</body>");
        out.println("</html>");
    }
    // Method to handle POST method request
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
