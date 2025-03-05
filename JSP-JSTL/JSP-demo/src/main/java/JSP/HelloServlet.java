package JSP;

import JavaBean.Person;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/JSP"})
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("time", new Date());

    Person person = new Person();
    person.setName("Tom");
    person.setAge(20);
    person.setGender("Male");
    person.setAddress("Beijing");
    person.setEmail("<EMAIL>");
    person.setPhone("13800138000");
    req.setAttribute("person", person);
    req.getRequestDispatcher("index.jsp").forward(req, resp);
  }
}
