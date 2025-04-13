package test_quest_app.controler;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import test_quest_app.model.Answer;
import test_quest_app.model.Question;
import test_quest_app.model.Repository;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {
  private final Repository repository = new Repository();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String answerId = req.getParameter("answerId");
    Question question;
    if (answerId != null) {
      question = repository.getAnswerById(Integer.parseInt(answerId)).getTo();
    } else {
      question = repository.getQuestionById(1);
    }
    Collection<Answer> answers = repository.getAnswers(question.getId());
    req.setAttribute("question", question);
    req.setAttribute("answers", answers);
    addStatistics(req);
    req.getRequestDispatcher("/quest.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

  private void addStatistics(HttpServletRequest req) {
    req.setAttribute("ip", req.getRemoteAddr());
    HttpSession session = req.getSession();
    req.setAttribute("name", session.getAttribute("name"));

    Cookie[] cookies = req.getCookies();
    req.setAttribute("userName", findCookiesValueByName("gameAttempt", cookies));
  }

  private String findCookiesValueByName(String name, Cookie[] cookies) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(name)) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
