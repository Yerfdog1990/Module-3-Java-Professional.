package mvc.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.demo.model.ServiceLocator;
import mvc.demo.model.service.ChefService;
import mvc.demo.model.service.Menu;

@WebServlet("/command")
public class CommandServlet extends HttpServlet {
  private ChefService chefService;

  @Override
  public void init() throws ServletException {
    chefService = (ChefService) ServiceLocator.getService("chefService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Interpreting the input from the view (user)
    String command = req.getParameter("command");
    List<String> commandElements = Arrays.stream(command.split(",")).map(String::trim).toList();

    // Invoking the business logic in the model layer
    Menu menu = chefService.prepareMenu(commandElements);

    // Translate the result from the model layer to something the view can understand and present to
    // the user
    req.setAttribute("items", serveDish(menu));
    req.getRequestDispatcher("/index.jsp").forward(req, resp);
  }

  private List<Dish> serveDish(Menu menu) {
    return menu.getItems().stream().map(Dish::new).toList();
  }
}
