package org.example.string.chomp_chop;

/*
Understanding chomp and chop in StringUtils (Apache Commons Lang3)
The chomp and chop methods in StringUtils are used for removing unwanted characters from the end of a string.
 */
import org.apache.commons.lang3.StringUtils;

public class StringChompChopDemo {
  public static void main(String[] args) {
    // Original strings
    String textWithNewline = "Hello, World!\n";
    String textWithCRLF = "Hello, World!\r\n";
    String normalText = "Hello, World!";
    String singleCharText = "A";
    String emptyText = "";

    // 1. Using chomp() to remove a newline (if present)
    System.out.println("Before chomp: '" + textWithNewline + "'");
    System.out.println("After chomp:  '" + StringUtils.chomp(textWithNewline) + "'");
    // Output: "Hello, World!" (newline removed)

    // 2. Chomp with different newline types (handles \n, \r\n, \r)
    System.out.println("Chomp CRLF: '" + StringUtils.chomp(textWithCRLF) + "'");
    // Output: "Hello, World!" (removes \r\n)

    // 3. Chomp with no newline (unchanged)
    System.out.println("Chomp without newline: '" + StringUtils.chomp(normalText) + "'");
    // Output: "Hello, World!" (unchanged)

    // 4. Chomp an empty string (remains empty)
    System.out.println("Chomp empty string: '" + StringUtils.chomp(emptyText) + "'");
    // Output: "" (unchanged)

    // 5. Using chop() to remove the last character
    System.out.println("Before chop: '" + normalText + "'");
    System.out.println("After chop:  '" + StringUtils.chop(normalText) + "'");
    // Output: "Hello, World" (last character removed)

    // 6. Chop removes newline as well
    System.out.println("Chop with newline: '" + StringUtils.chop(textWithNewline) + "'");
    // Output: "Hello, World" (removes '\n')

    // 7. Chop on a single-character string (returns empty)
    System.out.println("Chop single character: '" + StringUtils.chop(singleCharText) + "'");
    // Output: "" (empty)

    // 8. Chop on an empty string (remains empty)
    System.out.println("Chop empty string: '" + StringUtils.chop(emptyText) + "'");
    // Output: "" (unchanged)
  }
}
