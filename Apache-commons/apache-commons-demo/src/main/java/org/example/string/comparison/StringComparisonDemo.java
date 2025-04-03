package org.example.string.comparison;

import org.apache.commons.lang3.StringUtils;

/*
The StringUtils.compare() and StringUtils.compareIgnoreCase() methods from Apache Commons Lang help compare two strings in a way similar to Java’s built-in String.compareTo().
Here’s how they work:
1.compare(str1, str2)
-Compares str1 and str2 in dictionary (lexicographic) order.
-Returns:
  *Negative (-1, -2, etc.) → str1 comes before str2
  *Zero (0) → str1 and str2 are the same
  *Positive (+1, +2, etc.) → str1 comes after str2
2.compare(str1, str2, true)
-Same as compare(), but treats null as the smallest value.
3.compareIgnoreCase(str1, str2)
-Works just like compare(), but ignores uppercase/lowercase differences.
4.compareIgnoreCase(str1, str2, true)
-Same as compareIgnoreCase(), but treats null as the smallest value.
 */
public class StringComparisonDemo {
  public static void main(String[] args) {
    // Sample strings to compare
    String str1 = "apple";
    String str2 = "Banana";
    String str3 = "apple";
    String str4 = null;

    // 1️⃣ Basic comparison (case-sensitive)
    System.out.println(
        "compare(\"apple\", \"Banana\"): "
            + StringUtils.compare(str1, str2)); // Output: positive (apple > Banana)
    System.out.println(
        "compare(\"apple\", \"apple\"): " + StringUtils.compare(str1, str3)); // Output: 0 (same)

    // 2️⃣ Comparison with null handling (nullIsLess = true)
    System.out.println(
        "compare(\"apple\", null, true): "
            + StringUtils.compare(str1, str4, true)); // Output: positive (apple > null)
    System.out.println(
        "compare(null, \"Banana\", true): "
            + StringUtils.compare(str4, str2, true)); // Output: negative (null < Banana)

    // 3️⃣ Case-insensitive comparison
    System.out.println(
        "compareIgnoreCase(\"apple\", \"Banana\"): "
            + StringUtils.compareIgnoreCase(str1, str2)); // Output: positive (apple > banana)
    System.out.println(
        "compareIgnoreCase(\"apple\", \"APPLE\"): "
            + StringUtils.compareIgnoreCase(str1, str3)); // Output: 0 (same)

    // 4️⃣ Case-insensitive comparison with null handling
    System.out.println(
        "compareIgnoreCase(null, \"Banana\", true): "
            + StringUtils.compareIgnoreCase(str4, str2, true)); // Output: negative (null < banana)
  }
}
