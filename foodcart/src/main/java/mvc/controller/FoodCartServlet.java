package mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/foodcart")
public class FoodCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the data from database (model)
        String[] foodItems = {"Omena", "Maize", "Rice"};
        req.setAttribute("foodItems", foodItems);

        // Redirect to a different page (view)
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/FoodCart.jsp");
        dispatcher.forward(req, resp);
    }
}
