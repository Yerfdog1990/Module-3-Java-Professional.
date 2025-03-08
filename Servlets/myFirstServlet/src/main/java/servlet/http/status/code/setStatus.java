package servlet.http.status.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setStatus")
public class setStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set custom status code (example: 202 - Accepted)
        setStatus(resp, 202);

        // Send response content after setting status
        resp.setContentType("text/plain");
        resp.getWriter().write("Status code 202 has been set.");
    }

    private void setStatus(HttpServletResponse response, int statusCode) {
        response.setStatus(statusCode);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
