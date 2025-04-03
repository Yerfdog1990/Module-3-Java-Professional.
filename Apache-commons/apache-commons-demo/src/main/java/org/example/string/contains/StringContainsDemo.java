package org.example.string.contains;

/*
Explanation of Methods
1️⃣ Checking If a String Contains Certain Characters
1.contains(seq, searchSeq) → Checks if a string contains another string.
2.contains(seq, searchChar) → Checks if a string contains a specific character.
3.containsAny(cs, searchChars...) → Checks if a string contains any character from a given set.
4.containsAnyIgnoreCase(cs, searchCharSequences...) → Case-insensitive version of containsAny().
5.containsIgnoreCase(str, searchStr) → Case-insensitive version of contains().
6.containsNone(cs, searchChars...) → Checks if a string does not contain any of the given characters.
7.containsOnly(cs, validChars...) → Checks if a string only contains certain characters.
8.containsWhitespace(seq) → Checks if a string contains any whitespace.
 */

import org.apache.commons.lang3.StringUtils;

public class StringContainsDemo {
  public static void main(String[] args) {
    String str = "Hello World!";

    // 1️⃣ Checking if a string contains another string
    System.out.println(
        "contains(\"Hello World!\", \"World\"): " + StringUtils.contains(str, "World")); // ✅ true

    // 2️⃣ Checking if a string contains a specific character
    System.out.println(
        "contains(\"Hello World!\", 'W'): " + StringUtils.contains(str, 'W')); // ✅ true

    // 3️⃣ Checking if a string contains any of the given characters
    System.out.println(
        "containsAny(\"Hello World!\", 'x', 'o', 'z'): "
            + StringUtils.containsAny(str, 'x', 'o', 'z')); // ✅ true ('o' is present)

    // 4️⃣ Case-insensitive contains check
    System.out.println(
        "containsIgnoreCase(\"Hello World!\", \"hello\"): "
            + StringUtils.containsIgnoreCase(str, "hello")); // ✅ true

    // 5️⃣ Checking if a string does NOT contain certain characters
    System.out.println(
        "containsNone(\"Hello World!\", 'x', 'y', 'z'): "
            + StringUtils.containsNone(str, 'x', 'y', 'z')); // ✅ true (None of them exist)

    // 6️⃣ Checking if a string contains only certain characters
    System.out.println(
        "containsOnly(\"12345\", \"0123456789\"): "
            + StringUtils.containsOnly("12345", "0123456789")); // ✅ true (only digits)

    // 7️⃣ Checking if a string contains whitespace
    System.out.println(
        "containsWhitespace(\"Hello World!\"): "
            + StringUtils.containsWhitespace(str)); // ✅ true (contains space)
  }
}
