package com.tictactoe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int index = getSelectedIndex(req);
    resp.sendRedirect("/index.jsp");
  }

  private int getSelectedIndex(HttpServletRequest request) {
    String click = request.getParameter("click");
    if (click == null || click.isEmpty()) {
      return 0; // Default value
    }
    boolean isNumeric = click.chars().allMatch(Character::isDigit);
    return isNumeric ? Integer.parseInt(click) : 0;
  }
}
