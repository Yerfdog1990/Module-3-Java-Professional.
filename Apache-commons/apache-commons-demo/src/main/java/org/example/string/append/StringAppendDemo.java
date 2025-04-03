package org.example.string.append;

import org.apache.commons.lang3.StringUtils;

/*
Understanding appendIfMissing in StringUtils (Apache Commons Lang3)
The StringUtils.appendIfMissing methods help ensure that a string ends with a specified suffix.
If it already ends with the given suffix (or one from a set), it remains unchanged.
 */

public class StringAppendDemo {
  public static void main(String[] args) {
    String filename = "report";
    String url = "https://example.com/home";

    // 1. Append ".txt" if it's missing
    String result1 = StringUtils.appendIfMissing(filename, ".txt");
    System.out.println("Append if missing (.txt): " + result1);
    // Output: "report.txt"

    // 2. Append ".txt" if missing, but not if ".txt" or ".log" already exists
    String result2 = StringUtils.appendIfMissing("logfile.log", ".txt", ".txt", ".log");
    System.out.println("Append if missing (logfile.log): " + result2);
    // Output: "logfile.log" (unchanged)

    // 3. Append "/" to URL if it's missing
    String result3 = StringUtils.appendIfMissing(url, "/");
    System.out.println("Append if missing (/ to URL): " + result3);
    // Output: "https://example.com/home/" (adds trailing slash)

    // 4. Case-insensitive check for suffix (ignores case)
    String result4 = StringUtils.appendIfMissingIgnoreCase("image.JPG", ".jpg", ".png");
    System.out.println("Append if missing ignore case (image.JPG): " + result4);
    // Output: "image.JPG" (unchanged, because ".JPG" matches case-insensitively)

    // 5. Case-insensitive check, appends ".jpg" if missing
    String result5 = StringUtils.appendIfMissingIgnoreCase("photo", ".jpg", ".png");
    System.out.println("Append if missing ignore case (photo): " + result5);
    // Output: "photo.jpg"
  }
}
