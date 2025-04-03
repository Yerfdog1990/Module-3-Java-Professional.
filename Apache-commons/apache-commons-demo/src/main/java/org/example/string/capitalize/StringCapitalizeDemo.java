package org.example.string.capitalize;

import org.apache.commons.lang3.StringUtils;

/*
Understanding capitalize in StringUtils (Apache Commons Lang3)
The StringUtils.capitalize method helps convert the first character of a string to title case, while keeping the rest of the string unchanged.
 */
public class StringCapitalizeDemo {
  public static void main(String[] args) {
    String text1 = "hello world";
    String text2 = "java programming";
    String text3 = "123abc"; // Starts with a digit
    String text4 = ""; // Empty string
    String text5 = null; // Null string

    // 1. Capitalizing a lowercase word
    String result1 = StringUtils.capitalize(text1);
    System.out.println("Capitalize 'hello world': " + result1);
    // Output: "Hello world"

    // 2. Capitalizing another phrase
    String result2 = StringUtils.capitalize(text2);
    System.out.println("Capitalize 'java programming': " + result2);
    // Output: "Java programming"

    // 3. Capitalizing a string that starts with a number (no change)
    String result3 = StringUtils.capitalize(text3);
    System.out.println("Capitalize '123abc': " + result3);
    // Output: "123abc" (unchanged)

    // 4. Handling an empty string
    String result4 = StringUtils.capitalize(text4);
    System.out.println("Capitalize empty string: '" + result4 + "'");
    // Output: "" (unchanged)

    // 5. Handling null (returns null safely)
    String result5 = StringUtils.capitalize(text5);
    System.out.println("Capitalize null: " + result5);
    // Output: null
  }
}
