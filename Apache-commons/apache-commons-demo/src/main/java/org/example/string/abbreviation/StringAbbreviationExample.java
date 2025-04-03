package org.example.string.abbreviation;

import org.apache.commons.lang3.StringUtils;

/*
Understanding abbreviate in StringUtils (Apache Commons Lang3)
The StringUtils.abbreviate methods from Apache Commons Lang3 allow truncating long strings while keeping them readable.
They use ellipses ("...") or a custom marker to indicate omitted characters.
 */
public class StringAbbreviationExample {
  public static void main(String[] args) {
    String text = "Apache Commons Lang provides useful utilities for Java.";

    // 1. Abbreviate to 20 characters (default marker: "...")
    String result1 = StringUtils.abbreviate(text, 20);
    System.out.println("Abbreviate (default): " + result1);
    // Output: "Apache Commons L..."

    // 2. Abbreviate from offset 8 (default marker: "...")
    String result2 = StringUtils.abbreviate(text, 8, 20);
    System.out.println("Abbreviate (offset 8): " + result2);
    // Output: "…ommons Lang pro..."

    // 3. Abbreviate with a custom marker ("***")
    String result3 = StringUtils.abbreviate(text, "***", 20);
    System.out.println("Abbreviate (custom marker): " + result3);
    // Output: "Apache Commons L***"

    // 4. Abbreviate with custom marker and offset
    String result4 = StringUtils.abbreviate(text, "***", 8, 25);
    System.out.println("Abbreviate (custom marker, offset 8): " + result4);
    // Output: "…ommons Lang provides ***"

    // 5. Abbreviate middle, keeping first and last parts
    String result5 = StringUtils.abbreviateMiddle(text, "...", 25);
    System.out.println("Abbreviate Middle: " + result5);
    // Output: "Apache Co...for Java."
  }
}
