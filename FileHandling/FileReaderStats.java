import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderStats {
    public static void main(String[] args) {
        String inputFile = "sample.txt";            // Input file path
        String outputFile = "output_stats.txt";     // Output file path

        int charCount = 0;
        int wordCount = 0;
        StringBuilder content = new StringBuilder();

        try {
            // Reading from the file
            FileInputStream fis = new FileInputStream(inputFile);
            int i;
            while ((i = fis.read()) != -1) {
                charCount++;
                content.append((char) i);
            }
            fis.close();

            // Counting words
            String[] words = content.toString().trim().split("\\s+");
            if (content.toString().trim().length() > 0) {
                wordCount = words.length;
            }

            // Prepare result
            String result = "Total characters: " + charCount + "\nTotal words: " + wordCount;

            // Display on console
            System.out.println(result);

            // Write result to output file
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(result.getBytes());
            fos.close();

            System.out.println("Results written to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
