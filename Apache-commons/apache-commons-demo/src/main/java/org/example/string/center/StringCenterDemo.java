package org.example.string.center;

/*
Understanding center in StringUtils (Apache Commons Lang3)
The StringUtils.center method is used to center-align a string within a given width.
If the string is shorter than the specified size, it is padded with spaces (by default) or with a specified character or string.
 */
import org.apache.commons.lang3.StringUtils;

public class StringCenterDemo {
  public static void main(String[] args) {
    String text = "Java";

    // 1. Centering with default spaces
    String centeredWithSpaces = StringUtils.center(text, 10);
    System.out.println("Centered with spaces: '" + centeredWithSpaces + "'");
    // Output: "   Java   " (padded with spaces)

    // 2. Centering with a custom character ('*')
    String centeredWithChar = StringUtils.center(text, 10, '*');
    System.out.println("Centered with '*': '" + centeredWithChar + "'");
    // Output: "***Java***" (padded with '*')

    // 3. Centering with a custom string ("-=")
    String centeredWithString = StringUtils.center(text, 12, "-=");
    System.out.println("Centered with '-=': '" + centeredWithString + "'");
    // Output: "-=Java=-=-" (padded with "-=")

    // 4. Centering a string longer than the specified size (no change)
    String longerText = "Programming";
    String result = StringUtils.center(longerText, 5);
    System.out.println("Centering longer text: '" + result + "'");
    // Output: "Programming" (unchanged)

    // 5. Handling null input (returns null safely)
    String resultNull = StringUtils.center(null, 10);
    System.out.println("Centering null: " + resultNull);
    // Output: null
  }
}
