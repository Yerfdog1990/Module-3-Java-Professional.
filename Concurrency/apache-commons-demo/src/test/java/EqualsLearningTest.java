import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EqualsLearningTest {

  @Test
  @DisplayName("Compare String Reference")
  public void compareStringReference() {
    String s1 = "Hello";
    String s2 = "Hello";
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    assertTrue(s1 == s2);
    assertTrue(s1.equals(s2));
    assertEquals(s1, s2);
    assertSame(s1, s2);
  }
}
