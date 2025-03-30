import static org.junit.jupiter.api.Assertions.*;

import org.example.equalshashcodes.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {
  @Test
  @DisplayName("Test main method")
  public void testMain() {
    Person p1 = new Person("John", 20);
    Person p2 = new Person("John", 20);
    Person p3 = new Person("John", 20);

    // Rules of equals()
    // Reflexive: x.equals(x) should return true.
    assertTrue(p1.equals(p1));
    assertTrue(p2.equals(p2));
    assertTrue(p3.equals(p3));
    assertTrue(p1.hashCode() == p1.hashCode());
    assertTrue(p2.hashCode() == p2.hashCode());
    assertTrue(p3.hashCode() == p3.hashCode());
    assertTrue(p1.name.hashCode() == p1.name.hashCode());
    assertTrue(p2.name.hashCode() == p2.name.hashCode());
    assertTrue(p3.name.hashCode() == p3.name.hashCode());

    // Symmetric: If x.equals(y), then y.equals(x).
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p1));
    assertTrue(p3.equals(p2));
    assertTrue(p2.equals(p3));
    assertTrue(p1.hashCode() == p2.hashCode());
    assertTrue(p2.hashCode() == p1.hashCode());
    assertTrue(p3.hashCode() == p2.hashCode());
    assertTrue(p2.hashCode() == p3.hashCode());
    assertTrue(p1.name.equals(p2.name));
    assertTrue(p2.name.equals(p1.name));
    assertTrue(p3.name.equals(p2.name));
    assertTrue(p1.name.hashCode() == p2.name.hashCode());
    assertTrue(p2.name.hashCode() == p1.name.hashCode());
    assertTrue(p3.name.hashCode() == p2.name.hashCode());
    assertTrue(p1.name.hashCode() == p3.name.hashCode());

    // Transitive: If x.equals(y) and y.equals(z), then x.equals(z).
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p3));
    assertTrue(p1.equals(p3));
    // Consistent: Multiple calls should return the same result if the object state does not change.
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p1));
    assertTrue(p3.equals(p2));
    assertTrue(p2.equals(p3));
    // Null Handling: x.equals(null) should return false.
    assertFalse(p1.equals(null));
    assertFalse(p2.equals(null));
    assertFalse(p3.equals(null));
  }
}
