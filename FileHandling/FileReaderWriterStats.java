import java.io.*;
import java.util.Scanner;

public class FileReaderWriterStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "user_text.txt";

        // Write user message to file
        try {
            System.out.print("Enter a message to write to the file: ");
            String userMessage = scanner.nextLine();

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(userMessage.getBytes());
            fos.close();
            System.out.println("Message written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Read the same file and count characters and words
        int charCount = 0;
        int wordCount = 0;
        StringBuilder content = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            int i;

            while ((i = fis.read()) != -1) {
                charCount++;
                content.append((char) i);
            }

            fis.close();

            // Split by whitespace to count words
            String[] words = content.toString().trim().split("\\s+");
            if (content.toString().trim().length() > 0) {
                wordCount = words.length;
            }

            System.out.println("\n===== File Stats =====");
            System.out.println("Content: " + content.toString());
            System.out.println("Total characters: " + charCount);
            System.out.println("Total words: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}

