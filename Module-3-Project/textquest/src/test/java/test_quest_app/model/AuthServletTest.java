package test_quest_app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test_quest_app.controler.AuthServlet;

public class AuthServletTest {
  @Mock private HttpServletRequest requestMock;
  @Mock private HttpServletResponse responseMock;
  @Mock private HttpSession sessionMock;
  private AuthServlet authServlet;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    authServlet = new AuthServlet();
    when(requestMock.getSession(true)).thenReturn(sessionMock);
  }

  @Test
  public void testDoPostCreateNewCookie() throws Exception {
    Cookie[] cookies = {new Cookie("test_cookie_1", "test value")};
    when(requestMock.getCookies()).thenReturn(cookies);
    authServlet.doPost(requestMock, responseMock);
    verify(responseMock)
        .addCookie(
            argThat(
                cookie -> "gameAttempt".equals(cookie.getName()) && "1".equals(cookie.getValue())));
  }

  @Test
  public void testDoPostIncrementCookieValue() throws Exception {
    Cookie cookies = new Cookie("gameAttempt", "42");
    Cookie[] cookiesArray = {
      new Cookie("test_cookie_1", "test value"), cookies, new Cookie("test_cookie_2", "test value")
    };
    when(requestMock.getCookies()).thenReturn(cookiesArray);
    authServlet.doPost(requestMock, responseMock);
    assertEquals("43", cookies.getValue());
  }

  @Test
  public void testDoPostGetOrCreateSession() throws Exception {
    when(requestMock.getCookies()).thenReturn(new Cookie[] {});
    authServlet.doPost(requestMock, responseMock);
    verify(requestMock).getSession(true);
  }

  @Test
  public void testToDoPostSetsSessionAttributeName() throws Exception {
    when(requestMock.getCookies()).thenReturn(new Cookie[] {});
    when(requestMock.getParameter("name")).thenReturn("John");
    authServlet.doPost(requestMock, responseMock);
    verify(sessionMock).setAttribute("name", "John");
  }

  @Test
  public void testDoPostRedirectsToQuest() throws Exception {
    when(requestMock.getCookies()).thenReturn(new Cookie[] {});
    when(requestMock.getContextPath()).thenReturn("test path");
    authServlet.doPost(requestMock, responseMock);
    verify(responseMock).sendRedirect("test path/quest");
  }

  @Test
  public void testDoGetRedirectsToIndex() throws Exception {
    authServlet.doGet(requestMock, responseMock);
    verify(responseMock).sendRedirect("/index.jsp");
  }
}
