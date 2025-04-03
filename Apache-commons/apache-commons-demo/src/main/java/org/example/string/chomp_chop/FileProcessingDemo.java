package org.example.string.chomp_chop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class FileProcessingDemo {
  public static void main(String[] args) {
    // Use relative paths instead of absolute paths
    String sampleFilePath = "src/main/resources/sampleFile.txt";
    String cleanedFilePath = "src/main/resources/cleaned_sample.txt";

    // Step 1: Create and save a sample file if it does not exist
    File sampleFile = new File(sampleFilePath);
    if (!sampleFile.exists()) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(sampleFile))) {
        writer.write(
            "Hello, World!\n"
                + "Java Programming!\n"
                + "Welcome to Apache Commons!\n"
                + "LastLine.");
        System.out.println("Sample file created at: " + sampleFile.getAbsolutePath());
      } catch (IOException e) {
        System.err.println("Error creating sample file: " + e.getMessage());
        return;
      }
    } else {
      System.out.println("Sample file already exists at: " + sampleFile.getAbsolutePath());
    }

    // Step 2: Read the file and process each line
    List<String> cleanedLines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(sampleFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Remove trailing newline characters safely
        String cleanedLine = StringUtils.chomp(line);

        // Remove punctuation marks (e.g., '.' or '!')
        if (cleanedLine.endsWith("!") || cleanedLine.endsWith(".")) {
          cleanedLine = StringUtils.chop(cleanedLine);
        }

        cleanedLines.add(cleanedLine);
      }
    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
      return;
    }

    // Step 3: Write cleaned content to a new file
    File cleanedFile = new File(cleanedFilePath);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(cleanedFile))) {
      for (String cleanedLine : cleanedLines) {
        writer.write(cleanedLine);
        writer.newLine(); // Preserve the structure
      }
      System.out.println("Cleaned file saved at: " + cleanedFile.getAbsolutePath());
    } catch (IOException e) {
      System.err.println("Error writing cleaned file: " + e.getMessage());
    }
  }
}
