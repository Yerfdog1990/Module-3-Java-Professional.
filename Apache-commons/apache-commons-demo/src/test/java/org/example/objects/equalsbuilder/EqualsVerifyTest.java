package org.example.objects.equalsbuilder;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class EqualsVerifyTest {
  @Test
  public void testEquals() {
    EqualsVerifier.simple().forClass(Car.class).verify();
    System.out.println("Car.equals() works as expected.");
    EqualsVerifier.simple().forClass(Mazda.class).verify();
    System.out.println("Mazda.equals() works as expected.");
  }
}
