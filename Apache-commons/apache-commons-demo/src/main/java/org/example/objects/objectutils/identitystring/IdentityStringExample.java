package org.example.objects.objectutils.identitystring;

import org.apache.commons.lang3.ObjectUtils;

public class IdentityStringExample {
  public static void main(String[] args) {
    String sample = "Example";

    // Generate an identity string (memory address representation)
    String identity = ObjectUtils.identityToString(sample);
    System.out.println("Identity string: " + identity); // Example output: java.lang.String@7f31245a
  }
}
/*
Object Identity String
This method helps generate a unique identity string for an object.
 */
