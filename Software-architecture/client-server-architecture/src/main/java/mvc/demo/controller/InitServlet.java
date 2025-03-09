package mvc.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import mvc.demo.model.ContextFactory;
import mvc.demo.model.ServiceLocator;

@WebServlet(value = "/nopath", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
  @Override
  public void init() throws ServletException {
    ServiceLocator.register("chefService", ContextFactory.getChefService());
    System.out.println("InitServlet initialized");
  }
}
