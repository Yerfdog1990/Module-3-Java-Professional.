package servlet_01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class FirstHttpServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstHttpServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("Processing GET request to /hello endpoint");
        
        try {
            // Getting the parameter "hello" from request
            String hello = req.getParameter("hello");
            logger.debug("Retrieved parameter 'hello' with value: {}", hello);

            // Put parameter "hello" into Http-session
            HttpSession session = req.getSession(true);
            session.setAttribute("hello", hello);
            logger.debug("Stored 'hello' parameter in session");

            // Print HTML as a response for browser
            resp.setContentType("text/html;charset=utf-8");
            try (PrintWriter printWriter = resp.getWriter()) {
                printWriter.println(
                        "<html>" +
                                "<head>" +
                                "<title>Servlet-01</title>" +
                                "</head>" +
                                "<body>" +
                                "<h1>Hello from FirstHttpServlet!</h1>" +
                                "<p>Parameter 'hello' value: " + (hello != null ? hello : "not provided") + "</p>" +
                                "</body>" +
                                "</html>"
                );
            }
        } catch (Exception e) {
            logger.error("Error processing request: {}", e.getMessage(), e);
            if (!resp.isCommitted()) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                             "An error occurred while processing your request. Please try again later.");
            }
        }
    }
}
